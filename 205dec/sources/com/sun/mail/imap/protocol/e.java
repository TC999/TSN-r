package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Date;
import java.util.Vector;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ENVELOPE.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e implements l {

    /* renamed from: l  reason: collision with root package name */
    static final char[] f50513l = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};

    /* renamed from: m  reason: collision with root package name */
    private static MailDateFormat f50514m = new MailDateFormat();

    /* renamed from: a  reason: collision with root package name */
    public int f50515a;

    /* renamed from: b  reason: collision with root package name */
    public Date f50516b;

    /* renamed from: c  reason: collision with root package name */
    public String f50517c;

    /* renamed from: d  reason: collision with root package name */
    public InternetAddress[] f50518d;

    /* renamed from: e  reason: collision with root package name */
    public InternetAddress[] f50519e;

    /* renamed from: f  reason: collision with root package name */
    public InternetAddress[] f50520f;

    /* renamed from: g  reason: collision with root package name */
    public InternetAddress[] f50521g;

    /* renamed from: h  reason: collision with root package name */
    public InternetAddress[] f50522h;

    /* renamed from: i  reason: collision with root package name */
    public InternetAddress[] f50523i;

    /* renamed from: j  reason: collision with root package name */
    public String f50524j;

    /* renamed from: k  reason: collision with root package name */
    public String f50525k;

    public e(f fVar) throws ParsingException {
        this.f50516b = null;
        this.f50515a = fVar.E();
        fVar.B();
        if (fVar.r() == 40) {
            String w3 = fVar.w();
            if (w3 != null) {
                try {
                    this.f50516b = f50514m.parse(w3);
                } catch (Exception unused) {
                }
            }
            this.f50517c = fVar.w();
            this.f50518d = a(fVar);
            this.f50519e = a(fVar);
            this.f50520f = a(fVar);
            this.f50521g = a(fVar);
            this.f50522h = a(fVar);
            this.f50523i = a(fVar);
            this.f50524j = fVar.w();
            this.f50525k = fVar.w();
            if (fVar.r() != 41) {
                throw new ParsingException("ENVELOPE parse error");
            }
            return;
        }
        throw new ParsingException("ENVELOPE parse error");
    }

    private InternetAddress[] a(com.sun.mail.iap.g gVar) throws ParsingException {
        gVar.B();
        byte r3 = gVar.r();
        if (r3 != 40) {
            if (r3 != 78 && r3 != 110) {
                throw new ParsingException("ADDRESS parse error");
            }
            gVar.A(2);
            return null;
        }
        Vector vector = new Vector();
        do {
            g gVar2 = new g(gVar);
            if (!gVar2.a()) {
                vector.addElement(gVar2);
            }
        } while (gVar.n() != 41);
        gVar.A(1);
        InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
        vector.copyInto(internetAddressArr);
        return internetAddressArr;
    }
}
