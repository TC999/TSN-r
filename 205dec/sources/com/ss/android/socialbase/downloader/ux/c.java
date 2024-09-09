package com.ss.android.socialbase.downloader.ux;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.fp;
import com.ss.android.socialbase.downloader.gd.f;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements w {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f50173a;
    private volatile boolean bk;

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f50174c;
    private com.ss.android.socialbase.downloader.f.c ev;

    /* renamed from: f  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.c f50175f;
    private int fp;
    private com.ss.android.socialbase.downloader.f.c gd;

    /* renamed from: k  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.c f50176k;

    /* renamed from: p  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.c f50177p;

    /* renamed from: r  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.c f50178r;

    /* renamed from: t  reason: collision with root package name */
    private volatile Throwable f50179t;

    /* renamed from: w  reason: collision with root package name */
    private final int f50180w;
    private final int xv;
    private volatile Future ys;
    private final Object sr = new Object();
    private final Object ux = new Object();
    private final Runnable ia = new Runnable() { // from class: com.ss.android.socialbase.downloader.ux.c.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.c sr;
            Process.setThreadPriority(10);
            do {
                try {
                    sr = c.this.sr();
                    sr.xv = c.this.f50174c.read(sr.f49599c);
                    c.this.xv(sr);
                } catch (Throwable th) {
                    try {
                        c.this.f50179t = th;
                        th.printStackTrace();
                        synchronized (c.this.ux) {
                            c.this.bk = true;
                            c.this.ux.notify();
                            f.c(c.this.f50174c);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (c.this.ux) {
                            c.this.bk = true;
                            c.this.ux.notify();
                            f.c(c.this.f50174c);
                            throw th2;
                        }
                    }
                }
            } while (sr.xv != -1);
            synchronized (c.this.ux) {
                c.this.bk = true;
                c.this.ux.notify();
            }
            f.c(c.this.f50174c);
        }
    };

    public c(InputStream inputStream, int i4, int i5) throws Throwable {
        this.f50174c = inputStream;
        this.f50180w = i4;
        if (i5 < 1) {
            i5 = 1;
        } else if (i5 > 64) {
            i5 = 64;
        }
        this.xv = i5;
        xv();
    }

    private void f() throws BaseException {
        Throwable th = this.f50179t;
        if (th != null) {
            if (th instanceof fp) {
                throw new BaseException(1068, "async reader closed!");
            }
            f.c(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.c sr() throws fp, InterruptedException {
        int i4;
        com.ss.android.socialbase.downloader.f.c cVar = this.ev;
        if (cVar != null) {
            if (!this.f50173a) {
                this.ev = cVar.sr;
                cVar.sr = null;
                return cVar;
            }
            throw new fp("");
        }
        synchronized (this.sr) {
            if (!this.f50173a) {
                com.ss.android.socialbase.downloader.f.c cVar2 = this.f50175f;
                if (cVar2 == null && (i4 = this.fp) < this.xv) {
                    this.fp = i4 + 1;
                    return new com.ss.android.socialbase.downloader.f.c(this.f50180w);
                }
                while (cVar2 == null) {
                    this.sr.wait();
                    if (!this.f50173a) {
                        cVar2 = this.f50175f;
                    } else {
                        throw new fp("");
                    }
                }
                this.ev = cVar2.sr;
                this.f50178r = null;
                this.f50175f = null;
                cVar2.sr = null;
                return cVar2;
            }
            throw new fp("");
        }
    }

    private com.ss.android.socialbase.downloader.f.c ux() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.c cVar;
        com.ss.android.socialbase.downloader.f.c cVar2 = this.f50176k;
        if (cVar2 != null) {
            this.f50176k = cVar2.sr;
            cVar2.sr = null;
            return cVar2;
        }
        synchronized (this.ux) {
            cVar = this.gd;
            if (cVar == null) {
                do {
                    if (this.bk) {
                        f();
                    }
                    this.ux.wait();
                    cVar = this.gd;
                } while (cVar == null);
                this.f50176k = cVar.sr;
                this.f50177p = null;
                this.gd = null;
                cVar.sr = null;
            } else {
                this.f50176k = cVar.sr;
                this.f50177p = null;
                this.gd = null;
                cVar.sr = null;
            }
        }
        return cVar;
    }

    private void xv() throws Throwable {
        this.ys = com.ss.android.socialbase.downloader.downloader.xv.ia().submit(this.ia);
    }

    @Override // com.ss.android.socialbase.downloader.ux.w
    public void w() {
        synchronized (this.sr) {
            this.f50173a = true;
            this.sr.notify();
        }
        Future future = this.ys;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.ys = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(com.ss.android.socialbase.downloader.f.c cVar) {
        synchronized (this.ux) {
            com.ss.android.socialbase.downloader.f.c cVar2 = this.f50177p;
            if (cVar2 == null) {
                this.f50177p = cVar;
                this.gd = cVar;
                this.ux.notify();
            } else {
                cVar2.sr = cVar;
                this.f50177p = cVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.ux.w
    public com.ss.android.socialbase.downloader.f.c c() throws BaseException, InterruptedException {
        return ux();
    }

    @Override // com.ss.android.socialbase.downloader.ux.w
    public void c(com.ss.android.socialbase.downloader.f.c cVar) {
        w(cVar);
    }

    private void w(com.ss.android.socialbase.downloader.f.c cVar) {
        synchronized (this.sr) {
            com.ss.android.socialbase.downloader.f.c cVar2 = this.f50178r;
            if (cVar2 == null) {
                this.f50178r = cVar;
                this.f50175f = cVar;
                this.sr.notify();
            } else {
                cVar2.sr = cVar;
                this.f50178r = cVar;
            }
        }
    }
}
