package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CleanerJava9 implements Cleaner {
    private static final Method INVOKE_CLEANER;
    private static final InternalLogger logger;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    static {
        /*
            java.lang.Class<io.netty.util.internal.CleanerJava9> r0 = io.netty.util.internal.CleanerJava9.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance(r0)
            io.netty.util.internal.CleanerJava9.logger = r0
            boolean r1 = io.netty.util.internal.PlatformDependent0.hasUnsafe()
            r2 = 0
            if (r1 == 0) goto L27
            r1 = 1
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            io.netty.util.internal.CleanerJava9$1 r3 = new io.netty.util.internal.CleanerJava9$1
            r3.<init>()
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r3)
            boolean r3 = r1 instanceof java.lang.Throwable
            if (r3 == 0) goto L24
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            goto L2e
        L24:
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            goto L31
        L27:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r3 = "sun.misc.Unsafe unavailable"
            r1.<init>(r3)
        L2e:
            r4 = r2
            r2 = r1
            r1 = r4
        L31:
            if (r2 != 0) goto L39
            java.lang.String r2 = "java.nio.ByteBuffer.cleaner(): available"
            r0.debug(r2)
            goto L3e
        L39:
            java.lang.String r3 = "java.nio.ByteBuffer.cleaner(): unavailable"
            r0.debug(r3, r2)
        L3e:
            io.netty.util.internal.CleanerJava9.INVOKE_CLEANER = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.CleanerJava9.<clinit>():void");
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Exception exc = (Exception) AccessController.doPrivileged(new PrivilegedAction<Exception>() { // from class: io.netty.util.internal.CleanerJava9.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Exception run() {
                try {
                    CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
                    return null;
                } catch (IllegalAccessException e4) {
                    return e4;
                } catch (InvocationTargetException e5) {
                    return e5;
                }
            }
        });
        if (exc != null) {
            PlatformDependent0.throwException(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupported() {
        return INVOKE_CLEANER != null;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (System.getSecurityManager() == null) {
            try {
                INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer);
                return;
            } catch (Throwable th) {
                PlatformDependent0.throwException(th);
                return;
            }
        }
        freeDirectBufferPrivileged(byteBuffer);
    }
}
