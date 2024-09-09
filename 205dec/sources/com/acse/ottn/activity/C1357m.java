package com.acse.ottn.activity;

import com.acse.ottn.b.C1383k;
import com.acse.ottn.util.va;

/* renamed from: com.acse.ottn.activity.m  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1357m implements C1383k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4746a;

    C1357m(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4746a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void a() {
        va.a().a("refuse_minu_service_run");
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void b() {
        va.a().a("allow_minu_service_run");
        com.acse.ottn.d.b.l.b(this.f4746a);
    }
}
