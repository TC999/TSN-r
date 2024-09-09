package com.amap.api.col.p0003l;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MethodCallHelper.java */
/* renamed from: com.amap.api.col.3l.i3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i3 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8083a = false;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<a> f8084b = new ArrayList<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: MethodCallHelper.java */
    /* renamed from: com.amap.api.col.3l.i3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8085a;

        /* renamed from: b  reason: collision with root package name */
        private Object f8086b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?>[] f8087c;

        /* renamed from: d  reason: collision with root package name */
        private Object[] f8088d;

        public a(Object obj, String str, Object... objArr) {
            this.f8086b = obj;
            this.f8085a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.f8087c = new Class[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                this.f8087c[i4] = objArr[i4].getClass();
            }
            this.f8088d = new Object[objArr.length];
            for (int i5 = 0; i5 < objArr.length; i5++) {
                this.f8088d[i5] = objArr[i5];
            }
        }
    }

    public final synchronized void a() {
        if (this.f8083a) {
            return;
        }
        this.f8083a = true;
        for (int i4 = 0; i4 < this.f8084b.size(); i4++) {
            a aVar = this.f8084b.get(i4);
            try {
                try {
                    try {
                        if (aVar.f8086b != null) {
                            Class<?> cls = aVar.f8086b.getClass();
                            Method method = null;
                            try {
                                method = cls.getDeclaredMethod(aVar.f8085a, aVar.f8087c);
                            } catch (NoSuchMethodException unused) {
                                if (aVar.f8087c.length > 0) {
                                    Class<?>[] clsArr = new Class[aVar.f8087c.length];
                                    for (int i5 = 0; i5 < aVar.f8087c.length; i5++) {
                                        if (aVar.f8087c[i5].getInterfaces().length > 0) {
                                            clsArr[i5] = aVar.f8087c[i5].getInterfaces()[0];
                                        }
                                    }
                                    method = cls.getDeclaredMethod(aVar.f8085a, clsArr);
                                }
                            }
                            if (method != null) {
                                method.setAccessible(true);
                                method.invoke(aVar.f8086b, aVar.f8088d);
                            }
                        }
                    } catch (IllegalArgumentException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                } catch (IllegalAccessException e6) {
                    e6.printStackTrace();
                } catch (SecurityException e7) {
                    e7.printStackTrace();
                }
            } catch (NoSuchMethodException e8) {
                e8.printStackTrace();
            }
        }
        this.f8084b.clear();
    }

    public final synchronized void b(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f8084b.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f8083a = false;
    }
}
