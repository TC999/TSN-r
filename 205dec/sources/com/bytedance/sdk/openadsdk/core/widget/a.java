package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    protected static volatile AtomicInteger f35374c = new AtomicInteger(0);
    private RelativeLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private c f35375f;
    private RelativeLayout gd;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f35376k;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f35377p;

    /* renamed from: r  reason: collision with root package name */
    private String f35378r;
    private TextView sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private SSWebView f35379w;
    private Context xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);
    }

    public a(Context context, String str) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.f35378r = str;
        this.xv = context;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f35374c.set(0);
        c cVar = this.f35375f;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ux.gw(this.xv));
        w();
        c();
    }

    protected void c() {
        String zr = ls.w().zr();
        if (TextUtils.isEmpty(zr)) {
            this.ux = "https://www.pangle.cn/privacy/partner";
        } else {
            this.ux = zr;
        }
        if (TextUtils.isEmpty(this.f35378r)) {
            return;
        }
        if (this.ux.contains("?")) {
            this.ux += "&ad_info=" + this.f35378r;
            return;
        }
        this.ux += "?ad_info=" + this.f35378r;
    }

    protected void w() {
        this.f35379w = (SSWebView) findViewById(2114387765);
        TextView textView = (TextView) findViewById(2114387651);
        this.sr = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f35375f != null) {
                    a.this.f35375f.c(a.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.f35379w.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.xv, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.ev = a.f35374c;
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
                        String lowerCase = scheme.toLowerCase(Locale.US);
                        if (lowerCase.contains("http") || lowerCase.contains("https")) {
                            webView.loadUrl(str);
                            return true;
                        }
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                }
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, String str) {
                this.ev = a.f35374c;
                return super.c(webView, str);
            }
        });
        this.f35379w.setJavaScriptEnabled(true);
        this.f35379w.setDisplayZoomControls(false);
        this.f35379w.setCacheMode(2);
        this.f35379w.c(this.ux);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387886);
        this.ev = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387898);
        this.gd = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.sr.setVisibility(8);
        this.f35377p = (ImageView) findViewById(2114387816);
        this.f35376k = (ImageView) findViewById(2114387839);
        this.f35377p.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f35375f != null) {
                    a.this.f35375f.c(a.this);
                    a.f35374c.set(0);
                }
            }
        });
        this.f35376k.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast makeText = Toast.makeText(a.this.xv, "", 1);
                try {
                    ((ClipboardManager) a.this.xv.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.this.ux));
                    makeText.setText("\u94fe\u63a5\u590d\u5236\u6210\u529f");
                } catch (Throwable th) {
                    th.printStackTrace();
                    makeText.setText("\u94fe\u63a5\u590d\u5236\u5931\u8d25");
                }
                makeText.show();
            }
        });
    }

    public a c(c cVar) {
        this.f35375f = cVar;
        return this;
    }
}
