package com.amap.api.col.p0463l;

import android.content.Context;
import android.net.Proxy;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* renamed from: com.amap.api.col.3l.n4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ProxyUtil {
    /* renamed from: a */
    private static String m54442a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    /* renamed from: b */
    private static String m54441b(String str) {
        return C1925p4.m54183u(str);
    }

    /* renamed from: c */
    public static java.net.Proxy m54440c(Context context) {
        try {
            return m54439d(context, new URI("http://restsdk.amap.com"));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "pu", "gp");
            return null;
        }
    }

    /* renamed from: d */
    private static java.net.Proxy m54439d(Context context, URI uri) {
        java.net.Proxy proxy;
        if (m54436g(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null) {
                    return null;
                }
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "pu", "gpsc");
            }
        }
        return null;
    }

    /* renamed from: e */
    private static int m54438e() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        if (r10 == (-1)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        if (r10 == (-1)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a8, code lost:
        r18 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ab, code lost:
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0119, code lost:
        if (r12 == (-1)) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015c A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #10 {all -> 0x0158, blocks: (B:108:0x014d, B:115:0x015c), top: B:130:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef A[Catch: all -> 0x0171, TryCatch #8 {all -> 0x0171, blocks: (B:66:0x00ca, B:75:0x00e4, B:77:0x00ef, B:79:0x0103, B:81:0x0109, B:86:0x0115, B:89:0x011e, B:91:0x0124, B:93:0x012a, B:98:0x0136), top: B:129:0x0028 }] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy m54437f(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.ProxyUtil.m54437f(android.content.Context):java.net.Proxy");
    }

    /* renamed from: g */
    private static boolean m54436g(Context context) {
        return DeviceInfo.m54809M(context) == 0;
    }
}
