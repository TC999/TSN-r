package com.acse.ottn.activity;

import android.app.Activity;
import com.acse.ottn.b.C1383k;
import com.acse.ottn.util.va;

/* renamed from: com.acse.ottn.activity.c  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1347c implements C1383k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4736a;

    C1347c(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4736a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void a() {
        va.a().a("refuse_vivo_buttery_manage");
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void b() {
        va.a().a("allow_vivo_buttery_manage");
        com.acse.ottn.d.b.F.a((Activity) this.f4736a);
    }
}
