package com.example.farmachinchanito

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.farmachinchanito.fragments.HomeFragment
import com.example.farmachinchanito.fragments.NosotrosFragment
import com.example.farmachinchanito.fragments.ProductosFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {


    lateinit var tb: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setup del tulvar
        tb = tulvar as Toolbar

            tb.title= "Farmacia "

        //setup navigationview
        setupnavigation()
        setupfragment(HomeFragment())

        nav.menu.getItem(0).isChecked =true


    }

    private fun setupnavigation() {
        val toogle = ActionBarDrawerToggle(this,drawer,tb,R.string.drawer_abierto,R.string.drawer_cerrado)
        toogle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toogle)
        toogle.syncState()
        nav.setNavigationItemSelectedListener(this)
    }
//innicialiso el contenido de los fragents
    private fun setupfragment(fragment :Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame,fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> setupfragment(HomeFragment())
            R.id.productos -> setupfragment(ProductosFragment())
            R.id.nosotros -> setupfragment(NosotrosFragment())

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}
