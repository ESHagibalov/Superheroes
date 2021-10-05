package com.example.superheroes.ui.superheroeslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroes.databinding.ItemSuperheroBinding
import com.example.superheroes.models.Result

class SuperheroesPreviewAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<SuperheroesPreviewAdapter.ViewHolder>() {

    var data = listOf<Result>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder private constructor(
        val binding: ItemSuperheroBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Result,
            onClickListener: OnClickListener
        ) {
            binding.tvCardName.text = item.name
            binding.tvCardId.text = item.id
            binding.ivCardImage.load(item.image.url)
            binding.clMainLayout.setOnClickListener {
                onClickListener.onClick(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemSuperheroBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (item: Result) -> Unit) {
        fun onClick(item: Result) = clickListener(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!data.isNullOrEmpty()) {
            val item = data[position]

            holder.bind(item, onClickListener)
        }    }

    override fun getItemCount() = data.size
}