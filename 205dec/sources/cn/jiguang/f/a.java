package cn.jiguang.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.service.PushReceiver;
import com.stub.StubApp;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3618a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f3619b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f3620c = "";

    /* renamed from: d  reason: collision with root package name */
    private static int f3621d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f3622e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f3623f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f3624g = "";

    /* renamed from: h  reason: collision with root package name */
    private static String f3625h = "";

    /* renamed from: i  reason: collision with root package name */
    private static PackageInfo f3626i;

    /* renamed from: j  reason: collision with root package name */
    private static HashMap<String, HashMap<Integer, PackageInfo>> f3627j;

    /* renamed from: k  reason: collision with root package name */
    private static int f3628k;

    /* renamed from: l  reason: collision with root package name */
    private static Object f3629l;

    /* renamed from: m  reason: collision with root package name */
    private static final HashMap<Integer, PackageInfo> f3630m;

    /* renamed from: n  reason: collision with root package name */
    private static int f3631n;

    static {
        HashMap<String, HashMap<Integer, PackageInfo>> hashMap = new HashMap<>();
        f3627j = hashMap;
        hashMap.put("com.huawei.hwid", null);
        f3628k = Integer.MIN_VALUE;
        f3630m = new HashMap<>();
        f3631n = 0;
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i4;
        PackageInfo b4;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.bq.d.i("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            i4 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            b4 = b(context, str, i4);
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("AndroidUtil", "hasComponent error:" + th);
        }
        if (b4 == null) {
            return null;
        }
        ComponentInfo[] componentInfoArr = i4 != 1 ? i4 != 2 ? i4 != 4 ? i4 != 8 ? null : b4.providers : b4.services : b4.receivers : b4.activities;
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    private static PackageInfo a(int i4) {
        PackageInfo packageInfo = f3626i;
        if (packageInfo == null || (i4 != 0 && (f3631n & i4) == 0)) {
            HashMap<Integer, PackageInfo> hashMap = f3630m;
            if (!hashMap.containsKey(Integer.valueOf(i4)) || hashMap.get(Integer.valueOf(i4)) == null) {
                if (i4 != 0 || hashMap.size() <= 0) {
                    return null;
                }
                for (Integer num : hashMap.keySet()) {
                    PackageInfo packageInfo2 = f3630m.get(Integer.valueOf(num.intValue()));
                    if (packageInfo2 != null) {
                        return packageInfo2;
                    }
                }
                return null;
            }
            return hashMap.get(Integer.valueOf(i4));
        }
        return packageInfo;
    }

    public static PackageInfo a(Context context, int i4) {
        return b(context, c(context), i4);
    }

    public static PackageInfo a(String str, int i4) {
        try {
            if (f3629l == null) {
                f3629l = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke(null, new Object[0]);
            }
            IBinder asBinder = ((IInterface) f3629l).asBinder();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken(asBinder.getInterfaceDescriptor());
            obtain.writeString(str);
            obtain.writeLong(i4);
            obtain.writeInt(c());
            asBinder.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            r0 = obtain2.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable unused) {
        }
        return r0;
    }

    public static ProviderInfo a(Context context, String str, String str2) {
        ProviderInfo[] providerInfoArr;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PackageInfo b4 = b(context, str, 8);
                if (b4 != null && (providerInfoArr = b4.providers) != null && providerInfoArr.length != 0) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(Context context) {
        String c4;
        if (TextUtils.isEmpty(f3618a)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String processName = Application.getProcessName();
                    f3618a = processName;
                    if (!TextUtils.isEmpty(processName)) {
                        return f3618a;
                    }
                }
                c4 = f.c();
                f3618a = c4;
            } catch (Throwable th) {
                cn.jiguang.bq.d.j("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
            }
            if (TextUtils.isEmpty(c4)) {
                f3618a = b();
                return f3618a;
            }
            return f3618a;
        }
        return f3618a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r4.checkPermission(r6, r5.activityInfo.packageName) != 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, android.content.Intent r5, java.lang.String r6) {
        /*
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L2f
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch: java.lang.Throwable -> L2f
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L2f
            android.content.pm.ServiceInfo r0 = r5.serviceInfo     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L2f
            java.lang.String r0 = r0.name     // Catch: java.lang.Throwable -> L2f
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L2f
            r2 = 1
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L2b
            android.content.pm.ActivityInfo r5 = r5.activityInfo     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = r5.packageName     // Catch: java.lang.Throwable -> L2f
            int r4 = r4.checkPermission(r6, r5)     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L2b
            goto L2c
        L2b:
            r1 = 1
        L2c:
            if (r1 == 0) goto L2f
            return r0
        L2f:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.f.a.a(android.content.Context, android.content.Intent, java.lang.String):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!c(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("AndroidUtil", "send broadcast failed: " + th.getMessage());
        }
    }

    public static void a(Context context, String str, int i4) {
        int i5;
        if (!f(context)) {
            cn.jiguang.bq.d.c("AndroidUtil", "not debuggable");
            return;
        }
        cn.jiguang.bq.d.c("AndroidUtil", "action:showPermanentNotification");
        Intent intent = new Intent(context, PushReceiver.class);
        intent.setAction("noti_open_proxy");
        intent.addCategory(context.getPackageName());
        intent.putExtra("debug_notification", true);
        intent.putExtra("toastText", str);
        intent.putExtra("type", i4);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        try {
            i5 = context.getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), 0).icon;
        } catch (Throwable th) {
            cn.jiguang.bq.d.e("AndroidUtil", "failed to get application info and icon.", th);
            i5 = 17301586;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = Build.VERSION.SDK_INT;
        Notification.Builder when = new Notification.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext())).setContentTitle("Jiguang\u63d0\u793a\uff1a\u5305\u540d\u548cAppKey\u4e0d\u5339\u914d").setContentText("\u8bf7\u5230 Portal \u4e0a\u83b7\u53d6\u60a8\u7684\u5305\u540d\u548cAppKey\u5e76\u66f4\u65b0AndroidManifest\u76f8\u5e94\u5b57\u6bb5").setContentIntent(broadcast).setSmallIcon(i5).setTicker(str).setWhen(currentTimeMillis);
        if (i6 >= 26) {
            if (notificationManager.getNotificationChannel("JPush_Notification") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("JPush_Notification", "JPush_Notification", 3));
            }
            when.setChannelId("JPush_Notification");
        }
        Notification notification = when.getNotification();
        notification.flags = 34;
        f3621d = 10000;
        notificationManager.notify(10000, notification);
    }

    public static boolean a() {
        boolean z3;
        try {
            z3 = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("AndroidUtil", "isSdcardExist exception: " + th);
            z3 = false;
        }
        if (!z3) {
            cn.jiguang.bq.d.c("AndroidUtil", "SDCard is not mounted");
        }
        return z3;
    }

    public static boolean a(Context context, int i4, boolean z3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("configID", i4);
            bundle.putBoolean("isFromJCore", z3);
            Object a4 = cn.jiguang.bl.a.a(null, "isCanCollect", bundle, null);
            if (a4 instanceof Boolean) {
                return ((Boolean) a4).booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static synchronized PackageInfo b(Context context, int i4) {
        int i5;
        String str;
        String str2;
        synchronized (a.class) {
            String c4 = c(context);
            PackageInfo a4 = a(i4);
            if (a4 != null) {
                return a4;
            }
            cn.jiguang.bq.d.c("AndroidUtil", "no l p info cache, call sys api");
            if (f3631n == 0) {
                i5 = i4 | 15 | 4288;
                if (Build.VERSION.SDK_INT >= 28) {
                    i5 |= 134217728;
                }
            } else {
                i5 = i4;
            }
            f3631n = i5 | f3631n;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c4, f3631n);
            if (packageInfo == null) {
                cn.jiguang.bq.d.i("AndroidUtil", "g l p info failed, p info is null");
                packageInfo = context.getPackageManager().getPackageInfo(c4, i4);
                if (packageInfo != null) {
                    f3630m.put(Integer.valueOf(i4), packageInfo);
                    str = "AndroidUtil";
                    str2 = "get l p info again success for l p is null, flag: " + i4;
                }
                return packageInfo;
            }
            f3626i = packageInfo;
            str = "AndroidUtil";
            str2 = "get l p info success, flag: " + i4 + ", flags: " + f3631n;
            cn.jiguang.bq.d.c(str, str2);
            return packageInfo;
        }
    }

    public static PackageInfo b(Context context, String str, int i4) {
        PackageInfo a4 = (Build.VERSION.SDK_INT < 33 || !a(context, 1109, true)) ? null : a(str, i4);
        return a4 == null ? c(context, str, i4) : a4;
    }

    public static ProviderInfo b(Context context, String str, Class<? extends ContentProvider> cls) {
        try {
            return context.getPackageManager().getProviderInfo(new ComponentName(str, cls.getName()), 65536);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i4;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable unused) {
            }
            try {
                bArr = new byte[256];
                i4 = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i4 >= 256) {
                        break;
                    }
                    bArr[i4] = (byte) read;
                    i4++;
                }
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                    return "";
                }
                return "";
            }
            if (i4 <= 0) {
                fileInputStream.close();
                return "";
            }
            String str = new String(bArr, 0, i4, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(Context context, String str, String str2) {
        try {
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("data", str2);
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            cn.jiguang.bq.d.c("AndroidUtil", "send config  intent=" + intent);
            context.sendBroadcast(intent, context.getPackageName() + cn.jiguang.a.a.f2009a);
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context) {
        if (f3619b == null) {
            f3619b = Boolean.valueOf(context.getPackageName().equals(a(context)));
        }
        return f3619b.booleanValue();
    }

    private static int c() {
        int i4 = f3628k;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        try {
            Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
            Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(cls, Integer.valueOf(Process.myUid()))).intValue();
            f3628k = intValue;
            return intValue;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static PackageInfo c(Context context, String str, int i4) {
        String str2;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || i4 < 0) {
            str2 = "get third p info failed, because param is illegal";
        } else {
            try {
                int indexOf = str.indexOf(":");
                if (indexOf > 0) {
                    String substring = str.substring(0, indexOf);
                    cn.jiguang.bq.d.i("AndroidUtil", "get p info has p name, origin: " + str + ", new: " + substring);
                    str = substring;
                }
                if (TextUtils.equals(c(context), str)) {
                    return b(context, i4);
                }
                if (a(context, 1105, true) && a(context, 1100, true)) {
                    HashMap<Integer, PackageInfo> hashMap = f3627j.get(str);
                    if (hashMap != null) {
                        packageInfo = hashMap.get(Integer.valueOf(i4));
                        if (packageInfo != null) {
                            if (TextUtils.isEmpty(packageInfo.packageName)) {
                                packageInfo = null;
                            }
                            cn.jiguang.bq.d.c("AndroidUtil", "get third p info by mem-cache, p name: " + str + ", flag: " + i4 + ", pinfo: " + packageInfo);
                            return packageInfo;
                        }
                    } else {
                        packageInfo = null;
                    }
                    try {
                        cn.jiguang.bq.d.f("AndroidUtil", "get third p info by sys api, p name: " + str + ", flag: " + i4);
                        packageInfo = context.getPackageManager().getPackageInfo(str, i4);
                    } catch (Throwable unused) {
                    }
                    if (f3627j.containsKey(str)) {
                        HashMap<Integer, PackageInfo> hashMap2 = new HashMap<>();
                        hashMap2.put(Integer.valueOf(i4), packageInfo == null ? new PackageInfo() : packageInfo);
                        f3627j.put(str, hashMap2);
                        cn.jiguang.bq.d.c("AndroidUtil", "cache third p info, p name: " + str + ", flag: " + i4);
                    }
                    return packageInfo;
                }
                cn.jiguang.bq.d.i("AndroidUtil", "configID 1105/1100 is not can collect,so return null ");
                return null;
            } catch (Throwable th) {
                str2 = "get p info failed, error: " + th.getMessage();
            }
        }
        cn.jiguang.bq.d.i("AndroidUtil", str2);
        return null;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f3620c)) {
            String packageName = context.getPackageName();
            f3620c = packageName;
            return packageName;
        }
        return f3620c;
    }

    public static boolean c(Context context, String str) {
        try {
            boolean z3 = true;
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.getApplicationInfo().targetSdkVersion < 23) {
                    String permissionToOp = AppOpsManager.permissionToOp(str);
                    if (permissionToOp != null) {
                        z3 = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(permissionToOp, context.getPackageName()) == 0;
                    }
                    return z3;
                } else if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r6) {
        /*
            java.lang.String r0 = "AndroidUtil"
            r1 = -1
            if (r6 != 0) goto L6
            return r1
        L6:
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "android.intent.action.BATTERY_CHANGED"
            r2.<init>(r3)
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.<init>()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r5 = r6.getPackageName()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.append(r5)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r5 = cn.jiguang.a.a.f2009a     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.append(r5)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            android.content.Intent r3 = cn.jiguang.cn.e.a(r6, r3, r2, r4, r3)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            goto L44
        L28:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getChargedStatus unkown exception:"
            r2.append(r4)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            goto L41
        L3f:
            java.lang.String r6 = "getChargedStatus SecurityException"
        L41:
            cn.jiguang.bq.d.i(r0, r6)
        L44:
            if (r3 != 0) goto L47
            return r1
        L47:
            java.lang.String r6 = "status"
            int r6 = r3.getIntExtra(r6, r1)
            r0 = 2
            if (r6 == r0) goto L56
            r0 = 5
            if (r6 != r0) goto L54
            goto L56
        L54:
            r6 = 0
            goto L57
        L56:
            r6 = 1
        L57:
            if (r6 != 0) goto L5a
            return r1
        L5a:
            java.lang.String r6 = "plugged"
            int r6 = r3.getIntExtra(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.f.a.d(android.content.Context):int");
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String d(Context context, String str) {
        synchronized (a.class) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("defaultImei", str);
                Object a4 = cn.jiguang.bl.a.a(context, "getImei", bundle, null);
                if (a4 instanceof String) {
                    return (String) a4;
                }
            } catch (Exception unused) {
            }
            return "";
        }
    }

    public static String e(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("defaultString", str);
            Object a4 = cn.jiguang.bl.a.a(context, "getWifiMac", bundle, null);
            return a4 instanceof String ? (String) a4 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!c(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean f(Context context) {
        try {
            cn.jiguang.bq.d.c("AndroidUtil", "isDebug:" + ((context.getApplicationInfo().flags & 2) != 0));
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            PackageInfo a4 = a(context, 64);
            if (a4 != null) {
                Signature[] signatureArr = a4.signatures;
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                boolean z3 = false;
                for (Signature signature : signatureArr) {
                    try {
                        X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                        z3 = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                        cn.jiguang.bq.d.c("AndroidUtil", "debuggable :" + z3);
                        if (z3) {
                            break;
                        }
                        String str = null;
                        try {
                            str = x509Certificate.getSubjectX500Principal().getName();
                        } catch (Exception unused) {
                        }
                        cn.jiguang.bq.d.c("AndroidUtil", "certName:" + str);
                        if (str != null && str.contains(strArr[0]) && str.contains(strArr[1]) && str.contains(strArr[2])) {
                            return true;
                        }
                    } catch (Throwable unused2) {
                    }
                }
                return z3;
            }
            return false;
        } catch (Throwable unused3) {
            return false;
        }
    }

    public static boolean f(Context context, String str) {
        return (g.a(str) || b(context, str, 0) == null) ? false : true;
    }

    public static void g(Context context) {
        try {
            if (f3621d != 0) {
                ((NotificationManager) context.getSystemService("notification")).cancel(f3621d);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("AndroidUtil", "[canclePermanentNotification] failed:" + th.getMessage());
        }
    }

    public static boolean g(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            PackageInfo b4 = b(context, 4096);
            if (b4 != null) {
                for (String str2 : b4.requestedPermissions) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
        }
        return false;
    }

    public static String h(Context context) {
        String i4 = i(context);
        if (TextUtils.isEmpty(i4)) {
            return i4;
        }
        return i4 + "/data/";
    }

    public static String i(Context context) {
        if (context == null) {
            return "";
        }
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "getExternalSdPath", null, null);
            if (a4 instanceof String) {
                return (String) a4;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static synchronized String j(Context context) {
        synchronized (a.class) {
            try {
                Object a4 = cn.jiguang.bl.a.a(context, "getWifiBssid", null, null);
                if (a4 instanceof String) {
                    return (String) a4;
                }
            } catch (Exception unused) {
            }
            return "";
        }
    }

    public static String k(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "getAndroidId", null, null);
            return a4 instanceof String ? (String) a4 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean l(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "checkDeviceRooted", null, null);
            if (a4 instanceof Boolean) {
                return ((Boolean) a4).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String m(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "getNetworkType", null, null);
            return a4 instanceof String ? (String) a4 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String n(Context context) {
        Object invoke;
        String str = null;
        int i4 = -1;
        if (context != null) {
            try {
                Object systemService = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null && (invoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                        String str2 = (String) invoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(invoke, new Object[0]);
                        try {
                            i4 = ((Integer) invoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(invoke, new Object[0])).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            cn.jiguang.bq.d.l("AndroidUtil", "getCountryCode failed, error :" + th);
                            cn.jiguang.bq.d.c("AndroidUtil", "get CountCode = " + str + " source = " + i4);
                            if (i4 != 0) {
                            }
                        }
                    }
                } else {
                    cn.jiguang.bq.d.c("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cn.jiguang.bq.d.c("AndroidUtil", "get CountCode = " + str + " source = " + i4);
        return (i4 != 0 || i4 == 1) ? str : "";
    }

    public static String o(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String p(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "getManufacturer", null, null);
            return a4 instanceof String ? (String) a4 : "0*0";
        } catch (Exception unused) {
            return "0*0";
        }
    }

    public static String q(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "getBrand", null, null);
            return a4 instanceof String ? (String) a4 : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
