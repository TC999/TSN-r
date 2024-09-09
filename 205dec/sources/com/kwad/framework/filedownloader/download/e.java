package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private final String VM;
    private final int afG;
    private final long afO;
    long afP;
    private final long afQ;
    private final com.kwad.framework.filedownloader.b.a afV;
    private final f agD;
    private final int agF;
    private final c agV;
    private final com.kwad.framework.filedownloader.a.b agW;
    private com.kwad.framework.filedownloader.e.a agX;
    private volatile long agY;
    private volatile long agZ;
    private final boolean agd;
    private final long contentLength;
    private volatile boolean kH;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        String VM;
        Integer afM;
        com.kwad.framework.filedownloader.download.a afN;
        Boolean agA;
        f agD;
        Integer agH;
        com.kwad.framework.filedownloader.a.b agW;
        c aha;

        public final a a(c cVar) {
            this.aha = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.agD = fVar;
            return this;
        }

        public final a bf(boolean z3) {
            this.agA = Boolean.valueOf(z3);
            return this;
        }

        public final a bl(String str) {
            this.VM = str;
            return this;
        }

        public final a bv(int i4) {
            this.agH = Integer.valueOf(i4);
            return this;
        }

        public final a bw(int i4) {
            this.afM = Integer.valueOf(i4);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.afN = aVar;
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.agW = bVar;
            return this;
        }

        public final e vS() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.agA != null && (bVar = this.agW) != null && (aVar = this.afN) != null && this.agD != null && this.VM != null && (num = this.afM) != null && this.agH != null) {
                return new e(bVar, aVar, this.aha, num.intValue(), this.agH.intValue(), this.agA.booleanValue(), this.agD, this.VM, (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i4, int i5, boolean z3, f fVar, String str, byte b4) {
        this(bVar, aVar, cVar, i4, i5, z3, fVar, str);
    }

    private void sync() {
        boolean z3;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.agX.wI();
            z3 = true;
        } catch (IOException e4) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e4);
            }
            z3 = false;
        }
        if (z3) {
            if (this.agV != null) {
                this.afV.a(this.afG, this.agF, this.afP);
            } else {
                this.agD.vA();
            }
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.afG), Integer.valueOf(this.agF), Long.valueOf(this.afP), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    private void vR() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.afP - this.agY, elapsedRealtime - this.agZ)) {
            sync();
            this.agY = this.afP;
            this.agZ = elapsedRealtime;
        }
    }

    public final void pause() {
        this.kH = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
        if (r13 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0120, code lost:
        com.kwad.sdk.crash.utils.b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.b.closeQuietly(r13);
        r6 = r16.afP - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012d, code lost:
        if (r2 == (-1)) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0131, code lost:
        if (r2 != r6) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0170, code lost:
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.afO), java.lang.Long.valueOf(r16.afQ), java.lang.Long.valueOf(r16.afP), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0171, code lost:
        r16.agD.a(r16.agV, r16.afO, r16.afQ);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017c, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.e.run():void");
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i4, int i5, boolean z3, f fVar, String str) {
        this.agY = 0L;
        this.agZ = 0L;
        this.agD = fVar;
        this.VM = str;
        this.agW = bVar;
        this.agd = z3;
        this.agV = cVar;
        this.agF = i5;
        this.afG = i4;
        this.afV = b.vo().vq();
        this.afO = aVar.afO;
        this.afQ = aVar.afQ;
        this.afP = aVar.afP;
        this.contentLength = aVar.contentLength;
    }
}
