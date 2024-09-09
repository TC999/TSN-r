package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private final d f4424a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4425b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4426c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f4427d = "";

    /* renamed from: f  reason: collision with root package name */
    private boolean f4429f = false;

    /* renamed from: e  reason: collision with root package name */
    private Queue<String> f4428e = new PriorityQueue();

    public a(d dVar, Context context) {
        this.f4424a = dVar;
        this.f4425b = context;
    }

    private boolean a(String str) {
        boolean z3 = false;
        try {
            Intent a4 = str.startsWith("android-app://") ? Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.ad.a.a(str, 2) : null : cn.jpush.android.ad.a.a(str, 1);
            Context context = this.f4425b;
            if (context != null && a4 != null) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && packageManager.resolveActivity(a4, 0) == null) {
                    Logger.w("JPushWebViewClient", "open deeplink intent can be not resolved, url: " + str);
                    return true;
                }
                a4.addCategory("android.intent.category.BROWSABLE");
                if (!str.startsWith("android-app://")) {
                    a4.setComponent(null);
                }
                Intent a5 = cn.jpush.android.ad.a.a(str, 0);
                a5.setFlags(268435456);
                this.f4425b.startActivity(a5);
                Logger.d("JPushWebViewClient", "h5 open deeplink success, url: " + str);
            }
            z3 = true;
        } catch (Throwable th) {
            Logger.w("JPushWebViewClient", "[openDeeplink] Bad URI " + str + ": " + th.getMessage());
        }
        long j4 = z3 ? 976L : 977L;
        d dVar = this.f4424a;
        byte b4 = dVar.ah;
        if (b4 == 0) {
            cn.jpush.android.helper.c.a(dVar.f4127d, j4, this.f4425b);
        } else {
            cn.jpush.android.helper.c.a(dVar.f4127d, "", b4, j4, this.f4425b);
        }
        return z3;
    }

    public void a(boolean z3) {
        this.f4429f = z3;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f4427d = str;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i4, String str, String str2) {
        super.onReceivedError(webView, i4, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Logger.ww("JPushWebViewClient", "onReceivedSslError stop show:" + webView.getUrl());
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb;
        String str2;
        String str3 = str;
        Context context = webView.getContext();
        Logger.i("JPushWebViewClient", "Url vaule is :" + str3);
        try {
            webView.getSettings().setSavePassword(false);
            cn.jpush.android.ad.a.a(webView);
            String format = String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", str3);
            if (str3.endsWith(".mp3")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "audio/*");
                webView.getContext().startActivity(intent);
                return true;
            }
            if (!str3.endsWith(".mp4") && !str3.endsWith(".3gp")) {
                if (str3.endsWith(".apk")) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } else if (str3.startsWith("http")) {
                    d dVar = this.f4424a;
                    byte b4 = dVar.ah;
                    if (b4 == 0) {
                        cn.jpush.android.helper.c.a(dVar.f4127d, 1016L, format, this.f4425b);
                    } else {
                        cn.jpush.android.helper.c.a(dVar.f4127d, "", b4, 1016L, this.f4425b, null, format);
                    }
                    return false;
                } else if (str3.startsWith("mailto")) {
                    if (str3.lastIndexOf("direct=") < 0 && !str3.startsWith("mailto")) {
                        if (str3.indexOf("?") > 0) {
                            sb = new StringBuilder();
                            sb.append(str3);
                            str2 = "&direct=false";
                        } else {
                            sb = new StringBuilder();
                            sb.append(str3);
                            str2 = "?direct=false";
                        }
                        sb.append(str2);
                        str3 = sb.toString();
                        str3.lastIndexOf("direct=");
                    }
                    int indexOf = str3.indexOf("?");
                    String substring = str3.substring(0, indexOf);
                    String substring2 = str3.substring(indexOf);
                    Logger.v("JPushWebViewClient", "Uri: " + substring);
                    Logger.v("JPushWebViewClient", "QueryString: " + substring2);
                    Intent intent2 = null;
                    if (substring.startsWith("mailto")) {
                        String[] split = substring.split(":");
                        if (split.length == 2) {
                            int indexOf2 = substring2.indexOf("&content=");
                            String substring3 = substring2.substring(substring2.indexOf("title=") + 6, indexOf2);
                            String substring4 = substring2.substring(indexOf2 + 9);
                            String[] strArr = {split[1]};
                            Intent intent3 = new Intent("android.intent.action.SEND");
                            intent3.setType("plain/text");
                            intent3.putExtra("android.intent.extra.EMAIL", strArr);
                            intent3.putExtra("android.intent.extra.SUBJECT", substring3);
                            intent3.putExtra("android.intent.extra.TEXT", substring4);
                            intent2 = intent3;
                        }
                    }
                    if (intent2 != null) {
                        context.startActivity(intent2);
                    }
                    d dVar2 = this.f4424a;
                    byte b5 = dVar2.ah;
                    if (b5 == 0) {
                        cn.jpush.android.helper.c.a(dVar2.f4127d, 1016L, format, this.f4425b);
                    } else {
                        cn.jpush.android.helper.c.a(dVar2.f4127d, "", b5, 1016L, this.f4425b, null, format);
                    }
                    return true;
                } else {
                    return a(str3);
                }
            }
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.setDataAndType(Uri.parse(str), "video/*");
            webView.getContext().startActivity(intent4);
            return true;
        } catch (Throwable unused) {
            Logger.e("JPushWebViewClient", "Invalid url");
            return true;
        }
    }
}
