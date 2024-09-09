package cn.jiguang.ag;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaDrm;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import cn.jiguang.ax.d;
import cn.jiguang.ax.e;
import cn.jiguang.internal.JConstants;
import com.acse.ottn.f3;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    private static String A = null;
    private static String B = null;
    private static String C = null;
    private static String D = null;
    private static String E = null;
    private static String F = null;
    private static String G = null;
    private static String H = null;
    private static String I = null;
    private static final char[] J;

    /* renamed from: a  reason: collision with root package name */
    private static String f2143a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2144b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f2145c = "";

    /* renamed from: d  reason: collision with root package name */
    private static WifiInfo f2146d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f2147e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f2148f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f2149g = "";

    /* renamed from: h  reason: collision with root package name */
    private static int f2150h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static int f2151i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static String f2152j = null;

    /* renamed from: k  reason: collision with root package name */
    private static String f2153k = "";

    /* renamed from: l  reason: collision with root package name */
    private static String f2154l = "";

    /* renamed from: m  reason: collision with root package name */
    private static String f2155m = "";

    /* renamed from: n  reason: collision with root package name */
    private static String f2156n = "";

    /* renamed from: o  reason: collision with root package name */
    private static Boolean f2157o = null;

    /* renamed from: p  reason: collision with root package name */
    private static Boolean f2158p = null;

    /* renamed from: q  reason: collision with root package name */
    private static String f2159q = "";

    /* renamed from: r  reason: collision with root package name */
    private static long f2160r = 3600000;

    /* renamed from: s  reason: collision with root package name */
    private static long f2161s = 0;

    /* renamed from: t  reason: collision with root package name */
    private static String f2162t = "";

    /* renamed from: u  reason: collision with root package name */
    private static long f2163u;

    /* renamed from: v  reason: collision with root package name */
    private static HashMap<String, HashMap<Integer, PackageInfo>> f2164v;

    /* renamed from: w  reason: collision with root package name */
    private static int f2165w;

    /* renamed from: x  reason: collision with root package name */
    private static Object f2166x;

    /* renamed from: y  reason: collision with root package name */
    private static String f2167y;

    /* renamed from: z  reason: collision with root package name */
    private static String f2168z;

    static {
        HashMap<String, HashMap<Integer, PackageInfo>> hashMap = new HashMap<>();
        f2164v = hashMap;
        hashMap.put("com.huawei.hwid", null);
        f2165w = Integer.MIN_VALUE;
        J = "0123456789ABCDEF".toCharArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WifiInfo D(Context context) {
        if (!e.a("getConnectWifiInfo", a((int) AVMDLDataLoader.KeyIsIsEncryptVersion))) {
            try {
                WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                if (wifiManager != null && a(context, "android.permission.ACCESS_WIFI_STATE")) {
                    f2146d = wifiManager.getConnectionInfo();
                    cn.jiguang.w.a.b("AndroidUtil", "getConnectWifiInfo - wifiInfo:" + f2146d.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return f2146d;
    }

    @SuppressLint({"HardwareIds"})
    private static String E(Context context) {
        if (cn.jiguang.ar.a.a().e(2007) && cn.jiguang.ar.a.a().e(1606)) {
            WifiInfo D2 = D(context);
            if (D2 != null && !e.a("getWifiMacAddressInternal", a(1606), 3)) {
                f2152j = D2.getMacAddress();
                cn.jiguang.w.a.b("AndroidUtil", "get mac addr by api, value is: " + f2152j);
            }
            return f2152j;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String F(Context context) {
        String str = "";
        try {
            if (!JConstants.isAndroidQ(context, false, "do not getImei") && a(context, "android.permission.READ_PHONE_STATE")) {
                str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                cn.jiguang.w.a.f("AndroidUtil", "imei is : " + str);
                return str;
            }
            return "";
        } catch (Exception e4) {
            cn.jiguang.w.a.h("AndroidUtil", e4.getMessage());
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String G(Context context) {
        String str = "";
        try {
            if (!JConstants.isAndroidQ(context, false, "do not getImsi") && a(context, "android.permission.READ_PHONE_STATE")) {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                cn.jiguang.w.a.f("AndroidUtil", "imsi is : " + str);
                return str;
            }
            return "";
        } catch (Throwable th) {
            cn.jiguang.w.a.f("AndroidUtil", "getImsi failed:" + th.getMessage());
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            try {
                cn.jiguang.w.a.b("AndroidUtil", "android id is " + str);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return h.e(str) ? str : "";
    }

    private static int a(int i4) {
        int d4 = cn.jiguang.ar.a.a().d(i4);
        if (d4 <= 0) {
            return 600000;
        }
        return d4;
    }

    public static long a(PackageInfo packageInfo) {
        if (packageInfo == null || !cn.jiguang.ar.a.a().e(1034)) {
            return 0L;
        }
        return packageInfo.firstInstallTime;
    }

    public static Intent a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i4);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        parseUri.setSelector(null);
        return intent;
    }

    public static PackageInfo a(Context context, int i4) {
        return a(context, a(context), i4);
    }

    public static PackageInfo a(Context context, String str, int i4) {
        if (context == null || TextUtils.isEmpty(str) || i4 < 0) {
            cn.jiguang.w.a.f("AndroidUtil", "get third p info failed, because param is illegal");
            return null;
        }
        return cn.jiguang.h.a.a(context, str, i4);
    }

    public static PackageInfo a(Context context, String str, int i4, boolean z3) {
        boolean e4 = cn.jiguang.ar.a.a().e(1109);
        if (z3) {
            return a(context, str, i4);
        }
        if (e4) {
            return b(str, i4);
        }
        return null;
    }

    private static File a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return !parentFile.getName().equals("0") ? a(parentFile) : parentFile;
        }
        return null;
    }

    public static String a() {
        try {
            if (!e.a("getPhoneIp", a((int) AVMDLDataLoader.KeyIsIsGetChecksumInfo), 1)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            String hostAddress = nextElement.getHostAddress();
                            f2162t = hostAddress;
                            return hostAddress;
                        }
                    }
                }
            }
            return !TextUtils.isEmpty(f2162t) ? f2162t : "";
        } catch (Exception e4) {
            cn.jiguang.w.a.f("AndroidUtil", "getPI:" + e4.getMessage());
            return "";
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f2143a)) {
            String packageName = context.getPackageName();
            f2143a = packageName;
            return packageName;
        }
        return f2143a;
    }

    public static String a(Context context, String str, String str2) {
        try {
            return (String) g.a(context.getClassLoader().loadClass("android.os.SystemProperties"), f3.f5657f, new Object[]{str, str2}, new Class[]{String.class, String.class});
        } catch (IllegalArgumentException e4) {
            throw e4;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(final Context context, final String str, boolean z3) {
        if (cn.jiguang.ar.a.a().e(2007)) {
            d.a aVar = new d.a() { // from class: cn.jiguang.ag.a.13
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2159q;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2159q = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.j(context, str);
                }
            };
            Object a4 = Build.VERSION.SDK_INT <= 28 ? cn.jiguang.ax.d.a(context, 2007, 1800000L, 864000000L, aVar) : cn.jiguang.ax.d.a(context, 2007, z3, e.a("getWifiMac", a(2007), 3), aVar);
            if (a4 != null && (a4 instanceof String)) {
                f2159q = (String) a4;
            }
            return f2159q;
        }
        return f2159q;
    }

    public static synchronized String a(final Context context, boolean z3) {
        synchronized (a.class) {
            if (cn.jiguang.ar.a.a().e(1600) && cn.jiguang.ar.a.a().e(1608)) {
                Object a4 = cn.jiguang.ax.d.a(context, 1608, z3, e.a("getWifiSsid", a(1608), 3), new d.a() { // from class: cn.jiguang.ag.a.4
                    @Override // cn.jiguang.ax.d.b
                    public Object a() {
                        return a.f2147e;
                    }

                    @Override // cn.jiguang.ax.d.b
                    public void a(Object obj) {
                        if (obj instanceof String) {
                            String unused = a.f2147e = (String) obj;
                        }
                    }

                    @Override // cn.jiguang.ax.d.b
                    public Object b() {
                        WifiInfo D2 = a.D(context);
                        if (D2 != null) {
                            String unused = a.f2147e = D2.getSSID();
                            cn.jiguang.w.a.b("AndroidUtil", "get ssid by api, value is: " + a.f2147e);
                        }
                        return a.f2147e;
                    }

                    @Override // cn.jiguang.ax.d.a, cn.jiguang.ax.d.b
                    public void b(Object obj) {
                        if (obj instanceof String) {
                            String unused = a.f2148f = (String) obj;
                        }
                    }
                });
                if (a4 instanceof String) {
                    f2147e = (String) a4;
                }
                cn.jiguang.w.a.b("AndroidUtil", "lastCacheWifiSSID=" + f2148f + " wifiSSID=" + f2147e + " isFromNetwork=" + z3);
                if (!TextUtils.isEmpty(f2148f) && !TextUtils.isEmpty(f2147e) && !TextUtils.equals(f2147e, f2148f) && Build.VERSION.SDK_INT >= 29 && z3) {
                    cn.jiguang.w.a.b("AndroidUtil", "ssid change,so update mac");
                    a(context, "", true);
                }
                return f2147e;
            }
            cn.jiguang.w.a.b("AndroidUtil", "getWifiSsid, not can get ssid");
            return "";
        }
    }

    public static String a(ApplicationInfo applicationInfo) {
        return (applicationInfo == null || !cn.jiguang.ar.a.a().e(1033)) ? "" : applicationInfo.sourceDir;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = i4 * 2;
            char[] cArr2 = J;
            cArr[i6] = cArr2[i5 >>> 4];
            cArr[i6 + 1] = cArr2[i5 & 15];
        }
        return new String(cArr);
    }

    public static boolean a(Context context, String str) {
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
            cn.jiguang.w.a.f("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static PackageInfo b(String str, int i4) {
        try {
            if (f2166x == null) {
                f2166x = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke(null, new Object[0]);
            }
            IBinder asBinder = ((IInterface) f2166x).asBinder();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken(asBinder.getInterfaceDescriptor());
            obtain.writeString(str);
            obtain.writeLong(i4);
            obtain.writeInt(y());
            asBinder.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            r0 = obtain2.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable unused) {
        }
        return r0;
    }

    public static String b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return readLine;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized String b(Context context, String str) {
        synchronized (a.class) {
        }
        return "";
    }

    public static synchronized String b(final Context context, boolean z3) {
        synchronized (a.class) {
            if (cn.jiguang.ar.a.a().e(1600) && cn.jiguang.ar.a.a().e(1601)) {
                Object a4 = cn.jiguang.ax.d.a(context, 1601, z3, e.a("getWifiBssid", a(1601), 3), new d.a() { // from class: cn.jiguang.ag.a.6
                    @Override // cn.jiguang.ax.d.b
                    public Object a() {
                        return a.f2149g;
                    }

                    @Override // cn.jiguang.ax.d.b
                    public void a(Object obj) {
                        if (obj instanceof String) {
                            String unused = a.f2149g = (String) obj;
                        }
                    }

                    @Override // cn.jiguang.ax.d.b
                    public Object b() {
                        WifiInfo D2 = a.D(context);
                        if (D2 != null) {
                            String unused = a.f2149g = D2.getBSSID();
                            if (a.f2149g == null || a.f2149g.startsWith("02:00:00:")) {
                                String unused2 = a.f2149g = "";
                            }
                            cn.jiguang.w.a.b("AndroidUtil", "get bssid by api, value is: " + a.f2149g);
                        }
                        return a.f2149g;
                    }
                });
                if (a4 instanceof String) {
                    f2149g = (String) a4;
                }
                return f2149g;
            }
            return "";
        }
    }

    public static boolean b(Context context) {
        String a4 = a(context.getApplicationInfo());
        if (h.a(a4)) {
            cn.jiguang.w.a.h("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        cn.jiguang.w.a.b("AndroidUtil", "Current pk installed path: " + a4);
        if (a4.startsWith("/system/app/")) {
            return true;
        }
        if (a4.startsWith("/data/app/")) {
            return false;
        }
        cn.jiguang.w.a.e("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }

    public static String c() {
        MediaDrm mediaDrm = null;
        try {
            MediaDrm mediaDrm2 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
            try {
                byte[] propertyByteArray = mediaDrm2.getPropertyByteArray("deviceUniqueId");
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(propertyByteArray);
                String a4 = a(messageDigest.digest());
                if (Build.VERSION.SDK_INT >= 28) {
                    mediaDrm2.close();
                    return a4;
                }
                mediaDrm2.release();
                return a4;
            } catch (Exception unused) {
                mediaDrm = mediaDrm2;
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm != null) {
                        mediaDrm.close();
                    }
                } else if (mediaDrm != null) {
                    mediaDrm.release();
                }
                return "";
            } catch (Throwable th) {
                th = th;
                mediaDrm = mediaDrm2;
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm != null) {
                        mediaDrm.close();
                    }
                } else if (mediaDrm != null) {
                    mediaDrm.release();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(final Context context) {
        if (context != null && context.getResources() != null && cn.jiguang.ar.a.a().e(2012)) {
            Object b4 = cn.jiguang.ax.d.b(context, 2012, true, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.1
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2144b;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2144b = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (displayMetrics == null) {
                        return "0*0";
                    }
                    int i4 = displayMetrics.widthPixels;
                    int i5 = displayMetrics.heightPixels;
                    return i4 + "*" + i5;
                }
            });
            if (b4 instanceof String) {
                return (String) b4;
            }
        }
        return "0*0";
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String c(final Context context, String str) {
        synchronized (a.class) {
            String str2 = "";
            if (cn.jiguang.ar.a.a().e(2004)) {
                Object a4 = cn.jiguang.ax.d.a(context, 2004, 1800000L, 864000000L, new d.a() { // from class: cn.jiguang.ag.a.7
                    @Override // cn.jiguang.ax.d.b
                    public Object a() {
                        return a.f2154l;
                    }

                    @Override // cn.jiguang.ax.d.b
                    public void a(Object obj) {
                        if (obj instanceof String) {
                            String unused = a.f2154l = (String) obj;
                        }
                    }

                    @Override // cn.jiguang.ax.d.b
                    public Object b() {
                        return a.F(context);
                    }
                });
                if (a4 instanceof String) {
                    str2 = (String) a4;
                }
            }
            if (h.e(str2)) {
                str = str2;
            }
        }
        return str;
    }

    public static String c(final Context context, boolean z3) {
        try {
            d.a aVar = new d.a() { // from class: cn.jiguang.ag.a.9
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2156n;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2156n = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.H(context);
                }
            };
            boolean b4 = cn.jiguang.s.b.b();
            cn.jiguang.w.a.b("AndroidUtil", "onlyVerifiSDK=" + b4);
            if (cn.jiguang.ar.a.a().f(2000)) {
                Object a4 = b4 ? cn.jiguang.ax.d.a(context, 2000, 259200000L, z3, aVar) : cn.jiguang.ax.d.a(context, 2000, 1800000L, 259200000L, aVar);
                return a4 instanceof String ? (String) a4 : "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d() {
        return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    @TargetApi(19)
    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(f2145c) && !e.a("getExternalSdPath", PolicyConfig.mServerBusyRetryBaseInternal)) {
                File externalFilesDir = JConstants.getAppContext(context).getExternalFilesDir(null);
                externalFilesDir.getClass();
                File a4 = a(externalFilesDir);
                if (a4 != null) {
                    f2145c = a4.getAbsolutePath();
                }
                cn.jiguang.w.a.b("AndroidUtil", "get sd ex path: " + f2145c);
            }
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(f2145c) ? "/storage/emulated/0" : f2145c;
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String d(final Context context, String str) {
        synchronized (a.class) {
            String str2 = "";
            if (cn.jiguang.ar.a.a().e(2005)) {
                Object a4 = cn.jiguang.ax.d.a(context, 2005, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.ag.a.8
                    @Override // cn.jiguang.ax.d.b
                    public Object a() {
                        return a.f2155m;
                    }

                    @Override // cn.jiguang.ax.d.b
                    public void a(Object obj) {
                        if (obj instanceof String) {
                            String unused = a.f2155m = (String) obj;
                        }
                    }

                    @Override // cn.jiguang.ax.d.b
                    public Object b() {
                        return a.G(context);
                    }
                });
                if (a4 instanceof String) {
                    str2 = (String) a4;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        return str;
    }

    public static synchronized int e(Context context) {
        synchronized (a.class) {
            if (cn.jiguang.ar.a.a().e(1500) && cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                WifiInfo D2 = D(context);
                if (D2 != null && !e.a("getWifiRssi", a((int) AVMDLDataLoader.KeyIsIsEncryptVersion), 3)) {
                    f2150h = D2.getRssi();
                    cn.jiguang.w.a.b("AndroidUtil", "get rssi by api, value is: " + f2150h);
                }
                return f2150h;
            }
            return 0;
        }
    }

    public static boolean e(Context context, String str) {
        return (h.a(str) || a(context, str, 0) == null) ? false : true;
    }

    public static synchronized int f(Context context) {
        synchronized (a.class) {
            if (cn.jiguang.ar.a.a().e(1500) && cn.jiguang.ar.a.a().e(AVMDLDataLoader.KeyIsIsEncryptVersion)) {
                WifiInfo D2 = D(context);
                if (D2 != null && !e.a("getWifiNetWorkId", a((int) AVMDLDataLoader.KeyIsIsEncryptVersion), 3)) {
                    f2151i = D2.getNetworkId();
                    cn.jiguang.w.a.b("AndroidUtil", "get net id by api, value is: " + f2151i);
                }
                return f2151i;
            }
            return -1;
        }
    }

    public static boolean f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                return packageManager.resolveActivity(launchIntentForPackage, 65536) != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String g(Context context) {
        return c(context, false);
    }

    public static boolean g(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] split = str.split("\\|");
            if (split.length <= 1) {
                return false;
            }
            Intent u3 = u(split[1]);
            u3.setPackage(split[0]);
            return packageManager.resolveActivity(u3, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(final Context context) {
        if (cn.jiguang.ar.a.a().e(2500)) {
            Object a4 = cn.jiguang.ax.e.a(context, 2500, new e.a() { // from class: cn.jiguang.ag.a.10
                @Override // cn.jiguang.ax.e.b
                public Object a() {
                    return a.f2157o;
                }

                @Override // cn.jiguang.ax.e.b
                public void a(Object obj) {
                    if (obj instanceof Boolean) {
                        Boolean unused = a.f2157o = Boolean.valueOf(((Boolean) obj).booleanValue());
                    }
                }

                @Override // cn.jiguang.ax.e.b
                public Object b() {
                    return Boolean.valueOf(new cn.jiguang.an.c(context).a());
                }
            });
            if (a4 instanceof Boolean) {
                return ((Boolean) a4).booleanValue();
            }
        }
        return false;
    }

    public static boolean h(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            PackageInfo a4 = a(context, 4096);
            if (a4 != null) {
                for (String str2 : a4.requestedPermissions) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.g("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
        }
        return false;
    }

    public static boolean i(final Context context) {
        if (cn.jiguang.ar.a.a().e(1027)) {
            Object a4 = cn.jiguang.ax.e.a(context, 1027, new e.a() { // from class: cn.jiguang.ag.a.11
                @Override // cn.jiguang.ax.e.b
                public Object a() {
                    return a.f2158p;
                }

                @Override // cn.jiguang.ax.e.b
                public void a(Object obj) {
                    if (obj instanceof Boolean) {
                        Boolean unused = a.f2158p = Boolean.valueOf(((Boolean) obj).booleanValue());
                    }
                }

                @Override // cn.jiguang.ax.e.b
                public Object b() {
                    return Boolean.valueOf(c.a(context).a(false).b(true).c(false).a());
                }
            });
            if (a4 instanceof Boolean) {
                return ((Boolean) a4).booleanValue();
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static String j(Context context) {
        String str = "";
        if (Build.VERSION.SDK_INT >= 23 || !a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            str = E(context);
            cn.jiguang.w.a.b("AndroidUtil", "mac address from WifiManager:" + str);
            return str;
        } catch (Exception e4) {
            cn.jiguang.w.a.b("AndroidUtil", "get mac from wifiManager failed ", e4);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String j(Context context, String str) {
        String str2;
        if (cn.jiguang.h.a.i(context)) {
            String j4 = j(context);
            if (!h.f(j4)) {
                j4 = k(context);
            }
            if (h.f(j4)) {
                str = j4;
            }
            str2 = "getWifiMac:" + str;
        } else {
            str2 = "[getWifiMac] lbs disabled";
        }
        cn.jiguang.w.a.b("AndroidUtil", str2);
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        r3 = new java.lang.StringBuilder();
        r5 = r4.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (r6 >= r5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        r3.append(java.lang.String.format(java.util.Locale.ENGLISH, "%02x:", java.lang.Byte.valueOf(r4[r6])));
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
        if (r3.length() <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
        r3.deleteCharAt(r3.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
        r2 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        cn.jiguang.w.a.b("AndroidUtil", "mac address from NetworkInterface:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009d, code lost:
        r3 = r12;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
        cn.jiguang.w.a.f("AndroidUtil", "get mac from NetworkInterface failed:" + r12.getMessage());
        r12 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String k(android.content.Context r12) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "AndroidUtil"
            r2 = 0
            java.lang.String r3 = "android.permission.ACCESS_WIFI_STATE"
            boolean r3 = a(r12, r3)     // Catch: java.lang.Exception -> La8
            if (r3 == 0) goto L23
            android.content.Context r12 = r12.getApplicationContext()     // Catch: java.lang.Exception -> La8
            android.content.Context r12 = com.stub.StubApp.getOrigApplicationContext(r12)     // Catch: java.lang.Exception -> La8
            java.lang.String r3 = "wifi"
            java.lang.Object r12 = r12.getSystemService(r3)     // Catch: java.lang.Exception -> La8
            android.net.wifi.WifiManager r12 = (android.net.wifi.WifiManager) r12     // Catch: java.lang.Exception -> La8
            boolean r12 = r12.isWifiEnabled()     // Catch: java.lang.Exception -> La8
            goto L24
        L23:
            r12 = 0
        L24:
            if (r12 != 0) goto L2c
            java.lang.String r2 = "not get mac address for wifi disabled"
            cn.jiguang.w.a.b(r1, r2)     // Catch: java.lang.Exception -> La3
            return r0
        L2c:
            java.util.Enumeration r3 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Exception -> La3
        L30:
            boolean r4 = r3.hasMoreElements()     // Catch: java.lang.Exception -> La3
            if (r4 == 0) goto La1
            java.lang.Object r4 = r3.nextElement()     // Catch: java.lang.Exception -> La3
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch: java.lang.Exception -> La3
            java.lang.String r5 = "wlan0"
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Exception -> La3
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Exception -> La3
            if (r5 == 0) goto L30
            byte[] r4 = r4.getHardwareAddress()     // Catch: java.lang.Exception -> La3
            if (r4 == 0) goto L30
            int r5 = r4.length     // Catch: java.lang.Exception -> La3
            if (r5 != 0) goto L53
            goto L30
        L53:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La3
            r3.<init>()     // Catch: java.lang.Exception -> La3
            int r5 = r4.length     // Catch: java.lang.Exception -> La3
            r6 = 0
        L5a:
            r7 = 1
            if (r6 >= r5) goto L75
            r8 = r4[r6]     // Catch: java.lang.Exception -> La3
            java.util.Locale r9 = java.util.Locale.ENGLISH     // Catch: java.lang.Exception -> La3
            java.lang.String r10 = "%02x:"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> La3
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch: java.lang.Exception -> La3
            r7[r2] = r8     // Catch: java.lang.Exception -> La3
            java.lang.String r7 = java.lang.String.format(r9, r10, r7)     // Catch: java.lang.Exception -> La3
            r3.append(r7)     // Catch: java.lang.Exception -> La3
            int r6 = r6 + 1
            goto L5a
        L75:
            int r2 = r3.length()     // Catch: java.lang.Exception -> La3
            if (r2 <= 0) goto L83
            int r2 = r3.length()     // Catch: java.lang.Exception -> La3
            int r2 = r2 - r7
            r3.deleteCharAt(r2)     // Catch: java.lang.Exception -> La3
        L83:
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> La3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9c
            r3.<init>()     // Catch: java.lang.Exception -> L9c
            java.lang.String r4 = "mac address from NetworkInterface:"
            r3.append(r4)     // Catch: java.lang.Exception -> L9c
            r3.append(r2)     // Catch: java.lang.Exception -> L9c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L9c
            cn.jiguang.w.a.b(r1, r3)     // Catch: java.lang.Exception -> L9c
            goto Lc4
        L9c:
            r3 = move-exception
            r11 = r3
            r3 = r12
            r12 = r11
            goto Lab
        La1:
            r2 = r0
            goto Lc4
        La3:
            r2 = move-exception
            r3 = r12
            r12 = r2
            r2 = r0
            goto Lab
        La8:
            r12 = move-exception
            r2 = r0
            r3 = 0
        Lab:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "get mac from NetworkInterface failed:"
            r4.append(r5)
            java.lang.String r12 = r12.getMessage()
            r4.append(r12)
            java.lang.String r12 = r4.toString()
            cn.jiguang.w.a.f(r1, r12)
            r12 = r3
        Lc4:
            if (r12 != 0) goto Ldb
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r3 = "mac address is dropped, which is "
            r12.append(r3)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            cn.jiguang.w.a.b(r1, r12)
            goto Ldc
        Ldb:
            r0 = r2
        Ldc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ag.a.k(android.content.Context):java.lang.String");
    }

    public static boolean l(Context context) {
        String a4 = a(context, "ro.product.brand", "");
        cn.jiguang.w.a.b("AndroidUtil", "brand = " + a4);
        String a5 = a(context, "ro.miui.ui.version.name", "");
        if (TextUtils.isEmpty(a4) || !"Xiaomi".equals(a4) || TextUtils.isEmpty(a5)) {
            return true;
        }
        String a6 = a(context, "ro.build.version.incremental", "");
        if (TextUtils.isEmpty(a6) || !a6.startsWith("V7.1")) {
            return true;
        }
        cn.jiguang.w.a.f("AndroidUtil", "7.1 will not get wifi list");
        return false;
    }

    public static String m(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String n(Context context) {
        if (cn.jiguang.ar.a.a().e(1015)) {
            Object b4 = cn.jiguang.ax.d.b(context, 1015, true, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.12
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2167y;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2167y = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.v(Build.PRODUCT);
                }
            });
            if (b4 instanceof String) {
                f2167y = (String) b4;
            }
        }
        return f2167y;
    }

    public static String o(Context context) {
        if (cn.jiguang.ar.a.a().e(1007)) {
            Object a4 = cn.jiguang.ax.d.a(context, 1007, new d.a() { // from class: cn.jiguang.ag.a.14
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.f2168z;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f2168z = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.v(Build.FINGERPRINT);
                }
            });
            if (a4 instanceof String) {
                f2168z = (String) a4;
            }
        }
        return f2168z;
    }

    public static String p(Context context) {
        if (cn.jiguang.ar.a.a().e(2009)) {
            Object b4 = cn.jiguang.ax.d.b(context, 2009, true, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.15
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.A;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.A = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.v(Build.MODEL);
                }
            });
            if (b4 instanceof String) {
                A = (String) b4;
            }
        }
        return A;
    }

    public static String q(Context context) {
        return cn.jiguang.ar.a.a().e(2001) ? a(context, "gsm.version.baseband", "baseband") : "";
    }

    public static String r(Context context) {
        if (cn.jiguang.ar.a.a().e(2002)) {
            Object b4 = cn.jiguang.ax.d.b(context, 2002, true, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.16
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.B;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.B = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.v(String.format(Locale.ENGLISH, Build.BRAND, new Object[0]));
                }
            });
            if (b4 instanceof String) {
                B = (String) b4;
            }
        }
        return B;
    }

    public static String s(final Context context) {
        if (cn.jiguang.ar.a.a().e(2006)) {
            Object b4 = cn.jiguang.ax.d.b(context, 2006, true, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.17
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.C;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.C = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.v(context.getResources().getConfiguration().locale.toString());
                }
            });
            if (b4 instanceof String) {
                C = (String) b4;
            }
        }
        return C;
    }

    public static String t(Context context) {
        if (cn.jiguang.ar.a.a().e(2008)) {
            Object b4 = cn.jiguang.ax.d.b(context, 2008, true, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.18
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.D;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.D = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.v(Build.MANUFACTURER);
                }
            });
            if (b4 instanceof String) {
                D = (String) b4;
            }
        }
        return D;
    }

    private static Intent u(String str) {
        return a(str, Build.VERSION.SDK_INT >= 22 ? 4 : 0);
    }

    public static String u(Context context) {
        Object b4 = cn.jiguang.ax.d.b(context, 2014, false, false, (d.b) new d.a() { // from class: cn.jiguang.ag.a.19
            @Override // cn.jiguang.ax.d.b
            public Object a() {
                return a.E;
            }

            @Override // cn.jiguang.ax.d.b
            public void a(Object obj) {
                if (obj instanceof String) {
                    String unused = a.E = (String) obj;
                }
            }

            @Override // cn.jiguang.ax.d.b
            public Object b() {
                StringBuilder sb;
                String str;
                long rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
                if (rawOffset > 0) {
                    sb = new StringBuilder();
                    str = "+";
                } else if (rawOffset < 0) {
                    sb = new StringBuilder();
                    sb.append("-");
                    sb.append(rawOffset);
                    return sb.toString().replace("--", "-");
                } else {
                    sb = new StringBuilder();
                    str = "";
                }
                sb.append(str);
                sb.append(rawOffset);
                return sb.toString().replace("--", "-");
            }
        });
        if (b4 instanceof String) {
            E = (String) b4;
        }
        return E;
    }

    public static String v(Context context) {
        if (cn.jiguang.ar.a.a().e(1014)) {
            Object a4 = cn.jiguang.ax.d.a(context, 1014, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.ag.a.20
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.F;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.F = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    String format = String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
                    if (TextUtils.isEmpty(format)) {
                        return null;
                    }
                    return format.trim();
                }
            });
            if (a4 instanceof String) {
                F = (String) a4;
            }
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String v(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    public static String w(Context context) {
        try {
            Object a4 = cn.jiguang.ar.a.a().e(1030) ? cn.jiguang.ax.d.a(context, 1030, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.ag.a.2
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.G;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.G = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.b();
                }
            }) : null;
            if (a4 instanceof String) {
                G = (String) a4;
            }
        } catch (Throwable unused) {
        }
        return G;
    }

    @TargetApi(18)
    public static String x(Context context) {
        try {
            Object a4 = cn.jiguang.ar.a.a().e(1031) ? cn.jiguang.ax.d.a(context, 1031, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.ag.a.3
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.H;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.H = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.c();
                }
            }) : null;
            if (a4 instanceof String) {
                H = (String) a4;
            }
        } catch (Throwable unused) {
        }
        return H;
    }

    private static int y() {
        int i4 = f2165w;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        try {
            Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
            Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(cls, Integer.valueOf(Process.myUid()))).intValue();
            f2165w = intValue;
            return intValue;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String y(Context context) {
        try {
            Object a4 = cn.jiguang.ar.a.a().e(1032) ? cn.jiguang.ax.d.a(context, 1032, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.ag.a.5
                @Override // cn.jiguang.ax.d.b
                public Object a() {
                    return a.I;
                }

                @Override // cn.jiguang.ax.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.I = (String) obj;
                    }
                }

                @Override // cn.jiguang.ax.d.b
                public Object b() {
                    return a.d();
                }
            }) : null;
            if (a4 instanceof String) {
                I = (String) a4;
            }
        } catch (Throwable unused) {
        }
        return I;
    }
}
