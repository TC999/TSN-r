package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bn {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12496a = "mobads_builds";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12497b = "brand_period";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12498c = "version_period";

    /* renamed from: d  reason: collision with root package name */
    public static final long f12499d = 604800000;

    /* renamed from: e  reason: collision with root package name */
    public static final long f12500e = 172800000;

    /* renamed from: f  reason: collision with root package name */
    public static final String f12501f = "sdk_int";

    /* renamed from: g  reason: collision with root package name */
    public static final String f12502g = "sdk";

    /* renamed from: h  reason: collision with root package name */
    public static final String f12503h = "release";

    /* renamed from: i  reason: collision with root package name */
    public static final String f12504i = "model";

    /* renamed from: j  reason: collision with root package name */
    public static final String f12505j = "brand";

    /* renamed from: k  reason: collision with root package name */
    public static final String f12506k = "netopera";

    /* renamed from: l  reason: collision with root package name */
    public static final String f12507l = "tags";

    /* renamed from: m  reason: collision with root package name */
    private int f12508m;

    /* renamed from: n  reason: collision with root package name */
    private String f12509n;

    /* renamed from: o  reason: collision with root package name */
    private String f12510o;

    /* renamed from: p  reason: collision with root package name */
    private String f12511p;

    /* renamed from: q  reason: collision with root package name */
    private String f12512q;

    /* renamed from: r  reason: collision with root package name */
    private String f12513r;

    /* renamed from: s  reason: collision with root package name */
    private String f12514s;

    /* renamed from: t  reason: collision with root package name */
    private Context f12515t;

    /* renamed from: u  reason: collision with root package name */
    private SharedPreferences f12516u;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bn f12517a = new bn();

        private a() {
        }
    }

    public static bn a(Context context) {
        a.f12517a.b(context);
        return a.f12517a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() > b("brand_period").longValue()) {
                this.f12511p = Build.MODEL;
                this.f12512q = Build.BRAND;
                this.f12513r = ((TelephonyManager) this.f12515t.getSystemService("phone")).getNetworkOperator();
                this.f12514s = Build.TAGS;
                a("model", this.f12511p);
                a("brand", this.f12512q);
                a("netopera", this.f12513r);
                a("tags", this.f12514s);
                a("brand_period", Long.valueOf(System.currentTimeMillis() + 604800000));
            } else {
                this.f12511p = a("model");
                this.f12512q = a("brand");
                this.f12513r = a("netopera");
                this.f12514s = a("tags");
            }
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() > b("version_period").longValue()) {
                int i4 = Build.VERSION.SDK_INT;
                this.f12508m = i4;
                this.f12509n = Build.VERSION.SDK;
                this.f12510o = Build.VERSION.RELEASE;
                a("sdk_int", i4);
                a("sdk", this.f12509n);
                a("release", this.f12510o);
                a("version_period", Long.valueOf(System.currentTimeMillis() + 172800000));
            } else {
                this.f12508m = c("sdk_int");
                this.f12509n = a("sdk");
                this.f12510o = a("release");
            }
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.f12516u.edit();
    }

    public void b(Context context) {
        if (this.f12515t == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f12515t = origApplicationContext;
            try {
                if (this.f12516u == null) {
                    this.f12516u = origApplicationContext.getSharedPreferences("mobads_builds", 0);
                    h();
                }
            } catch (Throwable th) {
                bv.a().c(th.getMessage());
            }
        } else if (a.f12517a == null) {
            bc.a(context);
        }
    }

    public String c() {
        return this.f12510o;
    }

    public String d() {
        return this.f12511p;
    }

    public String e() {
        return this.f12512q;
    }

    public String f() {
        return this.f12513r;
    }

    public String g() {
        return this.f12514s;
    }

    private bn() {
        this.f12508m = 0;
        this.f12509n = "";
        this.f12510o = "";
        this.f12511p = "";
        this.f12512q = "";
        this.f12513r = "";
        this.f12514s = "";
    }

    private int c(String str) {
        try {
            return this.f12516u.getInt(str, 0);
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.f12508m == 0) {
            this.f12508m = Build.VERSION.SDK_INT;
        }
        return this.f12508m;
    }

    private String a(String str) {
        try {
            return this.f12516u.getString(str, "");
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k4 = k();
            k4.putString(str, str2);
            k4.apply();
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f12509n)) {
            this.f12509n = Build.VERSION.SDK;
        }
        return this.f12509n;
    }

    @TargetApi(9)
    private void a(String str, Long l4) {
        try {
            SharedPreferences.Editor k4 = k();
            k4.putLong(str, l4.longValue());
            k4.apply();
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.f12516u.getLong(str, 0L));
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i4) {
        try {
            SharedPreferences.Editor k4 = k();
            k4.putInt(str, i4);
            k4.apply();
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }
}
