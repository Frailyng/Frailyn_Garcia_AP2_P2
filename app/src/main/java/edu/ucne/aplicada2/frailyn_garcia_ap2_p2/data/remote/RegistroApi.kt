package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote

import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto.RepositoryDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RegistroApi {
    @GET("api/Compras")
    suspend fun getRegistros(): List<RepositoryDto>

    @GET("api/Compras/{id}")
    suspend fun getRegistros(@Path("id") id: Int): List<RepositoryDto>

    @PUT("api/Compras/{id}")
    suspend fun updateRegistro(@Body repositoryDto: RepositoryDto): RepositoryDto

    @POST("api/Compras")
    suspend fun saveRegistro(@Body repositoryDto: RepositoryDto): RepositoryDto

    @DELETE("api/Compras/{id}")
    suspend fun deleteRegistro(@Path("id") id: Int): Response<Unit>

}