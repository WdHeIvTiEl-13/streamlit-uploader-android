package com.example.streamlituploader

import android.app.Activity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import android.net.Uri

class MainActivity : Activity() {
    companion object {
        private const val APP_URL =
            "https://9l72f7zvvhtrplk3jjdkh3.streamlit.app"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use Chrome Custom Tabs instead of an embedded WebView.
        // This keeps GitHub OAuth in a supported browser context and
        // allows the existing Streamlit ZIP upload flow to use Android's picker.
        val customTabsIntent = CustomTabsIntent.Builder().build()
        customTabsIntent.launchUrl(this, Uri.parse(APP_URL))
        finish()
    }
}
