package com.ss.android.socialbase.downloader.q;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private ok f50163a;
    private int bl;
    private ok ok;

    /* renamed from: s  reason: collision with root package name */
    private int f50164s = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        long f50165a;
        ok bl;
        long ok;

        /* renamed from: s  reason: collision with root package name */
        ok f50166s;

        private ok() {
        }
    }

    public long a(long j4, long j5) {
        synchronized (this) {
            ok okVar = this.ok;
            if (okVar == null) {
                return -1L;
            }
            ok ok2 = ok(j4);
            if (ok2 == null) {
                return -1L;
            }
            long j6 = okVar.ok - ok2.ok;
            long j7 = j5 - ok2.f50165a;
            if (j6 < 0 || j7 <= 0) {
                return -1L;
            }
            return j6 / j7;
        }
    }

    public boolean ok(long j4, long j5) {
        synchronized (this) {
            ok okVar = this.ok;
            if (okVar != null) {
                if (j4 >= okVar.ok && j5 >= okVar.f50165a) {
                    ok okVar2 = okVar.bl;
                    if (okVar2 != null && j5 - okVar2.f50165a < 1000) {
                        okVar.ok = j4;
                        okVar.f50165a = j5;
                        return true;
                    }
                }
                return false;
            }
            ok ok2 = ok();
            ok2.ok = j4;
            ok2.f50165a = j5;
            if (okVar != null) {
                ok2.bl = okVar;
                okVar.f50166s = ok2;
            }
            this.ok = ok2;
            return true;
        }
    }

    private ok ok() {
        ok okVar;
        int i4 = this.bl;
        if (i4 >= this.f50164s && (okVar = this.f50163a) != null) {
            ok okVar2 = okVar.f50166s;
            okVar.f50166s = null;
            this.f50163a = okVar2;
            if (okVar2 != null) {
                okVar2.bl = null;
            }
            return okVar;
        }
        this.bl = i4 + 1;
        return new ok();
    }

    private ok ok(long j4) {
        ok okVar = this.ok;
        ok okVar2 = null;
        while (okVar != null && okVar.f50165a > j4) {
            okVar2 = okVar;
            okVar = okVar.bl;
        }
        return (okVar == null || okVar2 == null || okVar == okVar2 || j4 - okVar.f50165a >= okVar2.f50165a - j4) ? okVar2 : okVar;
    }
}
