package io.netty.handler.ssl;

import javax.net.ssl.SSLException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NotSslRecordException extends SSLException {
    private static final long serialVersionUID = -4316784434770656841L;

    public NotSslRecordException() {
        super("");
    }

    public NotSslRecordException(String str) {
        super(str);
    }

    public NotSslRecordException(Throwable th) {
        super(th);
    }

    public NotSslRecordException(String str, Throwable th) {
        super(str, th);
    }
}
