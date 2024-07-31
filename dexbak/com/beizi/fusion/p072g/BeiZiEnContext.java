package com.beizi.fusion.p072g;

import android.app.Application;

/* renamed from: com.beizi.fusion.g.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiEnContext {

    /* renamed from: a */
    private static final Application f11359a;

    static {
        Application application;
        Throwable th;
        try {
            try {
                application = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
                if (application == null) {
                    try {
                        throw new IllegalStateException("Static initialization of Applications must be on main thread.");
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        try {
                            application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                            e.printStackTrace();
                        }
                        f11359a = application;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                application = null;
            } catch (Throwable th2) {
                application = null;
                th = th2;
                f11359a = application;
                throw th;
            }
            f11359a = application;
        } catch (Throwable th3) {
            th = th3;
            f11359a = application;
            throw th;
        }
    }

    /* renamed from: a */
    public static Application m48266a() {
        return f11359a;
    }
}
