package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.x */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1614x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3099a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3100b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3101c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3102d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1614x(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3102d = c1586y;
        this.f3099a = context;
        this.f3100b = accessiblityModel;
        this.f3101c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3102d.m56391a(this.f3099a, this.f3100b, this.f3101c);
    }
}
