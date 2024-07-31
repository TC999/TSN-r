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
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.acse.ottn.C1239R;
import com.acse.ottn.adapter.AbstractC1314d;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.acse.ottn.p035b.C1403C;
import com.acse.ottn.p035b.C1418d;
import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.p042d.C1533k;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1650T;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1666e;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1692qa;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.C1703va;
import com.acse.ottn.util.CommonUtil;
import com.baidu.mobads.sdk.internal.C2606av;
import com.bxkj.student.C4229c;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AccessibiltyTsnPermissionGreenActivity extends ActivityC1305w {

    /* renamed from: A */
    private RelativeLayout f2045A;

    /* renamed from: B */
    private RelativeLayout f2046B;

    /* renamed from: C */
    private RelativeLayout f2047C;

    /* renamed from: D */
    private AutoScrollViewPager f2048D;

    /* renamed from: E */
    private TextView f2049E;

    /* renamed from: F */
    private RelativeLayout f2050F;

    /* renamed from: G */
    private AbstractC1314d.InterfaceC1315a f2051G = new C1284b(this);

    /* renamed from: H */
    private long f2052H = 0;

    /* renamed from: I */
    private Handler f2053I = new Handler();

    /* renamed from: J */
    Runnable f2054J = new RunnableC1286d(this);

    /* renamed from: K */
    Runnable f2055K = new RunnableC1287e(this);

    /* renamed from: L */
    Runnable f2056L = new RunnableC1288f(this);

    /* renamed from: d */
    private ImageView f2057d;

    /* renamed from: e */
    private ImageView f2058e;

    /* renamed from: f */
    private ImageView f2059f;

    /* renamed from: g */
    private ImageView f2060g;

    /* renamed from: h */
    private ImageView f2061h;

    /* renamed from: i */
    private ImageView f2062i;

    /* renamed from: j */
    private ImageView f2063j;

    /* renamed from: k */
    private ImageView f2064k;

    /* renamed from: l */
    private ImageView f2065l;

    /* renamed from: m */
    private TextView f2066m;

    /* renamed from: n */
    private AlertDialog f2067n;

    /* renamed from: o */
    private AppCompatCheckBox f2068o;

    /* renamed from: p */
    private TextView f2069p;

    /* renamed from: q */
    private TextView f2070q;

    /* renamed from: r */
    private TextView f2071r;

    /* renamed from: s */
    private TextView f2072s;

    /* renamed from: t */
    private TextView f2073t;

    /* renamed from: u */
    private TextView f2074u;

    /* renamed from: v */
    private TextView f2075v;

    /* renamed from: w */
    private TextView f2076w;

    /* renamed from: x */
    private TextView f2077x;

    /* renamed from: y */
    private TextView f2078y;

    /* renamed from: z */
    private RelativeLayout f2079z;

    static {
        StubApp.interface11(4136);
    }

    /* renamed from: a */
    public static void m57335a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m57334a(AppCompatActivity appCompatActivity, String str, int i) {
        C1666e.m56042c().m56053a(appCompatActivity, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m57330a(String str) {
        String string = getResources().getString(C1239R.C1245string.dialog_keep_back_title);
        m57335a(this, this.f2067n);
        this.f2067n = C1426k.m56822a(this, string, getResources().getString(C1239R.C1245string.dialog_keep_back_message), "好的", false, new C1295m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m57329a(String str, String str2) {
        m57335a(this, this.f2067n);
        this.f2067n = C1426k.m56822a(this, "允许后台运行和自启动权限:", str2, "好的", false, new C1289g(this));
    }

    /* renamed from: a */
    private void m57328a(String str, String str2, String str3) {
        m57335a(this, this.f2067n);
        this.f2067n = C1426k.m56822a(this, str, str2, "好的", false, new C1296n(this, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m57325b(String str) {
        C1684n.m55975c().m55985a(false);
        m57335a(this, this.f2067n);
        this.f2067n = C1426k.m56822a(this, getResources().getString(C1239R.C1245string.dialog_flow_title), getResources().getString(C1239R.C1245string.dialog_flow_message), "好的", false, new C1292j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    /* renamed from: c */
    public void m57324c() {
        if (!C1684n.m55975c().m55965e()) {
            C1666e.m56042c().m56062a((Activity) this, 10010);
        } else if (C1684n.m55975c().m55984b()) {
            m57321d();
        } else {
            m57325b(CommonUtil.PACKAGE_NAME);
        }
        m57312j();
    }

    /* renamed from: c */
    private void m57322c(String str) {
        m57335a(this, this.f2067n);
        this.f2067n = C1426k.m56822a(this, "耗电管理:", getResources().getString(C1239R.C1245string.dialog_vivo_battery_message), "好的", false, new C1285c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m57321d() {
        m57319e();
    }

    /* renamed from: e */
    private void m57319e() {
        m57335a(this, this.f2067n);
        int m56090b = C1661ba.m56097a().m56090b("location_permission_size");
        if (!C1533k.m56493a().m56489b(getPackageName())) {
            m57329a(getPackageName(), getResources().getString(C1239R.C1245string.dialog_keep_back_two_title));
            return;
        }
        if (C1638Ka.m56193b().equals("vivo")) {
            if (!C1661ba.m56097a().m56096a("background_battery_hignt")) {
                m57322c(getPackageName());
                return;
            } else if (!C1692qa.m55930a().m55928a((Context) this) && m56090b <= 1) {
                m57328a(getResources().getString(C1239R.C1245string.location_title), getResources().getString(C1239R.C1245string.location_content), "1");
                return;
            } else if (!C1692qa.m55930a().m55925b((Context) this) && m56090b <= 2) {
                m57328a(getResources().getString(C1239R.C1245string.location_background_title), getResources().getString(C1239R.C1245string.location_background_content), "2");
                return;
            }
        } else if (!C1692qa.m55930a().m55928a((Context) this) && m56090b <= 1) {
            m57328a(getResources().getString(C1239R.C1245string.location_title), getResources().getString(C1239R.C1245string.location_content), "1");
            return;
        } else if (!C1692qa.m55930a().m55925b((Context) this) && m56090b <= 2) {
            m57328a(getResources().getString(C1239R.C1245string.location_background_title), getResources().getString(C1239R.C1245string.location_background_content), "2");
            return;
        }
        m57311k();
    }

    /* renamed from: f */
    private void m57317f() {
        if (System.currentTimeMillis() - this.f2052H <= 2000) {
            finish();
            return;
        }
        Toast.makeText(this, "再按返回键一次退出", 0).show();
        this.f2052H = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m57315g() {
        m57335a(this, this.f2067n);
        this.f2067n = C1418d.m56832a(this, getResources().getString(C1239R.C1245string.permission_warning), new C1291i(this));
    }

    @RequiresApi(api = 23)
    @SuppressLint({"RestrictedApi"})
    /* renamed from: h */
    private void m57314h() {
        this.f2057d = (ImageView) findViewById(C1239R.C1242id.banner);
        this.f2072s = (TextView) findViewById(C1239R.C1242id.tv_first_line);
        this.f2073t = (TextView) findViewById(C1239R.C1242id.tv_secend_line);
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(C1239R.C1242id.checkbox);
        this.f2068o = appCompatCheckBox;
        appCompatCheckBox.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(C1633I.m56254a().m56238e(this))));
        this.f2068o.setOnCheckedChangeListener(new C1293k(this));
        this.f2048D = (AutoScrollViewPager) findViewById(C1239R.C1242id.banner1);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1239R.C1242id.rl_accessiblity);
        this.f2079z = relativeLayout;
        relativeLayout.setOnClickListener(new View$OnClickListenerC1297o(this));
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(C1239R.C1242id.rl_location);
        this.f2046B = relativeLayout2;
        relativeLayout2.setOnClickListener(new View$OnClickListenerC1298p(this));
        this.f2057d.setOnClickListener(new View$OnClickListenerC1299q(this));
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(C1239R.C1242id.rl_flow_window);
        this.f2045A = relativeLayout3;
        relativeLayout3.setOnClickListener(new View$OnClickListenerC1300r(this));
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(C1239R.C1242id.rl_battery);
        this.f2047C = relativeLayout4;
        relativeLayout4.setOnClickListener(new View$OnClickListenerC1301s(this));
        this.f2058e = (ImageView) findViewById(C1239R.C1242id.iv_accessiblity_two);
        this.f2059f = (ImageView) findViewById(C1239R.C1242id.iv_flow_window_two);
        this.f2060g = (ImageView) findViewById(C1239R.C1242id.iv_battery_two);
        this.f2061h = (ImageView) findViewById(C1239R.C1242id.iv_accessiblity);
        this.f2063j = (ImageView) findViewById(C1239R.C1242id.iv_location);
        this.f2064k = (ImageView) findViewById(C1239R.C1242id.iv_location_two);
        this.f2062i = (ImageView) findViewById(C1239R.C1242id.iv_flow_window);
        this.f2065l = (ImageView) findViewById(C1239R.C1242id.iv_battery);
        this.f2050F = (RelativeLayout) findViewById(C1239R.C1242id.rl_service);
        this.f2078y = (TextView) findViewById(C1239R.C1242id.tv_location_describe);
        this.f2069p = (TextView) findViewById(C1239R.C1242id.tv_accessiblity_describe);
        this.f2070q = (TextView) findViewById(C1239R.C1242id.tv_flow_describe);
        this.f2066m = (TextView) findViewById(C1239R.C1242id.tv_content);
        this.f2049E = (TextView) findViewById(C1239R.C1242id.tv_warning);
        m57312j();
        this.f2057d.setImageResource(C1239R.mipmap.banner_6);
        TextView textView = (TextView) findViewById(C1239R.C1242id.tv_open);
        this.f2071r = textView;
        textView.setOnClickListener(new View$OnClickListenerC1302t(this));
        TextView textView2 = (TextView) findViewById(C1239R.C1242id.tv_my_think);
        this.f2077x = textView2;
        textView2.setOnClickListener(new View$OnClickListenerC1303u(this));
        this.f2075v = (TextView) findViewById(C1239R.C1242id.tv_service);
        this.f2074u = (TextView) findViewById(C1239R.C1242id.tv_privacy);
        m57313i();
    }

    /* renamed from: i */
    private void m57313i() {
        C1633I.m56254a().m56241c(this, this.f2072s);
        C1633I.m56254a().m56241c(this, this.f2075v);
        C1633I.m56254a().m56241c(this, this.f2074u);
        C1633I.m56254a().m56248a(this, this.f2071r);
        C1633I.m56254a().m56239d(this, this.f2049E);
        this.f2071r.setText(C1239R.C1245string.permission_commit);
        this.f2072s.setText(C1239R.C1245string.permission_title);
        this.f2073t.setText(C1239R.C1245string.permission_title_two);
        this.f2069p.setText(C1239R.C1245string.permission_accessiblity);
        this.f2070q.setText(C1239R.C1245string.permission_flowwindow);
        this.f2066m.setText(C1239R.C1245string.permission_home_back);
        this.f2075v.setOnClickListener(new View$OnClickListenerC1304v(this));
        this.f2074u.setOnClickListener(new View$OnClickListenerC1283a(this));
        C1633I.m56254a().m56249a(this, this.f2061h, this.f2063j, this.f2062i, this.f2065l, this.f2048D, this.f2057d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m57312j() {
        C1633I.m56254a().m56250a(this, this.f2058e, this.f2064k, this.f2059f, this.f2060g, this.f2079z, this.f2046B, this.f2045A, this.f2047C, this.f2078y);
    }

    /* renamed from: k */
    private void m57311k() {
        this.f2067n = C1426k.m56822a(this, null, getString(C1239R.C1245string.permission_all_open), "好的", false, new C1290h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m57310l() {
        if (AcseHelpManager.isOPenAllPermission()) {
            m57321d();
        } else if (!this.f2068o.isChecked()) {
            m57309m();
        } else if (!C1684n.m55975c().m55965e()) {
            C1666e.m56042c().m56062a((Activity) this, 10010);
        } else if (!C1684n.m55975c().m55984b()) {
            m57325b(CommonUtil.PACKAGE_NAME);
        } else if ((C4229c.f16088d.equals(C1638Ka.m56193b()) || "redmi".equals(C1638Ka.m56193b())) && !C1661ba.m56097a().m56096a("background_battery_hignt") && "2".equals(C1661ba.m56097a().m56086d("flow_window_state"))) {
            m57330a(CommonUtil.PACKAGE_NAME);
        } else if (!C1533k.m56493a().m56489b(getPackageName())) {
            String string = getResources().getString(C1239R.C1245string.dialog_keep_back_two_title);
            if (C1638Ka.m56193b().equals("vivo")) {
                string = getResources().getString(C1239R.C1245string.dialog_keep_back_message);
            }
            m57329a(getPackageName(), string);
        } else if (!C1638Ka.m56193b().equals("vivo") || C1661ba.m56097a().m56096a("background_battery_hignt")) {
            m57321d();
        } else {
            m57322c(getPackageName());
        }
    }

    /* renamed from: m */
    private void m57309m() {
        m57335a(this, this.f2067n);
        this.f2067n = C1403C.m56848a(this, new C1294l(this));
    }

    @Override // com.acse.ottn.activity.ActivityC1305w
    /* renamed from: a */
    public void mo57260a(int i) {
        Window window = getWindow();
        m57258a(this, i, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        m57317f();
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 23)
    protected native void onCreate(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m57335a(this, this.f2067n);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        m57335a(this, this.f2067n);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C1703va.m55903a().m55901a("open_accessiblity_page_pv");
        try {
            sendBroadcast(new Intent(C2606av.f8628b));
        } catch (Exception unused) {
        }
        try {
            m57312j();
            boolean m55984b = C1684n.m55975c().m55984b();
            if (C1684n.m55975c().m55965e() && this.f2068o.isChecked()) {
                m57335a(this, this.f2067n);
                this.f2053I.postDelayed(this.f2056L, 500L);
            }
            String m56161a = C1650T.m56150d().m56161a();
            String m56086d = C1661ba.m56097a().m56086d("send_open_flow_window");
            if (!m55984b || m56161a.equals(m56086d)) {
                return;
            }
            C1703va.m55903a().m55901a("open_flow_window");
            C1661ba.m56097a().m56088b("send_open_flow_window", m56161a);
        } catch (Exception e) {
            C1694ra.m55917a("sa mo n", "Exception e =" + e.getMessage());
        }
    }
}
