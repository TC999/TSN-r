package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends AlertDialog {

    /* renamed from: f  reason: collision with root package name */
    protected static volatile AtomicInteger f35411f = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    protected SSWebView f35412c;

    /* renamed from: r  reason: collision with root package name */
    private String f35413r;
    protected String sr;
    protected c ux;

    /* renamed from: w  reason: collision with root package name */
    protected Context f35414w;
    protected TextView xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);
    }

    public f(Context context, String str, String str2) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.f35414w = context;
        this.f35413r = str2;
        this.sr = str;
    }

    protected void c() {
        this.f35412c = (SSWebView) findViewById(2114387842);
        this.xv = (TextView) findViewById(2114387917);
        ((TextView) findViewById(2114387695)).setText(this.f35413r);
        this.xv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.f35411f.set(0);
                f fVar = f.this;
                c cVar = fVar.ux;
                if (cVar != null) {
                    cVar.c(fVar);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.f35412c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f35414w, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.ev = f.f35411f;
                return super.c(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView != null) {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return true;
                        }
                        String scheme = Uri.parse(str).getScheme();
                        if (TextUtils.isEmpty(scheme)) {
                            return true;
                        }
                        String lowerCase = scheme.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("http") || lowerCase.contains("https")) {
                            webView.loadUrl(str);
                            return true;
                        }
                        return true;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return true;
                    }
                }
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, String str) {
                this.ev = f.f35411f;
                return super.c(webView, str);
            }
        });
        this.f35412c.setJavaScriptEnabled(true);
        this.f35412c.setDisplayZoomControls(false);
        this.f35412c.setCacheMode(2);
        this.f35412c.c(this.sr);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f35411f.set(0);
        c cVar = this.ux;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ux.ox(getContext()));
        c();
    }

    public f c(c cVar) {
        this.ux = cVar;
        return this;
    }
}
