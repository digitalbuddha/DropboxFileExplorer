package dropbox.android.login.data

import android.content.Context
import com.dropbox.core.android.Auth

internal class AuthSdkImp(private val context: Context): AuthSdk {

    override fun authenticate() {
        Auth.startOAuth2Authentication(context,"3x84iqvt5klbjga")
    }

    override fun geTokenAndUid(): Pair<String, String>? {
        val accessToken = Auth.getOAuth2Token()

        if (accessToken.isNullOrEmpty()) {
            return null
        }
        val uid = Auth.getUid()
        return Pair(accessToken, uid)
    }

}