package io.netty.handler.proxy;

import java.net.ConnectException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ProxyConnectException extends ConnectException {
    private static final long serialVersionUID = 5211364632246265538L;

    public ProxyConnectException() {
    }

    public ProxyConnectException(String str) {
        super(str);
    }

    public ProxyConnectException(Throwable th) {
        initCause(th);
    }

    public ProxyConnectException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
