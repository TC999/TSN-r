package com.acse.ottn.activity;

import com.acse.ottn.b.C1376d;
import com.acse.ottn.util.va;

/* renamed from: com.acse.ottn.activity.i  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1353i implements C1376d.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4742a;

    C1353i(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4742a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.b.C1376d.a
    public void onDismiss() {
        va.a().a("refuse_continue_open_permission");
        this.f4742a.finish();
    }

    @Override // com.acse.ottn.b.C1376d.a
    public void onOpen() {
        va.a().a("continue_open_permission");
        this.f4742a.l();
    }
}
