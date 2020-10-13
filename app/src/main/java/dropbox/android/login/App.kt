package dropbox.android.login

import android.app.Application
import dropbox.android.login.di.LoginComponent
import dropbox.android.login.di.DaggerLoginComponent

class App: Application() {

    lateinit var component: LoginComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerLoginComponent.builder().application(this).build()
    }
}