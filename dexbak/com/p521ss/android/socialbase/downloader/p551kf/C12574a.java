package com.p521ss.android.socialbase.downloader.p551kf;

import androidx.annotation.NonNull;

/* renamed from: com.ss.android.socialbase.downloader.kf.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12574a implements InterfaceC12575bl, InterfaceC12581n, InterfaceC12590s {

    /* renamed from: a */
    private final int f35307a;

    /* renamed from: h */
    private C12582ok f35309h;

    /* renamed from: k */
    private volatile boolean f35310k;

    /* renamed from: kf */
    private C12582ok f35311kf;

    /* renamed from: n */
    private C12582ok f35312n;

    /* renamed from: ok */
    private final int f35313ok;

    /* renamed from: p */
    private C12582ok f35314p;

    /* renamed from: q */
    private C12582ok f35315q;

    /* renamed from: r */
    private int f35316r;

    /* renamed from: bl */
    private final Object f35308bl = new Object();

    /* renamed from: s */
    private final Object f35317s = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C12574a(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.f35313ok = i;
        this.f35307a = i2;
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12575bl
    @NonNull
    /* renamed from: a */
    public C12582ok mo17317a() throws C12577i, InterruptedException {
        synchronized (this.f35308bl) {
            if (!this.f35310k) {
                C12582ok c12582ok = this.f35312n;
                if (c12582ok == null) {
                    int i = this.f35316r;
                    if (i < this.f35313ok) {
                        this.f35316r = i + 1;
                        return new C12582ok(this.f35307a);
                    }
                    do {
                        this.f35308bl.wait();
                        if (!this.f35310k) {
                            c12582ok = this.f35312n;
                        } else {
                            throw new C12577i("obtain");
                        }
                    } while (c12582ok == null);
                }
                this.f35312n = c12582ok.f35344s;
                if (c12582ok == this.f35311kf) {
                    this.f35311kf = null;
                }
                c12582ok.f35344s = null;
                return c12582ok;
            }
            throw new C12577i("obtain");
        }
    }

    /* renamed from: bl */
    public void m17318bl() {
        this.f35310k = true;
        synchronized (this.f35308bl) {
            this.f35308bl.notifyAll();
        }
        synchronized (this.f35317s) {
            this.f35317s.notifyAll();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12590s
    @NonNull
    /* renamed from: ok */
    public C12582ok mo17195ok() throws C12577i, InterruptedException {
        C12582ok c12582ok;
        C12582ok c12582ok2 = this.f35315q;
        if (c12582ok2 != null) {
            this.f35315q = c12582ok2.f35344s;
            c12582ok2.f35344s = null;
            return c12582ok2;
        }
        synchronized (this.f35317s) {
            c12582ok = this.f35309h;
            while (c12582ok == null) {
                if (!this.f35310k) {
                    this.f35317s.wait();
                    c12582ok = this.f35309h;
                } else {
                    throw new C12577i("read");
                }
            }
            this.f35315q = c12582ok.f35344s;
            this.f35314p = null;
            this.f35309h = null;
            c12582ok.f35344s = null;
        }
        return c12582ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12575bl
    /* renamed from: ok */
    public void mo17316ok(@NonNull C12582ok c12582ok) {
        synchronized (this.f35308bl) {
            C12582ok c12582ok2 = this.f35311kf;
            if (c12582ok2 == null) {
                this.f35311kf = c12582ok;
                this.f35312n = c12582ok;
            } else {
                c12582ok2.f35344s = c12582ok;
                this.f35311kf = c12582ok;
            }
            this.f35308bl.notify();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12581n
    /* renamed from: a */
    public void mo17297a(@NonNull C12582ok c12582ok) {
        synchronized (this.f35317s) {
            C12582ok c12582ok2 = this.f35314p;
            if (c12582ok2 == null) {
                this.f35314p = c12582ok;
                this.f35309h = c12582ok;
                this.f35317s.notify();
            } else {
                c12582ok2.f35344s = c12582ok;
                this.f35314p = c12582ok;
            }
        }
    }
}
