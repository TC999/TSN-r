package com.acse.ottn.activity;

import com.acse.ottn.animator.SwitchOnAnimSmallView;
import com.acse.ottn.util.C1694ra;

/* renamed from: com.acse.ottn.activity.K */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1273K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TransparentActivity f2117a;

    RunnableC1273K(TransparentActivity transparentActivity) {
        this.f2117a = transparentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SwitchOnAnimSmallView switchOnAnimSmallView;
        try {
            switchOnAnimSmallView = this.f2117a.f2167l;
            switchOnAnimSmallView.m57216a();
        } catch (Exception e) {
            C1694ra.m55915b("TransparentActivity", e.getMessage());
        }
    }
}
