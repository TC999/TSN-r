package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NotificationTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class l extends n<Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private final RemoteViews f17993d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f17994e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17995f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17996g;

    /* renamed from: h  reason: collision with root package name */
    private final Notification f17997h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17998i;

    public l(Context context, int i4, RemoteViews remoteViews, Notification notification, int i5) {
        this(context, i4, remoteViews, notification, i5, null);
    }

    private void update() {
        ((NotificationManager) com.bumptech.glide.util.j.d((NotificationManager) this.f17994e.getSystemService("notification"))).notify(this.f17996g, this.f17995f, this.f17997h);
    }

    @Override // com.bumptech.glide.request.target.p
    /* renamed from: d */
    public void k(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.transition.f<? super Bitmap> fVar) {
        this.f17993d.setImageViewBitmap(this.f17998i, bitmap);
        update();
    }

    public l(Context context, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i4, remoteViews, notification, i5, str);
    }

    public l(Context context, int i4, int i5, int i6, RemoteViews remoteViews, Notification notification, int i7, String str) {
        super(i4, i5);
        this.f17994e = (Context) com.bumptech.glide.util.j.e(context, "Context must not be null!");
        this.f17997h = (Notification) com.bumptech.glide.util.j.e(notification, "Notification object can not be null!");
        this.f17993d = (RemoteViews) com.bumptech.glide.util.j.e(remoteViews, "RemoteViews object can not be null!");
        this.f17998i = i6;
        this.f17995f = i7;
        this.f17996g = str;
    }
}
