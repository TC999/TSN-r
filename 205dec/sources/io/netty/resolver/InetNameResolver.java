package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class InetNameResolver extends SimpleNameResolver<InetAddress> {
    private volatile AddressResolver<InetSocketAddress> addressResolver;

    /* JADX INFO: Access modifiers changed from: protected */
    public InetNameResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    public AddressResolver<InetSocketAddress> asAddressResolver() {
        AddressResolver<InetSocketAddress> addressResolver = this.addressResolver;
        if (addressResolver == null) {
            synchronized (this) {
                addressResolver = this.addressResolver;
                if (addressResolver == null) {
                    addressResolver = new InetSocketAddressResolver(executor(), this);
                    this.addressResolver = addressResolver;
                }
            }
        }
        return addressResolver;
    }
}
