package io.netty.handler.ssl;

import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class Java7SslParametersUtils {
    private Java7SslParametersUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAlgorithmConstraints(SSLParameters sSLParameters, Object obj) {
        sSLParameters.setAlgorithmConstraints((AlgorithmConstraints) obj);
    }
}
