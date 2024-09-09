package xyz.adscope.common.network.exception;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ReadException extends IOException {
    public ReadException(String str) {
        super(str);
    }

    public ReadException(String str, Throwable th) {
        super(str, th);
    }

    public ReadException(Throwable th) {
        super(th);
    }
}
