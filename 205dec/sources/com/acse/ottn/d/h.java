package com.acse.ottn.d;

import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.b.C1383k;
import com.acse.ottn.d.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h implements C1383k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i.a f5516a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f5517b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, i.a aVar) {
        this.f5517b = iVar;
        this.f5516a = aVar;
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void a() {
        AlertDialog alertDialog;
        alertDialog = this.f5517b.f5522c;
        alertDialog.dismiss();
        this.f5516a.a(false);
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void b() {
        AlertDialog alertDialog;
        this.f5516a.a(true);
        alertDialog = this.f5517b.f5522c;
        alertDialog.dismiss();
    }
}
