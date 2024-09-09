package io.netty.util.internal.logging;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory;

    public static InternalLoggerFactory getDefaultFactory() {
        if (defaultFactory == null) {
            defaultFactory = newDefaultFactory(InternalLoggerFactory.class.getName());
        }
        return defaultFactory;
    }

    public static InternalLogger getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    private static InternalLoggerFactory newDefaultFactory(String str) {
        try {
            try {
                try {
                    Slf4JLoggerFactory slf4JLoggerFactory = new Slf4JLoggerFactory(true);
                    slf4JLoggerFactory.newInstance(str).debug("Using SLF4J as the default logging framework");
                    return slf4JLoggerFactory;
                } catch (Throwable unused) {
                    InternalLoggerFactory internalLoggerFactory = Log4J2LoggerFactory.INSTANCE;
                    internalLoggerFactory.newInstance(str).debug("Using Log4J2 as the default logging framework");
                    return internalLoggerFactory;
                }
            } catch (Throwable unused2) {
                InternalLoggerFactory internalLoggerFactory2 = JdkLoggerFactory.INSTANCE;
                internalLoggerFactory2.newInstance(str).debug("Using java.util.logging as the default logging framework");
                return internalLoggerFactory2;
            }
        } catch (Throwable unused3) {
            InternalLoggerFactory internalLoggerFactory3 = Log4JLoggerFactory.INSTANCE;
            internalLoggerFactory3.newInstance(str).debug("Using Log4J as the default logging framework");
            return internalLoggerFactory3;
        }
    }

    public static void setDefaultFactory(InternalLoggerFactory internalLoggerFactory) {
        if (internalLoggerFactory != null) {
            defaultFactory = internalLoggerFactory;
            return;
        }
        throw new NullPointerException("defaultFactory");
    }

    protected abstract InternalLogger newInstance(String str);

    public static InternalLogger getInstance(String str) {
        return getDefaultFactory().newInstance(str);
    }
}
