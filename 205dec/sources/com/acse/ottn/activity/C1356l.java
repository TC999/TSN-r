package com.acse.ottn.activity;

import com.acse.ottn.b.C;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.va;

/* renamed from: com.acse.ottn.activity.l  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1356l implements C.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4745a;

    C1356l(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4745a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.b.C.a
    public void onDismiss() {
        va.a().a("refuse_service");
    }

    @Override // com.acse.ottn.b.C.a
    public void onOpen() {
        C1419ba.a().a("is_agree_service", true);
        va.a().a("allow_service");
        this.f4745a.f4601p.setChecked(true);
        this.f4745a.l();
    }
}
