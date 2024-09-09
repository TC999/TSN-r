package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ct {

    /* renamed from: a  reason: collision with root package name */
    private static int f38224a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f38225b;

    public ct() {
        b();
    }

    private int a(Method method) {
        try {
            int i4 = f38224a;
            if (i4 <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i4, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || f38225b) {
            return;
        }
        boolean b4 = cr.b();
        int i4 = Build.VERSION.SDK_INT;
        if (b4 && i4 < 29 && i4 > 22) {
            f38224a = Engine.off();
        }
        f38225b = true;
    }

    private boolean c() {
        return f38225b && f38224a > 1;
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dh.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i4, Class cls, String str, Object... objArr) {
        Method a4;
        try {
            if (!c() || (a4 = dh.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a4, i4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (c()) {
            long a4 = cq.f38213b.a();
            long a5 = cq.f38212a.a();
            if (f38224a == a4) {
                return (int) a5;
            }
            return -1;
        }
        return -1;
    }
}
