package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Namespaces.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public a[] f50578a;

    /* renamed from: b  reason: collision with root package name */
    public a[] f50579b;

    /* renamed from: c  reason: collision with root package name */
    public a[] f50580c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Namespaces.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50581a;

        /* renamed from: b  reason: collision with root package name */
        public char f50582b;

        public a(com.sun.mail.iap.g gVar) throws ProtocolException {
            if (gVar.r() == 40) {
                this.f50581a = com.sun.mail.imap.protocol.a.b(gVar.w());
                gVar.B();
                if (gVar.n() == 34) {
                    gVar.r();
                    char r3 = (char) gVar.r();
                    this.f50582b = r3;
                    if (r3 == '\\') {
                        this.f50582b = (char) gVar.r();
                    }
                    if (gVar.r() != 34) {
                        throw new ProtocolException("Missing '\"' at end of QUOTED_CHAR");
                    }
                } else {
                    String o4 = gVar.o();
                    if (o4 != null) {
                        if (o4.equalsIgnoreCase("NIL")) {
                            this.f50582b = (char) 0;
                        } else {
                            throw new ProtocolException("Expected NIL, got " + o4);
                        }
                    } else {
                        throw new ProtocolException("Expected NIL, got null");
                    }
                }
                if (gVar.n() != 41) {
                    gVar.B();
                    gVar.w();
                    gVar.B();
                    gVar.y();
                }
                if (gVar.r() != 41) {
                    throw new ProtocolException("Missing ')' at end of Namespace");
                }
                return;
            }
            throw new ProtocolException("Missing '(' at start of Namespace");
        }
    }

    public p(com.sun.mail.iap.g gVar) throws ProtocolException {
        this.f50578a = a(gVar);
        this.f50579b = a(gVar);
        this.f50580c = a(gVar);
    }

    private a[] a(com.sun.mail.iap.g gVar) throws ProtocolException {
        gVar.B();
        if (gVar.n() == 40) {
            Vector vector = new Vector();
            gVar.r();
            do {
                vector.addElement(new a(gVar));
            } while (gVar.n() != 41);
            gVar.r();
            a[] aVarArr = new a[vector.size()];
            vector.copyInto(aVarArr);
            return aVarArr;
        }
        String o4 = gVar.o();
        if (o4 != null) {
            if (o4.equalsIgnoreCase("NIL")) {
                return null;
            }
            throw new ProtocolException("Expected NIL, got " + o4);
        }
        throw new ProtocolException("Expected NIL, got null");
    }
}
