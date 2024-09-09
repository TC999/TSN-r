package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b;
import com.tencent.open.b.h;
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
public class TDialog extends c {

    /* renamed from: c  reason: collision with root package name */
    static final FrameLayout.LayoutParams f51638c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    static Toast f51639d = null;

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<ProgressDialog> f51640f;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Context> f51641e;

    /* renamed from: g  reason: collision with root package name */
    private String f51642g;

    /* renamed from: h  reason: collision with root package name */
    private OnTimeListener f51643h;

    /* renamed from: i  reason: collision with root package name */
    private IUiListener f51644i;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout f51645j;

    /* renamed from: k  reason: collision with root package name */
    private com.tencent.open.c.b f51646k;

    /* renamed from: l  reason: collision with root package name */
    private Handler f51647l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f51648m;

    /* renamed from: n  reason: collision with root package name */
    private QQToken f51649n;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f51646k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i4, String str, String str2) {
            super.onReceivedError(webView, i4, str, str2);
            TDialog.this.f51643h.onError(new UiError(i4, str, str2));
            if (TDialog.this.f51641e != null && TDialog.this.f51641e.get() != null) {
                Toast.makeText((Context) TDialog.this.f51641e.get(), "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\u6216\u7cfb\u7edf\u9519\u8bef", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) TDialog.this.f51641e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f51643h.onComplete(m.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://cancel")) {
                TDialog.this.f51643h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://close")) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (!str.startsWith("download://") && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            } else {
                try {
                    if (str.startsWith("download://")) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    if (TDialog.this.f51641e != null && TDialog.this.f51641e.get() != null) {
                        ((Context) TDialog.this.f51641e.get()).startActivity(intent);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class JsListener extends b.C1042b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f51647l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel("cancel");
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f51647l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f51647l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f51647l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a  reason: collision with root package name */
        String f51653a;

        /* renamed from: b  reason: collision with root package name */
        String f51654b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<Context> f51655c;

        /* renamed from: d  reason: collision with root package name */
        private String f51656d;

        /* renamed from: e  reason: collision with root package name */
        private IUiListener f51657e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f51655c = new WeakReference<>(context);
            this.f51656d = str;
            this.f51653a = str2;
            this.f51654b = str3;
            this.f51657e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f51657e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f51657e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h a4 = h.a();
            a4.a(this.f51656d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f51653a, false);
            IUiListener iUiListener = this.f51657e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f51657e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f51653a;
            } else {
                str = this.f51653a;
            }
            h a4 = h.a();
            a4.a(this.f51656d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f51657e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f51657e = null;
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
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class THandler extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private OnTimeListener f51659b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f51659b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i4 = message.what;
            if (i4 == 1) {
                this.f51659b.a((String) message.obj);
            } else if (i4 == 2) {
                this.f51659b.onCancel();
            } else if (i4 != 3) {
                if (i4 != 5 || TDialog.this.f51641e == null || TDialog.this.f51641e.get() == null) {
                    return;
                }
                TDialog.d((Context) TDialog.this.f51641e.get(), (String) message.obj);
            } else if (TDialog.this.f51641e == null || TDialog.this.f51641e.get() == null) {
            } else {
                TDialog.c((Context) TDialog.this.f51641e.get(), (String) message.obj);
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f51648m = false;
        this.f51649n = null;
        this.f51641e = new WeakReference<>(context);
        this.f51642g = str2;
        this.f51643h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f51647l = new THandler(this.f51643h, context.getMainLooper());
        this.f51644i = iUiListener;
        this.f51649n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f51643h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.c, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a.a(getWindow());
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d4 = m.d(str);
            int i4 = d4.getInt("type");
            String string = d4.getString("msg");
            if (i4 == 0) {
                Toast toast = f51639d;
                if (toast == null) {
                    f51639d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f51639d.setText(string);
                    f51639d.setDuration(0);
                }
                f51639d.show();
            } else if (i4 == 1) {
                Toast toast2 = f51639d;
                if (toast2 == null) {
                    f51639d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f51639d.setText(string);
                    f51639d.setDuration(1);
                }
                f51639d.show();
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d4 = m.d(str);
            int i4 = d4.getInt("action");
            String string = d4.getString("msg");
            if (i4 == 1) {
                WeakReference<ProgressDialog> weakReference = f51640f;
                if (weakReference != null && weakReference.get() != null) {
                    f51640f.get().setMessage(string);
                    if (!f51640f.get().isShowing()) {
                        f51640f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f51640f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i4 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f51640f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f51640f.get().isShowing()) {
                    f51640f.get().dismiss();
                    f51640f = null;
                }
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void a() {
        try {
            new TextView(this.f51641e.get()).setText("test");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f51641e.get());
            this.f51646k = bVar;
            bVar.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f51641e.get());
            this.f51645j = cVar;
            cVar.setLayoutParams(layoutParams);
            this.f51645j.setBackgroundColor(-1);
            this.f51645j.addView(this.f51646k);
            setContentView(this.f51645j);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.TDialog", "onCreateView exception", th);
            a.a(this, this.f51647l);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f51646k.setVerticalScrollBarEnabled(false);
        this.f51646k.setHorizontalScrollBarEnabled(false);
        this.f51646k.setWebViewClient(new FbWebViewClient());
        this.f51646k.setWebChromeClient(this.f51724b);
        this.f51646k.clearFormData();
        WebSettings settings = this.f51646k.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f51646k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f51641e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f51641e.get().getApplicationContext()).getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f51723a.a(new JsListener(), "sdk_js_if");
        this.f51646k.loadUrl(this.f51642g);
        this.f51646k.setLayoutParams(f51638c);
        this.f51646k.setVisibility(4);
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f51723a.a(this.f51646k, str);
        } catch (Exception unused) {
        }
    }
}
