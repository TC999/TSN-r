package cn.jiguang.e;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.bq.d;
import cn.jiguang.bx.e;
import cn.jiguang.bx.h;
import cn.jiguang.bx.j;
import cn.jiguang.cm.b;
import cn.jiguang.cn.g;
import cn.jiguang.f.c;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.DownloadProvider;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.stub.StubApp;
import java.io.File;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3597b;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f3598f;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f3599g;

    /* renamed from: i  reason: collision with root package name */
    private static Boolean f3600i;

    /* renamed from: k  reason: collision with root package name */
    private static a f3601k;

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f3602l;

    /* renamed from: a  reason: collision with root package name */
    Context f3603a;

    /* renamed from: c  reason: collision with root package name */
    private int f3604c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f3605d;

    /* renamed from: e  reason: collision with root package name */
    private String f3606e;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f3607j;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3608m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.jiguang.e.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0062a {

        /* renamed from: b  reason: collision with root package name */
        private int f3610b = -1;

        /* renamed from: c  reason: collision with root package name */
        private String f3611c;

        /* renamed from: d  reason: collision with root package name */
        private long f3612d;

        /* renamed from: e  reason: collision with root package name */
        private String f3613e;

        /* renamed from: f  reason: collision with root package name */
        private String f3614f;

        /* renamed from: g  reason: collision with root package name */
        private int f3615g;

        /* renamed from: h  reason: collision with root package name */
        private long f3616h;

        /* renamed from: i  reason: collision with root package name */
        private String f3617i;

        C0062a() {
        }

        public String toString() {
            return "ShareProcessBean{idc=" + this.f3610b + ", uuid='" + this.f3611c + "', uid=" + this.f3612d + ", pkgname='" + this.f3613e + "', appkey='" + this.f3614f + "', sdkVersion=" + this.f3615g + ", uuidCreateTime=" + this.f3616h + ", deviceId=" + this.f3617i + '}';
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(".jpush");
        String str = File.separator;
        sb.append(str);
        sb.append(".shareinfo");
        sb.append(str);
        f3597b = sb.toString();
        f3598f = new Object();
        f3602l = new byte[]{104, 125, 115, 99, 73, 105, 119, 124, 115, Byte.MAX_VALUE, 68, 115, 124, 122, 96, 120, 83, 69, 106};
    }

    private a() {
        cn.jiguang.bt.b.a("share_process_executor");
        this.f3462h = "ShareProcessManager";
    }

    private static ActivityInfo a(String str, Context context) {
        String str2;
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DownloadActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
            if ((activityInfo instanceof ActivityInfo) && ((ComponentInfo) activityInfo).exported && ((ComponentInfo) activityInfo).enabled) {
                if (!"jpush.custom".equals(activityInfo.taskAffinity)) {
                    str2 = "download activity need config taskAffinity is jpush.custom";
                } else if (activityInfo.theme == 16973840) {
                    return activityInfo;
                } else {
                    str2 = "download activity theme must config as @android:style/Theme.Translucent.NoTitleBar";
                }
                d.c("ShareProcessManager", str2);
            }
        } catch (Throwable th) {
            d.i("ShareProcessManager", "check downloadActivity error:" + th.getMessage());
        }
        d.c("ShareProcessManager", "DownloadActivity is invalid in " + str);
        return null;
    }

    private C0062a a(String str) {
        Throwable th;
        C0062a c0062a;
        try {
        } catch (Throwable th2) {
            th = th2;
            c0062a = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        c0062a = new C0062a();
        try {
            long optLong = jSONObject.optLong("u");
            String optString = jSONObject.optString("ak");
            String optString2 = jSONObject.optString("pn");
            String optString3 = jSONObject.optString("ud");
            int optInt = jSONObject.optInt("idc", -1);
            int optInt2 = jSONObject.optInt("sv");
            long optLong2 = jSONObject.optLong("uct", -1L);
            String optString4 = jSONObject.optString("di");
            c0062a.f3612d = optLong;
            c0062a.f3611c = optString3;
            c0062a.f3614f = optString;
            c0062a.f3610b = optInt;
            c0062a.f3613e = optString2;
            c0062a.f3615g = optInt2;
            c0062a.f3616h = optLong2;
            c0062a.f3617i = optString4;
        } catch (Throwable th3) {
            th = th3;
            d.i("ShareProcessManager", "parse json to shareBean failed:" + th.getMessage());
            return c0062a;
        }
        return c0062a;
    }

    public static String a(Context context, Uri uri) {
        try {
        } catch (Throwable th) {
            d.i("ShareProcessManager", "parseUriFromProvider failed:" + th.getMessage());
        }
        if (uri == null) {
            return cn.jiguang.a.a.f2010b;
        }
        String queryParameter = uri.getQueryParameter("kpgt");
        if (TextUtils.isEmpty(queryParameter)) {
            return cn.jiguang.a.a.f2010b;
        }
        String b4 = g.b(queryParameter, cn.jiguang.a.a.f2017i);
        if (TextUtils.isEmpty(b4)) {
            return "-6";
        }
        JSONObject jSONObject = new JSONObject(b4);
        String optString = jSONObject.optString("kta");
        d.c("ShareProcessManager", "action:" + optString);
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("asai")) {
                return e(context);
            }
            if (optString.equals("asm")) {
                d.c("ShareProcessManager", "recv msg:" + jSONObject.toString());
                if (g(context) && ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.I())).intValue() != 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("data", jSONObject.toString());
                    cn.jiguang.c.b.a(context, JConstants.SDK_TYPE, "asm", bundle);
                    return "0";
                }
                d.c("ShareProcessManager", "share process is closed!");
                return "-4";
            } else if (optString.equals("asmr")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("data", jSONObject.toString());
                cn.jiguang.c.b.a(context, JConstants.SDK_TYPE, "asmr", bundle2);
            }
        }
        return cn.jiguang.a.a.f2010b;
    }

    private String a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        try {
            ContentResolver contentResolver = StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver();
            String str3 = str + ".DownloadProvider";
            if (!str3.startsWith("content://")) {
                str3 = "content://" + str3;
            }
            Uri parse = Uri.parse(str3);
            JSONObject jSONObject = new JSONObject();
            Uri.Builder buildUpon = parse.buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("kta", str2);
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            buildUpon.appendQueryParameter("kpgt", g.a(jSONObject.toString(), cn.jiguang.a.a.f2017i));
            return contentResolver.getType(buildUpon.build());
        } catch (Throwable th) {
            d.i("ShareProcessManager", "callUriToDownloadProvider error:" + th.getMessage());
            return null;
        }
    }

    private static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                d.i("ShareProcessManager", "mapToJSONObject error:" + th.getMessage());
            }
        }
        return jSONObject;
    }

    public static void a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            d.i("ShareProcessManager", "deletFileIfUninstall failed ,context is null or pkgname is empty");
            return;
        }
        try {
            if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File d4 = d(context, str);
                if (d4.exists()) {
                    d4.delete();
                    return;
                }
                str2 = "not found file in sdcard,filepath:" + d4.getAbsolutePath();
            } else {
                str2 = "no write sdcard permission when deletFileIfUninstall";
            }
            d.c("ShareProcessManager", str2);
        } catch (Throwable unused) {
        }
    }

    private boolean a(String str, ComponentInfo componentInfo) {
        if (componentInfo == null || !(componentInfo instanceof ProviderInfo)) {
            return false;
        }
        ProviderInfo providerInfo = (ProviderInfo) componentInfo;
        d.a("ShareProcessManager", "scan exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
        if (providerInfo.exported && providerInfo.enabled && !TextUtils.isEmpty(providerInfo.authority)) {
            if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                return true;
            }
        }
        d.c("ShareProcessManager", "downloadprovider config error,exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
        return false;
    }

    private C0062a b(Context context, String str) {
        C0062a c4;
        try {
            String a4 = a(context, str, "asai", null);
            d.c("ShareProcessManager", "get type from:" + str + ",info:" + a4);
            if (a4 != null) {
                if (TextUtils.isEmpty(a4) || a4.length() <= 10) {
                    d.c("ShareProcessManager", "is not shareprocessbean info");
                    return null;
                }
                String b4 = g.b(a4, cn.jiguang.a.a.f2017i);
                if (TextUtils.isEmpty(b4)) {
                    d.c("ShareProcessManager", "decrypt error");
                    return null;
                }
                d.c("ShareProcessManager", "parse success:" + b4);
                c4 = a(b4);
            } else if (!f(context)) {
                return null;
            } else {
                c4 = c(context, str);
            }
            return c4;
        } catch (Throwable th) {
            d.j("ShareProcessManager", "scanShareProcessBean error:" + th.getMessage());
            return null;
        }
    }

    public static a b() {
        if (f3601k == null) {
            synchronized (f3598f) {
                if (f3601k == null) {
                    f3601k = new a();
                }
            }
        }
        return f3601k;
    }

    private C0062a c(Context context, String str) {
        String str2;
        StringBuilder sb;
        String str3;
        if (JConstants.isAndroidQ(context, false, "do not get share info from SD")) {
            return null;
        }
        if (cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            File d4 = d(context, str);
            String d5 = c.d(d4);
            if (TextUtils.isEmpty(d5)) {
                d.c("ShareProcessManager", "read info is empty from :" + d4.getAbsolutePath());
                return null;
            }
            C0062a a4 = a(g.b(d5, cn.jiguang.a.a.f2017i));
            if (a4 == null) {
                sb = new StringBuilder();
                str3 = "parse share process bean with target app:";
            } else if (!cn.jiguang.f.a.f(context, a4.f3613e)) {
                d.c("ShareProcessManager", "found target app is uninsatll when scan sdcard,pkgname:" + a4.f3613e);
                a(context, a4.f3613e);
                return null;
            } else if (a(a4.f3613e, context) != null) {
                d.c("ShareProcessManager", "get share bean info from sdcard:" + a4.toString());
                return a4;
            } else {
                sb = new StringBuilder();
                str3 = "not config DownloadActivity in target app:";
            }
            sb.append(str3);
            sb.append(str);
            str2 = sb.toString();
        } else {
            str2 = "no read sdcard permission";
        }
        d.c("ShareProcessManager", str2);
        return null;
    }

    private static String c() {
        return "cn.jpush.android.intent.DaemonService";
    }

    private Set<C0062a> c(Context context) {
        int i4;
        List list;
        HashSet hashSet = new HashSet();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(c());
            list = (List) packageManager.getClass().getDeclaredMethod(cn.jiguang.cn.d.b(f3602l), Intent.class, Integer.TYPE).invoke(packageManager, intent, 0);
        } catch (Throwable th) {
            d.i("ShareProcessManager", "scanOtherApp error:" + th.getMessage());
        }
        if (list != null && list.size() != 0) {
            List<String> arrayList = new ArrayList();
            for (i4 = 0; i4 < list.size(); i4++) {
                ServiceInfo serviceInfo = ((ResolveInfo) list.get(i4)).serviceInfo;
                String str = serviceInfo.name;
                String str2 = serviceInfo.packageName;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !context.getPackageName().equals(str2) && a(str2, cn.jiguang.f.a.b(context, str2, DownloadProvider.class))) {
                    arrayList.add(str2);
                }
            }
            d.c("ShareProcessManager", "valid size:" + arrayList.size());
            Object a4 = e.a(context, "filter_pkg_list", arrayList);
            if (a4 instanceof List) {
                arrayList = (List) a4;
            }
            d.c("ShareProcessManager", "valid end size:" + arrayList.size());
            for (String str3 : arrayList) {
                C0062a b4 = b(context, str3);
                d.c("ShareProcessManager", "scan share bean from:" + str3);
                if (b4 != null) {
                    hashSet.add(b4);
                }
            }
            d.c("ShareProcessManager", "end share bean list size:" + hashSet.size());
            return hashSet;
        }
        d.c("ShareProcessManager", "query service size is empty");
        return hashSet;
    }

    private static File d(Context context, String str) {
        String d4 = cn.jiguang.f.g.d(str);
        if (!TextUtils.isEmpty(d4)) {
            str = d4;
        }
        String i4 = cn.jiguang.f.a.i(context);
        return new File(i4, f3597b + str);
    }

    private void d(Context context) {
        try {
            if (JConstants.isAndroidQ(context, false, "do not save ShareInfo to SD")) {
                return;
            }
            if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File d4 = d(context, context.getPackageName());
                if (f(context)) {
                    String e4 = e(context);
                    d.c("ShareProcessManager", "save info to sdcard:" + d4.getAbsolutePath());
                    if (!TextUtils.isEmpty(e4) && e4.length() > 10) {
                        c.a(d4);
                        c.c(d4, e4);
                    }
                } else {
                    c.a(d4);
                }
            } else {
                d.c("ShareProcessManager", "no write sdcard permission");
            }
        } catch (Throwable th) {
            d.i("ShareProcessManager", "saveShareInfoToSdCard failed:" + th.getMessage());
        }
    }

    private static String e(Context context) {
        long j4;
        String str;
        if (context == null) {
            return "-1";
        }
        if (!g(context) || cn.jiguang.d.a.m(context) != 0) {
            d.c("ShareProcessManager", "[getTypeJson]share process is close by action");
            return "-4";
        } else if (!cn.jiguang.bk.c.a().a(context)) {
            d.c("ShareProcessManager", "getAttachJson,is not support jpush or jmessage ");
            return "-7";
        } else {
            int k4 = cn.jiguang.d.a.k(context);
            if (k4 < 0) {
                d.c("ShareProcessManager", "[getTypeJson]idc<0,need login to get it");
                return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
            }
            long f4 = cn.jiguang.d.a.f(context);
            if (f4 <= 0) {
                d.c("ShareProcessManager", "[getTypeJson]uid<=0,need login to get it");
                return NetworkPlatformConst.AD_NETWORK_NO_DATA;
            }
            Map map = (Map) cn.jiguang.d.a.j(context);
            if (map != null) {
                str = (String) map.get("uuid");
                j4 = ((Long) map.get("ct")).longValue();
            } else {
                j4 = -1;
                str = "";
            }
            String e4 = cn.jiguang.d.a.e(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("u", f4);
                jSONObject.put("p", cn.jiguang.d.a.i(context));
                jSONObject.put("ud", str);
                jSONObject.put("ak", e4);
                jSONObject.put("idc", k4);
                jSONObject.put("pn", context.getPackageName());
                jSONObject.put("sv", cn.jiguang.a.a.f2011c);
                jSONObject.put("uct", j4);
                jSONObject.put("di", cn.jiguang.cn.c.a(context));
                return g.a(jSONObject.toString(), cn.jiguang.a.a.f2017i);
            } catch (JSONException unused) {
                d.c("ShareProcessManager", "[getTypeJson] to json error");
                return cn.jiguang.a.a.f2010b;
            }
        }
    }

    private static boolean f(Context context) {
        Boolean bool = f3600i;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            String p3 = cn.jiguang.f.a.p(context);
            String lowerCase = "Xiaomi".toLowerCase();
            if (!TextUtils.isEmpty(p3) && TextUtils.equals(lowerCase, p3.toLowerCase())) {
                d.c("ShareProcessManager", "xiaomi not use activity and sdcard");
                Boolean bool2 = Boolean.FALSE;
                f3600i = bool2;
                return bool2.booleanValue();
            }
        } catch (Throwable th) {
            d.i("ShareProcessManager", "get MANUFACTURER failed - error:" + th.getMessage());
        }
        f3600i = a(context.getPackageName(), context) != null ? Boolean.TRUE : Boolean.FALSE;
        return f3600i.booleanValue();
    }

    private static boolean g(Context context) {
        Boolean bool = f3599g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            d.i("ShareProcessManager", "context is null");
            return true;
        }
        try {
            ProviderInfo b4 = cn.jiguang.f.a.b(context, context.getPackageName(), DownloadProvider.class);
            if (b4 == null) {
                d.c("ShareProcessManager", "not found download provider in manifest");
                Boolean bool2 = Boolean.FALSE;
                f3599g = bool2;
                return bool2.booleanValue();
            }
            if (((ComponentInfo) b4).enabled && ((ComponentInfo) b4).exported && !TextUtils.isEmpty(b4.authority)) {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jiguang.android.share.close");
                Boolean valueOf = Boolean.valueOf(context.getPackageManager().resolveService(intent, 0) == null);
                f3599g = valueOf;
                return valueOf.booleanValue();
            }
            d.c("ShareProcessManager", "download provider config error,enable" + ((ComponentInfo) b4).enabled + ",exported:" + ((ComponentInfo) b4).exported + ",authority:" + b4.authority);
            Boolean bool3 = Boolean.FALSE;
            f3599g = bool3;
            return bool3.booleanValue();
        } catch (Throwable th) {
            d.c("ShareProcessManager", "Get isShareProcessModeOpen error#:" + th.getMessage());
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8 A[Catch: all -> 0x02b9, TryCatch #1 {all -> 0x02b9, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0027, B:14:0x008f, B:16:0x0097, B:19:0x009f, B:20:0x00c2, B:22:0x00c8, B:24:0x00d4, B:26:0x00dc, B:29:0x00ed, B:30:0x00f1, B:32:0x00f7, B:36:0x0104, B:38:0x0118, B:57:0x0217, B:62:0x022f, B:63:0x0234, B:72:0x026c, B:66:0x0240, B:70:0x0264, B:67:0x024e, B:69:0x0256, B:71:0x0267, B:75:0x02af, B:13:0x0056), top: B:88:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f7 A[Catch: all -> 0x02b9, TRY_LEAVE, TryCatch #1 {all -> 0x02b9, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0027, B:14:0x008f, B:16:0x0097, B:19:0x009f, B:20:0x00c2, B:22:0x00c8, B:24:0x00d4, B:26:0x00dc, B:29:0x00ed, B:30:0x00f1, B:32:0x00f7, B:36:0x0104, B:38:0x0118, B:57:0x0217, B:62:0x022f, B:63:0x0234, B:72:0x026c, B:66:0x0240, B:70:0x0264, B:67:0x024e, B:69:0x0256, B:71:0x0267, B:75:0x02af, B:13:0x0056), top: B:88:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104 A[Catch: all -> 0x02b9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x02b9, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0027, B:14:0x008f, B:16:0x0097, B:19:0x009f, B:20:0x00c2, B:22:0x00c8, B:24:0x00d4, B:26:0x00dc, B:29:0x00ed, B:30:0x00f1, B:32:0x00f7, B:36:0x0104, B:38:0x0118, B:57:0x0217, B:62:0x022f, B:63:0x0234, B:72:0x026c, B:66:0x0240, B:70:0x0264, B:67:0x024e, B:69:0x0256, B:71:0x0267, B:75:0x02af, B:13:0x0056), top: B:88:0x0005 }] */
    @Override // cn.jiguang.cm.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.a():void");
    }

    public synchronized void a(Context context) {
        if (g(context) && cn.jiguang.bt.b.c(context) == 0) {
            if (!cn.jiguang.bk.c.a().a(context)) {
                d.c("ShareProcessManager", "is not support jpush or jmessage ");
                return;
            }
            Object a4 = e.a(context, "getwakeenable", null);
            if ((a4 instanceof Boolean) && !((Boolean) a4).booleanValue()) {
                d.c("ShareProcessManager", "wake disable,not scan share app");
                return;
            } else if (this.f3607j) {
                d.c("ShareProcessManager", "isAttaching");
                return;
            } else {
                this.f3603a = context;
                this.f3607j = true;
                d.c("ShareProcessManager", "scanOtherApp...");
                this.f3604c = 0;
                cn.jiguang.bt.b.b(this, new int[0]);
                return;
            }
        }
        d.c("ShareProcessManager", "share process is close by action");
        a(context, context.getPackageName());
    }

    public void a(Context context, int i4) {
        d.c("ShareProcessManager", "requestTimeOut,cmd:" + i4 + ",isAttaching:" + this.f3607j);
        if (i4 != 30 || this.f3607j) {
            return;
        }
        this.f3604c++;
        d.c("ShareProcessManager", "attachTimeoutTimes:" + this.f3604c + ",requestUIDS:" + this.f3605d + ",shareProcessUUID:" + this.f3606e);
        if (this.f3604c > 2) {
            d.c("ShareProcessManager", "attach too many times by once scan");
            return;
        }
        long[] jArr = this.f3605d;
        if (jArr == null || jArr.length <= 0 || TextUtils.isEmpty(this.f3606e)) {
            return;
        }
        d.c("ShareProcessManager", "will retry attach");
        cn.jiguang.bt.b.a(context, JConstants.SDK_TYPE, 30, 0, j.b(), 0L, cn.jiguang.bz.b.a(cn.jiguang.d.a.f(context), this.f3606e, this.f3605d));
    }

    public void a(Context context, int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("request");
        sb.append(i4 == 0 ? "success" : "failed");
        sb.append(",cmd:");
        sb.append(i5);
        sb.append(",code:");
        sb.append(i4);
        d.c("ShareProcessManager", sb.toString());
        if (i5 == 30 && i4 == 0) {
            this.f3604c = 0;
        }
    }

    public void a(Context context, long j4) {
        try {
            if (TextUtils.isEmpty(this.f3606e)) {
                d.c("ShareProcessManager", "dettachUid error,shareUUID is empty");
                return;
            }
            d.c("ShareProcessManager", "dettach uid:" + j4);
            cn.jiguang.bt.b.a(context, JConstants.SDK_TYPE, 32, 0, j.b(), 0L, cn.jiguang.bz.b.a(this.f3606e, new long[]{j4}));
        } catch (Throwable th) {
            d.c("ShareProcessManager", "dettach uid error:" + th.getMessage());
        }
    }

    public void a(Context context, long j4, byte[] bArr) {
        String str;
        long j5;
        if (j4 == 0 || bArr == null) {
            return;
        }
        try {
            Pair<cn.jiguang.bz.c, ByteBuffer> a4 = cn.jiguang.bz.a.a(context, bArr, "");
            if (a4 != null && ((cn.jiguang.bz.c) a4.first).f3170c == 3) {
                ByteBuffer byteBuffer = (ByteBuffer) a4.second;
                byteBuffer.get();
                long j6 = byteBuffer.getLong();
                String a5 = cn.jiguang.bz.b.a(byteBuffer);
                if (TextUtils.isEmpty(a5)) {
                    d.i("ShareProcessManager", "msgContent is empty");
                    return;
                }
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(a5));
                String readLine = lineNumberReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    d.l("ShareProcessManager", "appid is empty");
                    return;
                }
                String readLine2 = lineNumberReader.readLine();
                if (TextUtils.isEmpty(readLine2)) {
                    d.l("ShareProcessManager", "senderId is empty");
                    return;
                }
                if (g(context) && cn.jiguang.bt.b.c(context) == 0) {
                    if (!cn.jiguang.f.a.f(context, readLine)) {
                        a(context, ((cn.jiguang.bz.c) a4.first).f3174g);
                        d.c("ShareProcessManager", "app not installed:" + readLine);
                        a(context, readLine);
                        return;
                    }
                    String encodeToString = Base64.encodeToString(bArr, 10);
                    Long valueOf = Long.valueOf(((cn.jiguang.bz.c) a4.first).f3172e);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("ktm", encodeToString);
                    hashMap.put("ktp", g.a(cn.jiguang.d.a.f(context)));
                    hashMap.put("ktma", readLine2);
                    hashMap.put("mtmmi", j6 + "");
                    hashMap.put("ktmfp", context.getPackageName());
                    hashMap.put("ktmr", valueOf + "");
                    d.c("ShareProcessManager", "dispatch share msg,appkey:" + readLine2 + ",msgid:" + j6 + ",rid:" + valueOf);
                    String a6 = a(context, readLine, "asm", hashMap);
                    StringBuilder sb = new StringBuilder();
                    sb.append("dispatch result:");
                    sb.append(a6);
                    d.c("ShareProcessManager", sb.toString());
                    if (TextUtils.isEmpty(a6)) {
                        if (!f(context)) {
                            d.c("ShareProcessManager", "app can not use downloadActivity dispatch msg");
                            j5 = ((cn.jiguang.bz.c) a4.first).f3174g;
                        } else if (!cn.jiguang.bt.b.f2891a && JConstants.isAndroidQ(context, false, "do not startActivity in BackGround")) {
                            this.f3608m = true;
                            a(context, cn.jiguang.d.a.f(context));
                            return;
                        } else {
                            ActivityInfo a7 = a(readLine, context);
                            if (a7 != null) {
                                d.c("ShareProcessManager", "will try use downloadActivity");
                                JSONObject a8 = a(hashMap);
                                Intent intent = new Intent("asm");
                                intent.setComponent(new ComponentName(a7.packageName, a7.name));
                                intent.setFlags(268435456);
                                intent.addCategory(readLine);
                                intent.putExtra("data", a8.toString());
                                context.startActivity(intent);
                            } else {
                                j5 = ((cn.jiguang.bz.c) a4.first).f3174g;
                            }
                        }
                        a(context, j5);
                    } else if (a6.equals("-4")) {
                        j5 = ((cn.jiguang.bz.c) a4.first).f3174g;
                        a(context, j5);
                    } else {
                        if (a6.equals("0")) {
                            str = "wait the msg reponse";
                        } else {
                            str = "provider is :" + a6 + ",app is less than jcore_v125";
                        }
                        d.c("ShareProcessManager", str);
                    }
                    lineNumberReader.close();
                    return;
                }
                a(context, cn.jiguang.d.a.f(context));
                d.c("ShareProcessManager", " share process is close,will not dispatch the msg and dettach mine uid");
                return;
            }
            d.c("ShareProcessManager", "share msg cmd is not 3");
        } catch (Throwable th) {
            d.i("ShareProcessManager", "dispatchMsg error:" + th.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        String str;
        try {
            d.c("ShareProcessManager", "doMsg");
            if (bundle != null) {
                String string = bundle.getString("data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                d.c("ShareProcessManager", "doMsg json:" + jSONObject.toString());
                String optString = jSONObject.optString("ktm");
                String optString2 = jSONObject.optString("ktp");
                String optString3 = jSONObject.optString("mtmmi");
                String optString4 = jSONObject.optString("ktmfp");
                String optString5 = jSONObject.optString("ktma");
                String optString6 = jSONObject.optString("ktmr");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString5)) {
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("mtmmi", optString3);
                hashMap.put("ktmfp", optString4);
                hashMap.put("ktma", optString5);
                hashMap.put("ktmr", optString6);
                Pair<cn.jiguang.bz.c, ByteBuffer> a4 = cn.jiguang.bz.a.a(context, Base64.decode(optString, 10), optString2);
                if (a4 != null) {
                    hashMap.put("ktmu", ((cn.jiguang.bz.c) a4.first).f3174g + "");
                    if (g(context) && cn.jiguang.bt.b.c(context) == 0) {
                        if (((cn.jiguang.bz.c) a4.first).f3174g != cn.jiguang.d.a.f(context)) {
                            d.c("ShareProcessManager", "this msg uid is :" + ((cn.jiguang.bz.c) a4.first).f3174g + ",is not this app msg");
                            str = "1";
                            hashMap.put("asmrc", str);
                        } else {
                            hashMap.put("asmrc", "0");
                            cn.jiguang.bx.b.a().a(context, (cn.jiguang.bz.c) a4.first, (ByteBuffer) a4.second);
                        }
                    }
                    d.c("ShareProcessManager", "share process is closed");
                    str = "3";
                    hashMap.put("asmrc", str);
                }
                a(context, optString4, "asmr", hashMap);
            }
        } catch (Throwable th) {
            d.c("ShareProcessManager", "doMsg error:" + th.getMessage());
        }
    }

    public void b(Context context) {
        if (this.f3608m) {
            this.f3608m = false;
            if (h.a().d()) {
                d.c("ShareProcessManager", "attach mine while app in foreground from background");
                cn.jiguang.bt.b.a(context, JConstants.SDK_TYPE, 30, 0, j.b(), 0L, cn.jiguang.bz.b.a(cn.jiguang.d.a.f(context), this.f3606e, new long[]{cn.jiguang.d.a.f(context)}));
            }
        }
    }

    public void b(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("data");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("mtmmi");
                String optString2 = jSONObject.optString("ktmfp");
                String optString3 = jSONObject.optString("ktma");
                String optString4 = jSONObject.optString("ktmr");
                String optString5 = jSONObject.optString("ktmu");
                String optString6 = jSONObject.optString("asmrc", "0");
                d.c("ShareProcessManager", "msg response,msgId:" + optString + ",fromPkg:" + optString2 + ",appKey:" + optString3 + ",rid:" + optString4 + ",uid:" + optString5 + ",responseCode:" + optString6);
                if (optString6.equals("0") && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    d.c("ShareProcessManager", "response success,will send msg response to server");
                    cn.jiguang.bt.b.b(context, JConstants.SDK_TYPE, 4, 2, j.b(), Long.parseLong(optString5), cn.jiguang.bz.b.a(0, (byte) 0, Long.parseLong(optString), optString3));
                } else if (optString6.equals("1") && !TextUtils.isEmpty(optString5)) {
                    a(context, Long.parseLong(optString5));
                } else if (!optString6.equals("3") || TextUtils.isEmpty(optString5)) {
                    d.c("ShareProcessManager", "invalid msg response");
                } else {
                    a(context, Long.parseLong(optString5));
                    a(context, optString2);
                }
            }
        } catch (Throwable th) {
            d.i("ShareProcessManager", "doMsgResponse failed:" + th.getMessage());
        }
    }
}
