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
import kotlinx.android.synthetic.main.activity_favorites.*
import kotlinx.android.synthetic.main.app_bar_favorites.*
import model.favorites.Favorites
import presenter.FavoritePresenter
import presenter.FavirotesPresenterImpl


class FavoritesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener ,FavoritesView{
    var presenter: FavoritePresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        presenter = FavirotesPresenterImpl()
        presenter!!.attachView(this, this)
        nav_view.setNavigationItemSelectedListener(this)
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
        menuInflater.inflate(R.menu.favorites, menu)
        return true
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_translater -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
            R.id.nav_history -> {
                startActivity(Intent(applicationContext, HistoryActivity::class.java))
            }
            R.id.nav_favorites -> {

            }


        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun deleteAllFavorites() {
        presenter!!.deleteAllFavorite()
    }

    override fun getAllFavorites() {
        presenter!!.getAllFavorites()
    }

    override fun setFavorites(list: List<Favorites>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
