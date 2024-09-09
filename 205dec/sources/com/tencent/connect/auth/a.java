package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import com.tencent.connect.auth.b;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private String f51391a;

    /* renamed from: b  reason: collision with root package name */
    private b f51392b;

    /* renamed from: c  reason: collision with root package name */
    private IUiListener f51393c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f51394d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f51395e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f51396f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f51397g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f51398h;

    /* renamed from: i  reason: collision with root package name */
    private String f51399i;

    /* renamed from: j  reason: collision with root package name */
    private com.tencent.open.c.d f51400j;

    /* renamed from: k  reason: collision with root package name */
    private Context f51401k;

    /* renamed from: l  reason: collision with root package name */
    private com.tencent.open.web.security.b f51402l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f51403m;

    /* renamed from: n  reason: collision with root package name */
    private int f51404n;

    /* renamed from: o  reason: collision with root package name */
    private String f51405o;

    /* renamed from: p  reason: collision with root package name */
    private String f51406p;

    /* renamed from: q  reason: collision with root package name */
    private long f51407q;

    /* renamed from: r  reason: collision with root package name */
    private long f51408r;

    /* renamed from: s  reason: collision with root package name */
    private HashMap<String, Runnable> f51409s;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class C1032a extends WebViewClient {
        private C1032a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f51397g.setVisibility(8);
            if (a.this.f51400j != null) {
                a.this.f51400j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f51394d.removeCallbacks((Runnable) a.this.f51409s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f51397g.setVisibility(0);
            a.this.f51407q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.f51405o)) {
                a.this.f51394d.removeCallbacks((Runnable) a.this.f51409s.remove(a.this.f51405o));
            }
            a.this.f51405o = str;
            a aVar = a.this;
            d dVar = new d(aVar.f51405o);
            a.this.f51409s.put(str, dVar);
            a.this.f51394d.postDelayed(dVar, PolicyConfig.THREAD_BLOCK_TIMEOUT);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i4, String str, String str2) {
            super.onReceivedError(webView, i4, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i4 + " | description: " + str);
            if (!m.b(a.this.f51401k)) {
                a.this.f51392b.onError(new UiError(9001, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", str2));
                a.this.dismiss();
            } else if (!a.this.f51405o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f51407q;
                if (a.this.f51404n >= 1 || elapsedRealtime >= a.this.f51408r) {
                    a.this.f51400j.loadUrl(a.this.a());
                    return;
                }
                a.m(a.this);
                a.this.f51394d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f51400j.loadUrl(a.this.f51405o);
                    }
                }, 500L);
            } else {
                a.this.f51392b.onError(new UiError(i4, str, str2));
                a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "\u8bf7\u6c42\u4e0d\u5408\u6cd5\uff0c\u8bf7\u68c0\u67e5\u624b\u673a\u5b89\u5168\u8bbe\u7f6e\uff0c\u5982\u7cfb\u7edf\u65f6\u95f4\u3001\u4ee3\u7406\u7b49");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c4 = m.c(str);
                a aVar = a.this;
                aVar.f51403m = aVar.e();
                if (!a.this.f51403m) {
                    if (c4.optString("fail_cb", null) != null) {
                        a.this.a(c4.optString("fail_cb"), "");
                    } else if (c4.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.this.f51391a);
                        sb.append(a.this.f51391a.indexOf("?") > -1 ? "&" : "?");
                        aVar2.f51391a = sb.toString();
                        a aVar3 = a.this;
                        aVar3.f51391a = a.this.f51391a + "browser_error=1";
                        a.this.f51400j.loadUrl(a.this.f51391a);
                    } else {
                        String optString = c4.optString("redir", null);
                        if (optString != null) {
                            a.this.f51400j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f51392b.onComplete(m.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                a.this.f51392b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith("auth://close")) {
                a.this.dismiss();
                return true;
            } else if (!str.startsWith("download://") && !str.endsWith(".apk")) {
                if (str.startsWith("auth://progress")) {
                    try {
                        pathSegments = Uri.parse(str).getPathSegments();
                    } catch (Exception unused) {
                    }
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.f51397g.setVisibility(8);
                        a.this.f51400j.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.f51397g.setVisibility(0);
                    }
                    return true;
                } else if (!str.startsWith("auth://onLoginSubmit")) {
                    if (a.this.f51402l.a(a.this.f51400j, str)) {
                        return true;
                    }
                    SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                    return false;
                } else {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.f51406p = pathSegments2.get(0);
                        }
                    } catch (Exception unused2) {
                    }
                    return true;
                }
            } else {
                try {
                    if (str.startsWith("download://")) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    a.this.f51401k.startActivity(intent);
                } catch (Exception e4) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e4);
                }
                return true;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class b extends DefaultUiListener {

        /* renamed from: a  reason: collision with root package name */
        String f51416a;

        /* renamed from: b  reason: collision with root package name */
        String f51417b;

        /* renamed from: d  reason: collision with root package name */
        private String f51419d;

        /* renamed from: e  reason: collision with root package name */
        private IUiListener f51420e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f51419d = str;
            this.f51416a = str2;
            this.f51417b = str3;
            this.f51420e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f51420e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f51420e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h a4 = h.a();
            a4.a(this.f51419d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f51416a, false);
            IUiListener iUiListener = this.f51420e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f51420e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f51416a;
            } else {
                str = this.f51416a;
            }
            h.a().a(this.f51419d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f51420e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f51420e = null;
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
    private class c extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private b f51422b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f51422b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                this.f51422b.a((String) message.obj);
            } else if (i4 == 2) {
                this.f51422b.onCancel();
            } else if (i4 != 3) {
            } else {
                a.b(a.this.f51401k, (String) message.obj);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f51423a;

        public d(String str) {
            this.f51423a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f51423a + " | mRetryUrl: " + a.this.f51405o);
            if (this.f51423a.equals(a.this.f51405o)) {
                a.this.f51392b.onError(new UiError(9002, "\u8bf7\u6c42\u9875\u9762\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", a.this.f51405o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f51403m = false;
        this.f51407q = 0L;
        this.f51408r = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f51401k = context;
        this.f51391a = str2;
        this.f51392b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f51394d = new c(this.f51392b, context.getMainLooper());
        this.f51393c = iUiListener;
        this.f51399i = str;
        this.f51402l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(a aVar) {
        int i4 = aVar.f51404n;
        aVar.f51404n = i4 + 1;
        return i4;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f51409s.clear();
        this.f51394d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f51401k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e4);
        }
        com.tencent.open.c.d dVar = this.f51400j;
        if (dVar != null) {
            dVar.destroy();
            this.f51400j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f51403m) {
            this.f51392b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.f51409s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b a4 = com.tencent.connect.auth.b.a();
        String c4 = a4.c();
        b.a aVar = new b.a();
        aVar.f51430a = this.f51393c;
        aVar.f51431b = this;
        aVar.f51432c = c4;
        String a5 = a4.a(aVar);
        String str = this.f51391a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b4 = m.b(this.f51391a);
        b4.putString("token_key", c4);
        b4.putString("serial", a5);
        b4.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b4);
        this.f51391a = str2;
        return m.a(this.f51401k, str2);
    }

    private void b() {
        try {
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.c.d dVar = new com.tencent.open.c.d(this.f51401k);
            this.f51400j = dVar;
            dVar.setLayerType(1, null);
            this.f51400j.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f51401k);
            cVar.setLayoutParams(layoutParams);
            cVar.addView(this.f51400j);
            FrameLayout frameLayout = new FrameLayout(this.f51401k);
            this.f51395e = frameLayout;
            frameLayout.addView(cVar);
            this.f51395e.setBackgroundColor(-1);
            this.f51395e.addView(this.f51397g);
            String string = m.b(this.f51391a).getString("style");
            if (string != null && "qr".equals(string)) {
                a(this.f51395e);
            }
            setContentView(this.f51395e);
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.AuthDialog", "onCreateView exception", e4);
            com.tencent.open.a.a(this, this.f51394d);
        }
    }

    private void c() {
        TextView textView;
        this.f51398h = new ProgressBar(this.f51401k);
        this.f51398h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f51396f = new LinearLayout(this.f51401k);
        if (this.f51399i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f51401k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("\u767b\u5f55\u4e2d...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f51396f.setLayoutParams(layoutParams2);
        this.f51396f.addView(this.f51398h);
        if (textView != null) {
            this.f51396f.addView(textView);
        }
        this.f51397g = new FrameLayout(this.f51401k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f51397g.setLayoutParams(layoutParams3);
        this.f51397g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f51397g.addView(this.f51396f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f51400j.setVerticalScrollBarEnabled(false);
        this.f51400j.setHorizontalScrollBarEnabled(false);
        this.f51400j.setWebViewClient(new C1032a());
        this.f51400j.setWebChromeClient(new WebChromeClient());
        this.f51400j.clearFormData();
        this.f51400j.clearSslPreferences();
        this.f51400j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f51400j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action == 0 || action == 1) && !view.hasFocus()) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        WebSettings settings = this.f51400j.getSettings();
        com.tencent.open.web.a.a(this.f51400j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f51401k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f51391a);
        String str = this.f51391a;
        this.f51405o = str;
        this.f51400j.loadUrl(str);
        this.f51400j.setVisibility(4);
        this.f51402l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f51406p) && this.f51406p.length() >= 4) {
            String str2 = this.f51406p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f51391a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f51401k);
        int a4 = com.tencent.connect.avatar.a.a(this.f51401k, 15.6f);
        int a5 = com.tencent.connect.avatar.a.a(this.f51401k, 25.2f);
        int a6 = com.tencent.connect.avatar.a.a(this.f51401k, 10.0f);
        int i4 = a6 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4 + i4, a5 + i4);
        layoutParams.leftMargin = a6;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(a6, a6, a6, a6);
        imageView.setImageDrawable(m.a("h5_qr_back.png", this.f51401k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f51403m || a.this.f51392b == null) {
                    return;
                }
                a.this.f51392b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d4 = m.d(str);
            int i4 = d4.getInt("type");
            Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), d4.getString("msg"), i4).show();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f51400j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
