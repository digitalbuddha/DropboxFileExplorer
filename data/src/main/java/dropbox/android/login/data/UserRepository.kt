package dropbox.android.login.data

interface UserRepository {

    fun login()

    fun loadUser(): User?
}