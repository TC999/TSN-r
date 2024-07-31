package io.netty.util.internal.logging;

import io.netty.util.internal.ThreadLocalRandom;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory = newDefaultFactory(InternalLoggerFactory.class.getName());

    static {
        try {
            Class.forName(ThreadLocalRandom.class.getName(), true, InternalLoggerFactory.class.getClassLoader());
        } catch (Exception unused) {
        }
    }

    public static InternalLoggerFactory getDefaultFactory() {
        return defaultFactory;
    }

    public static InternalLogger getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    private static InternalLoggerFactory newDefaultFactory(String str) {
        try {
            try {
                Slf4JLoggerFactory slf4JLoggerFactory = new Slf4JLoggerFactory(true);
                slf4JLoggerFactory.newInstance(str).debug("Using SLF4J as the default logging framework");
                return slf4JLoggerFactory;
            } catch (Throwable unused) {
                InternalLoggerFactory internalLoggerFactory = JdkLoggerFactory.INSTANCE;
                internalLoggerFactory.newInstance(str).debug("Using java.util.logging as the default logging framework");
                return internalLoggerFactory;
            }
        } catch (Throwable unused2) {
            InternalLoggerFactory internalLoggerFactory2 = Log4JLoggerFactory.INSTANCE;
            internalLoggerFactory2.newInstance(str).debug("Using Log4J as the default logging framework");
            return internalLoggerFactory2;
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
