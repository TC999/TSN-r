package com.acse.ottn.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.acse.ottn.animator.SwitchOnAnimSmallView;
import com.acse.ottn.c4;
import com.acse.ottn.g0;
import com.acse.ottn.h1;
import com.acse.ottn.j0;
import com.acse.ottn.z1;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class TransparentActivity extends com.acse.ottn.z {

    /* renamed from: e  reason: collision with root package name */
    public TextView f4702e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4703f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4704g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4705h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4706i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f4707j;

    /* renamed from: k  reason: collision with root package name */
    public String f4708k;

    /* renamed from: m  reason: collision with root package name */
    public SwitchOnAnimSmallView f4710m;

    /* renamed from: l  reason: collision with root package name */
    public Handler f4709l = new Handler();

    /* renamed from: n  reason: collision with root package name */
    public String f4711n = "logout";

    /* renamed from: o  reason: collision with root package name */
    public BroadcastReceiver f4712o = new c();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TransparentActivity.this.f4710m.b();
            } catch (Exception e4) {
                z1.b("TransparentActivity", e4.getMessage());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransparentActivity.this.finish();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            z1.a("TransparentActivity", "\u6536\u5230\u5e7f\u64ad");
            TransparentActivity transparentActivity = TransparentActivity.this;
            transparentActivity.unregisterReceiver(transparentActivity.f4712o);
            TransparentActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(4683);
    }

    public String c() {
        return h1.c().b();
    }

    public final void d() {
        this.f4708k = g0.a().e(this);
    }

    public void e() {
        if (c4.b() != null) {
            String b4 = c4.b();
            b4.hashCode();
            char c4 = '\uffff';
            switch (b4.hashCode()) {
                case -1443430368:
                    if (b4.equals("smartisan")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1320380160:
                    if (b4.equals("oneplus")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1206476313:
                    if (b4.equals("huawei")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -934971466:
                    if (b4.equals("realme")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -878077690:
                    if (b4.equals("tdtech")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -874016782:
                    if (b4.equals("tianyi")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -759499589:
                    if (b4.equals("xiaomi")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 3318203:
                    if (b4.equals("letv")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 3418016:
                    if (b4.equals("oppo")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case 3620012:
                    if (b4.equals("vivo")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case 99462250:
                    if (b4.equals("honor")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case 103777484:
                    if (b4.equals("meizu")) {
                        c4 = 11;
                        break;
                    }
                    break;
                case 108389869:
                    if (b4.equals("redmi")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case 1864941562:
                    if (b4.equals("samsung")) {
                        c4 = '\r';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                case 7:
                case 11:
                    this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView = this.f4705h;
                    textView.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView2 = this.f4706i;
                    textView2.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView3 = this.f4707j;
                    textView3.setText(Html.fromHtml("<strong><font color=" + this.f4708k + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case 1:
                case 3:
                case '\b':
                    if (Build.VERSION.SDK_INT > 31) {
                        this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4705h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4708k + ">\u5df2\u4e0b\u8f7d\u7684\u5e94\u7528</font>\u201d"));
                        this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4706i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView4 = this.f4707j;
                        textView4.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        return;
                    }
                    this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView5 = this.f4705h;
                    textView5.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView6 = this.f4706i;
                    textView6.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView7 = this.f4707j;
                    textView7.setText(Html.fromHtml("<strong><font color=" + this.f4708k + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case 2:
                case 4:
                case 5:
                case '\n':
                    if (c4.s()) {
                        this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        TextView textView8 = this.f4705h;
                        textView8.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4708k + ">\u5df2\u5b89\u88c5\u7684\u670d\u52a1</font>\u201d"));
                        this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u70b9\u51fb");
                        TextView textView9 = this.f4706i;
                        textView9.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView10 = this.f4707j;
                        textView10.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        return;
                    }
                    this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView11 = this.f4705h;
                    textView11.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u70b9\u51fb");
                    TextView textView12 = this.f4706i;
                    textView12.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView13 = this.f4707j;
                    textView13.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case 6:
                case '\f':
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 > 29) {
                        this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4705h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4708k + ">\u5df2\u4e0b\u8f7d\u7684\u5e94\u7528</font>\u201d"));
                        this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4706i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView14 = this.f4707j;
                        textView14.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    }
                    if (i4 <= 29) {
                        this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4705h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4708k + ">\u66f4\u591a\u5df2\u4e0b\u8f7d\u7684\u670d\u52a1</font>\u201d"));
                        this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4706i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView15 = this.f4707j;
                        textView15.setText(Html.fromHtml("\u70b9\u51fb\u201c<font color=" + this.f4708k + ">\u5f00\u542f\u670d\u52a1</font>\u201c\u6309\u94ae"));
                        return;
                    }
                    return;
                case '\t':
                    if (Build.VERSION.SDK_INT >= 32) {
                        this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4705h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4708k + ">\u5df2\u4e0b\u8f7d\u7684\u670d\u52a1</font>\u201d"));
                        this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4706i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView16 = this.f4707j;
                        textView16.setText(Html.fromHtml("<strong><font color=" + this.f4708k + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        return;
                    }
                    this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView17 = this.f4705h;
                    textView17.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView18 = this.f4706i;
                    textView18.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView19 = this.f4707j;
                    textView19.setText(Html.fromHtml("<strong><font color=" + this.f4708k + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case '\r':
                    this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView20 = this.f4705h;
                    textView20.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4708k + ">\u5df2\u5b89\u88c5\u7684\u5e94\u7528\u7a0b\u5e8f</font>\u201d"));
                    this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u70b9\u51fb");
                    TextView textView21 = this.f4706i;
                    textView21.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView22 = this.f4707j;
                    textView22.setText(Html.fromHtml("\u8bf7\u5c06<font color=" + this.f4708k + "></font><font color=" + this.f4708k + ">\u7b2c1\u9879</font>\u5f00\u5173\u6253\u5f00<br/>(\u6ce8\u610f\u4e0d\u662f\u70b9\u201c<font color=" + this.f4708k + "></font><font color=" + this.f4708k + ">\u5feb\u6377\u65b9\u5f0f</font>\u201d)\u274c"));
                    return;
                default:
                    this.f4702e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView23 = this.f4705h;
                    textView23.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4703f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView24 = this.f4706i;
                    textView24.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4704g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView25 = this.f4707j;
                    textView25.setText(Html.fromHtml("<strong><font color=" + this.f4708k + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4708k + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
            }
        }
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SwitchOnAnimSmallView switchOnAnimSmallView = this.f4710m;
        if (switchOnAnimSmallView != null) {
            switchOnAnimSmallView.f();
            this.f4710m = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
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
