package com.kuaishou.weapon.p205p0;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* renamed from: com.kuaishou.weapon.p0.ao */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7171ao {
    /* renamed from: a */
    public boolean m34353a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(C7170an.f24524b).getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean m34351b() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(C7170an.f24524b)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: c */
    public boolean m34350c() {
        return m34352a(C7170an.f24525c);
    }

    /* renamed from: d */
    public boolean m34349d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(C7170an.f24523a).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        }
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(C7170an.f24524b).newInstance();
            } catch (ClassNotFoundException unused3) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused4) {
            }
        }
        return true;
    }

    /* renamed from: e */
    public String m34348e() {
        try {
            return System.getProperty("vxp");
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: f */
    public boolean m34347f() {
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

    /* renamed from: g */
    public boolean m34346g() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m34352a(String str) {
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
