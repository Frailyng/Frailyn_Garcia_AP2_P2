package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.registros

import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.RepositoryDto

data class RegistroUiState(
    val name: String = "",
    val description: String = "",
    val html_url: String = "",
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorDescripcion: String? = null,
    val errorMonto: String? = null,
    val successMessage: String? = null,
    val registros: List<RepositoryDto> = emptyList()

)