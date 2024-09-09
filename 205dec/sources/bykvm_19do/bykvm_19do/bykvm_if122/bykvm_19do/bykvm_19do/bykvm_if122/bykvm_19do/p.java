package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    static o f835a;

    /* renamed from: b  reason: collision with root package name */
    static long f836b;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        synchronized (p.class) {
            o oVar = f835a;
            if (oVar != null) {
                f835a = oVar.f833f;
                oVar.f833f = null;
                f836b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(o oVar) {
        if (oVar.f833f == null && oVar.f834g == null) {
            if (oVar.f831d) {
                return;
            }
            synchronized (p.class) {
                long j4 = f836b;
                if (j4 + 8192 > 65536) {
                    return;
                }
                f836b = j4 + 8192;
                oVar.f833f = f835a;
                oVar.f830c = 0;
                oVar.f829b = 0;
                f835a = oVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
