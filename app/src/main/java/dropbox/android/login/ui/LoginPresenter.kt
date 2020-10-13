package dropbox.android.login.ui

import dropbox.android.presentation.model.LoginModel
import kotlinx.coroutines.launch
import java.lang.Exception


class LoginPresenter(val userRepository: dropbox.android.login.data.UserRepository) : BasePresenter<LoginView>() {

    fun attemptLogin() = launch {
        val isLoginSent = doLogin()
        if (isLoginSent) publishResults { view?.loginInProgress() } else { publishResults { view?.generalError() }}
    }

    override fun bind(view: LoginView) {
        super.bind(view)
        processLogin()
    }

    private fun processLogin() = launch {
        when (val status = processLoginInner()) {
            is dropbox.android.login.data.UserAuthenticated -> publishResults { view?.loginSuccess("welcome ¡¡ ${status.user.name}") }
            is dropbox.android.login.data.UserNotLogged -> publishResults { view?.notLoggedUser() }
            is dropbox.android.login.data.UserError -> publishResults {
                view?.notLoggedUser()
                view?.generalError()
            }

        }
    }

      private fun doLogin() : Boolean {
        return try {
            userRepository.login()
            true
        } catch (e: Exception) {
            false
        }
    }

     private fun processLoginInner(): dropbox.android.login.data.UserStatus {
        return try {
            val userInformation = userRepository.loadUser()
            if (userInformation != null) {
                dropbox.android.login.data.UserAuthenticated(userInformation)
            } else {
                dropbox.android.login.data.UserNotLogged
            }
        } catch (e: Exception) {
            dropbox.android.login.data.UserError
        }
    }

}