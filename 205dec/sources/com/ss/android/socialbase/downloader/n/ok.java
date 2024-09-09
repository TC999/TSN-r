package com.ss.android.socialbase.downloader.n;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.kf.i;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int f49991a;
    private final int bl;

    /* renamed from: h  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f49992h;

    /* renamed from: i  reason: collision with root package name */
    private int f49993i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f49994j;

    /* renamed from: k  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f49995k;
    private com.ss.android.socialbase.downloader.kf.ok kf;
    private final InputStream ok;

    /* renamed from: p  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f49997p;

    /* renamed from: q  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f49998q;

    /* renamed from: r  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f49999r;
    private volatile Throwable rh;

    /* renamed from: t  reason: collision with root package name */
    private volatile Future f50001t;

    /* renamed from: z  reason: collision with root package name */
    private volatile boolean f50003z;

    /* renamed from: s  reason: collision with root package name */
    private final Object f50000s = new Object();

    /* renamed from: n  reason: collision with root package name */
    private final Object f49996n = new Object();

    /* renamed from: x  reason: collision with root package name */
    private final Runnable f50002x = new Runnable() { // from class: com.ss.android.socialbase.downloader.n.ok.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.kf.ok s3;
            Process.setThreadPriority(10);
            do {
                try {
                    s3 = ok.this.s();
                    s3.bl = ok.this.ok.read(s3.ok);
                    ok.this.bl(s3);
                } catch (Throwable th) {
                    try {
                        ok.this.rh = th;
                        th.printStackTrace();
                        synchronized (ok.this.f49996n) {
                            ok.this.f50003z = true;
                            ok.this.f49996n.notify();
                            kf.ok(ok.this.ok);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (ok.this.f49996n) {
                            ok.this.f50003z = true;
                            ok.this.f49996n.notify();
                            kf.ok(ok.this.ok);
                            throw th2;
                        }
                    }
                }
            } while (s3.bl != -1);
            synchronized (ok.this.f49996n) {
                ok.this.f50003z = true;
                ok.this.f49996n.notify();
            }
            kf.ok(ok.this.ok);
        }
    };

    public ok(InputStream inputStream, int i4, int i5) throws Throwable {
        this.ok = inputStream;
        this.f49991a = i4;
        if (i5 < 1) {
            i5 = 1;
        } else if (i5 > 64) {
            i5 = 64;
        }
        this.bl = i5;
        bl();
    }

    private void kf() throws BaseException {
        Throwable th = this.rh;
        if (th != null) {
            if (th instanceof i) {
                throw new BaseException(1068, "async reader closed!");
            }
            kf.ok(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private com.ss.android.socialbase.downloader.kf.ok n() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.kf.ok okVar;
        com.ss.android.socialbase.downloader.kf.ok okVar2 = this.f49999r;
        if (okVar2 != null) {
            this.f49999r = okVar2.f49850s;
            okVar2.f49850s = null;
            return okVar2;
        }
        synchronized (this.f49996n) {
            okVar = this.f49998q;
            if (okVar == null) {
                do {
                    if (this.f50003z) {
                        kf();
                    }
                    this.f49996n.wait();
                    okVar = this.f49998q;
                } while (okVar == null);
                this.f49999r = okVar.f49850s;
                this.f49995k = null;
                this.f49998q = null;
                okVar.f49850s = null;
            } else {
                this.f49999r = okVar.f49850s;
                this.f49995k = null;
                this.f49998q = null;
                okVar.f49850s = null;
            }
        }
        return okVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.kf.ok s() throws i, InterruptedException {
        int i4;
        com.ss.android.socialbase.downloader.kf.ok okVar = this.f49997p;
        if (okVar != null) {
            if (!this.f49994j) {
                this.f49997p = okVar.f49850s;
                okVar.f49850s = null;
                return okVar;
            }
            throw new i("");
        }
        synchronized (this.f50000s) {
            if (!this.f49994j) {
                com.ss.android.socialbase.downloader.kf.ok okVar2 = this.kf;
                if (okVar2 == null && (i4 = this.f49993i) < this.bl) {
                    this.f49993i = i4 + 1;
                    return new com.ss.android.socialbase.downloader.kf.ok(this.f49991a);
                }
                while (okVar2 == null) {
                    this.f50000s.wait();
                    if (!this.f49994j) {
                        okVar2 = this.kf;
                    } else {
                        throw new i("");
                    }
                }
                this.f49997p = okVar2.f49850s;
                this.f49992h = null;
                this.kf = null;
                okVar2.f49850s = null;
                return okVar2;
            }
            throw new i("");
        }
    }

    private void bl() throws Throwable {
        this.f50001t = com.ss.android.socialbase.downloader.downloader.bl.x().submit(this.f50002x);
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void a() {
        synchronized (this.f50000s) {
            this.f49994j = true;
            this.f50000s.notify();
        }
        Future future = this.f50001t;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.f50001t = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(com.ss.android.socialbase.downloader.kf.ok okVar) {
        synchronized (this.f49996n) {
            com.ss.android.socialbase.downloader.kf.ok okVar2 = this.f49995k;
            if (okVar2 == null) {
                this.f49995k = okVar;
                this.f49998q = okVar;
                this.f49996n.notify();
            } else {
                okVar2.f49850s = okVar;
                this.f49995k = okVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public com.ss.android.socialbase.downloader.kf.ok ok() throws BaseException, InterruptedException {
        return n();
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void ok(com.ss.android.socialbase.downloader.kf.ok okVar) {
        a(okVar);
    }

    private void a(com.ss.android.socialbase.downloader.kf.ok okVar) {
        synchronized (this.f50000s) {
            com.ss.android.socialbase.downloader.kf.ok okVar2 = this.f49992h;
            if (okVar2 == null) {
                this.f49992h = okVar;
                this.kf = okVar;
                this.f50000s.notify();
            } else {
                okVar2.f49850s = okVar;
                this.f49992h = okVar;
            }
        }
    }
}
