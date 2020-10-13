package dropbox.android.login.data

import android.content.Context
import com.dropbox.core.v2.users.FullAccount

internal class ClientImp(private val context: Context) : Client {

    override fun init(token: String) {
        DropboxClientFactory.init(token)
    }

    override fun getUser(): FullAccount? {
        return DropboxClientFactory.getClient().users()?.currentAccount
    }
}