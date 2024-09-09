package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6268a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6269b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6270c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6271d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6271d = y3;
        this.f6268a = context;
        this.f6269b = accessiblityModel;
        this.f6270c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6271d.a(this.f6268a, this.f6269b, this.f6270c);
    }
}
