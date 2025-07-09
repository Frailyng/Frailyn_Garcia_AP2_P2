package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.contributors

sealed interface ContributorsEvent {
    data class LoginChange(val login: String): ContributorsEvent
    data class Node_IdChange(val node_id: String): ContributorsEvent
    data class Html_urlChange(val html_url: String): ContributorsEvent
    data class ContributionsChange(val contributions: Int): ContributorsEvent
    data class GetContributors(val repositoryName: String) : ContributorsEvent
}