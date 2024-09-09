package ulL.WeEFDVoZmmWVmW.yXd;

import android.content.res.Resources;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class XposedHelpers {
    private static final ConcurrentHashMap fieldCache = new ConcurrentHashMap();
    private static final ConcurrentHashMap methodCache = new ConcurrentHashMap();
    private static final ConcurrentHashMap constructorCache = new ConcurrentHashMap();
    private static final WeakHashMap additionalFields = new WeakHashMap();
    private static final HashMap sMethodDepth = new HashMap();

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class ClassNotFoundError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public ClassNotFoundError(Throwable th) {
            super(th);
        }

        public ClassNotFoundError(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class InvocationTargetError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public InvocationTargetError(Throwable th) {
            super(th);
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public abstract class MemberCacheKey {
        private final int hash;

        /* loaded from: E:\TSN-r\205dec\155424.dex */
        public final class Constructor extends MemberCacheKey {
            private final Class clazz;
            private final boolean isExact;
            private final Class[] parameters;

            public Constructor(Class cls, Class[] clsArr, boolean z3) {
                super((Objects.hash(cls, Boolean.valueOf(z3)) * 31) + Arrays.hashCode(clsArr));
                this.clazz = cls;
                this.parameters = clsArr;
                this.isExact = z3;
            }

            @Override // ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers.MemberCacheKey
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Constructor) {
                    Constructor constructor = (Constructor) obj;
                    return this.isExact == constructor.isExact && Objects.equals(this.clazz, constructor.clazz) && Arrays.equals(this.parameters, constructor.parameters);
                }
                return false;
            }

            public String toString() {
                String str = this.clazz.getName() + XposedHelpers.getParametersString(this.parameters);
                if (this.isExact) {
                    return str + "#exact";
                }
                return str;
            }
        }

        /* loaded from: E:\TSN-r\205dec\155424.dex */
        public final class Field extends MemberCacheKey {
            private final Class clazz;
            private final String name;

            public Field(Class cls, String str) {
                super(Objects.hash(cls, str));
                this.clazz = cls;
                this.name = str;
            }

            @Override // ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers.MemberCacheKey
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Field) {
                    Field field = (Field) obj;
                    return Objects.equals(this.clazz, field.clazz) && Objects.equals(this.name, field.name);
                }
                return false;
            }

            public String toString() {
                return this.clazz.getName() + "#" + this.name;
            }
        }

        /* loaded from: E:\TSN-r\205dec\155424.dex */
        public final class Method extends MemberCacheKey {
            private final Class clazz;
            private final boolean isExact;
            private final String name;
            private final Class[] parameters;

            public Method(Class cls, String str, Class[] clsArr, boolean z3) {
                super((Objects.hash(cls, str, Boolean.valueOf(z3)) * 31) + Arrays.hashCode(clsArr));
                this.clazz = cls;
                this.name = str;
                this.parameters = clsArr;
                this.isExact = z3;
            }

            @Override // ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers.MemberCacheKey
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Method) {
                    Method method = (Method) obj;
                    return this.isExact == method.isExact && Objects.equals(this.clazz, method.clazz) && Objects.equals(this.name, method.name) && Arrays.equals(this.parameters, method.parameters);
                }
                return false;
            }

            public String toString() {
                String str = this.clazz.getName() + '#' + this.name + XposedHelpers.getParametersString(this.parameters);
                if (this.isExact) {
                    return str + "#exact";
                }
                return str;
            }
        }

        public MemberCacheKey(int i4) {
            this.hash = i4;
        }

        public abstract boolean equals(Object obj);

        public final int hashCode() {
            return this.hash;
        }
    }

    private XposedHelpers() {
    }

    public static byte[] assetAsByteArray(Resources resources, String str) {
        return inputStreamToByteArray(resources.getAssets().open(str));
    }

    public static Object callMethod(Object obj, String str, Object... objArr) {
        try {
            return findMethodBestMatch(obj.getClass(), str, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (InvocationTargetException e6) {
            throw new InvocationTargetError(e6.getCause());
        }
    }

    public static Object callStaticMethod(Class cls, String str, Object... objArr) {
        try {
            return findMethodBestMatch(cls, str, objArr).invoke(null, objArr);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (InvocationTargetException e6) {
            throw new InvocationTargetError(e6.getCause());
        }
    }

    public static int decrementMethodDepth(String str) {
        return ((AtomicInteger) getMethodDepthCounter(str).get()).decrementAndGet();
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(Class cls, Object... objArr) {
        if (objArr.length != 0 && (objArr[objArr.length - 1] instanceof XC_MethodHook)) {
            return XposedBridge.hookMethod(findConstructorExact(cls, getParameterClasses(cls.getClassLoader(), objArr)), (XC_MethodHook) objArr[objArr.length - 1]);
        }
        throw new IllegalArgumentException("no callback defined");
    }

    public static XC_MethodHook.Unhook findAndHookMethod(Class cls, String str, Object... objArr) {
        if (objArr.length != 0 && (objArr[objArr.length - 1] instanceof XC_MethodHook)) {
            return XposedBridge.hookMethod(findMethodExact(cls, str, getParameterClasses(cls.getClassLoader(), objArr)), (XC_MethodHook) objArr[objArr.length - 1]);
        }
        throw new IllegalArgumentException("no callback defined");
    }

    public static Class findClass(String str, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = XposedBridge.BOOTCLASSLOADER;
        }
        try {
            return AbstractC1480q.a(classLoader, str);
        } catch (ClassNotFoundException e4) {
            throw new ClassNotFoundError(e4);
        }
    }

    public static Class findClassIfExists(String str, ClassLoader classLoader) {
        try {
            return findClass(str, classLoader);
        } catch (ClassNotFoundError unused) {
            return null;
        }
    }

    public static Constructor findConstructorBestMatch(Class cls, Class... clsArr) {
        try {
            return findConstructorExact(cls, clsArr);
        } catch (NoSuchMethodError unused) {
            MemberCacheKey.Constructor constructor = new MemberCacheKey.Constructor(cls, clsArr, false);
            return (Constructor) ((Optional) constructorCache.computeIfAbsent(constructor, new a(0))).orElseThrow(new b(constructor, 0));
        }
    }

    public static Constructor findConstructorExact(Class cls, Object... objArr) {
        return findConstructorExact(cls, getParameterClasses(cls.getClassLoader(), objArr));
    }

    public static Constructor findConstructorExactIfExists(Class cls, Object... objArr) {
        try {
            return findConstructorExact(cls, objArr);
        } catch (NoSuchMethodError | ClassNotFoundError unused) {
            return null;
        }
    }

    public static Field findField(Class cls, String str) {
        MemberCacheKey.Field field = new MemberCacheKey.Field(cls, str);
        return (Field) ((Optional) fieldCache.computeIfAbsent(field, new a(1))).orElseThrow(new b(field, 2));
    }

    public static Field findFieldIfExists(Class cls, String str) {
        try {
            return findField(cls, str);
        } catch (NoSuchFieldError unused) {
            return null;
        }
    }

    private static Field findFieldRecursiveImpl(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e4) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    break;
                }
                try {
                    return cls.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
            }
            throw e4;
        }
    }

    public static Field findFirstFieldByExactType(Class cls, Class cls2) {
        Field[] declaredFields;
        Class cls3 = cls;
        do {
            for (Field field : cls3.getDeclaredFields()) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            cls3 = cls3.getSuperclass();
        } while (cls3 != null);
        throw new NoSuchFieldError("Field of type " + cls2.getName() + " in class " + cls.getName());
    }

    public static Method findMethodBestMatch(Class cls, String str, Class... clsArr) {
        try {
            return findMethodExact(cls, str, clsArr);
        } catch (NoSuchMethodError unused) {
            MemberCacheKey.Method method = new MemberCacheKey.Method(cls, str, clsArr, false);
            return (Method) ((Optional) methodCache.computeIfAbsent(method, new a(3))).orElseThrow(new c(method, 0));
        }
    }

    public static Method findMethodExact(Class cls, String str, Object... objArr) {
        return findMethodExact(cls, str, getParameterClasses(cls.getClassLoader(), objArr));
    }

    public static Method findMethodExactIfExists(Class cls, String str, Object... objArr) {
        try {
            return findMethodExact(cls, str, objArr);
        } catch (NoSuchMethodError | ClassNotFoundError unused) {
            return null;
        }
    }

    public static Method[] findMethodsByExactParameters(Class cls, Class cls2, Class... clsArr) {
        Method[] declaredMethods;
        LinkedList linkedList = new LinkedList();
        for (Method method : cls.getDeclaredMethods()) {
            if (cls2 == null || cls2 == method.getReturnType()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (clsArr.length == parameterTypes.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= clsArr.length) {
                            method.setAccessible(true);
                            linkedList.add(method);
                            break;
                        } else if (clsArr[i4] != parameterTypes[i4]) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
        }
        return (Method[]) linkedList.toArray(new Method[linkedList.size()]);
    }

    public static Object getAdditionalInstanceField(Object obj, String str) {
        Object obj2;
        if (obj != null) {
            if (str != null) {
                WeakHashMap weakHashMap = additionalFields;
                synchronized (weakHashMap) {
                    try {
                        HashMap hashMap = (HashMap) weakHashMap.get(obj);
                        if (hashMap == null) {
                            return null;
                        }
                        synchronized (hashMap) {
                            obj2 = hashMap.get(str);
                        }
                        return obj2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            throw new NullPointerException("key must not be null");
        }
        throw new NullPointerException("object must not be null");
    }

    public static Object getAdditionalStaticField(Object obj, String str) {
        return getAdditionalInstanceField(obj.getClass(), str);
    }

    public static boolean getBooleanField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getBoolean(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static byte getByteField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getByte(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static char getCharField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getChar(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static Class[] getClassesAsArray(Class... clsArr) {
        return clsArr;
    }

    public static double getDoubleField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getDouble(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static int getFirstParameterIndexByType(Member member, Class cls) {
        Class<?>[] parameterTypes = member instanceof Method ? ((Method) member).getParameterTypes() : ((Constructor) member).getParameterTypes();
        for (int i4 = 0; i4 < parameterTypes.length; i4++) {
            if (parameterTypes[i4] == cls) {
                return i4;
            }
        }
        throw new NoSuchFieldError("No parameter of type " + cls + " found in " + member);
    }

    public static float getFloatField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getFloat(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static int getIntField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getInt(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static long getLongField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getLong(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static String getMD5Sum(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static int getMethodDepth(String str) {
        return ((AtomicInteger) getMethodDepthCounter(str).get()).get();
    }

    private static ThreadLocal getMethodDepthCounter(String str) {
        ThreadLocal threadLocal;
        HashMap hashMap = sMethodDepth;
        synchronized (hashMap) {
            try {
                threadLocal = (ThreadLocal) hashMap.get(str);
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal() { // from class: ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers.1
                        @Override // java.lang.ThreadLocal
                        public AtomicInteger initialValue() {
                            return new AtomicInteger();
                        }
                    };
                    hashMap.put(str, threadLocal);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadLocal;
    }

    public static Object getObjectField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).get(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    private static Class[] getParameterClasses(ClassLoader classLoader, Object[] objArr) {
        Class[] clsArr = null;
        for (int length = objArr.length - 1; length >= 0; length--) {
            Object obj = objArr[length];
            if (obj == null) {
                throw new ClassNotFoundError("parameter type must not be null", null);
            }
            if (!(obj instanceof XC_MethodHook)) {
                if (clsArr == null) {
                    clsArr = new Class[length + 1];
                }
                if (obj instanceof Class) {
                    clsArr[length] = (Class) obj;
                } else if (!(obj instanceof String)) {
                    throw new ClassNotFoundError("parameter type must either be specified as Class or String", null);
                } else {
                    clsArr[length] = findClass((String) obj, classLoader);
                }
            }
        }
        return clsArr == null ? new Class[0] : clsArr;
    }

    public static int getParameterIndexByType(Member member, Class cls) {
        Class<?>[] parameterTypes = member instanceof Method ? ((Method) member).getParameterTypes() : ((Constructor) member).getParameterTypes();
        int i4 = -1;
        for (int i5 = 0; i5 < parameterTypes.length; i5++) {
            if (parameterTypes[i5] == cls) {
                if (i4 != -1) {
                    throw new NoSuchFieldError("More than one parameter of type " + cls + " found in " + member);
                }
                i4 = i5;
            }
        }
        if (i4 != -1) {
            return i4;
        }
        throw new NoSuchFieldError("No parameter of type " + cls + " found in " + member);
    }

    public static Class[] getParameterTypes(Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            clsArr[i4] = obj != null ? obj.getClass() : null;
        }
        return clsArr;
    }

    public static String getParametersString(Class... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z3 = true;
        for (Class cls : clsArr) {
            if (z3) {
                z3 = false;
            } else {
                sb.append(",");
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static short getShortField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getShort(obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static boolean getStaticBooleanField(Class cls, String str) {
        try {
            return findField(cls, str).getBoolean(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static byte getStaticByteField(Class cls, String str) {
        try {
            return findField(cls, str).getByte(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static char getStaticCharField(Class cls, String str) {
        try {
            return findField(cls, str).getChar(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static double getStaticDoubleField(Class cls, String str) {
        try {
            return findField(cls, str).getDouble(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static float getStaticFloatField(Class cls, String str) {
        try {
            return findField(cls, str).getFloat(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static int getStaticIntField(Class cls, String str) {
        try {
            return findField(cls, str).getInt(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static long getStaticLongField(Class cls, String str) {
        try {
            return findField(cls, str).getLong(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static Object getStaticObjectField(Class cls, String str) {
        try {
            return findField(cls, str).get(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static short getStaticShortField(Class cls, String str) {
        try {
            return findField(cls, str).getShort(null);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static Object getSurroundingThis(Object obj) {
        return getObjectField(obj, "this$0");
    }

    public static int incrementMethodDepth(String str) {
        return ((AtomicInteger) getMethodDepthCounter(str).get()).incrementAndGet();
    }

    public static byte[] inputStreamToByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static Optional lambda$findConstructorBestMatch$8(MemberCacheKey.Constructor constructor) {
        Constructor<?>[] declaredConstructors;
        Constructor<?> constructor2 = null;
        for (Constructor<?> constructor3 : constructor.clazz.getDeclaredConstructors()) {
            if (AbstractC1480q.c(constructor.parameters, constructor3.getParameterTypes())) {
                if (constructor2 != null) {
                    Class[] clsArr = constructor.parameters;
                    Class[] clsArr2 = p0.f61785a;
                    if (Float.compare(p0.b(clsArr, new C1478o0(constructor3)), p0.b(clsArr, new C1478o0(constructor2))) >= 0) {
                    }
                }
                constructor2 = constructor3;
            }
        }
        if (constructor2 != null) {
            constructor2.setAccessible(true);
            return Optional.of(constructor2);
        }
        return Optional.empty();
    }

    public static /* synthetic */ NoSuchMethodError lambda$findConstructorBestMatch$9(MemberCacheKey.Constructor constructor) {
        return new NoSuchMethodError(constructor.toString());
    }

    public static /* synthetic */ Optional lambda$findConstructorExact$6(MemberCacheKey.Constructor constructor) {
        try {
            Constructor declaredConstructor = constructor.clazz.getDeclaredConstructor(constructor.parameters);
            declaredConstructor.setAccessible(true);
            return Optional.of(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return Optional.empty();
        }
    }

    public static /* synthetic */ NoSuchMethodError lambda$findConstructorExact$7(MemberCacheKey.Constructor constructor) {
        return new NoSuchMethodError(constructor.toString());
    }

    public static /* synthetic */ Optional lambda$findField$0(MemberCacheKey.Field field) {
        try {
            Field findFieldRecursiveImpl = findFieldRecursiveImpl(field.clazz, field.name);
            findFieldRecursiveImpl.setAccessible(true);
            return Optional.of(findFieldRecursiveImpl);
        } catch (NoSuchFieldException unused) {
            return Optional.empty();
        }
    }

    public static /* synthetic */ NoSuchFieldError lambda$findField$1(MemberCacheKey.Field field) {
        return new NoSuchFieldError(field.toString());
    }

    public static Optional lambda$findMethodBestMatch$4(MemberCacheKey.Method method) {
        Method[] declaredMethods;
        Class cls = method.clazz;
        Method method2 = null;
        boolean z3 = true;
        while (true) {
            for (Method method3 : cls.getDeclaredMethods()) {
                if ((z3 || !Modifier.isPrivate(method3.getModifiers())) && method3.getName().equals(method.name) && AbstractC1480q.c(method.parameters, method3.getParameterTypes())) {
                    if (method2 != null) {
                        Class[] clsArr = method.parameters;
                        Class[] clsArr2 = p0.f61785a;
                        if (Float.compare(p0.b(clsArr, new C1478o0(method3)), p0.b(clsArr, new C1478o0(method2))) >= 0) {
                        }
                    }
                    method2 = method3;
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                break;
            }
            z3 = false;
        }
        if (method2 != null) {
            method2.setAccessible(true);
            return Optional.of(method2);
        }
        return Optional.empty();
    }

    public static /* synthetic */ NoSuchMethodError lambda$findMethodBestMatch$5(MemberCacheKey.Method method) {
        return new NoSuchMethodError(method.toString());
    }

    public static /* synthetic */ Optional lambda$findMethodExact$2(MemberCacheKey.Method method) {
        try {
            Method declaredMethod = method.clazz.getDeclaredMethod(method.name, method.parameters);
            declaredMethod.setAccessible(true);
            return Optional.of(declaredMethod);
        } catch (NoSuchMethodException unused) {
            return Optional.empty();
        }
    }

    public static /* synthetic */ NoSuchMethodError lambda$findMethodExact$3(MemberCacheKey.Method method) {
        return new NoSuchMethodError(method.toString());
    }

    public static Object newInstance(Class cls, Object... objArr) {
        try {
            return findConstructorBestMatch(cls, objArr).newInstance(objArr);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (InstantiationException e6) {
            throw new InstantiationError(e6.getMessage());
        } catch (InvocationTargetException e7) {
            throw new InvocationTargetError(e7.getCause());
        }
    }

    public static Object removeAdditionalInstanceField(Object obj, String str) {
        Object remove;
        if (obj != null) {
            if (str != null) {
                WeakHashMap weakHashMap = additionalFields;
                synchronized (weakHashMap) {
                    try {
                        HashMap hashMap = (HashMap) weakHashMap.get(obj);
                        if (hashMap == null) {
                            return null;
                        }
                        synchronized (hashMap) {
                            remove = hashMap.remove(str);
                        }
                        return remove;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            throw new NullPointerException("key must not be null");
        }
        throw new NullPointerException("object must not be null");
    }

    public static Object removeAdditionalStaticField(Object obj, String str) {
        return removeAdditionalInstanceField(obj.getClass(), str);
    }

    public static Object setAdditionalInstanceField(Object obj, String str, Object obj2) {
        HashMap hashMap;
        Object put;
        if (obj != null) {
            if (str != null) {
                WeakHashMap weakHashMap = additionalFields;
                synchronized (weakHashMap) {
                    try {
                        hashMap = (HashMap) weakHashMap.get(obj);
                        if (hashMap == null) {
                            hashMap = new HashMap();
                            weakHashMap.put(obj, hashMap);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                synchronized (hashMap) {
                    put = hashMap.put(str, obj2);
                }
                return put;
            }
            throw new NullPointerException("key must not be null");
        }
        throw new NullPointerException("object must not be null");
    }

    public static Object setAdditionalStaticField(Object obj, String str, Object obj2) {
        return setAdditionalInstanceField(obj.getClass(), str, obj2);
    }

    public static void setBooleanField(Object obj, String str, boolean z3) {
        try {
            findField(obj.getClass(), str).setBoolean(obj, z3);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setByteField(Object obj, String str, byte b4) {
        try {
            findField(obj.getClass(), str).setByte(obj, b4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setCharField(Object obj, String str, char c4) {
        try {
            findField(obj.getClass(), str).setChar(obj, c4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setDoubleField(Object obj, String str, double d4) {
        try {
            findField(obj.getClass(), str).setDouble(obj, d4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setFloatField(Object obj, String str, float f4) {
        try {
            findField(obj.getClass(), str).setFloat(obj, f4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setIntField(Object obj, String str, int i4) {
        try {
            findField(obj.getClass(), str).setInt(obj, i4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setLongField(Object obj, String str, long j4) {
        try {
            findField(obj.getClass(), str).setLong(obj, j4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setObjectField(Object obj, String str, Object obj2) {
        try {
            findField(obj.getClass(), str).set(obj, obj2);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setShortField(Object obj, String str, short s3) {
        try {
            findField(obj.getClass(), str).setShort(obj, s3);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticBooleanField(Class cls, String str, boolean z3) {
        try {
            findField(cls, str).setBoolean(null, z3);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticByteField(Class cls, String str, byte b4) {
        try {
            findField(cls, str).setByte(null, b4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticCharField(Class cls, String str, char c4) {
        try {
            findField(cls, str).setChar(null, c4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticDoubleField(Class cls, String str, double d4) {
        try {
            findField(cls, str).setDouble(null, d4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticFloatField(Class cls, String str, float f4) {
        try {
            findField(cls, str).setFloat(null, f4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticIntField(Class cls, String str, int i4) {
        try {
            findField(cls, str).setInt(null, i4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticLongField(Class cls, String str, long j4) {
        try {
            findField(cls, str).setLong(null, j4);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticObjectField(Class cls, String str, Object obj) {
        try {
            findField(cls, str).set(null, obj);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static void setStaticShortField(Class cls, String str, short s3) {
        try {
            findField(cls, str).setShort(null, s3);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        }
    }

    public static Constructor findConstructorExact(String str, ClassLoader classLoader, Object... objArr) {
        return findConstructorExact(findClass(str, classLoader), getParameterClasses(classLoader, objArr));
    }

    public static Constructor findConstructorExactIfExists(String str, ClassLoader classLoader, Object... objArr) {
        try {
            return findConstructorExact(str, classLoader, objArr);
        } catch (NoSuchMethodError | ClassNotFoundError unused) {
            return null;
        }
    }

    public static Method findMethodExact(String str, ClassLoader classLoader, String str2, Object... objArr) {
        return findMethodExact(findClass(str, classLoader), str2, getParameterClasses(classLoader, objArr));
    }

    public static Method findMethodExactIfExists(String str, ClassLoader classLoader, String str2, Object... objArr) {
        try {
            return findMethodExact(str, classLoader, str2, objArr);
        } catch (NoSuchMethodError | ClassNotFoundError unused) {
            return null;
        }
    }

    public static Object getAdditionalStaticField(Class cls, String str) {
        return getAdditionalInstanceField(cls, str);
    }

    public static Object removeAdditionalStaticField(Class cls, String str) {
        return removeAdditionalInstanceField(cls, str);
    }

    public static Object setAdditionalStaticField(Class cls, String str, Object obj) {
        return setAdditionalInstanceField(cls, str, obj);
    }

    public static Constructor findConstructorExact(Class cls, Class... clsArr) {
        MemberCacheKey.Constructor constructor = new MemberCacheKey.Constructor(cls, clsArr, true);
        return (Constructor) ((Optional) constructorCache.computeIfAbsent(constructor, new a(2))).orElseThrow(new b(constructor, 1));
    }

    public static Method findMethodExact(Class cls, String str, Class... clsArr) {
        MemberCacheKey.Method method = new MemberCacheKey.Method(cls, str, clsArr, true);
        return (Method) ((Optional) methodCache.computeIfAbsent(method, new a(4))).orElseThrow(new c(method, 1));
    }

    public static Constructor findConstructorBestMatch(Class cls, Object... objArr) {
        return findConstructorBestMatch(cls, getParameterTypes(objArr));
    }

    public static Method findMethodBestMatch(Class cls, String str, Object... objArr) {
        return findMethodBestMatch(cls, str, getParameterTypes(objArr));
    }

    public static Object callMethod(Object obj, String str, Class[] clsArr, Object... objArr) {
        try {
            return findMethodBestMatch(obj.getClass(), str, clsArr, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (InvocationTargetException e6) {
            throw new InvocationTargetError(e6.getCause());
        }
    }

    public static Object callStaticMethod(Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            return findMethodBestMatch(cls, str, clsArr, objArr).invoke(null, objArr);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (InvocationTargetException e6) {
            throw new InvocationTargetError(e6.getCause());
        }
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(String str, ClassLoader classLoader, Object... objArr) {
        return findAndHookConstructor(findClass(str, classLoader), objArr);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(String str, ClassLoader classLoader, String str2, Object... objArr) {
        return findAndHookMethod(findClass(str, classLoader), str2, objArr);
    }

    public static Constructor findConstructorBestMatch(Class cls, Class[] clsArr, Object[] objArr) {
        Class[] clsArr2 = null;
        for (int i4 = 0; i4 < clsArr.length; i4++) {
            if (clsArr[i4] == null) {
                if (clsArr2 == null) {
                    clsArr2 = getParameterTypes(objArr);
                }
                clsArr[i4] = clsArr2[i4];
            }
        }
        return findConstructorBestMatch(cls, clsArr);
    }

    public static Method findMethodBestMatch(Class cls, String str, Class[] clsArr, Object[] objArr) {
        Class[] clsArr2 = null;
        for (int i4 = 0; i4 < clsArr.length; i4++) {
            if (clsArr[i4] == null) {
                if (clsArr2 == null) {
                    clsArr2 = getParameterTypes(objArr);
                }
                clsArr[i4] = clsArr2[i4];
            }
        }
        return findMethodBestMatch(cls, str, clsArr);
    }

    public static Object newInstance(Class cls, Class[] clsArr, Object... objArr) {
        try {
            return findConstructorBestMatch(cls, clsArr, objArr).newInstance(objArr);
        } catch (IllegalAccessException e4) {
            XposedBridge.log(e4);
            throw new IllegalAccessError(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw e5;
        } catch (InstantiationException e6) {
            throw new InstantiationError(e6.getMessage());
        } catch (InvocationTargetException e7) {
            throw new InvocationTargetError(e7.getCause());
        }
    }
}
