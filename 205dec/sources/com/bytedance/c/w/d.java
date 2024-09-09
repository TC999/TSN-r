package com.bytedance.c.w;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Context f26516a = null;

    /* renamed from: b  reason: collision with root package name */
    private static long f26517b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static String f26518c = "default";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f26519d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static com.bytedance.c.w.ux.a f26520e;

    /* renamed from: h  reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f26523h;

    /* renamed from: j  reason: collision with root package name */
    private static volatile int f26525j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile String f26526k;

    /* renamed from: f  reason: collision with root package name */
    private static com.bytedance.c.w.ux.g f26521f = new com.bytedance.c.w.ux.g();

    /* renamed from: g  reason: collision with root package name */
    private static h f26522g = new h();

    /* renamed from: i  reason: collision with root package name */
    private static com.bytedance.c.w.ux.b f26524i = null;

    public static com.bytedance.c.w.ux.a a() {
        return f26520e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, g gVar) {
        f26517b = System.currentTimeMillis();
        f26516a = context;
        f26520e = new com.bytedance.c.w.ux.a(context, gVar);
    }

    public static boolean c() {
        return f26519d;
    }

    public static long d() {
        return f26517b;
    }

    public static ConcurrentHashMap<Integer, String> e() {
        return f26523h;
    }

    public static String f() {
        return f26526k;
    }

    public static int g() {
        return f26525j;
    }

    public static String h() {
        return f26518c;
    }

    public static Context i() {
        return f26516a;
    }

    public static com.bytedance.c.w.ux.g j() {
        return f26521f;
    }

    public static h k() {
        return f26522g;
    }

    public static com.bytedance.c.w.ux.b l() {
        if (f26524i == null) {
            synchronized (d.class) {
                f26524i = new com.bytedance.c.w.ux.b(f26516a);
            }
        }
        return f26524i;
    }
}
