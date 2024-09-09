package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPResponse.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i extends com.sun.mail.iap.g {

    /* renamed from: r  reason: collision with root package name */
    private String f50542r;

    /* renamed from: s  reason: collision with root package name */
    private int f50543s;

    public i(com.sun.mail.iap.f fVar) throws IOException, ProtocolException {
        super(fVar);
        if (!k() || h() || g() || d() || e()) {
            return;
        }
        String o4 = o();
        this.f50542r = o4;
        try {
            this.f50543s = Integer.parseInt(o4);
            this.f50542r = o();
        } catch (NumberFormatException unused) {
        }
    }

    public static i G(com.sun.mail.iap.f fVar) throws IOException, ProtocolException {
        i iVar = new i(fVar);
        return iVar.F("FETCH") ? new f(iVar) : iVar;
    }

    public String D() {
        return this.f50542r;
    }

    public int E() {
        return this.f50543s;
    }

    public boolean F(String str) {
        String str2 = this.f50542r;
        return str2 != null && str2.equalsIgnoreCase(str);
    }

    public String[] H() {
        byte[] bArr;
        int i4;
        B();
        byte[] bArr2 = this.f50300d;
        int i5 = this.f50297a;
        if (bArr2[i5] != 40) {
            return null;
        }
        this.f50297a = i5 + 1;
        Vector vector = new Vector();
        int i6 = this.f50297a;
        while (true) {
            bArr = this.f50300d;
            i4 = this.f50297a;
            if (bArr[i4] == 41) {
                break;
            }
            if (bArr[i4] == 32) {
                vector.addElement(ASCIIUtility.toString(bArr, i6, i4));
                i6 = this.f50297a + 1;
            }
            this.f50297a++;
        }
        if (i4 > i6) {
            vector.addElement(ASCIIUtility.toString(bArr, i6, i4));
        }
        this.f50297a++;
        int size = vector.size();
        if (size > 0) {
            String[] strArr = new String[size];
            vector.copyInto(strArr);
            return strArr;
        }
        return null;
    }

    public i(i iVar) {
        super(iVar);
        this.f50542r = iVar.f50542r;
        this.f50543s = iVar.f50543s;
    }
}
