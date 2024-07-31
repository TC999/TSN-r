package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.C1586Y;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.C */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1563C implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1586Y.InterfaceC1587a f2950a;

    /* renamed from: b */
    final /* synthetic */ C1586Y f2951b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1563C(C1586Y c1586y, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2951b = c1586y;
        this.f2950a = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1703va.m55903a().m55901a("close_coupon_window");
        C1586Y.m56387a(this.f2950a);
    }
}
