package com.ss.android.socialbase.downloader.gd;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private c f49713c;
    private int sr = 10;

    /* renamed from: w  reason: collision with root package name */
    private c f49714w;
    private int xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        long f49715c;
        c sr;

        /* renamed from: w  reason: collision with root package name */
        long f49716w;
        c xv;

        private c() {
        }
    }

    public boolean c(long j4, long j5) {
        synchronized (this) {
            c cVar = this.f49713c;
            if (cVar != null) {
                if (j4 >= cVar.f49715c && j5 >= cVar.f49716w) {
                    c cVar2 = cVar.xv;
                    if (cVar2 != null && j5 - cVar2.f49716w < 1000) {
                        cVar.f49715c = j4;
                        cVar.f49716w = j5;
                        return true;
                    }
                }
                return false;
            }
            c c4 = c();
            c4.f49715c = j4;
            c4.f49716w = j5;
            if (cVar != null) {
                c4.xv = cVar;
                cVar.sr = c4;
            }
            this.f49713c = c4;
            return true;
        }
    }

    public long w(long j4, long j5) {
        synchronized (this) {
            c cVar = this.f49713c;
            if (cVar == null) {
                return -1L;
            }
            c c4 = c(j4);
            if (c4 == null) {
                return -1L;
            }
            long j6 = cVar.f49715c - c4.f49715c;
            long j7 = j5 - c4.f49716w;
            if (j6 < 0 || j7 <= 0) {
                return -1L;
            }
            return j6 / j7;
        }
    }

    private c c() {
        c cVar;
        int i4 = this.xv;
        if (i4 >= this.sr && (cVar = this.f49714w) != null) {
            c cVar2 = cVar.sr;
            cVar.sr = null;
            this.f49714w = cVar2;
            if (cVar2 != null) {
                cVar2.xv = null;
            }
            return cVar;
        }
        this.xv = i4 + 1;
        return new c();
    }

    private c c(long j4) {
        c cVar = this.f49713c;
        c cVar2 = null;
        while (cVar != null && cVar.f49716w > j4) {
            cVar2 = cVar;
            cVar = cVar.xv;
        }
        return (cVar == null || cVar2 == null || cVar == cVar2 || j4 - cVar.f49716w >= cVar2.f49716w - j4) ? cVar2 : cVar;
    }
}
