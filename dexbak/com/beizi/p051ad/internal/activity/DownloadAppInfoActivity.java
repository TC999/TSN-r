package com.beizi.p051ad.internal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.download.BeiZiWebView;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.stub.StubApp;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.ad.internal.activity.DownloadAppInfoActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DownloadAppInfoActivity extends Activity {

    /* renamed from: a */
    private ImageView f9951a;

    /* renamed from: b */
    private TextView f9952b;

    /* renamed from: c */
    private LinearLayout f9953c;

    /* renamed from: d */
    private LinearLayout f9954d;

    /* renamed from: e */
    private LinearLayout f9955e;

    /* renamed from: f */
    private TextView f9956f;

    /* renamed from: g */
    private TextView f9957g;

    /* renamed from: h */
    private TextView f9958h;

    /* renamed from: i */
    private View f9959i;

    /* renamed from: j */
    private View f9960j;

    /* renamed from: k */
    private View f9961k;

    /* renamed from: l */
    private int f9962l = 0;

    /* renamed from: m */
    private String f9963m = "";

    /* renamed from: n */
    private String f9964n = "";

    /* renamed from: o */
    private String f9965o = "";

    /* renamed from: p */
    private String f9966p = "";

    /* renamed from: q */
    private ScrollView f9967q;

    /* renamed from: r */
    private ScrollView f9968r;

    /* renamed from: s */
    private ScrollView f9969s;

    /* renamed from: t */
    private TextView f9970t;

    /* renamed from: u */
    private TextView f9971u;

    /* renamed from: v */
    private TextView f9972v;

    /* renamed from: w */
    private BeiZiWebView f9973w;

    /* renamed from: x */
    private BeiZiWebView f9974x;

    /* renamed from: y */
    private BeiZiWebView f9975y;

    static {
        StubApp.interface11(8114);
    }

    /* renamed from: b */
    private void m49668b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f9964n = extras.getString("privacy_content_key");
        this.f9966p = extras.getString("title_content_key");
        this.f9963m = extras.getString(TTDelegateActivity.PERMISSION_CONTENT_KEY);
        this.f9965o = extras.getString("intro_content_key");
        this.f9962l = extras.getInt("from_position_key");
    }

    /* renamed from: c */
    private void m49667c() {
        if (!TextUtils.isEmpty(this.f9966p)) {
            this.f9952b.setText(this.f9966p);
        }
        this.f9951a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.finish();
            }
        });
        this.f9953c.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.m49671a(0);
            }
        });
        this.f9954d.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.m49671a(1);
            }
        });
        this.f9955e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.m49671a(2);
            }
        });
    }

    /* renamed from: d */
    private void m49666d() {
        TextView textView = this.f9958h;
        int i = C2750R.C2751color.appinfo_tab_unselected_color;
        textView.setTextColor(ContextCompat.getColor(this, i));
        this.f9961k.setVisibility(4);
        this.f9956f.setTextColor(ContextCompat.getColor(this, i));
        this.f9959i.setVisibility(4);
        this.f9957g.setTextColor(ContextCompat.getColor(this, i));
        this.f9960j.setVisibility(4);
        this.f9969s.setVisibility(8);
        this.f9975y.setVisibility(8);
        this.f9972v.setVisibility(8);
        this.f9967q.setVisibility(8);
        this.f9970t.setVisibility(8);
        this.f9973w.setVisibility(8);
        this.f9968r.setVisibility(8);
        this.f9971u.setVisibility(8);
        this.f9974x.setVisibility(8);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    /* renamed from: a */
    private void m49672a() {
        this.f9951a = (ImageView) findViewById(C2750R.C2753id.beizi_download_appinfo_back);
        this.f9952b = (TextView) findViewById(C2750R.C2753id.beizi_download_appinfo_title);
        this.f9953c = (LinearLayout) findViewById(C2750R.C2753id.beizi_appinfo_permission_layout);
        this.f9956f = (TextView) findViewById(C2750R.C2753id.beizi_appinfo_permission_textview);
        this.f9959i = findViewById(C2750R.C2753id.beizi_appinfo_permission_below_line);
        this.f9954d = (LinearLayout) findViewById(C2750R.C2753id.beizi_appinfo_privacy_layout);
        this.f9957g = (TextView) findViewById(C2750R.C2753id.beizi_appinfo_privacy_textview);
        this.f9960j = findViewById(C2750R.C2753id.beizi_appinfo_privacy_below_line);
        this.f9955e = (LinearLayout) findViewById(C2750R.C2753id.beizi_appinfo_intro_layout);
        this.f9958h = (TextView) findViewById(C2750R.C2753id.beizi_appinfo_intro_textview);
        this.f9961k = findViewById(C2750R.C2753id.beizi_appinfo_intro_below_line);
        this.f9967q = (ScrollView) findViewById(C2750R.C2753id.beizi_download_appinfo_persmission_content_scrollview);
        this.f9970t = (TextView) findViewById(C2750R.C2753id.beizi_download_appinfo_persmission_content_textview);
        this.f9973w = (BeiZiWebView) findViewById(C2750R.C2753id.beizi_download_appinfo_persmission_content_webview);
        this.f9968r = (ScrollView) findViewById(C2750R.C2753id.beizi_download_appinfo_privacy_content_scrollview);
        this.f9971u = (TextView) findViewById(C2750R.C2753id.beizi_download_appinfo_privacy_content_textview);
        this.f9974x = (BeiZiWebView) findViewById(C2750R.C2753id.beizi_download_appinfo_privacy_content_webview);
        this.f9969s = (ScrollView) findViewById(C2750R.C2753id.beizi_download_appinfo_intro_content_scrollview);
        this.f9972v = (TextView) findViewById(C2750R.C2753id.beizi_download_appinfo_intro_content_textview);
        this.f9975y = (BeiZiWebView) findViewById(C2750R.C2753id.beizi_download_appinfo_intro_content_webview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49671a(int i) {
        if (i == 2) {
            m49666d();
            m49670a(this.f9958h, this.f9961k, this.f9965o, this.f9972v, this.f9969s, this.f9975y);
        } else if (i == 1) {
            m49666d();
            m49670a(this.f9957g, this.f9960j, this.f9964n, this.f9971u, this.f9968r, this.f9974x);
        } else {
            m49666d();
            m49670a(this.f9956f, this.f9959i, this.f9963m, this.f9970t, this.f9967q, this.f9973w);
        }
    }

    /* renamed from: a */
    private void m49670a(TextView textView, View view, String str, TextView textView2, ScrollView scrollView, WebView webView) {
        int i = C2750R.C2751color.appinfo_tab_selected_color;
        textView.setTextColor(ContextCompat.getColor(this, i));
        view.setBackgroundColor(ContextCompat.getColor(this, i));
        view.setVisibility(0);
        if (str.startsWith(IDataSource.f43971a)) {
            textView2.setText("");
            scrollView.setVisibility(8);
            webView.setVisibility(0);
            webView.loadUrl(str);
            return;
        }
        textView2.setText(str);
        textView2.setVisibility(0);
        scrollView.setVisibility(0);
        webView.setVisibility(8);
    }
}
