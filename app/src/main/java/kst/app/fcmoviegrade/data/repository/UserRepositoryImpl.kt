package kst.app.fcmoviegrade.data.repository


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kst.app.fcmoviegrade.data.api.UserApi
import kst.app.fcmoviegrade.data.preference.PreferenceManager
import kst.app.fcmoviegrade.domain.model.Review
import kst.app.fcmoviegrade.domain.model.User

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val preferenceManager: PreferenceManager,
    private val dispatchers: CoroutineDispatcher
) : UserRepository {

    override suspend fun getUser(): User? = withContext(dispatchers) {
        preferenceManager.getString(KEY_USER_ID)?.let { User(it) }
    }

    override suspend fun saveUser(user: User) = withContext(dispatchers) {
        val newUser = userApi.saveUser(user)
        preferenceManager.putString(KEY_USER_ID, newUser.id!!)
    }

    companion object {
        private const val KEY_USER_ID = "KEY_USER_ID"
    }
}