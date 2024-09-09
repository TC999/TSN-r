package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends AlertDialog {
    protected static volatile AtomicInteger sr = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private String f35442a;
    private com.bytedance.sdk.openadsdk.core.dislike.xv.w bk;

    /* renamed from: c  reason: collision with root package name */
    protected SSWebView f35443c;
    private TextView ev;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f35444f;
    private FrameLayout fp;
    private TextView gd;
    private int ia;

    /* renamed from: k  reason: collision with root package name */
    private Intent f35445k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.c f35446p;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f35447r;

    /* renamed from: t  reason: collision with root package name */
    private TTViewStub f35448t;
    private LinearLayout ux;

    /* renamed from: w  reason: collision with root package name */
    protected Context f35449w;
    protected c xv;
    private TTViewStub ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);
    }

    public p(Context context, Intent intent) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.ia = 0;
        this.f35449w = context;
        this.f35445k = intent;
    }

    static /* synthetic */ int w(p pVar) {
        int i4 = pVar.ia;
        pVar.ia = i4 - 1;
        return i4;
    }

    static /* synthetic */ int xv(p pVar) {
        int i4 = pVar.ia;
        pVar.ia = i4 + 1;
        return i4;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        sr.set(0);
        c cVar = this.xv;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        me meVar;
        super.onCreate(bundle);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.f35449w);
        this.ux = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.ux.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.ux.setOrientation(1);
        this.f35443c = new SSWebView(this.f35449w);
        if (this.f35445k != null && (meVar = TTDelegateActivity.f31813c) != null) {
            this.bk = meVar.ve();
            this.f35442a = this.f35445k.getStringExtra("event_tag");
        }
        setContentView(com.bytedance.sdk.openadsdk.res.ux.pr(this.f35449w));
        w();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        getWindow().getAttributes().height = xk.ux(this.f35449w) - xk.ux(this.f35449w, 50.0f);
    }

    private void xv() {
        TTViewStub tTViewStub;
        this.fp = (FrameLayout) findViewById(2114387633);
        this.f35448t = (TTViewStub) findViewById(2114387772);
        this.ys = (TTViewStub) findViewById(2114387794);
        this.fp.addView(this.f35443c, new LinearLayout.LayoutParams(-1, -1));
        int ys = com.bytedance.sdk.openadsdk.core.k.sr().ys();
        if (ys == 0) {
            TTViewStub tTViewStub2 = this.f35448t;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (ys == 1 && (tTViewStub = this.ys) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387704);
        this.f35444f = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.p.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    p.sr.set(0);
                    SSWebView sSWebView = p.this.f35443c;
                    if (sSWebView != null && sSWebView.sr() && p.this.ia > 1) {
                        p.this.f35443c.ux();
                        p.w(p.this);
                        return;
                    }
                    p.this.dismiss();
                    p pVar = p.this;
                    c cVar = pVar.xv;
                    if (cVar != null) {
                        cVar.c(pVar);
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387703);
        this.f35447r = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.p.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    p.sr.set(0);
                    p.this.dismiss();
                    p pVar = p.this;
                    c cVar = pVar.xv;
                    if (cVar != null) {
                        cVar.c(pVar);
                    }
                }
            });
        }
        this.ev = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387626);
        this.gd = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.p.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    p.this.c();
                }
            });
        }
    }

    protected void c() {
        com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar;
        Context context = this.f35449w;
        if (context == null || (wVar = this.bk) == null) {
            return;
        }
        if (this.f35446p == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(context, wVar, this.f35442a, true);
            this.f35446p = cVar;
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.f35449w, cVar, TTDelegateActivity.f31813c);
        }
        this.f35446p.c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void w() {
        me meVar;
        xv();
        if (this.ev != null && (meVar = TTDelegateActivity.f31813c) != null && !TextUtils.isEmpty(meVar.ny())) {
            this.ev.setText(TTDelegateActivity.f31813c.ny());
        }
        com.bytedance.sdk.openadsdk.core.widget.c.w.c(this.f35449w).c(false).w(false).c(this.f35443c.getWebView());
        this.f35443c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f35449w, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.p.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.ev = p.sr;
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
                            p.xv(p.this);
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
                this.ev = p.sr;
                return super.c(webView, str);
            }
        });
        this.f35443c.setJavaScriptEnabled(true);
        this.f35443c.setDisplayZoomControls(false);
        this.f35443c.setCacheMode(2);
        this.f35443c.c("https://phoniex.toutiao.com");
    }

    public p c(c cVar) {
        this.xv = cVar;
        return this;
    }
}
