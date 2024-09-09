package com.bytedance.sdk.component.ev.sr;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.net.URI;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    public static boolean c(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            Log.e("ignored", th.toString());
        }
        return false;
    }

    public static int w(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        return 5;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (!TextUtils.isEmpty(subtypeName)) {
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (subtypeName.equalsIgnoreCase("CDMA2000")) {
                                }
                            }
                            return 3;
                        }
                        return 1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static String xv(Context context) {
        int w3 = w(context);
        return w3 != 2 ? w3 != 3 ? w3 != 4 ? w3 != 5 ? "mobile" : "4g" : "wifi" : "3g" : "2g";
    }

    private static boolean xv(String str) {
        return Pattern.matches("((2(5[0-5]|[0-4]\\\\d))|[0-1]?\\\\d{1,2})(\\\\.((2(5[0-5]|[0-4]\\\\d))|[0-1]?\\\\d{1,2})){3}", str);
    }

    public static int c(String str, int i4, int i5, int i6) {
        String w3 = w(str);
        if (TextUtils.isEmpty(w3)) {
            return 0;
        }
        String c4 = c(c(i5, i6, w3));
        xv.w("NETWORK_UTILS", c4);
        if (!TextUtils.isEmpty(c4)) {
            try {
                String[] split = c4.substring(c4.indexOf("min/avg/max/mdev") + 19).split(TTPathConst.sSeparator);
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                return -1;
                            }
                            return Math.round(Float.parseFloat(split[3]));
                        }
                        return Math.round(Float.parseFloat(split[2]));
                    }
                    return Math.round(Float.parseFloat(split[1]));
                }
                return Math.round(Float.parseFloat(split[0]));
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            }
        }
        return -1;
    }

    private static String w(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith(JPushConstants.HTTP_PRE) || !str.startsWith(JPushConstants.HTTPS_PRE)) {
            str = JPushConstants.HTTPS_PRE + str;
        }
        try {
            str2 = URI.create(str).getHost();
            if (str2 == null) {
                if (xv(str)) {
                    return str;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return str2;
    }

    public static float c(String str, int i4, int i5) {
        String w3 = w(str);
        if (TextUtils.isEmpty(w3)) {
            return 0.0f;
        }
        String c4 = c(c(i4, i5, w3));
        if (TextUtils.isEmpty(c4)) {
            return -1.0f;
        }
        String substring = c4.substring(c4.indexOf("received,"));
        return Float.parseFloat(substring.substring(9, substring.indexOf("packet")).replace("%", ""));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40
            java.lang.Process r6 = r1.exec(r6)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r3.<init>(r1)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r2.<init>(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r3.<init>()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
        L1c:
            java.lang.String r4 = r2.readLine()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            if (r4 == 0) goto L2b
            r3.append(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            goto L1c
        L2b:
            r2.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r1.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r6.destroy()
            return r0
        L39:
            r1 = move-exception
            goto L42
        L3b:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L4c
        L40:
            r1 = move-exception
            r6 = r0
        L42:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L4a
            r6.destroy()
        L4a:
            return r0
        L4b:
            r0 = move-exception
        L4c:
            if (r6 == 0) goto L51
            r6.destroy()
        L51:
            goto L53
        L52:
            throw r0
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.sr.f.c(java.lang.String):java.lang.String");
    }

    private static String c(int i4, int i5, String str) {
        return "/system/bin/ping -c " + i4 + " -w " + i5 + " " + str;
    }
}
