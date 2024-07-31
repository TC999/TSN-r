package com.acse.ottn.widget;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.widget.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RunnableC1715a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ActivityIndicatorView f3417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1715a(ActivityIndicatorView activityIndicatorView) {
        this.f3417a = activityIndicatorView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        ActivityIndicatorView.m55864a(this.f3417a, 30);
        this.f3417a.invalidate();
        handler = this.f3417a.f3403j;
        runnable = this.f3417a.f3404k;
        handler.postDelayed(runnable, 100L);
    }
}
