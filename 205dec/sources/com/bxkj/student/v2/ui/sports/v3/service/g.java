package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.amap.api.location.AMapLocationClient;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.ui.sports.v3.V3SportsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3NotificationManager.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/g;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f24275a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final int f24276b = 100;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final String f24277c = "my_channel_02";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3NotificationManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/g$a;", "", "Landroid/content/Context;", "context", "Lkotlin/f1;", "g", "b", "Landroid/app/Service;", "service", "Lcom/amap/api/location/AMapLocationClient;", "locationClient", "c", "d", "a", "", "msg", "", "isAlert", "e", "notifyChannelId", "Ljava/lang/String;", "", "notifyId", "I", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ void f(a aVar, Context context, String str, boolean z3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                z3 = false;
            }
            aVar.e(context, str, z3);
        }

        private final void g(Context context) {
            Object systemService = context.getSystemService("power");
            if (systemService != null) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn()) {
                    return;
                }
                powerManager.newWakeLock(268435462, "tsnApp:notificationLock").acquire(3000L);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }

        public final void a(@NotNull Context context) {
            f0.p(context, "context");
            g(context);
        }

        public final void b(@NotNull Context context) {
            f0.p(context, "context");
            Object systemService = context.getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                notificationManager.cancel(100);
                notificationManager.cancelAll();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }

        public final void c(@NotNull Service service, @Nullable AMapLocationClient aMapLocationClient) {
            f0.p(service, "service");
            Object systemService = service.getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                NotificationCompat.Builder ongoing = new NotificationCompat.Builder(service, "my_channel_02").setSmallIcon(2131558617).setPriority(1).setOnlyAlertOnce(true).setDefaults(64).setAutoCancel(false).setOngoing(true);
                if (Build.VERSION.SDK_INT >= 26) {
                    String string = service.getString(2131820604);
                    f0.o(string, "service.getString(R.string.app_name)");
                    NotificationChannel notificationChannel = new NotificationChannel("my_channel_02", string, 4);
                    notificationChannel.setDescription("\u6b63\u5728\u8bb0\u5f55\u672c\u6b21\u8dd1\u6b65");
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-65536);
                    notificationChannel.setLockscreenVisibility(1);
                    notificationChannel.setSound(null, null);
                    notificationManager.createNotificationChannel(notificationChannel);
                    ongoing.setChannelId("my_channel_02");
                }
                RemoteViews remoteViews = new RemoteViews(service.getPackageName(), 2131428113);
                b.g gVar = com.bxkj.student.v2.common.data.b.a;
                remoteViews.setTextViewText(2131232941, i.c(gVar.f()));
                int i4 = l.f18624a.k(gVar.v(), "runType") == 5 ? 8 : 0;
                remoteViews.setViewVisibility(2131232183, i4);
                remoteViews.setViewVisibility(2131233213, i4);
                remoteViews.setViewVisibility(2131233170, i4);
                remoteViews.setTextViewText(2131233198, i.g(gVar.d()));
                remoteViews.setTextViewText(2131233170, String.valueOf(gVar.y()));
                ongoing.setCustomBigContentView(remoteViews);
                ongoing.setVisibility(1);
                ongoing.setContentIntent(PendingIntent.getActivity(service, 1, new Intent(service, V3SportsActivity.class), 134217728));
                Notification build = ongoing.build();
                f0.o(build, "notificationBuild.build()");
                service.startForeground(100, build);
                if (aMapLocationClient == null) {
                    return;
                }
                aMapLocationClient.enableBackgroundLocation(100, build);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }

        public final void d(@NotNull Context context) {
            f0.p(context, "context");
            f(this, context, "", false, 4, null);
        }

        public final void e(@NotNull Context context, @NotNull String msg, boolean z3) {
            f0.p(context, "context");
            f0.p(msg, "msg");
            NotificationCompat.Builder ongoing = new NotificationCompat.Builder(context, "my_channel_02").setSmallIcon(2131558617).setWhen(System.currentTimeMillis()).setPriority(1).setOnlyAlertOnce(!z3).setDefaults(64).setAutoCancel(false).setOngoing(true);
            Object systemService = context.getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (Build.VERSION.SDK_INT >= 26) {
                    ongoing.setChannelId("my_channel_02");
                }
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2131428113);
                b.g gVar = com.bxkj.student.v2.common.data.b.a;
                remoteViews.setTextViewText(2131232941, i.c(gVar.f()));
                remoteViews.setTextViewText(2131233198, i.g(gVar.d()));
                remoteViews.setTextViewText(2131233170, String.valueOf(gVar.y()));
                remoteViews.setTextViewText(2131233036, msg);
                remoteViews.setViewVisibility(2131233036, msg.length() == 0 ? 8 : 0);
                int i4 = l.f18624a.k(gVar.v(), "runType") == 5 ? 8 : 0;
                remoteViews.setViewVisibility(2131232183, i4);
                remoteViews.setViewVisibility(2131233213, i4);
                remoteViews.setViewVisibility(2131233170, i4);
                ongoing.setCustomBigContentView(remoteViews);
                ongoing.setVisibility(1);
                ongoing.setContentIntent(PendingIntent.getActivity(context, 1, new Intent(context, V3SportsActivity.class), 134217728));
                notificationManager.notify(100, ongoing.build());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
    }
}
