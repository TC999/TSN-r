package com.acse.ottn.activity;

import android.app.AppOpsManager;
import android.app.PictureInPictureParams;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.util.Rational;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.animator.SwitchOnAnimSmallView;
import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.CommonUtil;
import com.baidu.mobads.sdk.internal.C2606av;
import com.bxkj.student.C4229c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PicToPicActivity extends ActivityC1305w {
    private static final String TAG = "PicToPicActivity";

    /* renamed from: d */
    private TextView f2123d;

    /* renamed from: e */
    private TextView f2124e;

    /* renamed from: f */
    private TextView f2125f;

    /* renamed from: g */
    private TextView f2126g;

    /* renamed from: h */
    private TextView f2127h;

    /* renamed from: i */
    private TextView f2128i;

    /* renamed from: j */
    private TextView f2129j;

    /* renamed from: k */
    private TextView f2130k;

    /* renamed from: l */
    private RelativeLayout f2131l;

    /* renamed from: m */
    private RelativeLayout f2132m;

    /* renamed from: n */
    private String f2133n;

    /* renamed from: p */
    private SwitchOnAnimView f2135p;

    /* renamed from: q */
    private SwitchOnAnimSmallView f2136q;

    /* renamed from: o */
    private Handler f2134o = new Handler();

    /* renamed from: r */
    private String f2137r = C2606av.f8628b;

    /* renamed from: s */
    public BroadcastReceiver f2138s = new C1308z(this);

    static {
        StubApp.interface11(4168);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m57299f() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                PictureInPictureParams.Builder builder = new PictureInPictureParams.Builder();
                builder.setAspectRatio(new Rational(16, 9));
                enterPictureInPictureMode(builder.build());
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    private void m57298g() {
        C1633I.m56254a().m56248a(this, this.f2130k);
        this.f2133n = C1633I.m56254a().m56238e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m57297h() {
        return Build.VERSION.SDK_INT >= 19 && ((AppOpsManager) getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", getApplicationInfo().uid, getPackageName()) == 0 && getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    /* renamed from: d */
    public String m57302d() {
        return C1663ca.m56080c().m56081b();
    }

    /* renamed from: e */
    public void m57300e() {
        TextView textView;
        StringBuilder sb;
        if (C1638Ka.m56193b() != null) {
            String m56193b = C1638Ka.m56193b();
            m56193b.hashCode();
            char c = 65535;
            switch (m56193b.hashCode()) {
                case -1443430368:
                    if (m56193b.equals("smartisan")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1320380160:
                    if (m56193b.equals("oneplus")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1206476313:
                    if (m56193b.equals("huawei")) {
                        c = 2;
                        break;
                    }
                    break;
                case -934971466:
                    if (m56193b.equals("realme")) {
                        c = 3;
                        break;
                    }
                    break;
                case -878077690:
                    if (m56193b.equals("tdtech")) {
                        c = 4;
                        break;
                    }
                    break;
                case -874016782:
                    if (m56193b.equals("tianyi")) {
                        c = 5;
                        break;
                    }
                    break;
                case -759499589:
                    if (m56193b.equals(C4229c.f16088d)) {
                        c = 6;
                        break;
                    }
                    break;
                case 3318203:
                    if (m56193b.equals("letv")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3418016:
                    if (m56193b.equals("oppo")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3620012:
                    if (m56193b.equals("vivo")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 99462250:
                    if (m56193b.equals("honor")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 103777484:
                    if (m56193b.equals("meizu")) {
                        c = 11;
                        break;
                    }
                    break;
                case 108389869:
                    if (m56193b.equals("redmi")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1864941562:
                    if (m56193b.equals("samsung")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
            }
            String str = ">使用</font></strong>👉【<font color=";
            String str2 = "</font>】—请启用🏃";
            switch (c) {
                case 0:
                case 7:
                case 11:
                    this.f2123d.setText("第一步:滑动列表");
                    TextView textView2 = this.f2126g;
                    textView2.setText(Html.fromHtml("找到“👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2124e.setText("第二步:找到并点击");
                    TextView textView3 = this.f2127h;
                    textView3.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2125f.setText("第三步:打开按钮");
                    textView = this.f2128i;
                    sb = new StringBuilder();
                    sb.append("<strong><font color=");
                    sb.append(this.f2133n);
                    sb.append(str);
                    sb.append(this.f2133n);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
                case 1:
                case 3:
                case '\b':
                    if (Build.VERSION.SDK_INT > 31) {
                        this.f2123d.setText("第一步:滑动列表");
                        this.f2126g.setText(Html.fromHtml("找到“<font color=" + this.f2133n + ">已下载的应用</font>”"));
                        this.f2124e.setText("第二步:找到并点击");
                        this.f2127h.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                        str = "👉【<font color=";
                        sb.append(str);
                        sb.append(this.f2133n);
                        sb.append(">");
                        sb.append(CommonUtil.appName);
                        break;
                    } else {
                        this.f2123d.setText("第一步:滑动列表");
                        TextView textView4 = this.f2126g;
                        textView4.setText(Html.fromHtml("找到“👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2124e.setText("第二步:找到并点击");
                        TextView textView5 = this.f2127h;
                        textView5.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                        sb.append("<strong><font color=");
                        sb.append(this.f2133n);
                        sb.append(str);
                        sb.append(this.f2133n);
                        sb.append(">");
                        sb.append(CommonUtil.appName);
                    }
                case 2:
                case 4:
                case 5:
                case '\n':
                    if (C1638Ka.m56174s()) {
                        this.f2123d.setText("第一步:滑动列表");
                        TextView textView6 = this.f2126g;
                        textView6.setText(Html.fromHtml("找到“<font color=" + this.f2133n + ">已安装的服务</font>”"));
                        this.f2124e.setText("第二步:点击");
                        TextView textView7 = this.f2127h;
                        textView7.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                    } else {
                        this.f2123d.setText("第一步:滑动列表");
                        TextView textView8 = this.f2126g;
                        textView8.setText(Html.fromHtml("找到“👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2124e.setText("第二步:点击");
                        TextView textView9 = this.f2127h;
                        textView9.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                    }
                    str = "👉【<font color=";
                    sb.append(str);
                    sb.append(this.f2133n);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
                case 6:
                case '\f':
                    int i = Build.VERSION.SDK_INT;
                    if (i > 29) {
                        this.f2123d.setText("第一步:滑动列表");
                        this.f2126g.setText(Html.fromHtml("找到“<font color=" + this.f2133n + ">已下载的应用</font>”"));
                        this.f2124e.setText("第二步:找到并点击");
                        this.f2127h.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        TextView textView10 = this.f2128i;
                        textView10.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    }
                    if (i <= 29) {
                        this.f2123d.setText("第一步:滑动列表");
                        this.f2126g.setText(Html.fromHtml("找到“<font color=" + this.f2133n + ">更多已下载的服务</font>”"));
                        this.f2124e.setText("第二步:找到并点击");
                        this.f2127h.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                        sb.append("点击“<font color=");
                        sb.append(this.f2133n);
                        str2 = ">开启服务</font>“按钮";
                        break;
                    } else {
                        return;
                    }
                case '\t':
                    if (Build.VERSION.SDK_INT >= 32) {
                        this.f2123d.setText("第一步:滑动列表");
                        this.f2126g.setText(Html.fromHtml("找到“<font color=" + this.f2133n + ">已下载的服务</font>”"));
                        this.f2124e.setText("第二步:找到并点击");
                        this.f2127h.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                    } else {
                        this.f2123d.setText("第一步:滑动列表");
                        TextView textView11 = this.f2126g;
                        textView11.setText(Html.fromHtml("找到“👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2124e.setText("第二步:找到并点击");
                        TextView textView12 = this.f2127h;
                        textView12.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2125f.setText("第三步:打开按钮");
                        textView = this.f2128i;
                        sb = new StringBuilder();
                    }
                    sb.append("<strong><font color=");
                    sb.append(this.f2133n);
                    sb.append(str);
                    sb.append(this.f2133n);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
                case '\r':
                    this.f2123d.setText("第一步:滑动列表");
                    TextView textView13 = this.f2126g;
                    textView13.setText(Html.fromHtml("找到“<font color=" + this.f2133n + ">已安装的应用程序</font>”"));
                    this.f2124e.setText("第二步:点击");
                    TextView textView14 = this.f2127h;
                    textView14.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2125f.setText("第三步:打开按钮");
                    textView = this.f2128i;
                    sb = new StringBuilder();
                    sb.append("请将<font color=");
                    sb.append(this.f2133n);
                    sb.append("></font><font color=");
                    sb.append(this.f2133n);
                    sb.append(">第1项</font>开关打开<br/>(注意不是点“<font color=");
                    sb.append(this.f2133n);
                    sb.append("></font><font color=");
                    sb.append(this.f2133n);
                    str2 = ">快捷方式</font>”)❌";
                    break;
                default:
                    this.f2123d.setText("第一步:滑动列表");
                    TextView textView15 = this.f2126g;
                    textView15.setText(Html.fromHtml("找到“👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2124e.setText("第二步:找到并点击");
                    TextView textView16 = this.f2127h;
                    textView16.setText(Html.fromHtml("👉【<font color=" + this.f2133n + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2125f.setText("第三步:打开按钮");
                    textView = this.f2128i;
                    sb = new StringBuilder();
                    sb.append("<strong><font color=");
                    sb.append(this.f2133n);
                    sb.append(str);
                    sb.append(this.f2133n);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
            }
            sb.append(str2);
            textView.setText(Html.fromHtml(sb.toString()));
        }
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        SwitchOnAnimSmallView switchOnAnimSmallView = this.f2136q;
        if (switchOnAnimSmallView != null) {
            switchOnAnimSmallView.m57214b();
            this.f2136q = null;
        }
        SwitchOnAnimView switchOnAnimView = this.f2135p;
        if (switchOnAnimView != null) {
            switchOnAnimView.m57202b();
            this.f2135p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
        if (!z) {
            this.f2123d.setTextSize(24.0f);
            this.f2124e.setTextSize(24.0f);
            this.f2125f.setTextSize(24.0f);
            this.f2123d.setPadding(0, 500, 0, 0);
            this.f2124e.setPadding(0, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, 0, 0);
            this.f2125f.setPadding(0, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, 0, 0);
            this.f2130k.setVisibility(0);
            this.f2126g.setTextSize(18.0f);
            this.f2127h.setTextSize(18.0f);
            this.f2129j.setTextSize(18.0f);
            this.f2132m.setVisibility(8);
            this.f2131l.setVisibility(0);
            this.f2126g.setPadding(0, 10, 0, 0);
            this.f2127h.setPadding(0, 10, 0, 0);
            this.f2129j.setPadding(0, 10, 0, 0);
            try {
                unregisterReceiver(this.f2138s);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.f2137r);
        registerReceiver(this.f2138s, intentFilter);
        this.f2123d.setTextSize(10.0f);
        this.f2124e.setTextSize(10.0f);
        this.f2125f.setTextSize(10.0f);
        this.f2123d.setPadding(0, 10, 0, 0);
        this.f2124e.setPadding(0, 10, 0, 0);
        this.f2125f.setPadding(0, 10, 0, 0);
        this.f2126g.setTextSize(10.0f);
        this.f2127h.setTextSize(10.0f);
        this.f2128i.setTextSize(10.0f);
        this.f2126g.setPadding(0, 3, 0, 0);
        this.f2127h.setPadding(0, 3, 0, 0);
        this.f2128i.setPadding(0, 3, 0, 0);
        this.f2130k.setVisibility(8);
        this.f2132m.setVisibility(0);
        this.f2131l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            unregisterReceiver(this.f2138s);
        } catch (Exception unused) {
        }
        finish();
        Log.d(TAG, "onStop");
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.d(TAG, "onUserLeaveHint");
        if (m57297h()) {
            m57299f();
        } else {
            finish();
        }
    }
}
