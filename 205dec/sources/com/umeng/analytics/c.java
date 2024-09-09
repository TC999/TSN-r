package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: InternalConfig.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f52468a = 3;

    /* renamed from: b  reason: collision with root package name */
    private static final String f52469b = "umeng_pcp";

    /* renamed from: c  reason: collision with root package name */
    private static final String f52470c = "mob";

    /* renamed from: d  reason: collision with root package name */
    private static final String f52471d = "em";

    /* renamed from: e  reason: collision with root package name */
    private static final String f52472e = "cp";

    /* renamed from: f  reason: collision with root package name */
    private static final String f52473f = "pk";

    /* renamed from: g  reason: collision with root package name */
    private static final String f52474g = "pv";

    /* renamed from: h  reason: collision with root package name */
    private static String[] f52475h = new String[2];

    /* renamed from: i  reason: collision with root package name */
    private static Object f52476i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, Object> f52477j = new HashMap();

    public static void a(Context context, String str, String str2) {
        String[] strArr = f52475h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f52475h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static Map<String, Object> c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_pcp", 0);
        String string = sharedPreferences.getString("cp", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String str = new String(at.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            if (str.length() > 0) {
                HashMap hashMap = new HashMap();
                try {
                    JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i4);
                        hashMap.put(jSONObject.getString("pk"), jSONObject.get("pv"));
                    }
                    sharedPreferences.edit().putString("cp", "").apply();
                    return hashMap;
                } catch (Throwable unused) {
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String[] a(Context context) {
        String[] a4;
        if (TextUtils.isEmpty(f52475h[0]) || TextUtils.isEmpty(f52475h[1])) {
            if (context == null || (a4 = com.umeng.common.b.a(context).a()) == null) {
                return null;
            }
            String[] strArr = f52475h;
            strArr[0] = a4[0];
            strArr[1] = a4[1];
            return strArr;
        }
        return f52475h;
    }

    public static void b(String str) {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("umeng_pcp", 0);
                byte[] a4 = at.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString("em", a4.length == 0 ? "_#$$$" : Base64.encodeToString(a4, 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("umeng_pcp", 0);
                byte[] a4 = at.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString("mob", a4.length == 0 ? "_#$$$" : Base64.encodeToString(a4, 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("umeng_pcp", 0);
                String string = sharedPreferences.getString("em", "");
                if ("_#$$$".equals(string)) {
                    sharedPreferences.edit().putString("em", "").apply();
                    return "";
                } else if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    sharedPreferences.edit().putString("em", "").apply();
                    return new String(at.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static String a() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("umeng_pcp", 0);
                String string = sharedPreferences.getString("mob", "");
                if ("_#$$$".equals(string)) {
                    sharedPreferences.edit().putString("mob", "").apply();
                    return "";
                } else if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    sharedPreferences.edit().putString("mob", "").apply();
                    return new String(at.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, Map<String, Object> map) {
        if (map != null) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                synchronized (f52476i) {
                    jSONStringer.array();
                    for (String str : map.keySet()) {
                        jSONStringer.object();
                        jSONStringer.key("pk");
                        jSONStringer.value(str);
                        jSONStringer.key("pv");
                        jSONStringer.value(map.get(str));
                        jSONStringer.endObject();
                    }
                    jSONStringer.endArray();
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_pcp", 0);
                sharedPreferences.edit().putString("cp", Base64.encodeToString(at.a(jSONStringer.toString().getBytes(), UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, Object obj) {
        synchronized (f52476i) {
            if (f52477j.containsKey(str)) {
                UMRTLog.i("MobclickRT", "\u66f4\u65b0\u8d26\u53f7\u81ea\u5b9a\u4e49KV: key=" + str + "; val=" + obj);
                f52477j.put(str, obj);
                a(UMGlobalContext.getAppContext(), f52477j);
            } else if (f52477j.size() >= 3) {
                UMRTLog.i("MobclickRT", "\u8bbe\u7f6e\u8d26\u53f7\u81ea\u5b9a\u4e49KV: \u5df2\u7ecf\u8bbe\u7f6e3\u4e2aKV\u952e\u503c\u5bf9\uff0c\u5ffd\u7565\u8bbe\u7f6e\u8bf7\u6c42\u3002");
                MLog.e("userProfile: Only 3 user-defined key-value pairs can be configured, please check!");
            } else {
                UMRTLog.i("MobclickRT", "\u8bbe\u7f6e\u8d26\u53f7\u81ea\u5b9a\u4e49KV: key=" + str + "; val=" + obj);
                f52477j.put(str, obj);
                a(UMGlobalContext.getAppContext(), f52477j);
            }
        }
    }
}
