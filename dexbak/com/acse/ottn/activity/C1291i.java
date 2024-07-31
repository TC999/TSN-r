package com.acse.ottn.activity;

import com.acse.ottn.p035b.C1418d;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1291i implements C1418d.InterfaceC1419a {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1291i(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2191a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.p035b.C1418d.InterfaceC1419a
    public void onDismiss() {
        C1703va.m55903a().m55901a("refuse_continue_open_permission");
        this.f2191a.finish();
    }

    @Override // com.acse.ottn.p035b.C1418d.InterfaceC1419a
    public void onOpen() {
        C1703va.m55903a().m55901a("continue_open_permission");
        this.f2191a.m57310l();
    }
}
