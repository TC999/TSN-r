package defpackage;

/* renamed from: p0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class[] f61785a = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    public static float a(Class cls, Class cls2) {
        float f4 = 0.0f;
        if (!cls2.isPrimitive()) {
            while (true) {
                if (cls == null || cls2.equals(cls)) {
                    break;
                }
                if (cls2.isInterface() && AbstractC1480q.b(cls, cls2)) {
                    f4 += 0.25f;
                    break;
                }
                f4 += 1.0f;
                cls = cls.getSuperclass();
            }
            return cls == null ? f4 + 1.5f : f4;
        } else if (cls == null) {
            return 1.5f;
        } else {
            if (!cls.isPrimitive()) {
                cls = (Class) AbstractC1480q.f61937c.get(cls);
                f4 = 0.1f;
            }
            for (int i4 = 0; cls != cls2 && i4 < 7; i4++) {
                Class[] clsArr = f61785a;
                if (cls == clsArr[i4]) {
                    f4 += 0.1f;
                    if (i4 < 6) {
                        cls = clsArr[i4 + 1];
                    }
                }
            }
            return f4;
        }
    }

    public static float b(Class[] clsArr, C1478o0 c1478o0) {
        float a4;
        Class[] clsArr2 = c1478o0.f61572a;
        boolean z3 = c1478o0.f61573b;
        int length = clsArr2.length;
        if (z3) {
            length--;
        }
        long j4 = length;
        if (clsArr.length < j4) {
            return Float.MAX_VALUE;
        }
        boolean z4 = false;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < j4; i4++) {
            f4 += a(clsArr[i4], clsArr2[i4]);
        }
        if (z3) {
            boolean z5 = clsArr.length < clsArr2.length;
            if (clsArr.length == clsArr2.length && clsArr[clsArr.length - 1] != null && clsArr[clsArr.length - 1].isArray()) {
                z4 = true;
            }
            Class<?> componentType = clsArr2[clsArr2.length - 1].getComponentType();
            if (z5) {
                a4 = a(componentType, Object.class);
            } else if (!z4) {
                for (int length2 = clsArr2.length - 1; length2 < clsArr.length; length2++) {
                    f4 += a(clsArr[length2], componentType) + 0.001f;
                }
                return f4;
            } else {
                a4 = a(clsArr[clsArr.length - 1].getComponentType(), componentType);
            }
            return f4 + a4 + 0.001f;
        }
        return f4;
    }
}
