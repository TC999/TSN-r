package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AbstractAddressResolver<T extends SocketAddress> implements AddressResolver<T> {
    private final EventExecutor executor;
    private final TypeParameterMatcher matcher;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractAddressResolver(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
        this.matcher = TypeParameterMatcher.find(this, AbstractAddressResolver.class, "T");
    }

    @Override // io.netty.resolver.AddressResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected abstract boolean doIsResolved(T t3);

    protected abstract void doResolve(T t3, Promise<T> promise) throws Exception;

    protected abstract void doResolveAll(T t3, Promise<List<T>> promise) throws Exception;

    protected EventExecutor executor() {
        return this.executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final boolean isResolved(SocketAddress socketAddress) {
        if (isSupported(socketAddress)) {
            return doIsResolved(socketAddress);
        }
        throw new UnsupportedAddressTypeException();
    }

    @Override // io.netty.resolver.AddressResolver
    public boolean isSupported(SocketAddress socketAddress) {
        return this.matcher.match(socketAddress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<T> resolve(SocketAddress socketAddress) {
        if (!isSupported((SocketAddress) ObjectUtil.checkNotNull(socketAddress, "address"))) {
            return executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return this.executor.newSucceededFuture(socketAddress);
        }
        try {
            Promise<T> newPromise = executor().newPromise();
            doResolve(socketAddress, newPromise);
            return newPromise;
        } catch (Exception e4) {
            return executor().newFailedFuture(e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<List<T>> resolveAll(SocketAddress socketAddress) {
        if (!isSupported((SocketAddress) ObjectUtil.checkNotNull(socketAddress, "address"))) {
            return executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return this.executor.newSucceededFuture(Collections.singletonList(socketAddress));
        }
        try {
            Promise<List<T>> newPromise = executor().newPromise();
            doResolveAll(socketAddress, newPromise);
            return newPromise;
        } catch (Exception e4) {
            return executor().newFailedFuture(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractAddressResolver(EventExecutor eventExecutor, Class<? extends T> cls) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
        this.matcher = TypeParameterMatcher.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<T> resolve(SocketAddress socketAddress, Promise<T> promise) {
        ObjectUtil.checkNotNull(socketAddress, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isSupported(socketAddress)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return promise.setSuccess(socketAddress);
        }
        try {
            doResolve(socketAddress, promise);
            return promise;
        } catch (Exception e4) {
            return promise.setFailure(e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<List<T>> resolveAll(SocketAddress socketAddress, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(socketAddress, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isSupported(socketAddress)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return promise.setSuccess(Collections.singletonList(socketAddress));
        }
        try {
            doResolveAll(socketAddress, promise);
            return promise;
        } catch (Exception e4) {
            return promise.setFailure(e4);
        }
    }
}
