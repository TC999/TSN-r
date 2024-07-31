package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.stub.StubApp;

/* compiled from: SharedPreferencesUtils.java */
/* renamed from: com.mbridge.msdk.foundation.tools.ae */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11400ae {

    /* renamed from: a */
    static FastKV f30994a;

    /* renamed from: a */
    public static void m21963a(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context == null) {
            return;
        }
        if (SDKController.m22827a().m22818d() && f30994a == null) {
            try {
                f30994a = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f30994a = null;
            }
        }
        if (f30994a != null) {
            try {
                if ("String".equals(simpleName)) {
                    f30994a.putString(str, (String) obj);
                } else if ("Integer".equals(simpleName)) {
                    f30994a.putInt(str, ((Integer) obj).intValue());
                } else if ("Boolean".equals(simpleName)) {
                    f30994a.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if ("Float".equals(simpleName)) {
                    f30994a.putFloat(str, ((Float) obj).floatValue());
                } else if ("Long".equals(simpleName)) {
                    f30994a.putLong(str, ((Long) obj).longValue());
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

    /* renamed from: b */
    public static Object m21961b(Context context, String str, Object obj) {
        if (context == null) {
            return obj;
        }
        String simpleName = obj != null ? obj.getClass().getSimpleName() : "";
        if (SDKController.m22827a().m22818d() && f30994a == null) {
            try {
                f30994a = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f30994a = null;
            }
        }
        if (f30994a != null) {
            try {
                if ("String".equals(simpleName)) {
                    return f30994a.getString(str, (String) obj);
                }
                if ("Integer".equals(simpleName)) {
                    return Integer.valueOf(f30994a.getInt(str, ((Integer) obj).intValue()));
                }
                if ("Boolean".equals(simpleName)) {
                    return Boolean.valueOf(f30994a.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
                if ("Float".equals(simpleName)) {
                    return Float.valueOf(f30994a.getFloat(str, ((Float) obj).floatValue()));
                }
                if ("Long".equals(simpleName)) {
                    return Long.valueOf(f30994a.getLong(str, ((Long) obj).longValue()));
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

    /* renamed from: a */
    public static void m21962a(Context context, String... strArr) {
        if (context == null || strArr == null || strArr.length == 0) {
            return;
        }
        if (SDKController.m22827a().m22818d() && f30994a == null) {
            try {
                f30994a = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f30994a = null;
            }
        }
        int i = 0;
        if (f30994a != null) {
            int length = strArr.length;
            while (i < length) {
                try {
                    f30994a.remove(strArr[i]);
                } catch (Exception unused2) {
                }
                i++;
            }
            return;
        }
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("share_date", 0).edit();
        int length2 = strArr.length;
        while (i < length2) {
            edit.remove(strArr[i]);
            i++;
        }
        edit.apply();
    }
}
