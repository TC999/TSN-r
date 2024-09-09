package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ck<com.bytedance.sdk.openadsdk.core.a.c> f33864c;
    private static volatile Context sr;

    /* renamed from: w  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.core.z.r f33865w;
    private static final AtomicBoolean xv = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: c  reason: collision with root package name */
        private static volatile Application f33872c;

        static {
            try {
                Object w3 = w();
                f33872c = (Application) w3.getClass().getMethod("getApplication", new Class[0]).invoke(w3, new Object[0]);
                com.bytedance.sdk.component.utils.a.sr("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.w("MyApplication", "application get failed", th);
            }
        }

        public static Application c() {
            return f33872c;
        }

        private static Object w() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.w("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static synchronized void c(Context context) {
        synchronized (ls.class) {
            if (sr == null && context != null) {
                sr = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
        }
    }

    public static Context getContext() {
        if (sr == null) {
            sr = c.c();
        }
        return sr;
    }

    public static boolean sr() {
        AtomicBoolean atomicBoolean = xv;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }

    public static com.bytedance.sdk.openadsdk.core.z.r w() {
        if (f33865w == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.z.r.class) {
                if (f33865w == null) {
                    f33865w = new com.bytedance.sdk.openadsdk.core.z.r();
                }
            }
        }
        return f33865w;
    }

    public static void xv() {
        AtomicBoolean atomicBoolean = xv;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static ck<com.bytedance.sdk.openadsdk.core.a.c> c() {
        if (f33864c == null) {
            synchronized (ls.class) {
                if (f33864c == null) {
                    f33864c = new z(getContext());
                }
            }
        }
        return f33864c;
    }

    public static Bridge c(int i4) {
        return yu.c().c(i4);
    }
}
