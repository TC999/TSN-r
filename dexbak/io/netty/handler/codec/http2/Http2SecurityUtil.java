package io.netty.handler.codec.http2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Http2SecurityUtil {
    public static final List<String> CIPHERS;
    private static final List<String> CIPHERS_JAVA_MOZILLA_INCREASED_SECURITY;
    private static final List<String> CIPHERS_JAVA_NO_MOZILLA_INCREASED_SECURITY;

    static {
        List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256"));
        CIPHERS_JAVA_MOZILLA_INCREASED_SECURITY = unmodifiableList;
        List<String> unmodifiableList2 = Collections.unmodifiableList(Arrays.asList("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"));
        CIPHERS_JAVA_NO_MOZILLA_INCREASED_SECURITY = unmodifiableList2;
        ArrayList arrayList = new ArrayList(unmodifiableList.size() + unmodifiableList2.size());
        arrayList.addAll(unmodifiableList);
        arrayList.addAll(unmodifiableList2);
        CIPHERS = Collections.unmodifiableList(arrayList);
    }

    private Http2SecurityUtil() {
    }
}
