package com.acse.ottn.animator;

import android.os.Handler;
import com.acse.ottn.animator.p031a.AbstractC1334a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1394f extends C1316a {

    /* renamed from: a */
    final /* synthetic */ SwitchOnAnimSmallView f2504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1394f(SwitchOnAnimSmallView switchOnAnimSmallView) {
        this.f2504a = switchOnAnimSmallView;
    }

    @Override // com.acse.ottn.animator.C1316a, com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
    /* renamed from: a */
    public void mo56852a(AbstractC1334a abstractC1334a) {
        Handler handler;
        handler = this.f2504a.f2242c;
        handler.postDelayed(new RunnableC1393e(this), 1000L);
    }
}
