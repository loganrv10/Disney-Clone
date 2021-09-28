package com.example.anushmp.coldstarmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.anushmp.coldstarmovieapp.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

   lateinit var dwlayout : DrawerLayout
   lateinit var ivmenu : ImageView
   lateinit var drawernav: NavigationView

   private var  fragmentHomes = HomeFragment()
    private var fragmentTvShow = TvSeriesFragment()
    private var fragmentDisney = DisneyFragment()
    private var fragmentSports = SportsFragment()
    private var fragmentMovies = MoviesFragment()
   lateinit var navigationBottom : BottomNavigationView


   lateinit var toolbar : androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dwlayout = findViewById(R.id.dwlayout)
        ivmenu = findViewById(R.id.hamburger)
        drawernav = findViewById(R.id.drawernav)
        toolbar = findViewById(R.id.toolbar)
        navigationBottom = findViewById(R.id.navigationBottom)
        setSupportActionBar(toolbar)
        setupBottomNavigationBar(fragmentHomes)
        navigationBottom.setOnNavigationItemSelectedListener {
         when (it.itemId){
           R.id.home -> setupBottomNavigationBar(fragmentHomes)
           R.id.tv -> setupBottomNavigationBar(fragmentTvShow)
           R.id.disney -> setupBottomNavigationBar(fragmentDisney)
           R.id.movies -> setupBottomNavigationBar(fragmentMovies)
           R.id.sports -> setupBottomNavigationBar(fragmentSports)

         }
            true
        }



        var togglee: ActionBarDrawerToggle = ActionBarDrawerToggle(this,dwlayout,
            R.string.nav_open,
            R.string.nav_close
        )

        dwlayout.addDrawerListener(togglee)

        togglee.syncState()

        //dwlayout.openDrawer(drawernav)

        ivmenu.setOnClickListener {

            dwlayout.openDrawer(drawernav)
        }

        //dwlayout.closeDrawer(drawernav)

        //drawernav.visibility = View.INVISIBLE

        //dwlayout.closeDrawer(drawernav)



    }

    private fun setupBottomNavigationBar(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, Fragment())
            commit()
        }

    }


    override fun onBackPressed() {

        if(dwlayout.isDrawerOpen(GravityCompat.START)){
            dwlayout.closeDrawer(drawernav)
        }else {

            super.onBackPressed()

        }
        }




}