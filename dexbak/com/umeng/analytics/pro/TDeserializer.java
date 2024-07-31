package com.umeng.analytics.pro;

import com.umeng.analytics.pro.TCompactProtocol;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.umeng.analytics.pro.bu */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TDeserializer {

    /* renamed from: a */
    private final TProtocol f37953a;

    /* renamed from: b */
    private final TMemoryInputTransport f37954b;

    public TDeserializer() {
        this(new TCompactProtocol.C13140a());
    }

    /* renamed from: j */
    private TField m14507j(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        this.f37954b.m14388a(bArr);
        int length = tFieldIdEnumArr.length + 1;
        TFieldIdEnum[] tFieldIdEnumArr2 = new TFieldIdEnum[length];
        int i = 0;
        tFieldIdEnumArr2[0] = tFieldIdEnum;
        int i2 = 0;
        while (i2 < tFieldIdEnumArr.length) {
            int i3 = i2 + 1;
            tFieldIdEnumArr2[i3] = tFieldIdEnumArr[i2];
            i2 = i3;
        }
        this.f37953a.mo14416j();
        TField tField = null;
        while (i < length) {
            tField = this.f37953a.mo14414l();
            if (tField.f38029b == 0 || tField.f38030c > tFieldIdEnumArr2[i].mo13481a()) {
                return null;
            }
            if (tField.f38030c != tFieldIdEnumArr2[i].mo13481a()) {
                TProtocolUtil.m14397a(this.f37953a, tField.f38029b);
                this.f37953a.mo14413m();
            } else {
                i++;
                if (i < length) {
                    this.f37953a.mo14416j();
                }
            }
        }
        return tField;
    }

    /* renamed from: a */
    public void m14518a(TBase tBase, byte[] bArr) throws TException {
        try {
            this.f37954b.m14388a(bArr);
            tBase.read(this.f37953a);
        } finally {
            this.f37954b.m14386e();
            this.f37953a.mo14441B();
        }
    }

    /* renamed from: b */
    public Byte m14515b(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (Byte) m14521a((byte) 3, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: c */
    public Double m14514c(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (Double) m14521a((byte) 4, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: d */
    public Short m14513d(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (Short) m14521a((byte) 6, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: e */
    public Integer m14512e(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (Integer) m14521a((byte) 8, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: f */
    public Long m14511f(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (Long) m14521a((byte) 10, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: g */
    public String m14510g(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (String) m14521a((byte) 11, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: h */
    public ByteBuffer m14509h(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (ByteBuffer) m14521a((byte) 100, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: i */
    public Short m14508i(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        Short sh;
        try {
            try {
                if (m14507j(bArr, tFieldIdEnum, tFieldIdEnumArr) != null) {
                    this.f37953a.mo14416j();
                    sh = Short.valueOf(this.f37953a.mo14414l().f38030c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e) {
                throw new TException(e);
            }
        } finally {
            this.f37954b.m14386e();
            this.f37953a.mo14441B();
        }
    }

    public TDeserializer(TProtocolFactory tProtocolFactory) {
        TMemoryInputTransport tMemoryInputTransport = new TMemoryInputTransport();
        this.f37954b = tMemoryInputTransport;
        this.f37953a = tProtocolFactory.mo14389a(tMemoryInputTransport);
    }

    /* renamed from: a */
    public void m14519a(TBase tBase, String str, String str2) throws TException {
        try {
            try {
                m14518a(tBase, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new TException("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f37953a.mo14441B();
        }
    }

    /* renamed from: a */
    public void m14517a(TBase tBase, byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        try {
            try {
                if (m14507j(bArr, tFieldIdEnum, tFieldIdEnumArr) != null) {
                    tBase.read(this.f37953a);
                }
            } catch (Exception e) {
                throw new TException(e);
            }
        } finally {
            this.f37954b.m14386e();
            this.f37953a.mo14441B();
        }
    }

    /* renamed from: a */
    public Boolean m14516a(byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        return (Boolean) m14521a((byte) 2, bArr, tFieldIdEnum, tFieldIdEnumArr);
    }

    /* renamed from: a */
    private Object m14521a(byte b, byte[] bArr, TFieldIdEnum tFieldIdEnum, TFieldIdEnum... tFieldIdEnumArr) throws TException {
        Object obj;
        try {
            try {
                TField m14507j = m14507j(bArr, tFieldIdEnum, tFieldIdEnumArr);
                if (m14507j != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && m14507j.f38029b == 11) {
                                                    obj = this.f37953a.mo14400z();
                                                }
                                            } else if (m14507j.f38029b == 10) {
                                                obj = Long.valueOf(this.f37953a.mo14402x());
                                            }
                                        } else if (m14507j.f38029b == 11) {
                                            obj = this.f37953a.mo14442A();
                                        }
                                    } else if (m14507j.f38029b == 8) {
                                        obj = Integer.valueOf(this.f37953a.mo14403w());
                                    }
                                } else if (m14507j.f38029b == 6) {
                                    obj = Short.valueOf(this.f37953a.mo14404v());
                                }
                            } else if (m14507j.f38029b == 4) {
                                obj = Double.valueOf(this.f37953a.mo14401y());
                            }
                        } else if (m14507j.f38029b == 3) {
                            obj = Byte.valueOf(this.f37953a.mo14405u());
                        }
                    } else if (m14507j.f38029b == 2) {
                        obj = Boolean.valueOf(this.f37953a.mo14406t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e) {
                throw new TException(e);
            }
        } finally {
            this.f37954b.m14386e();
            this.f37953a.mo14441B();
        }
    }

    /* renamed from: a */
    public void m14520a(TBase tBase, String str) throws TException {
        m14518a(tBase, str.getBytes());
    }
}
