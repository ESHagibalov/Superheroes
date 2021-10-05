package com.example.superheroes.ui.superheroeslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperheroesBinding


class SuperheroesFragment : Fragment() {

    private val viewModel: SuperheroesViewModel by viewModels()
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperheroesBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rvSuperheroes.layoutManager = LinearLayoutManager(context)
        binding.rvSuperheroes.adapter = SuperheroesPreviewAdapter(
            SuperheroesPreviewAdapter.OnClickListener {
                val bundle = bundleOf("id" to it.id.toInt())
                findNavController().navigate(R.id.action_superheroes_to_biography, bundle)
                Log.e("idLogger", it.id)
            }
        )
        setObservers(binding)
        viewModel.getSuperheroes(" ")
        binding.etSearchByName.addTextChangedListener {
            viewModel.getSuperheroes(binding.etSearchByName.text.toString())
            if (binding.etSearchByName.text.toString() != "") {
                binding.tvLetsStart.visibility = View.GONE
            } else {
                binding.tvLetsStart.visibility = View.VISIBLE

            }
        }

        binding.ivSearch.setOnClickListener {
            viewModel.getSuperheroes(binding.etSearchByName.text.toString())

        }

        return binding.root
    }

    private fun setObservers(binding: FragmentSuperheroesBinding) {
        Log.e("Observing", "observe...")
        //viewModel.getSuperheroes("Batman")
        viewModel.superheroes.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                (binding.rvSuperheroes.adapter as SuperheroesPreviewAdapter).data =
                    viewModel.superheroes.value!!
            } else {
                (binding.rvSuperheroes.adapter as SuperheroesPreviewAdapter).data = emptyList()
            }
        })
    }
}
