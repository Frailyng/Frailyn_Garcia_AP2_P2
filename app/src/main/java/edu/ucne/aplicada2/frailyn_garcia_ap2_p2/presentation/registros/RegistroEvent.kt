package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.registros

interface RegistroEvent {
    data class NameChange(val name: String): RegistroEvent
    data class DescriptionChange(val description: String): RegistroEvent
    data class Html_urlChange(val html_url: String): RegistroEvent

    data object PostRegistro: RegistroEvent
    data object GetRegistro: RegistroEvent
    data object Nuevo: RegistroEvent
    data object LimpiarErrorMessageDescripcion: RegistroEvent
    data object LimpiarErrorMessageMonto: RegistroEvent
    data class GetRegistros(val id: Int): RegistroEvent
    data object ResetSuccessMessage: RegistroEvent
}