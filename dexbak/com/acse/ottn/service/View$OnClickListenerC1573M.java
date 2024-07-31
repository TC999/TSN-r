package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.M */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1573M implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f2993a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f2994b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f2995c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f2996d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1573M(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2996d = c1586y;
        this.f2993a = context;
        this.f2994b = accessiblityModel;
        this.f2995c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2996d.m56391a(this.f2993a, this.f2994b, this.f2995c);
    }
}
