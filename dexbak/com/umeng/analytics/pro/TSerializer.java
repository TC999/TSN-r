package com.umeng.analytics.pro;

import com.umeng.analytics.pro.TCompactProtocol;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.umeng.analytics.pro.ca */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TSerializer {

    /* renamed from: a */
    private final ByteArrayOutputStream f37960a;

    /* renamed from: b */
    private final TIOStreamTransport f37961b;

    /* renamed from: c */
    private TProtocol f37962c;

    public TSerializer() {
        this(new TCompactProtocol.C13140a());
    }

    /* renamed from: a */
    public byte[] m14505a(TBase tBase) throws TException {
        this.f37960a.reset();
        tBase.write(this.f37962c);
        return this.f37960a.toByteArray();
    }

    /* renamed from: b */
    public String m14503b(TBase tBase) throws TException {
        return new String(m14505a(tBase));
    }

    public TSerializer(TProtocolFactory tProtocolFactory) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f37960a = byteArrayOutputStream;
        TIOStreamTransport tIOStreamTransport = new TIOStreamTransport(byteArrayOutputStream);
        this.f37961b = tIOStreamTransport;
        this.f37962c = tProtocolFactory.mo14389a(tIOStreamTransport);
    }

    /* renamed from: a */
    public String m14504a(TBase tBase, String str) throws TException {
        try {
            return new String(m14505a(tBase), str);
        } catch (UnsupportedEncodingException unused) {
            throw new TException("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
