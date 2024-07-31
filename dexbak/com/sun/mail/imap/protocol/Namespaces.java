package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ProtocolException;
import java.util.Vector;

/* renamed from: com.sun.mail.imap.protocol.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Namespaces {

    /* renamed from: a */
    public C12761a[] f36168a;

    /* renamed from: b */
    public C12761a[] f36169b;

    /* renamed from: c */
    public C12761a[] f36170c;

    /* compiled from: Namespaces.java */
    /* renamed from: com.sun.mail.imap.protocol.p$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12761a {

        /* renamed from: a */
        public String f36171a;

        /* renamed from: b */
        public char f36172b;

        public C12761a(C12728g c12728g) throws ProtocolException {
            if (c12728g.m16389r() == 40) {
                this.f36171a = BASE64MailboxDecoder.m16226b(c12728g.m16384w());
                c12728g.m16408B();
                if (c12728g.m16393n() == 34) {
                    c12728g.m16389r();
                    char m16389r = (char) c12728g.m16389r();
                    this.f36172b = m16389r;
                    if (m16389r == '\\') {
                        this.f36172b = (char) c12728g.m16389r();
                    }
                    if (c12728g.m16389r() != 34) {
                        throw new ProtocolException("Missing '\"' at end of QUOTED_CHAR");
                    }
                } else {
                    String m16392o = c12728g.m16392o();
                    if (m16392o != null) {
                        if (m16392o.equalsIgnoreCase("NIL")) {
                            this.f36172b = (char) 0;
                        } else {
                            throw new ProtocolException("Expected NIL, got " + m16392o);
                        }
                    } else {
                        throw new ProtocolException("Expected NIL, got null");
                    }
                }
                if (c12728g.m16393n() != 41) {
                    c12728g.m16408B();
                    c12728g.m16384w();
                    c12728g.m16408B();
                    c12728g.m16382y();
                }
                if (c12728g.m16389r() != 41) {
                    throw new ProtocolException("Missing ')' at end of Namespace");
                }
                return;
            }
            throw new ProtocolException("Missing '(' at start of Namespace");
        }
    }

    public Namespaces(C12728g c12728g) throws ProtocolException {
        this.f36168a = m16109a(c12728g);
        this.f36169b = m16109a(c12728g);
        this.f36170c = m16109a(c12728g);
    }

    /* renamed from: a */
    private C12761a[] m16109a(C12728g c12728g) throws ProtocolException {
        c12728g.m16408B();
        if (c12728g.m16393n() == 40) {
            Vector vector = new Vector();
            c12728g.m16389r();
            do {
                vector.addElement(new C12761a(c12728g));
            } while (c12728g.m16393n() != 41);
            c12728g.m16389r();
            C12761a[] c12761aArr = new C12761a[vector.size()];
            vector.copyInto(c12761aArr);
            return c12761aArr;
        }
        String m16392o = c12728g.m16392o();
        if (m16392o != null) {
            if (m16392o.equalsIgnoreCase("NIL")) {
                return null;
            }
            throw new ProtocolException("Expected NIL, got " + m16392o);
        }
        throw new ProtocolException("Expected NIL, got null");
    }
}
