package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote

import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.RepositoryDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val registroApi: RegistroApi
){
    suspend fun getRegistros()= registroApi.getRegistros()

    suspend fun updateRegistro(repositoryDto: RepositoryDto)= registroApi.updateRegistro(repositoryDto)

    suspend fun saveRegistro(repositoryDto: RepositoryDto)= registroApi.saveRegistro(repositoryDto)

    suspend fun  deleteRegistro(id: Int)= registroApi.deleteRegistro(id)

    suspend fun getRegistros(id: Int)= registroApi.getRegistros(id)
}