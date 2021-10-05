package com.example.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        binding.lifecycleOwner = this
       // setupNavigation(binding)
    }

    private fun setupNavigation(binding: ActivityMainBinding) {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_view) as NavHostFragment?

    }

}