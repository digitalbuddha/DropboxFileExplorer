package dropbox.android.login.data

sealed class UserStatus
data class UserAuthenticated(val user: User): UserStatus()
object UserNotLogged: UserStatus()
object UserError: UserStatus()