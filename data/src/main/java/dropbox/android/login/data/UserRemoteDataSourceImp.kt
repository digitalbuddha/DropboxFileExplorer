package dropbox.android.login.data

internal class UserRemoteDataSourceImp(private val authSdk: AuthSdk, private val client: Client) : UserRemoteDataSource {

    override fun login() {
        authSdk.authenticate()
    }

    override fun authenticate(): User? {

        val tokenAndUId = authSdk.geTokenAndUid() ?: return null
        client.init(tokenAndUId?.first)
        val user = client.getUser()
        return if (user != null)
            User(
                email = user.email,
                name = user.name.displayName,
                userName = user.accountType.name,
                uiId = tokenAndUId.second,
                token = tokenAndUId.first
            ) else null
    }
}