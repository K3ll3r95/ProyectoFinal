package com.example.farmachinchanito.otros

import android.app.Activity
import android.widget.Toast

fun Activity.toast(mensaje:CharSequence){
    Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
}