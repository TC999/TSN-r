package com.bytedance.pangle.p119d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* renamed from: com.bytedance.pangle.d.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6078a {

    /* renamed from: a */
    private static Class f21912a;

    /* renamed from: b */
    private static Object f21913b;

    /* renamed from: a */
    public static final Object m37251a() {
        if (f21913b == null) {
            try {
                synchronized (C6078a.class) {
                    if (f21913b == null) {
                        if (f21912a == null) {
                            f21912a = Class.forName("android.app.ActivityThread");
                        }
                        f21913b = MethodUtils.invokeStaticMethod(f21912a, "currentActivityThread", new Object[0]);
                    }
                    if (f21913b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        Object unused = C6078a.f21913b = MethodUtils.invokeStaticMethod(C6078a.f21912a, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (f21913b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return f21913b;
    }
}
