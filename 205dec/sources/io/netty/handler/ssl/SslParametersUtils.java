package io.netty.handler.ssl;

import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class SslParametersUtils {
    private SslParametersUtils() {
    }

    static void setAlgorithmConstraints(SSLParameters sSLParameters, Object obj) {
        sSLParameters.setAlgorithmConstraints((AlgorithmConstraints) obj);
    }
}
