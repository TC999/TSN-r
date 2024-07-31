package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.C6280bl;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TTAppContextHolder {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ok */
    private static volatile Context f22348ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.TTAppContextHolder$ok */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C6275ok {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: ok */
        private static volatile Application f22349ok;

        static {
            try {
                Object m36793a = m36793a();
                f22349ok = (Application) m36793a.getClass().getMethod("getApplication", new Class[0]).invoke(m36793a, new Object[0]);
                C6280bl.m36761s("MyApplication", "application get success");
            } catch (Throwable th) {
                C6280bl.m36770bl("MyApplication", "application get failed", th);
            }
        }

        /* renamed from: a */
        private static Object m36793a() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                C6280bl.m36770bl("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        /* renamed from: ok */
        public static Application m36792ok() {
            return f22349ok;
        }
    }

    public static Context getContext() {
        if (f22348ok == null) {
            setContext(null);
        }
        return f22348ok;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (f22348ok == null) {
                if (context != null) {
                    f22348ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
                } else if (C6275ok.m36792ok() != null) {
                    try {
                        f22348ok = C6275ok.m36792ok();
                        if (f22348ok != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
