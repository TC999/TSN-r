package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends com.tencent.open.c implements a.InterfaceC1043a {

    /* renamed from: c  reason: collision with root package name */
    static Toast f51733c;

    /* renamed from: d  reason: collision with root package name */
    private String f51734d;

    /* renamed from: e  reason: collision with root package name */
    private IUiListener f51735e;

    /* renamed from: f  reason: collision with root package name */
    private c f51736f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f51737g;

    /* renamed from: h  reason: collision with root package name */
    private com.tencent.open.c.a f51738h;

    /* renamed from: i  reason: collision with root package name */
    private com.tencent.open.c.b f51739i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<Context> f51740j;

    /* renamed from: k  reason: collision with root package name */
    private int f51741k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.f51739i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i4, String str, String str2) {
            super.onReceivedError(webView, i4, str, str2);
            d.this.f51736f.onError(new UiError(i4, str, str2));
            if (d.this.f51740j != null && d.this.f51740j.get() != null) {
                Toast.makeText((Context) d.this.f51740j.get(), "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\u6216\u7cfb\u7edf\u9519\u8bef", 0).show();
            }
            d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) d.this.f51740j.get(), "auth://tauth.qq.com/"))) {
                d.this.f51736f.onComplete(m.c(str));
                d.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                d.this.f51736f.onCancel();
                d.this.dismiss();
                return true;
            } else if (str.startsWith("auth://close")) {
                d.this.dismiss();
                return true;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b extends b.C1042b {
        private b() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class c extends DefaultUiListener {

        /* renamed from: a  reason: collision with root package name */
        String f51744a;

        /* renamed from: b  reason: collision with root package name */
        String f51745b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<Context> f51746c;

        /* renamed from: d  reason: collision with root package name */
        private String f51747d;

        /* renamed from: e  reason: collision with root package name */
        private IUiListener f51748e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f51746c = new WeakReference<>(context);
            this.f51747d = str;
            this.f51744a = str2;
            this.f51745b = str3;
            this.f51748e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f51748e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f51748e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h a4 = h.a();
            a4.a(this.f51747d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f51744a, false);
            IUiListener iUiListener = this.f51748e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f51748e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f51744a;
            } else {
                str = this.f51744a;
            }
            h a4 = h.a();
            a4.a(this.f51747d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f51748e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f51748e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e4) {
                e4.printStackTrace();
                onError(new UiError(-4, "\u670d\u52a1\u5668\u8fd4\u56de\u6570\u636e\u683c\u5f0f\u6709\u8bef!", str));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class HandlerC1044d extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private c f51750b;

        public HandlerC1044d(c cVar, Looper looper) {
            super(looper);
            this.f51750b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i4 = message.what;
            if (i4 == 1) {
                this.f51750b.a((String) message.obj);
            } else if (i4 == 2) {
                this.f51750b.onCancel();
            } else if (i4 != 3) {
                if (i4 != 5 || d.this.f51740j == null || d.this.f51740j.get() == null) {
                    return;
                }
                d.d((Context) d.this.f51740j.get(), (String) message.obj);
            } else if (d.this.f51740j == null || d.this.f51740j.get() == null) {
            } else {
                d.c((Context) d.this.f51740j.get(), (String) message.obj);
            }
        }
    }

    public d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f51740j = new WeakReference<>(context);
        this.f51734d = str2;
        this.f51736f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f51737g = new HandlerC1044d(this.f51736f, context.getMainLooper());
        this.f51735e = iUiListener;
        this.f51741k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f51741k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d4 = m.d(str);
            d4.getInt("action");
            d4.getString("msg");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.c, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f51739i.setVerticalScrollBarEnabled(false);
        this.f51739i.setHorizontalScrollBarEnabled(false);
        this.f51739i.setWebViewClient(new a());
        this.f51739i.setWebChromeClient(this.f51724b);
        this.f51739i.clearFormData();
        WebSettings settings = this.f51739i.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f51739i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f51740j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f51740j.get().getApplicationContext()).getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f51723a.a(new b(), "sdk_js_if");
        this.f51739i.clearView();
        this.f51739i.loadUrl(this.f51734d);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.f51740j.get());
        this.f51738h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f51738h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f51740j.get());
        this.f51739i = bVar;
        bVar.setBackgroundColor(0);
        this.f51739i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f51739i, 1, new Paint());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f51741k);
        layoutParams.addRule(13, -1);
        this.f51739i.setLayoutParams(layoutParams);
        this.f51738h.addView(this.f51739i);
        this.f51738h.a(this);
        setContentView(this.f51738h);
    }

    @Override // com.tencent.open.c.a.InterfaceC1043a
    public void a(int i4) {
        WeakReference<Context> weakReference = this.f51740j;
        if (weakReference != null && weakReference.get() != null) {
            if (i4 < this.f51741k && 2 == this.f51740j.get().getResources().getConfiguration().orientation) {
                this.f51739i.getLayoutParams().height = i4;
            } else {
                this.f51739i.getLayoutParams().height = this.f51741k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC1043a
    public void a() {
        this.f51739i.getLayoutParams().height = this.f51741k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f51723a.a(this.f51739i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d4 = m.d(str);
            int i4 = d4.getInt("type");
            String string = d4.getString("msg");
            if (i4 == 0) {
                Toast toast = f51733c;
                if (toast == null) {
                    f51733c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f51733c.setText(string);
                    f51733c.setDuration(0);
                }
                f51733c.show();
            } else if (i4 == 1) {
                Toast toast2 = f51733c;
                if (toast2 == null) {
                    f51733c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f51733c.setText(string);
                    f51733c.setDuration(1);
                }
                f51733c.show();
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
