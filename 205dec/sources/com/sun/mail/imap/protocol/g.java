package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ENVELOPE.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class g extends InternetAddress {
    private static final long serialVersionUID = -3835822029483122232L;

    /* renamed from: a  reason: collision with root package name */
    private boolean f50529a;

    /* renamed from: b  reason: collision with root package name */
    private InternetAddress[] f50530b;

    /* renamed from: c  reason: collision with root package name */
    private String f50531c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.sun.mail.iap.g gVar) throws ParsingException {
        this.f50529a = false;
        gVar.B();
        if (gVar.r() == 40) {
            this.encodedPersonal = gVar.w();
            gVar.w();
            String w3 = gVar.w();
            String w4 = gVar.w();
            if (gVar.r() != 41) {
                throw new ParsingException("ADDRESS parse error");
            }
            if (w4 == null) {
                this.f50529a = true;
                this.f50531c = w3;
                if (w3 == null) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.f50531c);
                stringBuffer.append(':');
                Vector vector = new Vector();
                while (gVar.n() != 41) {
                    g gVar2 = new g(gVar);
                    if (gVar2.a()) {
                        break;
                    }
                    if (vector.size() != 0) {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(gVar2.toString());
                    vector.addElement(gVar2);
                }
                stringBuffer.append(';');
                this.address = stringBuffer.toString();
                g[] gVarArr = new g[vector.size()];
                this.f50530b = gVarArr;
                vector.copyInto(gVarArr);
                return;
            } else if (w3 != null && w3.length() != 0) {
                if (w4.length() == 0) {
                    this.address = w3;
                    return;
                }
                this.address = w3 + "@" + w4;
                return;
            } else {
                this.address = w4;
                return;
            }
        }
        throw new ParsingException("ADDRESS parse error");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f50529a && this.f50531c == null;
    }

    @Override // javax.mail.internet.InternetAddress
    public InternetAddress[] getGroup(boolean z3) throws AddressException {
        InternetAddress[] internetAddressArr = this.f50530b;
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    @Override // javax.mail.internet.InternetAddress
    public boolean isGroup() {
        return this.f50529a;
    }
}
