package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.T */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1579T implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f3015a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f3016b;

    /* renamed from: c */
    final /* synthetic */ C1586Y.InterfaceC1587a f3017c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f3018d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1579T(C1586Y c1586y, Context context, AccessiblityModel accessiblityModel, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3018d = c1586y;
        this.f3015a = context;
        this.f3016b = accessiblityModel;
        this.f3017c = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3018d.m56391a(this.f3015a, this.f3016b, this.f3017c);
    }
}
