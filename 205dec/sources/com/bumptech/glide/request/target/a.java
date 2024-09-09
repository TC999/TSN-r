package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AppWidgetTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a extends n<Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private final int[] f17958d;

    /* renamed from: e  reason: collision with root package name */
    private final ComponentName f17959e;

    /* renamed from: f  reason: collision with root package name */
    private final RemoteViews f17960f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f17961g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17962h;

    public a(Context context, int i4, int i5, int i6, RemoteViews remoteViews, int... iArr) {
        super(i4, i5);
        if (iArr.length != 0) {
            this.f17961g = (Context) com.bumptech.glide.util.j.e(context, "Context can not be null!");
            this.f17960f = (RemoteViews) com.bumptech.glide.util.j.e(remoteViews, "RemoteViews object can not be null!");
            this.f17958d = (int[]) com.bumptech.glide.util.j.e(iArr, "WidgetIds can not be null!");
            this.f17962h = i6;
            this.f17959e = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f17961g);
        ComponentName componentName = this.f17959e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f17960f);
        } else {
            appWidgetManager.updateAppWidget(this.f17958d, this.f17960f);
        }
    }

    @Override // com.bumptech.glide.request.target.p
    /* renamed from: d */
    public void k(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.transition.f<? super Bitmap> fVar) {
        this.f17960f.setImageViewBitmap(this.f17962h, bitmap);
        update();
    }

    public a(Context context, int i4, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i4, remoteViews, iArr);
    }

    public a(Context context, int i4, int i5, int i6, RemoteViews remoteViews, ComponentName componentName) {
        super(i4, i5);
        this.f17961g = (Context) com.bumptech.glide.util.j.e(context, "Context can not be null!");
        this.f17960f = (RemoteViews) com.bumptech.glide.util.j.e(remoteViews, "RemoteViews object can not be null!");
        this.f17959e = (ComponentName) com.bumptech.glide.util.j.e(componentName, "ComponentName can not be null!");
        this.f17962h = i6;
        this.f17958d = null;
    }

    public a(Context context, int i4, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i4, remoteViews, componentName);
    }
}
