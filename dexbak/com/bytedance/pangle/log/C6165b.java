package com.bytedance.pangle.log;

import com.bytedance.pangle.util.C6255k;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.bytedance.pangle.log.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6165b {
    /* renamed from: a */
    public static String m37072a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /* renamed from: b */
    public static int m37070b(Object obj) {
        if (obj == null) {
            return -1;
        }
        return C6255k.m36870a(obj.toString());
    }

    /* renamed from: a */
    public static String m37071a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
