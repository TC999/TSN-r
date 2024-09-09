package com.bytedance.sdk.openadsdk.core.eq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.OsConstants;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.acse.ottn.c4;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.sdk.component.utils.ls;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {

    /* renamed from: c  reason: collision with root package name */
    private static String f33245c;
    private static volatile long fz;

    /* renamed from: i  reason: collision with root package name */
    private static volatile String f33247i;
    private static volatile long ia;

    /* renamed from: j  reason: collision with root package name */
    private static volatile String f33248j;
    private static volatile long ls;

    /* renamed from: q  reason: collision with root package name */
    private static volatile long f33252q;

    /* renamed from: t  reason: collision with root package name */
    private static volatile long f33255t;

    /* renamed from: u  reason: collision with root package name */
    private static volatile String f33256u;

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f33257w;
    private static volatile boolean xv;
    private static volatile long ys;
    private static AtomicBoolean sr = new AtomicBoolean(false);
    private static AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private static AtomicInteger f33246f = new AtomicInteger(-1);

    /* renamed from: r  reason: collision with root package name */
    private static volatile boolean f33253r = true;
    private static long ev = 0;
    private static volatile long gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private static volatile int f33251p = -1;

    /* renamed from: k  reason: collision with root package name */
    private static volatile int f33249k = -1;

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f33244a = null;
    private static volatile String bk = null;
    private static volatile float fp = -2.0f;

    /* renamed from: s  reason: collision with root package name */
    private static volatile int f33254s = -1;
    private static volatile long gb = -1;

    /* renamed from: n  reason: collision with root package name */
    private static volatile long f33250n = System.currentTimeMillis();
    private static volatile int ck = -1;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getBooleanExtra("present", false)) {
                    int intExtra = intent.getIntExtra("status", -1);
                    if (intExtra == -1) {
                        w.f33259c = intExtra;
                    } else if (intExtra == 2) {
                        w.f33259c = 1;
                    } else {
                        w.f33259c = 0;
                    }
                } else {
                    w.f33259c = 2;
                }
                w.f33260w = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                com.bytedance.sdk.component.utils.ev.c().post(new com.bytedance.sdk.component.gd.p("tt_vol") { // from class: com.bytedance.sdk.openadsdk.core.eq.gd.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.ls.getContext().getSystemService("audio");
                            if (audioManager == null) {
                                return;
                            }
                            int unused = gd.ck = audioManager.getStreamVolume(3);
                        } catch (Exception unused2) {
                        }
                    }
                });
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class sr extends BroadcastReceiver {
        sr() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = gd.f33253r = true;
                com.bytedance.sdk.component.utils.a.xv("DeviceUtils", "screen_on");
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = gd.f33253r = false;
                com.bytedance.sdk.component.utils.a.xv("DeviceUtils", "screen_off");
                com.bytedance.sdk.component.panglearmor.c.w.c().w(intent.getAction());
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = gd.f33250n = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        static int f33259c = -1;

        /* renamed from: w  reason: collision with root package name */
        static float f33260w;

        public static int c() {
            return f33259c;
        }

        public static float w() {
            return f33260w;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class xv implements ls.c {
        xv() {
        }

        @Override // com.bytedance.sdk.component.utils.ls.c
        public void c(Context context, Intent intent, boolean z3, int i4) {
            if (gd.f33246f.get() == i4) {
                return;
            }
            gd.f33246f.set(i4);
            gd.sr.set(true);
            gd.ux.set(true);
            com.bytedance.sdk.component.panglearmor.c.w.c().c(i4);
        }
    }

    public static void a() {
        Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        if (context != null) {
            int a4 = wv.a();
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("cpu_cnt", a4);
            wv.f33342c = a4;
            int xv2 = wv.xv(wv.a());
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("cpu_max_freq", xv2);
            wv.f33350w = xv2;
            int sr2 = wv.sr(wv.a());
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("cpu_min_freq", sr2);
            wv.xv = sr2;
            String ux2 = wv.ux(context, "MemTotal");
            if (ux2 != null) {
                com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("total_memory", ux2);
                wv.sr = ux2;
            }
            long fp2 = wv.fp();
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("internal_storage", fp2);
            wv.ux = fp2;
            long c4 = com.bytedance.sdk.component.utils.bk.c();
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("free_storage", c4);
            wv.f33343f = c4;
            long ia2 = wv.ia();
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("sdcard_storage", ia2);
            wv.f33346r = ia2;
            boolean s3 = wv.s();
            com.bytedance.sdk.openadsdk.core.xv.ux.c().c("is_root", s3 ? 1 : 0);
            wv.ev = s3 ? 1 : 0;
        }
    }

    public static long bk() {
        if (gb != -1) {
            return gb;
        }
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().w("dev19", -1L);
    }

    public static boolean c() {
        if (!f33253r && SystemClock.elapsedRealtime() - ev >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            ev = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.ls.getContext().getSystemService("power");
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        f33253r = powerManager.isInteractive();
                    } else {
                        f33253r = powerManager.isScreenOn();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return f33253r;
    }

    public static String ev() {
        if (s()) {
            return f33247i;
        }
        return fz()[1];
    }

    public static String[] f() {
        return s() ? new String[]{f33256u, f33247i} : fz();
    }

    private static String[] fz() {
        String[] strArr = {"", ""};
        if (sr.getAndSet(false)) {
            strArr = u();
        }
        String xv2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("dev13", 3600000L);
        String xv3 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("dev15", 3600000L);
        if (TextUtils.isEmpty(xv2) && TextUtils.isEmpty(xv3)) {
            strArr = u();
            f33256u = strArr[0];
            f33247i = strArr[1];
            f33252q = System.currentTimeMillis();
            return strArr;
        }
        String xv4 = com.bytedance.sdk.component.utils.c.xv(xv2);
        strArr[0] = xv4;
        String xv5 = com.bytedance.sdk.component.utils.c.xv(xv3);
        strArr[1] = xv5;
        f33256u = xv4;
        f33247i = xv5;
        f33252q = System.currentTimeMillis();
        return strArr;
    }

    public static String gd() {
        if (Build.VERSION.SDK_INT >= 21) {
            String languageTag = Locale.getDefault().toLanguageTag();
            return !TextUtils.isEmpty(languageTag) ? languageTag : "";
        }
        return Locale.getDefault().getLanguage();
    }

    private static String[] i() {
        String[] strArr = {"", ""};
        if (q()) {
            try {
                boolean z3 = false;
                boolean z4 = false;
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    for (InetAddress inetAddress : c(networkInterface)) {
                        boolean z5 = inetAddress instanceof Inet4Address;
                        if (!z5 || !z3) {
                            if (z5 || !z4) {
                                if (w(z5, inetAddress, strArr)) {
                                    if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                        return strArr;
                                    }
                                } else {
                                    String hostAddress = inetAddress.getHostAddress();
                                    if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                        if (z5) {
                                            com.bytedance.sdk.openadsdk.core.xv.ux.c().gb(com.bytedance.sdk.component.utils.c.w(hostAddress));
                                            strArr[0] = hostAddress;
                                            if (z4) {
                                                return strArr;
                                            }
                                            z3 = true;
                                        } else {
                                            int indexOf = hostAddress.indexOf(37);
                                            if (indexOf >= 0) {
                                                hostAddress = hostAddress.substring(0, indexOf);
                                            }
                                            if (xv(hostAddress)) {
                                                com.bytedance.sdk.openadsdk.core.xv.ux.c().n(com.bytedance.sdk.component.utils.c.w(hostAddress));
                                                strArr[1] = hostAddress;
                                                if (z3) {
                                                    return strArr;
                                                }
                                                z4 = true;
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return strArr;
        }
        return strArr;
    }

    public static int k() {
        if (f33254s != -1 && !c(fz, 60000L)) {
            return f33254s;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.ls.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        f33254s = accessibilityManager.isEnabled() ? 1 : 0;
        fz = System.currentTimeMillis();
        return f33254s;
    }

    public static float p() {
        if (fp != -2.0f && !c(ia, (long) PolicyConfig.mServerBusyRetryBaseInternal)) {
            return fp;
        }
        int i4 = -1;
        try {
            Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
            if (context != null) {
                i4 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.f("DeviceUtils", th.getMessage());
        }
        if (i4 < 0) {
            fp = -1.0f;
        } else {
            fp = Math.round((i4 / 255.0f) * 10.0f) / 10.0f;
        }
        ia = System.currentTimeMillis();
        return fp;
    }

    private static boolean q() {
        if (com.bytedance.sdk.openadsdk.core.ls.w().d()) {
            try {
                JSONArray jSONArray = new JSONArray(com.bytedance.sdk.openadsdk.core.k.sr().bk());
                int length = jSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null && !optJSONObject.isNull("name") && "tt_inner_isw".equals(optJSONObject.optString("name"))) {
                        return optJSONObject.optBoolean("value", true);
                    }
                }
            } catch (JSONException unused) {
            }
            return true;
        }
        return true;
    }

    public static String r() {
        if (s()) {
            return f33256u;
        }
        return fz()[0];
    }

    private static boolean s() {
        return (sr.get() || c(f33252q, 1800000L) || TextUtils.isEmpty(f33256u)) ? false : true;
    }

    public static int sr() {
        if (f33251p == -1 || SystemClock.elapsedRealtime() - gd >= 60000) {
            gd = SystemClock.elapsedRealtime();
            f33251p = com.bytedance.sdk.component.utils.ys.w(com.bytedance.sdk.openadsdk.core.ls.getContext());
        }
        return f33251p;
    }

    public static int t() {
        if (ck >= 0) {
            return ck;
        }
        try {
            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.ls.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0;
            }
            ck = audioManager.getStreamVolume(3);
            return ck;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String[] u() {
        String[] i4 = i();
        if (TextUtils.isEmpty(i4[0]) && TextUtils.isEmpty(i4[1])) {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().gb("");
        }
        return i4;
    }

    public static int ux() {
        if (f33251p == -1 || ux.getAndSet(false)) {
            f33251p = com.bytedance.sdk.component.utils.ys.w(com.bytedance.sdk.openadsdk.core.ls.getContext());
        }
        return f33251p;
    }

    public static void xv() {
        f33246f.set(com.bytedance.sdk.component.utils.ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext()));
        sr();
        p();
        k();
        c(0);
        c(1);
        f();
        c((String) null);
    }

    public static long w() {
        return f33250n;
    }

    public static void f(Context context) {
        com.bytedance.sdk.component.utils.ls.c(new xv(), context);
    }

    public static void ux(Context context) {
        if (xv) {
            return;
        }
        try {
            c cVar = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(cVar, intentFilter);
            xv = true;
        } catch (Throwable unused) {
        }
    }

    public static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("dev14", com.bytedance.sdk.component.utils.c.w(str));
        f33248j = str;
        ls = System.currentTimeMillis();
    }

    public static JSONObject sr(Context context) {
        return com.bytedance.sdk.openadsdk.core.xv.c.c(context, -1);
    }

    private static String sr(int i4) {
        List<CellInfo> allCellInfo;
        int dbm;
        WifiInfo w3;
        int xv2 = com.bytedance.sdk.component.utils.ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext());
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = com.bytedance.sdk.openadsdk.core.k.sr().ux();
        if (xv2 == 4) {
            if (i4 == 0) {
                try {
                    if (ux2.sr() && (w3 = com.bytedance.sdk.openadsdk.core.i.w()) != null) {
                        return w3.getRssi() + "dBm";
                    }
                    return "unknown";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (ux2.xv() && ux2.c() && i4 == 1) {
            try {
                if (com.bytedance.sdk.openadsdk.core.i.t()) {
                    TelephonyManager c4 = com.bytedance.sdk.openadsdk.core.i.c();
                    int i5 = Build.VERSION.SDK_INT;
                    if (c4 == null || (allCellInfo = c4.getAllCellInfo()) == null) {
                        return "unknown";
                    }
                    CellInfo cellInfo = allCellInfo.get(0);
                    if (cellInfo instanceof CellInfoGsm) {
                        dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoLte) {
                        dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    } else if (i5 >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (i5 >= 29 && (cellInfo instanceof CellInfoNr)) {
                        dbm = ((CellInfoNr) cellInfo).getCellSignalStrength().getDbm();
                    } else if (i5 >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                        dbm = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getDbm();
                    }
                    if (Integer.MIN_VALUE == dbm) {
                        return "unknown";
                    }
                    return dbm + "dBm";
                }
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }

    public static void c(Context context) {
        if (f33257w) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                f33253r = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            sr srVar = new sr();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(srVar, intentFilter);
            f33257w = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static boolean w(boolean z3, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z3) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (z3 || TextUtils.isEmpty(strArr[1])) {
            if (Build.VERSION.SDK_INT < 24) {
                return c(z3, inetAddress, strArr);
            }
            if (z3) {
                declaredField = InetAddress.class.getDeclaredField("holder");
            } else {
                declaredField = Inet6Address.class.getDeclaredField("holder6");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(inetAddress);
            Class<?> cls = obj.getClass();
            if (z3) {
                Field declaredField2 = cls.getDeclaredField("address");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
                byte[] bArr = {(byte) ((intValue >>> 24) & 255), (byte) ((intValue >>> 16) & 255), (byte) ((intValue >>> 8) & 255), (byte) (intValue & 255)};
                String w3 = w(bArr);
                if (bArr[0] != Byte.MAX_VALUE) {
                    strArr[0] = w3;
                }
            } else {
                Field declaredField3 = cls.getDeclaredField("ipaddress");
                declaredField3.setAccessible(true);
                Object obj3 = declaredField3.get(obj);
                if (obj3 instanceof byte[]) {
                    String c4 = c((byte[]) obj3);
                    if (!xv(c4)) {
                        return true;
                    }
                    strArr[1] = c4;
                }
            }
            return true;
        }
        return true;
    }

    private static boolean xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        if ((charAt == '2' || charAt == '3' || charAt == '5') && str.length() >= 2) {
            char charAt2 = str.charAt(1);
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 < 'a' || charAt2 > 'f') {
                    return charAt2 >= 'A' && charAt2 <= 'F';
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean xv(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(f33248j) && !c(ls, 1800000L)) {
            return f33248j;
        }
        String xv2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("dev14", 1800000L);
        if (TextUtils.isEmpty(xv2)) {
            if (str == null) {
                str = r();
            }
            f33248j = str;
        } else {
            f33248j = com.bytedance.sdk.component.utils.c.xv(xv2);
        }
        ls = System.currentTimeMillis();
        return f33248j;
    }

    public static String[] c(boolean z3) throws JSONException {
        long j4;
        String str;
        String str2;
        if (s()) {
            return new String[]{f33256u, f33247i};
        }
        String[] strArr = {"", ""};
        String i4 = com.bytedance.sdk.openadsdk.core.xv.ux.c().i();
        long j5 = 0;
        String str3 = null;
        if (i4 != null) {
            JSONObject jSONObject = new JSONObject(i4);
            str = com.bytedance.sdk.component.utils.c.xv(jSONObject.getString("value"));
            j4 = jSONObject.getLong("time");
        } else {
            j4 = 0;
            str = null;
        }
        String q3 = com.bytedance.sdk.openadsdk.core.xv.ux.c().q();
        if (q3 != null) {
            JSONObject jSONObject2 = new JSONObject(q3);
            str2 = com.bytedance.sdk.component.utils.c.xv(jSONObject2.getString("value"));
            j5 = jSONObject2.getLong("time");
        } else {
            str2 = null;
        }
        if (str != null || str2 != null) {
            strArr[0] = str;
            strArr[1] = str2;
            if (z3) {
                return strArr;
            }
        }
        if (sr.getAndSet(false)) {
            strArr = u();
            if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1])) {
                if (str == null) {
                    str = "";
                }
                strArr[0] = str;
                strArr[1] = str2 != null ? str2 : "";
            }
        } else {
            if (str != null && System.currentTimeMillis() - j4 > 3600000) {
                str = null;
            }
            if (str2 == null || System.currentTimeMillis() - j5 <= 3600000) {
                str3 = str2;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
                strArr = u();
            } else {
                strArr[0] = str;
                strArr[1] = str3;
            }
        }
        f33256u = strArr[0];
        f33247i = strArr[1];
        f33252q = System.currentTimeMillis();
        return strArr;
    }

    private static String w(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static boolean w(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject w(int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.sdk.openadsdk.core.k.sr().ev());
            jSONObject.put("name", com.bytedance.sdk.openadsdk.core.k.sr().gd());
            w(jSONObject);
            com.bytedance.sdk.openadsdk.t.c.c(jSONObject, i4);
            jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.k.sr().p());
            if (!com.bytedance.sdk.openadsdk.core.xv.ux.c().k(i4)) {
                jSONObject.put("network_speed", com.bytedance.sdk.openadsdk.core.q.c.c());
            }
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.r.c.ev());
            jSONObject.put("useful_open_sdk", com.bytedance.sdk.openadsdk.core.w.c.w.ev.xv().w());
            jSONObject.put("real_app_name", com.bytedance.sdk.openadsdk.core.r.c.w(com.bytedance.sdk.openadsdk.core.ls.getContext()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void w(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", wv.ev());
            jSONObject.put("version_code", wv.gd());
            jSONObject.put("version", wv.p());
        } catch (Exception unused) {
        }
    }

    private static List<InetAddress> c(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            if (Build.VERSION.SDK_INT < 24) {
                Object c4 = j.c(networkInterface, "java.net.NetworkInterface", "addresses", null);
                if (!(c4 instanceof List)) {
                    return Collections.list(networkInterface.getInetAddresses());
                }
                return (List) c4;
            }
            Object c5 = j.c(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(c5 instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) c5);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean c(boolean z3, InetAddress inetAddress, String[] strArr) {
        if (z3) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (z3 || TextUtils.isEmpty(strArr[1])) {
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Field declaredField = cls.getDeclaredField("os");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Method method = obj.getClass().getMethod("getnameinfo", InetAddress.class, Integer.TYPE);
            method.setAccessible(true);
            Object invoke = method.invoke(obj, inetAddress, Integer.valueOf(OsConstants.NI_NUMERICHOST));
            if (invoke == null) {
                return false;
            }
            String str = (String) invoke;
            if (str.startsWith("127")) {
                return true;
            }
            if (z3) {
                strArr[0] = str;
                return true;
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            if (xv(str)) {
                strArr[1] = str;
                return true;
            }
            return true;
        }
        return true;
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i4 << 1;
            sb.append(Integer.toHexString(((bArr[i5] << 8) & 65280) | (bArr[i5 + 1] & 255)));
            if (i4 < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    public static int c(Context context, boolean z3) {
        if (f33249k != -1) {
            return f33249k;
        }
        if (z3) {
            String xv2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("dev06", 2592000000L);
            try {
                if (!TextUtils.isEmpty(xv2)) {
                    f33249k = Integer.parseInt(xv2);
                }
            } catch (Exception unused) {
            }
            if (f33249k != -1) {
                return f33249k;
            }
        }
        if (xv(context)) {
            f33249k = 3;
        } else if (w(context)) {
            f33249k = 2;
        } else {
            f33249k = 1;
        }
        if (z3) {
            com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("dev06", String.valueOf(f33249k));
        }
        return f33249k;
    }

    public static void c(JSONObject jSONObject) throws JSONException {
        if (a.w()) {
            jSONObject.putOpt("os_new", c4.f5363a);
            jSONObject.putOpt("harmonyos_api", a.ux());
            jSONObject.putOpt("harmonyos_version", a.f());
            jSONObject.putOpt("harmonyos_release_type", a.r());
            jSONObject.putOpt("harmonyos_build_version", a.ev());
            jSONObject.putOpt("pure_mode", Integer.valueOf(a.c(com.bytedance.sdk.openadsdk.core.ls.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static String c(int i4) {
        if (i4 == 0 && !TextUtils.isEmpty(f33244a) && !c(f33255t, 60000L)) {
            return f33244a;
        }
        if (i4 == 1 && !TextUtils.isEmpty(bk) && !c(ys, 60000L)) {
            return bk;
        }
        String sr2 = sr(i4);
        if (i4 == 0) {
            f33244a = sr2;
            f33255t = System.currentTimeMillis();
        } else if (i4 == 1) {
            bk = sr2;
            ys = System.currentTimeMillis();
        }
        return sr2;
    }

    private static boolean c(long j4, long j5) {
        return System.currentTimeMillis() - j4 > j5;
    }

    public static void c(long j4) {
        if (j4 == -1 || gb == j4) {
            return;
        }
        gb = j4;
        com.bytedance.sdk.openadsdk.core.xv.ux.c().c("dev19", j4);
    }
}
