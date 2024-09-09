package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.log.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected static final Uri f51685a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d4 = d(context);
        if (d4 == 2) {
            return "wifi";
        }
        if (d4 == 1) {
            return "cmwap";
        }
        if (d4 == 4) {
            return "cmnet";
        }
        if (d4 == 16) {
            return "uniwap";
        }
        if (d4 == 8) {
            return "uninet";
        }
        if (d4 == 64) {
            return "wap";
        }
        if (d4 == 32) {
            return "net";
        }
        if (d4 == 512) {
            return "ctwap";
        }
        if (d4 == 256) {
            return "ctnet";
        }
        if (d4 == 2048) {
            return "3gnet";
        }
        if (d4 == 1024) {
            return "3gwap";
        }
        String b4 = b(context);
        return (b4 == null || b4.length() == 0) ? "none" : b4;
    }

    public static String b(Context context) {
        return "";
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f51685a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            query.close();
            return string;
        } catch (SecurityException e4) {
            SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e4.getMessage());
            return "";
        }
    }

    public static int d(Context context) {
        NetworkInfo e4;
        try {
            e4 = e(context);
        } catch (Exception e5) {
            SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e5.getMessage());
        }
        if (e4 == null) {
            return 128;
        }
        if (e4.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = e4.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith("net")) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String c4 = c(context);
                if (c4 != null) {
                    if (c4.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    static NetworkInfo e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }
}
