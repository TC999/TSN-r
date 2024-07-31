package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p352e.InterfaceC9480a;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.io.IOException;

/* renamed from: com.kwad.framework.filedownloader.download.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9476e {

    /* renamed from: VM */
    private final String f29482VM;
    private final int afG;
    private final long afO;
    long afP;
    private final long afQ;
    private final InterfaceC9440a afV;
    private final InterfaceC9478f agD;
    private final int agF;
    private final RunnableC9472c agV;
    private final InterfaceC9432b agW;
    private InterfaceC9480a agX;
    private volatile long agY;
    private volatile long agZ;
    private final boolean agd;
    private final long contentLength;

    /* renamed from: kH */
    private volatile boolean f29483kH;

    /* renamed from: com.kwad.framework.filedownloader.download.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9477a {

        /* renamed from: VM */
        String f29484VM;
        Integer afM;
        C9469a afN;
        Boolean agA;
        InterfaceC9478f agD;
        Integer agH;
        InterfaceC9432b agW;
        RunnableC9472c aha;

        /* renamed from: a */
        public final C9477a m28582a(RunnableC9472c runnableC9472c) {
            this.aha = runnableC9472c;
            return this;
        }

        /* renamed from: b */
        public final C9477a m28581b(InterfaceC9478f interfaceC9478f) {
            this.agD = interfaceC9478f;
            return this;
        }

        /* renamed from: bf */
        public final C9477a m28580bf(boolean z) {
            this.agA = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: bl */
        public final C9477a m28579bl(String str) {
            this.f29484VM = str;
            return this;
        }

        /* renamed from: bv */
        public final C9477a m28578bv(int i) {
            this.agH = Integer.valueOf(i);
            return this;
        }

        /* renamed from: bw */
        public final C9477a m28577bw(int i) {
            this.afM = Integer.valueOf(i);
            return this;
        }

        /* renamed from: c */
        public final C9477a m28576c(C9469a c9469a) {
            this.afN = c9469a;
            return this;
        }

        /* renamed from: d */
        public final C9477a m28575d(InterfaceC9432b interfaceC9432b) {
            this.agW = interfaceC9432b;
            return this;
        }

        /* renamed from: vS */
        public final C9476e m28574vS() {
            InterfaceC9432b interfaceC9432b;
            C9469a c9469a;
            Integer num;
            if (this.agA != null && (interfaceC9432b = this.agW) != null && (c9469a = this.afN) != null && this.agD != null && this.f29484VM != null && (num = this.afM) != null && this.agH != null) {
                return new C9476e(interfaceC9432b, c9469a, this.aha, num.intValue(), this.agH.intValue(), this.agA.booleanValue(), this.agD, this.f29484VM, (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    /* synthetic */ C9476e(InterfaceC9432b interfaceC9432b, C9469a c9469a, RunnableC9472c runnableC9472c, int i, int i2, boolean z, InterfaceC9478f interfaceC9478f, String str, byte b) {
        this(interfaceC9432b, c9469a, runnableC9472c, i, i2, z, interfaceC9478f, str);
    }

    private void sync() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.agX.mo28567wI();
            z = true;
        } catch (IOException e) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.agV != null) {
                this.afV.mo28795a(this.afG, this.agF, this.afP);
            } else {
                this.agD.mo28569vA();
            }
            if (C9498d.ail) {
                C9498d.m28535c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.afG), Integer.valueOf(this.agF), Long.valueOf(this.afP), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    /* renamed from: vR */
    private void m28583vR() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C9501f.m28500i(this.afP - this.agY, elapsedRealtime - this.agZ)) {
            sync();
            this.agY = this.afP;
            this.agZ = elapsedRealtime;
        }
    }

    public final void pause() {
        this.f29483kH = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
        if (r13 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0120, code lost:
        com.kwad.sdk.crash.utils.C10738b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.C10738b.closeQuietly(r13);
        r6 = r16.afP - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012d, code lost:
        if (r2 == (-1)) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0131, code lost:
        if (r2 != r6) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0170, code lost:
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.p353f.C9501f.m28515b("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.afO), java.lang.Long.valueOf(r16.afQ), java.lang.Long.valueOf(r16.afP), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0171, code lost:
        r16.agD.mo28573a(r16.agV, r16.afO, r16.afQ);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.C9476e.run():void");
    }

    private C9476e(InterfaceC9432b interfaceC9432b, C9469a c9469a, RunnableC9472c runnableC9472c, int i, int i2, boolean z, InterfaceC9478f interfaceC9478f, String str) {
        this.agY = 0L;
        this.agZ = 0L;
        this.agD = interfaceC9478f;
        this.f29482VM = str;
        this.agW = interfaceC9432b;
        this.agd = z;
        this.agV = runnableC9472c;
        this.agF = i2;
        this.afG = i;
        this.afV = C9470b.m28631vo().m28629vq();
        this.afO = c9469a.afO;
        this.afQ = c9469a.afQ;
        this.afP = c9469a.afP;
        this.contentLength = c9469a.contentLength;
    }
}
