package com.snail.antifake.deviceid;

import android.os.RemoteException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.snail.antifake.deviceid.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BinderUtil {
    /* renamed from: a */
    public static String m19686a(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) obj.getClass().getDeclaredMethod("getInterfaceDescriptor", new Class[0]).invoke(obj, new Object[0]);
    }

    /* renamed from: b */
    public static int m19685b(Object obj, String str) throws RemoteException, NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getEnclosingClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return ((Integer) declaredField.get(obj)).intValue();
    }
}
