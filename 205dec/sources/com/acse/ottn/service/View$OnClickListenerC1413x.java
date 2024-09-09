package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.x  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1413x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6590a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6591b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6592c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6593d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1413x(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6593d = y3;
        this.f6590a = context;
        this.f6591b = accessiblityModel;
        this.f6592c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6593d.a(this.f6590a, this.f6591b, this.f6592c);
    }
}
