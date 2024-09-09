package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38350a = "re_po_rt";

    /* renamed from: e  reason: collision with root package name */
    private static h f38351e;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f38352b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences.Editor f38353c;

    /* renamed from: d  reason: collision with root package name */
    private Context f38354d;

    public h(Context context, String str) {
        try {
            this.f38354d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f38352b = sharedPreferences;
            this.f38353c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized h a(Context context, String str) {
        h hVar;
        synchronized (h.class) {
            if (f38351e == null) {
                synchronized (h.class) {
                    if (f38351e == null) {
                        f38351e = new h(context, str);
                    }
                }
            }
            hVar = f38351e;
        }
        return hVar;
    }

    public Context b() {
        return this.f38354d;
    }

    public void c(String str, String str2) {
        try {
            this.f38353c.putString(str, str2);
            this.f38353c.apply();
        } catch (Exception unused) {
        }
    }

    public void d(String str, int i4) {
        this.f38353c.putInt(str, i4);
        this.f38353c.apply();
    }

    public boolean e(String str) {
        return this.f38352b.getBoolean(str, false);
    }

    public int b(String str) {
        try {
            return this.f38352b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int b(String str, int i4) {
        try {
            return this.f38352b.getInt(str, i4);
        } catch (Exception unused) {
            return i4;
        }
    }

    public void c(String str, String str2, boolean z3) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z3) {
                str2 = c.b(str2.getBytes(), 2);
            }
            this.f38353c.putString(str, str2);
            this.f38353c.apply();
        } catch (Throwable unused) {
        }
    }

    public long d(String str) {
        return this.f38352b.getLong(str, 0L);
    }

    public String b(String str, String str2) {
        return this.f38352b.getString(str, str2);
    }

    public h(Context context) {
        try {
            this.f38354d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f38352b = sharedPreferences;
            this.f38353c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public String b(String str, String str2, boolean z3) {
        String b4 = b(str, "");
        return !TextUtils.isEmpty(b4) ? z3 ? c.b(b4, 2) : b4 : str2;
    }

    public static h a() {
        return f38351e;
    }

    public int c(String str, int i4) {
        try {
            return this.f38352b.getInt(str, i4);
        } catch (Exception unused) {
            return i4;
        }
    }

    public void a(Context context) {
        this.f38354d = context;
    }

    public void b(String str, long j4) {
        this.f38353c.putLong(str, j4);
        this.f38353c.apply();
    }

    public int c(String str) {
        try {
            return this.f38352b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f38353c.putString(str, str2);
            this.f38353c.apply();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            this.f38353c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, boolean z3) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f38353c.putString(str, str2);
            if (z3) {
                this.f38353c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        return this.f38352b.getString(str, "");
    }

    public void a(String str, int i4) {
        try {
            this.f38353c.putInt(str, i4);
            this.f38353c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, int i4, boolean z3) {
        try {
            this.f38353c.putInt(str, i4);
            if (z3) {
                this.f38353c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public long a(String str, long j4) {
        return this.f38352b.getLong(str, j4);
    }

    public void a(String str, Boolean bool) {
        this.f38353c.putBoolean(str, bool.booleanValue());
        this.f38353c.apply();
    }
}
