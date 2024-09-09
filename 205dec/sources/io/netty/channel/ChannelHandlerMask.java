package io.netty.channel;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class ChannelHandlerMask {
    private static final int MASK_ALL_INBOUND = 511;
    private static final int MASK_ALL_OUTBOUND = 130561;
    static final int MASK_BIND = 512;
    static final int MASK_CHANNEL_ACTIVE = 8;
    static final int MASK_CHANNEL_INACTIVE = 16;
    static final int MASK_CHANNEL_READ = 32;
    static final int MASK_CHANNEL_READ_COMPLETE = 64;
    static final int MASK_CHANNEL_REGISTERED = 2;
    static final int MASK_CHANNEL_UNREGISTERED = 4;
    static final int MASK_CHANNEL_WRITABILITY_CHANGED = 256;
    static final int MASK_CLOSE = 4096;
    static final int MASK_CONNECT = 1024;
    static final int MASK_DEREGISTER = 8192;
    static final int MASK_DISCONNECT = 2048;
    static final int MASK_EXCEPTION_CAUGHT = 1;
    static final int MASK_FLUSH = 65536;
    static final int MASK_READ = 16384;
    static final int MASK_USER_EVENT_TRIGGERED = 128;
    static final int MASK_WRITE = 32768;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelHandlerMask.class);
    private static final FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>> MASKS = new FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>>() { // from class: io.netty.channel.ChannelHandlerMask.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Map<Class<? extends ChannelHandler>, Integer> initialValue() {
            return new WeakHashMap(32);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface Skip {
    }

    private ChannelHandlerMask() {
    }

    private static boolean isSkippable(final Class<?> cls, final String str, final Class<?>... clsArr) throws Exception {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() { // from class: io.netty.channel.ChannelHandlerMask.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedExceptionAction
            public Boolean run() throws Exception {
                boolean z3 = true;
                try {
                    Method method = cls.getMethod(str, clsArr);
                    return Boolean.valueOf((method == null || !method.isAnnotationPresent(Skip.class)) ? false : false);
                } catch (NoSuchMethodException e4) {
                    ChannelHandlerMask.logger.debug("Class {} missing method {}, assume we can not skip execution", cls, str, e4);
                    return Boolean.FALSE;
                }
            }
        })).booleanValue();
    }

    static int mask(Class<? extends ChannelHandler> cls) {
        Map<Class<? extends ChannelHandler>, Integer> map = MASKS.get();
        Integer num = map.get(cls);
        if (num == null) {
            num = Integer.valueOf(mask0(cls));
            map.put(cls, num);
        }
        return num.intValue();
    }

    private static int mask0(Class<? extends ChannelHandler> cls) {
        int i4;
        int i5 = 1;
        try {
            if (ChannelInboundHandler.class.isAssignableFrom(cls)) {
                try {
                    i4 = isSkippable(cls, "channelRegistered", ChannelHandlerContext.class) ? 509 : 511;
                } catch (Exception e4) {
                    e = e4;
                    i5 = 511;
                    PlatformDependent.throwException(e);
                    return i5;
                }
                try {
                    if (isSkippable(cls, "channelUnregistered", ChannelHandlerContext.class)) {
                        i4 &= -5;
                    }
                    if (isSkippable(cls, "channelActive", ChannelHandlerContext.class)) {
                        i4 &= -9;
                    }
                    if (isSkippable(cls, "channelInactive", ChannelHandlerContext.class)) {
                        i4 &= -17;
                    }
                    if (isSkippable(cls, "channelRead", ChannelHandlerContext.class, Object.class)) {
                        i4 &= -33;
                    }
                    if (isSkippable(cls, "channelReadComplete", ChannelHandlerContext.class)) {
                        i4 &= -65;
                    }
                    if (isSkippable(cls, "channelWritabilityChanged", ChannelHandlerContext.class)) {
                        i4 &= -257;
                    }
                    if (isSkippable(cls, "userEventTriggered", ChannelHandlerContext.class, Object.class)) {
                        i4 &= -129;
                    }
                } catch (Exception e5) {
                    e = e5;
                    i5 = i4;
                    PlatformDependent.throwException(e);
                    return i5;
                }
            } else {
                i4 = 1;
            }
            if (ChannelOutboundHandler.class.isAssignableFrom(cls)) {
                i4 |= MASK_ALL_OUTBOUND;
                if (isSkippable(cls, "bind", ChannelHandlerContext.class, SocketAddress.class, ChannelPromise.class)) {
                    i4 &= -513;
                }
                if (isSkippable(cls, "connect", ChannelHandlerContext.class, SocketAddress.class, SocketAddress.class, ChannelPromise.class)) {
                    i4 &= -1025;
                }
                if (isSkippable(cls, "disconnect", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i4 &= -2049;
                }
                if (isSkippable(cls, "close", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i4 &= -4097;
                }
                if (isSkippable(cls, "deregister", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i4 &= -8193;
                }
                if (isSkippable(cls, "read", ChannelHandlerContext.class)) {
                    i4 &= -16385;
                }
                if (isSkippable(cls, "write", ChannelHandlerContext.class, Object.class, ChannelPromise.class)) {
                    i4 = (-32769) & i4;
                }
                if (isSkippable(cls, "flush", ChannelHandlerContext.class)) {
                    i4 &= -65537;
                }
            }
            return isSkippable(cls, "exceptionCaught", ChannelHandlerContext.class, Throwable.class) ? i4 & (-2) : i4;
        } catch (Exception e6) {
            e = e6;
        }
    }
}
