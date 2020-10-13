package dropbox.android.login.data

interface UserLocalDataSource {
    fun isUserLogged(): Boolean
    fun saveUser(user: User)
    fun loadUser(): User?
}