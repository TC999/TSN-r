package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CodedOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f57594a;

    /* renamed from: b  reason: collision with root package name */
    private final int f57595b;

    /* renamed from: e  reason: collision with root package name */
    private final OutputStream f57598e;

    /* renamed from: d  reason: collision with root package name */
    private int f57597d = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f57596c = 0;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f57598e = outputStream;
        this.f57594a = bArr;
        this.f57595b = bArr.length;
    }

    public static int A(int i4, long j4) {
        return D(i4) + B(j4);
    }

    public static int B(long j4) {
        return w(H(j4));
    }

    public static int C(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return v(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("UTF-8 not supported.", e4);
        }
    }

    public static int D(int i4) {
        return v(WireFormat.c(i4, 0));
    }

    public static int E(int i4) {
        return v(i4);
    }

    public static int F(long j4) {
        return w(j4);
    }

    public static int G(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public static long H(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static CodedOutputStream J(OutputStream outputStream, int i4) {
        return new CodedOutputStream(outputStream, new byte[i4]);
    }

    private void K() throws IOException {
        OutputStream outputStream = this.f57598e;
        if (outputStream != null) {
            outputStream.write(this.f57594a, 0, this.f57596c);
            this.f57596c = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public static int a(int i4, boolean z3) {
        return D(i4) + b(z3);
    }

    public static int b(boolean z3) {
        return 1;
    }

    public static int c(byte[] bArr) {
        return v(bArr.length) + bArr.length;
    }

    public static int d(int i4, d dVar) {
        return D(i4) + e(dVar);
    }

    public static int e(d dVar) {
        return v(dVar.size()) + dVar.size();
    }

    public static int f(int i4, double d4) {
        return D(i4) + g(d4);
    }

    public static int g(double d4) {
        return 8;
    }

    public static int h(int i4, int i5) {
        return D(i4) + i(i5);
    }

    public static int i(int i4) {
        return p(i4);
    }

    public static int j(int i4) {
        return 4;
    }

    public static int k(long j4) {
        return 8;
    }

    public static int l(int i4, float f4) {
        return D(i4) + m(f4);
    }

    public static int m(float f4) {
        return 4;
    }

    public static int n(n nVar) {
        return nVar.getSerializedSize();
    }

    public static int o(int i4, int i5) {
        return D(i4) + p(i5);
    }

    public static int p(int i4) {
        if (i4 >= 0) {
            return v(i4);
        }
        return 10;
    }

    public static int q(long j4) {
        return w(j4);
    }

    public static int r(j jVar) {
        int b4 = jVar.b();
        return v(b4) + b4;
    }

    public static int s(int i4, n nVar) {
        return D(i4) + t(nVar);
    }

    public static int t(n nVar) {
        int serializedSize = nVar.getSerializedSize();
        return v(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i4) {
        if (i4 > 4096) {
            return 4096;
        }
        return i4;
    }

    public static int v(int i4) {
        if ((i4 & (-128)) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        return (i4 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int w(long j4) {
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (((-16384) & j4) == 0) {
            return 2;
        }
        if (((-2097152) & j4) == 0) {
            return 3;
        }
        if (((-268435456) & j4) == 0) {
            return 4;
        }
        if (((-34359738368L) & j4) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j4) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j4) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j4) == 0) {
            return 8;
        }
        return (j4 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int x(int i4) {
        return 4;
    }

    public static int y(long j4) {
        return 8;
    }

    public static int z(int i4) {
        return v(G(i4));
    }

    public void I() throws IOException {
        if (this.f57598e != null) {
            K();
        }
    }

    public void L(int i4, boolean z3) throws IOException {
        w0(i4, 0);
        M(z3);
    }

    public void M(boolean z3) throws IOException {
        h0(z3 ? 1 : 0);
    }

    public void N(byte[] bArr) throws IOException {
        o0(bArr.length);
        k0(bArr);
    }

    public void O(int i4, d dVar) throws IOException {
        w0(i4, 2);
        P(dVar);
    }

    public void P(d dVar) throws IOException {
        o0(dVar.size());
        i0(dVar);
    }

    public void Q(int i4, double d4) throws IOException {
        w0(i4, 1);
        R(d4);
    }

    public void R(double d4) throws IOException {
        n0(Double.doubleToRawLongBits(d4));
    }

    public void S(int i4, int i5) throws IOException {
        w0(i4, 0);
        T(i5);
    }

    public void T(int i4) throws IOException {
        b0(i4);
    }

    public void U(int i4) throws IOException {
        m0(i4);
    }

    public void V(long j4) throws IOException {
        n0(j4);
    }

    public void W(int i4, float f4) throws IOException {
        w0(i4, 5);
        X(f4);
    }

    public void X(float f4) throws IOException {
        m0(Float.floatToRawIntBits(f4));
    }

    public void Y(int i4, n nVar) throws IOException {
        w0(i4, 3);
        Z(nVar);
        w0(i4, 4);
    }

    public void Z(n nVar) throws IOException {
        nVar.writeTo(this);
    }

    public void a0(int i4, int i5) throws IOException {
        w0(i4, 0);
        b0(i5);
    }

    public void b0(int i4) throws IOException {
        if (i4 >= 0) {
            o0(i4);
        } else {
            p0(i4);
        }
    }

    public void c0(long j4) throws IOException {
        p0(j4);
    }

    public void d0(int i4, n nVar) throws IOException {
        w0(i4, 2);
        e0(nVar);
    }

    public void e0(n nVar) throws IOException {
        o0(nVar.getSerializedSize());
        nVar.writeTo(this);
    }

    public void f0(int i4, n nVar) throws IOException {
        w0(1, 3);
        x0(2, i4);
        d0(3, nVar);
        w0(1, 4);
    }

    public void g0(byte b4) throws IOException {
        if (this.f57596c == this.f57595b) {
            K();
        }
        byte[] bArr = this.f57594a;
        int i4 = this.f57596c;
        this.f57596c = i4 + 1;
        bArr[i4] = b4;
        this.f57597d++;
    }

    public void h0(int i4) throws IOException {
        g0((byte) i4);
    }

    public void i0(d dVar) throws IOException {
        j0(dVar, 0, dVar.size());
    }

    public void j0(d dVar, int i4, int i5) throws IOException {
        int i6 = this.f57595b;
        int i7 = this.f57596c;
        if (i6 - i7 >= i5) {
            dVar.n(this.f57594a, i4, i7, i5);
            this.f57596c += i5;
            this.f57597d += i5;
            return;
        }
        int i8 = i6 - i7;
        dVar.n(this.f57594a, i4, i7, i8);
        int i9 = i4 + i8;
        int i10 = i5 - i8;
        this.f57596c = this.f57595b;
        this.f57597d += i8;
        K();
        if (i10 <= this.f57595b) {
            dVar.n(this.f57594a, i9, 0, i10);
            this.f57596c = i10;
        } else {
            dVar.B(this.f57598e, i9, i10);
        }
        this.f57597d += i10;
    }

    public void k0(byte[] bArr) throws IOException {
        l0(bArr, 0, bArr.length);
    }

    public void l0(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.f57595b;
        int i7 = this.f57596c;
        if (i6 - i7 >= i5) {
            System.arraycopy(bArr, i4, this.f57594a, i7, i5);
            this.f57596c += i5;
            this.f57597d += i5;
            return;
        }
        int i8 = i6 - i7;
        System.arraycopy(bArr, i4, this.f57594a, i7, i8);
        int i9 = i4 + i8;
        int i10 = i5 - i8;
        this.f57596c = this.f57595b;
        this.f57597d += i8;
        K();
        if (i10 <= this.f57595b) {
            System.arraycopy(bArr, i9, this.f57594a, 0, i10);
            this.f57596c = i10;
        } else {
            this.f57598e.write(bArr, i9, i10);
        }
        this.f57597d += i10;
    }

    public void m0(int i4) throws IOException {
        h0(i4 & 255);
        h0((i4 >> 8) & 255);
        h0((i4 >> 16) & 255);
        h0((i4 >> 24) & 255);
    }

    public void n0(long j4) throws IOException {
        h0(((int) j4) & 255);
        h0(((int) (j4 >> 8)) & 255);
        h0(((int) (j4 >> 16)) & 255);
        h0(((int) (j4 >> 24)) & 255);
        h0(((int) (j4 >> 32)) & 255);
        h0(((int) (j4 >> 40)) & 255);
        h0(((int) (j4 >> 48)) & 255);
        h0(((int) (j4 >> 56)) & 255);
    }

    public void o0(int i4) throws IOException {
        while ((i4 & (-128)) != 0) {
            h0((i4 & 127) | 128);
            i4 >>>= 7;
        }
        h0(i4);
    }

    public void p0(long j4) throws IOException {
        while (((-128) & j4) != 0) {
            h0((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        h0((int) j4);
    }

    public void q0(int i4) throws IOException {
        m0(i4);
    }

    public void r0(long j4) throws IOException {
        n0(j4);
    }

    public void s0(int i4) throws IOException {
        o0(G(i4));
    }

    public void t0(int i4, long j4) throws IOException {
        w0(i4, 0);
        u0(j4);
    }

    public void u0(long j4) throws IOException {
        p0(H(j4));
    }

    public void v0(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        o0(bytes.length);
        k0(bytes);
    }

    public void w0(int i4, int i5) throws IOException {
        o0(WireFormat.c(i4, i5));
    }

    public void x0(int i4, int i5) throws IOException {
        w0(i4, 0);
        y0(i5);
    }

    public void y0(int i4) throws IOException {
        o0(i4);
    }

    public void z0(long j4) throws IOException {
        p0(j4);
    }
}
