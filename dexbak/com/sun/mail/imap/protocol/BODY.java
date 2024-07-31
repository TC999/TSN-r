package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* renamed from: com.sun.mail.imap.protocol.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BODY implements Item {

    /* renamed from: e */
    static final char[] f36074e = {'B', 'O', 'D', 'Y'};

    /* renamed from: a */
    public int f36075a;

    /* renamed from: b */
    public ByteArray f36076b;

    /* renamed from: c */
    public String f36077c;

    /* renamed from: d */
    public int f36078d;

    public BODY(FetchResponse fetchResponse) throws ParsingException {
        byte m16389r;
        this.f36078d = 0;
        this.f36075a = fetchResponse.m16121E();
        fetchResponse.m16408B();
        do {
            m16389r = fetchResponse.m16389r();
            if (m16389r == 93) {
                if (fetchResponse.m16389r() == 60) {
                    this.f36078d = fetchResponse.m16385v();
                    fetchResponse.m16409A(1);
                }
                this.f36076b = fetchResponse.m16388s();
                return;
            }
        } while (m16389r != 0);
        throw new ParsingException("BODY parse error: missing ``]'' at section end");
    }

    /* renamed from: a */
    public ByteArray m16221a() {
        return this.f36076b;
    }

    /* renamed from: b */
    public ByteArrayInputStream m16220b() {
        ByteArray byteArray = this.f36076b;
        if (byteArray != null) {
            return byteArray.m16422g();
        }
        return null;
    }
}
