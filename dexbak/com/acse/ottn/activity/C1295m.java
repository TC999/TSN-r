package com.acse.ottn.activity;

import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.p042d.p044b.C1509l;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1295m implements C1426k.InterfaceC1427a {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1295m(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2195a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: a */
    public void mo56522a() {
        C1703va.m55903a().m55901a("refuse_minu_service_run");
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: b */
    public void mo56521b() {
        C1703va.m55903a().m55901a("allow_minu_service_run");
        C1509l.m56581b(this.f2195a);
    }
}
