package com.trello.rxlifecycle2.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
public abstract class RxFragment extends Fragment implements b<FragmentEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<FragmentEvent> f52400a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: b */
    public final <T> c<T> I(@NonNull FragmentEvent fragmentEvent) {
        return d.c(this.f52400a, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> n() {
        return this.f52400a.hide();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f52400a.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f52400a.onNext(FragmentEvent.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f52400a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f52400a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.f52400a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f52400a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f52400a.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f52400a.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f52400a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f52400a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> c<T> t() {
        return com.trello.rxlifecycle2.android.b.b(this.f52400a);
    }
}
