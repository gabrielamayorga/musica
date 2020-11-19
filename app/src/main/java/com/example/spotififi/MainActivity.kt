package com.example.spotififi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        /*setSupportActionBar(toolbar)*/

        var drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        var btnToggle = ActionBarDrawerToggle(
           this, findViewById(R.id.drawerLayout), toolbar,
            R.string.abrirdrawer, R.string.fechardrawer
        )
        drawerLayout.addDrawerListener(btnToggle)
        btnToggle.syncState()


        var navController = findNavController(R.id.nav_host_fragment)
        navigationView.setNavigationItemSelectedListener {item ->
            when (item.itemId){

                R.id.itemLista->
                    navController.navigate(R.id.listaMusicaFragment)

                R.id.itemMsc ->
                    navController.navigate(R.id.listaMusicaFragment)

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }

        /*Quando chega na ultima pagina carregada e voltar*/
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}