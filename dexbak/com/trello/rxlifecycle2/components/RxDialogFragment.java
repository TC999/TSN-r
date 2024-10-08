package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* renamed from: com.trello.rxlifecycle2.components.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class RxDialogFragment extends DialogFragment implements LifecycleProvider<FragmentEvent> {

    /* renamed from: a */
    private final BehaviorSubject<FragmentEvent> f37496a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: a */
    public final <T> LifecycleTransformer<T> mo14877I(@NonNull FragmentEvent fragmentEvent) {
        return RxLifecycle.m14871c(this.f37496a, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: n */
    public final Observable<FragmentEvent> mo14875n() {
        return this.f37496a.hide();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f37496a.onNext(FragmentEvent.ATTACH);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f37496a.onNext(FragmentEvent.CREATE);
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onDestroy() {
        this.f37496a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onDestroyView() {
        this.f37496a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onDetach() {
        this.f37496a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onPause() {
        this.f37496a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f37496a.onNext(FragmentEvent.RESUME);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onStart() {
        super.onStart();
        this.f37496a.onNext(FragmentEvent.START);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @CallSuper
    public void onStop() {
        this.f37496a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f37496a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: t */
    public final <T> LifecycleTransformer<T> mo14874t() {
        return RxLifecycleAndroid.m14889b(this.f37496a);
    }
}
