package com.ss.android.socialbase.downloader.p;

import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.q;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements Runnable {
    private static final String ok = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.a f50106a;
    private com.ss.android.socialbase.downloader.model.a bl;

    /* renamed from: h  reason: collision with root package name */
    private final kf f50107h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f50108j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f50109k;
    private DownloadInfo kf;

    /* renamed from: n  reason: collision with root package name */
    private final DownloadTask f50110n;

    /* renamed from: p  reason: collision with root package name */
    private q f50111p;

    /* renamed from: q  reason: collision with root package name */
    private k f50112q;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f50113r;

    /* renamed from: s  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.n f50114s;

    public a(com.ss.android.socialbase.downloader.model.a aVar, DownloadTask downloadTask, kf kfVar) {
        this.f50108j = false;
        this.bl = aVar;
        this.f50110n = downloadTask;
        if (downloadTask != null) {
            this.kf = downloadTask.getDownloadInfo();
        }
        this.f50107h = kfVar;
        this.f50112q = com.ss.android.socialbase.downloader.downloader.bl.m();
        this.bl.ok(this);
    }

    private String bl() {
        return this.kf.getConnectionUrl();
    }

    private boolean n() {
        return this.f50109k || this.f50113r;
    }

    private void s() {
        q qVar = this.f50111p;
        if (qVar != null) {
            qVar.s();
            this.f50111p = null;
        }
    }

    public void a() {
        this.f50113r = true;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f50114s;
        if (nVar != null) {
            nVar.bl();
        }
    }

    public void ok(long j4, long j5) {
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f50114s;
        if (nVar == null) {
            return;
        }
        nVar.ok(j4, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.f50106a.ok(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.a r0 = r3.bl
            r3.f50106a = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.a r1 = r3.f50106a     // Catch: java.lang.Throwable -> L5d
            r1.ok(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f50106a     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.ok(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f50106a     // Catch: java.lang.Throwable -> L5d
            r1.ok(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.a r1 = r3.f50106a     // Catch: java.lang.Throwable -> L5d
            r1.ok(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.n()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.p.kf r1 = r3.f50107h     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r2 = r3.f50106a     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.zz()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r1 = r1.ok(r2)     // Catch: java.lang.Throwable -> L5d
            r3.f50106a = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.n()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f50106a     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L42
            goto L4d
        L42:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.model.a r1 = r3.f50106a
            if (r1 == 0) goto L54
            r1.ok(r0)
        L54:
            r3.s()
            com.ss.android.socialbase.downloader.p.kf r0 = r3.f50107h
            r0.ok(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.a r2 = r3.f50106a
            if (r2 == 0) goto L65
            r2.ok(r0)
        L65:
            r3.s()
            com.ss.android.socialbase.downloader.p.kf r0 = r3.f50107h
            r0.ok(r3)
            goto L6f
        L6e:
            throw r1
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.a.run():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc A[Catch: all -> 0x02a1, TRY_ENTER, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024f A[Catch: all -> 0x02a1, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0256 A[Catch: all -> 0x02a1, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0264 A[Catch: all -> 0x02a1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0260 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff A[Catch: all -> 0x01b2, BaseException -> 0x01ce, TRY_ENTER, TryCatch #4 {BaseException -> 0x01ce, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:62:0x00f5, B:66:0x00ff, B:68:0x0103, B:79:0x0131, B:51:0x00db), top: B:201:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ok(com.ss.android.socialbase.downloader.model.a r31) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.a.ok(com.ss.android.socialbase.downloader.model.a):boolean");
    }

    public a(com.ss.android.socialbase.downloader.model.a aVar, DownloadTask downloadTask, q qVar, kf kfVar) {
        this(aVar, downloadTask, kfVar);
        this.f50111p = qVar;
    }

    private void ok(com.ss.android.socialbase.downloader.model.a aVar, long j4) {
        com.ss.android.socialbase.downloader.model.a n4 = aVar.s() ? aVar.n() : aVar;
        if (n4 != null) {
            if (n4.p()) {
                this.f50112q.ok(n4.r(), n4.a(), j4);
            }
            n4.a(j4);
            this.f50112q.ok(n4.r(), n4.zz(), n4.a(), j4);
        } else if (aVar.s()) {
            this.f50112q.ok(aVar.r(), aVar.zz(), j4);
        }
    }

    public void ok() {
        this.f50109k = true;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f50114s;
        if (nVar != null) {
            nVar.a();
        }
    }
}
