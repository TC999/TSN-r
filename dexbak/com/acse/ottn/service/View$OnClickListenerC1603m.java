package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1603m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3068a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3069b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3070c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3071d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1603m(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3071d = c1586y;
        this.f3068a = context;
        this.f3069b = accessiblityModel;
        this.f3070c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3071d.m56391a(this.f3068a, this.f3069b, this.f3070c);
    }
}
