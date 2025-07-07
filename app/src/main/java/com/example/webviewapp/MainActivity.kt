package com.example.webviewapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge

class MainActivity : androidx.activity.ComponentActivity() {

    private lateinit var webView : WebView
    private val url = "https://nfcsit.jiophone.net/resource/jiopay_payout_sdk/websdk/210525/index.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.setSupportZoom(true)
        webSettings.domStorageEnabled = true
        webSettings.allowFileAccess = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setGeolocationEnabled(true)
        webSettings.defaultTextEncodingName = CommonConstants.UTF8
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE

        webView.isVerticalScrollBarEnabled = true
        webView.isHorizontalScrollBarEnabled = true
        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }

    object CommonConstants {
        const val UTF8 = "utf-8"
    }
}


