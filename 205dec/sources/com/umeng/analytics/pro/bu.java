package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ck;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TDeserializer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bu {

    /* renamed from: a  reason: collision with root package name */
    private final cq f52739a;

    /* renamed from: b  reason: collision with root package name */
    private final dd f52740b;

    public bu() {
        this(new ck.a());
    }

    private cl j(byte[] bArr, by byVar, by... byVarArr) throws bx {
        this.f52740b.a(bArr);
        int length = byVarArr.length + 1;
        by[] byVarArr2 = new by[length];
        int i4 = 0;
        byVarArr2[0] = byVar;
        int i5 = 0;
        while (i5 < byVarArr.length) {
            int i6 = i5 + 1;
            byVarArr2[i6] = byVarArr[i5];
            i5 = i6;
        }
        this.f52739a.j();
        cl clVar = null;
        while (i4 < length) {
            clVar = this.f52739a.l();
            if (clVar.f52815b == 0 || clVar.f52816c > byVarArr2[i4].a()) {
                return null;
            }
            if (clVar.f52816c != byVarArr2[i4].a()) {
                ct.a(this.f52739a, clVar.f52815b);
                this.f52739a.m();
            } else {
                i4++;
                if (i4 < length) {
                    this.f52739a.j();
                }
            }
        }
        return clVar;
    }

    public void a(br brVar, byte[] bArr) throws bx {
        try {
            this.f52740b.a(bArr);
            brVar.read(this.f52739a);
        } finally {
            this.f52740b.e();
            this.f52739a.B();
        }
    }

    public Byte b(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Byte) a((byte) 3, bArr, byVar, byVarArr);
    }

    public Double c(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Double) a((byte) 4, bArr, byVar, byVarArr);
    }

    public Short d(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Short) a((byte) 6, bArr, byVar, byVarArr);
    }

    public Integer e(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Integer) a((byte) 8, bArr, byVar, byVarArr);
    }

    public Long f(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Long) a((byte) 10, bArr, byVar, byVarArr);
    }

    public String g(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (String) a((byte) 11, bArr, byVar, byVarArr);
    }

    public ByteBuffer h(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (ByteBuffer) a((byte) 100, bArr, byVar, byVarArr);
    }

    public Short i(byte[] bArr, by byVar, by... byVarArr) throws bx {
        Short sh;
        try {
            try {
                if (j(bArr, byVar, byVarArr) != null) {
                    this.f52739a.j();
                    sh = Short.valueOf(this.f52739a.l().f52816c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e4) {
                throw new bx(e4);
            }
        } finally {
            this.f52740b.e();
            this.f52739a.B();
        }
    }

    public bu(cs csVar) {
        dd ddVar = new dd();
        this.f52740b = ddVar;
        this.f52739a = csVar.a(ddVar);
    }

    public void a(br brVar, String str, String str2) throws bx {
        try {
            try {
                a(brVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bx("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f52739a.B();
        }
    }

    public void a(br brVar, byte[] bArr, by byVar, by... byVarArr) throws bx {
        try {
            try {
                if (j(bArr, byVar, byVarArr) != null) {
                    brVar.read(this.f52739a);
                }
            } catch (Exception e4) {
                throw new bx(e4);
            }
        } finally {
            this.f52740b.e();
            this.f52739a.B();
        }
    }

    public Boolean a(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Boolean) a((byte) 2, bArr, byVar, byVarArr);
    }

    private Object a(byte b4, byte[] bArr, by byVar, by... byVarArr) throws bx {
        Object obj;
        try {
            try {
                cl j4 = j(bArr, byVar, byVarArr);
                if (j4 != null) {
                    if (b4 != 2) {
                        if (b4 != 3) {
                            if (b4 != 4) {
                                if (b4 != 6) {
                                    if (b4 != 8) {
                                        if (b4 != 100) {
                                            if (b4 != 10) {
                                                if (b4 == 11 && j4.f52815b == 11) {
                                                    obj = this.f52739a.z();
                                                }
                                            } else if (j4.f52815b == 10) {
                                                obj = Long.valueOf(this.f52739a.x());
                                            }
                                        } else if (j4.f52815b == 11) {
                                            obj = this.f52739a.A();
                                        }
                                    } else if (j4.f52815b == 8) {
                                        obj = Integer.valueOf(this.f52739a.w());
                                    }
                                } else if (j4.f52815b == 6) {
                                    obj = Short.valueOf(this.f52739a.v());
                                }
                            } else if (j4.f52815b == 4) {
                                obj = Double.valueOf(this.f52739a.y());
                            }
                        } else if (j4.f52815b == 3) {
                            obj = Byte.valueOf(this.f52739a.u());
                        }
                    } else if (j4.f52815b == 2) {
                        obj = Boolean.valueOf(this.f52739a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e4) {
                throw new bx(e4);
            }
        } finally {
            this.f52740b.e();
            this.f52739a.B();
        }
    }

    public void a(br brVar, String str) throws bx {
        a(brVar, str.getBytes());
    }
}
