package com.example.lect1_composablefunction.ViewModel

import androidx.lifecycle.ViewModel
import com.example.lect1_composablefunction.listOfGyms

class GymsViewModel() : ViewModel() {
    fun getGyms() = listOfGyms
}