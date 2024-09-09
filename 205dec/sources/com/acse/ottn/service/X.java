package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class X implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6411a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6412b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6413c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6414d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6414d = y3;
        this.f6411a = context;
        this.f6412b = accessiblityModel;
        this.f6413c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6414d.a(this.f6411a, this.f6412b, this.f6413c);
    }
}
