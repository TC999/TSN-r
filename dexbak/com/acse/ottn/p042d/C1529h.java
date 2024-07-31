package com.acse.ottn.p042d;

import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.p042d.C1530i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1529h implements C1426k.InterfaceC1427a {

    /* renamed from: a */
    final /* synthetic */ C1530i.InterfaceC1531a f2828a;

    /* renamed from: b */
    final /* synthetic */ C1530i f2829b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1529h(C1530i c1530i, C1530i.InterfaceC1531a interfaceC1531a) {
        this.f2829b = c1530i;
        this.f2828a = interfaceC1531a;
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: a */
    public void mo56522a() {
        AlertDialog alertDialog;
        alertDialog = this.f2829b.f2832c;
        alertDialog.dismiss();
        this.f2828a.mo56497a(false);
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: b */
    public void mo56521b() {
        AlertDialog alertDialog;
        this.f2828a.mo56497a(true);
        alertDialog = this.f2829b.f2832c;
        alertDialog.dismiss();
    }
}
