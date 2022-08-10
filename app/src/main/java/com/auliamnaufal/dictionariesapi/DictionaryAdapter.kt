package com.auliamnaufal.dictionariesapi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.dictionariesapi.data.DefinitionsItem
import com.auliamnaufal.dictionariesapi.data.DictionaryResponseItem
import com.auliamnaufal.dictionariesapi.databinding.RowItemWordBinding

class DictionaryAdapter: RecyclerView.Adapter<DictionaryAdapter.CommentViewHolder>() {
    private val listDefinition: ArrayList<DefinitionsItem?> = ArrayList()

    class CommentViewHolder(val binding: RowItemWordBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        RowItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.binding.apply {
            with(listDefinition[position]) {
                tvDefinition.text = this?.definition
            }
        }
    }

    override fun getItemCount() = listDefinition.size

    fun setData(data: List<DefinitionsItem?>?) {
        listDefinition.clear()
        Log.i("Adapter", "onBindViewHolder: $data")
        if (data != null) {
            listDefinition.addAll(data)
        }
    }

}