package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.message.C9532e;
import com.kwad.framework.filedownloader.message.C9535f;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9499e;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.framework.filedownloader.services.C9572f;
import com.kwad.sdk.crash.utils.C10747h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* renamed from: com.kwad.framework.filedownloader.download.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9474d implements Handler.Callback {
    private volatile Thread afv;
    private final C9475a agI;
    private final int agJ;
    private final int agK;
    private final int agL;
    private long agM;
    private HandlerThread agN;
    private volatile boolean agQ;
    private final C9464c aga;
    private Handler handler;
    private volatile boolean agO = false;
    private volatile long agu = 0;
    private final AtomicLong agP = new AtomicLong();
    private boolean agR = true;
    private final InterfaceC9440a afV = C9470b.m28631vo().m28629vq();

    /* renamed from: com.kwad.framework.filedownloader.download.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9475a {
        private boolean agS;
        private Exception agT;
        private int agU;

        /* renamed from: be */
        final void m28588be(boolean z) {
            this.agS = z;
        }

        /* renamed from: bu */
        final void m28587bu(int i) {
            this.agU = i;
        }

        /* renamed from: f */
        final void m28586f(Exception exc) {
            this.agT = exc;
        }

        public final Exception getException() {
            return this.agT;
        }

        /* renamed from: tZ */
        public final int m28585tZ() {
            return this.agU;
        }

        /* renamed from: vQ */
        public final boolean m28584vQ() {
            return this.agS;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9474d(C9464c c9464c, int i, int i2, int i3) {
        this.aga = c9464c;
        this.agK = i2 < 5 ? 5 : i2;
        this.agL = i3;
        this.agI = new C9475a();
        this.agJ = i;
    }

    /* renamed from: P */
    private boolean m28610P(long j) {
        if (!this.agR) {
            return this.agM != -1 && this.agP.get() >= this.agM && j - this.agu >= ((long) this.agK);
        }
        this.agR = false;
        return true;
    }

    /* renamed from: b */
    private synchronized void m28604b(Message message) {
        if (!this.agN.isAlive()) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (!this.agN.isAlive()) {
                if (C9498d.ail) {
                    C9498d.m28535c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    return;
                }
                return;
            }
            throw e;
        }
    }

    /* renamed from: d */
    private Exception m28601d(Exception exc) {
        long length;
        String m28685vD = this.aga.m28685vD();
        if ((this.aga.isChunked() || C9499e.m28530wN().air) && (exc instanceof IOException) && new File(m28685vD).exists()) {
            long availableBytes = C10747h.getAvailableBytes(m28685vD);
            if (availableBytes <= 4096) {
                File file = new File(m28685vD);
                if (!file.exists()) {
                    C9498d.m28537a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    length = 0;
                } else {
                    length = file.length();
                }
                return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
            }
            return exc;
        }
        return exc;
    }

    /* renamed from: e */
    private void m28600e(Exception exc) {
        Exception exc2;
        Exception m28601d = m28601d(exc);
        if (m28601d instanceof SQLiteFullException) {
            m28609a((SQLiteFullException) m28601d);
            exc2 = m28601d;
        } else {
            try {
                this.aga.m28690d((byte) -1);
                this.aga.m28692bo(exc.toString());
                this.afV.mo28789a(this.aga.getId(), m28601d, this.aga.m28683wl());
                exc2 = m28601d;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException = e;
                m28609a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.agI.m28586f(exc2);
        m28603c((byte) -1);
    }

    /* renamed from: h */
    private static long m28599h(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    /* renamed from: vM */
    private void m28592vM() {
        String m28685vD = this.aga.m28685vD();
        String targetFilePath = this.aga.getTargetFilePath();
        File file = new File(m28685vD);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    C9498d.m28534d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(C9501f.m28515b("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
            }
            if (file.renameTo(file2)) {
                if (!file.exists() || file.delete()) {
                    return;
                }
                C9498d.m28534d(this, "delete the temp file(%s) failed, on completed downloading.", m28685vD);
                return;
            }
            throw new IOException(C9501f.m28515b("Can't rename the  temp downloaded file(%s) to the target file(%s)", m28685vD, targetFilePath));
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                C9498d.m28534d(this, "delete the temp file(%s) failed, on completed downloading.", m28685vD);
            }
            throw th;
        }
    }

    /* renamed from: vN */
    private void m28591vN() {
        m28592vM();
        this.aga.m28690d((byte) -3);
        this.afV.mo28775c(this.aga.getId(), this.aga.getTotal());
        this.afV.mo28778bm(this.aga.getId());
        m28603c((byte) -3);
        if (C9499e.m28530wN().ais) {
            C9572f.m28376f(this.aga);
        }
    }

    /* renamed from: vO */
    private boolean m28590vO() {
        if (this.aga.isChunked()) {
            C9464c c9464c = this.aga;
            c9464c.m28695U(c9464c.m28683wl());
        } else if (this.aga.m28683wl() != this.aga.getTotal()) {
            m28602c(new FileDownloadGiveUpRetryException(C9501f.m28515b("sofar[%d] not equal total[%d]", Long.valueOf(this.aga.m28683wl()), Long.valueOf(this.aga.getTotal()))));
            return true;
        }
        return false;
    }

    /* renamed from: vP */
    private void m28589vP() {
        this.aga.m28690d((byte) -2);
        this.afV.mo28774d(this.aga.getId(), this.aga.m28683wl());
        m28603c((byte) -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m28606a(boolean z, long j, String str, String str2) {
        String m28682wm = this.aga.m28682wm();
        if (m28682wm != null && !m28682wm.equals(str)) {
            throw new IllegalArgumentException(C9501f.m28515b("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, m28682wm));
        }
        this.agI.m28588be(z);
        this.aga.m28690d((byte) 2);
        this.aga.m28695U(j);
        this.aga.m28693bn(str);
        this.aga.m28691bp(str2);
        this.afV.mo28794a(this.aga.getId(), j, str, str2);
        m28603c((byte) 2);
        this.agM = m28599h(j, this.agL);
        this.agQ = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m28602c(Exception exc) {
        m28600e(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.agO = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L17
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1e
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L2a
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L2a
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L2a
            r4.m28608a(r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L1e
        L17:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L2a
            r4.m28605b(r1, r0)     // Catch: java.lang.Throwable -> L2a
        L1e:
            r4.agO = r3
            java.lang.Thread r5 = r4.afv
            if (r5 == 0) goto L29
            java.lang.Thread r5 = r4.afv
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L29:
            return r0
        L2a:
            r5 = move-exception
            r4.agO = r3
            java.lang.Thread r0 = r4.afv
            if (r0 == 0) goto L36
            java.lang.Thread r0 = r4.afv
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L36:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.C9474d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.agN;
        return handlerThread != null && handlerThread.isAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onProgress(long j) {
        this.agP.addAndGet(j);
        this.aga.m28696T(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean m28610P = m28610P(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            m28605b(elapsedRealtime, m28610P);
        } else if (m28610P) {
            m28604b(handler.obtainMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vG */
    public final void m28598vG() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.agN.quit();
            this.afv = Thread.currentThread();
            while (this.agO) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.afv = null;
        }
    }

    /* renamed from: vH */
    public final void m28597vH() {
        this.aga.m28690d((byte) 1);
        this.afV.mo28776bo(this.aga.getId());
        m28603c((byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vI */
    public final void m28596vI() {
        this.aga.m28690d((byte) 6);
        m28603c((byte) 6);
        this.afV.mo28781bj(this.aga.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vJ */
    public final void m28595vJ() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.agN = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.agN.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vK */
    public final void m28594vK() {
        m28589vP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vL */
    public final void m28593vL() {
        if (m28590vO()) {
            return;
        }
        m28591vN();
    }

    /* renamed from: c */
    private void m28603c(byte b) {
        if (b == -2) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        C9532e.m28463wf().m28464s(C9535f.m28461a(b, this.aga, this.agI));
    }

    /* renamed from: b */
    private void m28605b(long j, boolean z) {
        if (this.aga.m28683wl() == this.aga.getTotal()) {
            this.afV.mo28783b(this.aga.getId(), this.aga.m28683wl());
            return;
        }
        if (this.agQ) {
            this.agQ = false;
            this.aga.m28690d((byte) 3);
        }
        if (z) {
            this.agu = j;
            m28603c((byte) 3);
            this.agP.set(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m28607a(Exception exc, int i, long j) {
        this.agP.set(0L);
        this.aga.m28696T(-j);
        Handler handler = this.handler;
        if (handler == null) {
            m28608a(exc, i);
        } else {
            m28604b(handler.obtainMessage(5, i, 0, exc));
        }
    }

    /* renamed from: a */
    private void m28609a(SQLiteFullException sQLiteFullException) {
        int id = this.aga.getId();
        if (C9498d.ail) {
            C9498d.m28535c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.aga.m28692bo(sQLiteFullException.toString());
        this.aga.m28690d((byte) -1);
        this.afV.mo28777bn(id);
        this.afV.mo28778bm(id);
    }

    /* renamed from: a */
    private void m28608a(Exception exc, int i) {
        Exception m28601d = m28601d(exc);
        this.agI.m28586f(m28601d);
        this.agI.m28587bu(this.agJ - i);
        this.aga.m28690d((byte) 5);
        this.aga.m28692bo(m28601d.toString());
        this.afV.mo28790a(this.aga.getId(), m28601d);
        m28603c((byte) 5);
    }
}
