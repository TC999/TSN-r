package com.kwai.library.ipneigh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;
import java.util.regex.Pattern;

/* renamed from: com.kwai.library.ipneigh.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C11175b {
    private static final Pattern aUx = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    @SuppressLint({"DefaultLocale"})
    /* renamed from: er */
    public static String m23479er(int i) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 24) & 255));
    }

    /* renamed from: hq */
    private static boolean m23478hq(String str) {
        if (str == null) {
            return false;
        }
        return aUx.matcher(str).matches();
    }

    /* renamed from: hr */
    public static String m23477hr(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\s+");
        return (split.length >= 5 && m23478hq(split[4])) ? split[4] : "";
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
