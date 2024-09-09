package com.bytedance.msdk.adapter.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class Reflection {
    public static boolean classFound(@NonNull String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Nullable
    public static Method getDeclaredMethodWithTraversal(@Nullable Class<?> cls, @NonNull String str, @NonNull Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static Field getPrivateField(@NonNull Class cls, @NonNull String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    @NonNull
    public static <T> T instantiateClassWithConstructor(@NonNull String str, @NonNull Class<? extends T> cls, @NonNull Class[] clsArr, @NonNull Object[] objArr) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(objArr);
    }

    @NonNull
    public static <T> T instantiateClassWithEmptyConstructor(@NonNull String str, @NonNull Class<? extends T> cls) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class MethodBuilder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Object f27227a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final String f27228b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f27229c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private List<Class<?>> f27230d = new ArrayList();
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private List<Object> f27231e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private boolean f27232f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f27233g;

        public MethodBuilder(@Nullable Object obj, @NonNull String str) {
            this.f27227a = obj;
            this.f27228b = str;
            this.f27229c = obj != null ? obj.getClass() : null;
        }

        @NonNull
        public <T> MethodBuilder addParam(@NonNull Class<T> cls, @Nullable T t3) {
            this.f27230d.add(cls);
            this.f27231e.add(t3);
            return this;
        }

        @Nullable
        public Object execute() throws Exception {
            List<Class<?>> list = this.f27230d;
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.f27229c, this.f27228b, (Class[]) list.toArray(new Class[this.f27230d.size()]));
            if (this.f27232f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            Object[] array = this.f27231e.toArray();
            if (this.f27233g) {
                return declaredMethodWithTraversal.invoke(null, array);
            }
            return declaredMethodWithTraversal.invoke(this.f27227a, array);
        }

        @NonNull
        public MethodBuilder setAccessible() {
            this.f27232f = true;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull Class<?> cls) {
            this.f27233g = true;
            this.f27229c = cls;
            return this;
        }

        @NonNull
        public MethodBuilder addParam(@NonNull String str, @Nullable Object obj) throws ClassNotFoundException {
            this.f27230d.add(Class.forName(str));
            this.f27231e.add(obj);
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull String str) throws ClassNotFoundException {
            this.f27233g = true;
            this.f27229c = Class.forName(str);
            return this;
        }
    }
}
