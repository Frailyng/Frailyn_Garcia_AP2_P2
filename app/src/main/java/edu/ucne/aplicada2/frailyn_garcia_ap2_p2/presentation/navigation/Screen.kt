package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data object RepositoryList : Screen()

    @Serializable
    data class ContributorsList(val repositoryName: String) : Screen()

    @Serializable
    data class Repository(val registroId: Int?) : Screen()
}