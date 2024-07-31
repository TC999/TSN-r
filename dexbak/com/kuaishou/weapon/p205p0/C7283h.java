package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: com.kuaishou.weapon.p0.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7283h {

    /* renamed from: a */
    public static final String f24954a = "re_po_rt";

    /* renamed from: e */
    private static C7283h f24955e;

    /* renamed from: b */
    private SharedPreferences f24956b;

    /* renamed from: c */
    private SharedPreferences.Editor f24957c;

    /* renamed from: d */
    private Context f24958d;

    public C7283h(Context context, String str) {
        try {
            this.f24958d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f24956b = sharedPreferences;
            this.f24957c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static synchronized C7283h m33888a(Context context, String str) {
        C7283h c7283h;
        synchronized (C7283h.class) {
            if (f24955e == null) {
                synchronized (C7283h.class) {
                    if (f24955e == null) {
                        f24955e = new C7283h(context, str);
                    }
                }
            }
            c7283h = f24955e;
        }
        return c7283h;
    }

    /* renamed from: b */
    public Context m33880b() {
        return this.f24958d;
    }

    /* renamed from: c */
    public void m33871c(String str, String str2) {
        try {
            this.f24957c.putString(str, str2);
            this.f24957c.apply();
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    public void m33868d(String str, int i) {
        this.f24957c.putInt(str, i);
        this.f24957c.apply();
    }

    /* renamed from: e */
    public boolean m33867e(String str) {
        return this.f24956b.getBoolean(str, false);
    }

    /* renamed from: b */
    public int m33879b(String str) {
        try {
            return this.f24956b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public int m33878b(String str, int i) {
        try {
            return this.f24956b.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: c */
    public void m33870c(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z) {
                str2 = C7212c.m34105b(str2.getBytes(), 2);
            }
            this.f24957c.putString(str, str2);
            this.f24957c.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public long m33869d(String str) {
        return this.f24956b.getLong(str, 0L);
    }

    /* renamed from: b */
    public String m33876b(String str, String str2) {
        return this.f24956b.getString(str, str2);
    }

    public C7283h(Context context) {
        try {
            this.f24958d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f24956b = sharedPreferences;
            this.f24957c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public String m33875b(String str, String str2, boolean z) {
        String m33876b = m33876b(str, "");
        return !TextUtils.isEmpty(m33876b) ? z ? C7212c.m34106b(m33876b, 2) : m33876b : str2;
    }

    /* renamed from: a */
    public static C7283h m33890a() {
        return f24955e;
    }

    /* renamed from: c */
    public int m33872c(String str, int i) {
        try {
            return this.f24956b.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public void m33889a(Context context) {
        this.f24958d = context;
    }

    /* renamed from: b */
    public void m33877b(String str, long j) {
        this.f24957c.putLong(str, j);
        this.f24957c.apply();
    }

    /* renamed from: c */
    public int m33873c(String str) {
        try {
            return this.f24956b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public void m33882a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f24957c.putString(str, str2);
            this.f24957c.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public void m33874c() {
        try {
            this.f24957c.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m33881a(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f24957c.putString(str, str2);
            if (z) {
                this.f24957c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String m33887a(String str) {
        return this.f24956b.getString(str, "");
    }

    /* renamed from: a */
    public void m33886a(String str, int i) {
        try {
            this.f24957c.putInt(str, i);
            this.f24957c.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m33885a(String str, int i, boolean z) {
        try {
            this.f24957c.putInt(str, i);
            if (z) {
                this.f24957c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public long m33884a(String str, long j) {
        return this.f24956b.getLong(str, j);
    }

    /* renamed from: a */
    public void m33883a(String str, Boolean bool) {
        this.f24957c.putBoolean(str, bool.booleanValue());
        this.f24957c.apply();
    }
}
