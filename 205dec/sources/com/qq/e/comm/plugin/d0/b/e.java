package com.qq.e.comm.plugin.d0.b;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.k;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42212a = "com.qq.e.comm.plugin.d0.b.e";

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<String, d> f42213b = new ConcurrentHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, com.qq.e.comm.plugin.d0.b.d] */
    private static <T extends d> T a(String str, Class<T> cls, boolean z3) {
        ?? r4;
        String a4 = a(cls, str);
        T t3 = (T) f42213b.get(a4);
        if (t3 == null && z3) {
            try {
                String str2 = f42212a;
                d1.a(str2, "IBridge \u5bf9\u8c61\u521b\u5efa, key = " + a4);
                r4 = (d) Class.forName(cls.getName()).newInstance();
            } catch (Throwable th) {
                th = th;
            }
            try {
                f42213b.putIfAbsent(a4, r4);
                return (T) f42213b.get(a4);
            } catch (Throwable th2) {
                th = th2;
                t3 = r4;
                d1.a(f42212a, "getBridge error", th);
                return t3;
            }
        }
        return t3;
    }

    public static <T extends d> void b(String str, Class<T> cls) {
        f42213b.remove(a(cls, str));
    }

    public static <T extends d> T a(String str, Class<T> cls) {
        return (T) a(str, cls, true);
    }

    public static <T extends d> void a(Class<T> cls) {
        int i4;
        if (a.class.equals(cls)) {
            i4 = 1;
        } else if (b.class.equals(cls)) {
            i4 = 2;
        } else {
            i4 = c.class.equals(cls) ? 3 : 0;
        }
        v.a(1130037, null, Integer.valueOf(i4), Integer.valueOf(k.b() ? 1 : 0), null);
    }

    private static <T extends d> String a(Class<T> cls, String str) {
        String str2;
        if (a.class.equals(cls)) {
            str2 = "ai";
        } else if (b.class.equals(cls)) {
            str2 = "fs";
        } else {
            str2 = c.class.equals(cls) ? "hy" : "";
        }
        return str2 + str;
    }
}
