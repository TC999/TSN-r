package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ParsingException;
import java.util.Date;
import java.util.Vector;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;

/* renamed from: com.sun.mail.imap.protocol.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ENVELOPE implements Item {

    /* renamed from: l */
    static final char[] f36101l = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};

    /* renamed from: m */
    private static MailDateFormat f36102m = new MailDateFormat();

    /* renamed from: a */
    public int f36103a;

    /* renamed from: b */
    public Date f36104b;

    /* renamed from: c */
    public String f36105c;

    /* renamed from: d */
    public InternetAddress[] f36106d;

    /* renamed from: e */
    public InternetAddress[] f36107e;

    /* renamed from: f */
    public InternetAddress[] f36108f;

    /* renamed from: g */
    public InternetAddress[] f36109g;

    /* renamed from: h */
    public InternetAddress[] f36110h;

    /* renamed from: i */
    public InternetAddress[] f36111i;

    /* renamed from: j */
    public String f36112j;

    /* renamed from: k */
    public String f36113k;

    public ENVELOPE(FetchResponse fetchResponse) throws ParsingException {
        this.f36104b = null;
        this.f36103a = fetchResponse.m16121E();
        fetchResponse.m16408B();
        if (fetchResponse.m16389r() == 40) {
            String m16384w = fetchResponse.m16384w();
            if (m16384w != null) {
                try {
                    this.f36104b = f36102m.parse(m16384w);
                } catch (Exception unused) {
                }
            }
            this.f36105c = fetchResponse.m16384w();
            this.f36106d = m16214a(fetchResponse);
            this.f36107e = m16214a(fetchResponse);
            this.f36108f = m16214a(fetchResponse);
            this.f36109g = m16214a(fetchResponse);
            this.f36110h = m16214a(fetchResponse);
            this.f36111i = m16214a(fetchResponse);
            this.f36112j = fetchResponse.m16384w();
            this.f36113k = fetchResponse.m16384w();
            if (fetchResponse.m16389r() != 41) {
                throw new ParsingException("ENVELOPE parse error");
            }
            return;
        }
        throw new ParsingException("ENVELOPE parse error");
    }

    /* renamed from: a */
    private InternetAddress[] m16214a(C12728g c12728g) throws ParsingException {
        c12728g.m16408B();
        byte m16389r = c12728g.m16389r();
        if (m16389r != 40) {
            if (m16389r != 78 && m16389r != 110) {
                throw new ParsingException("ADDRESS parse error");
            }
            c12728g.m16409A(2);
            return null;
        }
        Vector vector = new Vector();
        do {
            C12759g c12759g = new C12759g(c12728g);
            if (!c12759g.m16207a()) {
                vector.addElement(c12759g);
            }
        } while (c12728g.m16393n() != 41);
        c12728g.m16409A(1);
        InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
        vector.copyInto(internetAddressArr);
        return internetAddressArr;
    }
}
