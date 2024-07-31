package com.trello.rxlifecycle2.components.support;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class RxAppCompatActivity extends AppCompatActivity implements LifecycleProvider<ActivityEvent> {

    /* renamed from: a */
    private final BehaviorSubject<ActivityEvent> f37499a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: c */
    public final <T> LifecycleTransformer<T> mo14877I(@NonNull ActivityEvent activityEvent) {
        return RxLifecycle.m14871c(this.f37499a, activityEvent);
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: n */
    public final Observable<ActivityEvent> mo14875n() {
        return this.f37499a.hide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f37499a.onNext(ActivityEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onDestroy() {
        this.f37499a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onPause() {
        this.f37499a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f37499a.onNext(ActivityEvent.RESUME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onStart() {
        super.onStart();
        this.f37499a.onNext(ActivityEvent.START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onStop() {
        this.f37499a.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // com.trello.rxlifecycle2.LifecycleProvider
    @NonNull
    @CheckResult
    /* renamed from: t */
    public final <T> LifecycleTransformer<T> mo14874t() {
        return RxLifecycleAndroid.m14890a(this.f37499a);
    }
}
