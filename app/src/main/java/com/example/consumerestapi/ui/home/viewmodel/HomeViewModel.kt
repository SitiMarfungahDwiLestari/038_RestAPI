package com.example.consumerestapi.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumerestapi.model.Kontak
import com.example.consumerestapi.repository.KontakRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class KontakUIState{
    data class Success(val kontak: List<Kontak>): KontakUIState() //jika sukses
    object Error : KontakUIState() //jika eror
    object Loading : KontakUIState() //jika masih loading
}

class HomeViewModel (private val kontakRepository: KontakRepository) : ViewModel(){
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    //init -> yang akan pertama kali dijalankan, dia akan update terus
    init {
        getKontak()
    }

    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = try{
                KontakUIState.Success(kontakRepository.getKontak())
            }catch (e: IOException){
                KontakUIState.Error
            }catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
}