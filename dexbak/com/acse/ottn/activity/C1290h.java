package com.acse.ottn.activity;

import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1290h implements C1426k.InterfaceC1427a {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2190a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1290h(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2190a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: a */
    public void mo56522a() {
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: b */
    public void mo56521b() {
        C1703va.m55903a().m55901a("all_permission_open");
        this.f2190a.setResult(-1);
        this.f2190a.finish();
    }
}
