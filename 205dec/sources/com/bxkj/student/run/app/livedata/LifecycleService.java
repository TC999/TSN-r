package com.bxkj.student.run.app.livedata;

import android.app.Service;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LifecycleService.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/bxkj/student/run/app/livedata/LifecycleService;", "Landroid/app/Service;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lkotlin/f1;", "onCreate", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "onDestroy", "Landroidx/lifecycle/LifecycleRegistry;", "a", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class LifecycleService extends Service implements LifecycleOwner {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private LifecycleRegistry f22406a = new LifecycleRegistry(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.f22406a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f22406a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f22406a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        this.f22406a.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return super.onStartCommand(intent, i4, i5);
    }
}
