package com.trello.rxlifecycle2.components.support;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.b;
import com.trello.rxlifecycle2.c;
import com.trello.rxlifecycle2.d;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class RxFragmentActivity extends FragmentActivity implements b<ActivityEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f52401a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: c */
    public final <T> c<T> I(@NonNull ActivityEvent activityEvent) {
        return d.c(this.f52401a, activityEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> n() {
        return this.f52401a.hide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f52401a.onNext(ActivityEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onDestroy() {
        this.f52401a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onPause() {
        this.f52401a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f52401a.onNext(ActivityEvent.RESUME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onStart() {
        super.onStart();
        this.f52401a.onNext(ActivityEvent.START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onStop() {
        this.f52401a.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> c<T> t() {
        return com.trello.rxlifecycle2.android.b.a(this.f52401a);
    }
}
