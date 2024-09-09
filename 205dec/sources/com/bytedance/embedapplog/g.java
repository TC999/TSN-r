package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private static String f26730c = ":push";

    public static String c(boolean z3) {
        return z3 ? "yes" : "no";
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean sr() {
        ISensitiveInfoProvider sensitiveInfoProvider;
        InitConfig k4 = c.k();
        if (k4 == null || (sensitiveInfoProvider = k4.getSensitiveInfoProvider()) == null) {
            return false;
        }
        return sensitiveInfoProvider.isDropTime();
    }

    public static boolean w() {
        ISensitiveInfoProvider sensitiveInfoProvider;
        InitConfig k4 = c.k();
        if (k4 == null || (sensitiveInfoProvider = k4.getSensitiveInfoProvider()) == null) {
            return false;
        }
        return sensitiveInfoProvider.isUseLaunchStrategy();
    }

    public static String xv() {
        ISensitiveInfoProvider sensitiveInfoProvider;
        InitConfig k4 = c.k();
        return (k4 == null || (sensitiveInfoProvider = k4.getSensitiveInfoProvider()) == null) ? "" : sensitiveInfoProvider.getSdkBuildModel();
    }

    public static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return c((Object) jSONObject, (Object) jSONObject2);
    }

    public static String c(Context context) {
        ISensitiveInfoProvider sensitiveInfoProvider;
        InitConfig k4 = c.k();
        return (k4 == null || (sensitiveInfoProvider = k4.getSensitiveInfoProvider()) == null) ? "" : sensitiveInfoProvider.getCurrentProcessName(context);
    }

    public static boolean w(Context context) {
        String c4 = c(context);
        return c4 != null && c4.endsWith(f26730c);
    }

    public static JSONObject w(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e4) {
            be.w(e4);
        }
        return jSONObject;
    }

    public static boolean c() {
        InitConfig k4 = c.k();
        if (k4 != null) {
            return k4.isCanUseUploadPv();
        }
        return true;
    }

    public static String c(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String c4 = c(str3, str2);
            String str4 = hashMap.get(str3);
            String c5 = str4 != null ? c(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(c4);
            sb.append("=");
            sb.append(c5);
        }
        return sb.toString();
    }

    private static String c(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                be.c(th);
            }
        }
    }

    public static void c(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                be.c(th);
            }
        }
    }

    public static void c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                be.w(th);
            }
        }
    }

    public static String c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("getprop " + str);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader2.readLine();
                exec.destroy();
                c(bufferedReader2);
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                try {
                    be.c(th);
                    return str2;
                } finally {
                    c(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return str2;
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            w(jSONObject2, jSONObject);
            try {
                String c4 = kk.c(jSONObject2.optJSONObject(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY));
                if (TextUtils.isEmpty(c4)) {
                    return jSONObject2;
                }
                jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, c4);
                return jSONObject2;
            } catch (Exception e4) {
                be.w(e4);
                return jSONObject2;
            }
        }
        return null;
    }
}
