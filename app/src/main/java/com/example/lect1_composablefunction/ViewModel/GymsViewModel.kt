package com.example.lect1_composablefunction.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.lect1_composablefunction.Gym
import com.example.lect1_composablefunction.listOfGyms

class GymsViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {

    var state by mutableStateOf(restoreSelectedGyms())

    private fun getGyms() = listOfGyms

    fun toggleFavouriteState(gymId: Int) {
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isFavourite = !gyms[itemIndex].isFavourite)
        storeSelectedGym(gyms[itemIndex])
        state = gyms
    }

    private fun storeSelectedGym(gym: Gym) {
        val saveHandleList = stateHandle.get<List<Int?>>(FAV_IDS).orEmpty().toMutableList()
        if (gym.isFavourite) {
            saveHandleList.add(gym.id)
        } else {
            saveHandleList.remove(gym.id)
        }
        stateHandle[FAV_IDS] = saveHandleList
    }

    private fun restoreSelectedGyms(): List<Gym> {
        val gyms = getGyms()
        // let -> is if stateHandel is null dont error or essus
        stateHandle.get<List<Int?>>(FAV_IDS)?.let { savesIds ->
            savesIds.forEach { gymsId ->
                gyms.find { it.id == gymsId }?.isFavourite = true
            }
        }
        return gyms
    }

    companion object {
        const val FAV_IDS = "favouriteGymIDs"
    }
}