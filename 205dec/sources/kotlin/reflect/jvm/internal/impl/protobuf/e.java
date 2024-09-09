package kotlin.reflect.jvm.internal.impl.protobuf;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: CodedInputStream.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f57637a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f57638b;

    /* renamed from: c  reason: collision with root package name */
    private int f57639c;

    /* renamed from: d  reason: collision with root package name */
    private int f57640d;

    /* renamed from: e  reason: collision with root package name */
    private int f57641e;

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f57642f;

    /* renamed from: g  reason: collision with root package name */
    private int f57643g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f57644h;

    /* renamed from: i  reason: collision with root package name */
    private int f57645i;

    /* renamed from: j  reason: collision with root package name */
    private int f57646j;

    /* renamed from: k  reason: collision with root package name */
    private int f57647k;

    /* renamed from: l  reason: collision with root package name */
    private int f57648l;

    /* renamed from: m  reason: collision with root package name */
    private int f57649m;

    /* renamed from: n  reason: collision with root package name */
    private a f57650n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        void a();
    }

    private e(InputStream inputStream) {
        this.f57644h = false;
        this.f57646j = Integer.MAX_VALUE;
        this.f57648l = 64;
        this.f57649m = TTAdConstant.KEY_CLICK_AREA;
        this.f57650n = null;
        this.f57637a = new byte[4096];
        this.f57639c = 0;
        this.f57641e = 0;
        this.f57645i = 0;
        this.f57642f = inputStream;
        this.f57638b = false;
    }

    public static int B(int i4, InputStream inputStream) throws IOException {
        if ((i4 & 128) == 0) {
            return i4;
        }
        int i5 = i4 & 127;
        int i6 = 7;
        while (i6 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i5 |= (read & 127) << i6;
            if ((read & 128) == 0) {
                return i5;
            }
            i6 += 7;
        }
        while (i6 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i5;
            }
            i6 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void N() {
        int i4 = this.f57639c + this.f57640d;
        this.f57639c = i4;
        int i5 = this.f57645i + i4;
        int i6 = this.f57646j;
        if (i5 > i6) {
            int i7 = i5 - i6;
            this.f57640d = i7;
            this.f57639c = i4 - i7;
            return;
        }
        this.f57640d = 0;
    }

    private void O(int i4) throws IOException {
        if (!T(i4)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void S(int i4) throws IOException {
        if (i4 >= 0) {
            int i5 = this.f57645i;
            int i6 = this.f57641e;
            int i7 = i5 + i6 + i4;
            int i8 = this.f57646j;
            if (i7 <= i8) {
                int i9 = this.f57639c;
                int i10 = i9 - i6;
                this.f57641e = i9;
                O(1);
                while (true) {
                    int i11 = i4 - i10;
                    int i12 = this.f57639c;
                    if (i11 > i12) {
                        i10 += i12;
                        this.f57641e = i12;
                        O(1);
                    } else {
                        this.f57641e = i11;
                        return;
                    }
                }
            } else {
                R((i8 - i5) - i6);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean T(int i4) throws IOException {
        int i5 = this.f57641e;
        if (i5 + i4 > this.f57639c) {
            if (this.f57645i + i5 + i4 > this.f57646j) {
                return false;
            }
            a aVar = this.f57650n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f57642f != null) {
                int i6 = this.f57641e;
                if (i6 > 0) {
                    int i7 = this.f57639c;
                    if (i7 > i6) {
                        byte[] bArr = this.f57637a;
                        System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                    }
                    this.f57645i += i6;
                    this.f57639c -= i6;
                    this.f57641e = 0;
                }
                InputStream inputStream = this.f57642f;
                byte[] bArr2 = this.f57637a;
                int i8 = this.f57639c;
                int read = inputStream.read(bArr2, i8, bArr2.length - i8);
                if (read == 0 || read < -1 || read > this.f57637a.length) {
                    StringBuilder sb = new StringBuilder(102);
                    sb.append("InputStream#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read > 0) {
                    this.f57639c += read;
                    if ((this.f57645i + i4) - this.f57649m <= 0) {
                        N();
                        if (this.f57639c >= i4) {
                            return true;
                        }
                        return T(i4);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i4);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    public static int b(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public static long c(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    private void d(int i4) throws IOException {
        if (this.f57639c - this.f57641e < i4) {
            O(i4);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e h(m mVar) {
        e eVar = new e(mVar);
        try {
            eVar.j(mVar.size());
            return eVar;
        } catch (InvalidProtocolBufferException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    private byte[] x(int i4) throws IOException {
        if (i4 <= 0) {
            if (i4 == 0) {
                return h.f57662a;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i5 = this.f57645i;
        int i6 = this.f57641e;
        int i7 = i5 + i6 + i4;
        int i8 = this.f57646j;
        if (i7 > i8) {
            R((i8 - i5) - i6);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i4 < 4096) {
            byte[] bArr = new byte[i4];
            int i9 = this.f57639c - i6;
            System.arraycopy(this.f57637a, i6, bArr, 0, i9);
            this.f57641e = this.f57639c;
            int i10 = i4 - i9;
            d(i10);
            System.arraycopy(this.f57637a, 0, bArr, i9, i10);
            this.f57641e = i10;
            return bArr;
        } else {
            int i11 = this.f57639c;
            this.f57645i = i5 + i11;
            this.f57641e = 0;
            this.f57639c = 0;
            int i12 = i11 - i6;
            int i13 = i4 - i12;
            ArrayList<byte[]> arrayList = new ArrayList();
            while (i13 > 0) {
                int min = Math.min(i13, 4096);
                byte[] bArr2 = new byte[min];
                int i14 = 0;
                while (i14 < min) {
                    InputStream inputStream = this.f57642f;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i14, min - i14);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.f57645i += read;
                    i14 += read;
                }
                i13 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(this.f57637a, i6, bArr3, 0, i12);
            for (byte[] bArr4 : arrayList) {
                System.arraycopy(bArr4, 0, bArr3, i12, bArr4.length);
                i12 += bArr4.length;
            }
            return bArr3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f57641e
            int r1 = r9.f57639c
            if (r1 != r0) goto L8
            goto L7b
        L8:
            byte[] r2 = r9.f57637a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L13
            r9.f57641e = r3
            return r0
        L13:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L19
            goto L7b
        L19:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2c
            r5 = -128(0xffffffffffffff80, double:NaN)
        L29:
            long r3 = r3 ^ r5
            int r0 = (int) r3
            goto L81
        L2c:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L3e
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L3c:
            r1 = r3
            goto L81
        L3e:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L4e
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L29
        L4e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L3c
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L81
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3c
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L81
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3c
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L81
        L7b:
            long r0 = r9.D()
            int r1 = (int) r0
            return r1
        L81:
            r9.f57641e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.A():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if (r2[r0] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long C() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.C():long");
    }

    long D() throws IOException {
        long j4 = 0;
        for (int i4 = 0; i4 < 64; i4 += 7) {
            byte w3 = w();
            j4 |= (w3 & Byte.MAX_VALUE) << i4;
            if ((w3 & 128) == 0) {
                return j4;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int A = A();
        int i4 = this.f57639c;
        int i5 = this.f57641e;
        if (A > i4 - i5 || A <= 0) {
            return A == 0 ? "" : new String(x(A), "UTF-8");
        }
        String str = new String(this.f57637a, i5, A, "UTF-8");
        this.f57641e += A;
        return str;
    }

    public String J() throws IOException {
        byte[] x3;
        int A = A();
        int i4 = this.f57641e;
        if (A <= this.f57639c - i4 && A > 0) {
            x3 = this.f57637a;
            this.f57641e = i4 + A;
        } else if (A == 0) {
            return "";
        } else {
            x3 = x(A);
            i4 = 0;
        }
        if (u.f(x3, i4, i4 + A)) {
            return new String(x3, i4, A, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int K() throws IOException {
        if (f()) {
            this.f57643g = 0;
            return 0;
        }
        int A = A();
        this.f57643g = A;
        if (WireFormat.a(A) != 0) {
            return this.f57643g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i4, CodedOutputStream codedOutputStream) throws IOException {
        int b4 = WireFormat.b(i4);
        if (b4 == 0) {
            long t3 = t();
            codedOutputStream.o0(i4);
            codedOutputStream.z0(t3);
            return true;
        } else if (b4 == 1) {
            long z3 = z();
            codedOutputStream.o0(i4);
            codedOutputStream.V(z3);
            return true;
        } else if (b4 == 2) {
            d l4 = l();
            codedOutputStream.o0(i4);
            codedOutputStream.P(l4);
            return true;
        } else if (b4 == 3) {
            codedOutputStream.o0(i4);
            Q(codedOutputStream);
            int c4 = WireFormat.c(WireFormat.a(i4), 4);
            a(c4);
            codedOutputStream.o0(c4);
            return true;
        } else if (b4 != 4) {
            if (b4 == 5) {
                int y3 = y();
                codedOutputStream.o0(i4);
                codedOutputStream.U(y3);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, codedOutputStream));
    }

    public void R(int i4) throws IOException {
        int i5 = this.f57639c;
        int i6 = this.f57641e;
        if (i4 <= i5 - i6 && i4 >= 0) {
            this.f57641e = i6 + i4;
        } else {
            S(i4);
        }
    }

    public void a(int i4) throws InvalidProtocolBufferException {
        if (this.f57643g != i4) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int e() {
        int i4 = this.f57646j;
        if (i4 == Integer.MAX_VALUE) {
            return -1;
        }
        return i4 - (this.f57645i + this.f57641e);
    }

    public boolean f() throws IOException {
        return this.f57641e == this.f57639c && !T(1);
    }

    public void i(int i4) {
        this.f57646j = i4;
        N();
    }

    public int j(int i4) throws InvalidProtocolBufferException {
        if (i4 >= 0) {
            int i5 = i4 + this.f57645i + this.f57641e;
            int i6 = this.f57646j;
            if (i5 <= i6) {
                this.f57646j = i5;
                N();
                return i6;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public d l() throws IOException {
        int A = A();
        int i4 = this.f57639c;
        int i5 = this.f57641e;
        if (A > i4 - i5 || A <= 0) {
            if (A == 0) {
                return d.f57629a;
            }
            return new m(x(A));
        }
        d cVar = (this.f57638b && this.f57644h) ? new c(this.f57637a, this.f57641e, A) : d.l(this.f57637a, i5, A);
        this.f57641e += A;
        return cVar;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i4, n.a aVar, f fVar) throws IOException {
        int i5 = this.f57647k;
        if (i5 < this.f57648l) {
            this.f57647k = i5 + 1;
            aVar.g(this, fVar);
            a(WireFormat.c(i4, 4));
            this.f57647k--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends n> T u(p<T> pVar, f fVar) throws IOException {
        int A = A();
        if (this.f57647k < this.f57648l) {
            int j4 = j(A);
            this.f57647k++;
            T c4 = pVar.c(this, fVar);
            a(0);
            this.f57647k--;
            i(j4);
            return c4;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void v(n.a aVar, f fVar) throws IOException {
        int A = A();
        if (this.f57647k < this.f57648l) {
            int j4 = j(A);
            this.f57647k++;
            aVar.g(this, fVar);
            a(0);
            this.f57647k--;
            i(j4);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte w() throws IOException {
        if (this.f57641e == this.f57639c) {
            O(1);
        }
        byte[] bArr = this.f57637a;
        int i4 = this.f57641e;
        this.f57641e = i4 + 1;
        return bArr[i4];
    }

    public int y() throws IOException {
        int i4 = this.f57641e;
        if (this.f57639c - i4 < 4) {
            O(4);
            i4 = this.f57641e;
        }
        byte[] bArr = this.f57637a;
        this.f57641e = i4 + 4;
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i4 = this.f57641e;
        if (this.f57639c - i4 < 8) {
            O(8);
            i4 = this.f57641e;
        }
        byte[] bArr = this.f57637a;
        this.f57641e = i4 + 8;
        return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
    }

    private e(m mVar) {
        this.f57644h = false;
        this.f57646j = Integer.MAX_VALUE;
        this.f57648l = 64;
        this.f57649m = TTAdConstant.KEY_CLICK_AREA;
        this.f57650n = null;
        this.f57637a = mVar.f57673c;
        int F = mVar.F();
        this.f57641e = F;
        this.f57639c = F + mVar.size();
        this.f57645i = -this.f57641e;
        this.f57642f = null;
        this.f57638b = true;
    }
}
