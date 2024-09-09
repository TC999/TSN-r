package io.netty.handler.codec.haproxy;

import io.netty.handler.codec.DecoderException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HAProxyProtocolException extends DecoderException {
    private static final long serialVersionUID = 713710864325167351L;

    public HAProxyProtocolException() {
    }

    public HAProxyProtocolException(String str, Throwable th) {
        super(str, th);
    }

    public HAProxyProtocolException(String str) {
        super(str);
    }

    public HAProxyProtocolException(Throwable th) {
        super(th);
    }
}
