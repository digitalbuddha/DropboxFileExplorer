package dropbox.android.login.data

import android.content.Context
import com.dropbox.core.android.Auth
import dropbox.android.file_explorer_sdk.R

internal class AuthSdkImp(private val context: Context): AuthSdk {

    override fun authenticate() {
        Auth.startOAuth2Authentication(context, context.getString(R.string.app_key))
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