package com.acse.ottn;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f3<T, V> extends b3<T, V> {

    /* renamed from: f  reason: collision with root package name */
    public static final String f5657f = "get";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5658g = "is";

    /* renamed from: h  reason: collision with root package name */
    public static final String f5659h = "set";

    /* renamed from: c  reason: collision with root package name */
    public Method f5660c;

    /* renamed from: d  reason: collision with root package name */
    public Method f5661d;

    /* renamed from: e  reason: collision with root package name */
    public Field f5662e;

    public f3(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = f5657f + str2;
        try {
            try {
                this.f5661d = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.f5661d = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = "is" + str2;
            try {
                try {
                    try {
                        this.f5661d = cls.getMethod(str4, null);
                    } catch (NoSuchMethodException unused3) {
                        Field field = cls.getField(str);
                        this.f5662e = field;
                        Class<?> type = field.getType();
                        if (a((Class) cls2, (Class) type)) {
                            return;
                        }
                        throw new m2("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                    }
                } catch (NoSuchMethodException unused4) {
                    Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                    this.f5661d = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
            } catch (NoSuchFieldException unused5) {
                throw new m2("No accessor method or field found for property with name " + str);
            }
        }
        Class<?> returnType = this.f5661d.getReturnType();
        if (a((Class) cls2, (Class) returnType)) {
            try {
                Method declaredMethod3 = cls.getDeclaredMethod(f5659h + str2, returnType);
                this.f5660c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                return;
            } catch (NoSuchMethodException unused6) {
                return;
            }
        }
        throw new m2("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
    }

    public final boolean a(Class<V> cls, Class cls2) {
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

    @Override // com.acse.ottn.b3
    public boolean c() {
        return this.f5660c == null && this.f5662e == null;
    }

    @Override // com.acse.ottn.b3
    public void a(T t3, V v3) {
        Method method = this.f5660c;
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
        Field field = this.f5662e;
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

    @Override // com.acse.ottn.b3
    public V a(T t3) {
        Method method = this.f5661d;
        if (method != null) {
            try {
                return (V) method.invoke(t3, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        Field field = this.f5662e;
        if (field != null) {
            try {
                return (V) field.get(t3);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }
}
