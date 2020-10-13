package dropbox.android.login.data

import com.dropbox.core.v2.users.FullAccount

interface Client {

    fun init(token: String)

    fun getUser(): FullAccount?
}