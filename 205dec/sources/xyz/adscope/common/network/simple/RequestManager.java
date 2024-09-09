package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import xyz.adscope.common.network.CancelerManager;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.Kalle;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RequestManager {

    /* renamed from: c  reason: collision with root package name */
    public static RequestManager f64977c;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f64978a = Kalle.getConfig().getWorkExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final CancelerManager f64979b = new CancelerManager();

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AsyncCallback<S, F> extends Callback<S, F> {

        /* renamed from: a  reason: collision with root package name */
        public final Callback<S, F> f64984a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f64985b = Kalle.getConfig().getMainExecutor();

        public AsyncCallback(Callback<S, F> callback) {
            this.f64984a = callback;
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public Type getFailed() {
            return this.f64984a.getFailed();
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public Type getSucceed() {
            return this.f64984a.getSucceed();
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onCancel() {
            if (this.f64984a == null) {
                return;
            }
            this.f64985b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64984a.onCancel();
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onEnd() {
            if (this.f64984a == null) {
                return;
            }
            this.f64985b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64984a.onEnd();
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onException(final Exception exc) {
            if (this.f64984a == null) {
                return;
            }
            this.f64985b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64984a.onException(exc);
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onResponse(final SimpleResponse<S, F> simpleResponse) {
            if (this.f64984a == null) {
                return;
            }
            this.f64985b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64984a.onResponse(simpleResponse);
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onStart() {
            if (this.f64984a == null) {
                return;
            }
            this.f64985b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64984a.onStart();
                }
            });
        }
    }

    public static RequestManager getInstance() {
        if (f64977c == null) {
            synchronized (RequestManager.class) {
                if (f64977c == null) {
                    f64977c = new RequestManager();
                }
            }
        }
        return f64977c;
    }

    public void cancel(Object obj) {
        this.f64979b.cancel(obj);
    }

    public <S, F> Canceller perform(final SimpleBodyRequest simpleBodyRequest, Callback<S, F> callback) {
        Work work = new Work(new BodyWorker(simpleBodyRequest, callback.getSucceed(), callback.getFailed()), new AsyncCallback<S, F>(callback) { // from class: xyz.adscope.common.network.simple.RequestManager.2
            @Override // xyz.adscope.common.network.simple.RequestManager.AsyncCallback, xyz.adscope.common.network.simple.Callback
            public void onEnd() {
                super.onEnd();
                RequestManager.this.f64979b.removeCancel(simpleBodyRequest);
            }
        });
        this.f64979b.addCancel(simpleBodyRequest, work);
        this.f64978a.execute(work);
        return work;
    }

    public <S, F> Canceller perform(final SimpleUrlRequest simpleUrlRequest, Callback<S, F> callback) {
        Work work = new Work(new UrlWorker(simpleUrlRequest, callback.getSucceed(), callback.getFailed()), new AsyncCallback<S, F>(callback) { // from class: xyz.adscope.common.network.simple.RequestManager.1
            @Override // xyz.adscope.common.network.simple.RequestManager.AsyncCallback, xyz.adscope.common.network.simple.Callback
            public void onEnd() {
                super.onEnd();
                RequestManager.this.f64979b.removeCancel(simpleUrlRequest);
            }
        });
        this.f64979b.addCancel(simpleUrlRequest, work);
        this.f64978a.execute(work);
        return work;
    }

    public <S, F> SimpleResponse<S, F> perform(SimpleBodyRequest simpleBodyRequest, Type type, Type type2) {
        return new BodyWorker(simpleBodyRequest, type, type2).call();
    }

    public <S, F> SimpleResponse<S, F> perform(SimpleUrlRequest simpleUrlRequest, Type type, Type type2) {
        return new UrlWorker(simpleUrlRequest, type, type2).call();
    }
}
