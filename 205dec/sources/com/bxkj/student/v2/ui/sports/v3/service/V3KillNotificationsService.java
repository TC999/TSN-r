package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.orhanobut.logger.j;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3KillNotificationsService.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3KillNotificationsService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "", "flags", "startId", "onStartCommand", "Lkotlin/f1;", "onCreate", "rootIntent", "onTaskRemoved", "a", "Landroid/os/IBinder;", "mBinder", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3KillNotificationsService extends Service {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f24191a = new a(this, this);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3KillNotificationsService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3KillNotificationsService$a;", "Landroid/os/Binder;", "Landroid/app/Service;", "a", "Landroid/app/Service;", "()Landroid/app/Service;", "service", "<init>", "(Lcom/bxkj/student/v2/ui/sports/v3/service/V3KillNotificationsService;Landroid/app/Service;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public final class a extends Binder {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Service f24192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V3KillNotificationsService f24193b;

        public a(@NotNull V3KillNotificationsService this$0, Service service) {
            f0.p(this$0, "this$0");
            f0.p(service, "service");
            this.f24193b = this$0;
            this.f24192a = service;
        }

        @NotNull
        public final Service a() {
            return this.f24192a;
        }
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@NotNull Intent intent) {
        f0.p(intent, "intent");
        return this.f24191a;
    }

    @Override // android.app.Service
    public void onCreate() {
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        j.d("KillNotificationsService->onTaskRemoved", new Object[0]);
        g.f24275a.b(this);
    }
}
