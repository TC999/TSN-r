package com.trello.rxlifecycle2.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.b;
import com.trello.rxlifecycle2.c;
import com.trello.rxlifecycle2.d;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class RxDialogFragment extends DialogFragment implements b<FragmentEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<FragmentEvent> f52399a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: b */
    public final <T> c<T> I(@NonNull FragmentEvent fragmentEvent) {
        return d.c(this.f52399a, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> n() {
        return this.f52399a.hide();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f52399a.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f52399a.onNext(FragmentEvent.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onDestroy() {
        this.f52399a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onDestroyView() {
        this.f52399a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onDetach() {
        this.f52399a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPause() {
        this.f52399a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f52399a.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onStart() {
        super.onStart();
        this.f52399a.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onStop() {
        this.f52399a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f52399a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> c<T> t() {
        return com.trello.rxlifecycle2.android.b.b(this.f52399a);
    }
}
