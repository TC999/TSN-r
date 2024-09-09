package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.acse.ottn.R;
import com.acse.ottn.l0;
import com.acse.ottn.widget.CustomWebView;
import com.acse.ottn.z1;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class WebViewService extends Service {

    /* renamed from: f  reason: collision with root package name */
    public static View f6399f = null;

    /* renamed from: g  reason: collision with root package name */
    public static WindowManager f6400g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f6401h = "WebViewService";

    /* renamed from: i  reason: collision with root package name */
    public static TimerTask f6402i;

    /* renamed from: a  reason: collision with root package name */
    public WindowManager.LayoutParams f6403a;

    /* renamed from: b  reason: collision with root package name */
    public CustomWebView f6404b;

    /* renamed from: c  reason: collision with root package name */
    public d f6405c;

    /* renamed from: d  reason: collision with root package name */
    public int f6406d = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6407e = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: com.acse.ottn.service.WebViewService$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0094a implements Runnable {
            public RunnableC0094a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebViewService.c();
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(WebViewService.f6401h, "\u7ed3\u675f\u4e86");
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0094a(), 0L);
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
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
    public static class c extends FrameLayout {
        public c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            super.onProgressChanged(webView, i4);
        }

        public /* synthetic */ d(WebViewService webViewService, a aVar) {
            this();
        }
    }

    static {
        StubApp.interface11(5047);
    }

    public static void c() {
        try {
            View view = f6399f;
            if (view != null) {
                view.setVisibility(8);
            }
            f6400g.removeView(f6399f);
        } catch (Exception e4) {
            String str = f6401h;
            z1.a(str, "dismiss e=" + e4.getMessage());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        this.f6403a = new WindowManager.LayoutParams();
        f6400g = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6403a.type = 2038;
        } else {
            this.f6403a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f6403a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        z1.c(f6401h, "MainService Created");
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            C1391a.b();
            C1391a.d();
            View view = f6399f;
            if (view != null) {
                f6400g.removeView(view);
            }
        } catch (Exception e4) {
            String str = f6401h;
            z1.c(str, "onDestroy e=" + e4.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        try {
            String stringExtra = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                b(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("shortLink");
            if (!TextUtils.isEmpty(stringExtra2)) {
                com.acse.ottn.n.a().a(this, stringExtra2);
            }
        } catch (Exception e4) {
            String str = f6401h;
            z1.a(str, "Exception =" + e4.getMessage());
        }
        return super.onStartCommand(intent, i4, i5);
    }

    public static void a(int i4) {
        f6402i = l0.a().b(i4, 1000, new a());
    }

    public static int a(Context context, int i4) {
        return (int) (i4 * context.getResources().getDisplayMetrics().density);
    }

    public final void a(String str) {
        String str2 = f6401h;
        z1.a(str2, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.f6404b;
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
            d dVar = new d(this, null);
            this.f6405c = dVar;
            this.f6404b.setWebChromeClient(dVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f6404b.setWebViewClient(new b());
            this.f6404b.loadUrl(str);
        } catch (IllegalArgumentException e4) {
            String str3 = f6401h;
            z1.a(str3, "IllegalArgumentException=" + e4.getMessage());
            e4.printStackTrace();
        } catch (Exception e5) {
            String str4 = f6401h;
            z1.a(str4, "Exception=" + e5.getMessage());
            e5.printStackTrace();
        }
    }

    public final void b(String str) {
        z1.a(f6401h, "webview\u60ac\u6d6e\u7a97");
        b(R.layout.webview_service);
        this.f6404b = (CustomWebView) f6399f.findViewById(R.id.dwebView);
        this.f6403a.height = -1;
        a(str);
        try {
            f6400g.addView(f6399f, this.f6403a);
        } catch (Exception e4) {
            String str2 = f6401h;
            z1.a(str2, "\u6dfb\u52a0\u5931\u8d25 e=" + e4.getMessage());
        }
        a(5000);
    }

    public final void b(int i4) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i4, (ViewGroup) null);
            f6399f = inflate;
            inflate.measure(0, 0);
        } catch (Exception e4) {
            String str = f6401h;
            z1.a(str, "setLayoutView e = " + e4.getMessage());
        }
    }
}
