package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class L implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y.a f6340a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Y f6341b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(Y y3, Y.a aVar) {
        this.f6341b = y3;
        this.f6340a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Y.a(this.f6340a);
    }
}
