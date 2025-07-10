package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.repository


import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.RemoteDataSource
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.Resource
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.ContributorsDto
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.RepositoryDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getRepositories(username: String): Flow<Resource<List<RepositoryDto>>> = flow {
        emit(Resource.Loading())
        try {
            val repositories = remoteDataSource.getRepository(username)
            emit(Resource.Success(repositories))
        } catch (e: Exception) {
            emit(Resource.Error("Error al obtener repositorios: ${e.message}"))
        }
    }

    suspend fun getContributors(repos: String): Flow<Resource<List<ContributorsDto>>> = flow {
        emit(Resource.Loading())
        try {
            val contributors = remoteDataSource.getContributors(repos)
            emit(Resource.Success(contributors))
        } catch (e: Exception) {
            emit(Resource.Error("Error al obtener los contribuidores: ${e.message}"))
        }
    }
}