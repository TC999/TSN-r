package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.u */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1611u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3092a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3093b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3094c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3095d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1611u(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3095d = c1586y;
        this.f3092a = context;
        this.f3093b = accessiblityModel;
        this.f3094c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3095d.m56391a(this.f3092a, this.f3093b, this.f3094c);
    }
}
