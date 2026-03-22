package com.nongmol.agent.utils
import android.content.Context
import android.content.res.Configuration
import java.util.Locale
object LocaleHelper {
    fun setLocale(context: Context): Context {
        val locale = Locale("th")
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }
    fun updateConfig(context: Context): Context = setLocale(context)
}
