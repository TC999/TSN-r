package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class F implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6321a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6322b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6323c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6324d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6324d = y3;
        this.f6321a = context;
        this.f6322b = accessiblityModel;
        this.f6323c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6324d.a(this.f6321a, this.f6322b, this.f6323c);
    }
}
