package com.example.exthost

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        web = findViewById(R.id.webView)
        with(web.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
            allowFileAccess = true
            allowContentAccess = true
        }
        // Simple local page so APK launches cleanly; your wrapper will
        // copy the Chrome extension into assets/extension/
        web.loadData(
            """
            <html><body>
              <h2>ExtHost is ready</h2>
              <p>Your extension files should be at <code>assets/extension/</code>.</p>
            </body></html>
            """.trimIndent(),
            "text/html", "UTF-8"
        )
    }
}
