package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class Java9SslUtils {
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Java9SslUtils.class);

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5 = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            SSLEngine createSSLEngine = sSLContext.createSSLEngine();
            Method method6 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.Java9SslUtils.1
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocol", new Class[0]);
                }
            });
            method6.invoke(createSSLEngine, new Object[0]);
            method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.Java9SslUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
                }
            });
            method.invoke(createSSLEngine, new Object[0]);
            method2 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.Java9SslUtils.3
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                }
            });
            method2.invoke(createSSLEngine.getSSLParameters(), EmptyArrays.EMPTY_STRINGS);
            method3 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.Java9SslUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("setHandshakeApplicationProtocolSelector", BiFunction.class);
                }
            });
            method3.invoke(createSSLEngine, new BiFunction<SSLEngine, List<String>, String>() { // from class: io.netty.handler.ssl.Java9SslUtils.5
                @Override // java.util.function.BiFunction
                public String apply(SSLEngine sSLEngine, List<String> list) {
                    return null;
                }
            });
            method4 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.Java9SslUtils.6
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocolSelector", new Class[0]);
                }
            });
            method4.invoke(createSSLEngine, new Object[0]);
            method5 = method6;
        } catch (Throwable th) {
            logger.error("Unable to initialize Java9SslUtils, but the detected javaVersion was: {}", Integer.valueOf(PlatformDependent.javaVersion()), th);
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
        }
        GET_HANDSHAKE_APPLICATION_PROTOCOL = method5;
        GET_APPLICATION_PROTOCOL = method;
        SET_APPLICATION_PROTOCOLS = method2;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method3;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method4;
    }

    private Java9SslUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_APPLICATION_PROTOCOL.invoke(sSLEngine, new Object[0]);
        } catch (UnsupportedOperationException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getHandshakeApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sSLEngine, new Object[0]);
        } catch (UnsupportedOperationException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine sSLEngine) {
        try {
            return (BiFunction) GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, new Object[0]);
        } catch (UnsupportedOperationException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setApplicationProtocols(SSLEngine sSLEngine, List<String> list) {
        SSLParameters sSLParameters = sSLEngine.getSSLParameters();
        try {
            SET_APPLICATION_PROTOCOLS.invoke(sSLParameters, (String[]) list.toArray(EmptyArrays.EMPTY_STRINGS));
            sSLEngine.setSSLParameters(sSLParameters);
        } catch (UnsupportedOperationException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine, BiFunction<SSLEngine, List<String>, String> biFunction) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, biFunction);
        } catch (UnsupportedOperationException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new IllegalStateException(e5);
        }
    }

    static boolean supportsAlpn() {
        return GET_APPLICATION_PROTOCOL != null;
    }
}
