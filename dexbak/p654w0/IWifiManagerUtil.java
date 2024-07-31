package p654w0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: w0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IWifiManagerUtil {

    /* renamed from: a */
    private static String f47143a = "02:00:00:00:00:00";

    /* renamed from: a */
    public static String m51a(Context context) {
        String m49c = m49c(context);
        if (TextUtils.isEmpty(m49c) || f47143a.endsWith(m49c)) {
            String m50b = m50b(context);
            if (!TextUtils.isEmpty(m50b)) {
                f47143a.endsWith(m50b);
            }
            return m50b;
        }
        return m49c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private static String m50b(Context context) {
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
    /* renamed from: c */
    private static String m49c(Context context) {
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
