package io.netty.util;

import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ReferenceCountUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountUtil.class);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class ReleasingTask implements Runnable {
        private final int decrement;
        private final ReferenceCounted obj;

        ReleasingTask(ReferenceCounted referenceCounted, int i) {
            this.obj = referenceCounted;
            this.decrement = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.obj.release(this.decrement)) {
                    ReferenceCountUtil.logger.warn("Non-zero refCnt: {}", this);
                } else {
                    ReferenceCountUtil.logger.debug("Released: {}", this);
                }
            } catch (Exception e) {
                ReferenceCountUtil.logger.warn("Failed to release an object: {}", this.obj, e);
            }
        }

        public String toString() {
            return StringUtil.simpleClassName(this.obj) + ".release(" + this.decrement + ") refCnt: " + this.obj.refCnt();
        }
    }

    private ReferenceCountUtil() {
    }

    public static boolean release(Object obj) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release();
        }
        return false;
    }

    public static <T> T releaseLater(T t) {
        return (T) releaseLater(t, 1);
    }

    public static <T> T retain(T t) {
        return t instanceof ReferenceCounted ? (T) ((ReferenceCounted) t).retain() : t;
    }

    public static void safeRelease(Object obj) {
        try {
            release(obj);
        } catch (Throwable th) {
            logger.warn("Failed to release a message: {}", obj, th);
        }
    }

    public static <T> T touch(T t) {
        return t instanceof ReferenceCounted ? (T) ((ReferenceCounted) t).touch() : t;
    }

    public static <T> T releaseLater(T t, int i) {
        if (t instanceof ReferenceCounted) {
            ThreadDeathWatcher.watch(Thread.currentThread(), new ReleasingTask((ReferenceCounted) t, i));
        }
        return t;
    }

    public static boolean release(Object obj, int i) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release(i);
        }
        return false;
    }

    public static <T> T retain(T t, int i) {
        return t instanceof ReferenceCounted ? (T) ((ReferenceCounted) t).retain(i) : t;
    }

    public static void safeRelease(Object obj, int i) {
        try {
            release(obj, i);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to release a message: {} (decrement: {})", obj, Integer.valueOf(i), th);
            }
        }
    }

    public static <T> T touch(T t, Object obj) {
        return t instanceof ReferenceCounted ? (T) ((ReferenceCounted) t).touch(obj) : t;
    }
}
