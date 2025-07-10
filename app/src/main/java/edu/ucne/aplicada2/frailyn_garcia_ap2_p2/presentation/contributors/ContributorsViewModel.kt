package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.contributors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.Resource
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.repository.RepositoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContributorsViewModel @Inject constructor(
    private val repositoryRepository: RepositoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ContributorsUiState())
    val uiState = _uiState.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun onEvent(event: ContributorsEvent) {
        when (event) {
            is ContributorsEvent.ContributionsChange -> TODO()
            is ContributorsEvent.GetContributors -> TODO()
            is ContributorsEvent.Html_urlChange -> TODO()
            is ContributorsEvent.LoginChange -> TODO()
            is ContributorsEvent.Node_IdChange -> TODO()
        }
    }

    fun getContributors(repos: String) {
        viewModelScope.launch {
            repositoryRepository.getContributors(repos).collectLatest { getting ->
                when (getting) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                contributors = getting.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}