package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

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
import androidx.core.internal.view.SupportMenu;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsActivity;
import com.bxkj.student.run.app.utils.FormatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/g;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3NotificationManager {
    @NotNull

    /* renamed from: a */
    public static final C5826a f20856a = new C5826a(null);

    /* renamed from: b */
    private static final int f20857b = 100;
    @NotNull

    /* renamed from: c */
    private static final String f20858c = "my_channel_02";

    /* compiled from: V3NotificationManager.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/g$a;", "", "Landroid/content/Context;", "context", "Lkotlin/f1;", "g", "b", "Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "Lcom/amap/api/location/AMapLocationClient;", "locationClient", "c", "d", "a", "", "msg", "", "isAlert", "e", "notifyChannelId", "Ljava/lang/String;", "", "notifyId", "I", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5826a {
        private C5826a() {
        }

        public /* synthetic */ C5826a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: f */
        public static /* synthetic */ void m38267f(C5826a c5826a, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            c5826a.m38268e(context, str, z);
        }

        /* renamed from: g */
        private final void m38266g(Context context) {
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

        /* renamed from: a */
        public final void m38272a(@NotNull Context context) {
            C14342f0.m8184p(context, "context");
            m38266g(context);
        }

        /* renamed from: b */
        public final void m38271b(@NotNull Context context) {
            C14342f0.m8184p(context, "context");
            Object systemService = context.getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                notificationManager.cancel(100);
                notificationManager.cancelAll();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }

        /* renamed from: c */
        public final void m38270c(@NotNull Service service, @Nullable AMapLocationClient aMapLocationClient) {
            C14342f0.m8184p(service, "service");
            Object systemService = service.getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                NotificationCompat.Builder ongoing = new NotificationCompat.Builder(service, V3NotificationManager.f20858c).setSmallIcon(2131558617).setPriority(1).setOnlyAlertOnce(true).setDefaults(64).setAutoCancel(false).setOngoing(true);
                if (Build.VERSION.SDK_INT >= 26) {
                    String string = service.getString(2131820604);
                    C14342f0.m8185o(string, "service.getString(R.string.app_name)");
                    NotificationChannel notificationChannel = new NotificationChannel(V3NotificationManager.f20858c, string, 4);
                    notificationChannel.setDescription("正在记录本次跑步");
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
                    notificationChannel.setLockscreenVisibility(1);
                    notificationChannel.setSound(null, null);
                    notificationManager.createNotificationChannel(notificationChannel);
                    ongoing.setChannelId(V3NotificationManager.f20858c);
                }
                RemoteViews remoteViews = new RemoteViews(service.getPackageName(), (int) C4215R.C4221layout.v3_notification_app_sports);
                SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                remoteViews.setTextViewText(2131232941, FormatUtils.m39634c(c5481g.m39270f()));
                int i = JsonGet.f15134a.m43769k(c5481g.m39250v(), "runType") == 5 ? 8 : 0;
                remoteViews.setViewVisibility(C4215R.C4219id.ll_distance, i);
                remoteViews.setViewVisibility(C4215R.C4219id.tv_unit, i);
                remoteViews.setViewVisibility(2131233170, i);
                remoteViews.setTextViewText(2131233198, FormatUtils.m39630g(c5481g.m39274d()));
                remoteViews.setTextViewText(2131233170, String.valueOf(c5481g.m39247y()));
                ongoing.setCustomBigContentView(remoteViews);
                ongoing.setVisibility(1);
                ongoing.setContentIntent(PendingIntent.getActivity(service, 1, new Intent(service, V3SportsActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH));
                Notification build = ongoing.build();
                C14342f0.m8185o(build, "notificationBuild.build()");
                service.startForeground(100, build);
                if (aMapLocationClient == null) {
                    return;
                }
                aMapLocationClient.enableBackgroundLocation(100, build);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }

        /* renamed from: d */
        public final void m38269d(@NotNull Context context) {
            C14342f0.m8184p(context, "context");
            m38267f(this, context, "", false, 4, null);
        }

        /* renamed from: e */
        public final void m38268e(@NotNull Context context, @NotNull String msg, boolean z) {
            C14342f0.m8184p(context, "context");
            C14342f0.m8184p(msg, "msg");
            NotificationCompat.Builder ongoing = new NotificationCompat.Builder(context, V3NotificationManager.f20858c).setSmallIcon(2131558617).setWhen(System.currentTimeMillis()).setPriority(1).setOnlyAlertOnce(!z).setDefaults(64).setAutoCancel(false).setOngoing(true);
            Object systemService = context.getSystemService("notification");
            if (systemService != null) {
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (Build.VERSION.SDK_INT >= 26) {
                    ongoing.setChannelId(V3NotificationManager.f20858c);
                }
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) C4215R.C4221layout.v3_notification_app_sports);
                SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                remoteViews.setTextViewText(2131232941, FormatUtils.m39634c(c5481g.m39270f()));
                remoteViews.setTextViewText(2131233198, FormatUtils.m39630g(c5481g.m39274d()));
                remoteViews.setTextViewText(2131233170, String.valueOf(c5481g.m39247y()));
                remoteViews.setTextViewText(2131233036, msg);
                remoteViews.setViewVisibility(2131233036, msg.length() == 0 ? 8 : 0);
                int i = JsonGet.f15134a.m43769k(c5481g.m39250v(), "runType") == 5 ? 8 : 0;
                remoteViews.setViewVisibility(C4215R.C4219id.ll_distance, i);
                remoteViews.setViewVisibility(C4215R.C4219id.tv_unit, i);
                remoteViews.setViewVisibility(2131233170, i);
                ongoing.setCustomBigContentView(remoteViews);
                ongoing.setVisibility(1);
                ongoing.setContentIntent(PendingIntent.getActivity(context, 1, new Intent(context, V3SportsActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH));
                notificationManager.notify(100, ongoing.build());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
    }
}
