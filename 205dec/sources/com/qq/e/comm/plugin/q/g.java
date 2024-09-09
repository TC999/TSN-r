package com.qq.e.comm.plugin.q;

import android.text.TextUtils;
import com.qq.e.comm.plugin.dysi.IGDTRF;
import com.qq.e.comm.plugin.util.d1;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Class<?>> f45420a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Method> f45421b = new HashMap();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements IGDTRF {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f45422a;

        a(Map map) {
            this.f45422a = map;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int ci(String str, String str2, String str3, int[] iArr) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && iArr != null && iArr.length == 0) {
                try {
                    Object newInstance = g.b(str).newInstance();
                    int identityHashCode = System.identityHashCode(newInstance);
                    this.f45422a.put(Integer.valueOf(identityHashCode), newInstance);
                    return identityHashCode;
                } catch (Throwable th) {
                    d1.a("RF", "getConstructor exception: " + th);
                    return -1;
                }
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    Class b4 = g.b(str);
                    String[] split = str2.split(",");
                    String[] split2 = str3.split(",");
                    if (split.length > 0 && split.length == split2.length) {
                        Class<?>[] clsArr = new Class[split.length];
                        Object[] objArr = new Object[split2.length];
                        for (int i4 = 0; i4 < split.length; i4++) {
                            clsArr[i4] = g.b(split[i4]);
                            if (!g.b(i4, iArr)) {
                                Object b5 = g.b(clsArr[i4], split2[i4]);
                                if (b5 == null) {
                                    return -1;
                                }
                                objArr[i4] = b5;
                            } else {
                                Object obj = this.f45422a.get(Integer.valueOf(Integer.parseInt(split2[i4])));
                                if (obj == null || !obj.getClass().equals(clsArr[i4])) {
                                    return -1;
                                }
                                objArr[i4] = obj;
                            }
                        }
                        Object newInstance2 = b4.getConstructor(clsArr).newInstance(objArr);
                        int identityHashCode2 = System.identityHashCode(newInstance2);
                        this.f45422a.put(Integer.valueOf(identityHashCode2), newInstance2);
                        return identityHashCode2;
                    }
                } catch (Throwable th2) {
                    d1.a("RF", "getConstructor exception: " + th2);
                }
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public void d(int[] iArr) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            try {
                for (int i4 : iArr) {
                    this.f45422a.remove(Integer.valueOf(i4));
                }
            } catch (Throwable th) {
                d1.a("RF", "remove used object exception: " + th);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int fc(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return System.identityHashCode(g.b(str));
            } catch (Throwable th) {
                d1.a("RF", "findClass exception: " + th);
                return -1;
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int fm(String str, String str2, String str3) {
            Method method;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String str4 = str + "." + str2 + "(" + str3 + ")";
                    Method method2 = (Method) g.f45421b.get(str4);
                    if (method2 == null) {
                        Class b4 = g.b(str);
                        if (TextUtils.isEmpty(str3)) {
                            method = b4.getMethod(str2, new Class[0]);
                        } else {
                            String[] split = str3.split(",");
                            if (split.length > 0) {
                                Class<?>[] clsArr = new Class[split.length];
                                for (int i4 = 0; i4 < split.length; i4++) {
                                    clsArr[i4] = g.b(split[i4]);
                                }
                                method = b4.getMethod(str2, clsArr);
                            }
                        }
                        method2 = method;
                    }
                    if (method2 != null) {
                        int identityHashCode = System.identityHashCode(method2);
                        method2.setAccessible(true);
                        g.f45421b.put(str4, method2);
                        this.f45422a.put(Integer.valueOf(identityHashCode), method2);
                        return identityHashCode;
                    }
                } catch (Throwable th) {
                    d1.a("RF", "getConstructor exception: " + th);
                }
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int gf(int i4, String str) {
            Class<?> cls;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                Object obj = this.f45422a.get(Integer.valueOf(i4));
                if (obj != null) {
                    if (obj.getClass().equals(Class.class)) {
                        cls = (Class) obj;
                    } else {
                        cls = obj.getClass();
                    }
                    Field field = cls.getField(str);
                    field.setAccessible(true);
                    Object obj2 = field.get(cls);
                    int identityHashCode = System.identityHashCode(obj2);
                    this.f45422a.put(Integer.valueOf(identityHashCode), obj2);
                    return identityHashCode;
                }
            } catch (Throwable th) {
                d1.a("RF", "getField exception: " + th);
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int iv(int i4, int i5, String str, int[] iArr) {
            Method method;
            try {
                method = (Method) this.f45422a.get(Integer.valueOf(i4));
            } catch (Throwable th) {
                d1.a("RF", "invoke method exception: " + th);
            }
            if (method == null) {
                return -1;
            }
            Object obj = this.f45422a.get(Integer.valueOf(i5));
            Object obj2 = null;
            if (TextUtils.isEmpty(str)) {
                obj2 = method.invoke(obj, new Object[0]);
                if (obj2 == null) {
                    return 1;
                }
            } else {
                String[] split = str.split(",");
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (split.length == parameterTypes.length) {
                    Object[] objArr = new Object[parameterTypes.length];
                    for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                        if (!g.b(i6, iArr)) {
                            Object b4 = g.b(parameterTypes[i6], split[i6]);
                            if (b4 == null) {
                                return -1;
                            }
                            objArr[i6] = b4;
                        } else {
                            Object obj3 = this.f45422a.get(Integer.valueOf(Integer.parseInt(split[i6])));
                            if (obj3 == null || !obj3.getClass().equals(parameterTypes[i6])) {
                                return -1;
                            }
                            objArr[i6] = obj3;
                        }
                    }
                    obj2 = method.invoke(obj, objArr);
                    if (obj2 == null) {
                        return 1;
                    }
                }
            }
            if (obj2 != null) {
                int identityHashCode = System.identityHashCode(obj2);
                this.f45422a.put(Integer.valueOf(identityHashCode), obj2);
                return identityHashCode;
            }
            return -1;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTRF
        public int sf(int i4, String str, String str2, int i5) {
            Class<?> cls;
            Object b4;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                Object obj = this.f45422a.get(Integer.valueOf(i4));
                if (obj != null) {
                    if (obj.getClass().equals(Class.class)) {
                        cls = (Class) obj;
                    } else {
                        cls = obj.getClass();
                    }
                    Field field = cls.getField(str);
                    field.setAccessible(true);
                    if (str2 == null) {
                        field.set(obj, null);
                        return 1;
                    }
                    if (i5 <= 0) {
                        b4 = g.b(field.getType(), str2);
                    } else {
                        b4 = this.f45422a.get(Integer.valueOf(Integer.parseInt(str2)));
                    }
                    if (b4 != null) {
                        field.set(obj, b4);
                        return 1;
                    }
                    return -1;
                }
            } catch (Throwable th) {
                d1.a("RF", "setField exception: " + th);
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<?> b(String str) throws Throwable {
        Class<?> cls = f45420a.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str);
            f45420a.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    static void a(com.qq.e.comm.dynamic.b bVar, Map<Integer, Object> map) {
        if (bVar != null && bVar.b() && map != null) {
            bVar.a("GDTRF", IGDTRF.class, new a(map));
        } else {
            d1.a("RF", "addRFInterface failed, because params invalid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i4, int[] iArr) {
        if (iArr != null) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                if (i5 == i4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(Class<?> cls, String str) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (String.class.equals(cls)) {
            return str;
        }
        if (!Boolean.TYPE.equals(cls) && !Boolean.class.equals(cls)) {
            if (!Byte.TYPE.equals(cls) && !Byte.class.equals(cls)) {
                if (!Short.TYPE.equals(cls) && !Short.class.equals(cls)) {
                    if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls)) {
                        if (!Long.TYPE.equals(cls) && !Long.class.equals(cls)) {
                            if (!Double.TYPE.equals(cls) && !Double.class.equals(cls)) {
                                if (Float.TYPE.equals(cls) || Float.class.equals(cls)) {
                                    return Float.valueOf(Float.parseFloat(str));
                                }
                                return null;
                            }
                            return Double.valueOf(Double.parseDouble(str));
                        }
                        return Long.valueOf(Long.parseLong(str));
                    }
                    return Integer.valueOf(Integer.parseInt(str));
                }
                return Short.valueOf(Short.parseShort(str));
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }
}
