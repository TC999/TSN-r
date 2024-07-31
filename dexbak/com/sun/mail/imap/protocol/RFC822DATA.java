package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* renamed from: com.sun.mail.imap.protocol.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RFC822DATA implements Item {

    /* renamed from: c */
    static final char[] f36173c = {'R', 'F', 'C', '8', '2', '2'};

    /* renamed from: a */
    public int f36174a;

    /* renamed from: b */
    public ByteArray f36175b;

    public RFC822DATA(FetchResponse fetchResponse) throws ParsingException {
        this.f36174a = fetchResponse.m16121E();
        fetchResponse.m16408B();
        this.f36175b = fetchResponse.m16388s();
    }

    /* renamed from: a */
    public ByteArray m16108a() {
        return this.f36175b;
    }

    /* renamed from: b */
    public ByteArrayInputStream m16107b() {
        ByteArray byteArray = this.f36175b;
        if (byteArray != null) {
            return byteArray.m16422g();
        }
        return null;
    }
}
