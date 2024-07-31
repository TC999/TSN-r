package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.X */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1585X implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3037a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3038b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3039c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3040d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1585X(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3040d = c1586y;
        this.f3037a = context;
        this.f3038b = accessiblityModel;
        this.f3039c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3040d.m56391a(this.f3037a, this.f3038b, this.f3039c);
    }
}
