package com.acse.ottn.util;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class Ia implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f6757a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(CoordinatorLayout coordinatorLayout) {
        this.f6757a = coordinatorLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6757a.requestLayout();
    }
}
