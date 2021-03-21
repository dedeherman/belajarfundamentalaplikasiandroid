package com.dede.mylistview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailHeroActivity : AppCompatActivity() {

    companion object{
        const val KEY_HERO = "key_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)

        val dataHero = intent.getParcelableExtra<Hero>(KEY_HERO) as Hero
        findViewById<TextView>(R.id.tvDescriptionDetail).text = dataHero.description
        findViewById<ImageView>(R.id.imgPhotoDetail).setImageResource(dataHero.photo)
    }
}