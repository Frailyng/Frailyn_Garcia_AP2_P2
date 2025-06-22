package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.repositories

interface RepositoryEvent {
    data class NameChange(val name: String): RepositoryEvent
    data class DescriptionChange(val description: String): RepositoryEvent
    data class Html_urlChange(val html_url: String): RepositoryEvent
}