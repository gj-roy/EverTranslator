package tw.firemaples.onscreenocr.translator

import android.content.ClipDescription
import android.content.ComponentName
import android.content.Intent
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory.packageName


object BingTranslateAppTranslator: Translator {
    override val type: TranslationProviderType
        get() = TranslationProviderType.BingTranslateApp

    override suspend fun translate(text: String, sourceLangCode: String): TranslationResult {

        val i = Intent()
        i.action = Intent.ACTION_PROCESS_TEXT
        i.addCategory(Intent.CATEGORY_DEFAULT)
        i.type = ClipDescription.MIMETYPE_TEXT_PLAIN
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.component = ComponentName("com.microsoft.translator", "com.microsoft.translator.activity.translate.InAppTranslationActivity")
        i.putExtra(Intent.EXTRA_PROCESS_TEXT, text)
        i.putExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, true)

        context.startActivity(i)


        return TranslationResult.OuterTranslatorLaunched
    }

}