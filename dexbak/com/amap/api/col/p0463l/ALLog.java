package com.amap.api.col.p0463l;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: com.amap.api.col.3l.m9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ALLog {
    /* renamed from: a */
    public static void m54456a(Throwable th) {
        if (AmapContext.f4305a) {
            m54455b(th);
        }
    }

    /* renamed from: b */
    private static String m54455b(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
