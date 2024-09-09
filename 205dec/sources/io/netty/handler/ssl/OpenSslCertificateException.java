package io.netty.handler.ssl;

import java.security.cert.CertificateException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class OpenSslCertificateException extends CertificateException {
    private static final long serialVersionUID = 5542675253797129798L;
    private final int errorCode;

    public OpenSslCertificateException(int i4) {
        this((String) null, i4);
    }

    private static int checkErrorCode(int i4) {
        if (i4 < 0 || i4 > 65) {
            throw new IllegalArgumentException("errorCode must be 0 => 65. See https://www.openssl.org/docs/manmaster/apps/verify.html .");
        }
        return i4;
    }

    public int errorCode() {
        return this.errorCode;
    }

    public OpenSslCertificateException(String str, int i4) {
        super(str);
        this.errorCode = checkErrorCode(i4);
    }

    public OpenSslCertificateException(String str, Throwable th, int i4) {
        super(str, th);
        this.errorCode = checkErrorCode(i4);
    }

    public OpenSslCertificateException(Throwable th, int i4) {
        this(null, th, i4);
    }
}
