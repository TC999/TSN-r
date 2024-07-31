package com.p521ss.android.socialbase.downloader.p552n;

import android.os.Process;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.p551kf.C12577i;
import com.p521ss.android.socialbase.downloader.p551kf.C12582ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.InputStream;
import java.util.concurrent.Future;

/* renamed from: com.ss.android.socialbase.downloader.n.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12610ok implements InterfaceC12608a {

    /* renamed from: a */
    private final int f35530a;

    /* renamed from: bl */
    private final int f35531bl;

    /* renamed from: h */
    private C12582ok f35532h;

    /* renamed from: i */
    private int f35533i;

    /* renamed from: j */
    private volatile boolean f35534j;

    /* renamed from: k */
    private C12582ok f35535k;

    /* renamed from: kf */
    private C12582ok f35536kf;

    /* renamed from: ok */
    private final InputStream f35538ok;

    /* renamed from: p */
    private C12582ok f35539p;

    /* renamed from: q */
    private C12582ok f35540q;

    /* renamed from: r */
    private C12582ok f35541r;

    /* renamed from: rh */
    private volatile Throwable f35542rh;

    /* renamed from: t */
    private volatile Future f35544t;

    /* renamed from: z */
    private volatile boolean f35546z;

    /* renamed from: s */
    private final Object f35543s = new Object();

    /* renamed from: n */
    private final Object f35537n = new Object();

    /* renamed from: x */
    private final Runnable f35545x = new Runnable() { // from class: com.ss.android.socialbase.downloader.n.ok.1
        @Override // java.lang.Runnable
        public void run() {
            C12582ok m16963s;
            Process.setThreadPriority(10);
            do {
                try {
                    m16963s = C12610ok.this.m16963s();
                    m16963s.f35342bl = C12610ok.this.f35538ok.read(m16963s.f35343ok);
                    C12610ok.this.m16973bl(m16963s);
                } catch (Throwable th) {
                    try {
                        C12610ok.this.f35542rh = th;
                        th.printStackTrace();
                        synchronized (C12610ok.this.f35537n) {
                            C12610ok.this.f35546z = true;
                            C12610ok.this.f35537n.notify();
                            C12713kf.m16531ok(C12610ok.this.f35538ok);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (C12610ok.this.f35537n) {
                            C12610ok.this.f35546z = true;
                            C12610ok.this.f35537n.notify();
                            C12713kf.m16531ok(C12610ok.this.f35538ok);
                            throw th2;
                        }
                    }
                }
            } while (m16963s.f35342bl != -1);
            synchronized (C12610ok.this.f35537n) {
                C12610ok.this.f35546z = true;
                C12610ok.this.f35537n.notify();
            }
            C12713kf.m16531ok(C12610ok.this.f35538ok);
        }
    };

    public C12610ok(InputStream inputStream, int i, int i2) throws Throwable {
        this.f35538ok = inputStream;
        this.f35530a = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.f35531bl = i2;
        m16974bl();
    }

    /* renamed from: kf */
    private void m16971kf() throws BaseException {
        Throwable th = this.f35542rh;
        if (th != null) {
            if (th instanceof C12577i) {
                throw new BaseException(1068, "async reader closed!");
            }
            C12713kf.m16540ok(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    /* renamed from: n */
    private C12582ok m16970n() throws BaseException, InterruptedException {
        C12582ok c12582ok;
        C12582ok c12582ok2 = this.f35541r;
        if (c12582ok2 != null) {
            this.f35541r = c12582ok2.f35344s;
            c12582ok2.f35344s = null;
            return c12582ok2;
        }
        synchronized (this.f35537n) {
            c12582ok = this.f35540q;
            if (c12582ok == null) {
                do {
                    if (this.f35546z) {
                        m16971kf();
                    }
                    this.f35537n.wait();
                    c12582ok = this.f35540q;
                } while (c12582ok == null);
                this.f35541r = c12582ok.f35344s;
                this.f35535k = null;
                this.f35540q = null;
                c12582ok.f35344s = null;
            } else {
                this.f35541r = c12582ok.f35344s;
                this.f35535k = null;
                this.f35540q = null;
                c12582ok.f35344s = null;
            }
        }
        return c12582ok;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public C12582ok m16963s() throws C12577i, InterruptedException {
        int i;
        C12582ok c12582ok = this.f35539p;
        if (c12582ok != null) {
            if (!this.f35534j) {
                this.f35539p = c12582ok.f35344s;
                c12582ok.f35344s = null;
                return c12582ok;
            }
            throw new C12577i("");
        }
        synchronized (this.f35543s) {
            if (!this.f35534j) {
                C12582ok c12582ok2 = this.f35536kf;
                if (c12582ok2 == null && (i = this.f35533i) < this.f35531bl) {
                    this.f35533i = i + 1;
                    return new C12582ok(this.f35530a);
                }
                while (c12582ok2 == null) {
                    this.f35543s.wait();
                    if (!this.f35534j) {
                        c12582ok2 = this.f35536kf;
                    } else {
                        throw new C12577i("");
                    }
                }
                this.f35539p = c12582ok2.f35344s;
                this.f35532h = null;
                this.f35536kf = null;
                c12582ok2.f35344s = null;
                return c12582ok2;
            }
            throw new C12577i("");
        }
    }

    /* renamed from: bl */
    private void m16974bl() throws Throwable {
        this.f35544t = C12490bl.m17749x().submit(this.f35545x);
    }

    @Override // com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a
    /* renamed from: a */
    public void mo16977a() {
        synchronized (this.f35543s) {
            this.f35534j = true;
            this.f35543s.notify();
        }
        Future future = this.f35544t;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.f35544t = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public void m16973bl(C12582ok c12582ok) {
        synchronized (this.f35537n) {
            C12582ok c12582ok2 = this.f35535k;
            if (c12582ok2 == null) {
                this.f35535k = c12582ok;
                this.f35540q = c12582ok;
                this.f35537n.notify();
            } else {
                c12582ok2.f35344s = c12582ok;
                this.f35535k = c12582ok;
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a
    /* renamed from: ok */
    public C12582ok mo16969ok() throws BaseException, InterruptedException {
        return m16970n();
    }

    @Override // com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a
    /* renamed from: ok */
    public void mo16968ok(C12582ok c12582ok) {
        m16976a(c12582ok);
    }

    /* renamed from: a */
    private void m16976a(C12582ok c12582ok) {
        synchronized (this.f35543s) {
            C12582ok c12582ok2 = this.f35532h;
            if (c12582ok2 == null) {
                this.f35532h = c12582ok;
                this.f35536kf = c12582ok;
                this.f35543s.notify();
            } else {
                c12582ok2.f35344s = c12582ok;
                this.f35532h = c12582ok;
            }
        }
    }
}
