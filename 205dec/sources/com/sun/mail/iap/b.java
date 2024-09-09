package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Argument.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected Vector f50265a = new Vector(1);

    private void b(byte[] bArr, f fVar) throws IOException, ProtocolException {
        int i4;
        DataOutputStream dataOutputStream = (DataOutputStream) fVar.e();
        int length = bArr.length;
        if (length > 1024) {
            e(bArr, fVar);
            return;
        }
        boolean z3 = length == 0;
        boolean z4 = false;
        for (byte b4 : bArr) {
            if (b4 == 0 || b4 == 13 || b4 == 10 || (i4 = b4 & 255) > 127) {
                e(bArr, fVar);
                return;
            }
            if (b4 == 42 || b4 == 37 || b4 == 40 || b4 == 41 || b4 == 123 || b4 == 34 || b4 == 92 || i4 <= 32) {
                if (b4 == 34 || b4 == 92) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = true;
                }
            }
        }
        if (z3) {
            dataOutputStream.write(34);
        }
        if (z4) {
            for (byte b5 : bArr) {
                if (b5 == 34 || b5 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b5);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z3) {
            dataOutputStream.write(34);
        }
    }

    private void c(e eVar, f fVar) throws IOException, ProtocolException {
        eVar.writeTo(f(fVar, eVar.size()));
    }

    private void d(ByteArrayOutputStream byteArrayOutputStream, f fVar) throws IOException, ProtocolException {
        byteArrayOutputStream.writeTo(f(fVar, byteArrayOutputStream.size()));
    }

    private void e(byte[] bArr, f fVar) throws IOException, ProtocolException {
        f(fVar, bArr.length).write(bArr);
    }

    private OutputStream f(f fVar, int i4) throws IOException, ProtocolException {
        g l4;
        DataOutputStream dataOutputStream = (DataOutputStream) fVar.e();
        boolean p3 = fVar.p();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i4));
        if (p3) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!p3) {
            do {
                l4 = fVar.l();
                if (l4.f()) {
                }
            } while (!l4.j());
            throw new LiteralException(l4);
        }
        return dataOutputStream;
    }

    public void a(b bVar) {
        Vector vector = this.f50265a;
        vector.ensureCapacity(vector.size() + bVar.f50265a.size());
        for (int i4 = 0; i4 < bVar.f50265a.size(); i4++) {
            this.f50265a.addElement(bVar.f50265a.elementAt(i4));
        }
    }

    public void g(f fVar) throws IOException, ProtocolException {
        Vector vector = this.f50265a;
        int size = vector != null ? vector.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) fVar.e();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 > 0) {
                dataOutputStream.write(32);
            }
            Object elementAt = this.f50265a.elementAt(i4);
            if (elementAt instanceof c) {
                dataOutputStream.writeBytes(((c) elementAt).f50266a);
            } else if (elementAt instanceof Number) {
                dataOutputStream.writeBytes(((Number) elementAt).toString());
            } else if (elementAt instanceof a) {
                b(((a) elementAt).f50264a, fVar);
            } else if (elementAt instanceof byte[]) {
                e((byte[]) elementAt, fVar);
            } else if (elementAt instanceof ByteArrayOutputStream) {
                d((ByteArrayOutputStream) elementAt, fVar);
            } else if (elementAt instanceof e) {
                c((e) elementAt, fVar);
            } else if (elementAt instanceof b) {
                dataOutputStream.write(40);
                ((b) elementAt).g(fVar);
                dataOutputStream.write(41);
            }
        }
    }

    public void h(b bVar) {
        this.f50265a.addElement(bVar);
    }

    public void i(String str) {
        this.f50265a.addElement(new c(str));
    }

    public void j(e eVar) {
        this.f50265a.addElement(eVar);
    }

    public void k(ByteArrayOutputStream byteArrayOutputStream) {
        this.f50265a.addElement(byteArrayOutputStream);
    }

    public void l(byte[] bArr) {
        this.f50265a.addElement(bArr);
    }

    public void m(int i4) {
        this.f50265a.addElement(new Integer(i4));
    }

    public void n(long j4) {
        this.f50265a.addElement(new Long(j4));
    }

    public void o(String str) {
        this.f50265a.addElement(new a(ASCIIUtility.getBytes(str)));
    }

    public void p(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            o(str);
        } else {
            this.f50265a.addElement(new a(str.getBytes(str2)));
        }
    }
}
