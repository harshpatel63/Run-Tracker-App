package com.example.runtrackerapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.runtrackerapp.R
import com.example.runtrackerapp.databinding.ActivityMainBinding
import com.example.runtrackerapp.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToTrackingFragmentIfNeeded(intent)

        binding.apply {
            setSupportActionBar(toolbar)
            bottomNavigationView.setupWithNavController(findNavController(R.id.navHostFragment))

            bottomNavigationView.setOnNavigationItemReselectedListener {  }

            findNavController(R.id.navHostFragment).addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent){
        if(intent?.action == ACTION_SHOW_TRACKING_FRAGMENT){
            findNavController(R.id.navHostFragment).navigate(R.id.actionGlobalTrackingFragment)
        }
    }
}