package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends AlertDialog {

    /* renamed from: w  reason: collision with root package name */
    protected static volatile AtomicInteger f35511w = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private List<C0522xv> f35512a;
    private boolean bk;

    /* renamed from: c  reason: collision with root package name */
    protected Context f35513c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private ListView f35514f;
    private c gd;

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, String> f35515k;

    /* renamed from: p  reason: collision with root package name */
    private String f35516p;

    /* renamed from: r  reason: collision with root package name */
    private SSWebView f35517r;
    private Button sr;
    private ImageView ux;
    private Button xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);

        void w(Dialog dialog);

        void xv(Dialog dialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w extends ArrayAdapter<C0522xv> {

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        class c {
            private ImageView sr;

            /* renamed from: w  reason: collision with root package name */
            private TextView f35524w;
            private TextView xv;

            c() {
            }
        }

        w(Context context, int i4, List<C0522xv> list) {
            super(context, i4, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            c cVar;
            RelativeLayout relativeLayout;
            C0522xv item = getItem(i4);
            if (view == null) {
                RelativeLayout relativeLayout2 = new RelativeLayout(xv.this.f35513c);
                relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout2.setPadding(0, 0, 0, xk.ux(xv.this.f35513c, 17.0f));
                TextView textView = new TextView(xv.this.f35513c);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int ux = xk.ux(xv.this.f35513c, 16.0f);
                layoutParams.leftMargin = ux;
                layoutParams.rightMargin = ux;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, xk.ux(xv.this.f35513c, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout2.addView(textView);
                ImageView imageView = new ImageView(xv.this.f35513c);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ux, ux);
                layoutParams2.topMargin = xk.ux(xv.this.f35513c, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                imageView.setBackground(i.xv(xv.this.f35513c, "tt_open_app_detail_list_item"));
                imageView.setLayoutParams(layoutParams2);
                relativeLayout2.addView(imageView);
                TextView textView2 = new TextView(xv.this.f35513c);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = xk.ux(xv.this.f35513c, 8.0f);
                layoutParams3.topMargin = xk.ux(xv.this.f35513c, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout2.addView(textView2);
                cVar = new c();
                cVar.f35524w = textView;
                cVar.xv = textView2;
                cVar.sr = imageView;
                relativeLayout2.setTag(cVar);
                relativeLayout = relativeLayout2;
            } else {
                cVar = (c) view.getTag();
                relativeLayout = view;
            }
            cVar.sr.setVisibility(0);
            if ("\u8865\u5145\u4e2d\uff0c\u53ef\u4e8e\u5e94\u7528\u5b98\u7f51\u67e5\u770b".equals(item.c())) {
                cVar.sr.setVisibility(4);
            }
            cVar.f35524w.setText(item.c());
            cVar.xv.setText(item.w());
            return relativeLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.xv$xv  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0522xv {

        /* renamed from: w  reason: collision with root package name */
        private String f35526w;
        private String xv;

        C0522xv(String str, String str2) {
            this.f35526w = str;
            this.xv = str2;
        }

        public String c() {
            return this.f35526w;
        }

        public String w() {
            return this.xv;
        }
    }

    public xv(Context context, String str) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.f35512a = new ArrayList();
        this.bk = false;
        this.f35513c = context;
        this.f35516p = str;
    }

    private void sr() {
        if (this.f35513c == null) {
            this.f35513c = ls.getContext();
        }
        if (this.f35513c.getResources().getConfiguration().orientation == 1) {
            setContentView(c(1));
        } else {
            setContentView(c(0));
        }
    }

    private void ux() {
        if (this.f35513c == null) {
            this.f35513c = ls.getContext();
        }
        if (this.f35513c.getResources().getConfiguration().orientation == 1) {
            setContentView(w(1));
        } else {
            setContentView(w(0));
        }
    }

    private LinearLayout w(int i4, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i4 == 0) {
            return linearLayout;
        }
        View view = new View(this.f35513c);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.f35513c, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private LinearLayout xv(int i4, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.f35513c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int ux = xk.ux(this.f35513c, 16.0f);
        linearLayout2.setPadding(ux, ux, ux, ux);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.sr = new Button(this.f35513c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int ux2 = xk.ux(this.f35513c, 7.0f);
        layoutParams2.leftMargin = ux2;
        layoutParams2.rightMargin = ux2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.f35513c, 3.0f));
        gradientDrawable.setStroke(xk.ux(this.f35513c, 0.5f), Color.parseColor("#E0161823"));
        this.sr.setBackground(gradientDrawable);
        int ux3 = xk.ux(this.f35513c, 12.0f);
        this.sr.setText("\u4e0a\u4e00\u6b65");
        this.sr.setPadding(0, ux3, 0, ux3);
        this.sr.setTextColor(Color.parseColor("#A8161823"));
        this.sr.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.sr);
        return c(i4, linearLayout, relativeLayout, linearLayout2, ux2, ux3);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f35511w.set(0);
        c cVar = this.gd;
        if (cVar != null) {
            cVar.w(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w();
        if (!this.bk) {
            sr();
        } else {
            ux();
        }
        xv();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private View c(int i4) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f35513c);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i4);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f35513c);
        if (i4 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.f35513c);
        if (i4 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.f35513c, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.f35513c);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return c(i4, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout sr(int i4, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i4 == 0) {
            return linearLayout;
        }
        View view = new View(this.f35513c);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.f35513c, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    private View w(int i4) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f35513c);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i4);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f35513c);
        if (i4 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.f35513c);
        if (i4 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.f35513c, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return c(i4, linearLayout, relativeLayout);
    }

    protected void xv() {
        if (this.bk) {
            c();
        }
        this.xv.setVisibility(0);
        this.xv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xv.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xv.f35511w.set(0);
                if (xv.this.gd != null) {
                    xv.this.gd.c(xv.this);
                }
            }
        });
        this.ux.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xv.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xv.f35511w.set(0);
                if (xv.this.gd != null) {
                    xv.this.gd.w(xv.this);
                }
            }
        });
        this.sr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xv.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xv.f35511w.set(0);
                if (xv.this.gd != null) {
                    xv.this.gd.xv(xv.this);
                }
            }
        });
        List<C0522xv> list = this.f35512a;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f35514f.setAdapter((ListAdapter) new w(this.f35513c, 0, this.f35512a));
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.f35513c);
        this.ux = imageView;
        imageView.setMaxHeight(xk.ux(this.f35513c, 46.0f));
        this.ux.setMaxWidth(xk.ux(this.f35513c, 46.0f));
        this.ux.setMinimumHeight(xk.ux(this.f35513c, 46.0f));
        this.ux.setMinimumWidth(xk.ux(this.f35513c, 46.0f));
        this.ux.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(xk.ux(this.f35513c, 14.0f));
        xvVar.c(-16777216);
        xvVar.c(xk.ux(this.f35513c, 2.0f));
        this.ux.setImageDrawable(xvVar);
        relativeLayout.addView(this.ux);
        TextView textView = new TextView(this.f35513c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("\u6743\u9650\u5217\u8868");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.f35513c);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, xk.ux(this.f35513c, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return c(i4, linearLayout, c(linearLayout2, view));
    }

    private LinearLayout w(int i4, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.f35513c);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.f35513c, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.f35517r = new SSWebView(this.f35513c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.f35517r.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f35517r);
        View view2 = new View(this.f35513c);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.f35513c, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return xv(i4, linearLayout, relativeLayout);
    }

    protected void w() {
        if (TextUtils.isEmpty(this.f35516p)) {
            c(this.f35515k);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.u.ux ux = com.bytedance.sdk.openadsdk.core.w.ux(new JSONObject(this.f35516p));
            if (ux != null) {
                HashMap<String, String> c4 = ux.c();
                this.f35515k = c4;
                if (!c4.isEmpty()) {
                    this.bk = false;
                    c(this.f35515k);
                } else if (!TextUtils.isEmpty(ux.w())) {
                    this.ev = ux.w();
                    this.bk = true;
                } else {
                    c(this.f35515k);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private LinearLayout c(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.f35513c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.f35514f = new ListView(this.f35513c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = xk.ux(this.f35513c, 20.0f);
        int ux = xk.ux(this.f35513c, 16.0f);
        this.f35514f.setPadding(ux, 0, ux, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(xk.ux(this.f35513c, 1.0f), Color.parseColor("#F0F0F0"));
        this.f35514f.setDivider(gradientDrawable);
        this.f35514f.setDividerHeight(xk.ux(this.f35513c, 24.0f));
        this.f35514f.setSelector(new ColorDrawable(0));
        this.f35514f.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.f35514f);
        View view2 = new View(this.f35513c);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(this.f35513c, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.f35513c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int ux = xk.ux(this.f35513c, 16.0f);
        linearLayout3.setPadding(ux, ux, ux, ux);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.sr = new Button(this.f35513c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int ux2 = xk.ux(this.f35513c, 7.0f);
        layoutParams2.leftMargin = ux2;
        layoutParams2.rightMargin = ux2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.f35513c, 3.0f));
        gradientDrawable.setStroke(xk.ux(this.f35513c, 0.5f), Color.parseColor("#E0161823"));
        this.sr.setBackground(gradientDrawable);
        int ux3 = xk.ux(this.f35513c, 12.0f);
        this.sr.setText("\u4e0a\u4e00\u6b65");
        this.sr.setPadding(0, ux3, 0, ux3);
        this.sr.setTextColor(Color.parseColor("#A8161823"));
        this.sr.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.sr);
        return c(ux2, ux3, linearLayout3, w(i4, linearLayout, linearLayout2));
    }

    private LinearLayout c(int i4, int i5, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.xv = new Button(this.f35513c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i4;
        layoutParams.rightMargin = i4;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(xk.ux(this.f35513c, 3.0f));
        this.xv.setBackground(gradientDrawable);
        this.xv.setText("\u7acb\u5373\u4e0b\u8f7d");
        this.xv.setPadding(0, i5, 0, i5);
        this.xv.setTextColor(-1);
        this.xv.setLayoutParams(layoutParams);
        linearLayout.addView(this.xv);
        return linearLayout2;
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f35513c);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.f35513c);
        this.ux = imageView;
        imageView.setMaxHeight(xk.ux(this.f35513c, 46.0f));
        this.ux.setMaxWidth(xk.ux(this.f35513c, 46.0f));
        this.ux.setMinimumHeight(xk.ux(this.f35513c, 46.0f));
        this.ux.setMinimumWidth(xk.ux(this.f35513c, 46.0f));
        this.ux.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(xk.ux(this.f35513c, 14.0f));
        xvVar.c(-16777216);
        xvVar.c(xk.ux(this.f35513c, 2.0f));
        this.ux.setImageDrawable(xvVar);
        relativeLayout2.addView(this.ux);
        TextView textView = new TextView(this.f35513c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("\u6743\u9650\u5217\u8868");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return w(i4, linearLayout, relativeLayout);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i5, int i6) {
        return c(i5, i6, linearLayout2, sr(i4, linearLayout, relativeLayout));
    }

    protected void c() {
        this.f35517r.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f35513c, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.xv.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.ev = xv.f35511w;
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
                this.ev = xv.f35511w;
                return super.c(webView, str);
            }
        });
        this.f35517r.setJavaScriptEnabled(true);
        this.f35517r.setDisplayZoomControls(false);
        this.f35517r.setCacheMode(2);
        this.f35517r.c(this.ev);
    }

    private void c(HashMap<String, String> hashMap) {
        List<C0522xv> list = this.f35512a;
        if (list != null && list.size() > 0) {
            this.f35512a.clear();
        }
        if (this.f35512a == null) {
            this.f35512a = new ArrayList();
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                this.f35512a.add(new C0522xv(str, hashMap.get(str)));
            }
            return;
        }
        this.f35512a.add(new C0522xv("\u8865\u5145\u4e2d\uff0c\u53ef\u4e8e\u5e94\u7528\u5b98\u7f51\u67e5\u770b", ""));
    }

    public xv c(c cVar) {
        this.gd = cVar;
        return this;
    }
}
