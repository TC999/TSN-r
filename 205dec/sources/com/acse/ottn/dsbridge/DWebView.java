package com.acse.ottn.dsbridge;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.k0;
import com.acse.ottn.t2;
import com.acse.ottn.z1;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DWebView extends WebView {

    /* renamed from: l  reason: collision with root package name */
    public static final String f5550l = "_dsbridge";

    /* renamed from: m  reason: collision with root package name */
    public static final String f5551m = "dsBridge";

    /* renamed from: n  reason: collision with root package name */
    public static boolean f5552n;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f5553a;

    /* renamed from: b  reason: collision with root package name */
    public String f5554b;

    /* renamed from: c  reason: collision with root package name */
    public int f5555c;

    /* renamed from: d  reason: collision with root package name */
    public WebChromeClient f5556d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5557e;

    /* renamed from: f  reason: collision with root package name */
    public g f5558f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<e> f5559g;

    /* renamed from: h  reason: collision with root package name */
    public InnerJavascriptInterface f5560h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f5561i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, t2> f5562j;

    /* renamed from: k  reason: collision with root package name */
    public WebChromeClient f5563k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* renamed from: com.acse.ottn.dsbridge.DWebView$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class AnonymousClass1 {

        /* renamed from: com.acse.ottn.dsbridge.DWebView$1$a */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (DWebView.this.f5558f == null || DWebView.this.f5558f.onClose()) {
                    Context context = DWebView.this.getContext();
                    if (context instanceof Activity) {
                        ((Activity) context).onBackPressed();
                    }
                }
            }
        }

        /* renamed from: com.acse.ottn.dsbridge.DWebView$1$b */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f5566a;

            public b(Object obj) {
                this.f5566a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = (JSONObject) this.f5566a;
                try {
                    int i4 = jSONObject.getInt("id");
                    boolean z3 = jSONObject.getBoolean(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    t2 t2Var = DWebView.this.f5562j.get(Integer.valueOf(i4));
                    Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
                    if (t2Var != null) {
                        t2Var.a(obj);
                        if (z3) {
                            DWebView.this.f5562j.remove(Integer.valueOf(i4));
                        }
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }

        public AnonymousClass1() {
        }

        @JavascriptInterface
        @Keep
        public String closePage(Object obj) throws JSONException {
            DWebView.this.a(new a());
            return null;
        }

        @JavascriptInterface
        @Keep
        public void disableJavascriptDialogBlock(Object obj) throws JSONException {
            DWebView.this.f5557e = !((JSONObject) obj).getBoolean("disable");
        }

        @JavascriptInterface
        @Keep
        public void dsinit(Object obj) {
            DWebView.this.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
        @android.webkit.JavascriptInterface
        @androidx.annotation.Keep
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean hasNativeMethod(java.lang.Object r10) throws org.json.JSONException {
            /*
                r9 = this;
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                org.json.JSONObject r10 = (org.json.JSONObject) r10
                java.lang.String r1 = "name"
                java.lang.String r1 = r10.getString(r1)
                java.lang.String r1 = r1.trim()
                java.lang.String r2 = "type"
                java.lang.String r10 = r10.getString(r2)
                java.lang.String r10 = r10.trim()
                com.acse.ottn.dsbridge.DWebView r2 = com.acse.ottn.dsbridge.DWebView.this
                java.lang.String[] r1 = com.acse.ottn.dsbridge.DWebView.c(r2, r1)
                com.acse.ottn.dsbridge.DWebView r2 = com.acse.ottn.dsbridge.DWebView.this
                java.util.Map r2 = com.acse.ottn.dsbridge.DWebView.d(r2)
                r3 = 0
                r4 = r1[r3]
                java.lang.Object r2 = r2.get(r4)
                if (r2 == 0) goto L7b
                java.lang.Class r2 = r2.getClass()
                r4 = 0
                r5 = 1
                r6 = r1[r5]     // Catch: java.lang.Exception -> L45
                r7 = 2
                java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L45
                r7[r3] = r0     // Catch: java.lang.Exception -> L45
                java.lang.Class<com.acse.ottn.k0> r8 = com.acse.ottn.k0.class
                r7[r5] = r8     // Catch: java.lang.Exception -> L45
                java.lang.reflect.Method r4 = r2.getMethod(r6, r7)     // Catch: java.lang.Exception -> L45
                r0 = 1
                goto L50
            L45:
                r1 = r1[r5]     // Catch: java.lang.Exception -> L4f
                java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L4f
                r6[r3] = r0     // Catch: java.lang.Exception -> L4f
                java.lang.reflect.Method r4 = r2.getMethod(r1, r6)     // Catch: java.lang.Exception -> L4f
            L4f:
                r0 = 0
            L50:
                if (r4 == 0) goto L7b
                java.lang.Class<android.webkit.JavascriptInterface> r1 = android.webkit.JavascriptInterface.class
                java.lang.annotation.Annotation r1 = r4.getAnnotation(r1)
                android.webkit.JavascriptInterface r1 = (android.webkit.JavascriptInterface) r1
                if (r1 != 0) goto L5d
                return r3
            L5d:
                java.lang.String r1 = "all"
                boolean r1 = r1.equals(r10)
                if (r1 != 0) goto L7a
                if (r0 == 0) goto L6f
                java.lang.String r1 = "asyn"
                boolean r1 = r1.equals(r10)
                if (r1 != 0) goto L7a
            L6f:
                if (r0 != 0) goto L7b
                java.lang.String r0 = "syn"
                boolean r10 = r0.equals(r10)
                if (r10 == 0) goto L7b
            L7a:
                return r5
            L7b:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.dsbridge.DWebView.AnonymousClass1.hasNativeMethod(java.lang.Object):boolean");
        }

        @JavascriptInterface
        @Keep
        public void returnValue(Object obj) {
            DWebView.this.a(new b(obj));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class InnerJavascriptInterface {

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements k0 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f5577a;

            public a(String str) {
                this.f5577a = str;
            }

            @Override // com.acse.ottn.k0
            public void a() {
                a(null, true);
            }

            @Override // com.acse.ottn.k0
            public void b(Object obj) {
                a(obj, true);
            }

            @Override // com.acse.ottn.k0
            public void a(Object obj) {
                a(obj, false);
            }

            public final void a(Object obj, boolean z3) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("data", obj);
                    String str = this.f5577a;
                    if (str != null) {
                        String format = String.format("%s(%s.data);", str, jSONObject.toString());
                        if (z3) {
                            format = format + "delete window." + this.f5577a;
                        }
                        DWebView.this.b(format);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }

        public InnerJavascriptInterface() {
        }

        public final void a(String str) {
            Log.d("dsBridge", str);
            if (DWebView.f5552n) {
                DWebView dWebView = DWebView.this;
                dWebView.b(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
        @android.webkit.JavascriptInterface
        @androidx.annotation.Keep
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call(java.lang.String r14, java.lang.String r15) {
            /*
                Method dump skipped, instructions count: 277
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.dsbridge.DWebView.InnerJavascriptInterface.call(java.lang.String, java.lang.String):java.lang.String");
        }

        public /* synthetic */ InnerJavascriptInterface(DWebView dWebView, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5579a;

        public a(String str) {
            this.f5579a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.a(this.f5579a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5581a;

        public b(String str) {
            this.f5581a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f5581a;
            if (str != null && str.startsWith("javascript:")) {
                DWebView.super.loadUrl(this.f5581a);
                return;
            }
            DWebView.this.f5559g = new ArrayList();
            DWebView.super.loadUrl(this.f5581a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5583a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f5584b;

        public c(String str, Map map) {
            this.f5583a = str;
            this.f5584b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f5583a;
            if (str == null || !str.startsWith("javascript:")) {
                DWebView.this.f5559g = new ArrayList();
                DWebView.super.loadUrl(this.f5583a, this.f5584b);
                return;
            }
            DWebView.super.loadUrl(this.f5583a, this.f5584b);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.f5559g = new ArrayList();
            DWebView.super.reload();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f5587a;

        /* renamed from: b  reason: collision with root package name */
        public int f5588b;

        /* renamed from: c  reason: collision with root package name */
        public String f5589c;

        public e(String str, int i4, Object[] objArr) {
            this.f5587a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.f5588b = i4;
            this.f5589c = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.f5589c);
                jSONObject.put("callbackId", this.f5588b);
                jSONObject.put("data", this.f5587a);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    @Deprecated
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface f {
        @TargetApi(11)
        void a(ValueCallback valueCallback, String str);

        @TargetApi(16)
        void a(ValueCallback<Uri> valueCallback, String str, String str2);
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface g {
        boolean onClose();
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5553a = new HashMap();
        this.f5555c = 0;
        this.f5557e = true;
        this.f5558f = null;
        this.f5560h = new InnerJavascriptInterface(this, null);
        this.f5561i = new Handler(Looper.getMainLooper());
        this.f5562j = new HashMap();
        this.f5563k = new AnonymousClass6();
        c();
    }

    @Keep
    private void addInternalJavascriptObject() {
        a(new AnonymousClass1(), "_dsb");
    }

    public static void setWebContentsDebuggingEnabled(boolean z3) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z3);
        }
        f5552n = z3;
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z3) {
        super.clearCache(z3);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        File file = new File(this.f5554b);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            a(file2);
        }
        if (file.exists()) {
            a(file);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(new b(str));
    }

    @Override // android.webkit.WebView
    public void reload() {
        a(new d());
    }

    public void setJavascriptCloseWindowListener(g gVar) {
        this.f5558f = gVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f5556d = webChromeClient;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* renamed from: com.acse.ottn.dsbridge.DWebView$6  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class AnonymousClass6 extends WebChromeClient {

        /* renamed from: com.acse.ottn.dsbridge.DWebView$6$a */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f5569a;

            public a(JsResult jsResult) {
                this.f5569a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
                if (DWebView.this.f5557e) {
                    this.f5569a.confirm();
                }
            }
        }

        /* renamed from: com.acse.ottn.dsbridge.DWebView$6$b */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f5571a;

            public b(JsResult jsResult) {
                this.f5571a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (DWebView.this.f5557e) {
                    if (i4 == -1) {
                        this.f5571a.confirm();
                    } else {
                        this.f5571a.cancel();
                    }
                }
            }
        }

        /* renamed from: com.acse.ottn.dsbridge.DWebView$6$c */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class c implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f5573a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EditText f5574b;

            public c(JsPromptResult jsPromptResult, EditText editText) {
                this.f5573a = jsPromptResult;
                this.f5574b = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (DWebView.this.f5557e) {
                    if (i4 == -1) {
                        this.f5573a.confirm(this.f5574b.getText().toString());
                    } else {
                        this.f5573a.cancel();
                    }
                }
            }
        }

        public AnonymousClass6() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return DWebView.this.f5556d != null ? DWebView.this.f5556d.getDefaultVideoPoster() : super.getDefaultVideoPoster();
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return DWebView.this.f5556d != null ? DWebView.this.f5556d.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
        }

        @Override // android.webkit.WebChromeClient
        public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.getVisitedHistory(valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i4, String str2) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onConsoleMessage(str, i4, str2);
            } else {
                super.onConsoleMessage(str, i4, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z3, boolean z4, Message message) {
            return DWebView.this.f5556d != null ? DWebView.this.f5556d.onCreateWindow(webView, z3, z4, message) : super.onCreateWindow(webView, z3, z4, message);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j4, long j5, long j6, WebStorage.QuotaUpdater quotaUpdater) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onExceededDatabaseQuota(str, str2, j4, j5, j6, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j4, j5, j6, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DWebView.this.f5557e) {
                jsResult.confirm();
            }
            if (DWebView.this.f5556d == null || !DWebView.this.f5556d.onJsAlert(webView, str, str2, jsResult)) {
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, new a(jsResult)).create().show();
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return DWebView.this.f5556d != null ? DWebView.this.f5556d.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DWebView.this.f5557e) {
                jsResult.confirm();
            }
            if (DWebView.this.f5556d == null || !DWebView.this.f5556d.onJsConfirm(webView, str, str2, jsResult)) {
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, bVar).setNegativeButton(17039360, bVar).show();
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!DWebView.this.f5557e) {
                jsPromptResult.confirm();
            }
            if (DWebView.this.f5556d == null || !DWebView.this.f5556d.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str3);
                if (str3 != null) {
                    editText.setSelection(str3.length());
                }
                float f4 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(17039370, cVar).setNegativeButton(17039360, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i4 = (int) (16.0f * f4);
                layoutParams.setMargins(i4, 0, i4, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i5 = (int) (15.0f * f4);
                editText.setPadding(i5 - ((int) (f4 * 5.0f)), i5, i5, i5);
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            return DWebView.this.f5556d != null ? DWebView.this.f5556d.onJsTimeout() : super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onPermissionRequest(permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onPermissionRequestCanceled(permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i4) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onProgressChanged(webView, i4);
            } else {
                super.onProgressChanged(webView, i4);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z3) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onReceivedTouchIconUrl(webView, str, z3);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z3);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return DWebView.this.f5556d != null ? DWebView.this.f5556d.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Keep
        @TargetApi(11)
        public void openFileChooser(ValueCallback valueCallback, String str) {
            if (DWebView.this.f5556d instanceof f) {
                ((f) DWebView.this.f5556d).a(valueCallback, str);
            }
        }

        @Keep
        @TargetApi(16)
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (DWebView.this.f5556d instanceof f) {
                ((f) DWebView.this.f5556d).a(valueCallback, str, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (DWebView.this.f5556d != null) {
                return DWebView.this.f5556d.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(14)
        public void onShowCustomView(View view, int i4, WebChromeClient.CustomViewCallback customViewCallback) {
            if (DWebView.this.f5556d != null) {
                DWebView.this.f5556d.onShowCustomView(view, i4, customViewCallback);
            } else {
                super.onShowCustomView(view, i4, customViewCallback);
            }
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        a(new c(str, map));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public final void c() {
        this.f5554b = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.f5563k);
        addInternalJavascriptObject();
        super.addJavascriptInterface(this.f5560h, "_dsbridge");
    }

    public void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f5553a.remove(str);
    }

    public void b(String str) {
        a(new a(str));
    }

    public final synchronized void b() {
        ArrayList<e> arrayList = this.f5559g;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.f5559g = null;
        }
    }

    public final void a(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            return;
        }
        super.loadUrl("javascript:" + str);
    }

    public void b(String str, t2<Boolean> t2Var) {
        a("_hasJavascriptMethod", new Object[]{str}, t2Var);
    }

    public DWebView(Context context) {
        super(context);
        this.f5553a = new HashMap();
        this.f5555c = 0;
        this.f5557e = true;
        this.f5558f = null;
        this.f5560h = new InnerJavascriptInterface(this, null);
        this.f5561i = new Handler(Looper.getMainLooper());
        this.f5562j = new HashMap();
        this.f5563k = new AnonymousClass6();
        c();
    }

    public final void a(e eVar) {
        b(String.format("window._handleMessageFromNative(%s)", eVar.toString()));
    }

    public synchronized <T> void a(String str, Object[] objArr, t2<T> t2Var) {
        int i4 = this.f5555c + 1;
        this.f5555c = i4;
        e eVar = new e(str, i4, objArr);
        if (t2Var != null) {
            this.f5562j.put(Integer.valueOf(eVar.f5588b), t2Var);
        }
        ArrayList<e> arrayList = this.f5559g;
        if (arrayList != null) {
            arrayList.add(eVar);
        } else {
            a(eVar);
        }
    }

    public final String[] c(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            str = str.substring(lastIndexOf + 1);
        } else {
            str2 = "";
        }
        return new String[]{str2, str};
    }

    public void a(String str, Object[] objArr) {
        a(str, objArr, (t2) null);
    }

    public <T> void a(String str, t2<T> t2Var) {
        a(str, (Object[]) null, t2Var);
    }

    public void a(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.f5553a.put(str, obj);
        }
    }

    public void a(boolean z3) {
        this.f5557e = !z3;
    }

    public void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
            }
            file.delete();
            return;
        }
        z1.b("Webview", "delete file no exists " + file.getAbsolutePath());
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f5561i.post(runnable);
        }
    }
}
