package com.example.consumerestapi.ui.home

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumerestapi.KontakApplication
import com.example.consumerestapi.ui.kontak.viewmodel.DetailsViewModel
import com.example.consumerestapi.ui.kontak.viewmodel.EditViewModel
import com.example.consumerestapi.ui.kontak.viewmodel.HomeViewModel
import com.example.consumerestapi.ui.kontak.viewmodel.InsertViewModel

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiMars().container.kontakRepository)
        }
        initializer {
            InsertViewModel(aplikasiMars().container.kontakRepository)
        }
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                kontakRepository = aplikasiMars().container.kontakRepository
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                kontakRepository = aplikasiMars().container.kontakRepository
            )
        }
    }
}

fun CreationExtras.aplikasiMars(): KontakApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakApplication)