package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class RxActivity extends Activity implements LifecycleProvider<ActivityEvent> {

    /* renamed from: a */
    private final BehaviorSubject<ActivityEvent> f37489a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: a */
    public final <T> LifecycleTransformer<T> mo14877I(@NonNull ActivityEvent activityEvent) {
        return RxLifecycle.m14871c(this.f37489a, activityEvent);
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: n */
    public final Observable<ActivityEvent> mo14875n() {
        return this.f37489a.hide();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f37489a.onNext(ActivityEvent.CREATE);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onDestroy() {
        this.f37489a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onPause() {
        this.f37489a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onResume() {
        super.onResume();
        this.f37489a.onNext(ActivityEvent.RESUME);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onStart() {
        super.onStart();
        this.f37489a.onNext(ActivityEvent.START);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onStop() {
        this.f37489a.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: t */
    public final <T> LifecycleTransformer<T> mo14874t() {
        return RxLifecycleAndroid.m14890a(this.f37489a);
    }
}
