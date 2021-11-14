package kst.app.fcmoviegrade.data.api

import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.coroutines.tasks.await
import kst.app.fcmoviegrade.domain.model.User

class UserFirestoreApi(
    private val firestore: FirebaseFirestore
) : UserApi {

    override suspend fun saveUser(user: User): User =
        firestore.collection("users")
            .add(user)
            .await()
            .let { User(it.id) }
}