package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r {
    private static final String ok = "r";

    /* renamed from: a  reason: collision with root package name */
    private final s f50051a;
    private volatile boolean bl;

    /* renamed from: h  reason: collision with root package name */
    private int f50052h;
    private final ArrayList<a> kf;

    /* renamed from: n  reason: collision with root package name */
    private AtomicReference<j> f50053n;

    /* renamed from: s  reason: collision with root package name */
    private final AtomicReference<j> f50054s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.downloader.network.r$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ok;

        static {
            int[] iArr = new int[j.values().length];
            ok = iArr;
            try {
                iArr[j.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ok[j.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ok[j.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ok[j.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void ok(j jVar);
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ok {
        public static final r ok = new r(null);
    }

    /* synthetic */ r(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean bl() {
        if (this.f50051a == null) {
            return false;
        }
        try {
            int i4 = AnonymousClass1.ok[this.f50054s.get().ordinal()];
            double d4 = 2000.0d;
            double d5 = 550.0d;
            if (i4 == 1) {
                d5 = 0.0d;
                d4 = 150.0d;
            } else if (i4 == 2) {
                d4 = 550.0d;
                d5 = 150.0d;
            } else if (i4 != 3) {
                if (i4 != 4) {
                    return true;
                }
                d4 = 3.4028234663852886E38d;
                d5 = 2000.0d;
            }
            double ok2 = this.f50051a.ok();
            if (ok2 > d4) {
                if (ok2 > d4 * 1.25d) {
                    return true;
                }
            } else if (ok2 < d5 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static r ok() {
        return ok.ok;
    }

    private void s() {
        try {
            int size = this.kf.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.kf.get(i4).ok(this.f50054s.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized j a() {
        s sVar = this.f50051a;
        if (sVar == null) {
            return j.UNKNOWN;
        }
        return ok(sVar.ok());
    }

    private r() {
        this.f50051a = new s(0.05d);
        this.bl = false;
        this.f50054s = new AtomicReference<>(j.UNKNOWN);
        this.kf = new ArrayList<>();
    }

    public synchronized void ok(long j4, long j5) {
        j a4;
        double d4 = j4;
        Double.isNaN(d4);
        double d5 = j5;
        Double.isNaN(d5);
        double d6 = ((d4 * 1.0d) / d5) * 8.0d;
        if (j5 == 0 || d6 < 3.0d) {
            return;
        }
        try {
            this.f50051a.ok(d6);
            a4 = a();
        } catch (Throwable unused) {
        }
        if (this.bl) {
            this.f50052h++;
            if (a4 != this.f50053n.get()) {
                this.bl = false;
                this.f50052h = 1;
            }
            if (this.f50052h >= 5.0d && bl()) {
                this.bl = false;
                this.f50052h = 1;
                this.f50054s.set(this.f50053n.get());
                s();
            }
            return;
        }
        if (this.f50054s.get() != a4) {
            this.bl = true;
            this.f50053n = new AtomicReference<>(a4);
        }
    }

    private j ok(double d4) {
        if (d4 < 0.0d) {
            return j.UNKNOWN;
        }
        if (d4 < 150.0d) {
            return j.POOR;
        }
        if (d4 < 550.0d) {
            return j.MODERATE;
        }
        if (d4 < 2000.0d) {
            return j.GOOD;
        }
        return j.EXCELLENT;
    }
}
