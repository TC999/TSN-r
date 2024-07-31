package com.acse.ottn.activity;

import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.p042d.C1533k;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1289g implements C1426k.InterfaceC1427a {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1289g(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2189a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: a */
    public void mo56522a() {
        C1703va.m55903a().m55901a("refuse_service_permission");
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: b */
    public void mo56521b() {
        C1661ba.m56097a().m56088b("OpenPermissionName", "应用启动管理");
        C1703va.m55903a().m55901a("allow_service_permission");
        C1533k m56493a = C1533k.m56493a();
        AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = this.f2189a;
        m56493a.m56492a(accessibiltyTsnPermissionGreenActivity, accessibiltyTsnPermissionGreenActivity.getPackageName());
    }
}
