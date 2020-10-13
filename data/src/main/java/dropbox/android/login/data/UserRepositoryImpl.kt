package dropbox.android.login.data

internal class UserRepositoryImpl(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override fun login() {
        remoteDataSource.login()
    }

    override fun loadUser(): User? {
        return if (!localDataSource.isUserLogged()) {
            val user = remoteDataSource.authenticate()
            if (user != null) {
                localDataSource.saveUser(user)
            }
            user
        } else {
            localDataSource.loadUser()
        }
    }
}