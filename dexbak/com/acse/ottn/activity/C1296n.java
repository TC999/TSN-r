package com.acse.ottn.activity;

import android.app.Activity;
import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1692qa;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1296n implements C1426k.InterfaceC1427a {

    /* renamed from: a */
    final /* synthetic */ String f2196a;

    /* renamed from: b */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2197b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1296n(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity, String str) {
        this.f2197b = accessibiltyTsnPermissionGreenActivity;
        this.f2196a = str;
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: a */
    public void mo56522a() {
    }

    @Override // com.acse.ottn.p035b.C1426k.InterfaceC1427a
    /* renamed from: b */
    public void mo56521b() {
        if (C1661ba.m56097a().m56090b("location_permission_size") == 0) {
            C1661ba.m56097a().m56089b("location_permission_size", 1);
            C1692qa.m55930a().m55921e(this.f2197b);
        } else if (this.f2196a.equals("1")) {
            C1661ba.m56097a().m56089b("location_permission_size", 2);
            C1692qa.m55930a().m55924c((Activity) this.f2197b);
        } else if (this.f2196a.equals("2")) {
            C1661ba.m56097a().m56089b("location_permission_size", 3);
            C1692qa.m55930a().m55926b((Activity) this.f2197b);
        }
    }
}
