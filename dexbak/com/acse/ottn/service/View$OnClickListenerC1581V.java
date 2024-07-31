package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.V */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1581V implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3021a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3022b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3023c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3024d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1581V(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3024d = c1586y;
        this.f3021a = context;
        this.f3022b = accessiblityModel;
        this.f3023c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3024d.m56391a(this.f3021a, this.f3022b, this.f3023c);
    }
}
