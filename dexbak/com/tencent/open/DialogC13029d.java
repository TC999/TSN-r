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
import com.tencent.connect.common.Constants;
import com.tencent.open.C13006b;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13017h;
import com.tencent.open.p567c.C13024a;
import com.tencent.open.p567c.C13026b;
import com.tencent.open.utils.C13065j;
import com.tencent.open.utils.C13071m;
import com.tencent.open.web.C13074a;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.ccg.CcgConstant;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DialogC13029d extends AbstractDialogC13022c implements C13024a.InterfaceC13025a {

    /* renamed from: c */
    static Toast f37333c;

    /* renamed from: d */
    private String f37334d;

    /* renamed from: e */
    private IUiListener f37335e;

    /* renamed from: f */
    private C13033c f37336f;

    /* renamed from: g */
    private Handler f37337g;

    /* renamed from: h */
    private C13024a f37338h;

    /* renamed from: i */
    private C13026b f37339i;

    /* renamed from: j */
    private WeakReference<Context> f37340j;

    /* renamed from: k */
    private int f37341k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13031a extends WebViewClient {
        private C13031a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            DialogC13029d.this.f37339i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.m15123v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            DialogC13029d.this.f37336f.onError(new UiError(i, str, str2));
            if (DialogC13029d.this.f37340j != null && DialogC13029d.this.f37340j.get() != null) {
                Toast.makeText((Context) DialogC13029d.this.f37340j.get(), "网络连接异常或系统错误", 0).show();
            }
            DialogC13029d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.m15123v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(C13065j.m15004a().m15003a((Context) DialogC13029d.this.f37340j.get(), "auth://tauth.qq.com/"))) {
                DialogC13029d.this.f37336f.onComplete(C13071m.m14936c(str));
                DialogC13029d.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                DialogC13029d.this.f37336f.onCancel();
                DialogC13029d.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                DialogC13029d.this.dismiss();
                return true;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13032b extends C13006b.C13008b {
        private C13032b() {
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13033c extends DefaultUiListener {

        /* renamed from: a */
        String f37344a;

        /* renamed from: b */
        String f37345b;

        /* renamed from: c */
        private WeakReference<Context> f37346c;

        /* renamed from: d */
        private String f37347d;

        /* renamed from: e */
        private IUiListener f37348e;

        public C13033c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f37346c = new WeakReference<>(context);
            this.f37347d = str;
            this.f37344a = str2;
            this.f37345b = str3;
            this.f37348e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f37348e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f37348e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C13017h m15165a = C13017h.m15165a();
            m15165a.m15160a(this.f37347d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f37344a, false);
            IUiListener iUiListener = this.f37348e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f37348e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f37344a;
            } else {
                str = this.f37344a;
            }
            C13017h m15165a = C13017h.m15165a();
            m15165a.m15160a(this.f37347d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f37348e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f37348e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m15138a(String str) {
            try {
                onComplete(C13071m.m14933d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class HandlerC13034d extends Handler {

        /* renamed from: b */
        private C13033c f37350b;

        public HandlerC13034d(C13033c c13033c, Looper looper) {
            super(looper);
            this.f37350b = c13033c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.m15131d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.f37350b.m15138a((String) message.obj);
            } else if (i == 2) {
                this.f37350b.onCancel();
            } else if (i != 3) {
                if (i != 5 || DialogC13029d.this.f37340j == null || DialogC13029d.this.f37340j.get() == null) {
                    return;
                }
                DialogC13029d.m15140d((Context) DialogC13029d.this.f37340j.get(), (String) message.obj);
            } else if (DialogC13029d.this.f37340j == null || DialogC13029d.this.f37340j.get() == null) {
            } else {
                DialogC13029d.m15142c((Context) DialogC13029d.this.f37340j.get(), (String) message.obj);
            }
        }
    }

    public DialogC13029d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f37340j = new WeakReference<>(context);
        this.f37334d = str2;
        this.f37336f = new C13033c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f37337g = new HandlerC13034d(this.f37336f, context.getMainLooper());
        this.f37335e = iUiListener;
        this.f37341k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.m15129e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f37341k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m15140d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject m14933d = C13071m.m14933d(str);
            m14933d.getInt(CcgConstant.f38549t);
            m14933d.getString("msg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.AbstractDialogC13022c, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        m15146b();
        m15143c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: c */
    private void m15143c() {
        this.f37339i.setVerticalScrollBarEnabled(false);
        this.f37339i.setHorizontalScrollBarEnabled(false);
        this.f37339i.setWebViewClient(new C13031a());
        this.f37339i.setWebChromeClient(this.f37324b);
        this.f37339i.clearFormData();
        WebSettings settings = this.f37339i.getSettings();
        if (settings == null) {
            return;
        }
        C13074a.m14910a(this.f37339i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f37340j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f37340j.get().getApplicationContext()).getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f37323a.m15199a(new C13032b(), "sdk_js_if");
        this.f37339i.clearView();
        this.f37339i.loadUrl(this.f37334d);
    }

    /* renamed from: b */
    private void m15146b() {
        C13024a c13024a = new C13024a(this.f37340j.get());
        this.f37338h = c13024a;
        c13024a.setBackgroundColor(1711276032);
        this.f37338h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        C13026b c13026b = new C13026b(this.f37340j.get());
        this.f37339i = c13026b;
        c13026b.setBackgroundColor(0);
        this.f37339i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f37339i, 1, new Paint());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f37341k);
        layoutParams.addRule(13, -1);
        this.f37339i.setLayoutParams(layoutParams);
        this.f37338h.addView(this.f37339i);
        this.f37338h.m15154a(this);
        setContentView(this.f37338h);
    }

    @Override // com.tencent.open.p567c.C13024a.InterfaceC13025a
    /* renamed from: a */
    public void mo15150a(int i) {
        WeakReference<Context> weakReference = this.f37340j;
        if (weakReference != null && weakReference.get() != null) {
            if (i < this.f37341k && 2 == this.f37340j.get().getResources().getConfiguration().orientation) {
                this.f37339i.getLayoutParams().height = i;
            } else {
                this.f37339i.getLayoutParams().height = this.f37341k;
            }
        }
        SLog.m15129e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.p567c.C13024a.InterfaceC13025a
    /* renamed from: a */
    public void mo15151a() {
        this.f37339i.getLayoutParams().height = this.f37341k;
        SLog.m15129e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.AbstractDialogC13022c
    /* renamed from: a */
    protected void mo15147a(String str) {
        SLog.m15131d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f37323a.mo14905a(this.f37339i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m15142c(Context context, String str) {
        try {
            JSONObject m14933d = C13071m.m14933d(str);
            int i = m14933d.getInt("type");
            String string = m14933d.getString("msg");
            if (i == 0) {
                Toast toast = f37333c;
                if (toast == null) {
                    f37333c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f37333c.setText(string);
                    f37333c.setDuration(0);
                }
                f37333c.show();
            } else if (i == 1) {
                Toast toast2 = f37333c;
                if (toast2 == null) {
                    f37333c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f37333c.setText(string);
                    f37333c.setDuration(1);
                }
                f37333c.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
