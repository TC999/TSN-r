package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p399f.C10343a;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.kwad.sdk.utils.bi */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11059bi {
    private static boolean aQA = false;
    private static String aQC = "";
    private static String aQD = "";
    private static String aQE = "";
    private static String aQF = null;
    private static String aQG = null;
    private static int aQH = -1;
    private static boolean aQI = false;
    private static boolean aQJ = false;
    private static boolean aQK = false;
    private static boolean aQL = false;
    private static boolean aQM = false;
    private static boolean aQN = false;
    private static int aQO = 0;
    private static long aQP = 0;
    private static String aQQ = "";
    private static String aQR = "";
    public static String aQS = "";
    private static String aQs = null;
    private static String aQt = "";
    private static boolean aQu = false;
    private static String aQv = "";
    private static String aQw = "";
    private static int aQx;
    private static boolean aQy;
    private static int aQz;
    private static final String[] aQB = {"", ""};
    private static final List<String> aQT = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    /* renamed from: MQ */
    private static long m23916MQ() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        C10738b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    C10738b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    C10738b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            C10738b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* renamed from: MS */
    public static long m23915MS() {
        return C10747h.m24954K(Environment.getDataDirectory());
    }

    /* renamed from: MT */
    public static long m23914MT() {
        if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(1024L)) {
            return 0L;
        }
        return C10747h.m24955J(Environment.getDataDirectory());
    }

    /* renamed from: MU */
    public static long m23913MU() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory > 0) {
            return freeMemory;
        }
        return 0L;
    }

    /* renamed from: MV */
    public static int m23912MV() {
        int i = aQO;
        if (i > 0) {
            return i;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aQO = availableProcessors;
        return availableProcessors;
    }

    /* renamed from: MW */
    public static String m23911MW() {
        return Build.MODEL;
    }

    /* renamed from: MX */
    public static synchronized long m23910MX() {
        long j;
        synchronized (C11059bi.class) {
            j = 0;
            if (C11028au.usePhoneStateDisable() && (!TextUtils.isEmpty(C11028au.m24073Mj()) || C11028au.m24072Mk() != null)) {
                j = 1;
            }
            if (C11028au.m24075Mh() && C11028au.m24074Mi() != null) {
                j |= 64;
            }
            if (C11028au.usePhoneStateDisable() && !TextUtils.isEmpty(C11028au.m24071Ml())) {
                j |= 2;
            }
            if (C11028au.m24070Mm() && !TextUtils.isEmpty(C11028au.m24069Mn())) {
                j |= 4;
            }
            if (C11028au.m24068Mo() && !TextUtils.isEmpty(C11028au.m24067Mp())) {
                j |= 2048;
            }
            if (C11028au.m24064Ms()) {
                if (C11028au.m24063Mt() != null) {
                    j |= 16;
                }
            }
        }
        return j;
    }

    /* renamed from: MY */
    public static String m23909MY() {
        return Build.BRAND;
    }

    /* renamed from: MZ */
    public static synchronized long m23908MZ() {
        long elapsedRealtime;
        synchronized (C11059bi.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    /* renamed from: Na */
    public static synchronized long m23907Na() {
        long j;
        synchronized (C11059bi.class) {
            j = Build.TIME;
        }
        return j;
    }

    /* renamed from: Nb */
    public static synchronized String m23906Nb() {
        String str;
        synchronized (C11059bi.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    /* renamed from: Nc */
    public static synchronized String m23905Nc() {
        synchronized (C11059bi.class) {
            if (!TextUtils.isEmpty(aQs)) {
                return aQs;
            }
            String radioVersion = Build.getRadioVersion();
            aQs = radioVersion;
            return radioVersion;
        }
    }

    /* renamed from: Nd */
    public static synchronized String m23904Nd() {
        String name;
        synchronized (C11059bi.class) {
            name = C11027at.getName();
        }
        return name;
    }

    /* renamed from: Ne */
    public static synchronized String m23903Ne() {
        String version;
        synchronized (C11059bi.class) {
            version = C11027at.getVersion();
        }
        return version;
    }

    /* renamed from: Nf */
    public static String m23902Nf() {
        return Build.MANUFACTURER;
    }

    /* renamed from: Ng */
    public static int m23901Ng() {
        if (aQH == -1) {
            aQH = m23880df(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext()) ? 4 : 3;
        }
        return aQH;
    }

    /* renamed from: Nh */
    public static String m23900Nh() {
        if (TextUtils.isEmpty(aQG)) {
            aQG = System.getProperty("os.arch");
        }
        return aQG;
    }

    /* renamed from: Ni */
    public static int m23899Ni() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: Nj */
    public static String m23898Nj() {
        if (C11028au.m24066Mq() || ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(aQS)) {
            return aQS;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        aQS = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: Nk */
    private static String m23897Nk() {
        try {
            return m23894a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: Nl */
    private static String m23896Nl() {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return null;
        }
        String m23572j = C11137y.m23572j("ksadsdk_pref", SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, null);
        C11137y.m23570k(m23572j, "ksadsdk_pref", SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return m23572j;
    }

    /* renamed from: Nm */
    public static String m23895Nm() {
        if (!TextUtils.isEmpty(aQQ)) {
            return aQQ;
        }
        try {
            String m23738V = C11122q.m23738V(new File("/proc/sys/kernel/random/boot_id"));
            aQQ = TextUtils.isEmpty(m23738V) ? "" : m23738V.substring(0, m23738V.indexOf(ShellAdbUtils.f33810d));
        } catch (Throwable unused) {
        }
        return aQQ;
    }

    /* renamed from: a */
    private static String m23894a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: cA */
    public static synchronized String m23893cA(Context context) {
        synchronized (C11059bi.class) {
            if (context != null) {
                if (!aQJ && TextUtils.isEmpty(aQC) && SystemUtil.m24269cU(context) && !C11028au.usePhoneStateDisable() && C11120o.m23755Lp()) {
                    try {
                        aQC = ((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    aQJ = TextUtils.isEmpty(aQC);
                    return aQC;
                }
            }
            return aQC;
        }
    }

    /* renamed from: cV */
    public static long m23892cV(Context context) {
        if (context == null || ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(1024L)) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: cW */
    public static int m23891cW(Context context) {
        if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(512L)) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((BatteryManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: cX */
    public static long m23890cX(Context context) {
        long j = aQP;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            if (j2 <= 0) {
                j2 = m23916MQ();
            }
            aQP = j2;
            return j2;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: cY */
    private static synchronized String m23889cY(@Nullable Context context) {
        synchronized (C11059bi.class) {
            if (C11028au.usePhoneStateDisable() && !TextUtils.isEmpty(C11028au.m24073Mj())) {
                return C11028au.m24073Mj();
            } else if (aQI) {
                return aQv;
            } else {
                if (TextUtils.isEmpty(aQv) && context != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        return aQv;
                    } else if (C11028au.usePhoneStateDisable()) {
                        return aQv;
                    } else if (!C11120o.m23756Lo()) {
                        return aQv;
                    } else {
                        boolean z = false;
                        try {
                            z = SystemUtil.m24269cU(context);
                            if (z) {
                                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                aQv = deviceId;
                                if (TextUtils.isEmpty(deviceId)) {
                                    aQI = true;
                                }
                            }
                        } catch (Exception e) {
                            C10331c.printStackTrace(e);
                            if (z) {
                                aQI = true;
                            }
                        }
                        return aQv;
                    }
                }
                return aQv;
            }
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: cZ */
    public static synchronized String m23888cZ(@Nullable Context context) {
        TelephonyManager telephonyManager;
        synchronized (C11059bi.class) {
            if (aQN) {
                return aQw;
            }
            if (TextUtils.isEmpty(aQw) && context != null) {
                if (C11028au.usePhoneStateDisable()) {
                    return aQw;
                }
                if (!C11120o.m23757Ln()) {
                    return aQE;
                }
                boolean z = false;
                try {
                    z = SystemUtil.m24269cU(context);
                    if (z && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String meid = telephonyManager.getMeid();
                            aQw = meid;
                            if (TextUtils.isEmpty(meid)) {
                                aQN = true;
                            }
                        } else if (telephonyManager.getPhoneType() == 2) {
                            String deviceId = telephonyManager.getDeviceId();
                            aQw = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                aQN = true;
                            }
                        } else {
                            aQw = null;
                            aQN = true;
                        }
                    }
                } catch (Exception e) {
                    C10331c.printStackTrace(e);
                    if (z) {
                        aQN = true;
                    }
                }
                return aQw;
            }
            return aQw;
        }
    }

    /* renamed from: cd */
    public static String m23887cd(boolean z) {
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        if (interfaceC10968f == null) {
            return "";
        }
        Context context = interfaceC10968f.getContext();
        String m26238bc = C10343a.m26238bc(context);
        return (TextUtils.isEmpty(m26238bc) && !z && TextUtils.isEmpty(m23889cY(context))) ? ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24318yF() : m26238bc;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: cw */
    public static String m23886cw(Context context) {
        if (TextUtils.isEmpty(aQE) && context != null && !aQL) {
            if (C11028au.usePhoneStateDisable()) {
                return C11028au.m24071Ml();
            }
            if (!C11120o.m23762Li()) {
                return aQE;
            }
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                aQE = string;
                if (!m23874gY(string)) {
                    aQE = "";
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(aQE)) {
                aQL = true;
            }
            return aQE;
        }
        return aQE;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: da */
    public static synchronized String[] m23885da(@Nullable Context context) {
        synchronized (C11059bi.class) {
            if (C11028au.usePhoneStateDisable() && C11028au.m24072Mk() != null) {
                return C11028au.m24072Mk();
            } else if (aQM) {
                return aQB;
            } else {
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    return aQB;
                }
                String[] strArr = aQB;
                boolean z = false;
                if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
                    if (C11028au.usePhoneStateDisable()) {
                        return strArr;
                    }
                    if (C11120o.m23756Lo()) {
                        try {
                            boolean m24269cU = SystemUtil.m24269cU(context);
                            if (m24269cU) {
                                try {
                                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                    if (telephonyManager != null) {
                                        if (i >= 26) {
                                            int min = Math.min(m23884db(context), 2);
                                            for (int i2 = 0; i2 < min; i2++) {
                                                aQB[i2] = telephonyManager.getImei(i2);
                                            }
                                            String[] strArr2 = aQB;
                                            if (TextUtils.isEmpty(strArr2[0]) && TextUtils.isEmpty(strArr2[1])) {
                                                aQM = true;
                                            }
                                        } else if (telephonyManager.getPhoneType() == 1) {
                                            if (i >= 23) {
                                                int min2 = Math.min(m23884db(context), 2);
                                                for (int i3 = 0; i3 < min2; i3++) {
                                                    aQB[i3] = telephonyManager.getDeviceId(i3);
                                                }
                                            } else {
                                                strArr[0] = telephonyManager.getDeviceId();
                                                strArr[1] = null;
                                            }
                                            String[] strArr3 = aQB;
                                            if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                                aQM = true;
                                            }
                                        } else {
                                            strArr[0] = null;
                                            strArr[1] = null;
                                            aQM = true;
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    z = m24269cU;
                                    C10331c.printStackTraceOnly(e);
                                    if (z) {
                                        aQM = true;
                                    }
                                    return aQB;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                        return aQB;
                    }
                    return strArr;
                }
                return strArr;
            }
        }
    }

    /* renamed from: db */
    public static synchronized int m23884db(Context context) {
        synchronized (C11059bi.class) {
            if (!aQy && aQx <= 0 && Build.VERSION.SDK_INT >= 23 && context != null && !C11028au.usePhoneStateDisable()) {
                try {
                    aQx = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                } catch (Exception unused) {
                }
                int i = aQx;
                aQy = i == 0;
                return i;
            }
            return aQx;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: dc */
    public static int m23883dc(Context context) {
        if (context != null && aQz <= 0 && !aQA && Build.VERSION.SDK_INT >= 22 && SystemUtil.m24269cU(context) && !C11028au.usePhoneStateDisable()) {
            try {
                aQz = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            } catch (Throwable unused) {
            }
            int i = aQz;
            aQA = i != 0;
            return i;
        }
        return aQz;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: dd */
    public static String m23882dd(Context context) {
        if (TextUtils.isEmpty(aQD) && context != null) {
            if (aQK) {
                return aQD;
            }
            if (C11028au.usePhoneStateDisable()) {
                return aQD;
            }
            if (!C11120o.m23754Lq()) {
                return aQD;
            }
            try {
                if (SystemUtil.m24269cU(context)) {
                    aQD = ((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
                aQD = null;
            }
            if (TextUtils.isEmpty(aQD)) {
                aQK = true;
            }
            String str = TextUtils.isEmpty(aQD) ? "" : aQD;
            aQD = str;
            return str;
        }
        return aQD;
    }

    /* renamed from: de */
    public static synchronized int m23881de(Context context) {
        int ringerMode;
        synchronized (C11059bi.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Exception unused) {
                return -1;
            }
        }
        return ringerMode;
    }

    /* renamed from: df */
    private static boolean m23880df(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: dg */
    public static synchronized String m23879dg(@Nullable Context context) {
        synchronized (C11059bi.class) {
            if (TextUtils.isEmpty(aQt) && context != null && !aQu) {
                if (C11028au.m24070Mm()) {
                    String m24069Mn = C11028au.m24069Mn();
                    aQt = m24069Mn;
                    return m24069Mn;
                } else if (!C11120o.m23761Lj()) {
                    return aQt;
                } else {
                    try {
                        WifiInfo connectionInfo = ((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getConnectionInfo();
                        if (connectionInfo != null) {
                            aQt = connectionInfo.getMacAddress();
                        }
                        if (m23876gW(aQt)) {
                            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                NetworkInterface networkInterface = (NetworkInterface) it.next();
                                if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                                        StringBuilder sb = new StringBuilder();
                                        int length = hardwareAddress.length;
                                        for (int i = 0; i < length; i++) {
                                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                                        }
                                        if (sb.length() > 0) {
                                            sb.deleteCharAt(sb.length() - 1);
                                        }
                                        aQt = sb.toString();
                                    }
                                }
                            }
                        }
                        if (m23876gW(aQt)) {
                            aQt = C10747h.m24943c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                        }
                        if (!m23876gW(aQt)) {
                            aQt = aQt.toUpperCase(Locale.US);
                        }
                    } catch (Exception unused) {
                        aQu = true;
                    }
                    aQu = m23876gW(aQt);
                    return aQt;
                }
            }
            return aQt;
        }
    }

    @Nullable
    /* renamed from: dh */
    public static List<String> m23878dh(@NonNull Context context) {
        String[] list;
        if (C11077c.m23839bF(context)) {
            return new ArrayList();
        }
        if (!m23877di(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return null;
    }

    /* renamed from: di */
    public static boolean m23877di(@NonNull Context context) {
        return context.checkCallingOrSelfPermission(C7282g.f24952j) == 0;
    }

    /* renamed from: gW */
    private static boolean m23876gW(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    /* renamed from: gX */
    private static boolean m23875gX(String str) {
        return aQT.contains(str.toLowerCase(Locale.US));
    }

    /* renamed from: gY */
    private static boolean m23874gY(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: gZ */
    private static void m23873gZ(String str) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return;
        }
        C11137y.m23610a("ksadsdk_pref", SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, str, true);
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(aQF)) {
            return aQF;
        }
        String m23896Nl = m23896Nl();
        if (!TextUtils.isEmpty(m23896Nl)) {
            String str = "ANDROID_" + m23896Nl;
            aQF = str;
            return str;
        }
        String m23886cw = m23886cw(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext());
        if (!TextUtils.isEmpty(m23886cw) && !m23875gX(m23886cw) && m23874gY(m23886cw)) {
            String str2 = "ANDROID_" + m23886cw;
            aQF = str2;
            return str2;
        }
        String m23897Nk = m23897Nk();
        if (!TextUtils.isEmpty(m23897Nk)) {
            aQF = "ANDROID_" + m23897Nk;
            m23873gZ(m23897Nk);
            return aQF;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: ha */
    public static String m23872ha(String str) {
        String valueOf;
        if (TextUtils.isEmpty(aQR) && !TextUtils.isEmpty(str)) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                try {
                    StructStat stat = Os.stat(str);
                    if (stat == null) {
                        return aQR;
                    }
                    String str2 = "";
                    if (i >= 27) {
                        StructTimespec structTimespec = stat.st_atim;
                        if (structTimespec == null) {
                            valueOf = "";
                        } else {
                            str2 = String.valueOf(structTimespec.tv_sec);
                            valueOf = String.valueOf(stat.st_atim.tv_nsec);
                        }
                        aQR = str2 + "." + valueOf;
                    } else {
                        long j = stat.st_atime;
                        if (j != 0) {
                            str2 = String.valueOf(j);
                        }
                        aQR = str2;
                    }
                } catch (Exception e) {
                    C10331c.printStackTrace(e);
                }
            }
            return aQR;
        }
        return aQR;
    }

    /* renamed from: u */
    public static String m23871u(@Nullable Context context, boolean z) {
        if (C11028au.usePhoneStateDisable() && !TextUtils.isEmpty(C11028au.m24073Mj())) {
            return C11028au.m24073Mj();
        }
        String m23889cY = m23889cY(context);
        return (TextUtils.isEmpty(m23889cY) && !z && TextUtils.isEmpty(C10343a.m26238bc(context))) ? ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24319yE() : m23889cY;
    }
}
