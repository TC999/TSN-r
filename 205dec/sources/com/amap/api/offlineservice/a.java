package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ServiceModule.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected OfflineMapActivity f10858a = null;

    public final int a(float f4) {
        OfflineMapActivity offlineMapActivity = this.f10858a;
        return offlineMapActivity != null ? (int) ((f4 * (offlineMapActivity.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f4;
    }

    public final void b() {
        this.f10858a.showScr();
    }

    public abstract void c(View view);

    public final void d(OfflineMapActivity offlineMapActivity) {
        this.f10858a = offlineMapActivity;
    }

    public abstract void e();

    public boolean f() {
        return true;
    }

    public abstract RelativeLayout g();

    public abstract void h();
}
