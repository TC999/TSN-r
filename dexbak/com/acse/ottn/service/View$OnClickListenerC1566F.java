package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.F */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1566F implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f2972a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f2973b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f2974c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f2975d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1566F(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2975d = c1586y;
        this.f2972a = context;
        this.f2973b = accessiblityModel;
        this.f2974c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2975d.m56391a(this.f2972a, this.f2973b, this.f2974c);
    }
}
