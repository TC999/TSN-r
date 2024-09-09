package com.beizi.fusion.g;

import android.app.Application;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiEnContext.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Application f14914a;

    static {
        Application application;
        Throwable th;
        try {
            try {
                application = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
                if (application == null) {
                    try {
                        throw new IllegalStateException("Static initialization of Applications must be on main thread.");
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        try {
                            application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                            e.printStackTrace();
                        }
                        f14914a = application;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                application = null;
            } catch (Throwable th2) {
                application = null;
                th = th2;
                f14914a = application;
                throw th;
            }
            f14914a = application;
        } catch (Throwable th3) {
            th = th3;
            f14914a = application;
            throw th;
        }
    }

    public static Application a() {
        return f14914a;
    }
}
