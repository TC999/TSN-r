package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DnsCacheEntry {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InetAddress address;
    private final Throwable cause;
    private volatile ScheduledFuture<?> expirationFuture;
    private final String hostname;

    public DnsCacheEntry(String str, InetAddress inetAddress) {
        this.hostname = (String) ObjectUtil.checkNotNull(str, "hostname");
        this.address = (InetAddress) ObjectUtil.checkNotNull(inetAddress, "address");
        this.cause = null;
    }

    public InetAddress address() {
        return this.address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelExpiration() {
        ScheduledFuture<?> scheduledFuture = this.expirationFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public Throwable cause() {
        return this.cause;
    }

    public String hostname() {
        return this.hostname;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleExpiration(EventLoop eventLoop, Runnable runnable, long j, TimeUnit timeUnit) {
        this.expirationFuture = eventLoop.schedule(runnable, j, timeUnit);
    }

    public String toString() {
        if (this.cause != null) {
            return this.hostname + '/' + this.cause;
        }
        return this.address.toString();
    }

    public DnsCacheEntry(String str, Throwable th) {
        this.hostname = (String) ObjectUtil.checkNotNull(str, "hostname");
        this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
        this.address = null;
    }
}
