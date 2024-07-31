package com.mbridge.msdk.mbjscommon.p495b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.mbridge.msdk.mbjscommon.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class Hack {

    /* renamed from: a */
    private static InterfaceC11478a f31421a;

    /* compiled from: Hack.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11478a {
        /* renamed from: a */
        boolean m21536a(AbstractC11479b.C11480a c11480a);
    }

    /* compiled from: Hack.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.b.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractC11479b {

        /* compiled from: Hack.java */
        /* renamed from: com.mbridge.msdk.mbjscommon.b.a$b$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11480a extends Throwable {

            /* renamed from: a */
            private Class<?> f31422a;

            /* renamed from: b */
            private String f31423b;

            public C11480a(String str) {
                super(str);
            }

            /* renamed from: a */
            public final void m21535a(Class<?> cls) {
                this.f31422a = cls;
            }

            @Override // java.lang.Throwable
            public final String toString() {
                if (getCause() != null) {
                    return C11480a.class.getName() + ": " + getCause();
                }
                return super.toString();
            }

            public C11480a(Exception exc) {
                super(exc);
            }

            /* renamed from: a */
            public final void m21534a(String str) {
                this.f31423b = str;
            }
        }
    }

    /* compiled from: Hack.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.b.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11481c<C> {

        /* renamed from: a */
        protected Class<C> f31424a;

        public C11481c(Class<C> cls) {
            this.f31424a = cls;
        }

        /* renamed from: a */
        public final C11482d m21533a(String str, Class<?>... clsArr) throws AbstractC11479b.C11480a {
            return new C11482d(this.f31424a, str, clsArr, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m21537b(AbstractC11479b.C11480a c11480a) throws AbstractC11479b.C11480a {
        InterfaceC11478a interfaceC11478a = f31421a;
        if (interfaceC11478a == null || !interfaceC11478a.m21536a(c11480a)) {
            throw c11480a;
        }
    }

    /* compiled from: Hack.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.b.a$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11482d {

        /* renamed from: a */
        protected final Method f31425a;

        C11482d(Class<?> cls, String str, Class<?>[] clsArr, int i) throws AbstractC11479b.C11480a {
            Method method = null;
            if (cls == null) {
                return;
            }
            while (cls != Object.class) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    cls = cls.getSuperclass();
                } catch (SecurityException e2) {
                    try {
                        try {
                            e2.printStackTrace();
                            cls = cls.getSuperclass();
                        } catch (Exception e3) {
                            AbstractC11479b.C11480a c11480a = new AbstractC11479b.C11480a(e3);
                            c11480a.m21535a(cls);
                            c11480a.m21534a(str);
                            Hack.m21537b(c11480a);
                        }
                    } finally {
                        this.f31425a = method;
                    }
                }
            }
            if (i > 0 && (method.getModifiers() & i) != i) {
                Hack.m21537b(new AbstractC11479b.C11480a(method + " does not match modifiers: " + i));
            }
            method.setAccessible(true);
        }

        /* renamed from: a */
        public final Object m21531a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            try {
                return this.f31425a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: a */
        public final Method m21532a() {
            return this.f31425a;
        }
    }

    /* renamed from: a */
    public static <T> C11481c<T> m21538a(ClassLoader classLoader, String str) throws AbstractC11479b.C11480a {
        try {
            return new C11481c<>(classLoader.loadClass(str));
        } catch (Exception e) {
            m21537b(new AbstractC11479b.C11480a(e));
            return new C11481c<>(null);
        }
    }
}
