package p654w0;

import android.app.Application;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/* renamed from: w0.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MacAddressUtils {
    /* renamed from: a */
    public static String m48a(Application application) {
        WifiManager wifiManager = (WifiManager) application.getSystemService("wifi");
        String str = null;
        if (wifiManager != null) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (scanResults != null && connectionInfo != null) {
                for (int i = 0; i < scanResults.size(); i++) {
                    ScanResult scanResult = scanResults.get(i);
                    if (!TextUtils.isEmpty(connectionInfo.getBSSID()) && connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str = scanResult.BSSID;
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    public static String m47b(Context context) {
        String m45d = m45d();
        if (TextUtils.isEmpty(m45d)) {
            String m46c = m46c(context);
            if (TextUtils.isEmpty(m46c)) {
                String m51a = IWifiManagerUtil.m51a(context);
                return !TextUtils.isEmpty(m51a) ? m51a : "";
            }
            return m46c;
        }
        return m45d;
    }

    /* renamed from: c */
    public static String m46c(Context context) {
        Enumeration<NetworkInterface> enumeration;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
            enumeration = null;
        }
        while (enumeration.hasMoreElements()) {
            NetworkInterface nextElement = enumeration.nextElement();
            byte[] bArr = new byte[0];
            try {
                bArr = nextElement.getHardwareAddress();
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
            if (nextElement.getDisplayName().equals(m44e(context, "wifi.interface")) && bArr != null && bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                int length = bArr.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02X:", Byte.valueOf(bArr[i])));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
        }
        return "";
    }

    /* renamed from: d */
    public static String m45d() {
        return ShellAdbUtils.m19677b("cat /sys/class/net/wlan0/address", false).f33812b;
    }

    /* renamed from: e */
    private static String m44e(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            Method declaredMethod = loadClass.getDeclaredMethod("native_get", String.class);
            Object[] objArr = {str};
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(loadClass, objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
