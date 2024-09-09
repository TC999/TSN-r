package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class M implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6362a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6363b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6364c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6365d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6365d = y3;
        this.f6362a = context;
        this.f6363b = accessiblityModel;
        this.f6364c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6365d.a(this.f6362a, this.f6363b, this.f6364c);
    }
}
