package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    final class Delay implements CompletableObserver {

        /* renamed from: s */
        final CompletableObserver f40383s;
        private final CompositeDisposable set;

        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f40383s.onComplete();
            }
        }

        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class OnError implements Runnable {

            /* renamed from: e */
            private final Throwable f40384e;

            OnError(Throwable th) {
                this.f40384e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f40383s.onError(this.f40384e);
            }
        }

        Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.f40383s = completableObserver;
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
            this.f40383s.onSubscribe(this.set);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }
}
