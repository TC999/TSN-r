package com.acse.ottn.p042d;

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
import com.acse.ottn.C1239R;
import com.acse.ottn.p035b.C1426k;
import com.acse.ottn.p042d.p044b.C1492A;
import com.acse.ottn.p042d.p044b.C1493B;
import com.acse.ottn.p042d.p044b.C1505h;
import com.acse.ottn.p042d.p044b.C1506i;
import com.acse.ottn.p042d.p044b.C1509l;
import com.acse.ottn.p042d.p044b.C1523z;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.C1703va;
import com.acse.ottn.util.CommonUtil;
import com.bxkj.student.C4229c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.acse.ottn.d.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1530i {

    /* renamed from: a */
    private static final String f2830a = "FloatWindowManager";

    /* renamed from: b */
    private static volatile C1530i f2831b;

    /* renamed from: c */
    private AlertDialog f2832c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.d.i$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1531a {
        /* renamed from: a */
        void mo56497a(boolean z);
    }

    /* renamed from: a */
    public static Boolean m56517a(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(100)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    private void m56515a(AppCompatActivity appCompatActivity, InterfaceC1531a interfaceC1531a) {
        m56514a(appCompatActivity, "您的手机没有授予悬浮窗权限，请开启后再试", interfaceC1531a);
    }

    /* renamed from: a */
    private void m56514a(AppCompatActivity appCompatActivity, String str, InterfaceC1531a interfaceC1531a) {
        AlertDialog alertDialog = this.f2832c;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f2832c.dismiss();
        }
        this.f2832c = C1426k.m56822a(appCompatActivity, appCompatActivity.getResources().getString(C1239R.C1245string.dialog_flow_title), appCompatActivity.getResources().getString(C1239R.C1245string.dialog_flow_message), "好的", false, new C1529h(this, interfaceC1531a));
    }

    /* renamed from: b */
    public static C1530i m56512b() {
        if (f2831b == null) {
            synchronized (C1530i.class) {
                if (f2831b == null) {
                    f2831b = new C1530i();
                }
            }
        }
        return f2831b;
    }

    /* renamed from: b */
    public static void m56510b(AppCompatActivity appCompatActivity, int i) throws NoSuchFieldException, IllegalAccessException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + appCompatActivity.getPackageName()));
        appCompatActivity.startActivityForResult(intent, i);
    }

    /* renamed from: b */
    private boolean m56511b(Context context) {
        if (C1493B.m56648c()) {
            return m56507d(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e) {
                C1694ra.m55915b(f2830a, Log.getStackTraceString(e));
            }
        }
        return bool.booleanValue();
    }

    /* renamed from: c */
    private void m56508c(AppCompatActivity appCompatActivity, int i) {
        m56515a(appCompatActivity, new C1491b(this, appCompatActivity, i));
    }

    /* renamed from: c */
    private boolean m56509c(Context context) {
        return C1505h.m56619a(context);
    }

    /* renamed from: d */
    private void m56506d(AppCompatActivity appCompatActivity, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            m56504e(appCompatActivity, i);
        } else if (C1493B.m56647d()) {
            m56499h(appCompatActivity, i);
        } else if (C1493B.m56648c()) {
            m56500g(appCompatActivity, i);
        } else if (C1493B.m56649b()) {
            m56502f(appCompatActivity, i);
        } else if (C1493B.m56651a()) {
            m56508c(appCompatActivity, i);
        } else if (C1493B.m56646e()) {
            m56498i(appCompatActivity, i);
        }
    }

    /* renamed from: d */
    private boolean m56507d(Context context) {
        return C1506i.m56596a(context);
    }

    /* renamed from: e */
    private void m56504e(AppCompatActivity appCompatActivity, int i) {
        if (C1493B.m56648c()) {
            m56500g(appCompatActivity, i);
        } else if (Build.VERSION.SDK_INT >= 23) {
            m56515a(appCompatActivity, new C1528g(this, appCompatActivity, i));
        }
    }

    /* renamed from: e */
    private boolean m56505e(Context context) {
        return C1509l.m56588a(context);
    }

    /* renamed from: f */
    private void m56502f(AppCompatActivity appCompatActivity, int i) {
        m56515a(appCompatActivity, new C1524c(this, appCompatActivity, i));
    }

    /* renamed from: f */
    private boolean m56503f(Context context) {
        return C1523z.m56534a(context);
    }

    /* renamed from: g */
    private void m56500g(AppCompatActivity appCompatActivity, int i) {
        m56515a(appCompatActivity, new C1525d(this, appCompatActivity, i));
    }

    /* renamed from: g */
    private boolean m56501g(Context context) {
        return C1492A.m56654a(context);
    }

    /* renamed from: h */
    private void m56499h(AppCompatActivity appCompatActivity, int i) {
        m56515a(appCompatActivity, new C1526e(this, appCompatActivity, i));
    }

    /* renamed from: i */
    private void m56498i(AppCompatActivity appCompatActivity, int i) {
        m56515a(appCompatActivity, new C1527f(this, appCompatActivity, i));
    }

    /* renamed from: a */
    public void m56519a(Activity activity, int i) {
        Intent intent;
        C1703va.m55903a().m55901a("open_flow_window_list");
        try {
            String m56093a = C1661ba.m56097a().m56093a("flow_window_state", "1");
            if ((C1638Ka.m56193b().equals(C4229c.f16088d) || C1638Ka.m56193b().equals("redmi") || C1638Ka.m56193b().equals("blackshark")) && !m56093a.equals("2")) {
                C1661ba.m56097a().m56088b("flow_window_state", "2");
                C1661ba.m56097a().m56088b("OpenPermissionName", "显示悬浮窗");
                intent = new Intent();
                C1661ba.m56097a().m56092a("battery_white", true);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
            } else if (C1638Ka.m56193b().equals("vivo") && !m56093a.equals("2")) {
                C1661ba.m56097a().m56088b("flow_window_state", "2");
                C1661ba.m56097a().m56092a("battery_white", true);
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent2.putExtra("packagename", CommonUtil.PACKAGE_NAME);
                intent2.putExtra("tabId", "1");
                activity.startActivity(intent2);
                return;
            } else {
                intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                C1661ba.m56097a().m56088b("flow_window_state", "3");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                C1661ba.m56097a().m56092a("battery_white", true);
            }
            activity.startActivityForResult(intent, i);
        } catch (Exception unused) {
            Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            C1661ba.m56097a().m56088b("flow_window_state", "3");
            intent3.setData(Uri.parse("package:" + activity.getPackageName()));
            C1661ba.m56097a().m56092a("battery_white", true);
            activity.startActivityForResult(intent3, i);
        }
    }

    /* renamed from: a */
    public void m56516a(AppCompatActivity appCompatActivity, int i) {
        C1684n.m55975c().m55985a(false);
        m56515a(appCompatActivity, new C1484a(this, appCompatActivity, i));
    }

    /* renamed from: a */
    public boolean m56520a() {
        AlertDialog alertDialog = this.f2832c;
        return alertDialog != null && alertDialog.isShowing();
    }

    /* renamed from: a */
    public boolean m56518a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (C1493B.m56647d()) {
                return m56505e(context);
            }
            if (C1493B.m56648c()) {
                return m56507d(context);
            }
            if (C1493B.m56649b()) {
                return m56509c(context);
            }
            if (C1493B.m56651a()) {
                return m56501g(context);
            }
            if (C1493B.m56646e()) {
                return m56503f(context);
            }
        }
        return m56511b(context);
    }
}
