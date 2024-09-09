package cn.jiguang.af;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import cn.jpush.android.api.JPushInterface;
import com.stub.StubApp;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<String> f2116a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f2117b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2118c;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f2116a = arrayList;
        arrayList.add(cn.jiguang.ao.c.b(new byte[]{122, 103, 123, 63, 67, 79, 113, 125, 56, Byte.MAX_VALUE, 85, 87, 106, 107, 122, 120, 85, 78, 109}));
        f2118c = "Xiaomi".toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cn.jiguang.ad.c a(Context context, PackageManager packageManager, String str, String str2) {
        StringBuilder sb;
        String message;
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                int checkPermission = packageManager.checkPermission(str + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String b4 = cn.jiguang.ah.d.b(context);
                    Intent intent = new Intent();
                    intent.setClassName(str, "cn.jpush.android.service.PushService");
                    boolean z3 = packageManager.resolveService(intent, 0) != null;
                    if (checkPermission == 0 && z3 && !TextUtils.isEmpty(b4) && b4.length() == 24) {
                        cn.jiguang.ad.c cVar = new cn.jiguang.ad.c(str, str2, applicationInfo.targetSdkVersion);
                        cVar.f2097d = str + ".DownloadProvider";
                        return cVar;
                    }
                }
            } catch (PackageManager.NameNotFoundException e4) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart exception:");
                message = e4.toString();
                sb.append(message);
                cn.jiguang.w.a.f("JComponentHelper", sb.toString());
                return null;
            } catch (Throwable th) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.w.a.f("JComponentHelper", sb.toString());
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, boolean z3) {
        try {
            a(context, z3, "cn.jpush.android.intent.DaemonService", Class.forName("cn.jpush.android.service.DaemonService", false, context.getClassLoader()));
            b(context, z3, Class.forName("cn.jpush.android.service.DownloadProvider", false, context.getClassLoader()));
            a(context, z3, Class.forName("cn.jpush.android.service.DActivity", false, context.getClassLoader()));
            a(context, z3, Class.forName("cn.jpush.android.service.BActivity", false, context.getClassLoader()));
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JComponentHelper", "setComponentEnable failed, " + th.getMessage());
        }
    }

    private static void a(Context context, boolean z3, Class cls) {
        try {
            if (context == null) {
                cn.jiguang.w.a.g("JComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            if (packageManager == null) {
                cn.jiguang.w.a.g("JComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i4 = z3 ? 1 : 2;
            ComponentName componentName = new ComponentName(context, cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i4) {
                cn.jiguang.w.a.b("JComponentHelper", componentName.getClassName() + " enabled is :" + z3 + ", no need repeat set.");
                return;
            }
            cn.jiguang.w.a.b("JComponentHelper", componentName + " setActivityEnabledSetting newState: " + i4);
            packageManager.setComponentEnabledSetting(componentName, i4, 1);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JComponentHelper", "setActivityEnabled throwable:" + th.getMessage());
        }
    }

    private static void a(Context context, boolean z3, String str, Class cls) {
        String str2;
        try {
            if (context == null) {
                cn.jiguang.w.a.g("JComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            if (packageManager == null) {
                cn.jiguang.w.a.g("JComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            String packageName = context.getPackageName();
            int i4 = z3 ? 1 : 2;
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(str);
            ResolveInfo resolveService = packageManager.resolveService(intent, 512);
            if (resolveService != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (serviceInfo == null) {
                    return;
                }
                String str3 = serviceInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                try {
                    if (!cls.isAssignableFrom(Class.forName(str3))) {
                        cn.jiguang.w.a.g("JComponentHelper", "give up setting, as " + str3 + " is not extend from: " + cls.getName());
                        return;
                    }
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    cn.jiguang.w.a.b("JComponentHelper", componentName + " setComponentEnabledSetting newState: " + i4);
                    if (packageManager.getComponentEnabledSetting(componentName) != i4) {
                        packageManager.setComponentEnabledSetting(componentName, i4, 1);
                        return;
                    }
                    cn.jiguang.w.a.b("JComponentHelper", "DaemonService  enabled is :" + z3 + ", no need repeat set.");
                    return;
                } catch (ClassNotFoundException unused) {
                    str2 = "cant't find service class:" + str3;
                }
            } else {
                str2 = "cant't find DaemonService";
            }
            cn.jiguang.w.a.f("JComponentHelper", str2);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JComponentHelper", "setServiceEnabled throwable:" + th.getMessage());
        }
    }

    public static boolean a(Context context) {
        Boolean bool = f2117b;
        if (bool != null) {
            return bool.booleanValue();
        }
        f2117b = b(context) ? Boolean.TRUE : Boolean.FALSE;
        return f2117b.booleanValue();
    }

    public static boolean a(Context context, String str, Intent intent, boolean z3) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            intent.setPackage(str);
            if (!z3) {
                intent.setAction("cn.jpush.android.intent.DActivity");
                intent.addCategory(str);
            }
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            if (resolveActivity == null) {
                cn.jiguang.w.a.f("JComponentHelper", "getDActivity resolveInfo was null from:" + intent);
                return false;
            }
            cn.jiguang.w.a.b("JComponentHelper", "target actvity name:" + resolveActivity.activityInfo.name + ", theme:" + resolveActivity.activityInfo.theme + ", exported:" + resolveActivity.activityInfo.exported + ", enable: " + resolveActivity.activityInfo.enabled);
            if (resolveActivity.activityInfo.exported && (!a(str) || resolveActivity.activityInfo.enabled)) {
                if (resolveActivity.activityInfo.theme != 16973840) {
                    cn.jiguang.w.a.f("JComponentHelper", resolveActivity.activityInfo.name + "activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                    return false;
                }
                cn.jiguang.w.a.b("JComponentHelper", "dIntent:" + intent);
                return true;
            }
            cn.jiguang.w.a.f("JComponentHelper", "activity muse be exported and enabled");
            return false;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JComponentHelper", "get deeplink activity error#" + th);
            return false;
        }
    }

    private static boolean a(String str) {
        boolean contains = f2116a.contains(str);
        StringBuilder sb = new StringBuilder();
        sb.append("package[");
        sb.append(str);
        sb.append("] need check activity enable state, ");
        sb.append(!contains);
        cn.jiguang.w.a.e("JComponentHelper", sb.toString());
        return !contains;
    }

    private static void b(Context context, boolean z3, Class cls) {
        try {
            if (context == null) {
                cn.jiguang.w.a.g("JComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            if (packageManager == null) {
                cn.jiguang.w.a.g("JComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i4 = z3 ? 1 : 2;
            ComponentName componentName = new ComponentName(context, cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i4) {
                cn.jiguang.w.a.b("JComponentHelper", componentName.getClassName() + " enabled is :" + z3 + ", no need repeat set.");
                return;
            }
            cn.jiguang.w.a.b("JComponentHelper", componentName + " setDownloadProviderEnabledSetting newState: " + i4);
            packageManager.setComponentEnabledSetting(componentName, i4, 1);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JComponentHelper", "setContentProviderEnabled throwable:" + th.getMessage());
        }
    }

    private static boolean b(Context context) {
        try {
            String str = a.C0049a.f2213b;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(f2118c, str.toLowerCase());
        } catch (Throwable th) {
            cn.jiguang.w.a.g("JComponentHelper", "get MANUFACTURER failed - error:" + th);
            return false;
        }
    }
}
