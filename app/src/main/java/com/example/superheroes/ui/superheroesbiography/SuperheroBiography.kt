package com.example.superheroes.ui.superheroesbiography

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperheroBiographyBinding
import com.example.superheroes.databinding.FragmentSuperheroesBinding
import com.example.superheroes.ui.superheroeslist.SuperheroesPreviewAdapter
import com.example.superheroes.ui.superheroeslist.SuperheroesViewModel

class SuperheroBiography : Fragment() {

//    private val viewModel: SuperheroBiographyViewModel by lazy {
//        ViewModelProvider(this).get(
//            SuperheroBiographyViewModel::class.java
//        )
//    }
    private val viewModel: SuperheroBiographyViewModel by viewModels()


    private lateinit var binding: FragmentSuperheroBiographyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperheroBiographyBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        setObservers(binding)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getSuperhero(1)
    }

    private fun setObservers(binding: FragmentSuperheroBiographyBinding) {
        viewModel.superhero.observe(viewLifecycleOwner, {
            viewModel.getSuperhero(1)
            Log.e("superhero", it.toString())
            binding.ivBiographyCardImage.load(it.image.url)
            binding.tvName.text = it.name
            binding.tvWork.text = it.work.occupation
            binding.tvFullName.text = it.biography.fullName
            binding.tvAliases.text = it.biography.aliases.toString()
            binding.tvRelatives.text = it.connections.relatives
        })
    }

}