package io.netty.util.internal;

import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class PendingWrite {
    private static final Recycler<PendingWrite> RECYCLER = new Recycler<PendingWrite>() { // from class: io.netty.util.internal.PendingWrite.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PendingWrite newObject(Recycler.Handle<PendingWrite> handle) {
            return new PendingWrite(handle);
        }
    };
    private final Recycler.Handle<PendingWrite> handle;
    private Object msg;
    private Promise<Void> promise;

    public static PendingWrite newInstance(Object obj, Promise<Void> promise) {
        PendingWrite pendingWrite = RECYCLER.get();
        pendingWrite.msg = obj;
        pendingWrite.promise = promise;
        return pendingWrite;
    }

    public boolean failAndRecycle(Throwable th) {
        ReferenceCountUtil.release(this.msg);
        Promise<Void> promise = this.promise;
        if (promise != null) {
            promise.setFailure(th);
        }
        return recycle();
    }

    public Object msg() {
        return this.msg;
    }

    public Promise<Void> promise() {
        return this.promise;
    }

    public boolean recycle() {
        this.msg = null;
        this.promise = null;
        this.handle.recycle(this);
        return true;
    }

    public Promise<Void> recycleAndGet() {
        Promise<Void> promise = this.promise;
        recycle();
        return promise;
    }

    public boolean successAndRecycle() {
        Promise<Void> promise = this.promise;
        if (promise != null) {
            promise.setSuccess(null);
        }
        return recycle();
    }

    private PendingWrite(Recycler.Handle<PendingWrite> handle) {
        this.handle = handle;
    }
}
