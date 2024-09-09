package com.qq.e.comm.plugin.p.j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class n<T> implements Future<T> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<T> f45274c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Callable<T> callable) {
        this.f45274c = callable;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z3) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException {
        try {
            return this.f45274c.call();
        } catch (Exception e4) {
            throw new ExecutionException(e4);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get(long j4, TimeUnit timeUnit) throws ExecutionException {
        return get();
    }
}
