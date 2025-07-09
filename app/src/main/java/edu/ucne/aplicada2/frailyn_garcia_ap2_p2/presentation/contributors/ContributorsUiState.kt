package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.contributors

import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.ContributorsDto

data class ContributorsUiState(
    val login: String = "",
    val node_id: String = "",
    val html_url: String = "",
    val contributions: Int = 0,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
    val contributors: List<ContributorsDto> = emptyList()

)