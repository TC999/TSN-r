package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3LocationService.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3LocationService;", "Landroidx/lifecycle/LifecycleService;", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "rootIntent", "Lkotlin/f1;", "onTaskRemoved", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3LocationObserver;", "a", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3LocationObserver;", "locationObserver", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3SilentMusicObserver;", "b", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3SilentMusicObserver;", "v3SilentMusicObserver", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationService */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3LocationService extends LifecycleService {
    @Nullable

    /* renamed from: a */
    private V3LocationObserver f20802a;
    @Nullable

    /* renamed from: b */
    private V3SilentMusicObserver f20803b;

    public V3LocationService() {
        if (this.f20802a == null) {
            V3LocationObserver v3LocationObserver = new V3LocationObserver(this);
            this.f20802a = v3LocationObserver;
            getLifecycle().addObserver(v3LocationObserver);
            V3SilentMusicObserver v3SilentMusicObserver = new V3SilentMusicObserver();
            this.f20803b = v3SilentMusicObserver;
            getLifecycle().addObserver(v3SilentMusicObserver);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        C11792j.m20469d("StepService->onTaskRemoved", new Object[0]);
        V3LocationObserver v3LocationObserver = this.f20802a;
        if (v3LocationObserver != null) {
            v3LocationObserver.onDestroy();
        }
        V3LocationObserver v3LocationObserver2 = this.f20802a;
        if (v3LocationObserver2 != null) {
            getLifecycle().removeObserver(v3LocationObserver2);
        }
        V3SilentMusicObserver v3SilentMusicObserver = this.f20803b;
        if (v3SilentMusicObserver == null) {
            return;
        }
        getLifecycle().removeObserver(v3SilentMusicObserver);
    }
}
