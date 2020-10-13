package dropbox.android.login.ui

import dagger.Module
import dagger.Provides

@Module(includes = [PresentationModelModule::class])
class PresentationModule {

    @Provides
    @ActivityScope
    fun providesLoginPresenter(userRepository: dropbox.android.login.data.UserRepository) = LoginPresenter(userRepository)

}