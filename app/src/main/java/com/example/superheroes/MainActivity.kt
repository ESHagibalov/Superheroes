package com.example.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
       // setupNavigation(binding)
        setContentView(binding.root)

    }

    private fun setupNavigation(binding: ActivityMainBinding) {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_home) as NavHostFragment?

    }

}