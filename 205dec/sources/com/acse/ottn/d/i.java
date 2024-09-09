package com.acse.ottn.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.R;
import com.acse.ottn.b.C1383k;
import com.acse.ottn.d.b.A;
import com.acse.ottn.d.b.B;
import com.acse.ottn.d.b.l;
import com.acse.ottn.d.b.z;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.ra;
import com.acse.ottn.util.va;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5520a = "FloatWindowManager";

    /* renamed from: b  reason: collision with root package name */
    private static volatile i f5521b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f5522c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(boolean z3);
    }

    public static Boolean a(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(100)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private void a(AppCompatActivity appCompatActivity, a aVar) {
        a(appCompatActivity, "\u60a8\u7684\u624b\u673a\u6ca1\u6709\u6388\u4e88\u60ac\u6d6e\u7a97\u6743\u9650\uff0c\u8bf7\u5f00\u542f\u540e\u518d\u8bd5", aVar);
    }

    private void a(AppCompatActivity appCompatActivity, String str, a aVar) {
        AlertDialog alertDialog = this.f5522c;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f5522c.dismiss();
        }
        this.f5522c = C1383k.a(appCompatActivity, appCompatActivity.getResources().getString(R.string.dialog_flow_title), appCompatActivity.getResources().getString(R.string.dialog_flow_message), "\u597d\u7684", false, new h(this, aVar));
    }

    public static i b() {
        if (f5521b == null) {
            synchronized (i.class) {
                if (f5521b == null) {
                    f5521b = new i();
                }
            }
        }
        return f5521b;
    }

    public static void b(AppCompatActivity appCompatActivity, int i4) throws NoSuchFieldException, IllegalAccessException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + appCompatActivity.getPackageName()));
        appCompatActivity.startActivityForResult(intent, i4);
    }

    private boolean b(Context context) {
        if (B.c()) {
            return d(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e4) {
                ra.b("FloatWindowManager", Log.getStackTraceString(e4));
            }
        }
        return bool.booleanValue();
    }

    private void c(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new b(this, appCompatActivity, i4));
    }

    private boolean c(Context context) {
        return com.acse.ottn.d.b.h.a(context);
    }

    private void d(AppCompatActivity appCompatActivity, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            e(appCompatActivity, i4);
        } else if (B.d()) {
            h(appCompatActivity, i4);
        } else if (B.c()) {
            g(appCompatActivity, i4);
        } else if (B.b()) {
            f(appCompatActivity, i4);
        } else if (B.a()) {
            c(appCompatActivity, i4);
        } else if (B.e()) {
            i(appCompatActivity, i4);
        }
    }

    private boolean d(Context context) {
        return com.acse.ottn.d.b.i.a(context);
    }

    private void e(AppCompatActivity appCompatActivity, int i4) {
        if (B.c()) {
            g(appCompatActivity, i4);
        } else if (Build.VERSION.SDK_INT >= 23) {
            a(appCompatActivity, new g(this, appCompatActivity, i4));
        }
    }

    private boolean e(Context context) {
        return l.a(context);
    }

    private void f(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new c(this, appCompatActivity, i4));
    }

    private boolean f(Context context) {
        return z.a(context);
    }

    private void g(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new d(this, appCompatActivity, i4));
    }

    private boolean g(Context context) {
        return A.a(context);
    }

    private void h(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new e(this, appCompatActivity, i4));
    }

    private void i(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new f(this, appCompatActivity, i4));
    }

    public void a(Activity activity, int i4) {
        Intent intent;
        va.a().a("open_flow_window_list");
        try {
            String a4 = C1419ba.a().a("flow_window_state", "1");
            if ((Ka.b().equals("xiaomi") || Ka.b().equals("redmi") || Ka.b().equals("blackshark")) && !a4.equals("2")) {
                C1419ba.a().b("flow_window_state", "2");
                C1419ba.a().b("OpenPermissionName", "\u663e\u793a\u60ac\u6d6e\u7a97");
                intent = new Intent();
                C1419ba.a().a("battery_white", true);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
            } else if (Ka.b().equals("vivo") && !a4.equals("2")) {
                C1419ba.a().b("flow_window_state", "2");
                C1419ba.a().a("battery_white", true);
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent2.putExtra("packagename", CommonUtil.PACKAGE_NAME);
                intent2.putExtra("tabId", "1");
                activity.startActivity(intent2);
                return;
            } else {
                intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                C1419ba.a().b("flow_window_state", "3");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                C1419ba.a().a("battery_white", true);
            }
            activity.startActivityForResult(intent, i4);
        } catch (Exception unused) {
            Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            C1419ba.a().b("flow_window_state", "3");
            intent3.setData(Uri.parse("package:" + activity.getPackageName()));
            C1419ba.a().a("battery_white", true);
            activity.startActivityForResult(intent3, i4);
        }
    }

    public void a(AppCompatActivity appCompatActivity, int i4) {
        C1442n.c().a(false);
        a(appCompatActivity, new com.acse.ottn.d.a(this, appCompatActivity, i4));
    }

    public boolean a() {
        AlertDialog alertDialog = this.f5522c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (B.d()) {
                return e(context);
            }
            if (B.c()) {
                return d(context);
            }
            if (B.b()) {
                return c(context);
            }
            if (B.a()) {
                return g(context);
            }
            if (B.e()) {
                return f(context);
            }
        }
        return b(context);
    }
}
