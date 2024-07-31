package com.kwad.sdk.api.loader;

import androidx.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class Reflect {
    private final Class<?> amS;
    private final Object amT;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.Reflect$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9710b {
        private C9710b() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    /* renamed from: a */
    public static Reflect m27998a(Class<?> cls) {
        return new Reflect(cls);
    }

    /* renamed from: c */
    private static Class<?>[] m27984c(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? C9710b.class : obj.getClass();
        }
        return clsArr;
    }

    /* renamed from: cg */
    public static Reflect m27983cg(String str) {
        return m27998a(forName(str));
    }

    /* renamed from: ch */
    private Reflect m27982ch(String str) {
        try {
            Field m27981ci = m27981ci(str);
            return m27997a(m27981ci.getType(), m27981ci.get(this.amT));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    /* renamed from: ci */
    private Field m27981ci(String str) {
        Class<?> type = type();
        try {
            return (Field) m27994a(C9709a.m27974b(type, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) m27994a(C9709a.m27976a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type != null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type != null);
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String str) {
        try {
            return C9709a.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    /* renamed from: g */
    private Reflect m27979g(String str, Object... objArr) {
        return m27995a(str, m27984c(objArr), objArr);
    }

    /* renamed from: h */
    public static Reflect m27978h(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    /* renamed from: i */
    private static Object m27977i(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    private Class<?> type() {
        return this.amS;
    }

    /* renamed from: Ak */
    public final Reflect m27999Ak() {
        return m27985b(new Object[0]);
    }

    /* renamed from: b */
    public final Reflect m27987b(String str, Object obj) {
        try {
            Field m27981ci = m27981ci(str);
            if ((m27981ci.getModifiers() & 16) == 16) {
                try {
                    Field m27976a = C9709a.m27976a(Field.class, "modifiers");
                    m27976a.setAccessible(true);
                    m27976a.setInt(m27981ci, m27981ci.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            m27981ci.set(this.amT, m27977i(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    /* renamed from: cj */
    public final Reflect m27980cj(String str) {
        return m27979g(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.amT.equals(((Reflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.amT;
    }

    public final int hashCode() {
        return this.amT.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.amT);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.amS = cls;
        this.amT = obj;
    }

    /* renamed from: a */
    private static Reflect m27997a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public final <T> T get(String str) {
        return (T) m27982ch(str).get();
    }

    @Nullable
    /* renamed from: a */
    private static <T extends AccessibleObject> T m27994a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.Reflect$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9709a {
        private static final Method amU;
        private static final Method amV;
        private static final Method amW;
        private static final Method amX;
        private static final Method amY;
        private static final Method amZ;
        private static final Method ana;
        private static final Method anb;
        private static final Method anc;
        private static final Method and;
        private static final Method ane;
        private static final Method anf;
        private static final Method ang;
        private static final Method anh;

        static {
            try {
                amU = Class.class.getDeclaredMethod("forName", String.class);
                amV = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                amW = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                amX = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                amY = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                amZ = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                ana = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                anb = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                anc = Class.class.getDeclaredMethod("getField", String.class);
                and = Class.class.getDeclaredMethod("getFields", new Class[0]);
                ane = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                anf = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                ang = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                anh = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        /* renamed from: a */
        static Field m27976a(Class cls, String str) {
            try {
                return (Field) amW.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        /* renamed from: b */
        static Field m27974b(Class cls, String str) {
            try {
                return (Field) anc.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        /* renamed from: c */
        static Method m27972c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) amY.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        /* renamed from: d */
        static Method m27970d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) ane.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        /* renamed from: e */
        static Constructor[] m27969e(Class cls) {
            try {
                return (Constructor[]) anb.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Class forName(String str) {
            try {
                return (Class) amU.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        /* renamed from: a */
        static Constructor m27975a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) ana.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        /* renamed from: c */
        static Method[] m27973c(Class cls) {
            try {
                return (Method[]) amZ.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        /* renamed from: d */
        static Method[] m27971d(Class cls) {
            try {
                return (Method[]) anf.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
    }

    /* renamed from: b */
    private Method m27986b(String str, Class<?>[] clsArr) {
        Method[] m27971d;
        Method[] m27973c;
        Class<?> type = type();
        for (Method method : C9709a.m27971d(type)) {
            if (m27991a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : C9709a.m27973c(type)) {
                if (m27991a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    /* renamed from: a */
    public final Reflect m27995a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return m27992a(m27996a(str, clsArr), this.amT, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return m27992a(m27986b(str, clsArr), this.amT, objArr);
        }
    }

    /* renamed from: a */
    private Method m27996a(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return C9709a.m27970d(type, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return C9709a.m27972c(type, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type == null);
            throw new NoSuchMethodException();
        }
    }

    /* renamed from: b */
    private Reflect m27985b(Object... objArr) {
        return m27989a(m27984c(objArr), objArr);
    }

    /* renamed from: a */
    private boolean m27991a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && m27990a(method.getParameterTypes(), clsArr);
    }

    /* renamed from: b */
    private static Class<?> m27988b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            return Void.TYPE == cls ? Void.class : cls;
        }
        return cls;
    }

    /* renamed from: a */
    public final Reflect m27989a(Class<?>[] clsArr, Object... objArr) {
        Constructor[] m27969e;
        try {
            return m27993a(C9709a.m27975a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : C9709a.m27969e(type())) {
                if (m27990a(constructor.getParameterTypes(), clsArr)) {
                    return m27993a(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    /* renamed from: a */
    private static boolean m27990a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != C9710b.class && !m27988b(clsArr[i]).isAssignableFrom(m27988b(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static Reflect m27993a(Constructor<?> constructor, Object... objArr) {
        try {
            return m27997a(constructor.getDeclaringClass(), ((Constructor) m27994a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    /* renamed from: a */
    private static Reflect m27992a(Method method, Object obj, Object... objArr) {
        try {
            m27994a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return m27978h(obj);
            }
            return m27978h(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }
}
