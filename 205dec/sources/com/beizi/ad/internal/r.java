package com.beizi.ad.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: VisibilityDetector.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private View f14018a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Object> f14019b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f14020c;

    /* renamed from: d  reason: collision with root package name */
    private ScheduledExecutorService f14021d;

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.f14021d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        View view = this.f14018a;
        if (view != null) {
            view.removeCallbacks(this.f14020c);
            this.f14018a = null;
        }
        this.f14019b = null;
    }
}
