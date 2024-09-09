package com.acse.ottn.activity;

import com.acse.ottn.b.C1383k;
import com.acse.ottn.util.va;

/* renamed from: com.acse.ottn.activity.h  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1352h implements C1383k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4741a;

    C1352h(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4741a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void a() {
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void b() {
        va.a().a("all_permission_open");
        this.f4741a.setResult(-1);
        this.f4741a.finish();
    }
}
