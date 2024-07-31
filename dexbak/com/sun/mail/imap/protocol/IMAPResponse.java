package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12727f;
import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.Vector;

/* renamed from: com.sun.mail.imap.protocol.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPResponse extends C12728g {

    /* renamed from: r */
    private String f36132r;

    /* renamed from: s */
    private int f36133s;

    public IMAPResponse(C12727f c12727f) throws IOException, ProtocolException {
        super(c12727f);
        if (!m16396k() || m16399h() || m16400g() || m16403d() || m16402e()) {
            return;
        }
        String m16392o = m16392o();
        this.f36132r = m16392o;
        try {
            this.f36133s = Integer.parseInt(m16392o);
            this.f36132r = m16392o();
        } catch (NumberFormatException unused) {
        }
    }

    /* renamed from: G */
    public static IMAPResponse m16119G(C12727f c12727f) throws IOException, ProtocolException {
        IMAPResponse iMAPResponse = new IMAPResponse(c12727f);
        return iMAPResponse.m16120F("FETCH") ? new FetchResponse(iMAPResponse) : iMAPResponse;
    }

    /* renamed from: D */
    public String m16122D() {
        return this.f36132r;
    }

    /* renamed from: E */
    public int m16121E() {
        return this.f36133s;
    }

    /* renamed from: F */
    public boolean m16120F(String str) {
        String str2 = this.f36132r;
        return str2 != null && str2.equalsIgnoreCase(str);
    }

    /* renamed from: H */
    public String[] m16118H() {
        byte[] bArr;
        int i;
        m16408B();
        byte[] bArr2 = this.f35879d;
        int i2 = this.f35876a;
        if (bArr2[i2] != 40) {
            return null;
        }
        this.f35876a = i2 + 1;
        Vector vector = new Vector();
        int i3 = this.f35876a;
        while (true) {
            bArr = this.f35879d;
            i = this.f35876a;
            if (bArr[i] == 41) {
                break;
            }
            if (bArr[i] == 32) {
                vector.addElement(ASCIIUtility.toString(bArr, i3, i));
                i3 = this.f35876a + 1;
            }
            this.f35876a++;
        }
        if (i > i3) {
            vector.addElement(ASCIIUtility.toString(bArr, i3, i));
        }
        this.f35876a++;
        int size = vector.size();
        if (size > 0) {
            String[] strArr = new String[size];
            vector.copyInto(strArr);
            return strArr;
        }
        return null;
    }

    public IMAPResponse(IMAPResponse iMAPResponse) {
        super(iMAPResponse);
        this.f36132r = iMAPResponse.f36132r;
        this.f36133s = iMAPResponse.f36133s;
    }
}
