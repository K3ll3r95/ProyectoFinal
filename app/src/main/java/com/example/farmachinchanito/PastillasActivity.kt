package com.example.farmachinchanito

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.farmachinchanito.adapter.PastillaAdapter
import com.example.farmachinchanito.models.Pastilla
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

import kotlinx.android.synthetic.main.activity_pastillas.*
import java.util.*

class PastillasActivity : AppCompatActivity() {

    private lateinit var  recicler: RecyclerView
    private lateinit var adaptador: PastillaAdapter

    private val lista : ArrayList<Pastilla> = ArrayList()
    //private val pastStore = FirebaseFirestore.getInstance()
    //private var pastDB = pastStore.collection("Pastillas")
    lateinit var  mdata : DatabaseReference

    private var pastReg : ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pastillas)
        recicler = findViewById(R.id.recyclerPastillas)





    }



}
