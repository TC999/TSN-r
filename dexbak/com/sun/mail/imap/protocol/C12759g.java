package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ParsingException;
import io.netty.util.internal.StringUtil;
import java.util.Vector;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/* compiled from: ENVELOPE.java */
/* renamed from: com.sun.mail.imap.protocol.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12759g extends InternetAddress {
    private static final long serialVersionUID = -3835822029483122232L;

    /* renamed from: a */
    private boolean f36117a;

    /* renamed from: b */
    private InternetAddress[] f36118b;

    /* renamed from: c */
    private String f36119c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C12759g(C12728g c12728g) throws ParsingException {
        this.f36117a = false;
        c12728g.m16408B();
        if (c12728g.m16389r() == 40) {
            this.encodedPersonal = c12728g.m16384w();
            c12728g.m16384w();
            String m16384w = c12728g.m16384w();
            String m16384w2 = c12728g.m16384w();
            if (c12728g.m16389r() != 41) {
                throw new ParsingException("ADDRESS parse error");
            }
            if (m16384w2 == null) {
                this.f36117a = true;
                this.f36119c = m16384w;
                if (m16384w == null) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.f36119c);
                stringBuffer.append(':');
                Vector vector = new Vector();
                while (c12728g.m16393n() != 41) {
                    C12759g c12759g = new C12759g(c12728g);
                    if (c12759g.m16207a()) {
                        break;
                    }
                    if (vector.size() != 0) {
                        stringBuffer.append(StringUtil.COMMA);
                    }
                    stringBuffer.append(c12759g.toString());
                    vector.addElement(c12759g);
                }
                stringBuffer.append(';');
                this.address = stringBuffer.toString();
                C12759g[] c12759gArr = new C12759g[vector.size()];
                this.f36118b = c12759gArr;
                vector.copyInto(c12759gArr);
                return;
            } else if (m16384w != null && m16384w.length() != 0) {
                if (m16384w2.length() == 0) {
                    this.address = m16384w;
                    return;
                }
                this.address = m16384w + "@" + m16384w2;
                return;
            } else {
                this.address = m16384w2;
                return;
            }
        }
        throw new ParsingException("ADDRESS parse error");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m16207a() {
        return this.f36117a && this.f36119c == null;
    }

    @Override // javax.mail.internet.InternetAddress
    public InternetAddress[] getGroup(boolean z) throws AddressException {
        InternetAddress[] internetAddressArr = this.f36118b;
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    @Override // javax.mail.internet.InternetAddress
    public boolean isGroup() {
        return this.f36117a;
    }
}
