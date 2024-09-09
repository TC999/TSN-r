package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.android.ActivityEvent;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class RxActivity extends Activity implements com.trello.rxlifecycle2.b<ActivityEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f52387a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: a */
    public final <T> com.trello.rxlifecycle2.c<T> I(@NonNull ActivityEvent activityEvent) {
        return com.trello.rxlifecycle2.d.c(this.f52387a, activityEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> n() {
        return this.f52387a.hide();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f52387a.onNext(ActivityEvent.CREATE);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onDestroy() {
        this.f52387a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onPause() {
        this.f52387a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onResume() {
        super.onResume();
        this.f52387a.onNext(ActivityEvent.RESUME);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onStart() {
        super.onStart();
        this.f52387a.onNext(ActivityEvent.START);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onStop() {
        this.f52387a.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> com.trello.rxlifecycle2.c<T> t() {
        return com.trello.rxlifecycle2.android.b.a(this.f52387a);
    }
}
