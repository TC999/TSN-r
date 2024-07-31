package com.kuaishou.weapon.p205p0;

import android.os.Build;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.lang.reflect.Method;

/* renamed from: com.kuaishou.weapon.p0.ct */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7238ct {

    /* renamed from: a */
    private static int f24728a;

    /* renamed from: b */
    private static boolean f24729b;

    public C7238ct() {
        m34034b();
    }

    /* renamed from: a */
    private int m34035a(Method method) {
        try {
            int i = f24728a;
            if (i <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private void m34034b() {
        if (!Engine.loadSuccess || f24729b) {
            return;
        }
        boolean m34041b = C7236cr.m34041b();
        int i = Build.VERSION.SDK_INT;
        if (m34041b && i < 29 && i > 22) {
            f24728a = Engine.off();
        }
        f24729b = true;
    }

    /* renamed from: c */
    private boolean m34033c() {
        return f24729b && f24728a > 1;
    }

    /* renamed from: a */
    public int m34036a(Class cls, String str, Object... objArr) {
        try {
            if (m34033c()) {
                return m34035a(C7264dh.m33968a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public int m34037a(int i, Class cls, String str, Object... objArr) {
        Method m33968a;
        try {
            if (!m34033c() || (m33968a = C7264dh.m33968a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(m33968a, i);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public int m34038a() {
        if (m34033c()) {
            long m34047a = C7234cq.f24717b.m34047a();
            long m34047a2 = C7234cq.f24716a.m34047a();
            if (f24728a == m34047a) {
                return (int) m34047a2;
            }
            return -1;
        }
        return -1;
    }
}
