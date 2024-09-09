package w0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: IWifiManagerUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f64433a = "02:00:00:00:00:00";

    public static String a(Context context) {
        String c4 = c(context);
        if (TextUtils.isEmpty(c4) || f64433a.endsWith(c4)) {
            String b4 = b(context);
            if (!TextUtils.isEmpty(b4)) {
                f64433a.endsWith(b4);
            }
            return b4;
        }
        return c4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"MissingPermission"})
    public static String b(Context context) {
        WifiInfo wifiInfo = null;
        try {
            WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            String macAddress = connectionInfo != null ? connectionInfo.getMacAddress() : null;
            try {
                if (TextUtils.isEmpty(macAddress)) {
                    if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(true);
                        wifiManager.setWifiEnabled(false);
                    }
                    if (wifiManager != null) {
                        wifiInfo = wifiManager.getConnectionInfo();
                    }
                    return wifiInfo != null ? wifiInfo.getMacAddress() : macAddress;
                }
                return macAddress;
            } catch (Exception unused) {
                wifiInfo = macAddress;
                return wifiInfo;
            }
        } catch (Exception unused2) {
        }
    }

    @SuppressLint({"HardwareIds"})
    private static String c(Context context) {
        String str = null;
        try {
            WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
            Field declaredField = wifiManager.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(wifiManager);
            Method declaredMethod = obj.getClass().getDeclaredMethod("getConnectionInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            WifiInfo wifiInfo = (WifiInfo) declaredMethod.invoke(obj, new Object[0]);
            if (wifiInfo == null && !wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
                wifiManager.setWifiEnabled(false);
                wifiInfo = (WifiInfo) declaredMethod.invoke(obj, new Object[0]);
            }
            try {
                Field declaredField2 = wifiInfo.getClass().getDeclaredField("mMacAddress");
                declaredField2.setAccessible(true);
                String str2 = (String) declaredField2.get(wifiInfo);
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                } catch (Exception unused) {
                }
                str = str2;
            } catch (Exception unused2) {
            }
            return wifiInfo != null ? wifiInfo.getMacAddress() : str;
        } catch (Exception unused3) {
            return null;
        }
    }
}
