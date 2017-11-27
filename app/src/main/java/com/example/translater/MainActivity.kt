package com.example.translater

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import model.history.History
import presenter.MainPresenter
import presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(),MainView, NavigationView.OnNavigationItemSelectedListener {

    var presenter: MainPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        presenter = MainPresenterImpl()
        presenter!!.attachView(this, applicationContext)
        translateButton.setOnClickListener {
            sendToGetTranslate(inputBox.text.toString(), "en-ru")

//            val key = "trnsl.1.1.20171016T111419Z.fc55cd5c198738d8.3c01307e69f137c8b02570ba469a2dd01d6740b3"
//              utputBox.text =outputBox.text.toString()+ e.message+" error"
//            }

        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_translater -> {
                // Handle the camera action
            }
            R.id.nav_history -> {
                startActivity(Intent(applicationContext, HistoryActivity::class.java))
            }
            R.id.nav_favorites -> {
                startActivity(Intent(applicationContext, FavoritesActivity::class.java))
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun sendToGetTranslate(text: String, lang: String) {
        presenter!!.sendToTranslate(text,lang)
    }

    override fun setTranslated(s: String) {
        outputBox.text = s
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter!!.dettachView()
    }
}
