package com.acse.ottn.receiver;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    long f6229a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f6230b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar) {
        this.f6230b = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6229a = System.currentTimeMillis();
    }
}
