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
import com.tencent.connect.common.Constants;
import com.tencent.open.C13006b;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13017h;
import com.tencent.open.p567c.C13026b;
import com.tencent.open.p567c.C13027c;
import com.tencent.open.utils.C13065j;
import com.tencent.open.utils.C13071m;
import com.tencent.open.web.C13074a;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.ccg.CcgConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TDialog extends AbstractDialogC13022c {

    /* renamed from: c */
    static final FrameLayout.LayoutParams f37238c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    static Toast f37239d = null;

    /* renamed from: f */
    private static WeakReference<ProgressDialog> f37240f;

    /* renamed from: e */
    private WeakReference<Context> f37241e;

    /* renamed from: g */
    private String f37242g;

    /* renamed from: h */
    private OnTimeListener f37243h;

    /* renamed from: i */
    private IUiListener f37244i;

    /* renamed from: j */
    private FrameLayout f37245j;

    /* renamed from: k */
    private C13026b f37246k;

    /* renamed from: l */
    private Handler f37247l;

    /* renamed from: m */
    private boolean f37248m;

    /* renamed from: n */
    private QQToken f37249n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f37246k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.m15123v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TDialog.this.f37243h.onError(new UiError(i, str, str2));
            if (TDialog.this.f37241e != null && TDialog.this.f37241e.get() != null) {
                Toast.makeText((Context) TDialog.this.f37241e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            SLog.m15123v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(C13065j.m15004a().m15003a((Context) TDialog.this.f37241e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f37243h.onComplete(C13071m.m14936c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f37243h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    if (TDialog.this.f37241e != null && TDialog.this.f37241e.get() != null) {
                        ((Context) TDialog.this.f37241e.get()).startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class JsListener extends C13006b.C13008b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.m15131d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.m15129e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f37247l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.m15129e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CommonNetImpl.CANCEL);
        }

        public void onCancelInvite() {
            SLog.m15129e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f37247l.obtainMessage(1, str).sendToTarget();
            SLog.m15129e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f37247l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f37247l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a */
        String f37253a;

        /* renamed from: b */
        String f37254b;

        /* renamed from: c */
        private WeakReference<Context> f37255c;

        /* renamed from: d */
        private String f37256d;

        /* renamed from: e */
        private IUiListener f37257e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f37255c = new WeakReference<>(context);
            this.f37256d = str;
            this.f37253a = str2;
            this.f37254b = str3;
            this.f37257e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f37257e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f37257e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C13017h m15165a = C13017h.m15165a();
            m15165a.m15160a(this.f37256d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f37253a, false);
            IUiListener iUiListener = this.f37257e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f37257e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f37253a;
            } else {
                str = this.f37253a;
            }
            C13017h m15165a = C13017h.m15165a();
            m15165a.m15160a(this.f37256d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f37257e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f37257e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m15231a(String str) {
            try {
                onComplete(C13071m.m14933d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class THandler extends Handler {

        /* renamed from: b */
        private OnTimeListener f37259b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f37259b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.m15131d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.f37259b.m15231a((String) message.obj);
            } else if (i == 2) {
                this.f37259b.onCancel();
            } else if (i != 3) {
                if (i != 5 || TDialog.this.f37241e == null || TDialog.this.f37241e.get() == null) {
                    return;
                }
                TDialog.m15234d((Context) TDialog.this.f37241e.get(), (String) message.obj);
            } else if (TDialog.this.f37241e == null || TDialog.this.f37241e.get() == null) {
            } else {
                TDialog.m15236c((Context) TDialog.this.f37241e.get(), (String) message.obj);
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f37248m = false;
        this.f37249n = null;
        this.f37241e = new WeakReference<>(context);
        this.f37242g = str2;
        this.f37243h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f37247l = new THandler(this.f37243h, context.getMainLooper());
        this.f37244i = iUiListener;
        this.f37249n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f37243h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.AbstractDialogC13022c, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        C12995a.m15229a(getWindow());
        m15242a();
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
        m15239b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m15236c(Context context, String str) {
        try {
            JSONObject m14933d = C13071m.m14933d(str);
            int i = m14933d.getInt("type");
            String string = m14933d.getString("msg");
            if (i == 0) {
                Toast toast = f37239d;
                if (toast == null) {
                    f37239d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f37239d.setText(string);
                    f37239d.setDuration(0);
                }
                f37239d.show();
            } else if (i == 1) {
                Toast toast2 = f37239d;
                if (toast2 == null) {
                    f37239d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f37239d.setText(string);
                    f37239d.setDuration(1);
                }
                f37239d.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m15234d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject m14933d = C13071m.m14933d(str);
            int i = m14933d.getInt(CcgConstant.f38549t);
            String string = m14933d.getString("msg");
            if (i == 1) {
                WeakReference<ProgressDialog> weakReference = f37240f;
                if (weakReference != null && weakReference.get() != null) {
                    f37240f.get().setMessage(string);
                    if (!f37240f.get().isShowing()) {
                        f37240f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f37240f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i == 0) {
                WeakReference<ProgressDialog> weakReference2 = f37240f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f37240f.get().isShowing()) {
                    f37240f.get().dismiss();
                    f37240f = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m15242a() {
        try {
            new TextView(this.f37241e.get()).setText("test");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            C13026b c13026b = new C13026b(this.f37241e.get());
            this.f37246k = c13026b;
            c13026b.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            C13027c c13027c = new C13027c(this.f37241e.get());
            this.f37245j = c13027c;
            c13027c.setLayoutParams(layoutParams);
            this.f37245j.setBackgroundColor(-1);
            this.f37245j.addView(this.f37246k);
            setContentView(this.f37245j);
        } catch (Throwable th) {
            SLog.m15128e("openSDK_LOG.TDialog", "onCreateView exception", th);
            C12995a.m15230a(this, this.f37247l);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    private void m15239b() {
        this.f37246k.setVerticalScrollBarEnabled(false);
        this.f37246k.setHorizontalScrollBarEnabled(false);
        this.f37246k.setWebViewClient(new FbWebViewClient());
        this.f37246k.setWebChromeClient(this.f37324b);
        this.f37246k.clearFormData();
        WebSettings settings = this.f37246k.getSettings();
        if (settings == null) {
            return;
        }
        C13074a.m14910a(this.f37246k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f37241e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f37241e.get().getApplicationContext()).getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f37323a.m15199a(new JsListener(), "sdk_js_if");
        this.f37246k.loadUrl(this.f37242g);
        this.f37246k.setLayoutParams(f37238c);
        this.f37246k.setVisibility(4);
    }

    @Override // com.tencent.open.AbstractDialogC13022c
    /* renamed from: a */
    protected void mo15147a(String str) {
        SLog.m15131d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f37323a.mo14905a(this.f37246k, str);
        } catch (Exception unused) {
        }
    }
}
