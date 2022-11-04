package com.example.shoestoreinvetoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreinvetoryapp.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.loginFragment,R.id.shoeListFragment)
        )
        setSupportActionBar(binding.myToolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        Timber.plant(Timber.DebugTree())

    }

     // Setup the Activity to handle the navigateUp action
    override fun onSupportNavigateUp(): Boolean {
        navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}