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
import com.p518qq.p519e.comm.constants.ErrorCode;
import com.stub.StubApp;
import com.tencent.connect.auth.C12947b;
import com.tencent.connect.avatar.C12959a;
import com.tencent.connect.common.Constants;
import com.tencent.open.C12995a;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13017h;
import com.tencent.open.p567c.C13027c;
import com.tencent.open.p567c.C13028d;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.C13074a;
import com.tencent.open.web.security.C13076b;
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

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.auth.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DialogC12937a extends Dialog {

    /* renamed from: a */
    private String f37025a;

    /* renamed from: b */
    private C12944b f37026b;

    /* renamed from: c */
    private IUiListener f37027c;

    /* renamed from: d */
    private Handler f37028d;

    /* renamed from: e */
    private FrameLayout f37029e;

    /* renamed from: f */
    private LinearLayout f37030f;

    /* renamed from: g */
    private FrameLayout f37031g;

    /* renamed from: h */
    private ProgressBar f37032h;

    /* renamed from: i */
    private String f37033i;

    /* renamed from: j */
    private C13028d f37034j;

    /* renamed from: k */
    private Context f37035k;

    /* renamed from: l */
    private C13076b f37036l;

    /* renamed from: m */
    private boolean f37037m;

    /* renamed from: n */
    private int f37038n;

    /* renamed from: o */
    private String f37039o;

    /* renamed from: p */
    private String f37040p;

    /* renamed from: q */
    private long f37041q;

    /* renamed from: r */
    private long f37042r;

    /* renamed from: s */
    private HashMap<String, Runnable> f37043s;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12942a extends WebViewClient {
        private C12942a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.m15123v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            DialogC12937a.this.f37031g.setVisibility(8);
            if (DialogC12937a.this.f37034j != null) {
                DialogC12937a.this.f37034j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DialogC12937a.this.f37028d.removeCallbacks((Runnable) DialogC12937a.this.f37043s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.m15123v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            DialogC12937a.this.f37031g.setVisibility(0);
            DialogC12937a.this.f37041q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(DialogC12937a.this.f37039o)) {
                DialogC12937a.this.f37028d.removeCallbacks((Runnable) DialogC12937a.this.f37043s.remove(DialogC12937a.this.f37039o));
            }
            DialogC12937a.this.f37039o = str;
            DialogC12937a dialogC12937a = DialogC12937a.this;
            RunnableC12946d runnableC12946d = new RunnableC12946d(dialogC12937a.f37039o);
            DialogC12937a.this.f37043s.put(str, runnableC12946d);
            DialogC12937a.this.f37028d.postDelayed(runnableC12946d, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            SLog.m15127i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!C13071m.m14945b(DialogC12937a.this.f37035k)) {
                DialogC12937a.this.f37026b.onError(new UiError(ErrorCode.PrivateError.LOAD_FAIL, "当前网络不可用，请稍后重试！", str2));
                DialogC12937a.this.dismiss();
            } else if (!DialogC12937a.this.f37039o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - DialogC12937a.this.f37041q;
                if (DialogC12937a.this.f37038n >= 1 || elapsedRealtime >= DialogC12937a.this.f37042r) {
                    DialogC12937a.this.f37034j.loadUrl(DialogC12937a.this.m15431a());
                    return;
                }
                DialogC12937a.m15403m(DialogC12937a.this);
                DialogC12937a.this.f37028d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogC12937a.this.f37034j.loadUrl(DialogC12937a.this.f37039o);
                    }
                }, 500L);
            } else {
                DialogC12937a.this.f37026b.onError(new UiError(i, str, str2));
                DialogC12937a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.m15129e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            SLog.m15123v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject m14936c = C13071m.m14936c(str);
                DialogC12937a dialogC12937a = DialogC12937a.this;
                dialogC12937a.f37037m = dialogC12937a.m15412e();
                if (!DialogC12937a.this.f37037m) {
                    if (m14936c.optString("fail_cb", null) != null) {
                        DialogC12937a.this.m15423a(m14936c.optString("fail_cb"), "");
                    } else if (m14936c.optInt("fall_to_wv") == 1) {
                        DialogC12937a dialogC12937a2 = DialogC12937a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(DialogC12937a.this.f37025a);
                        sb.append(DialogC12937a.this.f37025a.indexOf("?") > -1 ? "&" : "?");
                        dialogC12937a2.f37025a = sb.toString();
                        DialogC12937a dialogC12937a3 = DialogC12937a.this;
                        dialogC12937a3.f37025a = DialogC12937a.this.f37025a + "browser_error=1";
                        DialogC12937a.this.f37034j.loadUrl(DialogC12937a.this.f37025a);
                    } else {
                        String optString = m14936c.optString("redir", null);
                        if (optString != null) {
                            DialogC12937a.this.f37034j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                DialogC12937a.this.f37026b.onComplete(C13071m.m14936c(str));
                DialogC12937a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                DialogC12937a.this.f37026b.onCancel();
                DialogC12937a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                DialogC12937a.this.dismiss();
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
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
                        DialogC12937a.this.f37031g.setVisibility(8);
                        DialogC12937a.this.f37034j.setVisibility(0);
                    } else if (intValue == 1) {
                        DialogC12937a.this.f37031g.setVisibility(0);
                    }
                    return true;
                } else if (!str.startsWith("auth://onLoginSubmit")) {
                    if (DialogC12937a.this.f37036l.mo14905a(DialogC12937a.this.f37034j, str)) {
                        return true;
                    }
                    SLog.m15127i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                    return false;
                } else {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            DialogC12937a.this.f37040p = pathSegments2.get(0);
                        }
                    } catch (Exception unused2) {
                    }
                    return true;
                }
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    DialogC12937a.this.f37035k.startActivity(intent);
                } catch (Exception e) {
                    SLog.m15128e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class C12944b extends DefaultUiListener {

        /* renamed from: a */
        String f37050a;

        /* renamed from: b */
        String f37051b;

        /* renamed from: d */
        private String f37053d;

        /* renamed from: e */
        private IUiListener f37054e;

        public C12944b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f37053d = str;
            this.f37050a = str2;
            this.f37051b = str3;
            this.f37054e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f37054e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f37054e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C13017h m15165a = C13017h.m15165a();
            m15165a.m15160a(this.f37053d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f37050a, false);
            IUiListener iUiListener = this.f37054e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f37054e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f37050a;
            } else {
                str = this.f37050a;
            }
            C13017h.m15165a().m15160a(this.f37053d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            DialogC12937a.this.m15424a(str);
            IUiListener iUiListener = this.f37054e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f37054e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m15398a(String str) {
            try {
                onComplete(C13071m.m14933d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class HandlerC12945c extends Handler {

        /* renamed from: b */
        private C12944b f37056b;

        public HandlerC12945c(C12944b c12944b, Looper looper) {
            super(looper);
            this.f37056b = c12944b;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.f37056b.m15398a((String) message.obj);
            } else if (i == 2) {
                this.f37056b.onCancel();
            } else if (i != 3) {
            } else {
                DialogC12937a.m15421b(DialogC12937a.this.f37035k, (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class RunnableC12946d implements Runnable {

        /* renamed from: a */
        String f37057a;

        public RunnableC12946d(String str) {
            this.f37057a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.m15123v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f37057a + " | mRetryUrl: " + DialogC12937a.this.f37039o);
            if (this.f37057a.equals(DialogC12937a.this.f37039o)) {
                DialogC12937a.this.f37026b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", DialogC12937a.this.f37039o));
                DialogC12937a.this.dismiss();
            }
        }
    }

    public DialogC12937a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f37037m = false;
        this.f37041q = 0L;
        this.f37042r = 30000L;
        this.f37035k = context;
        this.f37025a = str2;
        this.f37026b = new C12944b(str, str2, qQToken.getAppId(), iUiListener);
        this.f37028d = new HandlerC12945c(this.f37026b, context.getMainLooper());
        this.f37027c = iUiListener;
        this.f37033i = str;
        this.f37036l = new C13076b();
        getWindow().setSoftInputMode(32);
    }

    /* renamed from: m */
    static /* synthetic */ int m15403m(DialogC12937a dialogC12937a) {
        int i = dialogC12937a.f37038n;
        dialogC12937a.f37038n = i + 1;
        return i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f37043s.clear();
        this.f37028d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f37035k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.m15127i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        }
        C13028d c13028d = this.f37034j;
        if (c13028d != null) {
            c13028d.destroy();
            this.f37034j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f37037m) {
            this.f37026b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        C12995a.m15229a(getWindow());
        m15422b();
        m15415d();
        this.f37043s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m15412e() {
        C12947b m15397a = C12947b.m15397a();
        String m15394c = m15397a.m15394c();
        C12947b.C12948a c12948a = new C12947b.C12948a();
        c12948a.f37064a = this.f37027c;
        c12948a.f37065b = this;
        c12948a.f37066c = m15394c;
        String m15396a = m15397a.m15396a(c12948a);
        String str = this.f37025a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle m14942b = C13071m.m14942b(this.f37025a);
        m14942b.putString("token_key", m15394c);
        m14942b.putString("serial", m15396a);
        m14942b.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(m14942b);
        this.f37025a = str2;
        return C13071m.m14966a(this.f37035k, str2);
    }

    /* renamed from: b */
    private void m15422b() {
        try {
            m15418c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            C13028d c13028d = new C13028d(this.f37035k);
            this.f37034j = c13028d;
            c13028d.setLayerType(1, null);
            this.f37034j.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            C13027c c13027c = new C13027c(this.f37035k);
            c13027c.setLayoutParams(layoutParams);
            c13027c.addView(this.f37034j);
            FrameLayout frameLayout = new FrameLayout(this.f37035k);
            this.f37029e = frameLayout;
            frameLayout.addView(c13027c);
            this.f37029e.setBackgroundColor(-1);
            this.f37029e.addView(this.f37031g);
            String string = C13071m.m14942b(this.f37025a).getString("style");
            if (string != null && "qr".equals(string)) {
                m15429a(this.f37029e);
            }
            setContentView(this.f37029e);
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.AuthDialog", "onCreateView exception", e);
            C12995a.m15230a(this, this.f37028d);
        }
    }

    /* renamed from: c */
    private void m15418c() {
        TextView textView;
        this.f37032h = new ProgressBar(this.f37035k);
        this.f37032h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f37030f = new LinearLayout(this.f37035k);
        if (this.f37033i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f37035k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
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
        this.f37030f.setLayoutParams(layoutParams2);
        this.f37030f.addView(this.f37032h);
        if (textView != null) {
            this.f37030f.addView(textView);
        }
        this.f37031g = new FrameLayout(this.f37035k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f37031g.setLayoutParams(layoutParams3);
        this.f37031g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f37031g.addView(this.f37030f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: d */
    private void m15415d() {
        this.f37034j.setVerticalScrollBarEnabled(false);
        this.f37034j.setHorizontalScrollBarEnabled(false);
        this.f37034j.setWebViewClient(new C12942a());
        this.f37034j.setWebChromeClient(new WebChromeClient());
        this.f37034j.clearFormData();
        this.f37034j.clearSslPreferences();
        this.f37034j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f37034j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
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
        WebSettings settings = this.f37034j.getSettings();
        C13074a.m14910a(this.f37034j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f37035k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.m15123v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f37025a);
        String str = this.f37025a;
        this.f37039o = str;
        this.f37034j.loadUrl(str);
        this.f37034j.setVisibility(4);
        this.f37036l.m15199a(new SecureJsInterface(), "SecureJsInterface");
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
    /* renamed from: a */
    public String m15424a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f37040p) && this.f37040p.length() >= 4) {
            String str2 = this.f37040p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m15431a() {
        String str = this.f37025a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.m15127i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    /* renamed from: a */
    private void m15429a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f37035k);
        int m15331a = C12959a.m15331a(this.f37035k, 15.6f);
        int m15331a2 = C12959a.m15331a(this.f37035k, 25.2f);
        int m15331a3 = C12959a.m15331a(this.f37035k, 10.0f);
        int i = m15331a3 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m15331a + i, m15331a2 + i);
        layoutParams.leftMargin = m15331a3;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(m15331a3, m15331a3, m15331a3, m15331a3);
        imageView.setImageDrawable(C13071m.m14956a("h5_qr_back.png", this.f37035k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC12937a.this.dismiss();
                if (DialogC12937a.this.f37037m || DialogC12937a.this.f37026b == null) {
                    return;
                }
                DialogC12937a.this.f37026b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m15421b(Context context, String str) {
        try {
            JSONObject m14933d = C13071m.m14933d(str);
            int i = m14933d.getInt("type");
            Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), m14933d.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m15423a(String str, String str2) {
        this.f37034j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
