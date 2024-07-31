package com.amap.api.col.p0463l;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.3l.i3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class MethodCallHelper {

    /* renamed from: a */
    private boolean f4497a = false;

    /* renamed from: b */
    ArrayList<C1838a> f4498b = new ArrayList<>();

    /* compiled from: MethodCallHelper.java */
    /* renamed from: com.amap.api.col.3l.i3$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1838a {

        /* renamed from: a */
        private String f4499a;

        /* renamed from: b */
        private Object f4500b;

        /* renamed from: c */
        private Class<?>[] f4501c;

        /* renamed from: d */
        private Object[] f4502d;

        public C1838a(Object obj, String str, Object... objArr) {
            this.f4500b = obj;
            this.f4499a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.f4501c = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                this.f4501c[i] = objArr[i].getClass();
            }
            this.f4502d = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                this.f4502d[i2] = objArr[i2];
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m54730a() {
        if (this.f4497a) {
            return;
        }
        this.f4497a = true;
        for (int i = 0; i < this.f4498b.size(); i++) {
            C1838a c1838a = this.f4498b.get(i);
            try {
                try {
                    try {
                        if (c1838a.f4500b != null) {
                            Class<?> cls = c1838a.f4500b.getClass();
                            Method method = null;
                            try {
                                method = cls.getDeclaredMethod(c1838a.f4499a, c1838a.f4501c);
                            } catch (NoSuchMethodException unused) {
                                if (c1838a.f4501c.length > 0) {
                                    Class<?>[] clsArr = new Class[c1838a.f4501c.length];
                                    for (int i2 = 0; i2 < c1838a.f4501c.length; i2++) {
                                        if (c1838a.f4501c[i2].getInterfaces().length > 0) {
                                            clsArr[i2] = c1838a.f4501c[i2].getInterfaces()[0];
                                        }
                                    }
                                    method = cls.getDeclaredMethod(c1838a.f4499a, clsArr);
                                }
                            }
                            if (method != null) {
                                method.setAccessible(true);
                                method.invoke(c1838a.f4500b, c1838a.f4502d);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (SecurityException e4) {
                    e4.printStackTrace();
                }
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            }
        }
        this.f4498b.clear();
    }

    /* renamed from: b */
    public final synchronized void m54729b(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f4498b.add(new C1838a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f4497a = false;
    }
}
