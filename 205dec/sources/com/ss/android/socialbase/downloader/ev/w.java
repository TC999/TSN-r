package com.ss.android.socialbase.downloader.ev;

import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.gd;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49546c = w.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private boolean f49547a;
    private gd ev;

    /* renamed from: f  reason: collision with root package name */
    private DownloadInfo f49548f;
    private p gd;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f49549k;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f49550p;

    /* renamed from: r  reason: collision with root package name */
    private final f f49551r;
    private com.ss.android.socialbase.downloader.downloader.ux sr;
    private final DownloadTask ux;

    /* renamed from: w  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.w f49552w;
    private com.ss.android.socialbase.downloader.model.w xv;

    public w(com.ss.android.socialbase.downloader.model.w wVar, DownloadTask downloadTask, f fVar) {
        this.f49547a = false;
        this.xv = wVar;
        this.ux = downloadTask;
        if (downloadTask != null) {
            this.f49548f = downloadTask.getDownloadInfo();
        }
        this.f49551r = fVar;
        this.gd = com.ss.android.socialbase.downloader.downloader.xv.gb();
        this.xv.c(this);
    }

    private void sr() {
        gd gdVar = this.ev;
        if (gdVar != null) {
            gdVar.sr();
            this.ev = null;
        }
    }

    private boolean ux() {
        return this.f49550p || this.f49549k;
    }

    private String xv() {
        return this.f49548f.getConnectionUrl();
    }

    public void c(long j4, long j5) {
        com.ss.android.socialbase.downloader.downloader.ux uxVar = this.sr;
        if (uxVar == null) {
            return;
        }
        uxVar.c(j4, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.f49552w.c(false);
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
            com.ss.android.socialbase.downloader.model.w r0 = r3.xv
            r3.f49552w = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.w r1 = r3.f49552w     // Catch: java.lang.Throwable -> L5d
            r1.c(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.w r1 = r3.f49552w     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.c(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.w r1 = r3.f49552w     // Catch: java.lang.Throwable -> L5d
            r1.c(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.w r1 = r3.f49552w     // Catch: java.lang.Throwable -> L5d
            r1.c(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.ux()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.ev.f r1 = r3.f49551r     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.w r2 = r3.f49552w     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.fz()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.w r1 = r1.c(r2)     // Catch: java.lang.Throwable -> L5d
            r3.f49552w = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.ux()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.w r1 = r3.f49552w     // Catch: java.lang.Throwable -> L5d
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
            com.ss.android.socialbase.downloader.model.w r1 = r3.f49552w
            if (r1 == 0) goto L54
            r1.c(r0)
        L54:
            r3.sr()
            com.ss.android.socialbase.downloader.ev.f r0 = r3.f49551r
            r0.c(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.w r2 = r3.f49552w
            if (r2 == 0) goto L65
            r2.c(r0)
        L65:
            r3.sr()
            com.ss.android.socialbase.downloader.ev.f r0 = r3.f49551r
            r0.c(r3)
            goto L6f
        L6e:
            throw r1
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.w.run():void");
    }

    public void w() {
        this.f49549k = true;
        com.ss.android.socialbase.downloader.downloader.ux uxVar = this.sr;
        if (uxVar != null) {
            uxVar.xv();
        }
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
    private boolean c(com.ss.android.socialbase.downloader.model.w r31) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.w.c(com.ss.android.socialbase.downloader.model.w):boolean");
    }

    public w(com.ss.android.socialbase.downloader.model.w wVar, DownloadTask downloadTask, gd gdVar, f fVar) {
        this(wVar, downloadTask, fVar);
        this.ev = gdVar;
    }

    private void c(com.ss.android.socialbase.downloader.model.w wVar, long j4) {
        com.ss.android.socialbase.downloader.model.w ux = wVar.sr() ? wVar.ux() : wVar;
        if (ux != null) {
            if (ux.ev()) {
                this.gd.c(ux.k(), ux.w(), j4);
            }
            ux.w(j4);
            this.gd.c(ux.k(), ux.fz(), ux.w(), j4);
        } else if (wVar.sr()) {
            this.gd.c(wVar.k(), wVar.fz(), j4);
        }
    }

    public void c() {
        this.f49550p = true;
        com.ss.android.socialbase.downloader.downloader.ux uxVar = this.sr;
        if (uxVar != null) {
            uxVar.w();
        }
    }
}
