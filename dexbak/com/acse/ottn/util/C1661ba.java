package com.acse.ottn.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.acse.ottn.activity.AcseHelpManager;

/* renamed from: com.acse.ottn.util.ba */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1661ba {

    /* renamed from: a */
    public static final String f3298a = C1663ca.m56080c().m56081b() + "_info";

    /* renamed from: b */
    private static SharedPreferences f3299b;

    /* renamed from: c */
    private static C1661ba f3300c;

    /* renamed from: d */
    private static SharedPreferences.Editor f3301d;

    private C1661ba() {
        try {
            if (f3299b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences("acse_info", 0);
                f3299b = sharedPreferences;
                f3301d = sharedPreferences.edit();
            }
        } catch (Exception unused) {
        }
    }

    private C1661ba(Context context) {
        m56091b();
    }

    /* renamed from: a */
    public static synchronized C1661ba m56097a() {
        C1661ba c1661ba;
        synchronized (C1661ba.class) {
            try {
                if (f3300c == null) {
                    f3300c = new C1661ba(HelpShopAppUtil.getContext());
                }
                c1661ba = f3300c;
            } catch (Exception unused) {
                if (f3300c == null) {
                    f3300c = new C1661ba();
                }
                return f3300c;
            }
        }
        return c1661ba;
    }

    /* renamed from: a */
    public int m56095a(String str, int i) {
        return f3299b.getInt(str, i);
    }

    /* renamed from: a */
    public String m56093a(String str, String str2) {
        return f3299b.getString(str, str2);
    }

    /* renamed from: a */
    public void m56094a(String str, long j) {
        f3301d.putLong(str, j).apply();
    }

    /* renamed from: a */
    public void m56092a(String str, boolean z) {
        f3301d.putBoolean(str, z).apply();
    }

    /* renamed from: a */
    public boolean m56096a(String str) {
        return f3299b.getBoolean(str, false);
    }

    /* renamed from: b */
    public int m56090b(String str) {
        return f3299b.getInt(str, 0);
    }

    /* renamed from: b */
    public void m56091b() {
        try {
            if (f3299b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences(f3298a, 0);
                f3299b = sharedPreferences;
                f3301d = sharedPreferences.edit();
            }
        } catch (Exception unused) {
            if (f3299b == null) {
                Context context = HelpShopAppUtil.getContext();
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(AcseHelpManager.mContext.getPackageName() + "_info", 0);
                f3299b = sharedPreferences2;
                f3301d = sharedPreferences2.edit();
            }
        }
    }

    /* renamed from: b */
    public void m56089b(String str, int i) {
        f3301d.putInt(str, i).apply();
    }

    /* renamed from: b */
    public void m56088b(String str, String str2) {
        f3301d.putString(str, str2).apply();
    }

    /* renamed from: c */
    public Long m56087c(String str) {
        return Long.valueOf(f3299b.getLong(str, 0L));
    }

    /* renamed from: d */
    public String m56086d(String str) {
        return f3299b.getString(str, "");
    }
}
