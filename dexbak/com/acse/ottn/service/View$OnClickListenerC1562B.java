package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.B */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1562B implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f2946a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f2947b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f2948c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f2949d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1562B(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2949d = c1586y;
        this.f2946a = context;
        this.f2947b = accessiblityModel;
        this.f2948c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2949d.m56391a(this.f2946a, this.f2947b, this.f2948c);
    }
}
