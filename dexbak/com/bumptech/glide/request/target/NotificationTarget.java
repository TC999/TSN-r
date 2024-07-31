package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.request.target.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NotificationTarget extends SimpleTarget<Bitmap> {

    /* renamed from: d */
    private final RemoteViews f14475d;

    /* renamed from: e */
    private final Context f14476e;

    /* renamed from: f */
    private final int f14477f;

    /* renamed from: g */
    private final String f14478g;

    /* renamed from: h */
    private final Notification f14479h;

    /* renamed from: i */
    private final int f14480i;

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2) {
        this(context, i, remoteViews, notification, i2, null);
    }

    private void update() {
        ((NotificationManager) C3770j.m44392d((NotificationManager) this.f14476e.getSystemService("notification"))).notify(this.f14478g, this.f14477f, this.f14479h);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: d */
    public void mo44364k(@NonNull Bitmap bitmap, @Nullable InterfaceC3759f<? super Bitmap> interfaceC3759f) {
        this.f14475d.setImageViewBitmap(this.f14480i, bitmap);
        update();
    }

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, notification, i2, str);
    }

    public NotificationTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, Notification notification, int i4, String str) {
        super(i, i2);
        this.f14476e = (Context) C3770j.m44391e(context, "Context must not be null!");
        this.f14479h = (Notification) C3770j.m44391e(notification, "Notification object can not be null!");
        this.f14475d = (RemoteViews) C3770j.m44391e(remoteViews, "RemoteViews object can not be null!");
        this.f14480i = i3;
        this.f14477f = i4;
        this.f14478g = str;
    }
}
