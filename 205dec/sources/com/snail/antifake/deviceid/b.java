package com.snail.antifake.deviceid;

import android.os.RemoteException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BinderUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {
    public static String a(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) obj.getClass().getDeclaredMethod("getInterfaceDescriptor", new Class[0]).invoke(obj, new Object[0]);
    }

    public static int b(Object obj, String str) throws RemoteException, NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getEnclosingClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return ((Integer) declaredField.get(obj)).intValue();
    }
}
