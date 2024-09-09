package com.bytedance.msdk.sr.w;

import com.bytedance.msdk.api.sr.p;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    private static volatile w xv;

    /* renamed from: c  reason: collision with root package name */
    public p f28430c;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, com.bytedance.msdk.adapter.c.xv> f28431w = new ConcurrentHashMap();

    private w() {
    }

    public static w c() {
        if (xv == null) {
            synchronized (w.class) {
                if (xv == null) {
                    xv = new w();
                }
            }
        }
        return xv;
    }

    private com.bytedance.msdk.adapter.c.xv sr() {
        return new sr();
    }

    public synchronized Map<String, com.bytedance.msdk.adapter.c.xv> w() {
        return this.f28431w;
    }

    public Collection<com.bytedance.msdk.adapter.c.xv> xv() {
        return this.f28431w.values();
    }

    private com.bytedance.msdk.adapter.c.xv w(String str) {
        return this.f28431w.get(str);
    }

    public com.bytedance.msdk.adapter.c.xv c(String str, p pVar) {
        this.f28430c = pVar;
        return c(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        c(r5, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.bytedance.msdk.adapter.c.xv c(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bytedance.msdk.core.fp.xv r0 = com.bytedance.msdk.core.c.w()     // Catch: java.lang.Throwable -> L3b
            com.bytedance.msdk.core.k.c r0 = r0.c(r5)     // Catch: java.lang.Throwable -> L3b
            com.bytedance.msdk.adapter.c.xv r1 = r4.w(r5)     // Catch: java.lang.Throwable -> L3b
            if (r1 != 0) goto L39
            if (r0 != 0) goto L27
            com.bytedance.msdk.api.sr.p r2 = r4.f28430c     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L27
            com.bytedance.msdk.core.k.c r0 = new com.bytedance.msdk.core.k.c     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = r2.xv()     // Catch: java.lang.Throwable -> L3b
            com.bytedance.msdk.api.sr.p r3 = r4.f28430c     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.sr()     // Catch: java.lang.Throwable -> L3b
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            r4.f28430c = r2     // Catch: java.lang.Throwable -> L3b
        L27:
            if (r0 == 0) goto L34
            boolean r0 = r0.sr()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L30
            goto L34
        L30:
            com.bytedance.msdk.adapter.c.xv r1 = r4.sr()     // Catch: java.lang.Throwable -> L3b
        L34:
            if (r1 == 0) goto L39
            r4.c(r5, r1)     // Catch: java.lang.Throwable -> L3b
        L39:
            monitor-exit(r4)
            return r1
        L3b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.sr.w.w.c(java.lang.String):com.bytedance.msdk.adapter.c.xv");
    }

    private void c(String str, com.bytedance.msdk.adapter.c.xv xvVar) {
        this.f28431w.put(str, xvVar);
    }
}
