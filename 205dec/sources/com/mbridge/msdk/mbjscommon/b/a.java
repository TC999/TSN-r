package com.mbridge.msdk.mbjscommon.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Hack.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static InterfaceC0748a f40193a;

    /* compiled from: Hack.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0748a {
        boolean a(b.C0749a c0749a);
    }

    /* compiled from: Hack.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class b {

        /* compiled from: Hack.java */
        /* renamed from: com.mbridge.msdk.mbjscommon.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0749a extends Throwable {

            /* renamed from: a  reason: collision with root package name */
            private Class<?> f40194a;

            /* renamed from: b  reason: collision with root package name */
            private String f40195b;

            public C0749a(String str) {
                super(str);
            }

            public final void a(Class<?> cls) {
                this.f40194a = cls;
            }

            @Override // java.lang.Throwable
            public final String toString() {
                if (getCause() != null) {
                    return C0749a.class.getName() + ": " + getCause();
                }
                return super.toString();
            }

            public C0749a(Exception exc) {
                super(exc);
            }

            public final void a(String str) {
                this.f40195b = str;
            }
        }
    }

    /* compiled from: Hack.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c<C> {

        /* renamed from: a  reason: collision with root package name */
        protected Class<C> f40196a;

        public c(Class<C> cls) {
            this.f40196a = cls;
        }

        public final d a(String str, Class<?>... clsArr) throws b.C0749a {
            return new d(this.f40196a, str, clsArr, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.C0749a c0749a) throws b.C0749a {
        InterfaceC0748a interfaceC0748a = f40193a;
        if (interfaceC0748a == null || !interfaceC0748a.a(c0749a)) {
            throw c0749a;
        }
    }

    /* compiled from: Hack.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        protected final Method f40197a;

        d(Class<?> cls, String str, Class<?>[] clsArr, int i4) throws b.C0749a {
            Method method = null;
            if (cls == null) {
                return;
            }
            while (cls != Object.class) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                    cls = cls.getSuperclass();
                } catch (SecurityException e5) {
                    try {
                        try {
                            e5.printStackTrace();
                            cls = cls.getSuperclass();
                        } catch (Exception e6) {
                            b.C0749a c0749a = new b.C0749a(e6);
                            c0749a.a(cls);
                            c0749a.a(str);
                            a.b(c0749a);
                        }
                    } finally {
                        this.f40197a = method;
                    }
                }
            }
            if (i4 > 0 && (method.getModifiers() & i4) != i4) {
                a.b(new b.C0749a(method + " does not match modifiers: " + i4));
            }
            method.setAccessible(true);
        }

        public final Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            try {
                return this.f40197a.invoke(obj, objArr);
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        public final Method a() {
            return this.f40197a;
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0749a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e4) {
            b(new b.C0749a(e4));
            return new c<>(null);
        }
    }
}
