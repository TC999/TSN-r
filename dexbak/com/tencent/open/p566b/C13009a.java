package com.tencent.open.p566b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.kwad.components.offline.api.p341tk.model.report.TKDownloadReason;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13009a {

    /* renamed from: a */
    protected static final Uri f37288a = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: a */
    public static String m15198a(Context context) {
        int m15195d = m15195d(context);
        if (m15195d == 2) {
            return "wifi";
        }
        if (m15195d == 1) {
            return "cmwap";
        }
        if (m15195d == 4) {
            return "cmnet";
        }
        if (m15195d == 16) {
            return "uniwap";
        }
        if (m15195d == 8) {
            return "uninet";
        }
        if (m15195d == 64) {
            return "wap";
        }
        if (m15195d == 32) {
            return TKDownloadReason.KSAD_TK_NET;
        }
        if (m15195d == 512) {
            return "ctwap";
        }
        if (m15195d == 256) {
            return "ctnet";
        }
        if (m15195d == 2048) {
            return "3gnet";
        }
        if (m15195d == 1024) {
            return "3gwap";
        }
        String m15197b = m15197b(context);
        return (m15197b == null || m15197b.length() == 0) ? "none" : m15197b;
    }

    /* renamed from: b */
    public static String m15197b(Context context) {
        return "";
    }

    /* renamed from: c */
    public static String m15196c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f37288a, null, null, null, null);
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
        } catch (SecurityException e) {
            SLog.m15129e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    /* renamed from: d */
    public static int m15195d(Context context) {
        NetworkInfo m15194e;
        try {
            m15194e = m15194e(context);
        } catch (Exception e) {
            SLog.m15129e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        }
        if (m15194e == null) {
            return 128;
        }
        if (m15194e.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = m15194e.getExtraInfo().toLowerCase();
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
            if (lowerCase.startsWith(TKDownloadReason.KSAD_TK_NET)) {
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
                String m15196c = m15196c(context);
                if (m15196c != null) {
                    if (m15196c.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    /* renamed from: e */
    static NetworkInfo m15194e(Context context) {
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
