package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class V implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6393a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6394b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6395c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6396d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6396d = y3;
        this.f6393a = context;
        this.f6394b = accessiblityModel;
        this.f6395c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6396d.a(this.f6393a, this.f6394b, this.f6395c);
    }
}
