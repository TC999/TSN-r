package com.bytedance.pangle.log;

import com.bytedance.pangle.util.k;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {
    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static int b(Object obj) {
        if (obj == null) {
            return -1;
        }
        return k.a(obj.toString());
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
