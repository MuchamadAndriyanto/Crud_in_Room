package com.example.crudinroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudinroom.databinding.ActivityDetailBinding
import com.example.crudinroom.room.DataNote

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var getDetail = intent.getSerializableExtra("detail") as DataNote

        binding.detailTitle.text = getDetail.title
        binding.detailNote.text = getDetail.content

    }
}