package com.example.farmachinchanito.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmachinchanito.R
import com.example.farmachinchanito.listener.PastillasAdapterListener
import com.example.farmachinchanito.models.Producto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardproductos.view.*

class ProductoAdapter(    val productos: List<Producto>, private val listener:PastillasAdapterListener)
    :RecyclerView.Adapter<ProductoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.cardproductos,p0,false))

    override fun getItemCount() = productos.size

    override fun onBindViewHolder(Holder: ViewHolder, position: Int) = Holder.bind(productos[position],listener)

    class ViewHolder(item: View):RecyclerView.ViewHolder(item){
        fun bind(
            producto: Producto,
            listener: PastillasAdapterListener
        ) {
            itemView.nomproduct.text = producto.nombre_pro
            Picasso.get().load(producto.url_pro).into(itemView.imgproduct)
itemView.setOnClickListener {
    listener.onclick(producto,adapterPosition)
}
        }
    }

}