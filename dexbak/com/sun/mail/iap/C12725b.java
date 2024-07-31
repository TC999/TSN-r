package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import kotlin.UByte;

/* compiled from: Argument.java */
/* renamed from: com.sun.mail.iap.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12725b {

    /* renamed from: a */
    protected Vector f35844a = new Vector(1);

    /* renamed from: b */
    private void m16443b(byte[] bArr, C12727f c12727f) throws IOException, ProtocolException {
        int i;
        DataOutputStream dataOutputStream = (DataOutputStream) c12727f.m16418e();
        int length = bArr.length;
        if (length > 1024) {
            m16440e(bArr, c12727f);
            return;
        }
        boolean z = length == 0;
        boolean z2 = false;
        for (byte b : bArr) {
            if (b == 0 || b == 13 || b == 10 || (i = b & UByte.f41242c) > 127) {
                m16440e(bArr, c12727f);
                return;
            }
            if (b == 42 || b == 37 || b == 40 || b == 41 || b == 123 || b == 34 || b == 92 || i <= 32) {
                if (b == 34 || b == 92) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
        }
        if (z) {
            dataOutputStream.write(34);
        }
        if (z2) {
            for (byte b2 : bArr) {
                if (b2 == 34 || b2 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b2);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z) {
            dataOutputStream.write(34);
        }
    }

    /* renamed from: c */
    private void m16442c(Literal literal, C12727f c12727f) throws IOException, ProtocolException {
        literal.writeTo(m16439f(c12727f, literal.size()));
    }

    /* renamed from: d */
    private void m16441d(ByteArrayOutputStream byteArrayOutputStream, C12727f c12727f) throws IOException, ProtocolException {
        byteArrayOutputStream.writeTo(m16439f(c12727f, byteArrayOutputStream.size()));
    }

    /* renamed from: e */
    private void m16440e(byte[] bArr, C12727f c12727f) throws IOException, ProtocolException {
        m16439f(c12727f, bArr.length).write(bArr);
    }

    /* renamed from: f */
    private OutputStream m16439f(C12727f c12727f, int i) throws IOException, ProtocolException {
        C12728g mo16148l;
        DataOutputStream dataOutputStream = (DataOutputStream) c12727f.m16418e();
        boolean mo16143p = c12727f.mo16143p();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i));
        if (mo16143p) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!mo16143p) {
            do {
                mo16148l = c12727f.mo16148l();
                if (mo16148l.m16401f()) {
                }
            } while (!mo16148l.m16397j());
            throw new LiteralException(mo16148l);
        }
        return dataOutputStream;
    }

    /* renamed from: a */
    public void m16444a(C12725b c12725b) {
        Vector vector = this.f35844a;
        vector.ensureCapacity(vector.size() + c12725b.f35844a.size());
        for (int i = 0; i < c12725b.f35844a.size(); i++) {
            this.f35844a.addElement(c12725b.f35844a.elementAt(i));
        }
    }

    /* renamed from: g */
    public void m16438g(C12727f c12727f) throws IOException, ProtocolException {
        Vector vector = this.f35844a;
        int size = vector != null ? vector.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) c12727f.m16418e();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                dataOutputStream.write(32);
            }
            Object elementAt = this.f35844a.elementAt(i);
            if (elementAt instanceof C12726c) {
                dataOutputStream.writeBytes(((C12726c) elementAt).f35845a);
            } else if (elementAt instanceof Number) {
                dataOutputStream.writeBytes(((Number) elementAt).toString());
            } else if (elementAt instanceof Argument) {
                m16443b(((Argument) elementAt).f35843a, c12727f);
            } else if (elementAt instanceof byte[]) {
                m16440e((byte[]) elementAt, c12727f);
            } else if (elementAt instanceof ByteArrayOutputStream) {
                m16441d((ByteArrayOutputStream) elementAt, c12727f);
            } else if (elementAt instanceof Literal) {
                m16442c((Literal) elementAt, c12727f);
            } else if (elementAt instanceof C12725b) {
                dataOutputStream.write(40);
                ((C12725b) elementAt).m16438g(c12727f);
                dataOutputStream.write(41);
            }
        }
    }

    /* renamed from: h */
    public void m16437h(C12725b c12725b) {
        this.f35844a.addElement(c12725b);
    }

    /* renamed from: i */
    public void m16436i(String str) {
        this.f35844a.addElement(new C12726c(str));
    }

    /* renamed from: j */
    public void m16435j(Literal literal) {
        this.f35844a.addElement(literal);
    }

    /* renamed from: k */
    public void m16434k(ByteArrayOutputStream byteArrayOutputStream) {
        this.f35844a.addElement(byteArrayOutputStream);
    }

    /* renamed from: l */
    public void m16433l(byte[] bArr) {
        this.f35844a.addElement(bArr);
    }

    /* renamed from: m */
    public void m16432m(int i) {
        this.f35844a.addElement(new Integer(i));
    }

    /* renamed from: n */
    public void m16431n(long j) {
        this.f35844a.addElement(new Long(j));
    }

    /* renamed from: o */
    public void m16430o(String str) {
        this.f35844a.addElement(new Argument(ASCIIUtility.getBytes(str)));
    }

    /* renamed from: p */
    public void m16429p(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            m16430o(str);
        } else {
            this.f35844a.addElement(new Argument(str.getBytes(str2)));
        }
    }
}
