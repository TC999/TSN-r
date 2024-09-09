package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.u  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1410u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6583a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6584b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6585c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6586d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1410u(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6586d = y3;
        this.f6583a = context;
        this.f6584b = accessiblityModel;
        this.f6585c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6586d.a(this.f6583a, this.f6584b, this.f6585c);
    }
}
