package com.acse.ottn.activity;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.acse.ottn.widget.CustomWebView;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ExcessActivity extends ActivityC1305w {
    private static String TAG = "ExcessActivity";

    /* renamed from: d */
    CustomWebView f2108d;

    /* renamed from: e */
    private C1267a f2109e;

    /* renamed from: com.acse.ottn.activity.ExcessActivity$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1267a extends WebChromeClient {
        private C1267a() {
        }

        /* synthetic */ C1267a(ExcessActivity excessActivity, RunnableC1306x runnableC1306x) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    static {
        StubApp.interface11(4156);
    }

    /* renamed from: a */
    private void m57307a(String str) {
        try {
            CustomWebView customWebView = this.f2108d;
            if (customWebView == null) {
                return;
            }
            WebSettings settings = customWebView.getSettings();
            settings.setTextZoom(100);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            C1267a c1267a = new C1267a(this, null);
            this.f2109e = c1267a;
            this.f2108d.setWebChromeClient(c1267a);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f2108d.setWebViewClient(new C1307y(this));
            this.f2108d.loadUrl(str);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);
}
