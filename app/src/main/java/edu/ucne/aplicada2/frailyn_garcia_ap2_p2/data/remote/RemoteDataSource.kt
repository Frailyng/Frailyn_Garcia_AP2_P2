package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val repositoryApi: RepositoryApi
) {
    suspend fun getRepository(username: String) = repositoryApi.listRepos(username)

    suspend fun getContributors(repo: String) = repositoryApi.listContributors("Frailyng", repo)
}