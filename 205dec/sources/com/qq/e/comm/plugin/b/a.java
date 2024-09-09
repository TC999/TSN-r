package com.qq.e.comm.plugin.b;

import com.qq.e.comm.adevent.ADEvent;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    public static <T> T a(ADEvent aDEvent, Class<T> cls) {
        return (T) a(aDEvent, 0, cls);
    }

    public static <T> T a(ADEvent aDEvent, int i4, Class<T> cls) {
        try {
            return (T) aDEvent.getParam(i4, cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
