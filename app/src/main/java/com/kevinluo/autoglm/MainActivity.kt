package com.nongmol.agent

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nongmol.agent.utils.LocaleHelper
import com.nongmol.agent.vision.ModelSelector

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.updateConfig(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // เชื่อมต่อปุ่มเลือกโมเดล (หน้ากาก)
        findViewById<Button>(R.id.btn_select_model)?.setOnClickListener {
            ModelSelector.requestModelFolder(this)
        }
    }
}
