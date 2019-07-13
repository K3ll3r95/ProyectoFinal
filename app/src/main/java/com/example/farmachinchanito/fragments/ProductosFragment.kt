package com.example.farmachinchanito.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmachinchanito.PastillasActivity

import com.example.farmachinchanito.adapter.ProductoAdapter
import com.example.farmachinchanito.listener.PastillasAdapterListener
import com.example.farmachinchanito.models.Producto
import com.example.farmachinchanito.otros.toast
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_productos.view.*

//import android.R



class ProductosFragment : Fragment() {


    private lateinit var recicler:RecyclerView
    private lateinit var  adaptador:ProductoAdapter
    private val lm by lazy { GridLayoutManager(context,2)  }

    private val lista: ArrayList<Producto>  = ArrayList()


    private val productStore = FirebaseFirestore.getInstance()
    private var producDB = productStore.collection("Productos")
    private var prodReg : ListenerRegistration? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(com.example.farmachinchanito.R.layout.fragment_productos, container, false)
         recicler= root.recyclerProductos as RecyclerView
        setuprecycler()
        getproductos()

        return root
    }

    private fun setuprecycler(){
        recicler.setHasFixedSize(true)
        recicler.itemAnimator = DefaultItemAnimator()
        recicler.layoutManager = lm
        adaptador = ProductoAdapter(lista,object :PastillasAdapterListener{
            override fun onclick(pastilla: Producto, pos: Int) {
                val a=Intent(activity,PastillasActivity::class.java)

                startActivity(a)
            }

        })

        recicler.adapter = adaptador

    }

    private fun getproductos(){
        prodReg =producDB.addSnapshotListener(object: java.util.EventListener,EventListener<QuerySnapshot>{
            override fun onEvent(snap: QuerySnapshot?, ex: FirebaseFirestoreException?) {
                ex?.let {
                    activity?.toast("Exception")
                        return
                }
                snap?.let {
                    lista.clear()
                    val pro = it.toObjects(Producto::class.java)
                    lista.addAll(pro)
                    adaptador.notifyDataSetChanged()
                }
            }

        })

//                add(Producto(1,"Pastillas",R.drawable.pastillas))
//                add(Producto(2,"Jarabes",R.drawable.jarabe))
//                add(Producto(3,"Perfumeria",R.drawable.perfumes))
//                add(Producto(4,"Aseo Personal",R.drawable.aseo))
//                add(Producto(5,"Cremas y Pomadas",R.drawable.cremas_pomadas))
//                add(Producto(6,"Otros Productos",R.drawable.otros))



    }

    override fun onDestroyView() {
        prodReg?.remove()
        super.onDestroyView()
    }


}
