package com.trello.rxlifecycle2.android;

import android.view.View;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.MainThreadDisposable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ViewDetachesOnSubscribe.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class c implements ObservableOnSubscribe<Object> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f52381b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final View f52382a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ViewDetachesOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a extends MainThreadDisposable implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final ObservableEmitter<Object> f52383a;

        public a(ObservableEmitter<Object> observableEmitter) {
            this.f52383a = observableEmitter;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void onDispose() {
            c.this.f52382a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f52383a.onNext(c.f52381b);
        }
    }

    public c(View view) {
        this.f52382a = view;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
        MainThreadDisposable.verifyMainThread();
        a aVar = new a(observableEmitter);
        observableEmitter.setDisposable(aVar);
        this.f52382a.addOnAttachStateChangeListener(aVar);
    }
}
