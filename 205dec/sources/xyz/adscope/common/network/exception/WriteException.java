package xyz.adscope.common.network.exception;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class WriteException extends IOException {
    public WriteException(String str) {
        super(str);
    }

    public WriteException(String str, Throwable th) {
        super(str, th);
    }

    public WriteException(Throwable th) {
        super(th);
    }
}
