package cn.jpush.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f3897a;

    public static void a(Context context) {
        if (f3897a == null) {
            f3897a = context.getSharedPreferences("asus_push_sdk_preferences", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f3897a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, boolean z3) {
        SharedPreferences sharedPreferences = f3897a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Boolean b(String str, boolean z3) {
        SharedPreferences sharedPreferences = f3897a;
        return sharedPreferences != null ? Boolean.valueOf(sharedPreferences.getBoolean(str, true)) : Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(String str, String str2) {
        SharedPreferences sharedPreferences = f3897a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }
}
