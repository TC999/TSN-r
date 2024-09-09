package com.acse.ottn.animator.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class e<T, V> extends d<T, V> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4951c = "get";

    /* renamed from: d  reason: collision with root package name */
    private static final String f4952d = "is";

    /* renamed from: e  reason: collision with root package name */
    private static final String f4953e = "set";

    /* renamed from: f  reason: collision with root package name */
    private Method f4954f;

    /* renamed from: g  reason: collision with root package name */
    private Method f4955g;

    /* renamed from: h  reason: collision with root package name */
    private Field f4956h;

    public e(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = "get" + str2;
        try {
            try {
                this.f4955g = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.f4955g = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = "is" + str2;
            try {
                try {
                    try {
                        this.f4955g = cls.getMethod(str4, null);
                    } catch (NoSuchMethodException unused3) {
                        Field field = cls.getField(str);
                        this.f4956h = field;
                        Class<?> type = field.getType();
                        if (a((Class) cls2, (Class) type)) {
                            return;
                        }
                        throw new c("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                    }
                } catch (NoSuchMethodException unused4) {
                    Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                    this.f4955g = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
            } catch (NoSuchFieldException unused5) {
                throw new c("No accessor method or field found for property with name " + str);
            }
        }
        Class<?> returnType = this.f4955g.getReturnType();
        if (!a((Class) cls2, (Class) returnType)) {
            throw new c("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
        try {
            Method declaredMethod3 = cls.getDeclaredMethod("set" + str2, returnType);
            this.f4954f = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (NoSuchMethodException unused6) {
        }
    }

    private boolean a(Class<V> cls, Class cls2) {
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

    @Override // com.acse.ottn.animator.b.d
    public V a(T t3) {
        Method method = this.f4955g;
        if (method != null) {
            try {
                return (V) method.invoke(t3, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        Field field = this.f4956h;
        if (field != null) {
            try {
                return (V) field.get(t3);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    @Override // com.acse.ottn.animator.b.d
    public void a(T t3, V v3) {
        Method method = this.f4954f;
        if (method != null) {
            try {
                method.invoke(t3, v3);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        Field field = this.f4956h;
        if (field != null) {
            try {
                field.set(t3, v3);
                return;
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    @Override // com.acse.ottn.animator.b.d
    public boolean c() {
        return this.f4954f == null && this.f4956h == null;
    }
}
