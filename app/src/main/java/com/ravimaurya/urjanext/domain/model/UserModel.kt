package com.ravimaurya.urjanext.domain.model

data class UserModel(
    val userId : Int = -1,
    val fullName : String = "",
    val number : String = "",
    val email : String = "",
    val registerDate : String = "",
    val deviceId : String = "",
    val userPassword: String = ""
)
