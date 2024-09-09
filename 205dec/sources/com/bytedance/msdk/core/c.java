package com.bytedance.msdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile Context f27838c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile com.bytedance.msdk.core.fp.xv f27839w;
    private static volatile com.bytedance.msdk.xv.w.c<com.bytedance.msdk.xv.c> xv;

    /* renamed from: com.bytedance.msdk.core.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0415c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: c  reason: collision with root package name */
        private static volatile Application f27840c;

        static {
            try {
                Object w3 = w();
                f27840c = (Application) w3.getClass().getMethod("getApplication", new Class[0]).invoke(w3, new Object[0]);
                com.bytedance.msdk.adapter.sr.xv.sr("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.msdk.adapter.sr.xv.w("MyApplication", "application get failed", th);
            }
        }

        public static Application c() {
            return f27840c;
        }

        private static Object w() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.msdk.adapter.sr.xv.w("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static com.bytedance.msdk.xv.w.c<com.bytedance.msdk.xv.c> c() {
        if (xv == null) {
            synchronized (c.class) {
                if (xv == null) {
                    xv = new com.bytedance.msdk.xv.w.w(f27838c);
                }
            }
        }
        return xv;
    }

    public static Context getContext() {
        if (f27838c == null) {
            c(null);
        }
        return f27838c;
    }

    public static com.bytedance.msdk.core.fp.xv w() {
        if (f27839w == null) {
            synchronized (com.bytedance.msdk.core.fp.xv.class) {
                if (f27839w == null) {
                    f27839w = new com.bytedance.msdk.core.fp.xv();
                }
            }
        }
        return f27839w;
    }

    public static synchronized void c(Context context) {
        synchronized (c.class) {
            if (f27838c == null) {
                synchronized (c.class) {
                    if (C0415c.c() != null) {
                        try {
                            f27838c = C0415c.c();
                            if (f27838c != null) {
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (context != null) {
                        f27838c = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    }
                }
            }
        }
    }
}
