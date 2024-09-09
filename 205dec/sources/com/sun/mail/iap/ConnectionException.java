package com.sun.mail.iap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ConnectionException extends ProtocolException {
    private static final long serialVersionUID = 5749739604257464727L;

    /* renamed from: p  reason: collision with root package name */
    private transient f f50263p;

    public ConnectionException() {
    }

    public f getProtocol() {
        return this.f50263p;
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(f fVar, g gVar) {
        super(gVar);
        this.f50263p = fVar;
    }
}
