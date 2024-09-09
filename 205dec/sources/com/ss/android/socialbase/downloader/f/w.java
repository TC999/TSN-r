package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
class w implements sr, ux, xv {

    /* renamed from: c  reason: collision with root package name */
    private final int f49643c;
    private c ev;

    /* renamed from: f  reason: collision with root package name */
    private c f49644f;
    private c gd;

    /* renamed from: k  reason: collision with root package name */
    private int f49645k;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f49646p;

    /* renamed from: r  reason: collision with root package name */
    private c f49647r;
    private c ux;

    /* renamed from: w  reason: collision with root package name */
    private final int f49648w;
    private final Object xv = new Object();
    private final Object sr = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(int i4, int i5) {
        i4 = i4 < 64 ? 64 : i4;
        i5 = i5 < 8192 ? 8192 : i5;
        this.f49643c = i4;
        this.f49648w = i5;
    }

    @Override // com.ss.android.socialbase.downloader.f.sr
    @NonNull
    public c c() throws fp, InterruptedException {
        c cVar;
        c cVar2 = this.gd;
        if (cVar2 != null) {
            this.gd = cVar2.sr;
            cVar2.sr = null;
            return cVar2;
        }
        synchronized (this.sr) {
            cVar = this.f49647r;
            while (cVar == null) {
                if (!this.f49646p) {
                    this.sr.wait();
                    cVar = this.f49647r;
                } else {
                    throw new fp("read");
                }
            }
            this.gd = cVar.sr;
            this.ev = null;
            this.f49647r = null;
            cVar.sr = null;
        }
        return cVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.xv
    @NonNull
    public c w() throws fp, InterruptedException {
        synchronized (this.xv) {
            if (!this.f49646p) {
                c cVar = this.ux;
                if (cVar == null) {
                    int i4 = this.f49645k;
                    if (i4 < this.f49643c) {
                        this.f49645k = i4 + 1;
                        return new c(this.f49648w);
                    }
                    do {
                        this.xv.wait();
                        if (!this.f49646p) {
                            cVar = this.ux;
                        } else {
                            throw new fp("obtain");
                        }
                    } while (cVar == null);
                }
                this.ux = cVar.sr;
                if (cVar == this.f49644f) {
                    this.f49644f = null;
                }
                cVar.sr = null;
                return cVar;
            }
            throw new fp("obtain");
        }
    }

    public void xv() {
        this.f49646p = true;
        synchronized (this.xv) {
            this.xv.notifyAll();
        }
        synchronized (this.sr) {
            this.sr.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.xv
    public void c(@NonNull c cVar) {
        synchronized (this.xv) {
            c cVar2 = this.f49644f;
            if (cVar2 == null) {
                this.f49644f = cVar;
                this.ux = cVar;
            } else {
                cVar2.sr = cVar;
                this.f49644f = cVar;
            }
            this.xv.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.ux
    public void w(@NonNull c cVar) {
        synchronized (this.sr) {
            c cVar2 = this.ev;
            if (cVar2 == null) {
                this.ev = cVar;
                this.f49647r = cVar;
                this.sr.notify();
            } else {
                cVar2.sr = cVar;
                this.ev = cVar;
            }
        }
    }
}
