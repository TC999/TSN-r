package com.acse.ottn.activity;

import com.acse.ottn.b.C1383k;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.va;

/* renamed from: com.acse.ottn.activity.g  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1351g implements C1383k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4740a;

    C1351g(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4740a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void a() {
        va.a().a("refuse_service_permission");
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void b() {
        C1419ba.a().b("OpenPermissionName", "\u5e94\u7528\u542f\u52a8\u7ba1\u7406");
        va.a().a("allow_service_permission");
        com.acse.ottn.d.k a4 = com.acse.ottn.d.k.a();
        AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = this.f4740a;
        a4.a(accessibiltyTsnPermissionGreenActivity, accessibiltyTsnPermissionGreenActivity.getPackageName());
    }
}
