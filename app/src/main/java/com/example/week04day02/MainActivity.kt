package com.example.week04day02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        bottomNavClicks()
        chooseFragment(HomeFragment(),"HOME")
    }
   private fun connectViews(){
        bottomNavigationView = findViewById(R.id.bottomNav)
       frameLayout = findViewById(R.id.FrameLayout)
    }
    private fun bottomNavClicks(){
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    chooseFragment(HomeFragment(), "HOME")
                    supportActionBar?.title = "Home"

                }
                R.id.setting -> {

                    chooseFragment(SettingFragment(), "SETTING")
                    supportActionBar?.title = "Setting"
                }

                R.id.user -> {
                    chooseFragment(UserFragment(), "USER")
                    supportActionBar?.title = "User"

                }
            }

            true
        }

    }

    private fun chooseFragment(fragment: Fragment,tag:String){

        val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout,fragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()
    }


}