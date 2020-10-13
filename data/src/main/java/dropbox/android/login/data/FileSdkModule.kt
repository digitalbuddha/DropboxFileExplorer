package dropbox.android.login.data

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FileSdkModule {

    @Singleton
    @Provides
    fun providesAuthSdk(context: Context): AuthSdk = AuthSdkImp(context)

    @Provides
    fun providesClient(context: Context): Client = ClientImp(context)
}