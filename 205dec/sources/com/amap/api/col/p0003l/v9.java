package com.amap.api.col.p0003l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FlatBufferBuilder.java */
/* renamed from: com.amap.api.col.3l.v9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class v9 {

    /* renamed from: o  reason: collision with root package name */
    static final Charset f9297o = Charset.forName("UTF-8");

    /* renamed from: p  reason: collision with root package name */
    static final /* synthetic */ boolean f9298p = true;

    /* renamed from: a  reason: collision with root package name */
    ByteBuffer f9299a;

    /* renamed from: b  reason: collision with root package name */
    int f9300b;

    /* renamed from: c  reason: collision with root package name */
    int f9301c;

    /* renamed from: d  reason: collision with root package name */
    int[] f9302d;

    /* renamed from: e  reason: collision with root package name */
    int f9303e;

    /* renamed from: f  reason: collision with root package name */
    boolean f9304f;

    /* renamed from: g  reason: collision with root package name */
    boolean f9305g;

    /* renamed from: h  reason: collision with root package name */
    int f9306h;

    /* renamed from: i  reason: collision with root package name */
    int[] f9307i;

    /* renamed from: j  reason: collision with root package name */
    int f9308j;

    /* renamed from: k  reason: collision with root package name */
    int f9309k;

    /* renamed from: l  reason: collision with root package name */
    boolean f9310l;

    /* renamed from: m  reason: collision with root package name */
    CharsetEncoder f9311m;

    /* renamed from: n  reason: collision with root package name */
    ByteBuffer f9312n;

    /* compiled from: Table.java */
    /* renamed from: com.amap.api.col.3l.v9$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a extends ThreadLocal<CharsetDecoder> {
        a() {
        }

        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    /* compiled from: Table.java */
    /* renamed from: com.amap.api.col.3l.v9$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class b extends ThreadLocal<Charset> {
        b() {
        }

        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return a();
        }
    }

    private v9() {
        this.f9301c = 1;
        this.f9302d = null;
        this.f9303e = 0;
        this.f9304f = false;
        this.f9305g = false;
        this.f9307i = new int[16];
        this.f9308j = 0;
        this.f9309k = 0;
        this.f9310l = false;
        this.f9311m = f9297o.newEncoder();
        this.f9300b = 1024;
        this.f9299a = B(1024);
    }

    private int A() {
        return this.f9299a.capacity() - this.f9300b;
    }

    private static ByteBuffer B(int i4) {
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private byte[] C(int i4, int i5) {
        D();
        byte[] bArr = new byte[i5];
        this.f9299a.position(i4);
        this.f9299a.get(bArr);
        return bArr;
    }

    private void D() {
        if (!this.f9305g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void E(int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            ByteBuffer byteBuffer = this.f9299a;
            int i6 = this.f9300b - 1;
            this.f9300b = i6;
            byteBuffer.put(i6, (byte) 0);
        }
    }

    private void F() {
        if (this.f9304f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void G(int i4) {
        ByteBuffer byteBuffer = this.f9299a;
        int i5 = this.f9300b - 4;
        this.f9300b = i5;
        byteBuffer.putInt(i5, i4);
    }

    private void H(int i4) {
        x(4, 0);
        G(i4);
    }

    private void I(int i4) {
        this.f9302d[i4] = A();
    }

    private void k(long j4) {
        ByteBuffer byteBuffer = this.f9299a;
        int i4 = this.f9300b - 8;
        this.f9300b = i4;
        byteBuffer.putLong(i4, j4);
    }

    private void l(short s3) {
        ByteBuffer byteBuffer = this.f9299a;
        int i4 = this.f9300b - 2;
        this.f9300b = i4;
        byteBuffer.putShort(i4, s3);
    }

    private static ByteBuffer o(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i4 = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer B = B(i4);
            B.position(i4 - capacity);
            B.put(byteBuffer);
            return B;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void p(byte b4) {
        ByteBuffer byteBuffer = this.f9299a;
        int i4 = this.f9300b - 1;
        this.f9300b = i4;
        byteBuffer.put(i4, b4);
    }

    private void s(long j4) {
        x(8, 0);
        k(j4);
    }

    private void t(short s3) {
        x(2, 0);
        l(s3);
    }

    private void u(boolean z3) {
        ByteBuffer byteBuffer = this.f9299a;
        int i4 = this.f9300b - 1;
        this.f9300b = i4;
        byteBuffer.put(i4, z3 ? (byte) 1 : (byte) 0);
    }

    private int v(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        d((byte) 0);
        h(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f9299a;
        int i4 = this.f9300b - remaining;
        this.f9300b = i4;
        byteBuffer2.position(i4);
        this.f9299a.put(byteBuffer);
        return a();
    }

    private void x(int i4, int i5) {
        if (i4 > this.f9301c) {
            this.f9301c = i4;
        }
        int capacity = ((((this.f9299a.capacity() - this.f9300b) + i5) ^ (-1)) + 1) & (i4 - 1);
        while (this.f9300b < capacity + i4 + i5) {
            int capacity2 = this.f9299a.capacity();
            ByteBuffer o4 = o(this.f9299a);
            this.f9299a = o4;
            this.f9300b += o4.capacity() - capacity2;
        }
        E(capacity);
    }

    private void y(boolean z3) {
        x(1, 0);
        u(z3);
    }

    public final int a() {
        if (this.f9304f) {
            this.f9304f = false;
            G(this.f9309k);
            return A();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int b(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.f9311m.maxBytesPerChar());
        ByteBuffer byteBuffer = this.f9312n;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.f9312n = ByteBuffer.allocate(Math.max(128, length));
        }
        this.f9312n.clear();
        CoderResult encode = this.f9311m.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.f9312n, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e4) {
                throw new Error(e4);
            }
        }
        this.f9312n.flip();
        return v(this.f9312n);
    }

    public final v9 c(ByteBuffer byteBuffer) {
        this.f9299a = byteBuffer;
        byteBuffer.clear();
        this.f9299a.order(ByteOrder.LITTLE_ENDIAN);
        this.f9301c = 1;
        this.f9300b = this.f9299a.capacity();
        this.f9303e = 0;
        this.f9304f = false;
        this.f9305g = false;
        this.f9306h = 0;
        this.f9308j = 0;
        this.f9309k = 0;
        return this;
    }

    public final void d(byte b4) {
        x(1, 0);
        p(b4);
    }

    public final void e(int i4) {
        x(4, 0);
        if (!f9298p && i4 > A()) {
            throw new AssertionError();
        }
        G((A() - i4) + 4);
    }

    public final void f(int i4, byte b4) {
        if (this.f9310l || b4 != 0) {
            d(b4);
            I(i4);
        }
    }

    public final void g(int i4, int i5) {
        if (this.f9310l || i5 != 0) {
            H(i5);
            I(i4);
        }
    }

    public final void h(int i4, int i5, int i6) {
        F();
        this.f9309k = i5;
        int i7 = i4 * i5;
        x(4, i7);
        x(i6, i7);
        this.f9304f = true;
    }

    public final void i(int i4, long j4) {
        if (this.f9310l || j4 != 0) {
            s(j4);
            I(i4);
        }
    }

    public final void j(int i4, short s3) {
        if (this.f9310l || s3 != 0) {
            t(s3);
            I(i4);
        }
    }

    public final void m(boolean z3) {
        if (this.f9310l || z3) {
            y(z3);
            I(0);
        }
    }

    public final int n() {
        int i4;
        int i5;
        if (this.f9302d != null && this.f9304f) {
            H(0);
            int A = A();
            for (int i6 = this.f9303e - 1; i6 >= 0; i6--) {
                int[] iArr = this.f9302d;
                t((short) (iArr[i6] != 0 ? A - iArr[i6] : 0));
            }
            t((short) (A - this.f9306h));
            t((short) ((this.f9303e + 2) * 2));
            int i7 = 0;
            loop1: while (true) {
                if (i7 >= this.f9308j) {
                    i4 = 0;
                    break;
                }
                int capacity = this.f9299a.capacity() - this.f9307i[i7];
                int i8 = this.f9300b;
                short s3 = this.f9299a.getShort(capacity);
                if (s3 == this.f9299a.getShort(i8)) {
                    while (i5 < s3) {
                        i5 = this.f9299a.getShort(capacity + i5) == this.f9299a.getShort(i8 + i5) ? i5 + 2 : 2;
                    }
                    i4 = this.f9307i[i7];
                    break loop1;
                }
                i7++;
            }
            if (i4 != 0) {
                int capacity2 = this.f9299a.capacity() - A;
                this.f9300b = capacity2;
                this.f9299a.putInt(capacity2, i4 - A);
            } else {
                int i9 = this.f9308j;
                int[] iArr2 = this.f9307i;
                if (i9 == iArr2.length) {
                    this.f9307i = Arrays.copyOf(iArr2, i9 * 2);
                }
                int[] iArr3 = this.f9307i;
                int i10 = this.f9308j;
                this.f9308j = i10 + 1;
                iArr3[i10] = A();
                ByteBuffer byteBuffer = this.f9299a;
                byteBuffer.putInt(byteBuffer.capacity() - A, A() - A);
            }
            this.f9304f = false;
            return A;
        }
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    public final void q(int i4) {
        F();
        int[] iArr = this.f9302d;
        if (iArr == null || iArr.length < i4) {
            this.f9302d = new int[i4];
        }
        this.f9303e = i4;
        Arrays.fill(this.f9302d, 0, i4, 0);
        this.f9304f = true;
        this.f9306h = A();
    }

    public final void r(int i4, int i5) {
        if (this.f9310l || i5 != 0) {
            e(i5);
            I(i4);
        }
    }

    public final void w(int i4) {
        x(this.f9301c, 4);
        e(i4);
        this.f9299a.position(this.f9300b);
        this.f9305g = true;
    }

    public final byte[] z() {
        return C(this.f9300b, this.f9299a.capacity() - this.f9300b);
    }

    public v9(ByteBuffer byteBuffer) {
        this.f9301c = 1;
        this.f9302d = null;
        this.f9303e = 0;
        this.f9304f = false;
        this.f9305g = false;
        this.f9307i = new int[16];
        this.f9308j = 0;
        this.f9309k = 0;
        this.f9310l = false;
        this.f9311m = f9297o.newEncoder();
        c(byteBuffer);
    }
}
