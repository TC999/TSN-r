package com.bytedance.msdk.adapter.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class MethodBuilder {
        @Nullable

        /* renamed from: a */
        private final Object f21509a;
        @NonNull

        /* renamed from: b */
        private final String f21510b;
        @Nullable

        /* renamed from: c */
        private Class<?> f21511c;
        @NonNull

        /* renamed from: d */
        private List<Class<?>> f21512d = new ArrayList();
        @NonNull

        /* renamed from: e */
        private List<Object> f21513e = new ArrayList();

        /* renamed from: f */
        private boolean f21514f;

        /* renamed from: g */
        private boolean f21515g;

        public MethodBuilder(@Nullable Object obj, @NonNull String str) {
            this.f21509a = obj;
            this.f21510b = str;
            this.f21511c = obj != null ? obj.getClass() : null;
        }

        @NonNull
        public <T> MethodBuilder addParam(@NonNull Class<T> cls, @Nullable T t) {
            this.f21512d.add(cls);
            this.f21513e.add(t);
            return this;
        }

        @Nullable
        public Object execute() throws Exception {
            List<Class<?>> list = this.f21512d;
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.f21511c, this.f21510b, (Class[]) list.toArray(new Class[this.f21512d.size()]));
            if (this.f21514f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            Object[] array = this.f21513e.toArray();
            if (this.f21515g) {
                return declaredMethodWithTraversal.invoke(null, array);
            }
            return declaredMethodWithTraversal.invoke(this.f21509a, array);
        }

        @NonNull
        public MethodBuilder setAccessible() {
            this.f21514f = true;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull Class<?> cls) {
            this.f21515g = true;
            this.f21511c = cls;
            return this;
        }

        @NonNull
        public MethodBuilder addParam(@NonNull String str, @Nullable Object obj) throws ClassNotFoundException {
            this.f21512d.add(Class.forName(str));
            this.f21513e.add(obj);
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull String str) throws ClassNotFoundException {
            this.f21515g = true;
            this.f21511c = Class.forName(str);
            return this;
        }
    }
}
