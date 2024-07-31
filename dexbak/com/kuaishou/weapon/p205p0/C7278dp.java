package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.kuaishou.weapon.p0.dp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7278dp {

    /* renamed from: a */
    public static final String f24924a = "plc001_t_re";

    /* renamed from: b */
    public static final String f24925b = "wlpauct2";

    /* renamed from: c */
    public static final String f24926c = "plc001_pd_ptip_pi";

    /* renamed from: d */
    public static final String f24927d = "wiipaot";

    /* renamed from: e */
    public static final int f24928e = 1;

    /* renamed from: f */
    public static final String f24929f = "a1_p_s_p_s";

    /* renamed from: g */
    public static final String f24930g = "a1_p_s_p_s_c_b";

    /* renamed from: j */
    private static C7278dp f24931j;

    /* renamed from: h */
    private SharedPreferences f24932h;

    /* renamed from: i */
    private SharedPreferences.Editor f24933i;

    private C7278dp(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(C7193bi.f24583r, 4);
            this.f24932h = sharedPreferences;
            this.f24933i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static synchronized C7278dp m33920a(Context context) {
        C7278dp c7278dp;
        synchronized (C7278dp.class) {
            try {
                if (f24931j == null) {
                    f24931j = new C7278dp(context);
                }
                c7278dp = f24931j;
            } catch (Exception unused) {
                return null;
            }
        }
        return c7278dp;
    }

    /* renamed from: b */
    public boolean m33913b(String str) {
        return this.f24932h.getBoolean(str, false);
    }

    /* renamed from: b */
    public void m33912b(String str, String str2) {
        try {
            this.f24933i.putString(str, str2);
            this.f24933i.apply();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static C7278dp m33921a() {
        return f24931j;
    }

    /* renamed from: a */
    public long m33919a(String str) {
        return this.f24932h.getLong(str, 0L);
    }

    /* renamed from: a */
    public void m33916a(String str, long j, boolean z) {
        try {
            this.f24933i.putLong(str, j);
            if (z) {
                this.f24933i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public int m33918a(String str, int i) {
        try {
            return this.f24932h.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* renamed from: a */
    public void m33917a(String str, int i, boolean z) {
        try {
            this.f24933i.putInt(str, i);
            if (z) {
                this.f24933i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m33915a(String str, Boolean bool, boolean z) {
        try {
            SharedPreferences.Editor editor = this.f24933i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z) {
                    this.f24933i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public String m33914a(String str, String str2) {
        return this.f24932h.getString(str, str2);
    }
}
