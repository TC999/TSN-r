package com.acse.ottn.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.acse.ottn.widget.CustomWebView;
import com.acse.ottn.z1;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SeedWebViewActivity extends com.acse.ottn.z implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public static final String f4696g = "SeedWebViewActivity";

    /* renamed from: e  reason: collision with root package name */
    public CustomWebView f4697e;

    /* renamed from: f  reason: collision with root package name */
    public c f4698f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b extends FrameLayout {
        public b(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
        }

        public /* synthetic */ c(SeedWebViewActivity seedWebViewActivity, a aVar) {
            this();
        }
    }

    static {
        StubApp.interface11(4678);
    }

    public final void a(String str) {
        String str2 = f4696g;
        z1.a(str2, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.f4697e;
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
            c cVar = new c(this, null);
            this.f4698f = cVar;
            this.f4697e.setWebChromeClient(cVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f4697e.setWebViewClient(new a());
            this.f4697e.loadUrl(str);
        } catch (IllegalArgumentException e4) {
            String str3 = f4696g;
            z1.a(str3, "IllegalArgumentException=" + e4.getMessage());
            e4.printStackTrace();
        } catch (Exception e5) {
            String str4 = f4696g;
            z1.a(str4, "Exception=" + e5.getMessage());
            e5.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);
}
