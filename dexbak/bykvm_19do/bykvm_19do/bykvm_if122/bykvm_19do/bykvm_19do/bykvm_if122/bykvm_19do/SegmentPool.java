package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.p */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SegmentPool {

    /* renamed from: a */
    static Segment f842a;

    /* renamed from: b */
    static long f843b;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Segment m58893a() {
        synchronized (SegmentPool.class) {
            Segment segment = f842a;
            if (segment != null) {
                f842a = segment.f840f;
                segment.f840f = null;
                f843b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m58892a(Segment segment) {
        if (segment.f840f == null && segment.f841g == null) {
            if (segment.f838d) {
                return;
            }
            synchronized (SegmentPool.class) {
                long j = f843b;
                if (j + 8192 > 65536) {
                    return;
                }
                f843b = j + 8192;
                segment.f840f = f842a;
                segment.f837c = 0;
                segment.f836b = 0;
                f842a = segment;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
