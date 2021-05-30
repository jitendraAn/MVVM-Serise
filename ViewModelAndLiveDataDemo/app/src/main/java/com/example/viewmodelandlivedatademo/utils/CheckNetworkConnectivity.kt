package com.example.viewmodelandlivedatademo.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData

class CheckNetworkConnectivity(private val connectvityManager: ConnectivityManager) :
    LiveData<Boolean>() {

        constructor(application: Application):this(application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

    private val networkCallback= @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    object :ConnectivityManager.NetworkCallback(){
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onActive() {
        super.onActive()
        val build=NetworkRequest.Builder()
        connectvityManager.registerNetworkCallback(build.build(),networkCallback)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onInactive() {
        super.onInactive()
        connectvityManager.unregisterNetworkCallback(networkCallback)
    }


}