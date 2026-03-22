package com.nongmol.agent.vision
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.documentfile.provider.DocumentFile
import java.io.File
import java.io.FileOutputStream
object ModelSelector {
    fun requestModelFolder(activity: ComponentActivity) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        activity.startActivityForResult(intent, 1001)
    }
    fun handleResult(data: Intent?, resolver: android.content.ContentResolver): Uri? {
        val uri = data?.data ?: return null
        resolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        return uri
    }
    fun copyModel(context: android.content.Context, modelUri: Uri): String? {
        val input = context.contentResolver.openInputStream(modelUri) ?: return null
        val outFile = File(context.filesDir, "model_${System.currentTimeMillis()}.gguf")
        input.use { i -> FileOutputStream(outFile).use { o -> i.copyTo(o) } }
        return outFile.absolutePath
    }
}
