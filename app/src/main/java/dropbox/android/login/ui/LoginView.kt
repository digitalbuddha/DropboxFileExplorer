package dropbox.android.login.ui

interface LoginView {
    fun loginSuccess(welcomeMsn: String)
    fun loginInProgress()
    fun notLoggedUser()
    fun generalError()
}