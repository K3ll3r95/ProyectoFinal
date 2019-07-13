package com.example.farmachinchanito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.farmachinchanito.R
import com.example.farmachinchanito.adapter.PastillaAdapter
import com.example.farmachinchanito.models.Pastilla
import com.example.farmachinchanito.otros.toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.fragment_pastilla.view.*
import java.util.*


class PastillaFragment : Fragment() {
    private lateinit var  recicler:RecyclerView
    private lateinit var adaptador:PastillaAdapter
    private val lmg by lazy { LinearLayoutManager(context) }

    private val lista :ArrayList<Pastilla > = ArrayList()

    private val pastStore = FirebaseFirestore.getInstance()
    private var pastDB = pastStore.collection("Pastillas")
    private var pastReg : ListenerRegistration? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_pastilla, container, false)
        recicler =  root.recyclerPastillas as RecyclerView

        return root
    }

    private fun setuprecycler(){
        recicler.setHasFixedSize(true)
        recicler.itemAnimator = DefaultItemAnimator()
        recicler.layoutManager = lmg
        adaptador = PastillaAdapter(lista)
        recicler.adapter = adaptador
    }
    private fun getPastilas(){
        pastReg = pastDB.addSnapshotListener(object: EventListener,com.google.firebase.firestore.EventListener<QuerySnapshot>{
            override fun onEvent(p0: QuerySnapshot?, p1: FirebaseFirestoreException?) {
                p1?.let {
                    activity?.toast("exception")
                    return
                }
                p0?.let {
                    lista.clear()
                    val pas = it.toObjects(Pastilla::class.java)
                    lista.addAll(pas)
                    adaptador.notifyDataSetChanged()
                }
            }

        })
    }

    override fun onDestroyView() {
        pastReg?.remove()
            super.onDestroyView()
    }


}
