package com.acse.ottn.activity;

import com.acse.ottn.animator.SwitchOnAnimSmallView;
import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.util.C1694ra;

/* renamed from: com.acse.ottn.activity.A */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1254A implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PicToPicActivity f2044a;

    RunnableC1254A(PicToPicActivity picToPicActivity) {
        this.f2044a = picToPicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SwitchOnAnimSmallView switchOnAnimSmallView;
        SwitchOnAnimView switchOnAnimView;
        try {
            switchOnAnimSmallView = this.f2044a.f2136q;
            switchOnAnimSmallView.m57216a();
            switchOnAnimView = this.f2044a.f2135p;
            switchOnAnimView.m57204a();
        } catch (Exception e) {
            C1694ra.m55915b("TransparentActivity", e.getMessage());
        }
    }
}
