package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class f28671a;

    /* renamed from: b  reason: collision with root package name */
    private static Object f28672b;

    public static final Object a() {
        if (f28672b == null) {
            try {
                synchronized (a.class) {
                    if (f28672b == null) {
                        if (f28671a == null) {
                            f28671a = Class.forName("android.app.ActivityThread");
                        }
                        f28672b = MethodUtils.invokeStaticMethod(f28671a, "currentActivityThread", new Object[0]);
                    }
                    if (f28672b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        Object unused = a.f28672b = MethodUtils.invokeStaticMethod(a.f28671a, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e4) {
                                        ZeusLogger.errReport("Zeus_pangle", "ActivityThreadHelper main looper invoke currentActivityThread failed.", e4);
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
                        if (f28672b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e4) {
                                    ZeusLogger.errReport("Zeus_pangle", "ActivityThreadHelper currentActivityThread interruptedException failed.", e4);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                ZeusLogger.errReport("Zeus_pangle", "ActivityThreadHelper currentActivityThread failed.", e5);
            }
        }
        return f28672b;
    }
}
