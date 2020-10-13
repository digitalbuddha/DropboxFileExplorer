package dropbox.android.login.data

internal class UserLocalDataSourceImpl: UserLocalDataSource {

    private var _user: User? = null

    override fun isUserLogged(): Boolean {
        return _user != null
    }

    override fun saveUser(user: User) {
        this._user = user
    }

    override fun loadUser(): User? = _user
}