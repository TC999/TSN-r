package com.acse.ottn.widget;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityIndicatorView f6964a;

    a(ActivityIndicatorView activityIndicatorView) {
        this.f6964a = activityIndicatorView;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityIndicatorView.a(this.f6964a, 30);
        this.f6964a.invalidate();
        this.f6964a.f6947j.postDelayed(this.f6964a.f6948k, 100L);
    }
}
