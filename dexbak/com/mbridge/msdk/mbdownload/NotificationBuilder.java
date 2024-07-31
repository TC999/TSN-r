package com.mbridge.msdk.mbdownload;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.stub.StubApp;
import java.lang.reflect.Field;

/* renamed from: com.mbridge.msdk.mbdownload.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NotificationBuilder {

    /* renamed from: e */
    protected Context f31356e;

    /* renamed from: f */
    protected Notification f31357f;

    /* renamed from: g */
    protected Notification.Builder f31358g;

    /* renamed from: h */
    protected NotificationCompat.Builder f31359h;

    /* renamed from: i */
    protected PendingIntent f31360i;

    /* renamed from: j */
    protected RemoteViews f31361j;

    public NotificationBuilder(Context context) {
        this.f31356e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f31361j = new RemoteViews(this.f31356e.getPackageName(), ResourceUtil.m21814a(this.f31356e, "mbridge_download_notify_layout", "layout"));
        if (this.f31356e.getApplicationInfo().targetSdkVersion >= 26 && Build.VERSION.SDK_INT >= 26) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f31356e, "download");
            this.f31359h = builder;
            builder.setCustomContentView(this.f31361j);
            return;
        }
        Notification.Builder builder2 = new Notification.Builder(context);
        this.f31358g = builder2;
        builder2.setContent(this.f31361j);
    }

    /* renamed from: a */
    public final NotificationBuilder m21597a(boolean z) {
        Context context = this.f31356e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f31359h.setOngoing(z);
        } else {
            this.f31358g.setOngoing(z);
        }
        return this;
    }

    /* renamed from: b */
    public final NotificationBuilder m21596b(boolean z) {
        Context context = this.f31356e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f31359h.setAutoCancel(z);
        } else {
            this.f31358g.setAutoCancel(z);
        }
        return this;
    }

    /* renamed from: e */
    public final void m21595e() {
        Context context = this.f31356e;
        try {
            if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
                Field declaredField = NotificationCompat.Builder.class.getDeclaredField("mActions");
                declaredField.setAccessible(true);
                NotificationCompat.Builder builder = this.f31359h;
                declaredField.set(builder, declaredField.get(builder).getClass().newInstance());
            } else {
                Field declaredField2 = Notification.Builder.class.getDeclaredField("mActions");
                declaredField2.setAccessible(true);
                Notification.Builder builder2 = this.f31358g;
                declaredField2.set(builder2, declaredField2.get(builder2).getClass().newInstance());
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public final NotificationBuilder m21599a(int i) {
        Context context = this.f31356e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f31359h.setSmallIcon(i);
        } else {
            this.f31358g.setSmallIcon(i);
        }
        return this;
    }

    /* renamed from: a */
    public final NotificationBuilder m21598a(long j) {
        Context context = this.f31356e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f31359h.setWhen(j);
        } else {
            this.f31358g.setWhen(j);
        }
        return this;
    }
}
