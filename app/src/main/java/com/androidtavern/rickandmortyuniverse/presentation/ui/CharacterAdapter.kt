package com.androidtavern.rickandmortyuniverse.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidtavern.rickandmortyuniverse.R
import com.androidtavern.rickandmortyuniverse.databinding.ItemCharacterBinding
import com.androidtavern.rickandmortyuniverse.presentation.model.CharacterUI
import com.androidtavern.rickandmortyuniverse.presentation.utils.loadByUrlWithPlaceholder

class CharacterAdapter : PagingDataAdapter<CharacterUI, CharacterViewHolder>(DiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(inflater, parent, false),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CharacterViewHolder(
    private val binding: ItemCharacterBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CharacterUI?) {
        with(binding) {
            item?.let { character ->
                image.loadByUrlWithPlaceholder(character.image, R.drawable.unknown)
                name.text = character.name
                status.text = character.getCharacterStatus(context)
                imageStatus.setBackgroundColor(
                    ContextCompat.getColor(context, character.getStatusColor())
                )
                from.text = character.getCharacterFrom()
            }
        }
    }
}

private object DiffItemCallback : DiffUtil.ItemCallback<CharacterUI>() {

    override fun areItemsTheSame(oldItem: CharacterUI, newItem: CharacterUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CharacterUI, newItem: CharacterUI): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.name == newItem.name &&
                oldItem.status == newItem.status &&
                oldItem.species == newItem.species &&
                oldItem.type == newItem.type &&
                oldItem.gender == newItem.gender &&
                oldItem.origin == newItem.origin &&
                oldItem.image == newItem.image &&
                oldItem.url == newItem.url &&
                oldItem.location == newItem.location &&
                oldItem.episode == newItem.episode
    }
}