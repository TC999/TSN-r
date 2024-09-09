package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class T implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6387a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6388b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6389c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6390d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6390d = y3;
        this.f6387a = context;
        this.f6388b = accessiblityModel;
        this.f6389c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6390d.a(this.f6387a, this.f6388b, this.f6389c);
    }
}
