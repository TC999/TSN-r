package com.bytedance.sdk.component.xv.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class fp {

    /* renamed from: c  reason: collision with root package name */
    static ys f30682c;

    /* renamed from: w  reason: collision with root package name */
    static long f30683w;

    private fp() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ys c() {
        synchronized (fp.class) {
            ys ysVar = f30682c;
            if (ysVar != null) {
                f30682c = ysVar.f30704f;
                ysVar.f30704f = null;
                f30683w -= 8192;
                return ysVar;
            }
            return new ys();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ys ysVar) {
        if (ysVar.f30704f == null && ysVar.f30705r == null) {
            if (ysVar.sr) {
                return;
            }
            synchronized (fp.class) {
                long j4 = f30683w;
                if (j4 + 8192 > 65536) {
                    return;
                }
                f30683w = j4 + 8192;
                ysVar.f30704f = f30682c;
                ysVar.xv = 0;
                ysVar.f30706w = 0;
                f30682c = ysVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
