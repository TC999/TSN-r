package com.acse.ottn.util;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: com.acse.ottn.util.Ia */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1634Ia implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CoordinatorLayout f3247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1634Ia(CoordinatorLayout coordinatorLayout) {
        this.f3247a = coordinatorLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3247a.requestLayout();
    }
}
