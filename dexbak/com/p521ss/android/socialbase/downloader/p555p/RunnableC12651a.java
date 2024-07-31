package com.p521ss.android.socialbase.downloader.p555p;

import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12505n;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;

/* renamed from: com.ss.android.socialbase.downloader.p.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC12651a implements Runnable {

    /* renamed from: ok */
    private static final String f35663ok = RunnableC12651a.class.getSimpleName();

    /* renamed from: a */
    private C12598a f35664a;

    /* renamed from: bl */
    private C12598a f35665bl;

    /* renamed from: h */
    private final InterfaceC12658kf f35666h;

    /* renamed from: j */
    private boolean f35667j;

    /* renamed from: k */
    private volatile boolean f35668k;

    /* renamed from: kf */
    private DownloadInfo f35669kf;

    /* renamed from: n */
    private final DownloadTask f35670n;

    /* renamed from: p */
    private InterfaceC12635q f35671p;

    /* renamed from: q */
    private InterfaceC12501k f35672q;

    /* renamed from: r */
    private volatile boolean f35673r;

    /* renamed from: s */
    private C12505n f35674s;

    public RunnableC12651a(C12598a c12598a, DownloadTask downloadTask, InterfaceC12658kf interfaceC12658kf) {
        this.f35667j = false;
        this.f35665bl = c12598a;
        this.f35670n = downloadTask;
        if (downloadTask != null) {
            this.f35669kf = downloadTask.getDownloadInfo();
        }
        this.f35666h = interfaceC12658kf;
        this.f35672q = C12490bl.m17806m();
        this.f35665bl.m17031ok(this);
    }

    /* renamed from: bl */
    private String m16833bl() {
        return this.f35669kf.getConnectionUrl();
    }

    /* renamed from: n */
    private boolean m16832n() {
        return this.f35668k || this.f35673r;
    }

    /* renamed from: s */
    private void m16827s() {
        InterfaceC12635q interfaceC12635q = this.f35671p;
        if (interfaceC12635q != null) {
            interfaceC12635q.mo16908s();
            this.f35671p = null;
        }
    }

    /* renamed from: a */
    public void m16834a() {
        this.f35673r = true;
        C12505n c12505n = this.f35674s;
        if (c12505n != null) {
            c12505n.m17701bl();
        }
    }

    /* renamed from: ok */
    public void m16830ok(long j, long j2) {
        C12505n c12505n = this.f35674s;
        if (c12505n == null) {
            return;
        }
        c12505n.m17696ok(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.f35664a.m17029ok(false);
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
            com.ss.android.socialbase.downloader.model.a r0 = r3.f35665bl
            r3.f35664a = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.a r1 = r3.f35664a     // Catch: java.lang.Throwable -> L5d
            r1.m17031ok(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f35664a     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.m16829ok(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f35664a     // Catch: java.lang.Throwable -> L5d
            r1.m17029ok(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.a r1 = r3.f35664a     // Catch: java.lang.Throwable -> L5d
            r1.m17029ok(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.m16832n()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.p.kf r1 = r3.f35666h     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r2 = r3.f35664a     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.m17019zz()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.a r1 = r1.mo16758ok(r2)     // Catch: java.lang.Throwable -> L5d
            r3.f35664a = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.m16832n()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.a r1 = r3.f35664a     // Catch: java.lang.Throwable -> L5d
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
            com.ss.android.socialbase.downloader.model.a r1 = r3.f35664a
            if (r1 == 0) goto L54
            r1.m17029ok(r0)
        L54:
            r3.m16827s()
            com.ss.android.socialbase.downloader.p.kf r0 = r3.f35666h
            r0.mo16751ok(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.a r2 = r3.f35664a
            if (r2 == 0) goto L65
            r2.m17029ok(r0)
        L65:
            r3.m16827s()
            com.ss.android.socialbase.downloader.p.kf r0 = r3.f35666h
            r0.mo16751ok(r3)
            goto L6f
        L6e:
            throw r1
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12651a.run():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc A[Catch: all -> 0x02a1, TRY_ENTER, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x024f A[Catch: all -> 0x02a1, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0256 A[Catch: all -> 0x02a1, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0264 A[Catch: all -> 0x02a1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x02a1, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:168:0x0249, B:170:0x024f, B:172:0x025c, B:176:0x0264, B:171:0x0256, B:162:0x0230, B:163:0x023c, B:178:0x026f, B:180:0x0277, B:182:0x027f, B:184:0x0287, B:186:0x028f, B:189:0x0298, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:198:0x01d2, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0260 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff A[Catch: all -> 0x01b2, BaseException -> 0x01ce, TRY_ENTER, TryCatch #4 {BaseException -> 0x01ce, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:62:0x00f5, B:66:0x00ff, B:68:0x0103, B:79:0x0131, B:51:0x00db), top: B:201:0x004f }] */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m16829ok(com.p521ss.android.socialbase.downloader.model.C12598a r31) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12651a.m16829ok(com.ss.android.socialbase.downloader.model.a):boolean");
    }

    public RunnableC12651a(C12598a c12598a, DownloadTask downloadTask, InterfaceC12635q interfaceC12635q, InterfaceC12658kf interfaceC12658kf) {
        this(c12598a, downloadTask, interfaceC12658kf);
        this.f35671p = interfaceC12635q;
    }

    /* renamed from: ok */
    private void m16828ok(C12598a c12598a, long j) {
        C12598a m17038n = c12598a.m17024s() ? c12598a.m17038n() : c12598a;
        if (m17038n != null) {
            if (m17038n.m17028p()) {
                this.f35672q.mo17495ok(m17038n.m17026r(), m17038n.m17050a(), j);
            }
            m17038n.m17048a(j);
            this.f35672q.mo17496ok(m17038n.m17026r(), m17038n.m17019zz(), m17038n.m17050a(), j);
        } else if (c12598a.m17024s()) {
            this.f35672q.mo17495ok(c12598a.m17026r(), c12598a.m17019zz(), j);
        }
    }

    /* renamed from: ok */
    public void m16831ok() {
        this.f35668k = true;
        C12505n c12505n = this.f35674s;
        if (c12505n != null) {
            c12505n.m17703a();
        }
    }
}
