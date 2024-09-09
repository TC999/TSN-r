package com.qq.e.comm.plugin.h;

import com.qq.e.comm.plugin.util.d1;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43991a = "com.qq.e.comm.plugin.h.a";

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, b> f43992b = new HashMap<>();

    private static <T extends b> String a(String str, Class<T> cls) {
        return str + "_" + cls.getCanonicalName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, com.qq.e.comm.plugin.h.b] */
    public static <T extends b> T b(String str, Class<T> cls) {
        ?? r12;
        String a4 = a(str, cls);
        T t3 = (T) f43992b.get(a4);
        if (t3 == null) {
            synchronized (cls) {
                try {
                    r12 = (b) Class.forName(cls.getName() + "Impl").newInstance();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    f43992b.put(a4, r12);
                    t3 = r12;
                } catch (Throwable th2) {
                    th = th2;
                    t3 = r12;
                    d1.a(f43991a, "CallbackCenter getCallback error", th);
                    return t3;
                }
            }
        }
        return t3;
    }

    public static <T extends b> void c(String str, Class<T> cls) {
        f43992b.remove(a(str, cls));
    }
}
