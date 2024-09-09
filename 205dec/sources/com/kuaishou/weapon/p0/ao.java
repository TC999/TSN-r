package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ao {
    public boolean a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean b() {
        try {
            throw new Exception("");
        } catch (Exception e4) {
            for (StackTraceElement stackTraceElement : e4.getStackTrace()) {
                if (stackTraceElement.getClassName().contains("de.robv.android.xposed.XposedBridge")) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean c() {
        return a("com.elderdrivers.riru.edxp.config.EdXpConfigGlobal");
    }

    public boolean d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass("de.robv.android.xposed.XposedHelpers").newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        }
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass("de.robv.android.xposed.XposedBridge").newInstance();
            } catch (ClassNotFoundException unused3) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused4) {
            }
        }
        return true;
    }

    public String e() {
        try {
            return System.getProperty("vxp");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean f() {
        try {
            String str = System.getenv("CLASSPATH");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("XposedBridge");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean g() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    private boolean a(String str) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(str).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
            }
        }
        return true;
    }
}
