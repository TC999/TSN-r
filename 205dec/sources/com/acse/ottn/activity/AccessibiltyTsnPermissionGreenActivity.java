package com.acse.ottn.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.acse.ottn.R;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.acse.ottn.b1;
import com.acse.ottn.c;
import com.acse.ottn.c4;
import com.acse.ottn.d0;
import com.acse.ottn.g0;
import com.acse.ottn.g1;
import com.acse.ottn.h2;
import com.acse.ottn.i2;
import com.acse.ottn.j0;
import com.acse.ottn.o4;
import com.acse.ottn.p0;
import com.acse.ottn.q4;
import com.acse.ottn.u0;
import com.acse.ottn.u3;
import com.acse.ottn.y1;
import com.acse.ottn.z1;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class AccessibiltyTsnPermissionGreenActivity extends com.acse.ottn.z {
    public RelativeLayout A;
    public RelativeLayout B;
    public RelativeLayout C;
    public RelativeLayout D;
    public AutoScrollViewPager E;
    public TextView F;
    public RelativeLayout G;
    public d0.b H = new b();
    public long I = 0;
    public Handler J = new Handler();
    public Runnable K = new d();

    /* renamed from: L  reason: collision with root package name */
    public Runnable f4589L = new e();
    public Runnable M = new f();

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4590e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f4591f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f4592g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f4593h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f4594i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f4595j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f4596k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f4597l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f4598m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f4599n;

    /* renamed from: o  reason: collision with root package name */
    public AlertDialog f4600o;

    /* renamed from: p  reason: collision with root package name */
    public AppCompatCheckBox f4601p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f4602q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f4603r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f4604s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f4605t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f4606u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f4607v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f4608w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f4609x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f4610y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f4611z;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccessibiltyTsnPermissionGreenActivity.this, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().b(AccessibiltyTsnPermissionGreenActivity.this));
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(intent);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements d0.b<Integer> {
        public b() {
        }

        @Override // com.acse.ottn.d0.b
        @RequiresApi(api = 23)
        public void a(int i4, Integer num) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements u0.c {
        public c() {
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
            i2.a().a("refuse_vivo_buttery_manage");
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            i2.a().a("allow_vivo_buttery_manage");
            o4.a((Activity) AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            if (com.acse.ottn.b.d().b()) {
                if (("xiaomi".equals(c4.b()) || "redmi".equals(c4.b())) && !g1.a().a("background_battery_hignt") && "2".equals(g1.a().d("flow_window_state"))) {
                    AccessibiltyTsnPermissionGreenActivity.this.a(j0.f5781w);
                } else if (q4.a().b(AccessibiltyTsnPermissionGreenActivity.this.getPackageName())) {
                    AccessibiltyTsnPermissionGreenActivity.this.d();
                } else {
                    String string = AccessibiltyTsnPermissionGreenActivity.this.getResources().getString(R.string.dialog_keep_back_two_title);
                    if (c4.b().equals("vivo")) {
                        string = AccessibiltyTsnPermissionGreenActivity.this.getResources().getString(R.string.dialog_keep_back_message);
                    }
                    AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = AccessibiltyTsnPermissionGreenActivity.this;
                    accessibiltyTsnPermissionGreenActivity.a(accessibiltyTsnPermissionGreenActivity.getPackageName(), string);
                }
            } else {
                AccessibiltyTsnPermissionGreenActivity.this.b(j0.f5781w);
            }
            AccessibiltyTsnPermissionGreenActivity.this.j();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            AccessibiltyTsnPermissionGreenActivity.this.c();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements u0.c {
        public g() {
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
            i2.a().a("refuse_service_permission");
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            g1.a().b("OpenPermissionName", "\u5e94\u7528\u542f\u52a8\u7ba1\u7406");
            i2.a().a("allow_service_permission");
            q4 a4 = q4.a();
            AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = AccessibiltyTsnPermissionGreenActivity.this;
            a4.a(accessibiltyTsnPermissionGreenActivity, accessibiltyTsnPermissionGreenActivity.getPackageName());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements u0.c {
        public h() {
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            i2.a().a("all_permission_open");
            AccessibiltyTsnPermissionGreenActivity.this.setResult(-1);
            AccessibiltyTsnPermissionGreenActivity.this.finish();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class i implements c.d {
        public i() {
        }

        @Override // com.acse.ottn.c.d
        public void onDismiss() {
            i2.a().a("refuse_continue_open_permission");
            AccessibiltyTsnPermissionGreenActivity.this.finish();
        }

        @Override // com.acse.ottn.c.d
        public void onOpen() {
            i2.a().a("continue_open_permission");
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class j implements u0.c {
        public j() {
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
            i2.a().a("cancle_flow_window_list");
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            b1.b().a((Activity) AccessibiltyTsnPermissionGreenActivity.this, 10011);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (z3) {
                AccessibiltyTsnPermissionGreenActivity.this.f4601p.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(g0.a().e(AccessibiltyTsnPermissionGreenActivity.this))));
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class l implements u3.h {
        public l() {
        }

        @Override // com.acse.ottn.u3.h
        public void onDismiss() {
            i2.a().a("refuse_service");
        }

        @Override // com.acse.ottn.u3.h
        public void onOpen() {
            g1.a().a("is_agree_service", true);
            i2.a().a("allow_service");
            AccessibiltyTsnPermissionGreenActivity.this.f4601p.setChecked(true);
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class m implements u0.c {
        public m() {
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
            i2.a().a("refuse_minu_service_run");
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            i2.a().a("allow_minu_service_run");
            h2.c(AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class n implements u0.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4625a;

        public n(String str) {
            this.f4625a = str;
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            if (g1.a().b("location_permission_size") == 0) {
                g1.a().b("location_permission_size", 1);
                y1.a().e(AccessibiltyTsnPermissionGreenActivity.this);
            } else if (this.f4625a.equals("1")) {
                g1.a().b("location_permission_size", 2);
                y1.a().c((Activity) AccessibiltyTsnPermissionGreenActivity.this);
            } else if (this.f4625a.equals("2")) {
                g1.a().b("location_permission_size", 3);
                y1.a().b((Activity) AccessibiltyTsnPermissionGreenActivity.this);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 23)
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.g();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccessibiltyTsnPermissionGreenActivity.this, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().d(AccessibiltyTsnPermissionGreenActivity.this));
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(intent);
        }
    }

    static {
        StubApp.interface11(4654);
    }

    public final void g() {
        a(this, this.f4600o);
        this.f4600o = com.acse.ottn.c.a(this, getResources().getString(R.string.permission_warning), new i());
    }

    @RequiresApi(api = 23)
    @SuppressLint({"RestrictedApi"})
    public final void h() {
        this.f4590e = (ImageView) findViewById(R.id.banner);
        this.f4605t = (TextView) findViewById(R.id.tv_first_line);
        this.f4606u = (TextView) findViewById(R.id.tv_secend_line);
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.checkbox);
        this.f4601p = appCompatCheckBox;
        appCompatCheckBox.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(g0.a().e(this))));
        this.f4601p.setOnCheckedChangeListener(new k());
        this.E = (AutoScrollViewPager) findViewById(R.id.banner1);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_accessiblity);
        this.A = relativeLayout;
        relativeLayout.setOnClickListener(new o());
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_location);
        this.C = relativeLayout2;
        relativeLayout2.setOnClickListener(new p());
        this.f4590e.setOnClickListener(new q());
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_flow_window);
        this.B = relativeLayout3;
        relativeLayout3.setOnClickListener(new r());
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_battery);
        this.D = relativeLayout4;
        relativeLayout4.setOnClickListener(new s());
        this.f4591f = (ImageView) findViewById(R.id.iv_accessiblity_two);
        this.f4592g = (ImageView) findViewById(R.id.iv_flow_window_two);
        this.f4593h = (ImageView) findViewById(R.id.iv_battery_two);
        this.f4594i = (ImageView) findViewById(R.id.iv_accessiblity);
        this.f4596k = (ImageView) findViewById(R.id.iv_location);
        this.f4597l = (ImageView) findViewById(R.id.iv_location_two);
        this.f4595j = (ImageView) findViewById(R.id.iv_flow_window);
        this.f4598m = (ImageView) findViewById(R.id.iv_battery);
        this.G = (RelativeLayout) findViewById(R.id.rl_service);
        this.f4611z = (TextView) findViewById(R.id.tv_location_describe);
        this.f4602q = (TextView) findViewById(R.id.tv_accessiblity_describe);
        this.f4603r = (TextView) findViewById(R.id.tv_flow_describe);
        this.f4599n = (TextView) findViewById(R.id.tv_content);
        this.F = (TextView) findViewById(R.id.tv_warning);
        j();
        this.f4590e.setImageResource(R.mipmap.banner_6);
        TextView textView = (TextView) findViewById(R.id.tv_open);
        this.f4604s = textView;
        textView.setOnClickListener(new t());
        TextView textView2 = (TextView) findViewById(R.id.tv_my_think);
        this.f4610y = textView2;
        textView2.setOnClickListener(new u());
        this.f4608w = (TextView) findViewById(R.id.tv_service);
        this.f4607v = (TextView) findViewById(R.id.tv_privacy);
        i();
    }

    public final void i() {
        g0.a().c(this, this.f4605t);
        g0.a().c(this, this.f4608w);
        g0.a().c(this, this.f4607v);
        g0.a().a(this, this.f4604s);
        g0.a().d(this, this.F);
        this.f4604s.setText(R.string.permission_commit);
        this.f4605t.setText(R.string.permission_title);
        this.f4606u.setText(R.string.permission_title_two);
        this.f4602q.setText(R.string.permission_accessiblity);
        this.f4603r.setText(R.string.permission_flowwindow);
        this.f4599n.setText(R.string.permission_home_back);
        this.f4608w.setOnClickListener(new v());
        this.f4607v.setOnClickListener(new a());
        g0.a().a(this, this.f4594i, this.f4596k, this.f4595j, this.f4598m, this.E, this.f4590e);
    }

    public final void j() {
        g0.a().a(this, this.f4591f, this.f4597l, this.f4592g, this.f4593h, this.A, this.C, this.B, this.D, this.f4611z);
    }

    public final void k() {
        this.f4600o = u0.a(this, null, getString(R.string.permission_all_open), "\u597d\u7684", false, new h());
    }

    public final void l() {
        if (AcseHelpManager.isOPenAllPermission()) {
            d();
        } else if (!this.f4601p.isChecked()) {
            m();
        } else if (!com.acse.ottn.b.d().f()) {
            com.acse.ottn.a.c().a((Activity) this, 10010);
        } else if (!com.acse.ottn.b.d().b()) {
            b(j0.f5781w);
        } else if (("xiaomi".equals(c4.b()) || "redmi".equals(c4.b())) && !g1.a().a("background_battery_hignt") && "2".equals(g1.a().d("flow_window_state"))) {
            a(j0.f5781w);
        } else if (!q4.a().b(getPackageName())) {
            String string = getResources().getString(R.string.dialog_keep_back_two_title);
            if (c4.b().equals("vivo")) {
                string = getResources().getString(R.string.dialog_keep_back_message);
            }
            a(getPackageName(), string);
        } else if (c4.b().equals("vivo")) {
            if (!g1.a().a("background_battery_hignt")) {
                c(getPackageName());
            } else {
                d();
            }
        } else {
            d();
        }
    }

    public final void m() {
        a(this, this.f4600o);
        this.f4600o = u3.a(this, new l());
    }

    @Override // com.acse.ottn.z, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        f();
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 23)
    public native void onCreate(Bundle bundle);

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        a(this, this.f4600o);
        super.onDestroy();
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        a(this, this.f4600o);
        super.onPause();
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i2.a().a("open_accessiblity_page_pv");
        try {
            sendBroadcast(new Intent("logout"));
        } catch (Exception unused) {
        }
        try {
            j();
            boolean b4 = com.acse.ottn.b.d().b();
            if (com.acse.ottn.b.d().f() && this.f4601p.isChecked()) {
                a(this, this.f4600o);
                this.J.postDelayed(this.M, 500L);
            }
            String a4 = p0.d().a();
            String d4 = g1.a().d("send_open_flow_window");
            if (!b4 || a4.equals(d4)) {
                return;
            }
            i2.a().a("open_flow_window");
            g1.a().b("send_open_flow_window", a4);
        } catch (Exception e4) {
            z1.a("sa mo n", "Exception e =" + e4.getMessage());
        }
    }

    public final void c(String str) {
        a(this, this.f4600o);
        this.f4600o = u0.a(this, "\u8017\u7535\u7ba1\u7406:", getResources().getString(R.string.dialog_vivo_battery_message), "\u597d\u7684", false, new c());
    }

    public final void d() {
        e();
    }

    public final void e() {
        a(this, this.f4600o);
        int b4 = g1.a().b("location_permission_size");
        if (!q4.a().b(getPackageName())) {
            a(getPackageName(), getResources().getString(R.string.dialog_keep_back_two_title));
            return;
        }
        if (c4.b().equals("vivo")) {
            if (!g1.a().a("background_battery_hignt")) {
                c(getPackageName());
                return;
            } else if (!y1.a().a((Context) this) && b4 <= 1) {
                a(getResources().getString(R.string.location_title), getResources().getString(R.string.location_content), "1");
                return;
            } else if (!y1.a().b((Context) this) && b4 <= 2) {
                a(getResources().getString(R.string.location_background_title), getResources().getString(R.string.location_background_content), "2");
                return;
            }
        } else if (!y1.a().a((Context) this) && b4 <= 1) {
            a(getResources().getString(R.string.location_title), getResources().getString(R.string.location_content), "1");
            return;
        } else if (!y1.a().b((Context) this) && b4 <= 2) {
            a(getResources().getString(R.string.location_background_title), getResources().getString(R.string.location_background_content), "2");
            return;
        }
        k();
    }

    public final void f() {
        if (System.currentTimeMillis() - this.I > 2000) {
            Toast.makeText(this, "\u518d\u6309\u8fd4\u56de\u952e\u4e00\u6b21\u9000\u51fa", 0).show();
            this.I = System.currentTimeMillis();
            return;
        }
        finish();
    }

    public final void b(String str) {
        com.acse.ottn.b.d().a(false);
        a(this, this.f4600o);
        this.f4600o = u0.a(this, getResources().getString(R.string.dialog_flow_title), getResources().getString(R.string.dialog_flow_message), "\u597d\u7684", false, new j());
    }

    public final void a(String str, String str2) {
        a(this, this.f4600o);
        this.f4600o = u0.a(this, "\u5141\u8bb8\u540e\u53f0\u8fd0\u884c\u548c\u81ea\u542f\u52a8\u6743\u9650:", str2, "\u597d\u7684", false, new g());
    }

    @RequiresApi(api = 23)
    public final void c() {
        if (!com.acse.ottn.b.d().f()) {
            com.acse.ottn.a.c().a((Activity) this, 10010);
        } else if (!com.acse.ottn.b.d().b()) {
            b(j0.f5781w);
        } else {
            d();
        }
        j();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, int i4) {
        com.acse.ottn.a.c().a(appCompatActivity, i4);
    }

    @Override // com.acse.ottn.z
    public void a(int i4) {
        Window window = getWindow();
        a(this, i4, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public final void a(String str) {
        String string = getResources().getString(R.string.dialog_keep_back_title);
        a(this, this.f4600o);
        this.f4600o = u0.a(this, string, getResources().getString(R.string.dialog_keep_back_message), "\u597d\u7684", false, new m());
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3) {
        a(this, this.f4600o);
        this.f4600o = u0.a(this, str, str2, "\u597d\u7684", false, new n(str3));
    }
}
