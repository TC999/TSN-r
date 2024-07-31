package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.I */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1569I implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f2982a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f2983b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f2984c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f2985d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1569I(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2985d = c1586y;
        this.f2982a = context;
        this.f2983b = accessiblityModel;
        this.f2984c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2985d.m56391a(this.f2982a, this.f2983b, this.f2984c);
    }
}
