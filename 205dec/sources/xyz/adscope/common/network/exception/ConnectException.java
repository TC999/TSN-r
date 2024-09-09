package xyz.adscope.common.network.exception;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ConnectException extends IOException {
    public ConnectException(String str) {
        super(str);
    }

    public ConnectException(String str, Throwable th) {
        super(str, th);
    }

    public ConnectException(Throwable th) {
        super(th);
    }
}
