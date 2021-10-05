package com.example.superheroes.ui.superheroesbiography

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.superheroes.databinding.FragmentSuperheroBiographyBinding

class SuperheroBiography : Fragment() {

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
        arguments?.getInt("id")?.let { viewModel.getSuperhero(it) }
        setObservers(binding)
        return binding.root
    }


    private fun setObservers(binding: FragmentSuperheroBiographyBinding) {
        viewModel.superhero.observe(viewLifecycleOwner, {
            //  Log.e("saveArgs", args.superheroId.toString())
            binding.ivBiographyCardImage.load(it.image.url)
            binding.tvName.text = it.name
            binding.tvWork.text = it.work.occupation
            binding.tvFullName.text = it.biography.fullName
            it.biography.aliases.forEach { it -> binding.tvAliases.text = it }
            binding.tvRelatives.text = it.connections.relatives
        })
    }

}