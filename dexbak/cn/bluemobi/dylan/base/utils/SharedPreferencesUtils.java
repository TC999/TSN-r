package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: cn.bluemobi.dylan.base.utils.r */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SharedPreferencesUtils {

    /* renamed from: a */
    private Context f1826a;

    /* renamed from: b */
    private String f1827b;

    public SharedPreferencesUtils(String str) {
        this.f1827b = str;
    }

    /* renamed from: a */
    public void m57698a() {
        SharedPreferences.Editor edit = this.f1826a.getSharedPreferences(this.f1827b, 0).edit();
        edit.clear();
        edit.commit();
    }

    /* renamed from: b */
    public Object m57697b(String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = this.f1826a.getSharedPreferences(this.f1827b, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    /* renamed from: c */
    public void m57696c(String str) {
        SharedPreferences.Editor edit = this.f1826a.getSharedPreferences(this.f1827b, 0).edit();
        edit.remove(str);
        edit.commit();
    }

    /* renamed from: d */
    public void m57695d(String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor edit = this.f1826a.getSharedPreferences(this.f1827b, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, obj.toString());
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public SharedPreferencesUtils(Context context) {
        this.f1827b = "share_date";
        this.f1826a = context;
    }
}
