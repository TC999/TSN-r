package com.acse.ottn.service;

import android.view.View;
import com.acse.ottn.service.C1586Y;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.D */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnClickListenerC1564D implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2952a;

    /* renamed from: b */
    final /* synthetic */ C1586Y.InterfaceC1587a f2953b;

    /* renamed from: c */
    final /* synthetic */ C1586Y f2954c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1564D(C1586Y c1586y, String str, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f2954c = c1586y;
        this.f2952a = str;
        this.f2953b = interfaceC1587a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1586Y.m56384a(this.f2952a, this.f2953b);
    }
}
