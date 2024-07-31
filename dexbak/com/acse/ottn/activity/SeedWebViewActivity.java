package com.acse.ottn.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.widget.CustomWebView;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SeedWebViewActivity extends ActivityC1305w implements View.OnClickListener {
    private static final String TAG = "SeedWebViewActivity";

    /* renamed from: d */
    CustomWebView f2139d;

    /* renamed from: e */
    private C1280b f2140e;

    /* renamed from: com.acse.ottn.activity.SeedWebViewActivity$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1279a extends FrameLayout {
        public C1279a(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.acse.ottn.activity.SeedWebViewActivity$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1280b extends WebChromeClient {
        private C1280b() {
        }

        /* synthetic */ C1280b(SeedWebViewActivity seedWebViewActivity, C1264C c1264c) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    static {
        StubApp.interface11(4171);
    }

    /* renamed from: a */
    private void m57296a(String str) {
        String str2 = TAG;
        C1694ra.m55917a(str2, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.f2139d;
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
            C1280b c1280b = new C1280b(this, null);
            this.f2140e = c1280b;
            this.f2139d.setWebChromeClient(c1280b);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f2139d.setWebViewClient(new C1264C(this));
            this.f2139d.loadUrl(str);
        } catch (IllegalArgumentException e) {
            String str3 = TAG;
            C1694ra.m55917a(str3, "IllegalArgumentException=" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            String str4 = TAG;
            C1694ra.m55917a(str4, "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);
}
