package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Cleaner0 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CLEANER_FIELD_OFFSET;
    private static final boolean CLEANER_IS_RUNNABLE;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Cleaner0.class);

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    static {
        /*
            java.lang.Class<io.netty.util.internal.Cleaner0> r0 = io.netty.util.internal.Cleaner0.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance(r0)
            io.netty.util.internal.Cleaner0.logger = r0
            r0 = 1
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r0)
            boolean r2 = io.netty.util.internal.PlatformDependent0.hasUnsafe()
            r3 = 0
            r4 = -1
            r6 = 0
            if (r2 == 0) goto L48
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.Throwable -> L48
            java.lang.String r7 = "cleaner"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r7)     // Catch: java.lang.Throwable -> L48
            r2.setAccessible(r0)     // Catch: java.lang.Throwable -> L48
            long r7 = io.netty.util.internal.PlatformDependent0.objectFieldOffset(r2)     // Catch: java.lang.Throwable -> L48
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L48
            r9 = r2
            java.lang.Runnable r9 = (java.lang.Runnable) r9     // Catch: java.lang.ClassCastException -> L33 java.lang.Throwable -> L48
            r9.run()     // Catch: java.lang.ClassCastException -> L33 java.lang.Throwable -> L48
            goto L46
        L33:
            java.lang.Class r0 = r2.getClass()     // Catch: java.lang.Throwable -> L48
            java.lang.String r9 = "clean"
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> L48
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r9, r10)     // Catch: java.lang.Throwable -> L48
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L48
            r0.invoke(r2, r9)     // Catch: java.lang.Throwable -> L48
            r3 = r0
            r0 = 0
        L46:
            r6 = r0
            goto L49
        L48:
            r7 = r4
        L49:
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.Cleaner0.logger
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 == 0) goto L52
            java.lang.String r2 = "available"
            goto L54
        L52:
            java.lang.String r2 = "unavailable"
        L54:
            java.lang.String r4 = "java.nio.ByteBuffer.cleaner(): {}"
            r0.debug(r4, r2)
            io.netty.util.internal.Cleaner0.CLEANER_FIELD_OFFSET = r7
            io.netty.util.internal.Cleaner0.CLEAN_METHOD = r3
            io.netty.util.internal.Cleaner0.CLEANER_IS_RUNNABLE = r6
            freeDirectBuffer(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.Cleaner0.<clinit>():void");
    }

    private Cleaner0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        long j = CLEANER_FIELD_OFFSET;
        if (j != -1 && byteBuffer.isDirect()) {
            try {
                Object object = PlatformDependent0.getObject(byteBuffer, j);
                if (object != null) {
                    if (CLEANER_IS_RUNNABLE) {
                        ((Runnable) object).run();
                    } else {
                        CLEAN_METHOD.invoke(object, new Object[0]);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
