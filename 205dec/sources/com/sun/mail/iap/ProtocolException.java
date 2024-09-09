package com.sun.mail.iap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ProtocolException extends Exception {
    private static final long serialVersionUID = -4360500807971797439L;
    protected transient g response;

    public ProtocolException() {
        this.response = null;
    }

    public g getResponse() {
        return this.response;
    }

    public ProtocolException(String str) {
        super(str);
        this.response = null;
    }

    public ProtocolException(g gVar) {
        super(gVar.toString());
        this.response = gVar;
    }
}
