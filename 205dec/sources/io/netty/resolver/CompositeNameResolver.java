package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    public CompositeNameResolver(EventExecutor eventExecutor, NameResolver<T>... nameResolverArr) {
        super(eventExecutor);
        ObjectUtil.checkNotNull(nameResolverArr, "resolvers");
        for (int i4 = 0; i4 < nameResolverArr.length; i4++) {
            if (nameResolverArr[i4] == null) {
                throw new NullPointerException("resolvers[" + i4 + ']');
            }
        }
        if (nameResolverArr.length >= 2) {
            this.resolvers = (NameResolver[]) nameResolverArr.clone();
            return;
        }
        throw new IllegalArgumentException("resolvers: " + Arrays.asList(nameResolverArr) + " (expected: at least 2 resolvers)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllRec(final String str, final Promise<List<T>> promise, final int i4, Throwable th) throws Exception {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i4 >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i4].resolveAll(str).addListener(new FutureListener<List<T>>() { // from class: io.netty.resolver.CompositeNameResolver.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) throws Exception {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveAllRec(str, promise, i4 + 1, future.cause());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveRec(final String str, final Promise<T> promise, final int i4, Throwable th) throws Exception {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i4 >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i4].resolve(str).addListener(new FutureListener<T>() { // from class: io.netty.resolver.CompositeNameResolver.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) throws Exception {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveRec(str, promise, i4 + 1, future.cause());
                    }
                }
            });
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<T> promise) throws Exception {
        doResolveRec(str, promise, 0, null);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<T>> promise) throws Exception {
        doResolveAllRec(str, promise, 0, null);
    }
}
