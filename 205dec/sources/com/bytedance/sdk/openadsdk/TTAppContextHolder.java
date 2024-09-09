package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.bl;
import com.bytedance.sdk.openadsdk.api.xv;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class TTAppContextHolder {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context ok;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: c  reason: collision with root package name */
        private static volatile Application f31359c;

        static {
            try {
                Object w3 = w();
                f31359c = (Application) w3.getClass().getMethod("getApplication", new Class[0]).invoke(w3, new Object[0]);
                xv.sr("MyApplication", "application get success");
            } catch (Throwable th) {
                xv.xv("MyApplication", "application get failed", th);
            }
        }

        public static Application c() {
            return f31359c;
        }

        private static Object w() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                xv.xv("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class ok {
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application ok;

        static {
            try {
                Object a4 = a();
                ok = (Application) a4.getClass().getMethod("getApplication", new Class[0]).invoke(a4, new Object[0]);
                bl.s("MyApplication", "application get success");
            } catch (Throwable th) {
                bl.bl("MyApplication", "application get failed", th);
            }
        }

        private static Object a() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                bl.bl("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application ok() {
            return ok;
        }
    }

    public static Context getContext() {
        if (ok == null) {
            setContext(null);
        }
        return ok;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (ok == null) {
                if (context != null) {
                    ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
                } else if (ok.ok() != null) {
                    try {
                        ok = ok.ok();
                        if (ok != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
