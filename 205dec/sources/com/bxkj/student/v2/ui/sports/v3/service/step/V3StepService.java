package com.bxkj.student.v2.ui.sports.v3.service.step;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import com.orhanobut.logger.j;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3StepService.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "Landroidx/lifecycle/LifecycleService;", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "rootIntent", "Lkotlin/f1;", "onTaskRemoved", "Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver;", "a", "Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver;", "v3StepObserver", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3StepService extends LifecycleService {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private V3StepObserver f24300a;

    public V3StepService() {
        if (this.f24300a == null) {
            V3StepObserver v3StepObserver = new V3StepObserver(this);
            this.f24300a = v3StepObserver;
            getLifecycle().addObserver(v3StepObserver);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        j.d("StepService->onTaskRemoved", new Object[0]);
        V3StepObserver v3StepObserver = this.f24300a;
        if (v3StepObserver != null) {
            v3StepObserver.onDestroy();
        }
        V3StepObserver v3StepObserver2 = this.f24300a;
        if (v3StepObserver2 == null) {
            return;
        }
        getLifecycle().removeObserver(v3StepObserver2);
    }
}
