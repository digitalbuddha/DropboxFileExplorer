package dropbox.android.login.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dropbox.android.login.data.LocalModule
import dropbox.android.login.data.DataModule
import dropbox.android.login.ui.LoginActivity
import dropbox.android.login.data.RemoteModule
import dropbox.android.login.ui.PresentationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    RemoteModule::class,
    LocalModule::class,
    PresentationModule::class])
interface LoginComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
}