package com.mbridge.msdk.optimize;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.acse.ottn.f3;
import com.mbridge.msdk.optimize.a.a.c;
import com.mbridge.msdk.optimize.a.a.d;
import com.mbridge.msdk.optimize.a.a.e;
import com.mbridge.msdk.optimize.a.a.f;
import com.mbridge.msdk.optimize.a.a.g;
import com.mbridge.msdk.optimize.a.a.h;
import com.mbridge.msdk.optimize.a.a.i;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SensitiveDataUtil {
    private static String androidID;
    private static String deviceid;
    private static String imsi;
    private static boolean isAcquireAndroidId;
    private static boolean isAcquireIMEI;
    private static boolean isAcquireMac;
    private static boolean isAcquireOAID;
    private static boolean isAcquiredIMSI;
    private static String mSelfId;
    private static String macAddress;
    private static String oaid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        private static Object f40373e;

        /* renamed from: f  reason: collision with root package name */
        private static Class<?> f40374f;

        /* renamed from: g  reason: collision with root package name */
        private static Method f40375g;

        /* renamed from: h  reason: collision with root package name */
        private static Method f40376h;

        /* renamed from: i  reason: collision with root package name */
        private static Method f40377i;

        /* renamed from: j  reason: collision with root package name */
        private static Method f40378j;

        /* renamed from: a  reason: collision with root package name */
        final String f40379a;

        /* renamed from: b  reason: collision with root package name */
        final String f40380b;

        /* renamed from: c  reason: collision with root package name */
        final String f40381c;

        /* renamed from: d  reason: collision with root package name */
        final String f40382d;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f40374f = cls;
                f40373e = cls.newInstance();
                f40375g = f40374f.getMethod("getUDID", Context.class);
                f40376h = f40374f.getMethod("getOAID", Context.class);
                f40377i = f40374f.getMethod("getVAID", Context.class);
                f40378j = f40374f.getMethod("getAAID", Context.class);
            } catch (Throwable unused) {
            }
        }

        a(Context context) {
            this.f40379a = a(context, f40375g);
            this.f40380b = a(context, f40376h);
            this.f40381c = a(context, f40377i);
            this.f40382d = a(context, f40378j);
        }

        private static String a(Context context, Method method) {
            Object obj = f40373e;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static String getAndroidID(Context context) {
        if (isAcquireAndroidId) {
            return androidID;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            androidID = string;
            if (string == null) {
                androidID = "";
            }
        } catch (Exception unused) {
            androidID = "";
        }
        isAcquireAndroidId = true;
        return androidID;
    }

    private static void getFormNewThread(final Context context, final String str) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.optimize.SensitiveDataUtil.1
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.optimize.a.b bVar = new com.mbridge.msdk.optimize.a.b() { // from class: com.mbridge.msdk.optimize.SensitiveDataUtil.1.1
                    @Override // com.mbridge.msdk.optimize.a.b
                    public final void a(String str2) {
                    }

                    @Override // com.mbridge.msdk.optimize.a.b
                    public final void a(String str2, boolean z3) {
                        String unused = SensitiveDataUtil.oaid = str2;
                    }
                };
                if ("ASUS".equals(str)) {
                    new com.mbridge.msdk.optimize.a.a.a(context).a(bVar);
                } else if (BaseConstants.ROM_OPPO_UPPER_CONSTANT.equals(str)) {
                    new f(context).a(bVar);
                } else if ("ONEPLUS".equals(str)) {
                    new e(context).a(bVar);
                } else if (!"ZTE".equals(str) && !"FERRMEOS".equals(str) && !"SSUI".equals(str)) {
                    if ("HUAWEI".equals(str)) {
                        new com.mbridge.msdk.optimize.a.a(context).a(bVar);
                    } else if ("SAMSUNG".equals(str)) {
                        new g(context).a(bVar);
                    } else if (!"LENOVO".equals(str) && !"MOTOLORA".equals(str)) {
                        if ("MEIZU".equals(str)) {
                            new c(context).a(bVar);
                        }
                    } else {
                        new com.mbridge.msdk.optimize.a.a.b(context).a(bVar);
                    }
                } else {
                    new i(context).a(bVar);
                }
            }
        }).start();
    }

    public static String getIMEI(Context context) {
        if (isAcquireIMEI) {
            return deviceid;
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            deviceid = deviceId;
            if (deviceId == null) {
                deviceid = "";
            }
        } catch (Throwable unused) {
            deviceid = "";
        }
        isAcquireIMEI = true;
        return deviceid;
    }

    public static String getImsi(Context context) {
        if (isAcquiredIMSI) {
            return imsi;
        }
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            imsi = subscriberId;
            if (subscriberId == null) {
                imsi = "";
            }
        } catch (Exception unused) {
            imsi = "";
        }
        isAcquiredIMSI = true;
        return imsi;
    }

    private static String getMac() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i4])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return "";
    }

    public static String getMacAddress(Context context) {
        String macAddress2;
        if (isAcquireMac) {
            return macAddress;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                macAddress2 = getMac();
            } else {
                macAddress2 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            }
            if (macAddress2 == null) {
                return "";
            }
            String lowerCase = macAddress2.replaceAll(":", "").toLowerCase();
            macAddress = lowerCase;
            isAcquireMac = true;
            return lowerCase;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getOaid(Context context) {
        String str;
        if (isAcquireOAID) {
            return oaid;
        }
        if (!TextUtils.isEmpty(oaid)) {
            return oaid;
        }
        try {
            str = new a(context).f40380b;
            oaid = str;
        } catch (Throwable unused) {
            oaid = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return oaid;
        }
        String str2 = Build.MANUFACTURER;
        if (isFreeMeOS()) {
            str2 = "FERRMEOS";
        } else if (isSSUIOS()) {
            str2 = "SSUI";
        }
        if (!TextUtils.isEmpty(str2)) {
            String upperCase = str2.toUpperCase();
            if (Arrays.asList("ASUS", "HUAWEI", BaseConstants.ROM_OPPO_UPPER_CONSTANT, "ONEPLUS", "ZTE", "FERRMEOS", "SSUI", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO").contains(upperCase)) {
                getFormNewThread(context, upperCase);
            } else if ("VIVO".equals(upperCase)) {
                oaid = new h(context).a();
            } else if ("NUBIA".equals(upperCase)) {
                oaid = new d(context).a();
            }
        }
        isAcquireOAID = true;
        return oaid;
    }

    private static String getProperty(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSelfId(Context context) {
        if (mSelfId == null) {
            File file = new File(Environment.getExternalStorageDirectory().toString(), "/.a/track_id.bin");
            try {
                if (!file.exists()) {
                    mSelfId = writeInstallationFile(context, file);
                } else {
                    mSelfId = readInstallationFile(file);
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        String str = mSelfId;
        return str == null ? "" : str;
    }

    public static boolean isFreeMeOS() {
        String property = getProperty("ro.build.freeme.label");
        return !TextUtils.isEmpty(property) && property.equalsIgnoreCase("FREEMEOS");
    }

    public static boolean isSSUIOS() {
        String property = getProperty("ro.ssui.product");
        return (TextUtils.isEmpty(property) || property.equalsIgnoreCase("unknown")) ? false : true;
    }

    private static String readInstallationFile(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr);
            randomAccessFile.close();
            return str;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        }
    }

    private static void writeFile(Context context, File file, String str) throws IOException {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
        }
        try {
            fileOutputStream.write(str.getBytes());
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
    }

    private static String writeInstallationFile(Context context, File file) throws IOException {
        UUID randomUUID = UUID.randomUUID();
        writeFile(context, file, randomUUID.toString());
        return randomUUID.toString();
    }
}
