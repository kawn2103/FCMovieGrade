package kst.app.fcmoviegrade.data.repository

import kst.app.fcmoviegrade.domain.model.Review
import kst.app.fcmoviegrade.domain.model.User


interface UserRepository {

    suspend fun getUser(): User?

    suspend fun saveUser(user: User)
}