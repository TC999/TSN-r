package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Segment {

    /* renamed from: a */
    final byte[] f835a;

    /* renamed from: b */
    int f836b;

    /* renamed from: c */
    int f837c;

    /* renamed from: d */
    boolean f838d;

    /* renamed from: e */
    boolean f839e;

    /* renamed from: f */
    Segment f840f;

    /* renamed from: g */
    Segment f841g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.f835a = new byte[8192];
        this.f839e = true;
        this.f838d = false;
    }

    /* renamed from: a */
    public final Segment m58897a(Segment segment) {
        segment.f841g = this;
        segment.f840f = this.f840f;
        this.f840f.f841g = segment;
        this.f840f = segment;
        return segment;
    }

    /* renamed from: b */
    public final Segment m58895b() {
        Segment segment = this.f840f;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.f841g;
        segment3.f840f = segment;
        this.f840f.f841g = segment3;
        this.f840f = null;
        this.f841g = null;
        return segment2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final Segment m58894c() {
        this.f838d = true;
        return new Segment(this.f835a, this.f836b, this.f837c, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f835a = bArr;
        this.f836b = i;
        this.f837c = i2;
        this.f838d = z;
        this.f839e = z2;
    }

    /* renamed from: a */
    public final Segment m58898a(int i) {
        Segment m58893a;
        if (i > 0 && i <= this.f837c - this.f836b) {
            if (i >= 1024) {
                m58893a = m58894c();
            } else {
                m58893a = SegmentPool.m58893a();
                System.arraycopy(this.f835a, this.f836b, m58893a.f835a, 0, i);
            }
            m58893a.f837c = m58893a.f836b + i;
            this.f836b += i;
            this.f841g.m58897a(m58893a);
            return m58893a;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final void m58899a() {
        Segment segment = this.f841g;
        if (segment != this) {
            if (segment.f839e) {
                int i = this.f837c - this.f836b;
                if (i > (8192 - segment.f837c) + (segment.f838d ? 0 : segment.f836b)) {
                    return;
                }
                m58896a(segment, i);
                m58895b();
                SegmentPool.m58892a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final void m58896a(Segment segment, int i) {
        if (segment.f839e) {
            int i2 = segment.f837c;
            int i3 = i2 + i;
            if (i3 > 8192) {
                if (!segment.f838d) {
                    int i4 = segment.f836b;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = segment.f835a;
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        segment.f837c -= segment.f836b;
                        segment.f836b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f835a, this.f836b, segment.f835a, segment.f837c, i);
            segment.f837c += i;
            this.f836b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
