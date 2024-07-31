package com.acse.ottn.activity;

import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.util.C1694ra;

/* renamed from: com.acse.ottn.activity.O */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1277O implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TransparentGreenActivity f2121a;

    RunnableC1277O(TransparentGreenActivity transparentGreenActivity) {
        this.f2121a = transparentGreenActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SwitchOnAnimView switchOnAnimView;
        SwitchOnAnimView switchOnAnimView2;
        try {
            switchOnAnimView = this.f2121a.f2173g;
            switchOnAnimView.m57204a();
            switchOnAnimView2 = this.f2121a.f2174h;
            switchOnAnimView2.m57204a();
        } catch (Exception e) {
            C1694ra.m55915b("TransparentActivity", e.getMessage());
        }
    }
}
