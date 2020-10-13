package dropbox.android.login.data

interface UserRemoteDataSource {
    fun login()
    fun authenticate(): User?
}