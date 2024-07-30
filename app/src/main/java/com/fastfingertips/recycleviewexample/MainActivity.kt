package com.fastfingertips.recycleviewexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fastfingertips.recycleviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superHeroList = arrayListOf(
            SuperHero("Superman", "Journalist", R.drawable.superman),
            SuperHero("Batman", "Businessman", R.drawable.batman),
            SuperHero("Ironman", "Inventor", R.drawable.ironman),
            SuperHero("Aquaman", "King of Atlantis", R.drawable.aquaman),
            SuperHero("Wonder Woman", "Warrior Princess"),
            SuperHero("Flash", "Speedster"),
            SuperHero("Green Lantern", "Space Cop"),
            SuperHero("Spider-Man", "Photographer"),
            SuperHero("Thor", "God of Thunder"),
            SuperHero("Captain America", "Soldier"),
            SuperHero("Hulk", "Scientist"),
            SuperHero("Black Widow", "Spy"),
            SuperHero("Scarlet Witch", "Sorceress"),
            SuperHero("Doctor Strange", "Sorcerer Supreme")
        )

        val adapter = SuperHeroAdapter(superHeroList)
        binding.superHeroRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.superHeroRecyclerView.adapter = adapter
    }
}