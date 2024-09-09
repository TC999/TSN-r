package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.o  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1405o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6565a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6566b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6567c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6568d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1405o(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6568d = y3;
        this.f6565a = context;
        this.f6566b = accessiblityModel;
        this.f6567c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6568d.a(this.f6565a, this.f6566b, this.f6567c);
    }
}
