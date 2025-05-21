package project.android.pahlawanindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import project.android.pahlawanindonesia.R
import project.android.pahlawanindonesia.model.Hero

class ListHeroAdapter (private val listHero: ArrayList<Hero>,
                       private val onItemClick:(Hero) -> Unit): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallBack = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.txtName.text = name
        holder.txtDesc.text = desc
        holder.itemView.setOnClickListener{onItemClick(listHero[position])
        }

    }


    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var txtName: TextView = itemView.findViewById(R.id.txt_item_name)
        var txtDesc: TextView = itemView.findViewById(R.id.txt_item_description)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Hero)
    }
}

// Kamis 15 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/