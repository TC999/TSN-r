package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class E implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y.a f6305a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Y f6306b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(Y y3, Y.a aVar) {
        this.f6306b = y3;
        this.f6305a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Y.a(this.f6305a);
    }
}
