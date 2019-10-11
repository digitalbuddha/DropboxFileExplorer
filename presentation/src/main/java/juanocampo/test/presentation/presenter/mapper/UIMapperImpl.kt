package juanocampo.test.presentation.presenter.mapper

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import juanocampo.test.domain.entity.entity.FileDropbox
import juanocampo.test.domain.entity.entity.FileIntent
import juanocampo.test.presentation.BuildConfig
import juanocampo.test.presentation.entitiy.FileViewType
import juanocampo.test.presentation.ext.toUIModel
import juanocampo.test.presentation.mapper.UIMapper

class UIMapperImpl: UIMapper {

    override fun mapFileIntent(fileIntent: FileIntent, context: Context): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", fileIntent.file)
        intent.setDataAndType(uri, fileIntent.type)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        return intent
    }


    override fun mapToUIFile(file: FileDropbox): FileViewType = file.toUIModel()
}