package com.kukki.imageloading.di

import DataResponse

interface FirebaseCallback {
    fun onResponse(response: DataResponse)
}