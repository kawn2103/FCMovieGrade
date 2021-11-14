package kst.app.fcmoviegrade.data.api

import kst.app.fcmoviegrade.domain.model.User


interface UserApi {

    suspend fun saveUser(user: User): User
}