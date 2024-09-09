package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.l0;
import com.acse.ottn.service.ShopHelperService;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6096a = "NubiaUtils";

    /* renamed from: b  reason: collision with root package name */
    public static TimerTask f6097b;

    /* renamed from: c  reason: collision with root package name */
    public static AccessibilityNodeInfo f6098c;

    public static void c(ShopHelperService shopHelperService) {
        f6097b = l0.a().b(1000, 100, new d(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void d(ShopHelperService shopHelperService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(shopHelperService, "\u8017\u7535\u7ba1\u7406");
        AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(shopHelperService, "\u8017\u7535\u4fdd\u62a4");
        if (g4 == null && g5 == null) {
            return;
        }
        if (g1.a() != null) {
            g1.a().a("battery_white", true);
        }
        if (g4 != null) {
            com.acse.ottn.b.d().g(g4);
        } else {
            com.acse.ottn.b.d().g(g5);
        }
        f6097b = l0.a().b(1500, 200, new c(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void e(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.d().b()) {
            z1.a(f6096a, "\u60ac\u6d6e\u7a97\u6743\u9650\u5df2\u5f00\u542f");
            return;
        }
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(shopHelperService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        if (g4 == null) {
            return;
        }
        com.acse.ottn.b.d().g(g4);
        com.acse.ottn.b.d().e(shopHelperService);
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.d().e(shopHelperService);
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(ShopHelperService shopHelperService) {
        a(shopHelperService.getRootInActiveWindow());
    }

    public static void g(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.d().b()) {
            z1.a(f6096a, "\u60ac\u6d6e\u7a97\u6743\u9650\u5df2\u5f00\u542f");
            return;
        }
        f6097b = l0.a().b(20000, 100, new b(shopHelperService, h1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void h(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.d().b()) {
            z1.a(f6096a, "\u60ac\u6d6e\u7a97\u6743\u9650\u5df2\u5f00\u542f");
            return;
        }
        f6097b = l0.a().b(20000, 100, new a(shopHelperService, h1.c().b()));
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    public static boolean a(Context context, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if ("".equals(j0.f5781w)) {
            return true;
        }
        if (i5 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), j0.f5781w)).intValue() == 0;
            } catch (Exception e4) {
                z1.b(f6096a, Log.getStackTraceString(e4));
            }
        } else {
            z1.b(f6096a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f6104a;

        public d(ShopHelperService shopHelperService) {
            this.f6104a = shopHelperService;
        }

        @Override // com.acse.ottn.l0.d
        @RequiresApi(api = 16)
        public void a(long j4) {
            AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a((AccessibilityService) this.f6104a, "\u5141\u8bb8", true);
            if (a4 != null) {
                TimerTask timerTask = o2.f6097b;
                if (timerTask != null) {
                    timerTask.cancel();
                    o2.f6097b = null;
                }
                com.acse.ottn.b.d().g(a4);
                j0.b(true);
                com.acse.ottn.b.d().e(this.f6104a);
                com.acse.ottn.b.d().e(this.f6104a);
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask timerTask = o2.f6097b;
            if (timerTask != null) {
                timerTask.cancel();
                o2.f6097b = null;
            }
            j0.b(true);
            com.acse.ottn.b.d().e(this.f6104a);
            com.acse.ottn.b.d().e(this.f6104a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f6099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6100b;

        public a(ShopHelperService shopHelperService, String str) {
            this.f6099a = shopHelperService;
            this.f6100b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6099a, this.f6100b);
                if (g4 == null) {
                    o2.f(this.f6099a);
                    if (o2.f6098c == null) {
                        return;
                    }
                    com.acse.ottn.b.d().b(o2.f6098c);
                    return;
                }
                TimerTask timerTask = o2.f6097b;
                if (timerTask != null) {
                    timerTask.cancel();
                    o2.f6097b = null;
                }
                z1.a(o2.f6096a, "\u627e\u5230\u4e86");
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().e(this.f6099a);
            } catch (Exception e4) {
                z1.a(o2.f6096a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            o2.f6097b = null;
            z1.a(o2.f6096a, "\u7ed3\u675f\u4e86");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f6101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6102b;

        public b(ShopHelperService shopHelperService, String str) {
            this.f6101a = shopHelperService;
            this.f6102b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6101a, this.f6102b);
                if (g4 == null) {
                    o2.f(this.f6101a);
                    if (o2.f6098c == null) {
                        return;
                    }
                    com.acse.ottn.b.d().b(o2.f6098c);
                    return;
                }
                TimerTask timerTask = o2.f6097b;
                if (timerTask != null) {
                    timerTask.cancel();
                    o2.f6097b = null;
                }
                z1.a(o2.f6096a, "\u627e\u5230\u4e86");
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().e(this.f6101a);
            } catch (Exception e4) {
                z1.a(o2.f6096a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            o2.f6097b = null;
            z1.a(o2.f6096a, "\u7ed3\u675f\u4e86");
        }
    }

    public static void a(Activity activity, int i4) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void a(Activity activity) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra("packageName", j0.f5781w);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", j0.f5781w, null));
                activity.startActivityForResult(intent2, 10013);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", j0.f5781w);
            intent.putExtra("app_name", h1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10013);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f6103a;

        public c(ShopHelperService shopHelperService) {
            this.f6103a = shopHelperService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6103a, "\u5141\u8bb8\u5b8c\u5168\u540e\u53f0\u884c\u4e3a");
            AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(this.f6103a, "\u5141\u8bb8\u540e\u53f0\u8fd0\u884c");
            AccessibilityNodeInfo g6 = com.acse.ottn.b.d().g(this.f6103a, "\u5141\u8bb8\u5e94\u7528\u81ea\u542f\u52a8");
            if (g6 != null && g6.getParent() != null) {
                TimerTask timerTask = o2.f6097b;
                if (timerTask != null) {
                    timerTask.cancel();
                    o2.f6097b = null;
                }
                for (int i4 = 0; i4 < g6.getParent().getChildCount(); i4++) {
                    if (g6.getParent().getChild(i4) != null && "android.widget.Switch".equals(g6.getParent().getChild(i4).getClassName()) && !g6.getParent().getChild(i4).isChecked()) {
                        com.acse.ottn.b.d().g(g6);
                    }
                }
            }
            if (g4 == null || g4.getParent() == null) {
                if (g5 != null) {
                    TimerTask timerTask2 = o2.f6097b;
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                        o2.f6097b = null;
                    }
                    com.acse.ottn.b.d().g(g5);
                    o2.c(this.f6103a);
                    return;
                }
                return;
            }
            TimerTask timerTask3 = o2.f6097b;
            if (timerTask3 != null) {
                timerTask3.cancel();
                o2.f6097b = null;
            }
            for (int i5 = 0; i5 < g4.getParent().getChildCount(); i5++) {
                if ("android.widget.Switch".equals(g4.getParent().getChild(i5).getClassName()) && !g4.getParent().getChild(i5).isChecked()) {
                    com.acse.ottn.b.d().g(g4);
                }
            }
            o2.c(this.f6103a);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask timerTask = o2.f6097b;
            if (timerTask != null) {
                timerTask.cancel();
                o2.f6097b = null;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if ("android.support.v7.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f6098c = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }
}
