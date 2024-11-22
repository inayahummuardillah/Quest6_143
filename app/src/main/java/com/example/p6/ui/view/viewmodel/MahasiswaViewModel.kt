package com.example.p6.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p6.ui.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel(){
    fun saveDataMahasiswa(mahasiswa: Mahasiswa){
    }

    //request
    private val _statusUI = MutableStateFlow(Mahasiswa())

    //response
    val statusUI: StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni -> //isi sebuah model yaitu data siswa
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }
}