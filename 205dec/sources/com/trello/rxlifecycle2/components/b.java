package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.android.FragmentEvent;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RxDialogFragment.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class b extends DialogFragment implements com.trello.rxlifecycle2.b<FragmentEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<FragmentEvent> f52394a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: a */
    public final <T> com.trello.rxlifecycle2.c<T> I(@NonNull FragmentEvent fragmentEvent) {
        return com.trello.rxlifecycle2.d.c(this.f52394a, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> n() {
        return this.f52394a.hide();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f52394a.onNext(FragmentEvent.ATTACH);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f52394a.onNext(FragmentEvent.CREATE);
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onDestroy() {
        this.f52394a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onDestroyView() {
        this.f52394a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onDetach() {
        this.f52394a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onPause() {
        this.f52394a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f52394a.onNext(FragmentEvent.RESUME);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onStart() {
        super.onStart();
        this.f52394a.onNext(FragmentEvent.START);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onStop() {
        this.f52394a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f52394a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> com.trello.rxlifecycle2.c<T> t() {
        return com.trello.rxlifecycle2.android.b.b(this.f52394a);
    }
}
