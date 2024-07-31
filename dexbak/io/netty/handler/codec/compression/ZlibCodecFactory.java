package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ZlibCodecFactory {
    private static final int DEFAULT_JDK_MEM_LEVEL = 8;
    private static final int DEFAULT_JDK_WINDOW_SIZE = 15;
    private static final InternalLogger logger;
    private static final boolean noJdkZlibDecoder;
    private static final boolean noJdkZlibEncoder;
    private static final boolean supportsWindowSizeAndMemLevel;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ZlibCodecFactory.class);
        logger = internalLoggerFactory;
        boolean z = true;
        boolean z2 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", PlatformDependent.javaVersion() < 7);
        noJdkZlibDecoder = z2;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(z2));
        boolean z3 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
        noJdkZlibEncoder = z3;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(z3));
        if (!z2 && PlatformDependent.javaVersion() < 7) {
            z = false;
        }
        supportsWindowSizeAndMemLevel = z;
    }

    private ZlibCodecFactory() {
    }

    public static boolean isSupportingWindowSizeAndMemLevel() {
        return supportsWindowSizeAndMemLevel;
    }

    public static ZlibDecoder newZlibDecoder() {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder();
        }
        return new JZlibDecoder();
    }

    public static ZlibEncoder newZlibEncoder(int i) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(i);
        }
        return new JZlibEncoder(i);
    }

    public static ZlibDecoder newZlibDecoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(zlibWrapper);
        }
        return new JZlibDecoder(zlibWrapper);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper);
        }
        return new JZlibEncoder(zlibWrapper);
    }

    public static ZlibDecoder newZlibDecoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibDecoder) {
            return new JdkZlibDecoder(bArr);
        }
        return new JZlibDecoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(zlibWrapper, i);
        }
        return new JZlibEncoder(zlibWrapper, i);
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i, int i2, int i3) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i2 == 15 && i3 == 8) {
            return new JdkZlibEncoder(zlibWrapper, i);
        }
        return new JZlibEncoder(zlibWrapper, i, i2, i3);
    }

    public static ZlibEncoder newZlibEncoder(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(bArr);
        }
        return new JZlibEncoder(bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder) {
            return new JdkZlibEncoder(i, bArr);
        }
        return new JZlibEncoder(i, bArr);
    }

    public static ZlibEncoder newZlibEncoder(int i, int i2, int i3, byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i2 == 15 && i3 == 8) {
            return new JdkZlibEncoder(i, bArr);
        }
        return new JZlibEncoder(i, i2, i3, bArr);
    }
}
