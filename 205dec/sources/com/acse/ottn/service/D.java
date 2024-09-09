package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class D implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6297a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Y.a f6298b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y f6299c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(Y y3, String str, Y.a aVar) {
        this.f6299c = y3;
        this.f6297a = str;
        this.f6298b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Y.a(this.f6297a, this.f6298b);
    }
}
