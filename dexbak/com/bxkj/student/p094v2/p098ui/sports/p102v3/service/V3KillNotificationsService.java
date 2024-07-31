package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3KillNotificationsService.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3KillNotificationsService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "", "flags", "startId", "onStartCommand", "Lkotlin/f1;", "onCreate", "rootIntent", "onTaskRemoved", "a", "Landroid/os/IBinder;", "mBinder", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3KillNotificationsService */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3KillNotificationsService extends Service {
    @NotNull

    /* renamed from: a */
    private final IBinder f20772a = new BinderC5803a(this, this);

    /* compiled from: V3KillNotificationsService.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3KillNotificationsService$a;", "Landroid/os/Binder;", "Landroid/app/Service;", "a", "Landroid/app/Service;", "()Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(Lcom/bxkj/student/v2/ui/sports/v3/service/V3KillNotificationsService;Landroid/app/Service;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3KillNotificationsService$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public final class BinderC5803a extends Binder {
        @NotNull

        /* renamed from: a */
        private final Service f20773a;

        /* renamed from: b */
        final /* synthetic */ V3KillNotificationsService f20774b;

        public BinderC5803a(@NotNull V3KillNotificationsService this$0, Service service) {
            C14342f0.m8184p(this$0, "this$0");
            C14342f0.m8184p(service, "service");
            this.f20774b = this$0;
            this.f20773a = service;
        }

        @NotNull
        /* renamed from: a */
        public final Service m38330a() {
            return this.f20773a;
        }
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@NotNull Intent intent) {
        C14342f0.m8184p(intent, "intent");
        return this.f20772a;
    }

    @Override // android.app.Service
    public void onCreate() {
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        C11792j.m20469d("KillNotificationsService->onTaskRemoved", new Object[0]);
        V3NotificationManager.f20856a.m38271b(this);
    }
}
