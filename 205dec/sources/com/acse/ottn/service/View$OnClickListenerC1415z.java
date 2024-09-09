package com.acse.ottn.service;

import android.content.Context;
import android.view.View;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;

/* renamed from: com.acse.ottn.service.z  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class View$OnClickListenerC1415z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6596a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6597b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y.a f6598c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6599d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1415z(Y y3, Context context, AccessiblityModel accessiblityModel, Y.a aVar) {
        this.f6599d = y3;
        this.f6596a = context;
        this.f6597b = accessiblityModel;
        this.f6598c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6599d.a(this.f6596a, this.f6597b, this.f6598c);
    }
}
