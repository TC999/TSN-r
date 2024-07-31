package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* renamed from: com.amap.api.offlineservice.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class ServiceModule {

    /* renamed from: a */
    protected OfflineMapActivity f7160a = null;

    /* renamed from: a */
    public final int m51969a(float f) {
        OfflineMapActivity offlineMapActivity = this.f7160a;
        return offlineMapActivity != null ? (int) ((f * (offlineMapActivity.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f;
    }

    /* renamed from: b */
    public final void m51968b() {
        this.f7160a.showScr();
    }

    /* renamed from: c */
    public abstract void mo51967c(View view);

    /* renamed from: d */
    public final void m51966d(OfflineMapActivity offlineMapActivity) {
        this.f7160a = offlineMapActivity;
    }

    /* renamed from: e */
    public abstract void mo51965e();

    /* renamed from: f */
    public boolean mo51964f() {
        return true;
    }

    /* renamed from: g */
    public abstract RelativeLayout mo51963g();

    /* renamed from: h */
    public abstract void mo51962h();
}
