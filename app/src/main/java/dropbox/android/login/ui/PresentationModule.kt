package dropbox.android.login.ui

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [PresentationModelModule::class])
class PresentationModule {

    @Provides
    @Singleton
    fun providesLoginPresenter(userRepository: dropbox.android.login.data.UserRepository) = LoginPresenter(userRepository)

}