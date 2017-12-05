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
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.app_bar_history.*
import kotlinx.android.synthetic.main.content_history.*
import model.history.History
import presenter.HistoryPresenter
import presenter.HistoryPresenterImpl
class HistoryActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, HistoryView {

    var presenter:HistoryPresenter?=null
    val header = listOf("word","from","to","translate")
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        clearButton.text="Clear all history"
        ////////////////////////////////////////////////////////////////////////////////////////////////
        clearButton.setOnClickListener {
            deleteAllHistory()
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        presenter = HistoryPresenterImpl()
        presenter!!.attachView(this, applicationContext)
        getHistory()

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.history, menu)
        return true
    }
////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_translater -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
            R.id.nav_history -> {

            }
            R.id.nav_favorites -> {
                startActivity(Intent(applicationContext, FavoritesActivity::class.java))
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun getHistory() {
        presenter!!.getAllHistory()
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun setHistory(list: List<History>) {
        setToTable(list)
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun deleteAllHistory() {
        presenter!!.deleteAllHistory()
        setToTable(listOf<History>())
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    fun setToTable(list:List<History>)
    {
        val resList = mutableListOf<String>()
        resList.addAll(header)
        for (h in list){
            resList.add(h.text)
            resList.add(h.langFrom)
            resList.add(h.langTo)
            resList.add(h.translated)
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resList)
        table.adapter=adapter
    }
}
