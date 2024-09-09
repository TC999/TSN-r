package com.acse.ottn.activity;

import androidx.annotation.RequiresApi;
import com.acse.ottn.R;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.Ka;

/* renamed from: com.acse.ottn.activity.d  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class RunnableC1348d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4737a;

    RunnableC1348d(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4737a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // java.lang.Runnable
    @RequiresApi(api = 23)
    public void run() {
        if (!C1442n.c().b()) {
            this.f4737a.b(CommonUtil.PACKAGE_NAME);
        } else if (("xiaomi".equals(Ka.b()) || "redmi".equals(Ka.b())) && !C1419ba.a().a("background_battery_hignt") && "2".equals(C1419ba.a().d("flow_window_state"))) {
            this.f4737a.a(CommonUtil.PACKAGE_NAME);
        } else if (com.acse.ottn.d.k.a().b(this.f4737a.getPackageName())) {
            this.f4737a.d();
        } else {
            String string = this.f4737a.getResources().getString(R.string.dialog_keep_back_two_title);
            if (Ka.b().equals("vivo")) {
                string = this.f4737a.getResources().getString(R.string.dialog_keep_back_message);
            }
            AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = this.f4737a;
            accessibiltyTsnPermissionGreenActivity.a(accessibiltyTsnPermissionGreenActivity.getPackageName(), string);
        }
        this.f4737a.j();
    }
}
