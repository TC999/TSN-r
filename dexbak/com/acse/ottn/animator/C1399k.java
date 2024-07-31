package com.acse.ottn.animator;

import android.os.Handler;
import com.acse.ottn.animator.p031a.AbstractC1334a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1399k extends C1316a {

    /* renamed from: a */
    final /* synthetic */ SwitchOnAnimView f2509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1399k(SwitchOnAnimView switchOnAnimView) {
        this.f2509a = switchOnAnimView;
    }

    @Override // com.acse.ottn.animator.C1316a, com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
    /* renamed from: a */
    public void mo56852a(AbstractC1334a abstractC1334a) {
        Handler handler;
        handler = this.f2509a.f2250c;
        handler.postDelayed(new RunnableC1398j(this), 1000L);
    }
}
