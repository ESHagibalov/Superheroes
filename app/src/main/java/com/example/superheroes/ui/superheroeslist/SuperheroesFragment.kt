package com.example.superheroes.ui.superheroeslist

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperheroesBinding


class SuperheroesFragment : Fragment() {

    private val viewModel: SuperheroesViewModel by lazy {
        ViewModelProvider(this).get(
            SuperheroesViewModel::class.java
        )
    }

    private lateinit var binding: FragmentSuperheroesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperheroesBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rvSuperheroes.layoutManager = LinearLayoutManager(context)
        binding.rvSuperheroes.adapter = SuperheroesPreviewAdapter(
            SuperheroesPreviewAdapter.OnClickListener{
               // findNavController().navigate()
            }
        )
        viewModel.getSuperheroes("Batman")
        setObservers(binding)
        return binding.root
    }

    private fun setObservers(binding: FragmentSuperheroesBinding) {
        viewModel.superheroes.observe(viewLifecycleOwner, {
            if(!it.isNullOrEmpty()) {
                (binding.rvSuperheroes.adapter as SuperheroesPreviewAdapter).data = viewModel.superheroes.value!!
            }
        })
    }

}