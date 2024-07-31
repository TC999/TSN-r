package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1607q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3080a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3081b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3082c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3083d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1607q(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3083d = c1586y;
        this.f3080a = context;
        this.f3081b = accessiblityModel;
        this.f3082c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3083d.m56391a(this.f3080a, this.f3081b, this.f3082c);
    }
}
