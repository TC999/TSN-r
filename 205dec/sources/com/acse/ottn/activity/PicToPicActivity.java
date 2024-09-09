package com.acse.ottn.activity;

import android.app.AppOpsManager;
import android.app.PictureInPictureParams;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.animator.SwitchOnAnimSmallView;
import com.acse.ottn.animator.SwitchOnAnimView;
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
public class PicToPicActivity extends com.acse.ottn.z {

    /* renamed from: u  reason: collision with root package name */
    public static final String f4676u = "PicToPicActivity";

    /* renamed from: e  reason: collision with root package name */
    public TextView f4677e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4678f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4679g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4680h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4681i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f4682j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f4683k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f4684l;

    /* renamed from: m  reason: collision with root package name */
    public RelativeLayout f4685m;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f4686n;

    /* renamed from: o  reason: collision with root package name */
    public String f4687o;

    /* renamed from: q  reason: collision with root package name */
    public SwitchOnAnimView f4689q;

    /* renamed from: r  reason: collision with root package name */
    public SwitchOnAnimSmallView f4690r;

    /* renamed from: p  reason: collision with root package name */
    public Handler f4688p = new Handler();

    /* renamed from: s  reason: collision with root package name */
    public String f4691s = "logout";

    /* renamed from: t  reason: collision with root package name */
    public BroadcastReceiver f4692t = new a();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d(PicToPicActivity.f4676u, "\u6536\u5230\u5e7f\u64ad");
            PicToPicActivity picToPicActivity = PicToPicActivity.this;
            picToPicActivity.unregisterReceiver(picToPicActivity.f4692t);
            PicToPicActivity.this.finish();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PicToPicActivity.this.f4690r.b();
                PicToPicActivity.this.f4689q.b();
            } catch (Exception e4) {
                z1.b("TransparentActivity", e4.getMessage());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PicToPicActivity.this.g()) {
                PicToPicActivity.this.d();
                return;
            }
            Log.d(PicToPicActivity.f4676u, "\u65e0\u6cd5\u8fdb\u5165PIP\u6a21\u5f0f");
            PicToPicActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(4674);
    }

    public String e() {
        return h1.c().b();
    }

    public final void f() {
        g0.a().a(this, this.f4684l);
        this.f4687o = g0.a().e(this);
    }

    public final boolean g() {
        return Build.VERSION.SDK_INT >= 19 && ((AppOpsManager) getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", getApplicationInfo().uid, getPackageName()) == 0 && getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public void h() {
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
                    this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView = this.f4680h;
                    textView.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView2 = this.f4681i;
                    textView2.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView3 = this.f4682j;
                    textView3.setText(Html.fromHtml("<strong><font color=" + this.f4687o + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case 1:
                case 3:
                case '\b':
                    if (Build.VERSION.SDK_INT > 31) {
                        this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4680h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4687o + ">\u5df2\u4e0b\u8f7d\u7684\u5e94\u7528</font>\u201d"));
                        this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4681i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView4 = this.f4682j;
                        textView4.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        return;
                    }
                    this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView5 = this.f4680h;
                    textView5.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView6 = this.f4681i;
                    textView6.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView7 = this.f4682j;
                    textView7.setText(Html.fromHtml("<strong><font color=" + this.f4687o + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case 2:
                case 4:
                case 5:
                case '\n':
                    if (c4.s()) {
                        this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        TextView textView8 = this.f4680h;
                        textView8.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4687o + ">\u5df2\u5b89\u88c5\u7684\u670d\u52a1</font>\u201d"));
                        this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u70b9\u51fb");
                        TextView textView9 = this.f4681i;
                        textView9.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView10 = this.f4682j;
                        textView10.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        return;
                    }
                    this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView11 = this.f4680h;
                    textView11.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u70b9\u51fb");
                    TextView textView12 = this.f4681i;
                    textView12.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView13 = this.f4682j;
                    textView13.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case 6:
                case '\f':
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 > 29) {
                        this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4680h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4687o + ">\u5df2\u4e0b\u8f7d\u7684\u5e94\u7528</font>\u201d"));
                        this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4681i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView14 = this.f4682j;
                        textView14.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    }
                    if (i4 <= 29) {
                        this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4680h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4687o + ">\u66f4\u591a\u5df2\u4e0b\u8f7d\u7684\u670d\u52a1</font>\u201d"));
                        this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4681i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView15 = this.f4682j;
                        textView15.setText(Html.fromHtml("\u70b9\u51fb\u201c<font color=" + this.f4687o + ">\u5f00\u542f\u670d\u52a1</font>\u201c\u6309\u94ae"));
                        return;
                    }
                    return;
                case '\t':
                    if (Build.VERSION.SDK_INT >= 32) {
                        this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                        this.f4680h.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4687o + ">\u5df2\u4e0b\u8f7d\u7684\u670d\u52a1</font>\u201d"));
                        this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                        this.f4681i.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                        TextView textView16 = this.f4682j;
                        textView16.setText(Html.fromHtml("<strong><font color=" + this.f4687o + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                        return;
                    }
                    this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView17 = this.f4680h;
                    textView17.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView18 = this.f4681i;
                    textView18.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView19 = this.f4682j;
                    textView19.setText(Html.fromHtml("<strong><font color=" + this.f4687o + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
                case '\r':
                    this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView20 = this.f4680h;
                    textView20.setText(Html.fromHtml("\u627e\u5230\u201c<font color=" + this.f4687o + ">\u5df2\u5b89\u88c5\u7684\u5e94\u7528\u7a0b\u5e8f</font>\u201d"));
                    this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u70b9\u51fb");
                    TextView textView21 = this.f4681i;
                    textView21.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView22 = this.f4682j;
                    textView22.setText(Html.fromHtml("\u8bf7\u5c06<font color=" + this.f4687o + "></font><font color=" + this.f4687o + ">\u7b2c1\u9879</font>\u5f00\u5173\u6253\u5f00<br/>(\u6ce8\u610f\u4e0d\u662f\u70b9\u201c<font color=" + this.f4687o + "></font><font color=" + this.f4687o + ">\u5feb\u6377\u65b9\u5f0f</font>\u201d)\u274c"));
                    return;
                default:
                    this.f4677e.setText("\u7b2c\u4e00\u6b65:\u6ed1\u52a8\u5217\u8868");
                    TextView textView23 = this.f4680h;
                    textView23.setText(Html.fromHtml("\u627e\u5230\u201c\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4678f.setText("\u7b2c\u4e8c\u6b65:\u627e\u5230\u5e76\u70b9\u51fb");
                    TextView textView24 = this.f4681i;
                    textView24.setText(Html.fromHtml("\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    this.f4679g.setText("\u7b2c\u4e09\u6b65:\u6253\u5f00\u6309\u94ae");
                    TextView textView25 = this.f4682j;
                    textView25.setText(Html.fromHtml("<strong><font color=" + this.f4687o + ">\u4f7f\u7528</font></strong>\u1f449\u3010<font color=" + this.f4687o + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3"));
                    return;
            }
        }
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(f4676u, "onDestroy");
        SwitchOnAnimSmallView switchOnAnimSmallView = this.f4690r;
        if (switchOnAnimSmallView != null) {
            switchOnAnimSmallView.f();
            this.f4690r = null;
        }
        SwitchOnAnimView switchOnAnimView = this.f4689q;
        if (switchOnAnimView != null) {
            switchOnAnimView.f();
            this.f4689q = null;
        }
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d(f4676u, "onPause");
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3, Configuration configuration) {
        super.onPictureInPictureModeChanged(z3, configuration);
        if (z3) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(this.f4691s);
            registerReceiver(this.f4692t, intentFilter);
            this.f4677e.setTextSize(10.0f);
            this.f4678f.setTextSize(10.0f);
            this.f4679g.setTextSize(10.0f);
            this.f4677e.setPadding(0, 10, 0, 0);
            this.f4678f.setPadding(0, 10, 0, 0);
            this.f4679g.setPadding(0, 10, 0, 0);
            this.f4680h.setTextSize(10.0f);
            this.f4681i.setTextSize(10.0f);
            this.f4682j.setTextSize(10.0f);
            this.f4680h.setPadding(0, 3, 0, 0);
            this.f4681i.setPadding(0, 3, 0, 0);
            this.f4682j.setPadding(0, 3, 0, 0);
            this.f4684l.setVisibility(8);
            this.f4686n.setVisibility(0);
            this.f4685m.setVisibility(8);
            return;
        }
        this.f4677e.setTextSize(24.0f);
        this.f4678f.setTextSize(24.0f);
        this.f4679g.setTextSize(24.0f);
        this.f4677e.setPadding(0, 500, 0, 0);
        this.f4678f.setPadding(0, 150, 0, 0);
        this.f4679g.setPadding(0, 150, 0, 0);
        this.f4684l.setVisibility(0);
        this.f4680h.setTextSize(18.0f);
        this.f4681i.setTextSize(18.0f);
        this.f4683k.setTextSize(18.0f);
        this.f4686n.setVisibility(8);
        this.f4685m.setVisibility(0);
        this.f4680h.setPadding(0, 10, 0, 0);
        this.f4681i.setPadding(0, 10, 0, 0);
        this.f4683k.setPadding(0, 10, 0, 0);
        try {
            unregisterReceiver(this.f4692t);
        } catch (Exception unused) {
        }
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(f4676u, "onResume");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            unregisterReceiver(this.f4692t);
        } catch (Exception unused) {
        }
        finish();
        Log.d(f4676u, "onStop");
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.d(f4676u, "onUserLeaveHint");
        if (g()) {
            d();
        } else {
            finish();
        }
    }

    public final void d() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                PictureInPictureParams.Builder builder = new PictureInPictureParams.Builder();
                builder.setAspectRatio(new Rational(16, 9));
                enterPictureInPictureMode(builder.build());
            }
        } catch (Exception unused) {
        }
    }
}
