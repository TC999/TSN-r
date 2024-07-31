package com.p521ss.android.socialbase.downloader.p556q;

/* renamed from: com.ss.android.socialbase.downloader.q.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12714n {

    /* renamed from: a */
    private C12716ok f35803a;

    /* renamed from: bl */
    private int f35804bl;

    /* renamed from: ok */
    private C12716ok f35805ok;

    /* renamed from: s */
    private int f35806s = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.downloader.q.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12716ok {

        /* renamed from: a */
        long f35807a;

        /* renamed from: bl */
        C12716ok f35808bl;

        /* renamed from: ok */
        long f35809ok;

        /* renamed from: s */
        C12716ok f35810s;

        private C12716ok() {
        }
    }

    /* renamed from: a */
    public long m16514a(long j, long j2) {
        synchronized (this) {
            C12716ok c12716ok = this.f35805ok;
            if (c12716ok == null) {
                return -1L;
            }
            C12716ok m16512ok = m16512ok(j);
            if (m16512ok == null) {
                return -1L;
            }
            long j3 = c12716ok.f35809ok - m16512ok.f35809ok;
            long j4 = j2 - m16512ok.f35807a;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    /* renamed from: ok */
    public boolean m16511ok(long j, long j2) {
        synchronized (this) {
            C12716ok c12716ok = this.f35805ok;
            if (c12716ok != null) {
                if (j >= c12716ok.f35809ok && j2 >= c12716ok.f35807a) {
                    C12716ok c12716ok2 = c12716ok.f35808bl;
                    if (c12716ok2 != null && j2 - c12716ok2.f35807a < 1000) {
                        c12716ok.f35809ok = j;
                        c12716ok.f35807a = j2;
                        return true;
                    }
                }
                return false;
            }
            C12716ok m16513ok = m16513ok();
            m16513ok.f35809ok = j;
            m16513ok.f35807a = j2;
            if (c12716ok != null) {
                m16513ok.f35808bl = c12716ok;
                c12716ok.f35810s = m16513ok;
            }
            this.f35805ok = m16513ok;
            return true;
        }
    }

    /* renamed from: ok */
    private C12716ok m16513ok() {
        C12716ok c12716ok;
        int i = this.f35804bl;
        if (i >= this.f35806s && (c12716ok = this.f35803a) != null) {
            C12716ok c12716ok2 = c12716ok.f35810s;
            c12716ok.f35810s = null;
            this.f35803a = c12716ok2;
            if (c12716ok2 != null) {
                c12716ok2.f35808bl = null;
            }
            return c12716ok;
        }
        this.f35804bl = i + 1;
        return new C12716ok();
    }

    /* renamed from: ok */
    private C12716ok m16512ok(long j) {
        C12716ok c12716ok = this.f35805ok;
        C12716ok c12716ok2 = null;
        while (c12716ok != null && c12716ok.f35807a > j) {
            c12716ok2 = c12716ok;
            c12716ok = c12716ok.f35808bl;
        }
        return (c12716ok == null || c12716ok2 == null || c12716ok == c12716ok2 || j - c12716ok.f35807a >= c12716ok2.f35807a - j) ? c12716ok2 : c12716ok;
    }
}
