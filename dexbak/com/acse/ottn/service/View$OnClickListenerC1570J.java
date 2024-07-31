package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.J */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1570J implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2986a;

    /* renamed from: b */
    final /* synthetic */ C1586Y.InterfaceC1587a f2987b;

    /* renamed from: c */
    final /* synthetic */ C1586Y f2988c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1570J(C1586Y c1586y, String str, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2988c = c1586y;
        this.f2986a = str;
        this.f2987b = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2988c.m56380b(this.f2986a);
        C1586Y.m56387a(this.f2987b);
    }
}
