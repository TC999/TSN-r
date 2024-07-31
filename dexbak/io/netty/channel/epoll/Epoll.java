package io.netty.channel.epoll;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    static {
        /*
            r0 = 0
            io.netty.channel.unix.FileDescriptor r1 = io.netty.channel.epoll.Native.newEpollCreate()     // Catch: java.lang.Throwable -> L19
            io.netty.channel.unix.FileDescriptor r2 = io.netty.channel.epoll.Native.newEventFd()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L10
            r1.close()     // Catch: java.lang.Exception -> Lf
            goto L10
        Lf:
        L10:
            if (r2 == 0) goto L15
            r2.close()     // Catch: java.lang.Exception -> L15
        L15:
            r2 = r0
            goto L22
        L17:
            r2 = move-exception
            goto L1b
        L19:
            r2 = move-exception
            r1 = r0
        L1b:
            if (r1 == 0) goto L22
            r1.close()     // Catch: java.lang.Exception -> L21
            goto L22
        L21:
        L22:
            if (r2 == 0) goto L27
            io.netty.channel.epoll.Epoll.UNAVAILABILITY_CAUSE = r2
            goto L37
        L27:
            boolean r1 = io.netty.util.internal.PlatformDependent.hasUnsafe()
            if (r1 == 0) goto L2e
            goto L35
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "sun.misc.Unsafe not available"
            r0.<init>(r1)
        L35:
            io.netty.channel.epoll.Epoll.UNAVAILABILITY_CAUSE = r0
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.Epoll.<clinit>():void");
    }

    private Epoll() {
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }
}
