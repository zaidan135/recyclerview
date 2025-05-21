package project.android.pahlawanindonesia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.android.pahlawanindonesia.adapter.ListHeroAdapter
import project.android.pahlawanindonesia.model.Hero

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_hero)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListOfHeroes())
        showRecyclerList()

    }

    private fun getListOfHeroes(): ArrayList<Hero>{

        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices){
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }

        return listHero
    }

    private fun showRecyclerList(){
        val listHeroAdapter = ListHeroAdapter(list){data ->
            showSelectedHero(data)
        }

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })

        rvHeroes.layoutManager = LinearLayoutManager(this)
        rvHeroes.adapter = listHeroAdapter
        rvHeroes.setHasFixedSize(true)
    }

    private fun showSelectedHero(hero: Hero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HERO_OBJECT", hero)
        startActivity(intent)
    }
}

// Kamis 15 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/