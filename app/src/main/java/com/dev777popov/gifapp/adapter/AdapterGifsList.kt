package com.dev777popov.gifapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev777popov.gifapp.R
import com.dev777popov.gifapp.model.Data
import kotlinx.android.synthetic.main.item_list_gifs.view.*

class AdapterGifsList(private val data: List<Data>) :
    RecyclerView.Adapter<AdapterGifsList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_gifs, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.img_gif

        fun bind(item: Data?) {
            if (item != null) {
                Glide.with(image).load(item.images?.original?.url).into(image)
            }
        }
    }
}
