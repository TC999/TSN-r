package com.trello.rxlifecycle2.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class RxFragment extends Fragment implements LifecycleProvider<FragmentEvent> {

    /* renamed from: a */
    private final BehaviorSubject<FragmentEvent> f37502a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: b */
    public final <T> LifecycleTransformer<T> mo14877I(@NonNull FragmentEvent fragmentEvent) {
        return RxLifecycle.m14871c(this.f37502a, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: n */
    public final Observable<FragmentEvent> mo14875n() {
        return this.f37502a.hide();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f37502a.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f37502a.onNext(FragmentEvent.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f37502a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f37502a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.f37502a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f37502a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f37502a.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f37502a.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f37502a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f37502a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: t */
    public final <T> LifecycleTransformer<T> mo14874t() {
        return RxLifecycleAndroid.m14889b(this.f37502a);
    }
}
