package com.acse.ottn;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.HelpShopAppUtil;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5667a = h1.c().b() + "_info";

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f5668b;

    /* renamed from: c  reason: collision with root package name */
    public static g1 f5669c;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences.Editor f5670d;

    public g1(Context context) {
        b();
    }

    public static synchronized g1 a() {
        g1 g1Var;
        synchronized (g1.class) {
            try {
                if (f5669c == null) {
                    f5669c = new g1(HelpShopAppUtil.getContext());
                }
                g1Var = f5669c;
            } catch (Exception unused) {
                if (f5669c == null) {
                    f5669c = new g1();
                }
                return f5669c;
            }
        }
        return g1Var;
    }

    public void b() {
        try {
            if (f5668b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences(f5667a, 0);
                f5668b = sharedPreferences;
                if (sharedPreferences != null) {
                    f5670d = sharedPreferences.edit();
                }
            }
        } catch (Exception unused) {
            if (f5668b == null) {
                Context context = HelpShopAppUtil.getContext();
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(AcseHelpManager.mContext.getPackageName() + "_info", 0);
                f5668b = sharedPreferences2;
                if (sharedPreferences2 != null) {
                    f5670d = sharedPreferences2.edit();
                }
            }
        }
    }

    public Long c(String str) {
        SharedPreferences sharedPreferences = f5668b;
        if (sharedPreferences != null && f5669c != null) {
            return Long.valueOf(sharedPreferences.getLong(str, 0L));
        }
        return 0L;
    }

    public String d(String str) {
        SharedPreferences sharedPreferences = f5668b;
        return (sharedPreferences == null || f5669c == null) ? "" : sharedPreferences.getString(str, "");
    }

    public g1() {
        try {
            if (f5668b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences("acse_info", 0);
                f5668b = sharedPreferences;
                if (sharedPreferences != null) {
                    f5670d = sharedPreferences.edit();
                }
            }
        } catch (Exception e4) {
            Log.d("preferences", e4.getMessage());
        }
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = f5668b;
        return (sharedPreferences == null || f5669c == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editor = f5670d;
        if (editor == null) {
            return;
        }
        editor.putString(str, str2).apply();
    }

    public void a(String str, long j4) {
        SharedPreferences.Editor editor = f5670d;
        if (editor == null) {
            return;
        }
        editor.putLong(str, j4).apply();
    }

    public void b(String str, int i4) {
        SharedPreferences.Editor editor = f5670d;
        if (editor == null) {
            return;
        }
        editor.putInt(str, i4).apply();
    }

    public int a(String str, int i4) {
        SharedPreferences sharedPreferences = f5668b;
        return (sharedPreferences == null || f5669c == null) ? i4 : sharedPreferences.getInt(str, i4);
    }

    public int b(String str) {
        SharedPreferences sharedPreferences = f5668b;
        if (sharedPreferences == null || f5669c == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    public void a(String str, boolean z3) {
        SharedPreferences.Editor editor = f5670d;
        if (editor == null) {
            return;
        }
        editor.putBoolean(str, z3).apply();
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = f5668b;
        if (sharedPreferences == null || f5669c == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }
}
