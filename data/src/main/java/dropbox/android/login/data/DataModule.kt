package dropbox.android.login.data

import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesUserRepository(localDataSource: UserLocalDataSource,
                               remoteDataSource: UserRemoteDataSource
    ): UserRepository = UserRepositoryImpl(localDataSource, remoteDataSource)
}