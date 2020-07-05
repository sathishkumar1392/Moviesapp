package com.zatto.movieapp.utilis

import android.content.Context
import android.net.ConnectivityManager

@Suppress("DEPRECATION")
class ConnectivityImpl(private val context: Context) : Connectivity {
    override fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}
interface Connectivity {
    fun isNetworkAvailable(): Boolean
}
