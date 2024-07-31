package com.acse.ottn.activity;

import android.app.Activity;
import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.p042d.p044b.C1497F;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1285c implements C1426k.InterfaceC1427a {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2185a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1285c(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2185a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: a */
    public void mo56522a() {
        C1703va.m55903a().m55901a("refuse_vivo_buttery_manage");
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: b */
    public void mo56521b() {
        C1703va.m55903a().m55901a("allow_vivo_buttery_manage");
        C1497F.m56639a((Activity) this.f2185a);
    }
}
