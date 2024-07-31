package com.beizi.p051ad.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.beizi.ad.internal.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VisibilityDetector {

    /* renamed from: a */
    private View f10409a;

    /* renamed from: b */
    private ArrayList<Object> f10410b;

    /* renamed from: c */
    private Runnable f10411c;

    /* renamed from: d */
    private ScheduledExecutorService f10412d;

    /* renamed from: a */
    public void m49293a() {
        ScheduledExecutorService scheduledExecutorService = this.f10412d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        View view = this.f10409a;
        if (view != null) {
            view.removeCallbacks(this.f10411c);
            this.f10409a = null;
        }
        this.f10410b = null;
    }
}
