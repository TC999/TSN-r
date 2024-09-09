package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TBinaryProtocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class cj extends cq {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f52766a = -65536;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f52767b = -2147418112;

    /* renamed from: h  reason: collision with root package name */
    private static final cv f52768h = new cv();

    /* renamed from: c  reason: collision with root package name */
    protected boolean f52769c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f52770d;

    /* renamed from: e  reason: collision with root package name */
    protected int f52771e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f52772f;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f52773i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f52774j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f52775k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f52776l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f52777m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f52778n;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f52779o;

    /* renamed from: p  reason: collision with root package name */
    private byte[] f52780p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TBinaryProtocol.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements cs {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f52781a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f52782b;

        /* renamed from: c  reason: collision with root package name */
        protected int f52783c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.cs
        public cq a(de deVar) {
            cj cjVar = new cj(deVar, this.f52781a, this.f52782b);
            int i4 = this.f52783c;
            if (i4 != 0) {
                cjVar.c(i4);
            }
            return cjVar;
        }

        public a(boolean z3, boolean z4) {
            this(z3, z4, 0);
        }

        public a(boolean z3, boolean z4, int i4) {
            this.f52781a = z3;
            this.f52782b = z4;
            this.f52783c = i4;
        }
    }

    public cj(de deVar) {
        this(deVar, false, true);
    }

    @Override // com.umeng.analytics.pro.cq
    public ByteBuffer A() throws bx {
        int w3 = w();
        d(w3);
        if (this.f52829g.h() >= w3) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f52829g.f(), this.f52829g.g(), w3);
            this.f52829g.a(w3);
            return wrap;
        }
        byte[] bArr = new byte[w3];
        this.f52829g.d(bArr, 0, w3);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(co coVar) throws bx {
        if (this.f52770d) {
            a((-2147418112) | coVar.f52823b);
            a(coVar.f52822a);
            a(coVar.f52824c);
            return;
        }
        a(coVar.f52822a);
        a(coVar.f52823b);
        a(coVar.f52824c);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cv cvVar) {
    }

    public String b(int i4) throws bx {
        try {
            d(i4);
            byte[] bArr = new byte[i4];
            this.f52829g.d(bArr, 0, i4);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bx("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void c() {
    }

    public void c(int i4) {
        this.f52771e = i4;
        this.f52772f = true;
    }

    @Override // com.umeng.analytics.pro.cq
    public void d() throws bx {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cq
    public void e() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void f() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void g() {
    }

    @Override // com.umeng.analytics.pro.cq
    public co h() throws bx {
        int w3 = w();
        if (w3 < 0) {
            if (((-65536) & w3) == -2147418112) {
                return new co(z(), (byte) (w3 & 255), w());
            }
            throw new cr(4, "Bad version in readMessageBegin");
        } else if (!this.f52769c) {
            return new co(b(w3), u(), w());
        } else {
            throw new cr(4, "Missing version in readMessageBegin, old client?");
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void i() {
    }

    @Override // com.umeng.analytics.pro.cq
    public cv j() {
        return f52768h;
    }

    @Override // com.umeng.analytics.pro.cq
    public void k() {
    }

    @Override // com.umeng.analytics.pro.cq
    public cl l() throws bx {
        byte u3 = u();
        return new cl("", u3, u3 == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.cq
    public void m() {
    }

    @Override // com.umeng.analytics.pro.cq
    public cn n() throws bx {
        return new cn(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.cq
    public void o() {
    }

    @Override // com.umeng.analytics.pro.cq
    public cm p() throws bx {
        return new cm(u(), w());
    }

    @Override // com.umeng.analytics.pro.cq
    public void q() {
    }

    @Override // com.umeng.analytics.pro.cq
    public cu r() throws bx {
        return new cu(u(), w());
    }

    @Override // com.umeng.analytics.pro.cq
    public void s() {
    }

    @Override // com.umeng.analytics.pro.cq
    public boolean t() throws bx {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.cq
    public byte u() throws bx {
        if (this.f52829g.h() >= 1) {
            byte b4 = this.f52829g.f()[this.f52829g.g()];
            this.f52829g.a(1);
            return b4;
        }
        a(this.f52777m, 0, 1);
        return this.f52777m[0];
    }

    @Override // com.umeng.analytics.pro.cq
    public short v() throws bx {
        byte[] bArr = this.f52778n;
        int i4 = 0;
        if (this.f52829g.h() >= 2) {
            bArr = this.f52829g.f();
            i4 = this.f52829g.g();
            this.f52829g.a(2);
        } else {
            a(this.f52778n, 0, 2);
        }
        return (short) ((bArr[i4 + 1] & 255) | ((bArr[i4] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.cq
    public int w() throws bx {
        byte[] bArr = this.f52779o;
        int i4 = 0;
        if (this.f52829g.h() >= 4) {
            bArr = this.f52829g.f();
            i4 = this.f52829g.g();
            this.f52829g.a(4);
        } else {
            a(this.f52779o, 0, 4);
        }
        return (bArr[i4 + 3] & 255) | ((bArr[i4] & 255) << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.cq
    public long x() throws bx {
        byte[] bArr = this.f52780p;
        int i4 = 0;
        if (this.f52829g.h() >= 8) {
            bArr = this.f52829g.f();
            i4 = this.f52829g.g();
            this.f52829g.a(8);
        } else {
            a(this.f52780p, 0, 8);
        }
        return (bArr[i4 + 7] & 255) | ((bArr[i4] & 255) << 56) | ((bArr[i4 + 1] & 255) << 48) | ((bArr[i4 + 2] & 255) << 40) | ((bArr[i4 + 3] & 255) << 32) | ((bArr[i4 + 4] & 255) << 24) | ((bArr[i4 + 5] & 255) << 16) | ((bArr[i4 + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.cq
    public double y() throws bx {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.cq
    public String z() throws bx {
        int w3 = w();
        if (this.f52829g.h() >= w3) {
            try {
                String str = new String(this.f52829g.f(), this.f52829g.g(), w3, "UTF-8");
                this.f52829g.a(w3);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new bx("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(w3);
    }

    public cj(de deVar, boolean z3, boolean z4) {
        super(deVar);
        this.f52772f = false;
        this.f52773i = new byte[1];
        this.f52774j = new byte[2];
        this.f52775k = new byte[4];
        this.f52776l = new byte[8];
        this.f52777m = new byte[1];
        this.f52778n = new byte[2];
        this.f52779o = new byte[4];
        this.f52780p = new byte[8];
        this.f52769c = z3;
        this.f52770d = z4;
    }

    protected void d(int i4) throws bx {
        if (i4 >= 0) {
            if (this.f52772f) {
                int i5 = this.f52771e - i4;
                this.f52771e = i5;
                if (i5 >= 0) {
                    return;
                }
                throw new cr("Message length exceeded: " + i4);
            }
            return;
        }
        throw new cr("Negative length: " + i4);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cl clVar) throws bx {
        a(clVar.f52815b);
        a(clVar.f52816c);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cn cnVar) throws bx {
        a(cnVar.f52819a);
        a(cnVar.f52820b);
        a(cnVar.f52821c);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cm cmVar) throws bx {
        a(cmVar.f52817a);
        a(cmVar.f52818b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cu cuVar) throws bx {
        a(cuVar.f52839a);
        a(cuVar.f52840b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(boolean z3) throws bx {
        a(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(byte b4) throws bx {
        byte[] bArr = this.f52773i;
        bArr[0] = b4;
        this.f52829g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(short s3) throws bx {
        byte[] bArr = this.f52774j;
        bArr[0] = (byte) ((s3 >> 8) & 255);
        bArr[1] = (byte) (s3 & 255);
        this.f52829g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(int i4) throws bx {
        byte[] bArr = this.f52775k;
        bArr[0] = (byte) ((i4 >> 24) & 255);
        bArr[1] = (byte) ((i4 >> 16) & 255);
        bArr[2] = (byte) ((i4 >> 8) & 255);
        bArr[3] = (byte) (i4 & 255);
        this.f52829g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(long j4) throws bx {
        byte[] bArr = this.f52776l;
        bArr[0] = (byte) ((j4 >> 56) & 255);
        bArr[1] = (byte) ((j4 >> 48) & 255);
        bArr[2] = (byte) ((j4 >> 40) & 255);
        bArr[3] = (byte) ((j4 >> 32) & 255);
        bArr[4] = (byte) ((j4 >> 24) & 255);
        bArr[5] = (byte) ((j4 >> 16) & 255);
        bArr[6] = (byte) ((j4 >> 8) & 255);
        bArr[7] = (byte) (j4 & 255);
        this.f52829g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(double d4) throws bx {
        a(Double.doubleToLongBits(d4));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(String str) throws bx {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f52829g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bx("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(ByteBuffer byteBuffer) throws bx {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f52829g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i4, int i5) throws bx {
        d(i5);
        return this.f52829g.d(bArr, i4, i5);
    }
}
