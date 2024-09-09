package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.Proxy;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ProxyUtil.java */
/* renamed from: com.amap.api.col.3l.o4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o4 {

    /* compiled from: SDKInfo.java */
    /* renamed from: com.amap.api.col.3l.o4$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8454a;

        /* renamed from: b  reason: collision with root package name */
        private String f8455b;

        /* renamed from: c  reason: collision with root package name */
        private String f8456c;

        /* renamed from: d  reason: collision with root package name */
        private String f8457d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8458e = true;

        /* renamed from: f  reason: collision with root package name */
        private String f8459f = "standard";

        /* renamed from: g  reason: collision with root package name */
        private String[] f8460g = null;

        public a(String str, String str2, String str3) {
            this.f8454a = str2;
            this.f8455b = str2;
            this.f8457d = str3;
            this.f8456c = str;
        }

        public final a a(String str) {
            this.f8455b = str;
            return this;
        }

        public final a b(String[] strArr) {
            if (strArr != null) {
                this.f8460g = (String[]) strArr.clone();
            }
            return this;
        }

        public final o4 c() throws fk {
            if (this.f8460g != null) {
                return new o4(this, (byte) 0);
            }
            throw new fk("sdk packages is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            u5.p(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static String b(String str) {
        return q4.u(str);
    }

    public static java.net.Proxy c(Context context) {
        try {
            return d(context, new URI("http://restsdk.amap.com"));
        } catch (Throwable th) {
            u5.p(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy d(Context context, URI uri) {
        java.net.Proxy proxy;
        if (g(context)) {
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
                u5.p(th, "pu", "gpsc");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            u5.p(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r10 == (-1)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
        if (r10 == (-1)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
        r18 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ac, code lost:
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x011a, code lost:
        if (r12 == (-1)) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015d A[Catch: all -> 0x0159, TRY_LEAVE, TryCatch #10 {all -> 0x0159, blocks: (B:108:0x014e, B:115:0x015d), top: B:130:0x014e }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0 A[Catch: all -> 0x0172, TryCatch #8 {all -> 0x0172, blocks: (B:66:0x00cb, B:75:0x00e5, B:77:0x00f0, B:79:0x0104, B:81:0x010a, B:86:0x0116, B:89:0x011f, B:91:0x0125, B:93:0x012b, B:98:0x0137), top: B:129:0x0029 }] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy f(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.o4.f(android.content.Context):java.net.Proxy");
    }

    private static boolean g(Context context) {
        return i4.M(context) == 0;
    }
}
