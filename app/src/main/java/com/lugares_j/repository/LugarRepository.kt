package com.lugares_j.repository

import androidx.lifecycle.LiveData
import com.lugares_j.data.LugarDao
import com.lugares_j.model.Lugar

class LugarRepository(private val lugarDao: LugarDao) {

    suspend fun saveLugar(lugar: Lugar) {
        if (lugar.id==0){
            lugarDao.addLugar(lugar)
        }else {
            lugarDao.updateLugar(lugar)
        }

    }
    suspend fun  deleteLugar(lugar: Lugar) {
        if (lugar.id!=0){
            lugarDao.deleteLugar(lugar)
        }

    }

    val getLugares : LiveData<List<Lugar>> = lugarDao.getLugares()

}