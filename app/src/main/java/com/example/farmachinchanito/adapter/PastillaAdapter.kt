package com.example.farmachinchanito.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmachinchanito.R
import com.example.farmachinchanito.models.Pastilla
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardpastilla.view.*

class PastillaAdapter ( val pastillas: List<Pastilla> )
    : RecyclerView.Adapter<PastillaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.cardpastilla,p0,false))

    override fun getItemCount() = pastillas.size

    override fun onBindViewHolder(Holder: ViewHolder, position: Int) = Holder.bind(pastillas[position])

    class ViewHolder(item: View):RecyclerView.ViewHolder(item){
        fun bind(pastilla : Pastilla) {
            itemView.nompast.text = pastilla.nom
            itemView.preciopast.text= pastilla.Precio.toString()
            Picasso.get().load(pastilla.img).into(itemView.imgpast)
        }
    }

}