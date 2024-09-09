package w0;

import android.app.Application;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.e;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: MacAddressUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {
    public static String a(Application application) {
        WifiManager wifiManager = (WifiManager) application.getSystemService("wifi");
        String str = null;
        if (wifiManager != null) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (scanResults != null && connectionInfo != null) {
                for (int i4 = 0; i4 < scanResults.size(); i4++) {
                    ScanResult scanResult = scanResults.get(i4);
                    if (!TextUtils.isEmpty(connectionInfo.getBSSID()) && connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str = scanResult.BSSID;
                    }
                }
            }
        }
        return str;
    }

    public static String b(Context context) {
        String d4 = d();
        if (TextUtils.isEmpty(d4)) {
            String c4 = c(context);
            if (TextUtils.isEmpty(c4)) {
                String a4 = a.a(context);
                return !TextUtils.isEmpty(a4) ? a4 : "";
            }
            return c4;
        }
        return d4;
    }

    public static String c(Context context) {
        Enumeration<NetworkInterface> enumeration;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e4) {
            e4.printStackTrace();
            enumeration = null;
        }
        while (enumeration.hasMoreElements()) {
            NetworkInterface nextElement = enumeration.nextElement();
            byte[] bArr = new byte[0];
            try {
                bArr = nextElement.getHardwareAddress();
            } catch (SocketException e5) {
                e5.printStackTrace();
            }
            if (nextElement.getDisplayName().equals(e(context, "wifi.interface")) && bArr != null && bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                int length = bArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    sb.append(String.format("%02X:", Byte.valueOf(bArr[i4])));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static String d() {
        return e.b("cat /sys/class/net/wlan0/address", false).f48146b;
    }

    private static String e(Context context, String str) {
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
