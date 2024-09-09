package com.volcengine.mobsecBiz.metasec.ml;

import android.content.Context;
import ms.bz.bd.c.Pgl.m0;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class d {
    public static synchronized c a(String str) {
        c cVar;
        synchronized (d.class) {
            m0.pgla d4 = m0.d(str);
            cVar = d4 != null ? new c(d4) : null;
        }
        return cVar;
    }

    public static synchronized boolean b(Context context, a aVar) {
        boolean c4;
        synchronized (d.class) {
            c4 = m0.c(context, aVar.b(), "Pglbizssdk_ml", null);
        }
        return c4;
    }

    public static synchronized void c(String str) {
        synchronized (d.class) {
            m0.b(str);
        }
    }
}
