package com.acse.ottn.animator.p032b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.acse.ottn.animator.b.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1374e<T, V> extends AbstractC1373d<T, V> {

    /* renamed from: c */
    private static final String f2409c = "get";

    /* renamed from: d */
    private static final String f2410d = "is";

    /* renamed from: e */
    private static final String f2411e = "set";

    /* renamed from: f */
    private Method f2412f;

    /* renamed from: g */
    private Method f2413g;

    /* renamed from: h */
    private Field f2414h;

    public C1374e(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = f2409c + str2;
        try {
            try {
                this.f2413g = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.f2413g = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = "is" + str2;
            try {
                try {
                    try {
                        this.f2413g = cls.getMethod(str4, null);
                    } catch (NoSuchMethodException unused3) {
                        Field field = cls.getField(str);
                        this.f2414h = field;
                        Class<?> type = field.getType();
                        if (m57004a((Class) cls2, (Class) type)) {
                            return;
                        }
                        throw new C1372c("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                    }
                } catch (NoSuchMethodException unused4) {
                    Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                    this.f2413g = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
            } catch (NoSuchFieldException unused5) {
                throw new C1372c("No accessor method or field found for property with name " + str);
            }
        }
        Class<?> returnType = this.f2413g.getReturnType();
        if (!m57004a((Class) cls2, (Class) returnType)) {
            throw new C1372c("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
        try {
            Method declaredMethod3 = cls.getDeclaredMethod(f2411e + str2, returnType);
            this.f2412f = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (NoSuchMethodException unused6) {
        }
    }

    /* renamed from: a */
    private boolean m57004a(Class<V> cls, Class cls2) {
        if (cls2 != cls) {
            if (cls2.isPrimitive()) {
                if (cls2 == Float.TYPE && cls == Float.class) {
                    return true;
                }
                if (cls2 == Integer.TYPE && cls == Integer.class) {
                    return true;
                }
                if (cls2 == Boolean.TYPE && cls == Boolean.class) {
                    return true;
                }
                if (cls2 == Long.TYPE && cls == Long.class) {
                    return true;
                }
                if (cls2 == Double.TYPE && cls == Double.class) {
                    return true;
                }
                if (cls2 == Short.TYPE && cls == Short.class) {
                    return true;
                }
                if (cls2 == Byte.TYPE && cls == Byte.class) {
                    return true;
                }
                return cls2 == Character.TYPE && cls == Character.class;
            }
            return false;
        }
        return true;
    }

    @Override // com.acse.ottn.animator.p032b.AbstractC1373d
    /* renamed from: a */
    public V mo57003a(T t) {
        Method method = this.f2413g;
        if (method != null) {
            try {
                return (V) method.invoke(t, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        Field field = this.f2414h;
        if (field != null) {
            try {
                return (V) field.get(t);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    @Override // com.acse.ottn.animator.p032b.AbstractC1373d
    /* renamed from: a */
    public void mo57002a(T t, V v) {
        Method method = this.f2412f;
        if (method != null) {
            try {
                method.invoke(t, v);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        Field field = this.f2414h;
        if (field != null) {
            try {
                field.set(t, v);
                return;
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new UnsupportedOperationException("Property " + m57007a() + " is read-only");
    }

    @Override // com.acse.ottn.animator.p032b.AbstractC1373d
    /* renamed from: c */
    public boolean mo57001c() {
        return this.f2412f == null && this.f2414h == null;
    }
}
