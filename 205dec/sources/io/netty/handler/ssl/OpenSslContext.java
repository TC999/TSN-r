package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5, int i4, Certificate[] certificateArr, ClientAuth clientAuth) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j4, j5, i4, certificateArr, clientAuth, false);
    }

    protected final void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }

    final SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i4) {
        return new OpenSslEngine(this, byteBufAllocator, str, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j4, long j5, int i4, Certificate[] certificateArr, ClientAuth clientAuth) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j4, j5, i4, certificateArr, clientAuth, false);
    }
}
