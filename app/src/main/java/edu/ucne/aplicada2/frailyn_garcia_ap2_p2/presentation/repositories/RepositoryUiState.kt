package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.repositories

import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.RepositoryDto

data class RepositoryUiState(
    val name: String = "",
    val description: String = "",
    val html_url: String = "",
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
    val repository: List<RepositoryDto> = emptyList()

)