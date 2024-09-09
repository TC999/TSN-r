package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.s  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1408s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6577a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6578b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6579c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6580d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1408s(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6580d = y3;
        this.f6577a = context;
        this.f6578b = accessiblityModel;
        this.f6579c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6580d.a(this.f6577a, this.f6578b, this.f6579c);
    }
}
