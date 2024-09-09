package com.bytedance.dutexplorer;

import com.bytedance.component.sdk.annotation.Keep;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class tmapcloak {
    static int DexNum;

    static {
        try {
            if (DexNum > 0) {
                System.loadLibrary("maparmor");
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static native byte bob_bytedance_call(int i4, int i5, Object... objArr);

    public static native char cob_bytedance_call(int i4, int i5, Object... objArr);

    public static native double dob_bytedance_call(int i4, int i5, Object... objArr);

    public static native float fob_bytedance_call(int i4, int i5, Object... objArr);

    public static native int iob_bytedance_call(int i4, int i5, Object... objArr);

    public static native long job_bytedance_call(int i4, int i5, Object... objArr);

    public static native Object obj_bytedance_call(int i4, int i5, Object... objArr);

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static native short sob_bytedance_call(int i4, int i5, Object... objArr);

    public static native void voi_bytedance_call(int i4, int i5, Object... objArr);

    public static native boolean zob_bytedance_call(int i4, int i5, Object... objArr);

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }
}
