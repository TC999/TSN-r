package com.acse.ottn.dsbridge;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
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
import com.acse.ottn.util.C1694ra;
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

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DWebView extends WebView {

    /* renamed from: a */
    private static final String f2844a = "_dsbridge";

    /* renamed from: b */
    private static final String f2845b = "dsBridge";

    /* renamed from: c */
    private static boolean f2846c;

    /* renamed from: d */
    private Map<String, Object> f2847d;

    /* renamed from: e */
    private String f2848e;

    /* renamed from: f */
    private int f2849f;

    /* renamed from: g */
    private WebChromeClient f2850g;

    /* renamed from: h */
    private volatile boolean f2851h;

    /* renamed from: i */
    private InterfaceC1538c f2852i;

    /* renamed from: j */
    private ArrayList<C1536a> f2853j;

    /* renamed from: k */
    private InnerJavascriptInterface f2854k;

    /* renamed from: l */
    private Handler f2855l;

    /* renamed from: m */
    Map<Integer, InterfaceC1550l> f2856m;

    /* renamed from: n */
    private WebChromeClient f2857n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.acse.ottn.dsbridge.DWebView$1 */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C15341 {
        C15341() {
        }

        @JavascriptInterface
        @Keep
        public String closePage(Object obj) throws JSONException {
            DWebView.this.m56477a(new RunnableC1540b(this));
            return null;
        }

        @JavascriptInterface
        @Keep
        public void disableJavascriptDialogBlock(Object obj) throws JSONException {
            DWebView.this.f2851h = !((JSONObject) obj).getBoolean("disable");
        }

        @JavascriptInterface
        @Keep
        public void dsinit(Object obj) {
            DWebView.this.m56471b();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
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
                java.lang.String[] r1 = com.acse.ottn.dsbridge.DWebView.m56463c(r2, r1)
                com.acse.ottn.dsbridge.DWebView r2 = com.acse.ottn.dsbridge.DWebView.this
                java.util.Map r2 = com.acse.ottn.dsbridge.DWebView.m56461d(r2)
                r3 = 0
                r4 = r1[r3]
                java.lang.Object r2 = r2.get(r4)
                if (r2 == 0) goto L79
                java.lang.Class r2 = r2.getClass()
                r4 = 0
                r5 = 1
                r6 = r1[r5]     // Catch: java.lang.Exception -> L44
                r7 = 2
                java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L44
                r7[r3] = r0     // Catch: java.lang.Exception -> L44
                java.lang.Class<com.acse.ottn.dsbridge.a> r8 = com.acse.ottn.dsbridge.InterfaceC1539a.class
                r7[r5] = r8     // Catch: java.lang.Exception -> L44
                java.lang.reflect.Method r4 = r2.getMethod(r6, r7)     // Catch: java.lang.Exception -> L44
                r0 = 1
                goto L4f
            L44:
                r1 = r1[r5]     // Catch: java.lang.Exception -> L4e
                java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L4e
                r6[r3] = r0     // Catch: java.lang.Exception -> L4e
                java.lang.reflect.Method r4 = r2.getMethod(r1, r6)     // Catch: java.lang.Exception -> L4e
            L4e:
                r0 = 0
            L4f:
                if (r4 == 0) goto L79
                java.lang.Class<android.webkit.JavascriptInterface> r1 = android.webkit.JavascriptInterface.class
                java.lang.annotation.Annotation r1 = r4.getAnnotation(r1)
                android.webkit.JavascriptInterface r1 = (android.webkit.JavascriptInterface) r1
                if (r1 != 0) goto L5c
                return r3
            L5c:
                java.lang.String r1 = "all"
                boolean r1 = r1.equals(r10)
                if (r1 != 0) goto L78
                if (r0 == 0) goto L6e
                java.lang.String r1 = "asyn"
                boolean r1 = r1.equals(r10)
                if (r1 != 0) goto L78
            L6e:
                if (r0 != 0) goto L79
                java.lang.String r0 = "syn"
                boolean r10 = r0.equals(r10)
                if (r10 == 0) goto L79
            L78:
                return r5
            L79:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.dsbridge.DWebView.C15341.hasNativeMethod(java.lang.Object):boolean");
        }

        @JavascriptInterface
        @Keep
        public void returnValue(Object obj) {
            DWebView.this.m56477a(new RunnableC1541c(this, obj));
        }
    }

    /* renamed from: com.acse.ottn.dsbridge.DWebView$6 */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C15356 extends WebChromeClient {
        C15356() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.getDefaultVideoPoster() : super.getDefaultVideoPoster();
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
        }

        @Override // android.webkit.WebChromeClient
        public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.getVisitedHistory(valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onConsoleMessage(str, i, str2);
            } else {
                super.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DWebView.this.f2851h) {
                jsResult.confirm();
            }
            if (DWebView.this.f2850g == null || !DWebView.this.f2850g.onJsAlert(webView, str, str2, jsResult)) {
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, new DialogInterface$OnClickListenerC1546h(this, jsResult)).create().show();
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (!DWebView.this.f2851h) {
                jsResult.confirm();
            }
            if (DWebView.this.f2850g == null || !DWebView.this.f2850g.onJsConfirm(webView, str, str2, jsResult)) {
                DialogInterface$OnClickListenerC1547i dialogInterface$OnClickListenerC1547i = new DialogInterface$OnClickListenerC1547i(this, jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(17039370, dialogInterface$OnClickListenerC1547i).setNegativeButton(17039360, dialogInterface$OnClickListenerC1547i).show();
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!DWebView.this.f2851h) {
                jsPromptResult.confirm();
            }
            if (DWebView.this.f2850g == null || !DWebView.this.f2850g.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str3);
                if (str3 != null) {
                    editText.setSelection(str3.length());
                }
                float f = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                DialogInterface$OnClickListenerC1548j dialogInterface$OnClickListenerC1548j = new DialogInterface$OnClickListenerC1548j(this, jsPromptResult, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(17039370, dialogInterface$OnClickListenerC1548j).setNegativeButton(17039360, dialogInterface$OnClickListenerC1548j).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f);
                editText.setPadding(i2 - ((int) (f * 5.0f)), i2, i2, i2);
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.onJsTimeout() : super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onPermissionRequest(permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onPermissionRequestCanceled(permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onProgressChanged(webView, i);
            } else {
                super.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onReceivedTouchIconUrl(webView, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(14)
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onShowCustomView(view, i, customViewCallback);
            } else {
                super.onShowCustomView(view, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (DWebView.this.f2850g != null) {
                DWebView.this.f2850g.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return DWebView.this.f2850g != null ? DWebView.this.f2850g.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Keep
        @TargetApi(11)
        public void openFileChooser(ValueCallback valueCallback, String str) {
            if (DWebView.this.f2850g instanceof InterfaceC1537b) {
                ((InterfaceC1537b) DWebView.this.f2850g).m56453a(valueCallback, str);
            }
        }

        @Keep
        @TargetApi(16)
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (DWebView.this.f2850g instanceof InterfaceC1537b) {
                ((InterfaceC1537b) DWebView.this.f2850g).m56452a(valueCallback, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class InnerJavascriptInterface {
        private InnerJavascriptInterface() {
        }

        /* synthetic */ InnerJavascriptInterface(DWebView dWebView, C15341 c15341) {
            this();
        }

        /* renamed from: a */
        private void m56455a(String str) {
            Log.d(DWebView.f2845b, str);
            if (DWebView.f2846c) {
                DWebView dWebView = DWebView.this;
                dWebView.m56476a(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
        @android.webkit.JavascriptInterface
        @androidx.annotation.Keep
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call(java.lang.String r14, java.lang.String r15) {
            /*
                Method dump skipped, instructions count: 247
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.dsbridge.DWebView.InnerJavascriptInterface.call(java.lang.String, java.lang.String):java.lang.String");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.dsbridge.DWebView$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1536a {

        /* renamed from: a */
        private String f2861a;

        /* renamed from: b */
        private int f2862b;

        /* renamed from: c */
        private String f2863c;

        C1536a(String str, int i, Object[] objArr) {
            this.f2861a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.f2862b = i;
            this.f2863c = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.f2863c);
                jSONObject.put("callbackId", this.f2862b);
                jSONObject.put("data", this.f2861a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    @Deprecated
    /* renamed from: com.acse.ottn.dsbridge.DWebView$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1537b {
        @TargetApi(11)
        /* renamed from: a */
        void m56453a(ValueCallback valueCallback, String str);

        @TargetApi(16)
        /* renamed from: a */
        void m56452a(ValueCallback<Uri> valueCallback, String str, String str2);
    }

    /* renamed from: com.acse.ottn.dsbridge.DWebView$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1538c {
        boolean onClose();
    }

    public DWebView(Context context) {
        super(context);
        this.f2847d = new HashMap();
        this.f2849f = 0;
        this.f2851h = true;
        this.f2852i = null;
        this.f2854k = new InnerJavascriptInterface(this, null);
        this.f2855l = new Handler(Looper.getMainLooper());
        this.f2856m = new HashMap();
        this.f2857n = new C15356();
        m56465c();
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2847d = new HashMap();
        this.f2849f = 0;
        this.f2851h = true;
        this.f2852i = null;
        this.f2854k = new InnerJavascriptInterface(this, null);
        this.f2855l = new Handler(Looper.getMainLooper());
        this.f2856m = new HashMap();
        this.f2857n = new C15356();
        m56465c();
    }

    /* renamed from: a */
    private void m56487a(C1536a c1536a) {
        m56476a(String.format("window._handleMessageFromNative(%s)", c1536a.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m56477a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f2855l.post(runnable);
        }
    }

    @Keep
    private void addInternalJavascriptObject() {
        m56478a(new C15341(), "_dsb");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m56471b() {
        ArrayList<C1536a> arrayList = this.f2853j;
        if (arrayList != null) {
            Iterator<C1536a> it = arrayList.iterator();
            while (it.hasNext()) {
                m56487a(it.next());
            }
            this.f2853j = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    /* renamed from: c */
    private void m56465c() {
        this.f2848e = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCachePath(this.f2848e);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.f2857n);
        addInternalJavascriptObject();
        super.addJavascriptInterface(this.f2854k, f2844a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m56462c(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            return;
        }
        super.loadUrl("javascript:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String[] m56459d(String str) {
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

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
        f2846c = z;
    }

    /* renamed from: a */
    public void m56479a(File file) {
        if (!file.exists()) {
            C1694ra.m55915b("Webview", "delete file no exists " + file.getAbsolutePath());
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m56479a(file2);
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public void m56478a(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.f2847d.put(str, obj);
        }
    }

    /* renamed from: a */
    public void m56476a(String str) {
        m56477a(new RunnableC1542d(this, str));
    }

    /* renamed from: a */
    public <T> void m56475a(String str, InterfaceC1550l<T> interfaceC1550l) {
        m56473a(str, (Object[]) null, interfaceC1550l);
    }

    /* renamed from: a */
    public void m56474a(String str, Object[] objArr) {
        m56473a(str, objArr, (InterfaceC1550l) null);
    }

    /* renamed from: a */
    public synchronized <T> void m56473a(String str, Object[] objArr, InterfaceC1550l<T> interfaceC1550l) {
        int i = this.f2849f + 1;
        this.f2849f = i;
        C1536a c1536a = new C1536a(str, i, objArr);
        if (interfaceC1550l != null) {
            this.f2856m.put(Integer.valueOf(c1536a.f2862b), interfaceC1550l);
        }
        ArrayList<C1536a> arrayList = this.f2853j;
        if (arrayList != null) {
            arrayList.add(c1536a);
        } else {
            m56487a(c1536a);
        }
    }

    /* renamed from: a */
    public void m56472a(boolean z) {
        this.f2851h = !z;
    }

    /* renamed from: b */
    public void m56467b(String str) {
        if (str == null) {
            str = "";
        }
        this.f2847d.remove(str);
    }

    /* renamed from: b */
    public void m56466b(String str, InterfaceC1550l<Boolean> interfaceC1550l) {
        m56473a("_hasJavascriptMethod", new Object[]{str}, interfaceC1550l);
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        super.clearCache(z);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(this.f2848e);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            m56479a(file2);
        }
        if (file.exists()) {
            m56479a(file);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        m56477a(new RunnableC1543e(this, str));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        m56477a(new RunnableC1544f(this, str, map));
    }

    @Override // android.webkit.WebView
    public void reload() {
        m56477a(new RunnableC1545g(this));
    }

    public void setJavascriptCloseWindowListener(InterfaceC1538c interfaceC1538c) {
        this.f2852i = interfaceC1538c;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f2850g = webChromeClient;
    }
}
