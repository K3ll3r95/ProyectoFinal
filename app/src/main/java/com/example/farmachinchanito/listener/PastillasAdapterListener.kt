package com.example.farmachinchanito.listener

import com.example.farmachinchanito.models.Producto

interface PastillasAdapterListener {
    fun onclick(pastilla: Producto, pos:Int)
}