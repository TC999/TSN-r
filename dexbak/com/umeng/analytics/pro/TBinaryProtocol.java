package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* renamed from: com.umeng.analytics.pro.cj */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TBinaryProtocol extends TProtocol {

    /* renamed from: a */
    protected static final int f37980a = -65536;

    /* renamed from: b */
    protected static final int f37981b = -2147418112;

    /* renamed from: h */
    private static final TStruct f37982h = new TStruct();

    /* renamed from: c */
    protected boolean f37983c;

    /* renamed from: d */
    protected boolean f37984d;

    /* renamed from: e */
    protected int f37985e;

    /* renamed from: f */
    protected boolean f37986f;

    /* renamed from: i */
    private byte[] f37987i;

    /* renamed from: j */
    private byte[] f37988j;

    /* renamed from: k */
    private byte[] f37989k;

    /* renamed from: l */
    private byte[] f37990l;

    /* renamed from: m */
    private byte[] f37991m;

    /* renamed from: n */
    private byte[] f37992n;

    /* renamed from: o */
    private byte[] f37993o;

    /* renamed from: p */
    private byte[] f37994p;

    /* compiled from: TBinaryProtocol.java */
    /* renamed from: com.umeng.analytics.pro.cj$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13139a implements TProtocolFactory {

        /* renamed from: a */
        protected boolean f37995a;

        /* renamed from: b */
        protected boolean f37996b;

        /* renamed from: c */
        protected int f37997c;

        public C13139a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.TProtocolFactory
        /* renamed from: a */
        public TProtocol mo14389a(TTransport tTransport) {
            TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(tTransport, this.f37995a, this.f37996b);
            int i = this.f37997c;
            if (i != 0) {
                tBinaryProtocol.m14466c(i);
            }
            return tBinaryProtocol;
        }

        public C13139a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C13139a(boolean z, boolean z2, int i) {
            this.f37995a = z;
            this.f37996b = z2;
            this.f37997c = i;
        }
    }

    public TBinaryProtocol(TTransport tTransport) {
        this(tTransport, false, true);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: A */
    public ByteBuffer mo14442A() throws TException {
        int mo14403w = mo14403w();
        m14465d(mo14403w);
        if (this.f38043g.mo14374h() >= mo14403w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f38043g.mo14376f(), this.f38043g.mo14375g(), mo14403w);
            this.f38043g.mo14384a(mo14403w);
            return wrap;
        }
        byte[] bArr = new byte[mo14403w];
        this.f38043g.m14377d(bArr, 0, mo14403w);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14439a() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14431a(TMessage tMessage) throws TException {
        if (this.f37984d) {
            mo14436a(f37981b | tMessage.f38037b);
            mo14428a(tMessage.f38036a);
            mo14436a(tMessage.f38038c);
            return;
        }
        mo14428a(tMessage.f38036a);
        mo14438a(tMessage.f38037b);
        mo14436a(tMessage.f38038c);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14429a(TStruct tStruct) {
    }

    /* renamed from: b */
    public String m14467b(int i) throws TException {
        try {
            m14465d(i);
            byte[] bArr = new byte[i];
            this.f38043g.m14377d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: b */
    public void mo14424b() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: c */
    public void mo14423c() {
    }

    /* renamed from: c */
    public void m14466c(int i) {
        this.f37985e = i;
        this.f37986f = true;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: d */
    public void mo14422d() throws TException {
        mo14438a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: e */
    public void mo14421e() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: f */
    public void mo14420f() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: g */
    public void mo14419g() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: h */
    public TMessage mo14418h() throws TException {
        int mo14403w = mo14403w();
        if (mo14403w < 0) {
            if (((-65536) & mo14403w) == f37981b) {
                return new TMessage(mo14400z(), (byte) (mo14403w & 255), mo14403w());
            }
            throw new TProtocolException(4, "Bad version in readMessageBegin");
        } else if (!this.f37983c) {
            return new TMessage(m14467b(mo14403w), mo14405u(), mo14403w());
        } else {
            throw new TProtocolException(4, "Missing version in readMessageBegin, old client?");
        }
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: i */
    public void mo14417i() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: j */
    public TStruct mo14416j() {
        return f37982h;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: k */
    public void mo14415k() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: l */
    public TField mo14414l() throws TException {
        byte mo14405u = mo14405u();
        return new TField("", mo14405u, mo14405u == 0 ? (short) 0 : mo14404v());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: m */
    public void mo14413m() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: n */
    public TMap mo14412n() throws TException {
        return new TMap(mo14405u(), mo14405u(), mo14403w());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: o */
    public void mo14411o() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: p */
    public TList mo14410p() throws TException {
        return new TList(mo14405u(), mo14403w());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: q */
    public void mo14409q() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: r */
    public TSet mo14408r() throws TException {
        return new TSet(mo14405u(), mo14403w());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: s */
    public void mo14407s() {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: t */
    public boolean mo14406t() throws TException {
        return mo14405u() == 1;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: u */
    public byte mo14405u() throws TException {
        if (this.f38043g.mo14374h() >= 1) {
            byte b = this.f38043g.mo14376f()[this.f38043g.mo14375g()];
            this.f38043g.mo14384a(1);
            return b;
        }
        m14468a(this.f37991m, 0, 1);
        return this.f37991m[0];
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: v */
    public short mo14404v() throws TException {
        byte[] bArr = this.f37992n;
        int i = 0;
        if (this.f38043g.mo14374h() >= 2) {
            bArr = this.f38043g.mo14376f();
            i = this.f38043g.mo14375g();
            this.f38043g.mo14384a(2);
        } else {
            m14468a(this.f37992n, 0, 2);
        }
        return (short) ((bArr[i + 1] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 8));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: w */
    public int mo14403w() throws TException {
        byte[] bArr = this.f37993o;
        int i = 0;
        if (this.f38043g.mo14374h() >= 4) {
            bArr = this.f38043g.mo14376f();
            i = this.f38043g.mo14375g();
            this.f38043g.mo14384a(4);
        } else {
            m14468a(this.f37993o, 0, 4);
        }
        return (bArr[i + 3] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 24) | ((bArr[i + 1] & UByte.f41242c) << 16) | ((bArr[i + 2] & UByte.f41242c) << 8);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: x */
    public long mo14402x() throws TException {
        byte[] bArr = this.f37994p;
        int i = 0;
        if (this.f38043g.mo14374h() >= 8) {
            bArr = this.f38043g.mo14376f();
            i = this.f38043g.mo14375g();
            this.f38043g.mo14384a(8);
        } else {
            m14468a(this.f37994p, 0, 8);
        }
        return (bArr[i + 7] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 56) | ((bArr[i + 1] & UByte.f41242c) << 48) | ((bArr[i + 2] & UByte.f41242c) << 40) | ((bArr[i + 3] & UByte.f41242c) << 32) | ((bArr[i + 4] & UByte.f41242c) << 24) | ((bArr[i + 5] & UByte.f41242c) << 16) | ((bArr[i + 6] & UByte.f41242c) << 8);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: y */
    public double mo14401y() throws TException {
        return Double.longBitsToDouble(mo14402x());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: z */
    public String mo14400z() throws TException {
        int mo14403w = mo14403w();
        if (this.f38043g.mo14374h() >= mo14403w) {
            try {
                String str = new String(this.f38043g.mo14376f(), this.f38043g.mo14375g(), mo14403w, "UTF-8");
                this.f38043g.mo14384a(mo14403w);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new TException("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m14467b(mo14403w);
    }

    public TBinaryProtocol(TTransport tTransport, boolean z, boolean z2) {
        super(tTransport);
        this.f37986f = false;
        this.f37987i = new byte[1];
        this.f37988j = new byte[2];
        this.f37989k = new byte[4];
        this.f37990l = new byte[8];
        this.f37991m = new byte[1];
        this.f37992n = new byte[2];
        this.f37993o = new byte[4];
        this.f37994p = new byte[8];
        this.f37983c = z;
        this.f37984d = z2;
    }

    /* renamed from: d */
    protected void m14465d(int i) throws TException {
        if (i >= 0) {
            if (this.f37986f) {
                int i2 = this.f37985e - i;
                this.f37985e = i2;
                if (i2 >= 0) {
                    return;
                }
                throw new TProtocolException("Message length exceeded: " + i);
            }
            return;
        }
        throw new TProtocolException("Negative length: " + i);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14434a(TField tField) throws TException {
        mo14438a(tField.f38029b);
        mo14426a(tField.f38030c);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14432a(TMap tMap) throws TException {
        mo14438a(tMap.f38033a);
        mo14438a(tMap.f38034b);
        mo14436a(tMap.f38035c);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14433a(TList tList) throws TException {
        mo14438a(tList.f38031a);
        mo14436a(tList.f38032b);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14430a(TSet tSet) throws TException {
        mo14438a(tSet.f38053a);
        mo14436a(tSet.f38054b);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14425a(boolean z) throws TException {
        mo14438a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14438a(byte b) throws TException {
        byte[] bArr = this.f37987i;
        bArr[0] = b;
        this.f38043g.mo14380b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14426a(short s) throws TException {
        byte[] bArr = this.f37988j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f38043g.mo14380b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14436a(int i) throws TException {
        byte[] bArr = this.f37989k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f38043g.mo14380b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14435a(long j) throws TException {
        byte[] bArr = this.f37990l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.f38043g.mo14380b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14437a(double d) throws TException {
        mo14435a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14428a(String str) throws TException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo14436a(bytes.length);
            this.f38043g.mo14380b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14427a(ByteBuffer byteBuffer) throws TException {
        int limit = byteBuffer.limit() - byteBuffer.position();
        mo14436a(limit);
        this.f38043g.mo14380b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    /* renamed from: a */
    private int m14468a(byte[] bArr, int i, int i2) throws TException {
        m14465d(i2);
        return this.f38043g.m14377d(bArr, i, i2);
    }
}
