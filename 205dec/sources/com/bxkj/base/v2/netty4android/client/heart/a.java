package com.bxkj.base.v2.netty4android.client.heart;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlarmNettyTimer.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/heart/a;", "", "Lkotlin/f1;", "b", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "J", "TIME_INTERVAL", "Landroid/app/AlarmManager;", "c", "Landroid/app/AlarmManager;", "am", "Landroid/app/PendingIntent;", "d", "Landroid/app/PendingIntent;", "pendingIntent", "<init>", "(Landroid/content/Context;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f18781a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18782b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final AlarmManager f18783c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f18784d;

    public a(@NotNull Context context) {
        f0.p(context, "context");
        this.f18781a = context;
        this.f18782b = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        Object systemService = context.getSystemService("alarm");
        if (systemService != null) {
            this.f18783c = (AlarmManager) systemService;
            this.f18784d = PendingIntent.getService(context, 0, new Intent(context, AlarmNettyService.class), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.AlarmManager");
    }

    public final void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f18783c;
        if (alarmManager == null || (pendingIntent = this.f18784d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public final void b() {
        a();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            AlarmManager alarmManager = this.f18783c;
            f0.m(alarmManager);
            alarmManager.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + this.f18782b, this.f18784d);
        } else if (i4 >= 19) {
            AlarmManager alarmManager2 = this.f18783c;
            f0.m(alarmManager2);
            alarmManager2.setExact(0, System.currentTimeMillis() + this.f18782b, this.f18784d);
        } else {
            AlarmManager alarmManager3 = this.f18783c;
            f0.m(alarmManager3);
            alarmManager3.set(0, System.currentTimeMillis() + this.f18782b, this.f18784d);
        }
    }
}
