package dropbox.android.login.data

import dagger.Module
import dagger.Provides

@Module(includes = [FileSdkModule::class])
class RemoteModule {

    @Provides
    fun providesRemoteDataSourceImp(authSdk: AuthSdk, client: Client): UserRemoteDataSource = UserRemoteDataSourceImp(authSdk, client)

}