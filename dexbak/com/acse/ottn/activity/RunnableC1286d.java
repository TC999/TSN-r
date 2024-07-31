package com.acse.ottn.activity;

import androidx.annotation.RequiresApi;
import com.acse.ottn.C1239R;
import com.acse.ottn.p042d.C1533k;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.CommonUtil;
import com.bxkj.student.C4229c;

/* renamed from: com.acse.ottn.activity.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1286d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2186a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1286d(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2186a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // java.lang.Runnable
    @RequiresApi(api = 23)
    public void run() {
        if (!C1684n.m55975c().m55984b()) {
            this.f2186a.m57325b(CommonUtil.PACKAGE_NAME);
        } else if ((C4229c.f16088d.equals(C1638Ka.m56193b()) || "redmi".equals(C1638Ka.m56193b())) && !C1661ba.m56097a().m56096a("background_battery_hignt") && "2".equals(C1661ba.m56097a().m56086d("flow_window_state"))) {
            this.f2186a.m57330a(CommonUtil.PACKAGE_NAME);
        } else if (C1533k.m56493a().m56489b(this.f2186a.getPackageName())) {
            this.f2186a.m57321d();
        } else {
            String string = this.f2186a.getResources().getString(C1239R.C1245string.dialog_keep_back_two_title);
            if (C1638Ka.m56193b().equals("vivo")) {
                string = this.f2186a.getResources().getString(C1239R.C1245string.dialog_keep_back_message);
            }
            AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = this.f2186a;
            accessibiltyTsnPermissionGreenActivity.m57329a(accessibiltyTsnPermissionGreenActivity.getPackageName(), string);
        }
        this.f2186a.m57312j();
    }
}
