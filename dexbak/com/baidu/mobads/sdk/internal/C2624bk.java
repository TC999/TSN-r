package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* renamed from: com.baidu.mobads.sdk.internal.bk */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2624bk {

    /* renamed from: a */
    public static final String f8677a = "mobads_builds";

    /* renamed from: b */
    public static final String f8678b = "brand_period";

    /* renamed from: c */
    public static final String f8679c = "version_period";

    /* renamed from: d */
    public static final long f8680d = 604800000;

    /* renamed from: e */
    public static final long f8681e = 172800000;

    /* renamed from: f */
    public static final String f8682f = "sdk_int";

    /* renamed from: g */
    public static final String f8683g = "sdk";

    /* renamed from: h */
    public static final String f8684h = "release";

    /* renamed from: i */
    public static final String f8685i = "model";

    /* renamed from: j */
    public static final String f8686j = "brand";

    /* renamed from: k */
    public static final String f8687k = "netopera";

    /* renamed from: l */
    public static final String f8688l = "tags";

    /* renamed from: m */
    private int f8689m;

    /* renamed from: n */
    private String f8690n;

    /* renamed from: o */
    private String f8691o;

    /* renamed from: p */
    private String f8692p;

    /* renamed from: q */
    private String f8693q;

    /* renamed from: r */
    private String f8694r;

    /* renamed from: s */
    private String f8695s;

    /* renamed from: t */
    private Context f8696t;

    /* renamed from: u */
    private SharedPreferences f8697u;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.sdk.internal.bk$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2625a {

        /* renamed from: a */
        private static final C2624bk f8698a = new C2624bk();

        private C2625a() {
        }
    }

    /* renamed from: a */
    public static C2624bk m50799a(Context context) {
        C2625a.f8698a.m50793b(context);
        return C2625a.f8698a;
    }

    /* renamed from: h */
    private void m50785h() {
        m50784i();
        m50783j();
    }

    /* renamed from: i */
    private void m50784i() {
        try {
            if (System.currentTimeMillis() > m50792b(f8678b).longValue()) {
                this.f8692p = Build.MODEL;
                this.f8693q = Build.BRAND;
                this.f8694r = ((TelephonyManager) this.f8696t.getSystemService("phone")).getNetworkOperator();
                this.f8695s = Build.TAGS;
                m50795a(f8685i, this.f8692p);
                m50795a(f8686j, this.f8693q);
                m50795a(f8687k, this.f8694r);
                m50795a("tags", this.f8695s);
                m50796a(f8678b, Long.valueOf(System.currentTimeMillis() + f8680d));
            } else {
                this.f8692p = m50798a(f8685i);
                this.f8693q = m50798a(f8686j);
                this.f8694r = m50798a(f8687k);
                this.f8695s = m50798a("tags");
            }
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
        }
    }

    /* renamed from: j */
    private void m50783j() {
        try {
            if (System.currentTimeMillis() > m50792b(f8679c).longValue()) {
                int i = Build.VERSION.SDK_INT;
                this.f8689m = i;
                this.f8690n = Build.VERSION.SDK;
                this.f8691o = Build.VERSION.RELEASE;
                m50797a(f8682f, i);
                m50795a("sdk", this.f8690n);
                m50795a("release", this.f8691o);
                m50796a(f8679c, Long.valueOf(System.currentTimeMillis() + f8681e));
            } else {
                this.f8689m = m50790c(f8682f);
                this.f8690n = m50798a("sdk");
                this.f8691o = m50798a("release");
            }
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
        }
    }

    /* renamed from: k */
    private SharedPreferences.Editor m50782k() {
        return this.f8697u.edit();
    }

    /* renamed from: b */
    public void m50793b(Context context) {
        if (this.f8696t == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8696t = origApplicationContext;
            try {
                if (this.f8697u == null) {
                    this.f8697u = origApplicationContext.getSharedPreferences(f8677a, 0);
                    m50785h();
                }
            } catch (Throwable th) {
                C2634bs.m50744a().m50731c(th.getMessage());
            }
        } else if (C2625a.f8698a == null) {
            C2611az.m50844a(context);
        }
    }

    /* renamed from: c */
    public String m50791c() {
        return this.f8691o;
    }

    /* renamed from: d */
    public String m50789d() {
        return this.f8692p;
    }

    /* renamed from: e */
    public String m50788e() {
        return this.f8693q;
    }

    /* renamed from: f */
    public String m50787f() {
        return this.f8694r;
    }

    /* renamed from: g */
    public String m50786g() {
        return this.f8695s;
    }

    private C2624bk() {
        this.f8689m = 0;
        this.f8690n = "";
        this.f8691o = "";
        this.f8692p = "";
        this.f8693q = "";
        this.f8694r = "";
        this.f8695s = "";
    }

    /* renamed from: c */
    private int m50790c(String str) {
        try {
            return this.f8697u.getInt(str, 0);
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
            return 0;
        }
    }

    /* renamed from: a */
    public int m50800a() {
        if (this.f8689m == 0) {
            this.f8689m = Build.VERSION.SDK_INT;
        }
        return this.f8689m;
    }

    /* renamed from: a */
    private String m50798a(String str) {
        try {
            return this.f8697u.getString(str, "");
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    /* renamed from: a */
    private void m50795a(String str, String str2) {
        try {
            SharedPreferences.Editor m50782k = m50782k();
            m50782k.putString(str, str2);
            m50782k.apply();
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
        }
    }

    /* renamed from: b */
    public String m50794b() {
        if (TextUtils.isEmpty(this.f8690n)) {
            this.f8690n = Build.VERSION.SDK;
        }
        return this.f8690n;
    }

    @TargetApi(9)
    /* renamed from: a */
    private void m50796a(String str, Long l) {
        try {
            SharedPreferences.Editor m50782k = m50782k();
            m50782k.putLong(str, l.longValue());
            m50782k.apply();
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
        }
    }

    /* renamed from: b */
    private Long m50792b(String str) {
        try {
            return Long.valueOf(this.f8697u.getLong(str, 0L));
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    /* renamed from: a */
    private void m50797a(String str, int i) {
        try {
            SharedPreferences.Editor m50782k = m50782k();
            m50782k.putInt(str, i);
            m50782k.apply();
        } catch (Throwable th) {
            C2634bs.m50744a().m50731c(th.getMessage());
        }
    }
}
