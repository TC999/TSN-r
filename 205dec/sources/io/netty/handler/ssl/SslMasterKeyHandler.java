package io.netty.handler.ssl;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.internal.tcnative.SSL;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class SslMasterKeyHandler extends ChannelInboundHandlerAdapter {
    private static final Class<?> SSL_SESSIONIMPL_CLASS;
    private static final Field SSL_SESSIONIMPL_MASTER_SECRET_FIELD;
    public static final String SYSTEM_PROP_KEY = "io.netty.ssl.masterKeyHandler";
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslMasterKeyHandler.class);

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class WiresharkSslMasterKeyHandler extends SslMasterKeyHandler {
        private static final InternalLogger wireshark_logger = InternalLoggerFactory.getInstance("io.netty.wireshark");
        private static final char[] hexCode = "0123456789ABCDEF".toCharArray();

        private WiresharkSslMasterKeyHandler() {
        }

        @Override // io.netty.handler.ssl.SslMasterKeyHandler
        protected void accept(SecretKey secretKey, SSLSession sSLSession) {
            if (secretKey.getEncoded().length == 48) {
                wireshark_logger.warn("RSA Session-ID:{} Master-Key:{}", ByteBufUtil.hexDump(sSLSession.getId()).toLowerCase(), ByteBufUtil.hexDump(secretKey.getEncoded()).toLowerCase());
                return;
            }
            throw new IllegalArgumentException("An invalid length master key was provided.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Class<?>] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v8 */
    static {
        Throwable th;
        Field field;
        ?? r12;
        Field field2 = null;
        try {
            ?? cls = Class.forName("sun.security.ssl.SSLSessionImpl");
            try {
                field2 = cls.getDeclaredField("masterSecret");
                th = ReflectionUtil.trySetAccessible(field2, true);
                r12 = cls;
            } catch (Throwable th2) {
                th = th2;
                field = field2;
                field2 = cls;
                logger.debug("sun.security.ssl.SSLSessionImpl is unavailable.", th);
                Field field3 = field;
                r12 = field2;
                field2 = field3;
                UNAVAILABILITY_CAUSE = th;
                SSL_SESSIONIMPL_CLASS = r12;
                SSL_SESSIONIMPL_MASTER_SECRET_FIELD = field2;
            }
        } catch (Throwable th3) {
            th = th3;
            field = null;
        }
        UNAVAILABILITY_CAUSE = th;
        SSL_SESSIONIMPL_CLASS = r12;
        SSL_SESSIONIMPL_MASTER_SECRET_FIELD = field2;
    }

    protected SslMasterKeyHandler() {
    }

    public static void ensureSunSslEngineAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw new IllegalStateException("Failed to find SSLSessionImpl on classpath", th);
        }
    }

    public static boolean isSunSslEngineAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static SslMasterKeyHandler newWireSharkSslMasterKeyHandler() {
        return new WiresharkSslMasterKeyHandler();
    }

    public static Throwable sunSslEngineUnavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    protected abstract void accept(SecretKey secretKey, SSLSession sSLSession);

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj == SslHandshakeCompletionEvent.SUCCESS && SystemPropertyUtil.getBoolean(SYSTEM_PROP_KEY, false)) {
            SSLEngine engine = ((SslHandler) channelHandlerContext.pipeline().get(SslHandler.class)).engine();
            SSLSession session = engine.getSession();
            if (isSunSslEngineAvailable() && session.getClass().equals(SSL_SESSIONIMPL_CLASS)) {
                try {
                    accept((SecretKey) SSL_SESSIONIMPL_MASTER_SECRET_FIELD.get(session), session);
                } catch (IllegalAccessException e4) {
                    throw new IllegalArgumentException("Failed to access the field 'masterSecret' via reflection.", e4);
                }
            } else if (OpenSsl.isAvailable() && (engine instanceof ReferenceCountedOpenSslEngine)) {
                accept(new SecretKeySpec(SSL.getMasterKey(((ReferenceCountedOpenSslEngine) engine).sslPointer()), "AES"), session);
            }
        }
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
