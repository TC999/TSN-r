package com.sun.mail.iap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ProtocolException extends Exception {
    private static final long serialVersionUID = -4360500807971797439L;
    protected transient C12728g response;

    public ProtocolException() {
        this.response = null;
    }

    public C12728g getResponse() {
        return this.response;
    }

    public ProtocolException(String str) {
        super(str);
        this.response = null;
    }

    public ProtocolException(C12728g c12728g) {
        super(c12728g.toString());
        this.response = c12728g;
    }
}
