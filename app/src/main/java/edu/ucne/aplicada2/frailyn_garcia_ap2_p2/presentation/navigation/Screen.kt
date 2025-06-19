package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object Home : Screen()
    @Serializable
    data object RegistroList: Screen()
    @Serializable
    data class Registro(val registroId: Int?) : Screen()
}