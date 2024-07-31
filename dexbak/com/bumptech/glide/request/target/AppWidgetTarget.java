package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.request.target.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {

    /* renamed from: d */
    private final int[] f14440d;

    /* renamed from: e */
    private final ComponentName f14441e;

    /* renamed from: f */
    private final RemoteViews f14442f;

    /* renamed from: g */
    private final Context f14443g;

    /* renamed from: h */
    private final int f14444h;

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length != 0) {
            this.f14443g = (Context) C3770j.m44391e(context, "Context can not be null!");
            this.f14442f = (RemoteViews) C3770j.m44391e(remoteViews, "RemoteViews object can not be null!");
            this.f14440d = (int[]) C3770j.m44391e(iArr, "WidgetIds can not be null!");
            this.f14444h = i3;
            this.f14441e = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f14443g);
        ComponentName componentName = this.f14441e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f14442f);
        } else {
            appWidgetManager.updateAppWidget(this.f14440d, this.f14442f);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: d */
    public void mo44364k(@NonNull Bitmap bitmap, @Nullable InterfaceC3759f<? super Bitmap> interfaceC3759f) {
        this.f14442f.setImageViewBitmap(this.f14444h, bitmap);
        update();
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, ComponentName componentName) {
        super(i, i2);
        this.f14443g = (Context) C3770j.m44391e(context, "Context can not be null!");
        this.f14442f = (RemoteViews) C3770j.m44391e(remoteViews, "RemoteViews object can not be null!");
        this.f14441e = (ComponentName) C3770j.m44391e(componentName, "ComponentName can not be null!");
        this.f14444h = i3;
        this.f14440d = null;
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }
}
