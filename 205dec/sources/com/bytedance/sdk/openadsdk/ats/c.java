package com.bytedance.sdk.openadsdk.ats;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.ls.ux;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    static final Map<String, Pair<Class, Boolean>> f31501c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    static final Map<Class, Pair<Class, Method>> f31502w = new HashMap();
    private static volatile c xv;
    private xv ev;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Object, Object> f31503f;

    /* renamed from: r  reason: collision with root package name */
    private final Map<Class, SparseArray<Method>> f31504r;
    private final Map<String, Object> sr;
    private final Map<Object, Object> ux;

    private c() {
        w(com.bytedance.sdk.openadsdk.core.fz.xv.class);
        w(ux.class);
        w(com.bytedance.sdk.component.ux.xv.w.class);
        xv(com.bytedance.sdk.openadsdk.r.c.class);
        this.sr = new HashMap();
        this.ux = new WeakHashMap();
        this.f31503f = new WeakHashMap();
        this.f31504r = new HashMap();
    }

    private Object sr(Object obj, Class<?> cls) {
        if (obj == null || cls == Void.class) {
            return null;
        }
        return w.w(cls) == null ? obj : c(obj, cls);
    }

    private static void w(Class cls) {
        String[] value;
        ATS ats = (ATS) cls.getAnnotation(ATS.class);
        if (ats == null || (value = ats.value()) == null) {
            return;
        }
        Log.d("AutoService", "registerService:" + cls + ", " + ats.single());
        for (String str : value) {
            f31501c.put(str, new Pair<>(cls, Boolean.valueOf(ats.single())));
        }
    }

    private static void xv(Class cls) {
        Method[] methods = cls.getMethods();
        Log.d("AutoService", "registerConfig:" + cls);
        for (Method method : methods) {
            if (((ATSMethod) method.getAnnotation(ATSMethod.class)) != null) {
                f31502w.put(method.getReturnType(), new Pair<>(cls, method));
            }
        }
    }

    public static c c() {
        if (xv == null) {
            synchronized (c.class) {
                if (xv == null) {
                    xv = new c();
                }
            }
        }
        return xv;
    }

    private <T> T sr(Class<T> cls) throws InvocationTargetException, IllegalAccessException {
        Object[] objArr;
        Pair<Class, Method> pair = f31502w.get(cls);
        Object obj = null;
        if (pair != null) {
            Method method = (Method) pair.second;
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length <= 0) {
                objArr = null;
            } else {
                objArr = new Object[parameterTypes.length];
                for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                    objArr[i4] = sr(parameterTypes[i4]);
                }
            }
            if (!Modifier.isStatic(method.getModifiers())) {
                try {
                    obj = ((Class) pair.first).newInstance();
                } catch (Throwable th) {
                    xv xvVar = this.ev;
                    if (xvVar != null) {
                        xvVar.w(cls.getName(), th);
                    }
                    return null;
                }
            }
            return (T) method.invoke(obj, objArr);
        }
        return null;
    }

    private InvocationHandler w(final Object obj, final Class cls) {
        return new InvocationHandler() { // from class: com.bytedance.sdk.openadsdk.ats.c.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) {
                try {
                    return c.this.c(obj, obj2, method, objArr, cls);
                } catch (Throwable th) {
                    if (c.this.ev != null) {
                        c.this.ev.c(obj.getClass().getName(), method.getName(), "invoke failed", th);
                        return null;
                    }
                    return null;
                }
            }
        };
    }

    private Object xv(Object obj, Class<?> cls) {
        if (obj == null || cls == Void.class) {
            return null;
        }
        return w.w(cls) == null ? obj : c(obj, cls);
    }

    public <T> T c(Class<T> cls) {
        if (cls == null) {
            xv xvVar = this.ev;
            if (xvVar != null) {
                xvVar.c("", new RuntimeException("null api"));
            }
            return null;
        }
        String c4 = w.c(cls);
        if (c4 != null && c4 != "null") {
            Pair<Class, Boolean> pair = f31501c.get(c4);
            if (pair == null) {
                xv xvVar2 = this.ev;
                if (xvVar2 != null) {
                    xvVar2.c(cls.getName(), new RuntimeException("clazz not register"));
                }
                return null;
            }
            T t3 = (T) c(c4, pair, cls);
            if (t3 == null) {
                return null;
            }
            return t3.getClass().getClassLoader() == cls.getClassLoader() ? t3 : (T) c(t3, cls);
        }
        xv xvVar3 = this.ev;
        if (xvVar3 != null) {
            xvVar3.c(cls.getName(), new RuntimeException("not decorate by ATSApi"));
        }
        return null;
    }

    private Object c(Object obj, Class cls) {
        Object obj2 = this.f31503f.get(obj);
        if (obj2 == null) {
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, w(obj, cls));
            this.f31503f.put(obj, newProxyInstance);
            return newProxyInstance;
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(Object obj, Object obj2, Method method, Object[] objArr, Class cls) throws Throwable {
        xv xvVar;
        Annotation c4 = w.c(cls, method);
        if (c4 == null) {
            Object c5 = c(obj, obj2, method, objArr);
            if (c5 == null && (xvVar = this.ev) != null) {
                String name = obj.getClass().getName();
                String name2 = method.getName();
                xvVar.c(name, name2, "method " + method.getName() + " not decorate by AutoServiceMethod!", null);
            }
            return c5;
        }
        Method c6 = c(obj, ((Integer) w.c(c4)).intValue());
        if (c6 == null) {
            xv xvVar2 = this.ev;
            if (xvVar2 != null) {
                String name3 = obj.getClass().getName();
                String name4 = method.getName();
                xvVar2.c(name3, name4, "method " + method.getName() + " un support in service", null);
            }
            return null;
        }
        Class<?>[] parameterTypes = c6.getParameterTypes();
        if (parameterTypes != null) {
            for (int i4 = 0; i4 < objArr.length; i4++) {
                objArr[i4] = xv(objArr[i4], parameterTypes[i4]);
            }
        }
        Object invoke = c6.invoke(obj, objArr);
        if (invoke == obj) {
            Object obj3 = this.ux.get(invoke);
            if (obj3 == null) {
                Object sr = sr(invoke, method.getReturnType());
                this.ux.put(invoke, sr);
                return sr;
            }
            return obj3;
        }
        return sr(invoke, method.getReturnType());
    }

    private Object c(Object obj, Object obj2, Method method, Object[] objArr) {
        String name = method.getName();
        if (objArr == null || objArr.length == 0) {
            if (name.equals("toString")) {
                return obj.toString();
            }
            if (name.equals("hashCode")) {
                return Integer.valueOf(obj.hashCode());
            }
            return null;
        }
        return null;
    }

    private Method c(Object obj, int i4) {
        Method method;
        Class<?> cls = obj.getClass();
        SparseArray<Method> sparseArray = this.f31504r.get(cls);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f31504r.put(cls, sparseArray);
            method = null;
        } else {
            method = sparseArray.get(i4);
        }
        return method == null ? c(cls, sparseArray, i4) : method;
    }

    private Method c(Class<?> cls, SparseArray<Method> sparseArray, int i4) {
        Method method;
        Integer num;
        Method[] methods = cls.getMethods();
        Method method2 = null;
        if (methods == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            method = c(methods, sparseArray, i4);
        } else {
            Class xv2 = w.xv(cls);
            if (xv2 == null) {
                return null;
            }
            for (Method method3 : methods) {
                Annotation annotation = method3.getAnnotation(xv2);
                if (annotation != null && (num = (Integer) w.c(annotation)) != null) {
                    if (num.intValue() == i4) {
                        method2 = method3;
                    }
                    sparseArray.put(num.intValue(), method3);
                }
            }
            method = method2;
        }
        Log.d("AutoService", "init " + cls.getName() + " methods cost " + (System.currentTimeMillis() - currentTimeMillis));
        return method;
    }

    private Method c(Method[] methodArr, SparseArray<Method> sparseArray, int i4) {
        Method method = null;
        for (Method method2 : methodArr) {
            ATSMethod aTSMethod = (ATSMethod) method2.getAnnotation(ATSMethod.class);
            if (aTSMethod != null) {
                if (aTSMethod.value() == i4) {
                    method = method2;
                }
                sparseArray.put(aTSMethod.value(), method2);
            }
        }
        return method;
    }

    private Object c(String str, Pair<Class, Boolean> pair, Class cls) {
        try {
            if (((Boolean) pair.second).booleanValue()) {
                Object obj = this.sr.get(str);
                if (obj != null) {
                    return obj;
                }
                synchronized (this.sr) {
                    try {
                        Object obj2 = this.sr.get(str);
                        if (obj2 == null) {
                            Object c4 = c((Class<Object>) pair.first, (Class<Object>) cls);
                            try {
                                this.sr.put(str, c4);
                                obj2 = c4;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        return obj2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } else {
                return c((Class<Object>) pair.first, (Class<Object>) cls);
            }
        } catch (Throwable th3) {
            xv xvVar = this.ev;
            if (xvVar != null) {
                xvVar.c(str, th3);
                return null;
            }
            return null;
        }
    }

    private <T> T c(Class<T> cls, Class<T> cls2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?>[] declaredConstructors;
        T t3 = (T) sr(cls2);
        if (t3 != null) {
            return t3;
        }
        T t4 = (T) sr(cls);
        if (t4 != null) {
            return t4;
        }
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            if (constructor.getAnnotation(ATSMethod.class) != null) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] objArr = new Object[parameterTypes.length];
                for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                    objArr[i4] = sr(parameterTypes[i4]);
                }
                return (T) constructor.newInstance(objArr);
            }
        }
        return cls.newInstance();
    }
}
