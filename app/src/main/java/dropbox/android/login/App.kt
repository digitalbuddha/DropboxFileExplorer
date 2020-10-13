package dropbox.android.login

import android.app.Application
import dropbox.android.login.di.LoginComponent
import dropbox.android.login.di.DaggerAppComponent

class App: Application() {

    lateinit var component: LoginComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
        component.inject(this)
    }
}