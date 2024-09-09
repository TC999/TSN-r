package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dp {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38320a = "plc001_t_re";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38321b = "wlpauct2";

    /* renamed from: c  reason: collision with root package name */
    public static final String f38322c = "plc001_pd_ptip_pi";

    /* renamed from: d  reason: collision with root package name */
    public static final String f38323d = "wiipaot";

    /* renamed from: e  reason: collision with root package name */
    public static final int f38324e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f38325f = "a1_p_s_p_s";

    /* renamed from: g  reason: collision with root package name */
    public static final String f38326g = "a1_p_s_p_s_c_b";

    /* renamed from: j  reason: collision with root package name */
    private static dp f38327j;

    /* renamed from: h  reason: collision with root package name */
    private SharedPreferences f38328h;

    /* renamed from: i  reason: collision with root package name */
    private SharedPreferences.Editor f38329i;

    private dp(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("acbd", 4);
            this.f38328h = sharedPreferences;
            this.f38329i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized dp a(Context context) {
        dp dpVar;
        synchronized (dp.class) {
            try {
                if (f38327j == null) {
                    f38327j = new dp(context);
                }
                dpVar = f38327j;
            } catch (Exception unused) {
                return null;
            }
        }
        return dpVar;
    }

    public boolean b(String str) {
        return this.f38328h.getBoolean(str, false);
    }

    public void b(String str, String str2) {
        try {
            this.f38329i.putString(str, str2);
            this.f38329i.apply();
        } catch (Exception unused) {
        }
    }

    public static dp a() {
        return f38327j;
    }

    public long a(String str) {
        return this.f38328h.getLong(str, 0L);
    }

    public void a(String str, long j4, boolean z3) {
        try {
            this.f38329i.putLong(str, j4);
            if (z3) {
                this.f38329i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int a(String str, int i4) {
        try {
            return this.f38328h.getInt(str, i4);
        } catch (Throwable unused) {
            return i4;
        }
    }

    public void a(String str, int i4, boolean z3) {
        try {
            this.f38329i.putInt(str, i4);
            if (z3) {
                this.f38329i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z3) {
        try {
            SharedPreferences.Editor editor = this.f38329i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z3) {
                    this.f38329i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public String a(String str, String str2) {
        return this.f38328h.getString(str, str2);
    }
}
