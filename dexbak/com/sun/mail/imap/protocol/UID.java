package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* renamed from: com.sun.mail.imap.protocol.v */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UID implements Item {

    /* renamed from: c */
    static final char[] f36188c = {'U', 'I', 'D'};

    /* renamed from: a */
    public int f36189a;

    /* renamed from: b */
    public long f36190b;

    public UID(FetchResponse fetchResponse) throws ParsingException {
        this.f36189a = fetchResponse.m16121E();
        fetchResponse.m16408B();
        this.f36190b = fetchResponse.m16386u();
    }
}
