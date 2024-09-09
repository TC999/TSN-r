package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f50009a;
    private final Handler bl;
    private final com.ss.android.socialbase.downloader.q.p<String, a> ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f50014a;
        List<InetAddress> ok;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.downloader.network.bl$bl  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C1017bl {
        private static final bl ok = new bl();
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok {
        void ok(String str, List<InetAddress> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
        r10 = r2.ok;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #2 {all -> 0x0095, blocks: (B:2:0x0000, B:3:0x000a, B:7:0x0016, B:10:0x0034, B:12:0x003a, B:14:0x0052, B:21:0x0063, B:29:0x0078, B:32:0x007f, B:35:0x0087, B:37:0x008e, B:34:0x0085, B:23:0x0069, B:24:0x006d, B:4:0x000b, B:5:0x0013, B:16:0x0058), top: B:45:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final java.lang.String r8, final com.ss.android.socialbase.downloader.network.bl.ok r9, long r10) {
        /*
            r7 = this;
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L95
            com.ss.android.socialbase.downloader.q.p<java.lang.String, com.ss.android.socialbase.downloader.network.bl$a> r1 = r7.ok     // Catch: java.lang.Throwable -> L95
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L95
            com.ss.android.socialbase.downloader.q.p<java.lang.String, com.ss.android.socialbase.downloader.network.bl$a> r2 = r7.ok     // Catch: java.lang.Throwable -> L92
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L92
            com.ss.android.socialbase.downloader.network.bl$a r2 = (com.ss.android.socialbase.downloader.network.bl.a) r2     // Catch: java.lang.Throwable -> L92
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L3a
            com.ss.android.socialbase.downloader.h.ok r1 = com.ss.android.socialbase.downloader.h.ok.bl()     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = "dns_expire_min"
            r4 = 10
            int r1 = r1.ok(r3, r4)     // Catch: java.lang.Throwable -> L95
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L95
            long r5 = r2.f50014a     // Catch: java.lang.Throwable -> L95
            long r3 = r3 - r5
            int r1 = r1 * 60
            int r1 = r1 * 1000
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L95
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3a
            if (r9 == 0) goto L39
            java.util.List<java.net.InetAddress> r10 = r2.ok     // Catch: java.lang.Throwable -> L95
            r9.ok(r8, r10)     // Catch: java.lang.Throwable -> L95
        L39:
            return
        L3a:
            com.ss.android.socialbase.downloader.network.bl$2 r1 = new com.ss.android.socialbase.downloader.network.bl$2     // Catch: java.lang.Throwable -> L95
            r1.<init>()     // Catch: java.lang.Throwable -> L95
            android.os.Handler r3 = r7.bl     // Catch: java.lang.Throwable -> L95
            r3.postDelayed(r1, r10)     // Catch: java.lang.Throwable -> L95
            r10 = 0
            com.ss.android.socialbase.downloader.h.ok r11 = com.ss.android.socialbase.downloader.h.ok.bl()     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = "use_host_dns"
            r4 = 1
            int r11 = r11.ok(r3, r4)     // Catch: java.lang.Throwable -> L95
            if (r11 != r4) goto L61
            com.ss.android.socialbase.downloader.network.kf r11 = com.ss.android.socialbase.downloader.downloader.bl.ul()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto L61
            java.util.List r10 = r11.ok(r0)     // Catch: java.lang.Throwable -> L5d
            goto L61
        L5d:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L95
        L61:
            if (r10 == 0) goto L69
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto L76
        L69:
            com.ss.android.socialbase.downloader.network.kf r11 = com.ss.android.socialbase.downloader.downloader.bl.o()     // Catch: java.lang.Throwable -> L95
            java.util.List r10 = r11.ok(r0)     // Catch: java.lang.Throwable -> L72
            goto L76
        L72:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L95
        L76:
            if (r10 == 0) goto L83
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto L7f
            goto L83
        L7f:
            r7.ok(r0, r10)     // Catch: java.lang.Throwable -> L95
            goto L87
        L83:
            if (r2 == 0) goto L87
            java.util.List<java.net.InetAddress> r10 = r2.ok     // Catch: java.lang.Throwable -> L95
        L87:
            android.os.Handler r11 = r7.bl     // Catch: java.lang.Throwable -> L95
            r11.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L95
            if (r9 == 0) goto L99
            r9.ok(r8, r10)     // Catch: java.lang.Throwable -> L95
            goto L99
        L92:
            r8 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L92
            throw r8     // Catch: java.lang.Throwable -> L95
        L95:
            r8 = move-exception
            r8.printStackTrace()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.network.bl.a(java.lang.String, com.ss.android.socialbase.downloader.network.bl$ok, long):void");
    }

    private bl() {
        this.ok = new com.ss.android.socialbase.downloader.q.p<>(4, 16, false);
        this.f50009a = new Handler(com.ss.android.socialbase.downloader.network.ok.a.ok());
        this.bl = new Handler(com.ss.android.socialbase.downloader.p.n.ok());
    }

    public static bl ok() {
        return C1017bl.ok;
    }

    public void ok(final String str, final ok okVar, final long j4) {
        this.f50009a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.bl.1
            @Override // java.lang.Runnable
            public void run() {
                bl.this.a(str, okVar, j4);
            }
        });
    }

    private void ok(String str, List<InetAddress> list) {
        synchronized (this.ok) {
            a aVar = this.ok.get(str);
            if (aVar == null) {
                aVar = new a();
                this.ok.put(str, aVar);
            }
            aVar.ok = list;
            aVar.f50014a = System.currentTimeMillis();
        }
    }
}
