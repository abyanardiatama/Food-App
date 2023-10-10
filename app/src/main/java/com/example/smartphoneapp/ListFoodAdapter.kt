package com.example.smartphoneapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListFoodAdapter(private val listFood: ArrayList<Food>): RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_food, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFood.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (name, description, photo) = listFood[position]
        Glide.with(holder.itemView.context)
            .load(photo) // Load image from url
            .into(holder.imgPhoto)  // Set image into ImageView
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listFood[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val moveIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            // Pass food data to DetailActivity
            moveIntent.putExtra(DetailActivity.EXTRA_NAME, listFood[holder.adapterPosition].name)
            moveIntent.putExtra(DetailActivity.EXTRA_DESCRIPTION, listFood[holder.adapterPosition].description)
            moveIntent.putExtra(DetailActivity.EXTRA_IMAGE_URL, listFood[position].image)
            holder.itemView.context.startActivity(moveIntent)
        }
    }
}