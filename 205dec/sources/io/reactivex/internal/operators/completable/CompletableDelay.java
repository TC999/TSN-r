package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    final class Delay implements CompletableObserver {

        /* renamed from: s  reason: collision with root package name */
        final CompletableObserver f54866s;
        private final CompositeDisposable set;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f54866s.onComplete();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class OnError implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            private final Throwable f54867e;

            OnError(Throwable th) {
                this.f54867e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f54866s.onError(this.f54867e);
            }
        }

        Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.f54866s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            CompositeDisposable compositeDisposable = this.set;
            Scheduler scheduler = CompletableDelay.this.scheduler;
            OnComplete onComplete = new OnComplete();
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.add(scheduler.scheduleDirect(onComplete, completableDelay.delay, completableDelay.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            CompositeDisposable compositeDisposable = this.set;
            Scheduler scheduler = CompletableDelay.this.scheduler;
            OnError onError = new OnError(th);
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.add(scheduler.scheduleDirect(onError, completableDelay.delayError ? completableDelay.delay : 0L, completableDelay.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.f54866s.onSubscribe(this.set);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j4, TimeUnit timeUnit, Scheduler scheduler, boolean z3) {
        this.source = completableSource;
        this.delay = j4;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z3;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }
}
