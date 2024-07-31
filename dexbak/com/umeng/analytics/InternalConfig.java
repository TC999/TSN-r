package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.UContent;
import com.umeng.analytics.pro.ZipUtils;
import com.umeng.common.SPHelper;
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

/* renamed from: com.umeng.analytics.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class InternalConfig {

    /* renamed from: a */
    private static final int f37574a = 3;

    /* renamed from: b */
    private static final String f37575b = "umeng_pcp";

    /* renamed from: c */
    private static final String f37576c = "mob";

    /* renamed from: d */
    private static final String f37577d = "em";

    /* renamed from: e */
    private static final String f37578e = "cp";

    /* renamed from: f */
    private static final String f37579f = "pk";

    /* renamed from: g */
    private static final String f37580g = "pv";

    /* renamed from: h */
    private static String[] f37581h = new String[2];

    /* renamed from: i */
    private static Object f37582i = new Object();

    /* renamed from: j */
    private static Map<String, Object> f37583j = new HashMap();

    /* renamed from: a */
    public static void m14781a(Context context, String str, String str2) {
        String[] strArr = f37581h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            SPHelper.m14059a(context).m14054a(str, str2);
        }
    }

    /* renamed from: b */
    public static void m14776b(Context context) {
        String[] strArr = f37581h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            SPHelper.m14059a(context).m14053b();
        }
    }

    /* renamed from: c */
    public static Map<String, Object> m14774c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f37575b, 0);
        String string = sharedPreferences.getString(f37578e, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String str = new String(ZipUtils.m14699a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            if (str.length() > 0) {
                HashMap hashMap = new HashMap();
                try {
                    JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        hashMap.put(jSONObject.getString("pk"), jSONObject.get("pv"));
                    }
                    sharedPreferences.edit().putString(f37578e, "").apply();
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

    /* renamed from: a */
    public static String[] m14782a(Context context) {
        String[] m14061a;
        if (TextUtils.isEmpty(f37581h[0]) || TextUtils.isEmpty(f37581h[1])) {
            if (context == null || (m14061a = SPHelper.m14059a(context).m14061a()) == null) {
                return null;
            }
            String[] strArr = f37581h;
            strArr[0] = m14061a[0];
            strArr[1] = m14061a[1];
            return strArr;
        }
        return f37581h;
    }

    /* renamed from: b */
    public static void m14775b(String str) {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f37575b, 0);
                byte[] m14699a = ZipUtils.m14699a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString(f37577d, m14699a.length == 0 ? UContent.f38086Q : Base64.encodeToString(m14699a, 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m14779a(String str) {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f37575b, 0);
                byte[] m14699a = ZipUtils.m14699a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString(f37576c, m14699a.length == 0 ? UContent.f38086Q : Base64.encodeToString(m14699a, 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public static String m14777b() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f37575b, 0);
                String string = sharedPreferences.getString(f37577d, "");
                if (UContent.f38086Q.equals(string)) {
                    sharedPreferences.edit().putString(f37577d, "").apply();
                    return "";
                } else if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    sharedPreferences.edit().putString(f37577d, "").apply();
                    return new String(ZipUtils.m14699a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m14783a() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f37575b, 0);
                String string = sharedPreferences.getString(f37576c, "");
                if (UContent.f38086Q.equals(string)) {
                    sharedPreferences.edit().putString(f37576c, "").apply();
                    return "";
                } else if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    sharedPreferences.edit().putString(f37576c, "").apply();
                    return new String(ZipUtils.m14699a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m14780a(Context context, Map<String, Object> map) {
        if (map != null) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                synchronized (f37582i) {
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
                SharedPreferences sharedPreferences = context.getSharedPreferences(f37575b, 0);
                sharedPreferences.edit().putString(f37578e, Base64.encodeToString(ZipUtils.m14699a(jSONStringer.toString().getBytes(), UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m14778a(String str, Object obj) {
        synchronized (f37582i) {
            if (f37583j.containsKey(str)) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "更新账号自定义KV: key=" + str + "; val=" + obj);
                f37583j.put(str, obj);
                m14780a(UMGlobalContext.getAppContext(), f37583j);
            } else if (f37583j.size() >= 3) {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: 已经设置3个KV键值对，忽略设置请求。");
                MLog.m13820e("userProfile: Only 3 user-defined key-value pairs can be configured, please check!");
            } else {
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: key=" + str + "; val=" + obj);
                f37583j.put(str, obj);
                m14780a(UMGlobalContext.getAppContext(), f37583j);
            }
        }
    }
}
