package com.amap.api.col.p0463l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* renamed from: com.amap.api.col.3l.u9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FlatBufferBuilder {

    /* renamed from: o */
    static final Charset f5521o = Charset.forName("UTF-8");

    /* renamed from: p */
    static final /* synthetic */ boolean f5522p = true;

    /* renamed from: a */
    ByteBuffer f5523a;

    /* renamed from: b */
    int f5524b;

    /* renamed from: c */
    int f5525c;

    /* renamed from: d */
    int[] f5526d;

    /* renamed from: e */
    int f5527e;

    /* renamed from: f */
    boolean f5528f;

    /* renamed from: g */
    boolean f5529g;

    /* renamed from: h */
    int f5530h;

    /* renamed from: i */
    int[] f5531i;

    /* renamed from: j */
    int f5532j;

    /* renamed from: k */
    int f5533k;

    /* renamed from: l */
    boolean f5534l;

    /* renamed from: m */
    CharsetEncoder f5535m;

    /* renamed from: n */
    ByteBuffer f5536n;

    private FlatBufferBuilder() {
        this.f5525c = 1;
        this.f5526d = null;
        this.f5527e = 0;
        this.f5528f = false;
        this.f5529g = false;
        this.f5531i = new int[16];
        this.f5532j = 0;
        this.f5533k = 0;
        this.f5534l = false;
        this.f5535m = f5521o.newEncoder();
        this.f5524b = 1024;
        this.f5523a = m53713B(1024);
    }

    /* renamed from: A */
    private int m53714A() {
        return this.f5523a.capacity() - this.f5524b;
    }

    /* renamed from: B */
    private static ByteBuffer m53713B(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    /* renamed from: C */
    private byte[] m53712C(int i, int i2) {
        m53711D();
        byte[] bArr = new byte[i2];
        this.f5523a.position(i);
        this.f5523a.get(bArr);
        return bArr;
    }

    /* renamed from: D */
    private void m53711D() {
        if (!this.f5529g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    /* renamed from: E */
    private void m53710E(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.f5523a;
            int i3 = this.f5524b - 1;
            this.f5524b = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    /* renamed from: F */
    private void m53709F() {
        if (this.f5528f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    /* renamed from: G */
    private void m53708G(int i) {
        ByteBuffer byteBuffer = this.f5523a;
        int i2 = this.f5524b - 4;
        this.f5524b = i2;
        byteBuffer.putInt(i2, i);
    }

    /* renamed from: H */
    private void m53707H(int i) {
        m53682x(4, 0);
        m53708G(i);
    }

    /* renamed from: I */
    private void m53706I(int i) {
        this.f5526d[i] = m53714A();
    }

    /* renamed from: k */
    private void m53695k(long j) {
        ByteBuffer byteBuffer = this.f5523a;
        int i = this.f5524b - 8;
        this.f5524b = i;
        byteBuffer.putLong(i, j);
    }

    /* renamed from: l */
    private void m53694l(short s) {
        ByteBuffer byteBuffer = this.f5523a;
        int i = this.f5524b - 2;
        this.f5524b = i;
        byteBuffer.putShort(i, s);
    }

    /* renamed from: o */
    private static ByteBuffer m53691o(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer m53713B = m53713B(i);
            m53713B.position(i - capacity);
            m53713B.put(byteBuffer);
            return m53713B;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    /* renamed from: p */
    private void m53690p(byte b) {
        ByteBuffer byteBuffer = this.f5523a;
        int i = this.f5524b - 1;
        this.f5524b = i;
        byteBuffer.put(i, b);
    }

    /* renamed from: s */
    private void m53687s(long j) {
        m53682x(8, 0);
        m53695k(j);
    }

    /* renamed from: t */
    private void m53686t(short s) {
        m53682x(2, 0);
        m53694l(s);
    }

    /* renamed from: u */
    private void m53685u(boolean z) {
        ByteBuffer byteBuffer = this.f5523a;
        int i = this.f5524b - 1;
        this.f5524b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    /* renamed from: v */
    private int m53684v(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        m53702d((byte) 0);
        m53698h(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f5523a;
        int i = this.f5524b - remaining;
        this.f5524b = i;
        byteBuffer2.position(i);
        this.f5523a.put(byteBuffer);
        return m53705a();
    }

    /* renamed from: x */
    private void m53682x(int i, int i2) {
        if (i > this.f5525c) {
            this.f5525c = i;
        }
        int capacity = ((((this.f5523a.capacity() - this.f5524b) + i2) ^ (-1)) + 1) & (i - 1);
        while (this.f5524b < capacity + i + i2) {
            int capacity2 = this.f5523a.capacity();
            ByteBuffer m53691o = m53691o(this.f5523a);
            this.f5523a = m53691o;
            this.f5524b += m53691o.capacity() - capacity2;
        }
        m53710E(capacity);
    }

    /* renamed from: y */
    private void m53681y(boolean z) {
        m53682x(1, 0);
        m53685u(z);
    }

    /* renamed from: a */
    public final int m53705a() {
        if (this.f5528f) {
            this.f5528f = false;
            m53708G(this.f5533k);
            return m53714A();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    /* renamed from: b */
    public int mo53704b(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.f5535m.maxBytesPerChar());
        ByteBuffer byteBuffer = this.f5536n;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.f5536n = ByteBuffer.allocate(Math.max(128, length));
        }
        this.f5536n.clear();
        CoderResult encode = this.f5535m.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.f5536n, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.f5536n.flip();
        return m53684v(this.f5536n);
    }

    /* renamed from: c */
    public final FlatBufferBuilder m53703c(ByteBuffer byteBuffer) {
        this.f5523a = byteBuffer;
        byteBuffer.clear();
        this.f5523a.order(ByteOrder.LITTLE_ENDIAN);
        this.f5525c = 1;
        this.f5524b = this.f5523a.capacity();
        this.f5527e = 0;
        this.f5528f = false;
        this.f5529g = false;
        this.f5530h = 0;
        this.f5532j = 0;
        this.f5533k = 0;
        return this;
    }

    /* renamed from: d */
    public final void m53702d(byte b) {
        m53682x(1, 0);
        m53690p(b);
    }

    /* renamed from: e */
    public final void m53701e(int i) {
        m53682x(4, 0);
        if (!f5522p && i > m53714A()) {
            throw new AssertionError();
        }
        m53708G((m53714A() - i) + 4);
    }

    /* renamed from: f */
    public final void m53700f(int i, byte b) {
        if (this.f5534l || b != 0) {
            m53702d(b);
            m53706I(i);
        }
    }

    /* renamed from: g */
    public final void m53699g(int i, int i2) {
        if (this.f5534l || i2 != 0) {
            m53707H(i2);
            m53706I(i);
        }
    }

    /* renamed from: h */
    public final void m53698h(int i, int i2, int i3) {
        m53709F();
        this.f5533k = i2;
        int i4 = i * i2;
        m53682x(4, i4);
        m53682x(i3, i4);
        this.f5528f = true;
    }

    /* renamed from: i */
    public final void m53697i(int i, long j) {
        if (this.f5534l || j != 0) {
            m53687s(j);
            m53706I(i);
        }
    }

    /* renamed from: j */
    public final void m53696j(int i, short s) {
        if (this.f5534l || s != 0) {
            m53686t(s);
            m53706I(i);
        }
    }

    /* renamed from: m */
    public final void m53693m(boolean z) {
        if (this.f5534l || z) {
            m53681y(z);
            m53706I(0);
        }
    }

    /* renamed from: n */
    public final int m53692n() {
        int i;
        int i2;
        if (this.f5526d != null && this.f5528f) {
            m53707H(0);
            int m53714A = m53714A();
            for (int i3 = this.f5527e - 1; i3 >= 0; i3--) {
                int[] iArr = this.f5526d;
                m53686t((short) (iArr[i3] != 0 ? m53714A - iArr[i3] : 0));
            }
            m53686t((short) (m53714A - this.f5530h));
            m53686t((short) ((this.f5527e + 2) * 2));
            int i4 = 0;
            loop1: while (true) {
                if (i4 >= this.f5532j) {
                    i = 0;
                    break;
                }
                int capacity = this.f5523a.capacity() - this.f5531i[i4];
                int i5 = this.f5524b;
                short s = this.f5523a.getShort(capacity);
                if (s == this.f5523a.getShort(i5)) {
                    while (i2 < s) {
                        i2 = this.f5523a.getShort(capacity + i2) == this.f5523a.getShort(i5 + i2) ? i2 + 2 : 2;
                    }
                    i = this.f5531i[i4];
                    break loop1;
                }
                i4++;
            }
            if (i != 0) {
                int capacity2 = this.f5523a.capacity() - m53714A;
                this.f5524b = capacity2;
                this.f5523a.putInt(capacity2, i - m53714A);
            } else {
                int i6 = this.f5532j;
                int[] iArr2 = this.f5531i;
                if (i6 == iArr2.length) {
                    this.f5531i = Arrays.copyOf(iArr2, i6 * 2);
                }
                int[] iArr3 = this.f5531i;
                int i7 = this.f5532j;
                this.f5532j = i7 + 1;
                iArr3[i7] = m53714A();
                ByteBuffer byteBuffer = this.f5523a;
                byteBuffer.putInt(byteBuffer.capacity() - m53714A, m53714A() - m53714A);
            }
            this.f5528f = false;
            return m53714A;
        }
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    /* renamed from: q */
    public final void m53689q(int i) {
        m53709F();
        int[] iArr = this.f5526d;
        if (iArr == null || iArr.length < i) {
            this.f5526d = new int[i];
        }
        this.f5527e = i;
        Arrays.fill(this.f5526d, 0, i, 0);
        this.f5528f = true;
        this.f5530h = m53714A();
    }

    /* renamed from: r */
    public final void m53688r(int i, int i2) {
        if (this.f5534l || i2 != 0) {
            m53701e(i2);
            m53706I(i);
        }
    }

    /* renamed from: w */
    public final void m53683w(int i) {
        m53682x(this.f5525c, 4);
        m53701e(i);
        this.f5523a.position(this.f5524b);
        this.f5529g = true;
    }

    /* renamed from: z */
    public final byte[] m53680z() {
        return m53712C(this.f5524b, this.f5523a.capacity() - this.f5524b);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this.f5525c = 1;
        this.f5526d = null;
        this.f5527e = 0;
        this.f5528f = false;
        this.f5529g = false;
        this.f5531i = new int[16];
        this.f5532j = 0;
        this.f5533k = 0;
        this.f5534l = false;
        this.f5535m = f5521o.newEncoder();
        m53703c(byteBuffer);
    }
}
