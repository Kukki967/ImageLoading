package com.kukki.imageloading.di

import Album
import DataResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class ProductsViewModel(
) : ViewModel() {

    val _albumList = MutableLiveData<List<Album>>()
    val albumList: LiveData<List<Album>> = _albumList

    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val productRef: DatabaseReference = rootRef.child("albums")

    init {
        getResponseUsingCallback()
    }

    private fun getResponseFromRealtimeDatabaseUsingCallback(callback: FirebaseCallback) {
        productRef.get().addOnCompleteListener { task ->
            val response = DataResponse()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.products = result.children.map { snapShot ->
                        snapShot.getValue(Album::class.java)!!
                    }

                }
            } else {
                response.exception = task.exception
            }

            callback.onResponse(response)
        }
    }

    private fun getResponseUsingCallback() {
        getResponseUsingCallback(object : FirebaseCallback {
            override fun onResponse(response: DataResponse) {
                val list = response.products ?: ArrayList<Album>()
                _albumList.postValue(list)
            }
        })
    }

    private fun getResponseUsingCallback(callback: FirebaseCallback) {
        getResponseFromRealtimeDatabaseUsingCallback(callback)
    }
}