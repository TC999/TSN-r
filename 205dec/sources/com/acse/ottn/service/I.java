package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class I implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6331a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6332b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6333c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6334d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6334d = y3;
        this.f6331a = context;
        this.f6332b = accessiblityModel;
        this.f6333c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6334d.a(this.f6331a, this.f6332b, this.f6333c);
    }
}
