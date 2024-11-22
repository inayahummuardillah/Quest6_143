package com.example.prak6.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p6.ui.view.screen.DatailView
import com.example.p6.ui.view.screen.MahasiswaFormView
import com.example.p6.ui.view.screen.SplashView
import com.example.p6.ui.view.viewmodel.MahasiswaViewModel
import com.example.prak6.ui.screen.RencanaStudyView
import com.example.prak6.ui.viewmodel.RencanaStudyViewModel


enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.statusUI.collectAsState().value
    val rencanaStudiUiState = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        // Halaman Splash
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
    }
}