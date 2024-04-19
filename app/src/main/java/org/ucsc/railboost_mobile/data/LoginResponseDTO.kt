package org.ucsc.railboost_mobile.data

data class LoginResponseDTO(
    val userId: Int,
    val username: String,
    val isSuccessful: Boolean,
    val role: RoleDTO,
    val jwt: String
)
