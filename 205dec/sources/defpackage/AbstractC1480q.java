package defpackage;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/* renamed from: q  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class AbstractC1480q {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f61935a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f61936b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap f61937c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map f61938d;

    static {
        String.valueOf('.');
        String.valueOf('$');
        HashMap hashMap = new HashMap();
        f61935a = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put("boolean", cls);
        Class cls2 = Byte.TYPE;
        hashMap.put("byte", cls2);
        Class cls3 = Character.TYPE;
        hashMap.put("char", cls3);
        Class cls4 = Short.TYPE;
        hashMap.put("short", cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put("int", cls5);
        Class cls6 = Long.TYPE;
        hashMap.put("long", cls6);
        Class cls7 = Double.TYPE;
        hashMap.put("double", cls7);
        Class cls8 = Float.TYPE;
        hashMap.put("float", cls8);
        Class cls9 = Void.TYPE;
        hashMap.put("void", cls9);
        HashMap hashMap2 = new HashMap();
        f61936b = hashMap2;
        hashMap2.put(cls, Boolean.class);
        hashMap2.put(cls2, Byte.class);
        hashMap2.put(cls3, Character.class);
        hashMap2.put(cls4, Short.class);
        hashMap2.put(cls5, Integer.class);
        hashMap2.put(cls6, Long.class);
        hashMap2.put(cls7, Double.class);
        hashMap2.put(cls8, Float.class);
        hashMap2.put(cls9, cls9);
        f61937c = new HashMap();
        hashMap2.forEach(new Object());
        HashMap hashMap3 = new HashMap();
        hashMap3.put("int", "I");
        hashMap3.put("boolean", "Z");
        hashMap3.put("float", "F");
        hashMap3.put("long", "J");
        hashMap3.put("short", "S");
        hashMap3.put("byte", "B");
        hashMap3.put("double", "D");
        hashMap3.put("char", "C");
        f61938d = Collections.unmodifiableMap(hashMap3);
        Collections.unmodifiableMap((Map) hashMap3.entrySet().stream().collect(Collectors.toMap(new L0(1), new L0(2))));
    }

    public static Class a(ClassLoader classLoader, String str) {
        try {
            Class cls = (Class) f61935a.get(str);
            return cls != null ? cls : Class.forName(d(str), false, classLoader);
        } catch (ClassNotFoundException e4) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    return a(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1));
                } catch (ClassNotFoundException unused) {
                    throw e4;
                }
            }
            throw e4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Class cls, Class cls2) {
        if (cls2 == 0) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            if (cls.isPrimitive()) {
                cls = (Class) f61936b.get(cls);
            }
            if (cls == null) {
                return false;
            }
        }
        if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = (Class) f61937c.get(cls)) == null) {
            return false;
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (cls2.isPrimitive()) {
                Class cls3 = Integer.TYPE;
                if (cls3.equals(cls)) {
                    return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                }
                Class cls4 = Long.TYPE;
                if (cls4.equals(cls)) {
                    return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                } else if (Boolean.TYPE.equals(cls)) {
                    return false;
                } else {
                    Class cls5 = Double.TYPE;
                    if (cls5.equals(cls)) {
                        return false;
                    }
                    Class cls6 = Float.TYPE;
                    if (cls6.equals(cls)) {
                        return cls5.equals(cls2);
                    }
                    if (!Character.TYPE.equals(cls)) {
                        Class cls7 = Short.TYPE;
                        if (!cls7.equals(cls)) {
                            if (Byte.TYPE.equals(cls)) {
                                return cls7.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
                            }
                            return false;
                        }
                    }
                    return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
                }
            }
            return false;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static boolean c(Class[] clsArr, Class[] clsArr2) {
        if ((clsArr != null ? Array.getLength(clsArr) : 0) == (clsArr2 != null ? Array.getLength(clsArr2) : 0)) {
            Class[] clsArr3 = AbstractC1457e.f54630a;
            if (clsArr == null) {
                clsArr = clsArr3;
            }
            if (clsArr2 == null) {
                clsArr2 = clsArr3;
            }
            for (int i4 = 0; i4 < clsArr.length; i4++) {
                if (!b(clsArr[i4], clsArr2[i4])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String d(String str) {
        int i4 = J0.f33a;
        if (str != null && str.length() != 0) {
            int length = str.length();
            char[] cArr = new char[length];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (!Character.isWhitespace(str.charAt(i6))) {
                    cArr[i5] = str.charAt(i6);
                    i5++;
                }
            }
            if (i5 != length) {
                str = i5 == 0 ? "" : new String(cArr, 0, i5);
            }
        }
        Objects.requireNonNull(str, "className");
        if (str.endsWith("[]")) {
            StringBuilder sb = new StringBuilder();
            while (str.endsWith("[]")) {
                str = str.substring(0, str.length() - 2);
                sb.append("[");
            }
            String str2 = (String) f61938d.get(str);
            if (str2 != null) {
                sb.append(str2);
            } else {
                sb.append("L");
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        }
        return str;
    }
}
