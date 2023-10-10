package com.example.smartphoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.core.view.MenuItemCompat
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_IMAGE_URL = "extra_photo"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val imageUrl = intent.getStringExtra(EXTRA_IMAGE_URL)


        val foodImage = findViewById<ImageView>(R.id.foodImage)
        val foodName = findViewById<TextView>(R.id.foodName)
        val foodDescription = findViewById<TextView>(R.id.foodDescription)

        // Mengecek apakah imageUrl tidak null dan tidak kosong
        if (!imageUrl.isNullOrEmpty()) {
            // Menampilkan gambar menggunakan Glide
            Glide.with(this)
                .load(description)
                .into(foodImage)
        }

        foodName.text = name
        foodDescription.text = imageUrl


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Tangani aksi ketika tombol "Kembali" diklik
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
