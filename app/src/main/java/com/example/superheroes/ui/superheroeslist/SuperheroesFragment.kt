package com.example.superheroes.ui.superheroeslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
        try {
            Class.forName("dalvik.system.CloseGuard")
                .getMethod("setEnabled", Boolean::class.javaPrimitiveType)
                .invoke(null, true)
        } catch (e: ReflectiveOperationException) {
            throw RuntimeException(e)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getSuperheroes("Batman")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperheroesBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rvSuperheroes.layoutManager = LinearLayoutManager(context)
        binding.rvSuperheroes.adapter = SuperheroesPreviewAdapter(
            SuperheroesPreviewAdapter.OnClickListener {
                // findNavController().navigate()
            }
        )

        binding.etSearchByName.addTextChangedListener {
            viewModel.getSuperheroes(binding.etSearchByName.text.toString())
        }
        setObservers(binding)
       Log.e("2 element is", viewModel.superheroes.value!!.first().toString())

        return binding.root
    }

    private fun setObservers(binding: FragmentSuperheroesBinding) {
        viewModel.superheroes.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                (binding.rvSuperheroes.adapter as SuperheroesPreviewAdapter).data =
                    viewModel.superheroes.value!!
                 Log.e("1 element is", viewModel.superheroes.value!!.first().toString())
            }
        })
    }

}