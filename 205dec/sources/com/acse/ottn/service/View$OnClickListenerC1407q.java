package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.q  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1407q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6571a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6572b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6573c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6574d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1407q(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6574d = y3;
        this.f6571a = context;
        this.f6572b = accessiblityModel;
        this.f6573c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6574d.a(this.f6571a, this.f6572b, this.f6573c);
    }
}
