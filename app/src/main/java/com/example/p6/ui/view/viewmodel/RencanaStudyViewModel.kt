package com.example.prak6.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p6.ui.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudi.RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi.RencanaStudi> = _krsState.asStateFlow()

    fun setMatakuliah(mkPilihan: String) {
        _krsState.update {  stateMK -> stateMK.copy(mataKuliah = mkPilihan) }
    }

    fun setKelas(kelasPilihan: String) {
        _krsState.update {  stateMK -> stateMK.copy(kelas = kelasPilihan) }
    }

    fun saveDataKRS(ls: MutableList<String>){
        _krsState.update { status -> status.copy(
            mataKuliah = ls[0],
            kelas = ls[1]
        )
        }
    }
}