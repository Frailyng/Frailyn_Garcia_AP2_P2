package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.dto

import com.squareup.moshi.Json

data class ContributorsDto(
@Json(name = "login") val login: String,
@Json(name = "node_id") val node_id: String,
@Json(name = "html_url") val htmlUrl: String,
@Json(name = "contributions") val contributions: Int
)