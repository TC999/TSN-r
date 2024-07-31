package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1616z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3105a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3106b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3107c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3108d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1616z(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3108d = c1586y;
        this.f3105a = context;
        this.f3106b = accessiblityModel;
        this.f3107c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3108d.m56391a(this.f3105a, this.f3106b, this.f3107c);
    }
}
