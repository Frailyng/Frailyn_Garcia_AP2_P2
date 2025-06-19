package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation

sealed class UiEvent {
    object NavigateUp : UiEvent()
    data class ShowSnackbar(val message: String) : UiEvent()
}