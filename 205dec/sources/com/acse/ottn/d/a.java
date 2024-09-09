package com.acse.ottn.d;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.i;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.ra;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5390a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5391b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5392c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5392c = iVar;
        this.f5390a = appCompatActivity;
        this.f5391b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        Intent intent;
        if (!z3) {
            va.a().a("cancle_flow_window_list");
            ra.b(b1.f5166b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
            return;
        }
        va.a().a("open_flow_window_list");
        try {
            String a4 = C1419ba.a().a("flow_window_state", "1");
            if ((Ka.b().equals("xiaomi") || Ka.b().equals("redmi") || Ka.b().equals("blackshark")) && !a4.equals("2")) {
                C1419ba.a().b("flow_window_state", "2");
                C1419ba.a().b("OpenPermissionName", "\u663e\u793a\u60ac\u6d6e\u7a97");
                intent = new Intent();
                C1419ba.a().a("battery_white", true);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", this.f5390a.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
            } else if (Ka.b().equals("vivo") && !a4.equals("2")) {
                C1419ba.a().b("flow_window_state", "2");
                C1419ba.a().a("battery_white", true);
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent2.putExtra("packagename", CommonUtil.PACKAGE_NAME);
                intent2.putExtra("tabId", "1");
                this.f5390a.startActivity(intent2);
                return;
            } else {
                intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                C1419ba.a().b("flow_window_state", "3");
                intent.setData(Uri.parse("package:" + this.f5390a.getPackageName()));
                C1419ba.a().a("battery_white", true);
            }
            this.f5390a.startActivityForResult(intent, this.f5391b);
        } catch (Exception unused) {
            Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            C1419ba.a().b("flow_window_state", "3");
            intent3.setData(Uri.parse("package:" + this.f5390a.getPackageName()));
            C1419ba.a().a("battery_white", true);
            this.f5390a.startActivityForResult(intent3, this.f5391b);
        }
    }
}
