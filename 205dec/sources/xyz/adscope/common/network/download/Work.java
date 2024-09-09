package xyz.adscope.common.network.download;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.download.Download;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Work<T extends Download> extends FutureTask<String> implements Canceller {

    /* renamed from: a  reason: collision with root package name */
    public BasicWorker<T> f64961a;

    /* renamed from: b  reason: collision with root package name */
    public final Callback f64962b;

    public Work(BasicWorker<T> basicWorker, Callback callback) {
        super(basicWorker);
        this.f64961a = basicWorker;
        this.f64962b = callback;
    }

    @Override // xyz.adscope.common.network.Canceller
    public void cancel() {
        cancel(true);
        this.f64961a.cancel();
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        Callback callback;
        try {
            this.f64962b.onFinish(get());
        } catch (CancellationException unused) {
            this.f64962b.onCancel();
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (!isCancelled()) {
                if (cause == null || !(cause instanceof Exception)) {
                    this.f64962b.onException(new Exception(cause));
                } else {
                    callback = this.f64962b;
                    e = (Exception) cause;
                    callback.onException(e);
                }
            }
            this.f64962b.onCancel();
        } catch (Exception e5) {
            e = e5;
            if (!isCancelled()) {
                callback = this.f64962b;
                callback.onException(e);
            }
            this.f64962b.onCancel();
        }
        this.f64962b.onEnd();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f64962b.onStart();
        super.run();
    }
}
