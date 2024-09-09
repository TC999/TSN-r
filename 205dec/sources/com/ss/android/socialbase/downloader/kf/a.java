package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class a implements bl, n, s {

    /* renamed from: a  reason: collision with root package name */
    private final int f49827a;

    /* renamed from: h  reason: collision with root package name */
    private ok f49828h;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f49829k;
    private ok kf;

    /* renamed from: n  reason: collision with root package name */
    private ok f49830n;
    private final int ok;

    /* renamed from: p  reason: collision with root package name */
    private ok f49831p;

    /* renamed from: q  reason: collision with root package name */
    private ok f49832q;

    /* renamed from: r  reason: collision with root package name */
    private int f49833r;
    private final Object bl = new Object();

    /* renamed from: s  reason: collision with root package name */
    private final Object f49834s = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i4, int i5) {
        i4 = i4 < 64 ? 64 : i4;
        i5 = i5 < 8192 ? 8192 : i5;
        this.ok = i4;
        this.f49827a = i5;
    }

    @Override // com.ss.android.socialbase.downloader.kf.bl
    @NonNull
    public ok a() throws i, InterruptedException {
        synchronized (this.bl) {
            if (!this.f49829k) {
                ok okVar = this.f49830n;
                if (okVar == null) {
                    int i4 = this.f49833r;
                    if (i4 < this.ok) {
                        this.f49833r = i4 + 1;
                        return new ok(this.f49827a);
                    }
                    do {
                        this.bl.wait();
                        if (!this.f49829k) {
                            okVar = this.f49830n;
                        } else {
                            throw new i("obtain");
                        }
                    } while (okVar == null);
                }
                this.f49830n = okVar.f49850s;
                if (okVar == this.kf) {
                    this.kf = null;
                }
                okVar.f49850s = null;
                return okVar;
            }
            throw new i("obtain");
        }
    }

    public void bl() {
        this.f49829k = true;
        synchronized (this.bl) {
            this.bl.notifyAll();
        }
        synchronized (this.f49834s) {
            this.f49834s.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.s
    @NonNull
    public ok ok() throws i, InterruptedException {
        ok okVar;
        ok okVar2 = this.f49832q;
        if (okVar2 != null) {
            this.f49832q = okVar2.f49850s;
            okVar2.f49850s = null;
            return okVar2;
        }
        synchronized (this.f49834s) {
            okVar = this.f49828h;
            while (okVar == null) {
                if (!this.f49829k) {
                    this.f49834s.wait();
                    okVar = this.f49828h;
                } else {
                    throw new i("read");
                }
            }
            this.f49832q = okVar.f49850s;
            this.f49831p = null;
            this.f49828h = null;
            okVar.f49850s = null;
        }
        return okVar;
    }

    @Override // com.ss.android.socialbase.downloader.kf.bl
    public void ok(@NonNull ok okVar) {
        synchronized (this.bl) {
            ok okVar2 = this.kf;
            if (okVar2 == null) {
                this.kf = okVar;
                this.f49830n = okVar;
            } else {
                okVar2.f49850s = okVar;
                this.kf = okVar;
            }
            this.bl.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.n
    public void a(@NonNull ok okVar) {
        synchronized (this.f49834s) {
            ok okVar2 = this.f49831p;
            if (okVar2 == null) {
                this.f49831p = okVar;
                this.f49828h = okVar;
                this.f49834s.notify();
            } else {
                okVar2.f49850s = okVar;
                this.f49831p = okVar;
            }
        }
    }
}
