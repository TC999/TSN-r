package com.beizi.ad.internal.activity;

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
import com.beizi.ad.R;
import com.beizi.ad.internal.download.BeiZiWebView;
import com.stub.StubApp;
import xyz.adscope.ad.constants.Constants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DownloadAppInfoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f13628a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f13629b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f13630c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f13631d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f13632e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13633f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13634g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13635h;

    /* renamed from: i  reason: collision with root package name */
    private View f13636i;

    /* renamed from: j  reason: collision with root package name */
    private View f13637j;

    /* renamed from: k  reason: collision with root package name */
    private View f13638k;

    /* renamed from: l  reason: collision with root package name */
    private int f13639l = 0;

    /* renamed from: m  reason: collision with root package name */
    private String f13640m = "";

    /* renamed from: n  reason: collision with root package name */
    private String f13641n = "";

    /* renamed from: o  reason: collision with root package name */
    private String f13642o = "";

    /* renamed from: p  reason: collision with root package name */
    private String f13643p = "";

    /* renamed from: q  reason: collision with root package name */
    private ScrollView f13644q;

    /* renamed from: r  reason: collision with root package name */
    private ScrollView f13645r;

    /* renamed from: s  reason: collision with root package name */
    private ScrollView f13646s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f13647t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f13648u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f13649v;

    /* renamed from: w  reason: collision with root package name */
    private BeiZiWebView f13650w;

    /* renamed from: x  reason: collision with root package name */
    private BeiZiWebView f13651x;

    /* renamed from: y  reason: collision with root package name */
    private BeiZiWebView f13652y;

    static {
        StubApp.interface11(8968);
    }

    private void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f13641n = extras.getString(Constants.PRIVACY_CONTENT_KEY);
        this.f13643p = extras.getString(Constants.TITLE_CONTENT_KEY);
        this.f13640m = extras.getString("permission_content_key");
        this.f13642o = extras.getString(Constants.INTRO_CONTENT_KEY);
        this.f13639l = extras.getInt(Constants.FROM_POSITION_KEY);
    }

    private void c() {
        if (!TextUtils.isEmpty(this.f13643p)) {
            this.f13629b.setText(this.f13643p);
        }
        this.f13628a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.finish();
            }
        });
        this.f13630c.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.a(0);
            }
        });
        this.f13631d.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.a(1);
            }
        });
        this.f13632e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.a(2);
            }
        });
    }

    private void d() {
        TextView textView = this.f13635h;
        int i4 = R.color.appinfo_tab_unselected_color;
        textView.setTextColor(ContextCompat.getColor(this, i4));
        this.f13638k.setVisibility(4);
        this.f13633f.setTextColor(ContextCompat.getColor(this, i4));
        this.f13636i.setVisibility(4);
        this.f13634g.setTextColor(ContextCompat.getColor(this, i4));
        this.f13637j.setVisibility(4);
        this.f13646s.setVisibility(8);
        this.f13652y.setVisibility(8);
        this.f13649v.setVisibility(8);
        this.f13644q.setVisibility(8);
        this.f13647t.setVisibility(8);
        this.f13650w.setVisibility(8);
        this.f13645r.setVisibility(8);
        this.f13648u.setVisibility(8);
        this.f13651x.setVisibility(8);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void a() {
        this.f13628a = (ImageView) findViewById(R.id.beizi_download_appinfo_back);
        this.f13629b = (TextView) findViewById(R.id.beizi_download_appinfo_title);
        this.f13630c = (LinearLayout) findViewById(R.id.beizi_appinfo_permission_layout);
        this.f13633f = (TextView) findViewById(R.id.beizi_appinfo_permission_textview);
        this.f13636i = findViewById(R.id.beizi_appinfo_permission_below_line);
        this.f13631d = (LinearLayout) findViewById(R.id.beizi_appinfo_privacy_layout);
        this.f13634g = (TextView) findViewById(R.id.beizi_appinfo_privacy_textview);
        this.f13637j = findViewById(R.id.beizi_appinfo_privacy_below_line);
        this.f13632e = (LinearLayout) findViewById(R.id.beizi_appinfo_intro_layout);
        this.f13635h = (TextView) findViewById(R.id.beizi_appinfo_intro_textview);
        this.f13638k = findViewById(R.id.beizi_appinfo_intro_below_line);
        this.f13644q = (ScrollView) findViewById(R.id.beizi_download_appinfo_persmission_content_scrollview);
        this.f13647t = (TextView) findViewById(R.id.beizi_download_appinfo_persmission_content_textview);
        this.f13650w = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_persmission_content_webview);
        this.f13645r = (ScrollView) findViewById(R.id.beizi_download_appinfo_privacy_content_scrollview);
        this.f13648u = (TextView) findViewById(R.id.beizi_download_appinfo_privacy_content_textview);
        this.f13651x = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_privacy_content_webview);
        this.f13646s = (ScrollView) findViewById(R.id.beizi_download_appinfo_intro_content_scrollview);
        this.f13649v = (TextView) findViewById(R.id.beizi_download_appinfo_intro_content_textview);
        this.f13652y = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_intro_content_webview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        if (i4 == 2) {
            d();
            a(this.f13635h, this.f13638k, this.f13642o, this.f13649v, this.f13646s, this.f13652y);
        } else if (i4 == 1) {
            d();
            a(this.f13634g, this.f13637j, this.f13641n, this.f13648u, this.f13645r, this.f13651x);
        } else {
            d();
            a(this.f13633f, this.f13636i, this.f13640m, this.f13647t, this.f13644q, this.f13650w);
        }
    }

    private void a(TextView textView, View view, String str, TextView textView2, ScrollView scrollView, WebView webView) {
        int i4 = R.color.appinfo_tab_selected_color;
        textView.setTextColor(ContextCompat.getColor(this, i4));
        view.setBackgroundColor(ContextCompat.getColor(this, i4));
        view.setVisibility(0);
        if (str.startsWith("http")) {
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
