package dropbox.android.login.data

interface AuthSdk {

    fun authenticate()

    fun geTokenAndUid(): Pair<String, String>?

}