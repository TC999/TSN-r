package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.o */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1605o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3074a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3075b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3076c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3077d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1605o(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3077d = c1586y;
        this.f3074a = context;
        this.f3075b = accessiblityModel;
        this.f3076c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3077d.m56391a(this.f3074a, this.f3075b, this.f3076c);
    }
}
