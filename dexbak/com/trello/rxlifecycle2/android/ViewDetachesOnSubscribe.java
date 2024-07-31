package com.trello.rxlifecycle2.android;

import android.view.View;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.MainThreadDisposable;

/* renamed from: com.trello.rxlifecycle2.android.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class ViewDetachesOnSubscribe implements ObservableOnSubscribe<Object> {

    /* renamed from: b */
    static final Object f37483b = new Object();

    /* renamed from: a */
    final View f37484a;

    /* compiled from: ViewDetachesOnSubscribe.java */
    /* renamed from: com.trello.rxlifecycle2.android.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class View$OnAttachStateChangeListenerC13087a extends MainThreadDisposable implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        final ObservableEmitter<Object> f37485a;

        public View$OnAttachStateChangeListenerC13087a(ObservableEmitter<Object> observableEmitter) {
            this.f37485a = observableEmitter;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void onDispose() {
            ViewDetachesOnSubscribe.this.f37484a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f37485a.onNext(ViewDetachesOnSubscribe.f37483b);
        }
    }

    public ViewDetachesOnSubscribe(View view) {
        this.f37484a = view;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
        MainThreadDisposable.verifyMainThread();
        View$OnAttachStateChangeListenerC13087a view$OnAttachStateChangeListenerC13087a = new View$OnAttachStateChangeListenerC13087a(observableEmitter);
        observableEmitter.setDisposable(view$OnAttachStateChangeListenerC13087a);
        this.f37484a.addOnAttachStateChangeListener(view$OnAttachStateChangeListenerC13087a);
    }
}
