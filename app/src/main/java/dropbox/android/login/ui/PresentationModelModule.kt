package dropbox.android.login.ui

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class PresentationModelModule {


    @Provides
    fun providesPermissionHelper(context: Context) = PermissionHelper(context)


}