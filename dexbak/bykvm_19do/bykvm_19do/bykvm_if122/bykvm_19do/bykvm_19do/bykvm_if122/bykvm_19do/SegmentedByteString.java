package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: f */
    final transient byte[][] f844f;

    /* renamed from: g */
    final transient int[] f845g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.m58867a(buffer.f805b, 0L, i);
        Segment segment = buffer.f804a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.f837c;
            int i6 = segment.f836b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.f840f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f844f = new byte[i4];
        this.f845g = new int[i4 * 2];
        Segment segment2 = buffer.f804a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f844f;
            bArr[i7] = segment2.f835a;
            int i8 = segment2.f837c;
            int i9 = segment2.f836b;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f845g;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            segment2.f838d = true;
            i7++;
            segment2 = segment2.f840f;
        }
    }

    /* renamed from: i */
    private ByteString m58877i() {
        return new ByteString(mo58879g());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: a */
    public String mo58891a() {
        return m58877i().mo58891a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: b */
    public String mo58885b() {
        return m58877i().mo58885b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: c */
    public ByteString mo58883c() {
        return m58877i().mo58883c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: d */
    public ByteString mo58882d() {
        return m58877i().mo58882d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: e */
    public int mo58881e() {
        return this.f845g[this.f844f.length - 1];
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.mo58881e() == mo58881e() && mo58888a(0, byteString, 0, mo58881e())) {
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: f */
    public ByteString mo58880f() {
        return m58877i().mo58880f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: g */
    public byte[] mo58879g() {
        int[] iArr = this.f845g;
        byte[][] bArr = this.f844f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f845g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f844f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: h */
    public String mo58878h() {
        return m58877i().mo58878h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    public int hashCode() {
        int i = this.f809b;
        if (i != 0) {
            return i;
        }
        int length = this.f844f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f844f[i2];
            int[] iArr = this.f845g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f809b = i4;
        return i4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    public String toString() {
        return m58877i().toString();
    }

    /* renamed from: b */
    private int m58884b(int i) {
        int binarySearch = Arrays.binarySearch(this.f845g, 0, this.f844f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: a */
    public ByteString mo58889a(int i, int i2) {
        return m58877i().mo58889a(i, i2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: a */
    public byte mo58890a(int i) {
        Util.m58867a(this.f845g[this.f844f.length - 1], i, 1L);
        int m58884b = m58884b(i);
        int i2 = m58884b == 0 ? 0 : this.f845g[m58884b - 1];
        int[] iArr = this.f845g;
        byte[][] bArr = this.f844f;
        return bArr[m58884b][(i - i2) + iArr[bArr.length + m58884b]];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: a */
    public void mo58886a(Buffer buffer) {
        int length = this.f844f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f845g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.f844f[i], i3, (i3 + i4) - i2, true, false);
            Segment segment2 = buffer.f804a;
            if (segment2 == null) {
                segment.f841g = segment;
                segment.f840f = segment;
                buffer.f804a = segment;
            } else {
                segment2.f841g.m58897a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f805b += i2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: a */
    public boolean mo58888a(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > mo58881e() - i3) {
            return false;
        }
        int m58884b = m58884b(i);
        while (i3 > 0) {
            int i4 = m58884b == 0 ? 0 : this.f845g[m58884b - 1];
            int min = Math.min(i3, ((this.f845g[m58884b] - i4) + i4) - i);
            int[] iArr = this.f845g;
            byte[][] bArr = this.f844f;
            if (!byteString.mo58887a(i2, bArr[m58884b], (i - i4) + iArr[bArr.length + m58884b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m58884b++;
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString
    /* renamed from: a */
    public boolean mo58887a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo58881e() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int m58884b = m58884b(i);
        while (i3 > 0) {
            int i4 = m58884b == 0 ? 0 : this.f845g[m58884b - 1];
            int min = Math.min(i3, ((this.f845g[m58884b] - i4) + i4) - i);
            int[] iArr = this.f845g;
            byte[][] bArr2 = this.f844f;
            if (!Util.m58864a(bArr2[m58884b], (i - i4) + iArr[bArr2.length + m58884b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m58884b++;
        }
        return true;
    }
}
