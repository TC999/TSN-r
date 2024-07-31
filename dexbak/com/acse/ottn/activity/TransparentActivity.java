package com.acse.ottn.activity;

import android.content.BroadcastReceiver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import com.acse.ottn.animator.SwitchOnAnimSmallView;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.CommonUtil;
import com.baidu.mobads.sdk.internal.C2606av;
import com.bxkj.student.C4229c;
import com.stub.StubApp;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TransparentActivity extends ActivityC1305w {

    /* renamed from: d */
    private TextView f2159d;

    /* renamed from: e */
    private TextView f2160e;

    /* renamed from: f */
    private TextView f2161f;

    /* renamed from: g */
    private TextView f2162g;

    /* renamed from: h */
    private TextView f2163h;

    /* renamed from: i */
    private TextView f2164i;

    /* renamed from: j */
    private String f2165j;

    /* renamed from: l */
    private SwitchOnAnimSmallView f2167l;

    /* renamed from: k */
    private Handler f2166k = new Handler();

    /* renamed from: m */
    private String f2168m = C2606av.f8628b;

    /* renamed from: n */
    public BroadcastReceiver f2169n = new C1275M(this);

    static {
        StubApp.interface11(4175);
    }

    /* renamed from: e */
    private void m57274e() {
        this.f2165j = C1633I.m56254a().m56238e(this);
    }

    /* renamed from: c */
    public String m57276c() {
        return C1663ca.m56080c().m56081b();
    }

    /* renamed from: d */
    public void m57275d() {
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
                    this.f2159d.setText("第一步:滑动列表");
                    TextView textView2 = this.f2162g;
                    textView2.setText(Html.fromHtml("找到“👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2160e.setText("第二步:找到并点击");
                    TextView textView3 = this.f2163h;
                    textView3.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2161f.setText("第三步:打开按钮");
                    textView = this.f2164i;
                    sb = new StringBuilder();
                    sb.append("<strong><font color=");
                    sb.append(this.f2165j);
                    sb.append(str);
                    sb.append(this.f2165j);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
                case 1:
                case 3:
                case '\b':
                    if (Build.VERSION.SDK_INT > 31) {
                        this.f2159d.setText("第一步:滑动列表");
                        this.f2162g.setText(Html.fromHtml("找到“<font color=" + this.f2165j + ">已下载的应用</font>”"));
                        this.f2160e.setText("第二步:找到并点击");
                        this.f2163h.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                        str = "👉【<font color=";
                        sb.append(str);
                        sb.append(this.f2165j);
                        sb.append(">");
                        sb.append(CommonUtil.appName);
                        break;
                    } else {
                        this.f2159d.setText("第一步:滑动列表");
                        TextView textView4 = this.f2162g;
                        textView4.setText(Html.fromHtml("找到“👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2160e.setText("第二步:找到并点击");
                        TextView textView5 = this.f2163h;
                        textView5.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                        sb.append("<strong><font color=");
                        sb.append(this.f2165j);
                        sb.append(str);
                        sb.append(this.f2165j);
                        sb.append(">");
                        sb.append(CommonUtil.appName);
                    }
                case 2:
                case 4:
                case 5:
                case '\n':
                    if (C1638Ka.m56174s()) {
                        this.f2159d.setText("第一步:滑动列表");
                        TextView textView6 = this.f2162g;
                        textView6.setText(Html.fromHtml("找到“<font color=" + this.f2165j + ">已安装的服务</font>”"));
                        this.f2160e.setText("第二步:点击");
                        TextView textView7 = this.f2163h;
                        textView7.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                    } else {
                        this.f2159d.setText("第一步:滑动列表");
                        TextView textView8 = this.f2162g;
                        textView8.setText(Html.fromHtml("找到“👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2160e.setText("第二步:点击");
                        TextView textView9 = this.f2163h;
                        textView9.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                    }
                    str = "👉【<font color=";
                    sb.append(str);
                    sb.append(this.f2165j);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
                case 6:
                case '\f':
                    int i = Build.VERSION.SDK_INT;
                    if (i > 29) {
                        this.f2159d.setText("第一步:滑动列表");
                        this.f2162g.setText(Html.fromHtml("找到“<font color=" + this.f2165j + ">已下载的应用</font>”"));
                        this.f2160e.setText("第二步:找到并点击");
                        this.f2163h.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        TextView textView10 = this.f2164i;
                        textView10.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    }
                    if (i <= 29) {
                        this.f2159d.setText("第一步:滑动列表");
                        this.f2162g.setText(Html.fromHtml("找到“<font color=" + this.f2165j + ">更多已下载的服务</font>”"));
                        this.f2160e.setText("第二步:找到并点击");
                        this.f2163h.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                        sb.append("点击“<font color=");
                        sb.append(this.f2165j);
                        str2 = ">开启服务</font>“按钮";
                        break;
                    } else {
                        return;
                    }
                case '\t':
                    if (Build.VERSION.SDK_INT >= 32) {
                        this.f2159d.setText("第一步:滑动列表");
                        this.f2162g.setText(Html.fromHtml("找到“<font color=" + this.f2165j + ">已下载的服务</font>”"));
                        this.f2160e.setText("第二步:找到并点击");
                        this.f2163h.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                    } else {
                        this.f2159d.setText("第一步:滑动列表");
                        TextView textView11 = this.f2162g;
                        textView11.setText(Html.fromHtml("找到“👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2160e.setText("第二步:找到并点击");
                        TextView textView12 = this.f2163h;
                        textView12.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                        this.f2161f.setText("第三步:打开按钮");
                        textView = this.f2164i;
                        sb = new StringBuilder();
                    }
                    sb.append("<strong><font color=");
                    sb.append(this.f2165j);
                    sb.append(str);
                    sb.append(this.f2165j);
                    sb.append(">");
                    sb.append(CommonUtil.appName);
                    break;
                case '\r':
                    this.f2159d.setText("第一步:滑动列表");
                    TextView textView13 = this.f2162g;
                    textView13.setText(Html.fromHtml("找到“<font color=" + this.f2165j + ">已安装的应用程序</font>”"));
                    this.f2160e.setText("第二步:点击");
                    TextView textView14 = this.f2163h;
                    textView14.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2161f.setText("第三步:打开按钮");
                    textView = this.f2164i;
                    sb = new StringBuilder();
                    sb.append("请将<font color=");
                    sb.append(this.f2165j);
                    sb.append("></font><font color=");
                    sb.append(this.f2165j);
                    sb.append(">第1项</font>开关打开<br/>(注意不是点“<font color=");
                    sb.append(this.f2165j);
                    sb.append("></font><font color=");
                    sb.append(this.f2165j);
                    str2 = ">快捷方式</font>”)❌";
                    break;
                default:
                    this.f2159d.setText("第一步:滑动列表");
                    TextView textView15 = this.f2162g;
                    textView15.setText(Html.fromHtml("找到“👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2160e.setText("第二步:找到并点击");
                    TextView textView16 = this.f2163h;
                    textView16.setText(Html.fromHtml("👉【<font color=" + this.f2165j + ">" + CommonUtil.appName + "</font>】—请启用🏃"));
                    this.f2161f.setText("第三步:打开按钮");
                    textView = this.f2164i;
                    sb = new StringBuilder();
                    sb.append("<strong><font color=");
                    sb.append(this.f2165j);
                    sb.append(str);
                    sb.append(this.f2165j);
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
        SwitchOnAnimSmallView switchOnAnimSmallView = this.f2167l;
        if (switchOnAnimSmallView != null) {
            switchOnAnimSmallView.m57214b();
            this.f2167l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        double height = defaultDisplay.getHeight();
        Double.isNaN(height);
        attributes.height = (int) (height * 0.3d);
        double width = defaultDisplay.getWidth();
        Double.isNaN(width);
        attributes.width = (int) (width * 0.6d);
        attributes.gravity = 51;
        attributes.x = 0;
        attributes.y = 0;
        attributes.format = 1;
        attributes.flags = 32;
        getWindow().setAttributes(attributes);
    }
}
