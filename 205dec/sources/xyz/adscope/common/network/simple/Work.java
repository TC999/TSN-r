package xyz.adscope.common.network.simple;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.simple.SimpleRequest;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
final class Work<T extends SimpleRequest, S, F> extends FutureTask<SimpleResponse<S, F>> implements Canceller {

    /* renamed from: a  reason: collision with root package name */
    public BasicWorker<T, S, F> f65016a;

    /* renamed from: b  reason: collision with root package name */
    public final Callback<S, F> f65017b;

    public Work(BasicWorker<T, S, F> basicWorker, Callback<S, F> callback) {
        super(basicWorker);
        this.f65016a = basicWorker;
        this.f65017b = callback;
    }

    @Override // xyz.adscope.common.network.Canceller
    public void cancel() {
        cancel(true);
        this.f65016a.cancel();
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        Callback<S, F> callback;
        try {
            this.f65017b.onResponse(get());
        } catch (CancellationException unused) {
            this.f65017b.onCancel();
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (!isCancelled()) {
                if (cause == null || !(cause instanceof Exception)) {
                    this.f65017b.onException(new Exception(cause));
                } else {
                    callback = this.f65017b;
                    e = (Exception) cause;
                    callback.onException(e);
                }
            }
            this.f65017b.onCancel();
        } catch (Exception e5) {
            e = e5;
            if (!isCancelled()) {
                callback = this.f65017b;
                callback.onException(e);
            }
            this.f65017b.onCancel();
        }
        this.f65017b.onEnd();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f65017b.onStart();
        super.run();
    }
}
