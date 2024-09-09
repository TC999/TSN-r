package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.Y;
import com.acse.ottn.util.va;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y.a f6272a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Y f6273b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(Y y3, Y.a aVar) {
        this.f6273b = y3;
        this.f6272a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        va.a().a("close_coupon_window");
        Y.a(this.f6272a);
    }
}
