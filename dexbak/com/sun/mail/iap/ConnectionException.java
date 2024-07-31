package com.sun.mail.iap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ConnectionException extends ProtocolException {
    private static final long serialVersionUID = 5749739604257464727L;

    /* renamed from: p */
    private transient C12727f f35842p;

    public ConnectionException() {
    }

    public C12727f getProtocol() {
        return this.f35842p;
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(C12727f c12727f, C12728g c12728g) {
        super(c12728g);
        this.f35842p = c12727f;
    }
}
