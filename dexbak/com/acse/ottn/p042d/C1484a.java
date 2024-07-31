package com.acse.ottn.p042d;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.C1703va;
import com.acse.ottn.util.CommonUtil;
import com.bxkj.student.C4229c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1484a implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2720a;

    /* renamed from: b */
    final /* synthetic */ int f2721b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2722c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1484a(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2722c = c1530i;
        this.f2720a = appCompatActivity;
        this.f2721b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        Intent intent;
        if (!z) {
            C1703va.m55903a().m55901a("cancle_flow_window_list");
            C1694ra.m55915b("FloatWindowManager", "ROM:360, user manually refuse OVERLAY_PERMISSION");
            return;
        }
        C1703va.m55903a().m55901a("open_flow_window_list");
        try {
            String m56093a = C1661ba.m56097a().m56093a("flow_window_state", "1");
            if ((C1638Ka.m56193b().equals(C4229c.f16088d) || C1638Ka.m56193b().equals("redmi") || C1638Ka.m56193b().equals("blackshark")) && !m56093a.equals("2")) {
                C1661ba.m56097a().m56088b("flow_window_state", "2");
                C1661ba.m56097a().m56088b("OpenPermissionName", "显示悬浮窗");
                intent = new Intent();
                C1661ba.m56097a().m56092a("battery_white", true);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", this.f2720a.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
            } else if (C1638Ka.m56193b().equals("vivo") && !m56093a.equals("2")) {
                C1661ba.m56097a().m56088b("flow_window_state", "2");
                C1661ba.m56097a().m56092a("battery_white", true);
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent2.putExtra("packagename", CommonUtil.PACKAGE_NAME);
                intent2.putExtra("tabId", "1");
                this.f2720a.startActivity(intent2);
                return;
            } else {
                intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                C1661ba.m56097a().m56088b("flow_window_state", "3");
                intent.setData(Uri.parse("package:" + this.f2720a.getPackageName()));
                C1661ba.m56097a().m56092a("battery_white", true);
            }
            this.f2720a.startActivityForResult(intent, this.f2721b);
        } catch (Exception unused) {
            Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            C1661ba.m56097a().m56088b("flow_window_state", "3");
            intent3.setData(Uri.parse("package:" + this.f2720a.getPackageName()));
            C1661ba.m56097a().m56092a("battery_white", true);
            this.f2720a.startActivityForResult(intent3, this.f2721b);
        }
    }
}
