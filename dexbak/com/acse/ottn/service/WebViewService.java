package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1631H;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.widget.CustomWebView;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class WebViewService extends Service {

    /* renamed from: a */
    private static View f3027a = null;

    /* renamed from: b */
    private static WindowManager f3028b = null;

    /* renamed from: c */
    private static String f3029c = "WebViewService";

    /* renamed from: d */
    public static TimerTask f3030d;

    /* renamed from: e */
    private WindowManager.LayoutParams f3031e;

    /* renamed from: f */
    private CustomWebView f3032f;

    /* renamed from: g */
    private C1584b f3033g;

    /* renamed from: h */
    private int f3034h = -1;

    /* renamed from: i */
    private boolean f3035i = false;

    /* renamed from: com.acse.ottn.service.WebViewService$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1583a extends FrameLayout {
        public C1583a(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.service.WebViewService$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1584b extends WebChromeClient {
        private C1584b() {
        }

        /* synthetic */ C1584b(WebViewService webViewService, C1590aa c1590aa) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    static {
        StubApp.interface11(4520);
    }

    /* renamed from: a */
    private static int m56401a(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    private static void m56402a(int i) {
        f3030d = C1648S.m56165a().m56163b(i, 1000, new C1590aa());
    }

    /* renamed from: a */
    private void m56400a(String str) {
        String str2 = f3029c;
        C1694ra.m55917a(str2, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.f3032f;
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
            C1584b c1584b = new C1584b(this, null);
            this.f3033g = c1584b;
            this.f3032f.setWebChromeClient(c1584b);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.f3032f.setWebViewClient(new C1592ba(this));
            this.f3032f.loadUrl(str);
        } catch (IllegalArgumentException e) {
            String str3 = f3029c;
            C1694ra.m55917a(str3, "IllegalArgumentException=" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            String str4 = f3029c;
            C1694ra.m55917a(str4, "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m56399b() {
        try {
            View view = f3027a;
            if (view != null) {
                view.setVisibility(8);
            }
            f3028b.removeView(f3027a);
        } catch (Exception e) {
            String str = f3029c;
            C1694ra.m55917a(str, "dismiss e=" + e.getMessage());
        }
    }

    /* renamed from: b */
    private void m56398b(int i) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i, (ViewGroup) null);
            f3027a = inflate;
            inflate.measure(0, 0);
        } catch (Exception e) {
            String str = f3029c;
            C1694ra.m55917a(str, "setLayoutView e = " + e.getMessage());
        }
    }

    /* renamed from: b */
    private void m56397b(String str) {
        C1694ra.m55917a(f3029c, "webview悬浮窗");
        m56398b(C1239R.C1244layout.webview_service);
        this.f3032f = (CustomWebView) f3027a.findViewById(C1239R.C1242id.dwebView);
        this.f3031e.height = -1;
        m56400a(str);
        try {
            f3028b.addView(f3027a, this.f3031e);
        } catch (Exception e) {
            String str2 = f3029c;
            C1694ra.m55917a(str2, "添加失败 e=" + e.getMessage());
        }
        m56402a(5000);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: c */
    private void m56396c() {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.f3031e = new WindowManager.LayoutParams();
        f3028b = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f3031e;
            i = 2038;
        } else {
            layoutParams = this.f3031e;
            i = 2002;
        }
        layoutParams.type = i;
        WindowManager.LayoutParams layoutParams2 = this.f3031e;
        layoutParams2.format = 1;
        layoutParams2.flags = 8;
        layoutParams2.gravity = 51;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1694ra.m55914c(f3029c, "MainService Created");
        m56396c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            C1586Y.m56383b();
            C1586Y.m56378c();
            View view = f3027a;
            if (view != null) {
                f3028b.removeView(view);
            }
        } catch (Exception e) {
            String str = f3029c;
            C1694ra.m55914c(str, "onDestroy e=" + e.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            String stringExtra = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                m56397b(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("shortLink");
            if (!TextUtils.isEmpty(stringExtra2)) {
                C1631H.m56262a().m56260a(this, stringExtra2);
            }
        } catch (Exception e) {
            String str = f3029c;
            C1694ra.m55917a(str, "Exception =" + e.getMessage());
        }
        return super.onStartCommand(intent, i, i2);
    }
}
