package com.beizi.p051ad.internal.utilities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.beizi.p051ad.p056c.EnumType;
import java.util.Locale;

/* renamed from: com.beizi.ad.internal.utilities.DeviceInfo */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DeviceInfo {
    public static String SDK_UID_KEY = "SDK_UID_KEY";
    public static String SDK_UID_KEY_NEW = "SDK_UID_KEY_NEW";
    public static String density;
    public static String harddiskSizeByte;
    public static String physicalMemoryByte;
    private static DeviceInfo sDeviceInfoInstance;
    public String agVercode;
    public String bootMark;
    public String hmsCoreVersion;
    public String romVersion;
    public String root;
    public String updateMark;
    public boolean wxInstalled;
    public String sdkUID = null;
    public boolean firstLaunch = false;

    /* renamed from: os */
    public final String f10413os = Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
    public EnumType.EnumC2813b devType = EnumType.EnumC2813b.DEVICE_OTHER;
    public final String brand = Build.BRAND;
    public final String model = Build.MODEL;
    public final String manufacturer = Build.MANUFACTURER;
    public String resolution = null;
    public String screenSize = null;
    public final String language = Locale.getDefault().getLanguage();

    static {
        try {
            System.loadLibrary("devInfo");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        sDeviceInfoInstance = null;
    }

    private DeviceInfo() {
    }

    public static DeviceInfo getInstance() {
        DeviceInfo deviceInfo;
        synchronized (DeviceInfo.class) {
            if (sDeviceInfoInstance == null) {
                sDeviceInfoInstance = new DeviceInfo();
                HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.init));
                density = BeiZiImpl.m49492a().f10139i.getResources().getDisplayMetrics().density + "";
                physicalMemoryByte = SystemUtil.m49020m(BeiZiImpl.m49492a().f10139i);
                harddiskSizeByte = SystemUtil.m49034b();
            }
            deviceInfo = sDeviceInfoInstance;
        }
        return deviceInfo;
    }

    public native String getBootMark();

    public long getInstallDate(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long getLastUpdateTime(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:3:0x0007, B:6:0x0025, B:14:0x0041, B:16:0x0059, B:18:0x0071, B:20:0x0085, B:22:0x008b, B:23:0x009b, B:12:0x003c), top: B:28:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085 A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:3:0x0007, B:6:0x0025, B:14:0x0041, B:16:0x0059, B:18:0x0071, B:20:0x0085, B:22:0x008b, B:23:0x009b, B:12:0x003c), top: B:28:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getMarks(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "BeiZisAd"
            java.lang.String r2 = "SystemMarkStatus"
            r3 = 0
            int r4 = com.beizi.p051ad.internal.utilities.SPUtils.getInt(r12, r2, r3)     // Catch: java.lang.Throwable -> Lc5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5
            r5.<init>()     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r6 = "getMarks status= "
            r5.append(r6)     // Catch: java.lang.Throwable -> Lc5
            r5.append(r4)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lc5
            android.util.Log.e(r1, r5)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r5 = "SystemMarkStatusExpireTime"
            r6 = 3
            r7 = 1
            if (r4 != r7) goto L34
            com.beizi.p051ad.internal.utilities.SPUtils.putInt(r12, r2, r6)     // Catch: java.lang.Throwable -> Lc5
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc5
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> Lc5
            com.beizi.p051ad.internal.utilities.SPUtils.put(r12, r5, r4)     // Catch: java.lang.Throwable -> Lc5
            r4 = 3
        L34:
            r8 = 2
            if (r4 == 0) goto L3c
            if (r4 != r8) goto L3a
            goto L3c
        L3a:
            r7 = r4
            goto L3f
        L3c:
            com.beizi.p051ad.internal.utilities.SPUtils.putInt(r12, r2, r7)     // Catch: java.lang.Throwable -> Lc5
        L3f:
            if (r7 != r6) goto L85
            long r6 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object r4 = com.beizi.p051ad.internal.utilities.SPUtils.get(r12, r5, r4)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Long r4 = (java.lang.Long) r4     // Catch: java.lang.Throwable -> Lc5
            long r6 = r4.longValue()     // Catch: java.lang.Throwable -> Lc5
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L84
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc5
            long r8 = r4.longValue()     // Catch: java.lang.Throwable -> Lc5
            long r6 = r6 - r8
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> Lc5
            long r6 = r4.longValue()     // Catch: java.lang.Throwable -> Lc5
            r8 = -1702967296(0xffffffff9a7ec800, double:NaN)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L84
            com.beizi.p051ad.internal.utilities.SPUtils.putInt(r12, r2, r3)     // Catch: java.lang.Throwable -> Lc5
            long r2 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lc5
            com.beizi.p051ad.internal.utilities.SPUtils.put(r12, r5, r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r12 = "bootMark expireTime= null and status = 0"
            android.util.Log.d(r1, r12)     // Catch: java.lang.Throwable -> Lc5
        L84:
            return
        L85:
            java.lang.String r0 = r11.getBootMark()     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto L9b
            r4 = 36
            int r5 = r0.length()     // Catch: java.lang.Throwable -> Lc5
            int r4 = java.lang.Math.min(r4, r5)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = r0.substring(r3, r4)     // Catch: java.lang.Throwable -> Lc5
            r11.bootMark = r0     // Catch: java.lang.Throwable -> Lc5
        L9b:
            java.lang.String r0 = r11.getUpdateMark()     // Catch: java.lang.Throwable -> Lc5
            r11.updateMark = r0     // Catch: java.lang.Throwable -> Lc5
            com.beizi.p051ad.internal.utilities.SPUtils.putInt(r12, r2, r8)     // Catch: java.lang.Throwable -> Lc5
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5
            r12.<init>()     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = "bootMark = "
            r12.append(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = r11.bootMark     // Catch: java.lang.Throwable -> Lc5
            r12.append(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = ",updateMark = "
            r12.append(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = r11.updateMark     // Catch: java.lang.Throwable -> Lc5
            r12.append(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lc5
            android.util.Log.e(r1, r12)     // Catch: java.lang.Throwable -> Lc5
            goto Le1
        Lc5:
            r12 = move-exception
            r12.printStackTrace()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Exception："
            r0.append(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r1, r12)
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.utilities.DeviceInfo.getMarks(android.content.Context):void");
    }

    public String getPackName(Context context) {
        return context.getPackageName();
    }

    public String getPlatform() {
        return "Android";
    }

    public String getRomVersion() {
        if (!TextUtils.isEmpty(this.romVersion)) {
            return this.romVersion;
        }
        try {
            OEMSystemInfo oEMSystemInfo = OEMSystemInfo.getInstance();
            oEMSystemInfo.initializeOEMInfo();
            this.romVersion = oEMSystemInfo.getRomVersion();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.romVersion;
    }

    public native String getUpdateMark();
}
