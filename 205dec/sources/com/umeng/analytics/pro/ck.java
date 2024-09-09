package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TCompactProtocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ck extends cq {

    /* renamed from: d  reason: collision with root package name */
    private static final cv f52784d = new cv("");

    /* renamed from: e  reason: collision with root package name */
    private static final cl f52785e = new cl("", (byte) 0, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f52786f;

    /* renamed from: h  reason: collision with root package name */
    private static final byte f52787h = -126;

    /* renamed from: i  reason: collision with root package name */
    private static final byte f52788i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final byte f52789j = 31;

    /* renamed from: k  reason: collision with root package name */
    private static final byte f52790k = -32;

    /* renamed from: l  reason: collision with root package name */
    private static final int f52791l = 5;

    /* renamed from: a  reason: collision with root package name */
    byte[] f52792a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f52793b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f52794c;

    /* renamed from: m  reason: collision with root package name */
    private bp f52795m;

    /* renamed from: n  reason: collision with root package name */
    private short f52796n;

    /* renamed from: o  reason: collision with root package name */
    private cl f52797o;

    /* renamed from: p  reason: collision with root package name */
    private Boolean f52798p;

    /* renamed from: q  reason: collision with root package name */
    private final long f52799q;

    /* renamed from: r  reason: collision with root package name */
    private byte[] f52800r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TCompactProtocol.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte f52802a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final byte f52803b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final byte f52804c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final byte f52805d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final byte f52806e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final byte f52807f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final byte f52808g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final byte f52809h = 8;

        /* renamed from: i  reason: collision with root package name */
        public static final byte f52810i = 9;

        /* renamed from: j  reason: collision with root package name */
        public static final byte f52811j = 10;

        /* renamed from: k  reason: collision with root package name */
        public static final byte f52812k = 11;

        /* renamed from: l  reason: collision with root package name */
        public static final byte f52813l = 12;

        private b() {
        }
    }

    static {
        f52786f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public ck(de deVar, long j4) {
        super(deVar);
        this.f52795m = new bp(15);
        this.f52796n = (short) 0;
        this.f52797o = null;
        this.f52798p = null;
        this.f52792a = new byte[5];
        this.f52793b = new byte[10];
        this.f52800r = new byte[1];
        this.f52794c = new byte[1];
        this.f52799q = j4;
    }

    private int E() throws bx {
        int i4 = 0;
        if (this.f52829g.h() >= 5) {
            byte[] f4 = this.f52829g.f();
            int g4 = this.f52829g.g();
            int i5 = 0;
            int i6 = 0;
            while (true) {
                byte b4 = f4[g4 + i4];
                i5 |= (b4 & Byte.MAX_VALUE) << i6;
                if ((b4 & 128) != 128) {
                    this.f52829g.a(i4 + 1);
                    return i5;
                }
                i6 += 7;
                i4++;
            }
        } else {
            int i7 = 0;
            while (true) {
                byte u3 = u();
                i4 |= (u3 & Byte.MAX_VALUE) << i7;
                if ((u3 & 128) != 128) {
                    return i4;
                }
                i7 += 7;
            }
        }
    }

    private long F() throws bx {
        byte u3;
        byte b4;
        int i4 = 0;
        long j4 = 0;
        if (this.f52829g.h() >= 10) {
            byte[] f4 = this.f52829g.f();
            int g4 = this.f52829g.g();
            long j5 = 0;
            int i5 = 0;
            while (true) {
                j5 |= (b4 & Byte.MAX_VALUE) << i5;
                if ((f4[g4 + i4] & 128) != 128) {
                    this.f52829g.a(i4 + 1);
                    return j5;
                }
                i5 += 7;
                i4++;
            }
        } else {
            while (true) {
                j4 |= (u3 & Byte.MAX_VALUE) << i4;
                if ((u() & 128) != 128) {
                    return j4;
                }
                i4 += 7;
            }
        }
    }

    private int c(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    private long c(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    private boolean c(byte b4) {
        int i4 = b4 & 15;
        return i4 == 1 || i4 == 2;
    }

    private long d(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    private byte[] e(int i4) throws bx {
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i4];
        this.f52829g.d(bArr, 0, i4);
        return bArr;
    }

    private void f(int i4) throws cr {
        if (i4 >= 0) {
            long j4 = this.f52799q;
            if (j4 == -1 || i4 <= j4) {
                return;
            }
            throw new cr("Length exceeded max allowed: " + i4);
        }
        throw new cr("Negative length: " + i4);
    }

    private int g(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    @Override // com.umeng.analytics.pro.cq
    public ByteBuffer A() throws bx {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f52829g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void B() {
        this.f52795m.c();
        this.f52796n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cq
    public void a() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(co coVar) throws bx {
        b((byte) -126);
        d(((coVar.f52823b << 5) & (-32)) | 1);
        b(coVar.f52824c);
        a(coVar.f52822a);
    }

    @Override // com.umeng.analytics.pro.cq
    public void b() throws bx {
        this.f52796n = this.f52795m.a();
    }

    @Override // com.umeng.analytics.pro.cq
    public void c() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void d() throws bx {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cq
    public void e() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void f() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void g() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public co h() throws bx {
        byte u3 = u();
        if (u3 == -126) {
            byte u4 = u();
            byte b4 = (byte) (u4 & 31);
            if (b4 == 1) {
                int E = E();
                return new co(z(), (byte) ((u4 >> 5) & 3), E);
            }
            throw new cr("Expected version 1 but got " + ((int) b4));
        }
        throw new cr("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u3));
    }

    @Override // com.umeng.analytics.pro.cq
    public void i() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public cv j() throws bx {
        this.f52795m.a(this.f52796n);
        this.f52796n = (short) 0;
        return f52784d;
    }

    @Override // com.umeng.analytics.pro.cq
    public void k() throws bx {
        this.f52796n = this.f52795m.a();
    }

    @Override // com.umeng.analytics.pro.cq
    public cl l() throws bx {
        short s3;
        byte u3 = u();
        if (u3 == 0) {
            return f52785e;
        }
        short s4 = (short) ((u3 & 240) >> 4);
        if (s4 == 0) {
            s3 = v();
        } else {
            s3 = (short) (this.f52796n + s4);
        }
        byte b4 = (byte) (u3 & 15);
        cl clVar = new cl("", d(b4), s3);
        if (c(u3)) {
            this.f52798p = b4 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f52796n = clVar.f52816c;
        return clVar;
    }

    @Override // com.umeng.analytics.pro.cq
    public void m() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public cn n() throws bx {
        int E = E();
        byte u3 = E == 0 ? (byte) 0 : u();
        return new cn(d((byte) (u3 >> 4)), d((byte) (u3 & 15)), E);
    }

    @Override // com.umeng.analytics.pro.cq
    public void o() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public cm p() throws bx {
        byte u3 = u();
        int i4 = (u3 >> 4) & 15;
        if (i4 == 15) {
            i4 = E();
        }
        return new cm(d(u3), i4);
    }

    @Override // com.umeng.analytics.pro.cq
    public void q() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public cu r() throws bx {
        return new cu(p());
    }

    @Override // com.umeng.analytics.pro.cq
    public void s() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public boolean t() throws bx {
        Boolean bool = this.f52798p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f52798p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.cq
    public byte u() throws bx {
        if (this.f52829g.h() > 0) {
            byte b4 = this.f52829g.f()[this.f52829g.g()];
            this.f52829g.a(1);
            return b4;
        }
        this.f52829g.d(this.f52794c, 0, 1);
        return this.f52794c[0];
    }

    @Override // com.umeng.analytics.pro.cq
    public short v() throws bx {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.cq
    public int w() throws bx {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.cq
    public long x() throws bx {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.cq
    public double y() throws bx {
        byte[] bArr = new byte[8];
        this.f52829g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.cq
    public String z() throws bx {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f52829g.h() >= E) {
                String str = new String(this.f52829g.f(), this.f52829g.g(), E, "UTF-8");
                this.f52829g.a(E);
                return str;
            }
            return new String(e(E), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bx("UTF-8 not supported!");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TCompactProtocol.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements cs {

        /* renamed from: a  reason: collision with root package name */
        private final long f52801a;

        public a() {
            this.f52801a = -1L;
        }

        @Override // com.umeng.analytics.pro.cs
        public cq a(de deVar) {
            return new ck(deVar, this.f52801a);
        }

        public a(int i4) {
            this.f52801a = i4;
        }
    }

    private void b(int i4) throws bx {
        int i5 = 0;
        while ((i4 & (-128)) != 0) {
            this.f52792a[i5] = (byte) ((i4 & 127) | 128);
            i4 >>>= 7;
            i5++;
        }
        byte[] bArr = this.f52792a;
        bArr[i5] = (byte) i4;
        this.f52829g.b(bArr, 0, i5 + 1);
    }

    private void d(int i4) throws bx {
        b((byte) i4);
    }

    private byte d(byte b4) throws cr {
        byte b5 = (byte) (b4 & 15);
        switch (b5) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new cr("don't know what type: " + ((int) b5));
        }
    }

    private byte e(byte b4) {
        return f52786f[b4];
    }

    private void b(long j4) throws bx {
        int i4 = 0;
        while (((-128) & j4) != 0) {
            this.f52793b[i4] = (byte) ((127 & j4) | 128);
            j4 >>>= 7;
            i4++;
        }
        byte[] bArr = this.f52793b;
        bArr[i4] = (byte) j4;
        this.f52829g.b(bArr, 0, i4 + 1);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cv cvVar) throws bx {
        this.f52795m.a(this.f52796n);
        this.f52796n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cl clVar) throws bx {
        if (clVar.f52815b == 2) {
            this.f52797o = clVar;
        } else {
            a(clVar, (byte) -1);
        }
    }

    private void b(byte b4) throws bx {
        byte[] bArr = this.f52800r;
        bArr[0] = b4;
        this.f52829g.b(bArr);
    }

    private void a(cl clVar, byte b4) throws bx {
        if (b4 == -1) {
            b4 = e(clVar.f52815b);
        }
        short s3 = clVar.f52816c;
        short s4 = this.f52796n;
        if (s3 > s4 && s3 - s4 <= 15) {
            d(b4 | ((s3 - s4) << 4));
        } else {
            b(b4);
            a(clVar.f52816c);
        }
        this.f52796n = clVar.f52816c;
    }

    public ck(de deVar) {
        this(deVar, -1L);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cn cnVar) throws bx {
        int i4 = cnVar.f52821c;
        if (i4 == 0) {
            d(0);
            return;
        }
        b(i4);
        d(e(cnVar.f52820b) | (e(cnVar.f52819a) << 4));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cm cmVar) throws bx {
        a(cmVar.f52817a, cmVar.f52818b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cu cuVar) throws bx {
        a(cuVar.f52839a, cuVar.f52840b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(boolean z3) throws bx {
        cl clVar = this.f52797o;
        if (clVar != null) {
            a(clVar, z3 ? (byte) 1 : (byte) 2);
            this.f52797o = null;
            return;
        }
        b(z3 ? (byte) 1 : (byte) 2);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(byte b4) throws bx {
        b(b4);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(short s3) throws bx {
        b(c((int) s3));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(int i4) throws bx {
        b(c(i4));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(long j4) throws bx {
        b(c(j4));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(double d4) throws bx {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d4), bArr, 0);
        this.f52829g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(String str) throws bx {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bx("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(ByteBuffer byteBuffer) throws bx {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i4, int i5) throws bx {
        b(i5);
        this.f52829g.b(bArr, i4, i5);
    }

    protected void a(byte b4, int i4) throws bx {
        if (i4 <= 14) {
            d(e(b4) | (i4 << 4));
            return;
        }
        d(e(b4) | 240);
        b(i4);
    }

    private void a(long j4, byte[] bArr, int i4) {
        bArr[i4 + 0] = (byte) (j4 & 255);
        bArr[i4 + 1] = (byte) ((j4 >> 8) & 255);
        bArr[i4 + 2] = (byte) ((j4 >> 16) & 255);
        bArr[i4 + 3] = (byte) ((j4 >> 24) & 255);
        bArr[i4 + 4] = (byte) ((j4 >> 32) & 255);
        bArr[i4 + 5] = (byte) ((j4 >> 40) & 255);
        bArr[i4 + 6] = (byte) ((j4 >> 48) & 255);
        bArr[i4 + 7] = (byte) ((j4 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
