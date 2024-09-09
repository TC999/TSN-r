package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor agl = com.kwad.framework.filedownloader.f.b.bq("ConnectionBlock");
    private final com.kwad.framework.filedownloader.b.a afV;
    private final d afY;
    private final int afZ;
    private final com.kwad.framework.filedownloader.d.c aga;
    private final com.kwad.framework.filedownloader.d.b agb;
    private final boolean agc;
    private final boolean agd;
    private final y age;
    private boolean agf;
    int agg;
    private final boolean agh;
    private final ArrayList<c> agi;
    private e agj;
    private boolean agk;
    private boolean agm;
    private boolean agn;
    private boolean ago;
    private final AtomicBoolean agp;
    private volatile boolean agq;
    private volatile Exception agr;
    private String ags;
    private long agt;
    private long agu;
    private long agv;
    private long agw;
    private volatile boolean kH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private com.kwad.framework.filedownloader.d.b afH;
        private Boolean agA;
        private Integer agB;
        private com.kwad.framework.filedownloader.d.c aga;
        private y age;
        private Integer agx;
        private Integer agy;
        private Boolean agz;

        public final a a(y yVar) {
            this.age = yVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.afH = bVar;
            return this;
        }

        public final a c(Integer num) {
            this.agB = num;
            return this;
        }

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.aga = cVar;
            return this;
        }

        public final DownloadLaunchRunnable vE() {
            if (this.aga != null && this.age != null && this.agx != null && this.agy != null && this.agz != null && this.agA != null && this.agB != null) {
                return new DownloadLaunchRunnable(this.aga, this.afH, this.age, this.agx.intValue(), this.agy.intValue(), this.agz.booleanValue(), this.agA.booleanValue(), this.agB.intValue(), (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        public final a a(Integer num) {
            this.agx = num;
            return this;
        }

        public final a b(Integer num) {
            this.agy = num;
            return this;
        }

        public final a a(Boolean bool) {
            this.agz = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.agA = bool;
            return this;
        }
    }

    /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i4, int i5, boolean z3, boolean z4, int i6, byte b4) {
        this(cVar, bVar, yVar, i4, i5, z3, z4, i6);
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) {
        int id = this.aga.getId();
        int responseCode = bVar.getResponseCode();
        this.agn = responseCode == 206 || responseCode == 1;
        boolean z3 = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String wm = this.aga.wm();
        String a4 = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (responseCode == 412 || !(wm == null || wm.equals(a4) || (!z3 && !this.agn)) || ((responseCode == 201 && connectTask.vk()) || (responseCode == 416 && this.aga.wl() > 0))) {
            if (this.agm) {
                com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]\u3001new etag[%s]\u3001response requestHttpCode is %d", Integer.valueOf(id), wm, a4, Integer.valueOf(responseCode));
            }
            this.afV.bm(this.aga.getId());
            com.kwad.framework.filedownloader.f.f.B(this.aga.getTargetFilePath(), this.aga.vD());
            this.agm = false;
            if (wm != 0 && wm.equals(a4)) {
                com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", wm, a4, Integer.valueOf(responseCode), Integer.valueOf(id));
                a4 = null;
            }
            this.aga.S(0L);
            this.aga.U(0L);
            this.aga.bn(a4);
            this.aga.wp();
            this.afV.a(id, this.aga.wm(), this.aga.wl(), this.aga.getTotal(), this.aga.wo());
            throw new RetryDirectly();
        }
        this.ags = connectTask.vl();
        if (!this.agn && !z3) {
            throw new FileDownloadHttpException(responseCode, map, bVar.vd());
        }
        long b4 = com.kwad.framework.filedownloader.f.f.b(id, bVar);
        String a5 = this.aga.tR() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.aga.getUrl()) : null;
        boolean z4 = b4 == -1;
        this.ago = z4;
        this.afY.a(this.agm && this.agn, !z4 ? this.aga.wl() + b4 : b4, a4, a5);
    }

    private void b(long j4, int i4) {
        long j5 = j4 / i4;
        int id = this.aga.getId();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        long j6 = 0;
        while (i5 < i4) {
            long j7 = i5 == i4 + (-1) ? 0L : (j6 + j5) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i5);
            aVar.setStartOffset(j6);
            aVar.Q(j6);
            aVar.R(j7);
            arrayList.add(aVar);
            this.afV.a(aVar);
            j6 += j5;
            i5++;
        }
        this.aga.bD(i4);
        this.afV.s(id, i4);
        b(arrayList, j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.framework.filedownloader.download.a q(java.util.List<com.kwad.framework.filedownloader.d.a> r21) {
        /*
            r20 = this;
            r0 = r20
            com.kwad.framework.filedownloader.d.c r1 = r0.aga
            int r1 = r1.wo()
            com.kwad.framework.filedownloader.d.c r2 = r0.aga
            java.lang.String r2 = r2.vD()
            com.kwad.framework.filedownloader.d.c r3 = r0.aga
            java.lang.String r3 = r3.getTargetFilePath()
            r4 = 0
            r5 = 1
            if (r1 <= r5) goto L1a
            r6 = 1
            goto L1b
        L1a:
            r6 = 0
        L1b:
            r7 = 0
            if (r6 == 0) goto L23
            boolean r9 = r0.agh
            if (r9 == 0) goto L54
        L23:
            com.kwad.framework.filedownloader.d.c r9 = r0.aga
            int r9 = r9.getId()
            com.kwad.framework.filedownloader.d.c r10 = r0.aga
            boolean r9 = com.kwad.framework.filedownloader.f.f.b(r9, r10)
            if (r9 == 0) goto L54
            boolean r9 = r0.agh
            if (r9 != 0) goto L40
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            long r9 = r1.length()
        L3e:
            r14 = r9
            goto L55
        L40:
            if (r6 == 0) goto L4d
            int r6 = r21.size()
            if (r1 != r6) goto L54
            long r9 = com.kwad.framework.filedownloader.d.a.r(r21)
            goto L3e
        L4d:
            com.kwad.framework.filedownloader.d.c r1 = r0.aga
            long r9 = r1.wl()
            goto L3e
        L54:
            r14 = r7
        L55:
            com.kwad.framework.filedownloader.d.c r1 = r0.aga
            r1.S(r14)
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L5f
            r4 = 1
        L5f:
            r0.agm = r4
            if (r4 != 0) goto L71
            com.kwad.framework.filedownloader.b.a r1 = r0.afV
            com.kwad.framework.filedownloader.d.c r4 = r0.aga
            int r4 = r4.getId()
            r1.bm(r4)
            com.kwad.framework.filedownloader.f.f.B(r3, r2)
        L71:
            com.kwad.framework.filedownloader.download.a r1 = new com.kwad.framework.filedownloader.download.a
            r12 = 0
            r16 = 0
            com.kwad.framework.filedownloader.d.c r2 = r0.aga
            long r2 = r2.getTotal()
            long r18 = r2 - r14
            r11 = r1
            r11.<init>(r12, r14, r16, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.q(java.util.List):com.kwad.framework.filedownloader.download.a");
    }

    private void vB() {
        if (this.agd && !com.kwad.framework.filedownloader.f.f.by("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.aga.getId()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.agd && com.kwad.framework.filedownloader.f.f.wS()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void vC() {
        int id = this.aga.getId();
        if (this.aga.tR()) {
            String targetFilePath = this.aga.getTargetFilePath();
            int A = com.kwad.framework.filedownloader.f.f.A(this.aga.getUrl(), targetFilePath);
            if (!com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.agc, false)) {
                com.kwad.framework.filedownloader.d.c bk = this.afV.bk(A);
                if (bk != null) {
                    if (!com.kwad.framework.filedownloader.f.c.a(id, bk, this.age, false)) {
                        List<com.kwad.framework.filedownloader.d.a> bl = this.afV.bl(A);
                        this.afV.bn(A);
                        this.afV.bm(A);
                        com.kwad.framework.filedownloader.f.f.bC(this.aga.getTargetFilePath());
                        if (com.kwad.framework.filedownloader.f.f.b(A, bk)) {
                            this.aga.S(bk.wl());
                            this.aga.U(bk.getTotal());
                            this.aga.bn(bk.wm());
                            this.aga.bD(bk.wo());
                            this.afV.b(this.aga);
                            if (bl != null) {
                                for (com.kwad.framework.filedownloader.d.a aVar : bl) {
                                    aVar.setId(id);
                                    this.afV.a(aVar);
                                }
                            }
                            throw new RetryDirectly();
                        }
                    } else {
                        this.afV.bn(id);
                        this.afV.bm(id);
                        throw new DiscardSafely();
                    }
                }
                if (com.kwad.framework.filedownloader.f.c.a(id, this.aga.wl(), this.aga.vD(), targetFilePath, this.age)) {
                    this.afV.bn(id);
                    this.afV.bm(id);
                    throw new DiscardSafely();
                }
                return;
            }
            this.afV.bn(id);
            this.afV.bm(id);
            throw new DiscardSafely();
        }
    }

    private boolean vz() {
        return (!this.agm || this.aga.wo() > 1) && this.agn && this.agh && !this.ago;
    }

    public final int getId() {
        return this.aga.getId();
    }

    public final boolean isAlive() {
        return this.agp.get() || this.afY.isAlive();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j4) {
        if (this.kH) {
            return;
        }
        this.afY.onProgress(j4);
    }

    public final void pause() {
        this.kH = true;
        e eVar = this.agj;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.agi.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
        if (r9 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e9, code lost:
        r9.ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ff, code lost:
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.b("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        if (com.kwad.framework.filedownloader.f.d.ail == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        com.kwad.framework.filedownloader.f.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.aga.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
        r19.afY.vG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (r19.kH == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
        if (r19.agq == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r19.afY.vL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
        if (r19.kH == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
        r19.aga.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
        if (r9 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
        r9.ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
        r19.afY.vG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
        if (r19.kH == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
        if (r19.agq == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
        r19.afY.vL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
        vC();
        r14 = r19.aga.getTotal();
        a(r14, r19.aga.vD());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
        if (vz() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
        if (r19.agm == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
        r10 = r19.aga.wo();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
        r17 = r14;
        r10 = com.kwad.framework.filedownloader.download.b.vo().a(r19.aga.getId(), r19.aga.getUrl(), r19.aga.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:
        if (r10 <= 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
        if (r19.kH == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
        r19.aga.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
        if (r9 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
        r9.ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
        r19.afY.vG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
        if (r19.kH == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
        if (r19.agq == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
        r19.afY.vL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bc, code lost:
        if (r10 != 1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c1, code lost:
        r19.agk = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
        if (r11 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
        a(r8.vm(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cd, code lost:
        if (r9 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cf, code lost:
        r9.ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
        r19.afY.vJ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01db, code lost:
        if (r19.agm == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dd, code lost:
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e1, code lost:
        b(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e6, code lost:
        r9 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x025e A[Catch: all -> 0x0219, TryCatch #27 {all -> 0x0219, blocks: (B:46:0x00cf, B:95:0x01d4, B:97:0x01dd, B:98:0x01e1, B:155:0x0258, B:157:0x025e, B:160:0x0266, B:126:0x021c), top: B:206:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0271 A[Catch: all -> 0x0291, TryCatch #25 {all -> 0x0291, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:164:0x0271, B:165:0x0274, B:130:0x022b, B:128:0x0224, B:162:0x026b), top: B:205:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0266 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 707
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void vA() {
        this.afV.b(this.aga.getId(), this.aga.wl());
    }

    public final String vD() {
        return this.aga.vD();
    }

    public final void vy() {
        if (this.aga.wo() > 1) {
            List<com.kwad.framework.filedownloader.d.a> bl = this.afV.bl(this.aga.getId());
            if (this.aga.wo() == bl.size()) {
                this.aga.S(com.kwad.framework.filedownloader.d.a.r(bl));
            } else {
                this.aga.S(0L);
                this.afV.bm(this.aga.getId());
            }
        }
        this.afY.vH();
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i4, int i5, boolean z3, boolean z4, int i6) {
        this.afZ = 5;
        this.agi = new ArrayList<>(5);
        this.agt = 0L;
        this.agu = 0L;
        this.agv = 0L;
        this.agw = 0L;
        this.agp = new AtomicBoolean(true);
        this.kH = false;
        this.agf = false;
        this.aga = cVar;
        this.agb = bVar;
        this.agc = z3;
        this.agd = z4;
        this.afV = b.vo().vq();
        this.agh = b.vo().vs();
        this.age = yVar;
        this.agg = i6;
        this.afY = new d(cVar, i6, i4, i5);
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j4) {
        long wi;
        int id = this.aga.getId();
        String wm = this.aga.wm();
        String str = this.ags;
        if (str == null) {
            str = this.aga.getUrl();
        }
        String vD = this.aga.vD();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j4));
        }
        boolean z3 = this.agm;
        long j5 = 0;
        long j6 = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.wi() == j5) {
                wi = j4 - aVar.wh();
            } else {
                wi = (aVar.wi() - aVar.wh()) + 1;
            }
            long j7 = wi;
            j6 += aVar.wh() - aVar.getStartOffset();
            if (j7 == j5) {
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
                }
            } else {
                c vF = new c.a().bt(id).d(Integer.valueOf(aVar.getIndex())).a(this).bi(str).bj(z3 ? wm : null).c(this.agb).bd(this.agd).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.wh(), aVar.wi(), j7)).bk(vD).vF();
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.agi.add(vF);
            }
            j5 = 0;
        }
        if (j6 != this.aga.wl()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.aga.wl()), Long.valueOf(j6));
            this.aga.S(j6);
        }
        ArrayList arrayList = new ArrayList(this.agi.size());
        Iterator<c> it = this.agi.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.kH) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.kH) {
            this.aga.d((byte) -2);
            return;
        }
        List<Future> invokeAll = agl.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.ail) {
            for (Future future : invokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) {
        if (!this.agn) {
            this.aga.S(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.afQ, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).bw(this.aga.getId()).bv(-1).bf(this.agd).d(bVar).c(aVar).bl(this.aga.vD());
        this.aga.bD(1);
        this.afV.s(this.aga.getId(), 1);
        this.agj = aVar2.vS();
        if (this.kH) {
            this.aga.d((byte) -2);
            this.agj.pause();
            return;
        }
        this.agj.run();
    }

    private void a(int i4, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i4 > 1 && list.size() == i4) {
            b(list, this.aga.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j4, String str) {
        com.kwad.framework.filedownloader.e.a aVar = null;
        if (j4 != -1) {
            try {
                aVar = com.kwad.framework.filedownloader.f.f.bA(this.aga.vD());
                long length = new File(str).length();
                long j5 = j4 - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes >= j5) {
                    if (!com.kwad.framework.filedownloader.f.e.wN().air) {
                        aVar.setLength(j4);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j5, length);
                }
            } finally {
                if (0 != 0) {
                    aVar.close();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.agq = true;
        this.agr = exc;
        if (this.kH) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        Iterator it = ((ArrayList) this.agi.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.uK();
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j4, long j5) {
        if (this.kH) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        int i4 = cVar == null ? -1 : cVar.agF;
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(this.aga.getTotal()));
        }
        if (this.agk) {
            if (j4 == 0 || j5 == this.aga.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(this.aga.getTotal()), Integer.valueOf(this.aga.getId()));
            return;
        }
        synchronized (this.agi) {
            this.agi.remove(cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.agk && code == 416 && !this.agf) {
                com.kwad.framework.filedownloader.f.f.B(this.aga.getTargetFilePath(), this.aga.vD());
                this.agf = true;
                return true;
            }
        }
        return this.agg > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j4) {
        if (this.kH) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        int i4 = this.agg;
        int i5 = i4 - 1;
        this.agg = i5;
        if (i4 < 0) {
            com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i5), Integer.valueOf(this.aga.getId()));
        }
        this.afY.a(exc, this.agg, j4);
    }
}
