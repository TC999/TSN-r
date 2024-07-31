package com.mbridge.msdk.optimize;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mbridge.msdk.optimize.p498a.OaidAidlUtil;
import com.mbridge.msdk.optimize.p498a.OaidCallback;
import com.mbridge.msdk.optimize.p498a.p499a.ASUSDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.LenovoDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.MeizuDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.NubiaDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.OnePlusDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.OppoDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.SamsungDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.VivoDeviceHelper;
import com.mbridge.msdk.optimize.p498a.p499a.ZTEDeviceHelper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
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
    /* renamed from: com.mbridge.msdk.optimize.SensitiveDataUtil$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11519a {

        /* renamed from: e */
        private static Object f31600e;

        /* renamed from: f */
        private static Class<?> f31601f;

        /* renamed from: g */
        private static Method f31602g;

        /* renamed from: h */
        private static Method f31603h;

        /* renamed from: i */
        private static Method f31604i;

        /* renamed from: j */
        private static Method f31605j;

        /* renamed from: a */
        final String f31606a;

        /* renamed from: b */
        final String f31607b;

        /* renamed from: c */
        final String f31608c;

        /* renamed from: d */
        final String f31609d;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f31601f = cls;
                f31600e = cls.newInstance();
                f31602g = f31601f.getMethod("getUDID", Context.class);
                f31603h = f31601f.getMethod("getOAID", Context.class);
                f31604i = f31601f.getMethod("getVAID", Context.class);
                f31605j = f31601f.getMethod("getAAID", Context.class);
            } catch (Throwable unused) {
            }
        }

        C11519a(Context context) {
            this.f31606a = m21370a(context, f31602g);
            this.f31607b = m21370a(context, f31603h);
            this.f31608c = m21370a(context, f31604i);
            this.f31609d = m21370a(context, f31605j);
        }

        /* renamed from: a */
        private static String m21370a(Context context, Method method) {
            Object obj = f31600e;
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
            String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
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
                OaidCallback oaidCallback = new OaidCallback() { // from class: com.mbridge.msdk.optimize.SensitiveDataUtil.1.1
                    @Override // com.mbridge.msdk.optimize.p498a.OaidCallback
                    /* renamed from: a */
                    public final void mo21351a(String str2) {
                    }

                    @Override // com.mbridge.msdk.optimize.p498a.OaidCallback
                    /* renamed from: a */
                    public final void mo21350a(String str2, boolean z) {
                        String unused = SensitiveDataUtil.oaid = str2;
                    }
                };
                if ("ASUS".equals(str)) {
                    new ASUSDeviceHelper(context).m21363a(oaidCallback);
                } else if ("OPPO".equals(str)) {
                    new OppoDeviceHelper(context).m21357a(oaidCallback);
                } else if ("ONEPLUS".equals(str)) {
                    new OnePlusDeviceHelper(context).m21359a(oaidCallback);
                } else if (!"ZTE".equals(str) && !"FERRMEOS".equals(str) && !"SSUI".equals(str)) {
                    if ("HUAWEI".equals(str)) {
                        new OaidAidlUtil(context).m21366a(oaidCallback);
                    } else if ("SAMSUNG".equals(str)) {
                        new SamsungDeviceHelper(context).m21355a(oaidCallback);
                    } else if (!"LENOVO".equals(str) && !"MOTOLORA".equals(str)) {
                        if ("MEIZU".equals(str)) {
                            new MeizuDeviceHelper(context).m21361a(oaidCallback);
                        }
                    } else {
                        new LenovoDeviceHelper(context).m21362a(oaidCallback);
                    }
                } else {
                    new ZTEDeviceHelper(context).m21352a(oaidCallback);
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
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            str = new C11519a(context).f31607b;
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
            if (Arrays.asList("ASUS", "HUAWEI", "OPPO", "ONEPLUS", "ZTE", "FERRMEOS", "SSUI", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO").contains(upperCase)) {
                getFormNewThread(context, upperCase);
            } else if ("VIVO".equals(upperCase)) {
                oaid = new VivoDeviceHelper(context).m21354a();
            } else if ("NUBIA".equals(upperCase)) {
                oaid = new NubiaDeviceHelper(context).m21360a();
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
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
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
            } catch (IOException e) {
                e.printStackTrace();
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
