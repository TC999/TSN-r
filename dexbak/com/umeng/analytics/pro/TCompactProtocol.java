package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.C14354n;

/* renamed from: com.umeng.analytics.pro.ck */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TCompactProtocol extends TProtocol {

    /* renamed from: d */
    private static final TStruct f37998d = new TStruct("");

    /* renamed from: e */
    private static final TField f37999e = new TField("", (byte) 0, 0);

    /* renamed from: f */
    private static final byte[] f38000f;

    /* renamed from: h */
    private static final byte f38001h = -126;

    /* renamed from: i */
    private static final byte f38002i = 1;

    /* renamed from: j */
    private static final byte f38003j = 31;

    /* renamed from: k */
    private static final byte f38004k = -32;

    /* renamed from: l */
    private static final int f38005l = 5;

    /* renamed from: a */
    byte[] f38006a;

    /* renamed from: b */
    byte[] f38007b;

    /* renamed from: c */
    byte[] f38008c;

    /* renamed from: m */
    private ShortStack f38009m;

    /* renamed from: n */
    private short f38010n;

    /* renamed from: o */
    private TField f38011o;

    /* renamed from: p */
    private Boolean f38012p;

    /* renamed from: q */
    private final long f38013q;

    /* renamed from: r */
    private byte[] f38014r;

    /* compiled from: TCompactProtocol.java */
    /* renamed from: com.umeng.analytics.pro.ck$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13141b {

        /* renamed from: a */
        public static final byte f38016a = 1;

        /* renamed from: b */
        public static final byte f38017b = 2;

        /* renamed from: c */
        public static final byte f38018c = 3;

        /* renamed from: d */
        public static final byte f38019d = 4;

        /* renamed from: e */
        public static final byte f38020e = 5;

        /* renamed from: f */
        public static final byte f38021f = 6;

        /* renamed from: g */
        public static final byte f38022g = 7;

        /* renamed from: h */
        public static final byte f38023h = 8;

        /* renamed from: i */
        public static final byte f38024i = 9;

        /* renamed from: j */
        public static final byte f38025j = 10;

        /* renamed from: k */
        public static final byte f38026k = 11;

        /* renamed from: l */
        public static final byte f38027l = 12;

        private C13141b() {
        }
    }

    static {
        f38000f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public TCompactProtocol(TTransport tTransport, long j) {
        super(tTransport);
        this.f38009m = new ShortStack(15);
        this.f38010n = (short) 0;
        this.f38011o = null;
        this.f38012p = null;
        this.f38006a = new byte[5];
        this.f38007b = new byte[10];
        this.f38014r = new byte[1];
        this.f38008c = new byte[1];
        this.f38013q = j;
    }

    /* renamed from: E */
    private int m14464E() throws TException {
        int i = 0;
        if (this.f38043g.mo14374h() >= 5) {
            byte[] mo14376f = this.f38043g.mo14376f();
            int mo14375g = this.f38043g.mo14375g();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = mo14376f[mo14375g + i];
                i2 |= (b & C14354n.f41155b) << i3;
                if ((b & 128) != 128) {
                    this.f38043g.mo14384a(i + 1);
                    return i2;
                }
                i3 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte mo14405u = mo14405u();
                i |= (mo14405u & C14354n.f41155b) << i4;
                if ((mo14405u & 128) != 128) {
                    return i;
                }
                i4 += 7;
            }
        }
    }

    /* renamed from: F */
    private long m14463F() throws TException {
        byte mo14405u;
        byte b;
        int i = 0;
        long j = 0;
        if (this.f38043g.mo14374h() >= 10) {
            byte[] mo14376f = this.f38043g.mo14376f();
            int mo14375g = this.f38043g.mo14375g();
            long j2 = 0;
            int i2 = 0;
            while (true) {
                j2 |= (b & C14354n.f41155b) << i2;
                if ((mo14376f[mo14375g + i] & 128) != 128) {
                    this.f38043g.mo14384a(i + 1);
                    return j2;
                }
                i2 += 7;
                i++;
            }
        } else {
            while (true) {
                j |= (mo14405u & C14354n.f41155b) << i;
                if ((mo14405u() & 128) != 128) {
                    return j;
                }
                i += 7;
            }
        }
    }

    /* renamed from: c */
    private int m14453c(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: c */
    private long m14452c(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: c */
    private boolean m14454c(byte b) {
        int i = b & 15;
        return i == 1 || i == 2;
    }

    /* renamed from: d */
    private long m14449d(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* renamed from: e */
    private byte[] m14447e(int i) throws TException {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.f38043g.m14377d(bArr, 0, i);
        return bArr;
    }

    /* renamed from: f */
    private void m14446f(int i) throws TProtocolException {
        if (i >= 0) {
            long j = this.f38013q;
            if (j == -1 || i <= j) {
                return;
            }
            throw new TProtocolException("Length exceeded max allowed: " + i);
        }
        throw new TProtocolException("Negative length: " + i);
    }

    /* renamed from: g */
    private int m14445g(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: A */
    public ByteBuffer mo14442A() throws TException {
        int m14464E = m14464E();
        m14446f(m14464E);
        if (m14464E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[m14464E];
        this.f38043g.m14377d(bArr, 0, m14464E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: B */
    public void mo14441B() {
        this.f38009m.m14549c();
        this.f38010n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14439a() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14431a(TMessage tMessage) throws TException {
        m14457b(f38001h);
        m14450d(((tMessage.f38037b << 5) & (-32)) | 1);
        m14456b(tMessage.f38038c);
        mo14428a(tMessage.f38036a);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: b */
    public void mo14424b() throws TException {
        this.f38010n = this.f38009m.m14552a();
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: c */
    public void mo14423c() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: d */
    public void mo14422d() throws TException {
        m14457b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: e */
    public void mo14421e() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: f */
    public void mo14420f() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: g */
    public void mo14419g() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: h */
    public TMessage mo14418h() throws TException {
        byte mo14405u = mo14405u();
        if (mo14405u == -126) {
            byte mo14405u2 = mo14405u();
            byte b = (byte) (mo14405u2 & f38003j);
            if (b == 1) {
                int m14464E = m14464E();
                return new TMessage(mo14400z(), (byte) ((mo14405u2 >> 5) & 3), m14464E);
            }
            throw new TProtocolException("Expected version 1 but got " + ((int) b));
        }
        throw new TProtocolException("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(mo14405u));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: i */
    public void mo14417i() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: j */
    public TStruct mo14416j() throws TException {
        this.f38009m.m14551a(this.f38010n);
        this.f38010n = (short) 0;
        return f37998d;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: k */
    public void mo14415k() throws TException {
        this.f38010n = this.f38009m.m14552a();
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: l */
    public TField mo14414l() throws TException {
        short s;
        byte mo14405u = mo14405u();
        if (mo14405u == 0) {
            return f37999e;
        }
        short s2 = (short) ((mo14405u & 240) >> 4);
        if (s2 == 0) {
            s = mo14404v();
        } else {
            s = (short) (this.f38010n + s2);
        }
        byte b = (byte) (mo14405u & 15);
        TField tField = new TField("", m14451d(b), s);
        if (m14454c(mo14405u)) {
            this.f38012p = b == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f38010n = tField.f38030c;
        return tField;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: m */
    public void mo14413m() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: n */
    public TMap mo14412n() throws TException {
        int m14464E = m14464E();
        byte mo14405u = m14464E == 0 ? (byte) 0 : mo14405u();
        return new TMap(m14451d((byte) (mo14405u >> 4)), m14451d((byte) (mo14405u & 15)), m14464E);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: o */
    public void mo14411o() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: p */
    public TList mo14410p() throws TException {
        byte mo14405u = mo14405u();
        int i = (mo14405u >> 4) & 15;
        if (i == 15) {
            i = m14464E();
        }
        return new TList(m14451d(mo14405u), i);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: q */
    public void mo14409q() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: r */
    public TSet mo14408r() throws TException {
        return new TSet(mo14410p());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: s */
    public void mo14407s() throws TException {
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: t */
    public boolean mo14406t() throws TException {
        Boolean bool = this.f38012p;
        if (bool == null) {
            return mo14405u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f38012p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: u */
    public byte mo14405u() throws TException {
        if (this.f38043g.mo14374h() > 0) {
            byte b = this.f38043g.mo14376f()[this.f38043g.mo14375g()];
            this.f38043g.mo14384a(1);
            return b;
        }
        this.f38043g.m14377d(this.f38008c, 0, 1);
        return this.f38008c[0];
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: v */
    public short mo14404v() throws TException {
        return (short) m14445g(m14464E());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: w */
    public int mo14403w() throws TException {
        return m14445g(m14464E());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: x */
    public long mo14402x() throws TException {
        return m14449d(m14463F());
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: y */
    public double mo14401y() throws TException {
        byte[] bArr = new byte[8];
        this.f38043g.m14377d(bArr, 0, 8);
        return Double.longBitsToDouble(m14459a(bArr));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: z */
    public String mo14400z() throws TException {
        int m14464E = m14464E();
        m14446f(m14464E);
        if (m14464E == 0) {
            return "";
        }
        try {
            if (this.f38043g.mo14374h() >= m14464E) {
                String str = new String(this.f38043g.mo14376f(), this.f38043g.mo14375g(), m14464E, "UTF-8");
                this.f38043g.mo14384a(m14464E);
                return str;
            }
            return new String(m14447e(m14464E), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new TException("UTF-8 not supported!");
        }
    }

    /* compiled from: TCompactProtocol.java */
    /* renamed from: com.umeng.analytics.pro.ck$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13140a implements TProtocolFactory {

        /* renamed from: a */
        private final long f38015a;

        public C13140a() {
            this.f38015a = -1L;
        }

        @Override // com.umeng.analytics.pro.TProtocolFactory
        /* renamed from: a */
        public TProtocol mo14389a(TTransport tTransport) {
            return new TCompactProtocol(tTransport, this.f38015a);
        }

        public C13140a(int i) {
            this.f38015a = i;
        }
    }

    /* renamed from: b */
    private void m14456b(int i) throws TException {
        int i2 = 0;
        while ((i & (-128)) != 0) {
            this.f38006a[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2++;
        }
        byte[] bArr = this.f38006a;
        bArr[i2] = (byte) i;
        this.f38043g.mo14380b(bArr, 0, i2 + 1);
    }

    /* renamed from: d */
    private void m14450d(int i) throws TException {
        m14457b((byte) i);
    }

    /* renamed from: d */
    private byte m14451d(byte b) throws TProtocolException {
        byte b2 = (byte) (b & 15);
        switch (b2) {
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
                throw new TProtocolException("don't know what type: " + ((int) b2));
        }
    }

    /* renamed from: e */
    private byte m14448e(byte b) {
        return f38000f[b];
    }

    /* renamed from: b */
    private void m14455b(long j) throws TException {
        int i = 0;
        while (((-128) & j) != 0) {
            this.f38007b[i] = (byte) ((127 & j) | 128);
            j >>>= 7;
            i++;
        }
        byte[] bArr = this.f38007b;
        bArr[i] = (byte) j;
        this.f38043g.mo14380b(bArr, 0, i + 1);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14429a(TStruct tStruct) throws TException {
        this.f38009m.m14551a(this.f38010n);
        this.f38010n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14434a(TField tField) throws TException {
        if (tField.f38029b == 2) {
            this.f38011o = tField;
        } else {
            m14460a(tField, (byte) -1);
        }
    }

    /* renamed from: b */
    private void m14457b(byte b) throws TException {
        byte[] bArr = this.f38014r;
        bArr[0] = b;
        this.f38043g.m14381b(bArr);
    }

    /* renamed from: a */
    private void m14460a(TField tField, byte b) throws TException {
        if (b == -1) {
            b = m14448e(tField.f38029b);
        }
        short s = tField.f38030c;
        short s2 = this.f38010n;
        if (s > s2 && s - s2 <= 15) {
            m14450d(b | ((s - s2) << 4));
        } else {
            m14457b(b);
            mo14426a(tField.f38030c);
        }
        this.f38010n = tField.f38030c;
    }

    public TCompactProtocol(TTransport tTransport) {
        this(tTransport, -1L);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14432a(TMap tMap) throws TException {
        int i = tMap.f38035c;
        if (i == 0) {
            m14450d(0);
            return;
        }
        m14456b(i);
        m14450d(m14448e(tMap.f38034b) | (m14448e(tMap.f38033a) << 4));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14433a(TList tList) throws TException {
        m14462a(tList.f38031a, tList.f38032b);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14430a(TSet tSet) throws TException {
        m14462a(tSet.f38053a, tSet.f38054b);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14425a(boolean z) throws TException {
        TField tField = this.f38011o;
        if (tField != null) {
            m14460a(tField, z ? (byte) 1 : (byte) 2);
            this.f38011o = null;
            return;
        }
        m14457b(z ? (byte) 1 : (byte) 2);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14438a(byte b) throws TException {
        m14457b(b);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14426a(short s) throws TException {
        m14456b(m14453c((int) s));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14436a(int i) throws TException {
        m14456b(m14453c(i));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14435a(long j) throws TException {
        m14455b(m14452c(j));
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14437a(double d) throws TException {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        m14461a(Double.doubleToLongBits(d), bArr, 0);
        this.f38043g.m14381b(bArr);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14428a(String str) throws TException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m14458a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: a */
    public void mo14427a(ByteBuffer byteBuffer) throws TException {
        m14458a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    /* renamed from: a */
    private void m14458a(byte[] bArr, int i, int i2) throws TException {
        m14456b(i2);
        this.f38043g.mo14380b(bArr, i, i2);
    }

    /* renamed from: a */
    protected void m14462a(byte b, int i) throws TException {
        if (i <= 14) {
            m14450d(m14448e(b) | (i << 4));
            return;
        }
        m14450d(m14448e(b) | 240);
        m14456b(i);
    }

    /* renamed from: a */
    private void m14461a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) (j & 255);
        bArr[i + 1] = (byte) ((j >> 8) & 255);
        bArr[i + 2] = (byte) ((j >> 16) & 255);
        bArr[i + 3] = (byte) ((j >> 24) & 255);
        bArr[i + 4] = (byte) ((j >> 32) & 255);
        bArr[i + 5] = (byte) ((j >> 40) & 255);
        bArr[i + 6] = (byte) ((j >> 48) & 255);
        bArr[i + 7] = (byte) ((j >> 56) & 255);
    }

    /* renamed from: a */
    private long m14459a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
