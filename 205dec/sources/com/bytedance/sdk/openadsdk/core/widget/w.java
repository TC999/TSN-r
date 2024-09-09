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

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends AlertDialog {

    /* renamed from: w  reason: collision with root package name */
    protected static volatile AtomicInteger f35503w = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    protected String f35504c;
    private c ev;

    /* renamed from: f  reason: collision with root package name */
    private Button f35505f;

    /* renamed from: r  reason: collision with root package name */
    private Button f35506r;
    private Context sr;
    private ImageView ux;
    private SSWebView xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);

        void w(Dialog dialog);

        void xv(Dialog dialog);
    }

    public w(Context context, String str) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.sr = context;
        this.f35504c = str;
        if (TextUtils.isEmpty(str) || !(this.f35504c.startsWith("https") || this.f35504c.startsWith("http"))) {
            this.f35504c = "https://apps.bytesfield.com/app_package_ce/appIntro";
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f35503w.set(0);
        c cVar = this.ev;
        if (cVar != null) {
            cVar.w(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.sr == null) {
            this.sr = ls.getContext();
        }
        c();
    }

    private View c(int i4) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.sr);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i4);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.sr);
        if (i4 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.sr);
        if (i4 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.sr, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.sr);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.sr);
        this.ux = imageView;
        imageView.setMaxHeight(xk.ux(this.sr, 46.0f));
        this.ux.setMaxWidth(xk.ux(this.sr, 46.0f));
        this.ux.setMinimumHeight(xk.ux(this.sr, 46.0f));
        this.ux.setMinimumWidth(xk.ux(this.sr, 46.0f));
        this.ux.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(xk.ux(this.sr, 14.0f));
        xvVar.c(-16777216);
        xvVar.c(xk.ux(this.sr, 2.0f));
        this.ux.setImageDrawable(xvVar);
        relativeLayout.addView(this.ux);
        TextView textView = new TextView(this.sr);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("\u5e94\u7528\u7b80\u4ecb");
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.sr);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.sr, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.xv = new SSWebView(this.sr);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.xv.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.xv);
        View view3 = new View(this.sr);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.sr, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.sr);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int ux = xk.ux(this.sr, 16.0f);
        linearLayout3.setPadding(ux, ux, ux, ux);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.f35506r = new Button(this.sr);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int ux2 = xk.ux(this.sr, 7.0f);
        layoutParams7.leftMargin = ux2;
        layoutParams7.rightMargin = ux2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(xk.ux(this.sr, 3.0f));
        gradientDrawable2.setStroke(xk.ux(this.sr, 0.5f), Color.parseColor("#E0161823"));
        this.f35506r.setBackground(gradientDrawable2);
        int ux3 = xk.ux(this.sr, 12.0f);
        this.f35506r.setText("\u4e0a\u4e00\u6b65");
        this.f35506r.setPadding(0, ux3, 0, ux3);
        this.f35506r.setTextColor(Color.parseColor("#A8161823"));
        this.f35506r.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.f35506r);
        this.f35505f = new Button(this.sr);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = ux2;
        layoutParams8.rightMargin = ux2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(xk.ux(this.sr, 3.0f));
        this.f35505f.setBackground(gradientDrawable3);
        this.f35505f.setText("\u7acb\u5373\u4e0b\u8f7d");
        this.f35505f.setPadding(0, ux3, 0, ux3);
        this.f35505f.setTextColor(-1);
        this.f35505f.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.f35505f);
        if (i4 == 0) {
            return linearLayout;
        }
        View view4 = new View(this.sr);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.sr, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    protected void c() {
        if (this.sr.getResources().getConfiguration().orientation == 1) {
            setContentView(c(1));
        } else {
            setContentView(c(0));
        }
        this.ux.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.f35503w.set(0);
                if (w.this.ev != null) {
                    w.this.ev.w(w.this);
                }
            }
        });
        this.f35506r.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.f35503w.set(0);
                if (w.this.ev != null) {
                    w.this.ev.xv(w.this);
                }
            }
        });
        this.f35505f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.f35503w.set(0);
                if (w.this.ev != null) {
                    w.this.ev.c(w.this);
                }
            }
        });
        this.xv.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.sr, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.w.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.ev = w.f35503w;
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
                this.ev = w.f35503w;
                return super.c(webView, str);
            }
        });
        this.xv.setJavaScriptEnabled(true);
        this.xv.setDisplayZoomControls(false);
        this.xv.setCacheMode(2);
        this.xv.c(this.f35504c);
    }

    public w c(c cVar) {
        this.ev = cVar;
        return this;
    }
}
