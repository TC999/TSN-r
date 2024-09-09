package com.acse.ottn;

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
import com.acse.ottn.u0;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b1 {

    /* renamed from: b  reason: collision with root package name */
    public static final String f5166b = "FloatWindowManager";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b1 f5167c;

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f5168a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5169a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5170b;

        public a(AppCompatActivity appCompatActivity, int i4) {
            this.f5169a = appCompatActivity;
            this.f5170b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                i2.a().a("open_flow_window_list");
                try {
                    String a4 = g1.a().a("flow_window_state", "1");
                    if ((c4.b().equals("xiaomi") || c4.b().equals("redmi") || c4.b().equals("blackshark")) && !a4.equals("2")) {
                        g1.a().b("flow_window_state", "2");
                        g1.a().b("OpenPermissionName", "\u663e\u793a\u60ac\u6d6e\u7a97");
                        Intent intent = new Intent();
                        g1.a().a("battery_white", true);
                        ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                        intent.putExtra("extra_pkgname", this.f5169a.getPackageName());
                        intent.setComponent(componentName);
                        intent.addFlags(268435456);
                        this.f5169a.startActivityForResult(intent, this.f5170b);
                        return;
                    } else if (c4.b().equals("vivo") && !a4.equals("2")) {
                        g1.a().b("flow_window_state", "2");
                        g1.a().a("battery_white", true);
                        Intent intent2 = new Intent();
                        intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                        intent2.putExtra("packagename", j0.f5781w);
                        intent2.putExtra("tabId", "1");
                        this.f5169a.startActivity(intent2);
                        return;
                    } else {
                        Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                        g1.a().b("flow_window_state", "3");
                        intent3.setData(Uri.parse("package:" + this.f5169a.getPackageName()));
                        g1.a().a("battery_white", true);
                        this.f5169a.startActivityForResult(intent3, this.f5170b);
                        return;
                    }
                } catch (Exception unused) {
                    Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    g1.a().b("flow_window_state", "3");
                    intent4.setData(Uri.parse("package:" + this.f5169a.getPackageName()));
                    g1.a().a("battery_white", true);
                    this.f5169a.startActivityForResult(intent4, this.f5170b);
                    return;
                }
            }
            i2.a().a("cancle_flow_window_list");
            z1.b(b1.f5166b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5172a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5173b;

        public b(AppCompatActivity appCompatActivity, int i4) {
            this.f5172a = appCompatActivity;
            this.f5173b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                d3.a((Activity) this.f5172a, this.f5173b);
            } else {
                z1.b(b1.f5166b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5175a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5176b;

        public c(AppCompatActivity appCompatActivity, int i4) {
            this.f5175a = appCompatActivity;
            this.f5176b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                l1.a((Activity) this.f5175a, this.f5176b);
            } else {
                z1.b(b1.f5166b, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5179b;

        public d(AppCompatActivity appCompatActivity, int i4) {
            this.f5178a = appCompatActivity;
            this.f5179b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                g2.a(this.f5178a, this.f5179b);
            } else {
                z1.b(b1.f5166b, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5182b;

        public e(AppCompatActivity appCompatActivity, int i4) {
            this.f5181a = appCompatActivity;
            this.f5182b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                h2.a((Activity) this.f5181a, this.f5182b);
            } else {
                z1.b(b1.f5166b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5184a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5185b;

        public f(AppCompatActivity appCompatActivity, int i4) {
            this.f5184a = appCompatActivity;
            this.f5185b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                x2.a((Activity) this.f5184a, this.f5185b);
            } else {
                z1.b(b1.f5166b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f5187a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5188b;

        public g(AppCompatActivity appCompatActivity, int i4) {
            this.f5187a = appCompatActivity;
            this.f5188b = i4;
        }

        @Override // com.acse.ottn.b1.i
        public void a(boolean z3) {
            if (z3) {
                try {
                    b1.e(this.f5187a, this.f5188b);
                    return;
                } catch (Exception e4) {
                    z1.b(b1.f5166b, Log.getStackTraceString(e4));
                    return;
                }
            }
            z1.a(b1.f5166b, "user manually refuse OVERLAY_PERMISSION");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements u0.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f5190a;

        public h(i iVar) {
            this.f5190a = iVar;
        }

        @Override // com.acse.ottn.u0.c
        public void a() {
            b1.this.f5168a.dismiss();
            this.f5190a.a(false);
        }

        @Override // com.acse.ottn.u0.c
        public void b() {
            this.f5190a.a(true);
            b1.this.f5168a.dismiss();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface i {
        void a(boolean z3);
    }

    public static b1 b() {
        if (f5167c == null) {
            synchronized (b1.class) {
                if (f5167c == null) {
                    f5167c = new b1();
                }
            }
        }
        return f5167c;
    }

    public final boolean c(Context context) {
        return l1.a(context);
    }

    public final boolean d(Context context) {
        return g2.a(context);
    }

    public final boolean e(Context context) {
        return h2.a(context);
    }

    public final boolean f(Context context) {
        return x2.a(context);
    }

    public final boolean g(Context context) {
        return d3.a(context);
    }

    public final void h(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new e(appCompatActivity, i4));
    }

    public final void i(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new f(appCompatActivity, i4));
    }

    public static Boolean a(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(100)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void e(AppCompatActivity appCompatActivity, int i4) throws NoSuchFieldException, IllegalAccessException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + appCompatActivity.getPackageName()));
        appCompatActivity.startActivityForResult(intent, i4);
    }

    public final void c(AppCompatActivity appCompatActivity, int i4) {
        if (Build.VERSION.SDK_INT < 23) {
            if (h3.d()) {
                h(appCompatActivity, i4);
                return;
            } else if (h3.c()) {
                g(appCompatActivity, i4);
                return;
            } else if (h3.b()) {
                f(appCompatActivity, i4);
                return;
            } else if (h3.a()) {
                a(appCompatActivity, i4);
                return;
            } else if (h3.e()) {
                i(appCompatActivity, i4);
                return;
            } else {
                return;
            }
        }
        d(appCompatActivity, i4);
    }

    public final void d(AppCompatActivity appCompatActivity, int i4) {
        if (h3.c()) {
            g(appCompatActivity, i4);
        } else if (Build.VERSION.SDK_INT >= 23) {
            a(appCompatActivity, new g(appCompatActivity, i4));
        }
    }

    public final void f(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new c(appCompatActivity, i4));
    }

    public final void g(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new d(appCompatActivity, i4));
    }

    public void b(AppCompatActivity appCompatActivity, int i4) {
        com.acse.ottn.b.d().a(false);
        a(appCompatActivity, new a(appCompatActivity, i4));
    }

    public boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public final boolean b(Context context) {
        if (h3.c()) {
            return d(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e4) {
                z1.b(f5166b, Log.getStackTraceString(e4));
            }
        }
        return bool.booleanValue();
    }

    public final void a(AppCompatActivity appCompatActivity, int i4) {
        a(appCompatActivity, new b(appCompatActivity, i4));
    }

    public final void a(AppCompatActivity appCompatActivity, i iVar) {
        a(appCompatActivity, "\u60a8\u7684\u624b\u673a\u6ca1\u6709\u6388\u4e88\u60ac\u6d6e\u7a97\u6743\u9650\uff0c\u8bf7\u5f00\u542f\u540e\u518d\u8bd5", iVar);
    }

    public boolean a() {
        AlertDialog alertDialog = this.f5168a;
        return alertDialog != null && alertDialog.isShowing();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, i iVar) {
        AlertDialog alertDialog = this.f5168a;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f5168a.dismiss();
        }
        this.f5168a = u0.a(appCompatActivity, appCompatActivity.getResources().getString(R.string.dialog_flow_title), appCompatActivity.getResources().getString(R.string.dialog_flow_message), "\u597d\u7684", false, new h(iVar));
    }

    public void a(Activity activity, int i4) {
        i2.a().a("open_flow_window_list");
        try {
            String a4 = g1.a().a("flow_window_state", "1");
            if ((c4.b().equals("xiaomi") || c4.b().equals("redmi") || c4.b().equals("blackshark")) && !a4.equals("2")) {
                g1.a().b("flow_window_state", "2");
                g1.a().b("OpenPermissionName", "\u663e\u793a\u60ac\u6d6e\u7a97");
                Intent intent = new Intent();
                g1.a().a("battery_white", true);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                activity.startActivityForResult(intent, i4);
            } else if (c4.b().equals("vivo") && !a4.equals("2")) {
                g1.a().b("flow_window_state", "2");
                g1.a().a("battery_white", true);
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent2.putExtra("packagename", j0.f5781w);
                intent2.putExtra("tabId", "1");
                activity.startActivity(intent2);
            } else {
                Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                g1.a().b("flow_window_state", "3");
                intent3.setData(Uri.parse("package:" + activity.getPackageName()));
                g1.a().a("battery_white", true);
                activity.startActivityForResult(intent3, i4);
            }
        } catch (Exception unused) {
            Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            g1.a().b("flow_window_state", "3");
            intent4.setData(Uri.parse("package:" + activity.getPackageName()));
            g1.a().a("battery_white", true);
            activity.startActivityForResult(intent4, i4);
        }
    }
}
