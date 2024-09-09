package com.bytedance.sdk.component.w.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class r {

    /* renamed from: c  reason: collision with root package name */
    static f f30444c;

    /* renamed from: w  reason: collision with root package name */
    static long f30445w;

    private r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f c() {
        synchronized (r.class) {
            f fVar = f30444c;
            if (fVar != null) {
                f30444c = fVar.f30440f;
                fVar.f30440f = null;
                f30445w -= 8192;
                return fVar;
            }
            return new f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(f fVar) {
        if (fVar.f30440f == null && fVar.f30441r == null) {
            if (fVar.sr) {
                return;
            }
            synchronized (r.class) {
                long j4 = f30445w;
                if (j4 + 8192 > 65536) {
                    return;
                }
                f30445w = j4 + 8192;
                fVar.f30440f = f30444c;
                fVar.xv = 0;
                fVar.f30442w = 0;
                f30444c = fVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
