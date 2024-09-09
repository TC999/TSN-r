package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.Y;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class J implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6335a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Y.a f6336b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y f6337c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(Y y3, String str, Y.a aVar) {
        this.f6337c = y3;
        this.f6335a = str;
        this.f6336b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6337c.b(this.f6335a);
        Y.a(this.f6336b);
    }
}
