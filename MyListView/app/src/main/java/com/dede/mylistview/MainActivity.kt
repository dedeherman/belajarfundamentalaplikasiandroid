package com.dede.mylistview

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        val adapter = HeroAdapter()
        listView.adapter = adapter

        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val heroes = arrayListOf<Hero>()
        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position,-1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailHeroActivity::class.java)
            intent.putExtra(DetailHeroActivity.KEY_HERO, heroes[position])
            startActivity(intent)
        }
    }
}