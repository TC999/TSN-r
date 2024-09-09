package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    protected static volatile AtomicInteger f35469c = new AtomicInteger(0);
    private c ev;

    /* renamed from: f  reason: collision with root package name */
    private Button f35470f;
    private String gd;

    /* renamed from: r  reason: collision with root package name */
    private String f35471r;
    private ImageView sr;
    private Button ux;

    /* renamed from: w  reason: collision with root package name */
    private SSWebView f35472w;
    private Context xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);

        void w(Dialog dialog);

        void xv(Dialog dialog);
    }

    public sr(Context context, String str) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.xv = context;
        this.gd = str;
    }

    private void w() {
        if (this.xv == null) {
            this.xv = ls.getContext();
        }
        if (this.xv.getResources().getConfiguration().orientation == 1) {
            setContentView(c(1));
        } else {
            setContentView(c(0));
        }
    }

    private void xv() {
        if (TextUtils.isEmpty(this.gd)) {
            this.f35471r = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.u.ux ux = com.bytedance.sdk.openadsdk.core.w.ux(new JSONObject(this.gd));
            if (ux != null) {
                String ev = ux.ev();
                this.f35471r = ev;
                if (TextUtils.isEmpty(ev)) {
                    this.f35471r = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f35469c.set(0);
        c cVar = this.ev;
        if (cVar != null) {
            cVar.w(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w();
        xv();
        c();
    }

    private View c(int i4) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.xv);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i4);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.xv);
        if (i4 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.xv);
        if (i4 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.xv, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.xv);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return c(i4, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout w(int i4, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.xv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int ux = xk.ux(this.xv, 16.0f);
        linearLayout3.setPadding(ux, ux, ux, ux);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.f35470f = new Button(this.xv);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int ux2 = xk.ux(this.xv, 7.0f);
        layoutParams2.leftMargin = ux2;
        layoutParams2.rightMargin = ux2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.xv, 3.0f));
        gradientDrawable.setStroke(xk.ux(this.xv, 0.5f), Color.parseColor("#E0161823"));
        this.f35470f.setBackground(gradientDrawable);
        int ux3 = xk.ux(this.xv, 12.0f);
        this.f35470f.setText("\u4e0a\u4e00\u6b65");
        this.f35470f.setPadding(0, ux3, 0, ux3);
        this.f35470f.setTextColor(Color.parseColor("#A8161823"));
        this.f35470f.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.f35470f);
        return c(i4, linearLayout, linearLayout2, linearLayout3, ux2, ux3);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.xv);
        this.sr = imageView;
        imageView.setMaxHeight(xk.ux(this.xv, 46.0f));
        this.sr.setMaxWidth(xk.ux(this.xv, 46.0f));
        this.sr.setMinimumHeight(xk.ux(this.xv, 46.0f));
        this.sr.setMinimumWidth(xk.ux(this.xv, 46.0f));
        this.sr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(xk.ux(this.xv, 14.0f));
        xvVar.c(-16777216);
        xvVar.c(xk.ux(this.xv, 2.0f));
        this.sr.setImageDrawable(xvVar);
        relativeLayout.addView(this.sr);
        TextView textView = new TextView(this.xv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("\u9690\u79c1\u653f\u7b56");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        return c(i4, linearLayout, linearLayout2);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, LinearLayout linearLayout2) {
        View view = new View(this.xv);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.xv, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        this.f35472w = new SSWebView(this.xv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.f35472w.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f35472w);
        View view2 = new View(this.xv);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.xv, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return w(i4, linearLayout, linearLayout2);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, int i5, int i6) {
        this.ux = new Button(this.xv);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i5;
        layoutParams.rightMargin = i5;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(xk.ux(this.xv, 3.0f));
        this.ux.setBackground(gradientDrawable);
        this.ux.setText("\u7acb\u5373\u4e0b\u8f7d");
        this.ux.setPadding(0, i6, 0, i6);
        this.ux.setTextColor(-1);
        this.ux.setLayoutParams(layoutParams);
        linearLayout3.addView(this.ux);
        if (i4 == 0) {
            return linearLayout;
        }
        View view = new View(this.xv);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.xv, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    protected void c() {
        this.sr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.sr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sr.f35469c.set(0);
                if (sr.this.ev != null) {
                    sr.this.ev.w(sr.this);
                }
            }
        });
        this.f35470f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.sr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sr.f35469c.set(0);
                if (sr.this.ev != null) {
                    sr.this.ev.xv(sr.this);
                }
            }
        });
        this.ux.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.sr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sr.f35469c.set(0);
                if (sr.this.ev != null) {
                    sr.this.ev.c(sr.this);
                }
            }
        });
        this.f35472w.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.xv, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.sr.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.ev = sr.f35469c;
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
                        String lowerCase = scheme.toLowerCase(Locale.ROOT);
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
                this.ev = sr.f35469c;
                return super.c(webView, str);
            }
        });
        this.f35472w.setJavaScriptEnabled(true);
        this.f35472w.setDisplayZoomControls(false);
        this.f35472w.setCacheMode(2);
        this.f35472w.c(this.f35471r);
    }

    public sr c(c cVar) {
        this.ev = cVar;
        return this;
    }
}
