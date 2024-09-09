package com.kwai.library.ipneigh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class b {
    private static final Pattern aUx = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    @SuppressLint({"DefaultLocale"})
    public static String er(int i4) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i4 & 255), Integer.valueOf((i4 >> 8) & 255), Integer.valueOf((i4 >> 16) & 255), Integer.valueOf((i4 >> 24) & 255));
    }

    private static boolean hq(String str) {
        if (str == null) {
            return false;
        }
        return aUx.matcher(str).matches();
    }

    public static String hr(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\s+");
        return (split.length >= 5 && hq(split[4])) ? split[4] : "";
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
