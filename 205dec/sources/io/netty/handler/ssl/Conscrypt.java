package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE = loadIsConscryptEngine();

    private Conscrypt() {
    }

    static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null && PlatformDependent.javaVersion() >= 8;
    }

    private static boolean isConscryptEngine(SSLEngine sSLEngine) {
        try {
            return ((Boolean) IS_CONSCRYPT_SSLENGINE.invoke(null, sSLEngine)).booleanValue();
        } catch (IllegalAccessException unused) {
            return false;
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isEngineSupported(SSLEngine sSLEngine) {
        return isAvailable() && isConscryptEngine(sSLEngine);
    }

    private static Method loadIsConscryptEngine() {
        try {
            return Class.forName("org.conscrypt.Conscrypt", true, ConscryptAlpnSslEngine.class.getClassLoader()).getMethod("isConscrypt", SSLEngine.class);
        } catch (Throwable unused) {
            return null;
        }
    }
}
