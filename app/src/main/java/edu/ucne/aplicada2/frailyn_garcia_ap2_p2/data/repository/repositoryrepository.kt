package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.repository


import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.RemoteDataSource
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.Resource
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.RepositoryDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RegistroRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    fun getRegistro(registroid: Int): Flow<Resource<List<RepositoryDto>>> = flow {
        try {
            emit(Resource.Loading())
            val registro = remoteDataSource.getRegistros(registroid)
            emit(Resource.Success(registro))
        } catch (e: HttpException) {
            emit(Resource.Error("Error de internet: ${e.message()}"))
        } catch (e: Exception) {
            emit(Resource.Error("Error desconocido: ${e.message}"))
        }
    }

    suspend fun saveRegistro(repositoryDto: RepositoryDto)= remoteDataSource.saveRegistro(repositoryDto)

    suspend fun deleteRegistro(id: Int)= remoteDataSource.deleteRegistro(id)

    suspend fun editRegistro(repositoryDto: RepositoryDto)= remoteDataSource.updateRegistro(repositoryDto)

    fun getRegistro(): Flow<Resource<List<RepositoryDto>>> = flow {
        try {
            emit(Resource.Loading())
            val registro = remoteDataSource.getRegistros()
            emit(Resource.Success(registro))
        } catch (e: HttpException) {
            emit(Resource.Error("Error de internet: ${e.message()}"))
        } catch (e: Exception) {
            emit(Resource.Error("Error desconocido: ${e.message}"))
        }
    }
}