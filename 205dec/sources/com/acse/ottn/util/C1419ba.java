package com.acse.ottn.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.acse.ottn.activity.AcseHelpManager;

/* renamed from: com.acse.ottn.util.ba  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1419ba {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6808a = C1421ca.c().b() + "_info";

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f6809b;

    /* renamed from: c  reason: collision with root package name */
    private static C1419ba f6810c;

    /* renamed from: d  reason: collision with root package name */
    private static SharedPreferences.Editor f6811d;

    private C1419ba() {
        try {
            if (f6809b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences("acse_info", 0);
                f6809b = sharedPreferences;
                f6811d = sharedPreferences.edit();
            }
        } catch (Exception unused) {
        }
    }

    private C1419ba(Context context) {
        b();
    }

    public static synchronized C1419ba a() {
        C1419ba c1419ba;
        synchronized (C1419ba.class) {
            try {
                if (f6810c == null) {
                    f6810c = new C1419ba(HelpShopAppUtil.getContext());
                }
                c1419ba = f6810c;
            } catch (Exception unused) {
                if (f6810c == null) {
                    f6810c = new C1419ba();
                }
                return f6810c;
            }
        }
        return c1419ba;
    }

    public int a(String str, int i4) {
        return f6809b.getInt(str, i4);
    }

    public String a(String str, String str2) {
        return f6809b.getString(str, str2);
    }

    public void a(String str, long j4) {
        f6811d.putLong(str, j4).apply();
    }

    public void a(String str, boolean z3) {
        f6811d.putBoolean(str, z3).apply();
    }

    public boolean a(String str) {
        return f6809b.getBoolean(str, false);
    }

    public int b(String str) {
        return f6809b.getInt(str, 0);
    }

    public void b() {
        try {
            if (f6809b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences(f6808a, 0);
                f6809b = sharedPreferences;
                f6811d = sharedPreferences.edit();
            }
        } catch (Exception unused) {
            if (f6809b == null) {
                Context context = HelpShopAppUtil.getContext();
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(AcseHelpManager.mContext.getPackageName() + "_info", 0);
                f6809b = sharedPreferences2;
                f6811d = sharedPreferences2.edit();
            }
        }
    }

    public void b(String str, int i4) {
        f6811d.putInt(str, i4).apply();
    }

    public void b(String str, String str2) {
        f6811d.putString(str, str2).apply();
    }

    public Long c(String str) {
        return Long.valueOf(f6809b.getLong(str, 0L));
    }

    public String d(String str) {
        return f6809b.getString(str, "");
    }
}
