package com.acse.ottn.activity;

import android.app.Activity;
import com.acse.ottn.b.C1383k;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.qa;

/* renamed from: com.acse.ottn.activity.n  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1358n implements C1383k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4747a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4748b;

    C1358n(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity, String str) {
        this.f4748b = accessibiltyTsnPermissionGreenActivity;
        this.f4747a = str;
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void a() {
    }

    @Override // com.acse.ottn.b.C1383k.a
    public void b() {
        if (C1419ba.a().b("location_permission_size") == 0) {
            C1419ba.a().b("location_permission_size", 1);
            qa.a().e(this.f4748b);
        } else if (this.f4747a.equals("1")) {
            C1419ba.a().b("location_permission_size", 2);
            qa.a().c((Activity) this.f4748b);
        } else if (this.f4747a.equals("2")) {
            C1419ba.a().b("location_permission_size", 3);
            qa.a().b((Activity) this.f4748b);
        }
    }
}
