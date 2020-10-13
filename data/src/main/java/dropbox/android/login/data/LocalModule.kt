package dropbox.android.login.data

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Singleton
    @Provides
    internal fun providesLocalDataSource(): UserLocalDataSource = UserLocalDataSourceImpl()

}