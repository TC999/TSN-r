package com.acse.ottn;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.widget.CustomWebView;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class w0 {

    /* renamed from: d  reason: collision with root package name */
    public static w0 f6920d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f6921e = "ExcessActivity";

    /* renamed from: a  reason: collision with root package name */
    public Activity f6922a;

    /* renamed from: b  reason: collision with root package name */
    public CustomWebView f6923b;

    /* renamed from: c  reason: collision with root package name */
    public c f6924c;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6925a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6927c;

        public a(String str, String str2, String str3) {
            this.f6925a = str;
            this.f6926b = str2;
            this.f6927c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f6925a)) {
                AccessiblityModel accessiblityModel = new AccessiblityModel();
                accessiblityModel.getData().setSpop_deeplink(this.f6925a);
                accessiblityModel.getData().setSpop_link(this.f6926b);
                accessiblityModel.getData().setPackage_name(this.f6927c);
                a4.b().a(w0.this.f6922a, accessiblityModel);
            }
            w0.this.f6922a.finish();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
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

        public /* synthetic */ c(w0 w0Var, a aVar) {
            this();
        }
    }

    public final Object b() throws ObjectStreamException {
        return f6920d;
    }

    public static w0 a() {
        if (f6920d == null) {
            synchronized (w0.class) {
                if (f6920d == null) {
                    f6920d = new w0();
                }
            }
        }
        return f6920d;
    }

    public void a(Activity activity) {
        this.f6922a = activity;
        this.f6923b = (CustomWebView) activity.findViewById(R.id.dwebView);
        String stringExtra = this.f6922a.getIntent().getStringExtra("password");
        String stringExtra2 = this.f6922a.getIntent().getStringExtra("link");
        String stringExtra3 = this.f6922a.getIntent().getStringExtra("deeplink");
        String stringExtra4 = this.f6922a.getIntent().getStringExtra("origin_url");
        String stringExtra5 = this.f6922a.getIntent().getStringExtra("name");
        int intExtra = this.f6922a.getIntent().getIntExtra("time", 100);
        if (!TextUtils.isEmpty(stringExtra)) {
            n.a().a(this.f6922a, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra4)) {
            String str = f6921e;
            z1.a(str, "loadH5Url = " + stringExtra4);
            a(stringExtra4);
        } else {
            z1.a(f6921e, "origin_url is null");
        }
        new Handler().postDelayed(new a(stringExtra3, stringExtra2, stringExtra5), intExtra);
    }

    public final void a(String str) {
        try {
            CustomWebView customWebView = this.f6923b;
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
            this.f6924c = cVar;
            this.f6923b.setWebChromeClient(cVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f6923b.setWebViewClient(new b());
            this.f6923b.loadUrl(str);
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
