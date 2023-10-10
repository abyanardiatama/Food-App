package com.example.smartphoneapp

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import de.hdodenhof.circleimageview.CircleImageView


class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            // Tindakan yang diambil ketika tombol "Back" diklik
            onBackPressed() // atau intent untuk kembali ke Activity sebelumnya
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}