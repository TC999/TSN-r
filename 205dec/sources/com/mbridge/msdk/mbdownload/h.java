package com.mbridge.msdk.mbdownload;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.tools.r;
import com.stub.StubApp;
import java.lang.reflect.Field;

/* compiled from: NotificationBuilder.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {

    /* renamed from: e  reason: collision with root package name */
    protected Context f40128e;

    /* renamed from: f  reason: collision with root package name */
    protected Notification f40129f;

    /* renamed from: g  reason: collision with root package name */
    protected Notification.Builder f40130g;

    /* renamed from: h  reason: collision with root package name */
    protected NotificationCompat.Builder f40131h;

    /* renamed from: i  reason: collision with root package name */
    protected PendingIntent f40132i;

    /* renamed from: j  reason: collision with root package name */
    protected RemoteViews f40133j;

    public h(Context context) {
        this.f40128e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f40133j = new RemoteViews(this.f40128e.getPackageName(), r.a(this.f40128e, "mbridge_download_notify_layout", "layout"));
        if (this.f40128e.getApplicationInfo().targetSdkVersion >= 26 && Build.VERSION.SDK_INT >= 26) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f40128e, "download");
            this.f40131h = builder;
            builder.setCustomContentView(this.f40133j);
            return;
        }
        Notification.Builder builder2 = new Notification.Builder(context);
        this.f40130g = builder2;
        builder2.setContent(this.f40133j);
    }

    public final h a(boolean z3) {
        Context context = this.f40128e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f40131h.setOngoing(z3);
        } else {
            this.f40130g.setOngoing(z3);
        }
        return this;
    }

    public final h b(boolean z3) {
        Context context = this.f40128e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f40131h.setAutoCancel(z3);
        } else {
            this.f40130g.setAutoCancel(z3);
        }
        return this;
    }

    public final void e() {
        Context context = this.f40128e;
        try {
            if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
                Field declaredField = NotificationCompat.Builder.class.getDeclaredField("mActions");
                declaredField.setAccessible(true);
                NotificationCompat.Builder builder = this.f40131h;
                declaredField.set(builder, declaredField.get(builder).getClass().newInstance());
            } else {
                Field declaredField2 = Notification.Builder.class.getDeclaredField("mActions");
                declaredField2.setAccessible(true);
                Notification.Builder builder2 = this.f40130g;
                declaredField2.set(builder2, declaredField2.get(builder2).getClass().newInstance());
            }
        } catch (Exception unused) {
        }
    }

    public final h a(int i4) {
        Context context = this.f40128e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f40131h.setSmallIcon(i4);
        } else {
            this.f40130g.setSmallIcon(i4);
        }
        return this;
    }

    public final h a(long j4) {
        Context context = this.f40128e;
        if ((context != null ? context.getApplicationInfo().targetSdkVersion : 0) >= 26 && Build.VERSION.SDK_INT >= 26) {
            this.f40131h.setWhen(j4);
        } else {
            this.f40130g.setWhen(j4);
        }
        return this;
    }
}
