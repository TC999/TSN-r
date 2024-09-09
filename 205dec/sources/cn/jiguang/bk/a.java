package cn.jiguang.bk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2690a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2691b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f2692c;

    /* renamed from: d  reason: collision with root package name */
    private static Pair<String, Long> f2693d;

    /* renamed from: e  reason: collision with root package name */
    private static final ArrayList<String> f2694e;

    /* renamed from: f  reason: collision with root package name */
    private static final ArrayList<String> f2695f;

    /* renamed from: g  reason: collision with root package name */
    private static final ArrayList<String> f2696g;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f2694e = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        f2695f = arrayList2;
        ArrayList<String> arrayList3 = new ArrayList<>();
        f2696g = arrayList3;
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList3.add("com.huawei.android.launcher.permission.CHANGE_BADGE");
        arrayList3.add("com.vivo.notification.permission.BADGE_ICON");
        arrayList3.add("com.hihonor.android.launcher.permission.CHANGE_BADGE");
        arrayList2.add("android.permission.CHANGE_WIFI_STATE");
        arrayList2.add("android.permission.VIBRATE");
        arrayList2.add("android.permission.WAKE_LOCK");
        arrayList2.add("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : b(packageInfo);
    }

    public static String a(Context context) {
        try {
            if (f2692c == null && !TextUtils.isEmpty(JConstants.APP_KEY)) {
                return JConstants.APP_KEY;
            }
        } catch (Throwable unused) {
            f2692c = Boolean.FALSE;
        }
        b(context);
        return f2690a;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static void a(Context context, String str) {
        f2691b = str;
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.J().a((cn.jiguang.g.a<String>) str));
        c(context);
    }

    private static long b(PackageInfo packageInfo) {
        return packageInfo.versionCode;
    }

    public static String b(Context context) {
        String str;
        Bundle bundle;
        if (TextUtils.isEmpty(f2690a)) {
            if (TextUtils.isEmpty(f2690a)) {
                try {
                    if (context != null) {
                        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                            str = "";
                        } else {
                            str = a(bundle, "JPUSH_APPKEY");
                            if (!TextUtils.isEmpty(str)) {
                                str = str.toLowerCase(Locale.getDefault());
                            }
                        }
                        if (!TextUtils.isEmpty("") && !TextUtils.isEmpty(str)) {
                            String lowerCase = "".toLowerCase(Locale.getDefault());
                            if (!lowerCase.contains(str)) {
                                cn.jiguang.bq.d.d("CheckManifestHelper", "[key-step]appkey " + str + " not in limitAppkeys:" + lowerCase);
                                cn.jiguang.bq.d.l("CheckManifestHelper", "[key-step]You use the customized sdk, but your appkey not in valid appkey list. If you want to enable it, please contact us.");
                            }
                        }
                        f2690a = str;
                    } else {
                        cn.jiguang.bq.d.c("CheckManifestHelper", "[getAppKey] context is null");
                    }
                } catch (Throwable unused) {
                }
            }
            return f2690a;
        }
        return f2690a;
    }

    public static String c(Context context) {
        StringBuilder sb;
        Bundle bundle;
        if (f2691b == null && context != null) {
            try {
                String c4 = cn.jiguang.d.a.c(context);
                f2691b = c4;
                if (c4 != null) {
                    sb = new StringBuilder();
                    sb.append("get option channel - ");
                    sb.append(f2691b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a4 = a(bundle, "JPUSH_CHANNEL");
                        f2691b = a4;
                        if (!TextUtils.isEmpty(a4)) {
                            f2691b = cn.jiguang.f.g.b(f2691b);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("manifest:channel - ");
                    sb.append(f2691b);
                }
                cn.jiguang.bq.d.d("CheckManifestHelper", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f2691b;
    }

    public static Pair<String, Long> d(Context context) {
        if (f2693d == null) {
            try {
                PackageInfo a4 = cn.jiguang.f.a.a(context, 0);
                if (a4 != null) {
                    String str = a4.versionName;
                    byte[] bytes = str.getBytes("UTF-8");
                    if (bytes.length > 30) {
                        str = new String(bytes, 0, 30);
                    }
                    f2693d = new Pair<>(str, Long.valueOf(a(a4)));
                } else {
                    cn.jiguang.bq.d.d("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
                }
            } catch (Throwable unused) {
                cn.jiguang.bq.d.d("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
            }
        }
        return f2693d;
    }

    public static int e(Context context) {
        String a4 = a(context);
        if (TextUtils.isEmpty(a4)) {
            cn.jiguang.bq.d.n("CheckManifestHelper", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
            cn.jiguang.f.a.a(context, " \u672a\u5728manifest\u4e2d\u914d\u7f6eAppKey", -1);
            return 10001;
        } else if (a4.length() != 24) {
            cn.jiguang.bq.d.n("CheckManifestHelper", "errorcode:1008,Invalid appKey : " + a4 + ", Please get your Appkey from JIGUANG web console!");
            cn.jiguang.f.a.a(context, " AppKey:" + a4 + " \u662f\u65e0\u6548\u7684AppKey,\u8bf7\u786e\u8ba4\u4e0eJIGUANG web\u7aef\u7684AppKey\u4e00\u81f4", -1);
            return 1008;
        } else {
            return 0;
        }
    }

    public static int f(Context context) {
        c(context);
        if (c.a().e() || c.a().d() || c.a().f()) {
            String str = context.getPackageName() + cn.jiguang.a.a.f2009a;
            if (!cn.jiguang.f.a.g(context, str)) {
                cn.jiguang.bq.d.m("CheckManifestHelper", "The permission should be defined - " + str);
                return 1001;
            }
            f2694e.add(str);
        }
        Iterator<String> it = f2694e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!cn.jiguang.f.a.c(context, next)) {
                cn.jiguang.bq.d.m("CheckManifestHelper", "The permissoin is required - " + next);
                return 1002;
            }
        }
        Iterator<String> it2 = f2695f.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!cn.jiguang.f.a.g(context, next2)) {
                cn.jiguang.bq.d.i("CheckManifestHelper", "We recommend you add the permission - " + next2);
            }
        }
        Iterator<String> it3 = f2696g.iterator();
        while (it3.hasNext()) {
            String next3 = it3.next();
            if (!cn.jiguang.f.a.g(context, next3)) {
                cn.jiguang.bq.d.k("CheckManifestHelper", "We recommend you add the permission - " + next3 + ",Otherwise set badge number will failed");
            }
        }
        cn.jiguang.bl.a.a(context, "checkManifestLocInfo", null, null);
        return 0;
    }
}
