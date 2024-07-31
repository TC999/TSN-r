package com.kwad.framework.filedownloader.download;

import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.framework.filedownloader.InterfaceC9583y;
import com.kwad.framework.filedownloader.download.C9476e;
import com.kwad.framework.filedownloader.download.RunnableC9472c;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9461a;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p352e.InterfaceC9480a;
import com.kwad.framework.filedownloader.p353f.C9490b;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9499e;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.sdk.crash.utils.C10747h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DownloadLaunchRunnable implements InterfaceC9478f, Runnable {
    private static final ThreadPoolExecutor agl = C9490b.m28552bq("ConnectionBlock");
    private final InterfaceC9440a afV;
    private final C9474d afY;
    private final int afZ;
    private final C9464c aga;
    private final C9462b agb;
    private final boolean agc;
    private final boolean agd;
    private final InterfaceC9583y age;
    private boolean agf;
    int agg;
    private final boolean agh;
    private final ArrayList<RunnableC9472c> agi;
    private C9476e agj;
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

    /* renamed from: kH */
    private volatile boolean f29478kH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9468a {
        private C9462b afH;
        private Boolean agA;
        private Integer agB;
        private C9464c aga;
        private InterfaceC9583y age;
        private Integer agx;
        private Integer agy;
        private Boolean agz;

        /* renamed from: a */
        public final C9468a m28646a(InterfaceC9583y interfaceC9583y) {
            this.age = interfaceC9583y;
            return this;
        }

        /* renamed from: b */
        public final C9468a m28643b(C9462b c9462b) {
            this.afH = c9462b;
            return this;
        }

        /* renamed from: c */
        public final C9468a m28640c(Integer num) {
            this.agB = num;
            return this;
        }

        /* renamed from: e */
        public final C9468a m28639e(C9464c c9464c) {
            this.aga = c9464c;
            return this;
        }

        /* renamed from: vE */
        public final DownloadLaunchRunnable m28638vE() {
            if (this.aga != null && this.age != null && this.agx != null && this.agy != null && this.agz != null && this.agA != null && this.agB != null) {
                return new DownloadLaunchRunnable(this.aga, this.afH, this.age, this.agx.intValue(), this.agy.intValue(), this.agz.booleanValue(), this.agA.booleanValue(), this.agB.intValue(), (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: a */
        public final C9468a m28644a(Integer num) {
            this.agx = num;
            return this;
        }

        /* renamed from: b */
        public final C9468a m28641b(Integer num) {
            this.agy = num;
            return this;
        }

        /* renamed from: a */
        public final C9468a m28645a(Boolean bool) {
            this.agz = bool;
            return this;
        }

        /* renamed from: b */
        public final C9468a m28642b(Boolean bool) {
            this.agA = bool;
            return this;
        }
    }

    /* synthetic */ DownloadLaunchRunnable(C9464c c9464c, C9462b c9462b, InterfaceC9583y interfaceC9583y, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(c9464c, c9462b, interfaceC9583y, i, i2, z, z2, i3);
    }

    /* renamed from: a */
    private void m28655a(Map<String, List<String>> map, ConnectTask connectTask, InterfaceC9432b interfaceC9432b) {
        int id = this.aga.getId();
        int responseCode = interfaceC9432b.getResponseCode();
        this.agn = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String m28682wm = this.aga.m28682wm();
        String m28525a = C9501f.m28525a(id, interfaceC9432b);
        if (responseCode == 412 || !(m28682wm == null || m28682wm.equals(m28525a) || (!z && !this.agn)) || ((responseCode == 201 && connectTask.m28667vk()) || (responseCode == 416 && this.aga.m28683wl() > 0))) {
            if (this.agm) {
                C9498d.m28534d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), m28682wm, m28525a, Integer.valueOf(responseCode));
            }
            this.afV.mo28778bm(this.aga.getId());
            C9501f.m28527B(this.aga.getTargetFilePath(), this.aga.m28685vD());
            this.agm = false;
            if (m28682wm != 0 && m28682wm.equals(m28525a)) {
                C9498d.m28534d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", m28682wm, m28525a, Integer.valueOf(responseCode), Integer.valueOf(id));
                m28525a = null;
            }
            this.aga.m28697S(0L);
            this.aga.m28695U(0L);
            this.aga.m28693bn(m28525a);
            this.aga.m28679wp();
            this.afV.mo28791a(id, this.aga.m28682wm(), this.aga.m28683wl(), this.aga.getTotal(), this.aga.m28680wo());
            throw new RetryDirectly();
        }
        this.ags = connectTask.m28666vl();
        if (!this.agn && !z) {
            throw new FileDownloadHttpException(responseCode, map, interfaceC9432b.mo24748vd());
        }
        long m28517b = C9501f.m28517b(id, interfaceC9432b);
        String m28522a = this.aga.m28688tR() ? C9501f.m28522a(interfaceC9432b, this.aga.getUrl()) : null;
        boolean z2 = m28517b == -1;
        this.ago = z2;
        this.afY.m28606a(this.agm && this.agn, !z2 ? this.aga.m28683wl() + m28517b : m28517b, m28525a, m28522a);
    }

    /* renamed from: b */
    private void m28654b(long j, int i) {
        long j2 = j / i;
        int id = this.aga.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
            C9461a c9461a = new C9461a();
            c9461a.setId(id);
            c9461a.setIndex(i2);
            c9461a.setStartOffset(j3);
            c9461a.m28712Q(j3);
            c9461a.m28711R(j4);
            arrayList.add(c9461a);
            this.afV.mo28784a(c9461a);
            j3 += j2;
            i2++;
        }
        this.aga.m28694bD(i);
        this.afV.mo28768s(id, i);
        m28653b(arrayList, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.framework.filedownloader.download.C9469a m28652q(java.util.List<com.kwad.framework.filedownloader.p351d.C9461a> r21) {
        /*
            r20 = this;
            r0 = r20
            com.kwad.framework.filedownloader.d.c r1 = r0.aga
            int r1 = r1.m28680wo()
            com.kwad.framework.filedownloader.d.c r2 = r0.aga
            java.lang.String r2 = r2.m28685vD()
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
            boolean r9 = com.kwad.framework.filedownloader.p353f.C9501f.m28516b(r9, r10)
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
            long r9 = com.kwad.framework.filedownloader.p351d.C9461a.m28709r(r21)
            goto L3e
        L4d:
            com.kwad.framework.filedownloader.d.c r1 = r0.aga
            long r9 = r1.m28683wl()
            goto L3e
        L54:
            r14 = r7
        L55:
            com.kwad.framework.filedownloader.d.c r1 = r0.aga
            r1.m28697S(r14)
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L5f
            r4 = 1
        L5f:
            r0.agm = r4
            if (r4 != 0) goto L71
            com.kwad.framework.filedownloader.b.a r1 = r0.afV
            com.kwad.framework.filedownloader.d.c r4 = r0.aga
            int r4 = r4.getId()
            r1.mo28778bm(r4)
            com.kwad.framework.filedownloader.p353f.C9501f.m28527B(r3, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.m28652q(java.util.List):com.kwad.framework.filedownloader.download.a");
    }

    /* renamed from: vB */
    private void m28651vB() {
        if (this.agd && !C9501f.m28503by(C7282g.f24944b)) {
            throw new FileDownloadGiveUpRetryException(C9501f.m28515b("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.aga.getId()), C7282g.f24944b));
        }
        if (this.agd && C9501f.m28496wS()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    /* renamed from: vC */
    private void m28650vC() {
        int id = this.aga.getId();
        if (this.aga.m28688tR()) {
            String targetFilePath = this.aga.getTargetFilePath();
            int m28528A = C9501f.m28528A(this.aga.getUrl(), targetFilePath);
            if (!C9492c.m28546a(id, targetFilePath, this.agc, false)) {
                C9464c mo28780bk = this.afV.mo28780bk(m28528A);
                if (mo28780bk != null) {
                    if (!C9492c.m28547a(id, mo28780bk, this.age, false)) {
                        List<C9461a> mo28779bl = this.afV.mo28779bl(m28528A);
                        this.afV.mo28777bn(m28528A);
                        this.afV.mo28778bm(m28528A);
                        C9501f.m28512bC(this.aga.getTargetFilePath());
                        if (C9501f.m28516b(m28528A, mo28780bk)) {
                            this.aga.m28697S(mo28780bk.m28683wl());
                            this.aga.m28695U(mo28780bk.getTotal());
                            this.aga.m28693bn(mo28780bk.m28682wm());
                            this.aga.m28694bD(mo28780bk.m28680wo());
                            this.afV.mo28782b(this.aga);
                            if (mo28779bl != null) {
                                for (C9461a c9461a : mo28779bl) {
                                    c9461a.setId(id);
                                    this.afV.mo28784a(c9461a);
                                }
                            }
                            throw new RetryDirectly();
                        }
                    } else {
                        this.afV.mo28777bn(id);
                        this.afV.mo28778bm(id);
                        throw new DiscardSafely();
                    }
                }
                if (C9492c.m28548a(id, this.aga.m28683wl(), this.aga.m28685vD(), targetFilePath, this.age)) {
                    this.afV.mo28777bn(id);
                    this.afV.mo28778bm(id);
                    throw new DiscardSafely();
                }
                return;
            }
            this.afV.mo28777bn(id);
            this.afV.mo28778bm(id);
            throw new DiscardSafely();
        }
    }

    /* renamed from: vz */
    private boolean m28647vz() {
        return (!this.agm || this.aga.m28680wo() > 1) && this.agn && this.agh && !this.ago;
    }

    public final int getId() {
        return this.aga.getId();
    }

    public final boolean isAlive() {
        return this.agp.get() || this.afY.isAlive();
    }

    @Override // com.kwad.framework.filedownloader.download.InterfaceC9478f
    public final void onProgress(long j) {
        if (this.f29478kH) {
            return;
        }
        this.afY.onProgress(j);
    }

    public final void pause() {
        this.f29478kH = true;
        C9476e c9476e = this.agj;
        if (c9476e != null) {
            c9476e.pause();
        }
        Iterator it = ((ArrayList) this.agi.clone()).iterator();
        while (it.hasNext()) {
            RunnableC9472c runnableC9472c = (RunnableC9472c) it.next();
            if (runnableC9472c != null) {
                runnableC9472c.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
        if (r9 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e9, code lost:
        r9.mo24747ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ff, code lost:
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.p353f.C9501f.m28515b("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        if (com.kwad.framework.filedownloader.p353f.C9498d.ail == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        com.kwad.framework.filedownloader.p353f.C9498d.m28535c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.aga.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
        r19.afY.m28598vG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (r19.f29478kH == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
        if (r19.agq == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
        r19.afY.m28593vL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
        if (r19.f29478kH == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
        r19.aga.m28690d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
        if (r9 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
        r9.mo24747ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
        r19.afY.m28598vG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
        if (r19.f29478kH == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
        if (r19.agq == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
        r19.afY.m28593vL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
        m28650vC();
        r14 = r19.aga.getTotal();
        m28657a(r14, r19.aga.m28685vD());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
        if (m28647vz() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
        if (r19.agm == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
        r10 = r19.aga.m28680wo();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
        r17 = r14;
        r10 = com.kwad.framework.filedownloader.download.C9470b.m28631vo().m28637a(r19.aga.getId(), r19.aga.getUrl(), r19.aga.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:
        if (r10 <= 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
        if (r19.f29478kH == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
        r19.aga.m28690d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
        if (r9 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
        r9.mo24747ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
        r19.afY.m28598vG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
        if (r19.f29478kH == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
        if (r19.agq == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
        r19.afY.m28593vL();
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
        m28656a(r8.m28665vm(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cd, code lost:
        if (r9 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cf, code lost:
        r9.mo24747ve();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
        r19.afY.m28595vJ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01db, code lost:
        if (r19.agm == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dd, code lost:
        m28658a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e1, code lost:
        m28654b(r17, r10);
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

    @Override // com.kwad.framework.filedownloader.download.InterfaceC9478f
    /* renamed from: vA */
    public final void mo28569vA() {
        this.afV.mo28783b(this.aga.getId(), this.aga.m28683wl());
    }

    /* renamed from: vD */
    public final String m28649vD() {
        return this.aga.m28685vD();
    }

    /* renamed from: vy */
    public final void m28648vy() {
        if (this.aga.m28680wo() > 1) {
            List<C9461a> mo28779bl = this.afV.mo28779bl(this.aga.getId());
            if (this.aga.m28680wo() == mo28779bl.size()) {
                this.aga.m28697S(C9461a.m28709r(mo28779bl));
            } else {
                this.aga.m28697S(0L);
                this.afV.mo28778bm(this.aga.getId());
            }
        }
        this.afY.m28597vH();
    }

    private DownloadLaunchRunnable(C9464c c9464c, C9462b c9462b, InterfaceC9583y interfaceC9583y, int i, int i2, boolean z, boolean z2, int i3) {
        this.afZ = 5;
        this.agi = new ArrayList<>(5);
        this.agt = 0L;
        this.agu = 0L;
        this.agv = 0L;
        this.agw = 0L;
        this.agp = new AtomicBoolean(true);
        this.f29478kH = false;
        this.agf = false;
        this.aga = c9464c;
        this.agb = c9462b;
        this.agc = z;
        this.agd = z2;
        this.afV = C9470b.m28631vo().m28629vq();
        this.agh = C9470b.m28631vo().m28627vs();
        this.age = interfaceC9583y;
        this.agg = i3;
        this.afY = new C9474d(c9464c, i3, i, i2);
    }

    /* renamed from: b */
    private void m28653b(List<C9461a> list, long j) {
        long m28704wi;
        int id = this.aga.getId();
        String m28682wm = this.aga.m28682wm();
        String str = this.ags;
        if (str == null) {
            str = this.aga.getUrl();
        }
        String m28685vD = this.aga.m28685vD();
        if (C9498d.ail) {
            C9498d.m28535c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.agm;
        long j2 = 0;
        long j3 = 0;
        for (C9461a c9461a : list) {
            if (c9461a.m28704wi() == j2) {
                m28704wi = j - c9461a.m28705wh();
            } else {
                m28704wi = (c9461a.m28704wi() - c9461a.m28705wh()) + 1;
            }
            long j4 = m28704wi;
            j3 += c9461a.m28705wh() - c9461a.getStartOffset();
            if (j4 == j2) {
                if (C9498d.ail) {
                    C9498d.m28535c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(c9461a.getId()), Integer.valueOf(c9461a.getIndex()));
                }
            } else {
                RunnableC9472c m28611vF = new RunnableC9472c.C9473a().m28614bt(id).m28612d(Integer.valueOf(c9461a.getIndex())).m28620a(this).m28617bi(str).m28616bj(z ? m28682wm : null).m28613c(this.agb).m28618bd(this.agd).m28619b(new C9469a(c9461a.getStartOffset(), c9461a.m28705wh(), c9461a.m28704wi(), j4)).m28615bk(m28685vD).m28611vF();
                if (C9498d.ail) {
                    C9498d.m28535c(this, "enable multiple connection: %s", c9461a);
                }
                this.agi.add(m28611vF);
            }
            j2 = 0;
        }
        if (j3 != this.aga.m28683wl()) {
            C9498d.m28534d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.aga.m28683wl()), Long.valueOf(j3));
            this.aga.m28697S(j3);
        }
        ArrayList arrayList = new ArrayList(this.agi.size());
        Iterator<RunnableC9472c> it = this.agi.iterator();
        while (it.hasNext()) {
            RunnableC9472c next = it.next();
            if (this.f29478kH) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.f29478kH) {
            this.aga.m28690d((byte) -2);
            return;
        }
        List<Future> invokeAll = agl.invokeAll(arrayList);
        if (C9498d.ail) {
            for (Future future : invokeAll) {
                C9498d.m28535c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    /* renamed from: a */
    private void m28656a(C9469a c9469a, InterfaceC9432b interfaceC9432b) {
        if (!this.agn) {
            this.aga.m28697S(0L);
            c9469a = new C9469a(0L, 0L, c9469a.afQ, c9469a.contentLength);
        }
        C9476e.C9477a c9477a = new C9476e.C9477a();
        c9477a.m28581b(this).m28577bw(this.aga.getId()).m28578bv(-1).m28580bf(this.agd).m28575d(interfaceC9432b).m28576c(c9469a).m28579bl(this.aga.m28685vD());
        this.aga.m28694bD(1);
        this.afV.mo28768s(this.aga.getId(), 1);
        this.agj = c9477a.m28574vS();
        if (this.f29478kH) {
            this.aga.m28690d((byte) -2);
            this.agj.pause();
            return;
        }
        this.agj.run();
    }

    /* renamed from: a */
    private void m28658a(int i, List<C9461a> list) {
        if (i > 1 && list.size() == i) {
            m28653b(list, this.aga.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private void m28657a(long j, String str) {
        InterfaceC9480a interfaceC9480a = null;
        if (j != -1) {
            try {
                interfaceC9480a = C9501f.m28514bA(this.aga.m28685vD());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = C10747h.getAvailableBytes(str);
                if (availableBytes >= j2) {
                    if (!C9499e.m28530wN().air) {
                        interfaceC9480a.setLength(j);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
            } finally {
                if (0 != 0) {
                    interfaceC9480a.close();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.InterfaceC9478f
    /* renamed from: b */
    public final void mo28570b(Exception exc) {
        this.agq = true;
        this.agr = exc;
        if (this.f29478kH) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        Iterator it = ((ArrayList) this.agi.clone()).iterator();
        while (it.hasNext()) {
            RunnableC9472c runnableC9472c = (RunnableC9472c) it.next();
            if (runnableC9472c != null) {
                runnableC9472c.m28621uK();
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.InterfaceC9478f
    /* renamed from: a */
    public final void mo28573a(RunnableC9472c runnableC9472c, long j, long j2) {
        if (this.f29478kH) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        int i = runnableC9472c == null ? -1 : runnableC9472c.agF;
        if (C9498d.ail) {
            C9498d.m28535c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.aga.getTotal()));
        }
        if (this.agk) {
            if (j == 0 || j2 == this.aga.getTotal()) {
                return;
            }
            C9498d.m28538a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.aga.getTotal()), Integer.valueOf(this.aga.getId()));
            return;
        }
        synchronized (this.agi) {
            this.agi.remove(runnableC9472c);
        }
    }

    @Override // com.kwad.framework.filedownloader.download.InterfaceC9478f
    /* renamed from: a */
    public final boolean mo28572a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.agk && code == 416 && !this.agf) {
                C9501f.m28527B(this.aga.getTargetFilePath(), this.aga.m28685vD());
                this.agf = true;
                return true;
            }
        }
        return this.agg > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.InterfaceC9478f
    /* renamed from: a */
    public final void mo28571a(Exception exc, long j) {
        if (this.f29478kH) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        int i = this.agg;
        int i2 = i - 1;
        this.agg = i2;
        if (i < 0) {
            C9498d.m28538a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.aga.getId()));
        }
        this.afY.m28607a(exc, this.agg, j);
    }
}
