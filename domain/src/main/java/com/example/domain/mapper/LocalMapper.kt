package com.example.domain.mapper

import com.example.data.model.ProfileLocalModel
import com.example.domain.model.ProfileModel

fun ProfileLocalModel.toDomain(): ProfileModel {
    return ProfileModel(
        name = this.name,
        email = this.email,
        password = this.password
    )
}