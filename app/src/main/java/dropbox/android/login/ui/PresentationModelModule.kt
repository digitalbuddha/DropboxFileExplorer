package dropbox.android.login.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import dropbox.android.presentation.model.FileExplorerModel
import dropbox.android.presentation.model.FileExplorerModelImpl
import dropbox.android.presentation.model.LoginModel

@Module
class PresentationModelModule {


    @Provides
    fun providesPermissionHelper(context: Context) = PermissionHelper(context)


}