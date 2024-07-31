package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1609s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3086a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3087b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3088c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3089d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1609s(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3089d = c1586y;
        this.f3086a = context;
        this.f3087b = accessiblityModel;
        this.f3088c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3089d.m56391a(this.f3086a, this.f3087b, this.f3088c);
    }
}
