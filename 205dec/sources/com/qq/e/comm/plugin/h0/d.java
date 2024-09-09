package com.qq.e.comm.plugin.h0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.FrameMetrics;
import android.view.Window;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends a implements Window.OnFrameMetricsAvailableListener {

    /* renamed from: j  reason: collision with root package name */
    private static final String f44019j = d.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private final Handler f44020i;

    public d(Activity activity, long j4) {
        super(activity, j4);
        this.f44020i = new Handler(Looper.getMainLooper());
    }

    @Override // com.qq.e.comm.plugin.h0.a
    String b() {
        return f44019j;
    }

    @Override // com.qq.e.comm.plugin.h0.a
    protected void c() {
        try {
            this.f43998a.getWindow().removeOnFrameMetricsAvailableListener(this);
        } catch (IllegalArgumentException unused) {
            d1.b(b(), "removeOnFrameMetricsAvailableListener fail");
        }
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i4) {
        FrameMetrics frameMetrics2 = new FrameMetrics(frameMetrics);
        if (frameMetrics2.getMetric(9) == 1) {
            d1.a(f44019j, "onFrameMetricsAvailable, ignore firstFrame");
        } else {
            a((int) (((float) frameMetrics2.getMetric(8)) / ((float) this.f43999b)));
        }
    }

    @Override // com.qq.e.comm.plugin.h0.a, com.qq.e.comm.plugin.h0.f
    public void start() {
        super.start();
        this.f43998a.getWindow().addOnFrameMetricsAvailableListener(this, this.f44020i);
    }
}
