package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* renamed from: com.sun.mail.imap.protocol.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RFC822SIZE implements Item {

    /* renamed from: c */
    static final char[] f36176c = {'R', 'F', 'C', '8', '2', '2', '.', 'S', 'I', 'Z', 'E'};

    /* renamed from: a */
    public int f36177a;

    /* renamed from: b */
    public int f36178b;

    public RFC822SIZE(FetchResponse fetchResponse) throws ParsingException {
        this.f36177a = fetchResponse.m16121E();
        fetchResponse.m16408B();
        this.f36178b = fetchResponse.m16385v();
    }
}
