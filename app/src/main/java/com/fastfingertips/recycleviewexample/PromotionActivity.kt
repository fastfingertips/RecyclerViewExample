package com.fastfingertips.recycleviewexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fastfingertips.recycleviewexample.databinding.ActivityPromotionBinding

class PromotionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPromotionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromotionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // #1 Singleton
        /*
        val selectedHero = MySingleton.selectedSuperHero
        selectedHero?.let {
            val imageResId = it.image ?: R.drawable.default_image
            binding.imageView.setImageResource(imageResId)
            binding.nameTextView.text = it.name
            binding.jobTextView.text = it.job
        }
        */

        // #2 Intent
        val selectedHero = intent.getSerializableExtra("selectedHero") as? SuperHero
        selectedHero?.let {
            val imageResId = it.image ?: R.drawable.default_image
            binding.imageView.setImageResource(imageResId)
            binding.nameTextView.text = it.name
            binding.jobTextView.text = it.job
        }
    }
}