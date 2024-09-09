package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.m  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1403m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6559a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6560b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6561c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6562d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1403m(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6562d = y3;
        this.f6559a = context;
        this.f6560b = accessiblityModel;
        this.f6561c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6562d.a(this.f6559a, this.f6560b, this.f6561c);
    }
}
