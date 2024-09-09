package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.stub.StubApp;

/* compiled from: SharedPreferencesUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ae {

    /* renamed from: a  reason: collision with root package name */
    static FastKV f39767a;

    public static void a(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context == null) {
            return;
        }
        if (com.mbridge.msdk.foundation.controller.b.a().d() && f39767a == null) {
            try {
                f39767a = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f39767a = null;
            }
        }
        if (f39767a != null) {
            try {
                if ("String".equals(simpleName)) {
                    f39767a.putString(str, (String) obj);
                } else if ("Integer".equals(simpleName)) {
                    f39767a.putInt(str, ((Integer) obj).intValue());
                } else if ("Boolean".equals(simpleName)) {
                    f39767a.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if ("Float".equals(simpleName)) {
                    f39767a.putFloat(str, ((Float) obj).floatValue());
                } else if ("Long".equals(simpleName)) {
                    f39767a.putLong(str, ((Long) obj).longValue());
                }
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("share_date", 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.apply();
    }

    public static Object b(Context context, String str, Object obj) {
        if (context == null) {
            return obj;
        }
        String simpleName = obj != null ? obj.getClass().getSimpleName() : "";
        if (com.mbridge.msdk.foundation.controller.b.a().d() && f39767a == null) {
            try {
                f39767a = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f39767a = null;
            }
        }
        if (f39767a != null) {
            try {
                if ("String".equals(simpleName)) {
                    return f39767a.getString(str, (String) obj);
                }
                if ("Integer".equals(simpleName)) {
                    return Integer.valueOf(f39767a.getInt(str, ((Integer) obj).intValue()));
                }
                if ("Boolean".equals(simpleName)) {
                    return Boolean.valueOf(f39767a.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
                if ("Float".equals(simpleName)) {
                    return Float.valueOf(f39767a.getFloat(str, ((Float) obj).floatValue()));
                }
                if ("Long".equals(simpleName)) {
                    return Long.valueOf(f39767a.getLong(str, ((Long) obj).longValue()));
                }
            } catch (Exception unused2) {
                return obj;
            }
        } else {
            SharedPreferences sharedPreferences = context.getSharedPreferences("share_date", 0);
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
        }
        return obj;
    }

    public static void a(Context context, String... strArr) {
        if (context == null || strArr == null || strArr.length == 0) {
            return;
        }
        if (com.mbridge.msdk.foundation.controller.b.a().d() && f39767a == null) {
            try {
                f39767a = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f39767a = null;
            }
        }
        int i4 = 0;
        if (f39767a != null) {
            int length = strArr.length;
            while (i4 < length) {
                try {
                    f39767a.remove(strArr[i4]);
                } catch (Exception unused2) {
                }
                i4++;
            }
            return;
        }
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("share_date", 0).edit();
        int length2 = strArr.length;
        while (i4 < length2) {
            edit.remove(strArr[i4]);
            i4++;
        }
        edit.apply();
    }
}
