package project.android.pahlawanindonesia

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import project.android.pahlawanindonesia.model.Hero

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val ivHeroImage = findViewById<ImageView>(R.id.img_heroImage)
        val tvHeroName = findViewById<TextView>(R.id.txt_heroName)
        val txtHeroDesc = findViewById<TextView>(R.id.txt_heroDescription)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("HERO_OBJECT", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("HERO_OBJECT")
        }
        if (hero != null) {
            ivHeroImage.setImageResource(hero.foto)
            tvHeroName.text = hero.nama
            txtHeroDesc.text = hero.deskripsi
        }

    }
}

// Kamis 15 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/