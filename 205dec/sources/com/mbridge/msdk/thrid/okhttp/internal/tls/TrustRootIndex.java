package com.mbridge.msdk.thrid.okhttp.internal.tls;

import java.security.cert.X509Certificate;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface TrustRootIndex {
    X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate);
}
