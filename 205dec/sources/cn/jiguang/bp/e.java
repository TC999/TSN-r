package cn.jiguang.bp;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f2817a = d.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 67, 77, 120, 122, 98, 126, 64, 13, 106, 108, 125, 112, 64, 73, 55, 98, Byte.MAX_VALUE, 118, 69, 65, 119, 111, 56, 114, 94});

    /* renamed from: b  reason: collision with root package name */
    public static String f2818b = d.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 98, 93, 65, 107, 124, 121, 97, 29, 83, 125, 99, 119, 97, 89, 13, 112, 120, 96, 39, 30, 74, 112, 111, 99, 112, 94, 71, 55, 107, 120});

    /* renamed from: c  reason: collision with root package name */
    public static LinkedList<String> f2819c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Integer, String> f2820d;

    static {
        HashMap hashMap = new HashMap();
        f2820d = hashMap;
        f2819c = new LinkedList<>();
        hashMap.put(1, "/v1/visual-bury-sdk-api/smartop/1/project");
        hashMap.put(2, "/v1/visual-bury-sdk-api/smartop/1/custom-event");
        hashMap.put(3, "/v1/visual-bury-sdk-api/smartop/1/user-tag");
        hashMap.put(4, "/v1/visual-bury-sdk-api/smartop/1/channel");
        hashMap.put(5, "/v1/visual-bury-sdk-api/smartop/1/user-attribute");
        f2819c.add(f2817a);
        f2819c.add(f2818b);
    }

    private static String a() {
        return a("/v1/visual-bury-sdk-api/smartop/1/debug/report");
    }

    private static String a(int i4) {
        String str = f2820d.get(Integer.valueOf(i4));
        if (str == null) {
            return null;
        }
        return a(str);
    }

    public static String a(Context context, int i4, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", cn.jiguang.bm.f.j(context));
            jSONObject.put("cuid", str);
            jSONObject.put("time", System.currentTimeMillis());
            String a4 = a(i4);
            if (a4 == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                jSONObject2.put("msg", "no has data type");
                return jSONObject2.toString();
            }
            return cn.jiguang.bm.f.a(context, a4, jSONObject);
        } catch (Throwable th) {
            h.b("JOperateHttpHelper", "testDemo:", th);
            return a(th).toString();
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", cn.jiguang.bm.f.j(context));
            jSONObject.put("cuid", str);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("type", "del");
            jSONObject.put("value", str2);
            return cn.jiguang.bm.f.a(context, e(), jSONObject);
        } catch (Throwable th) {
            h.b("JOperateHttpHelper", "unUserProfile:", th);
            return a(th).toString();
        }
    }

    public static String a(Context context, String str, String str2, long j4, long j5) {
        String str3;
        try {
            JSONObject a4 = cn.jiguang.bm.f.a(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userVersion", j4);
            jSONObject.put("eventVersion", j5);
            jSONObject.put("model_num", a4.optString("model", ""));
            jSONObject.put("manufacturer", a4.optString("manufacturer", ""));
            jSONObject.put("appkey", cn.jiguang.bm.f.j(context));
            if (str == null) {
                str = "";
            }
            jSONObject.put("cuid", str);
            jSONObject.put("rid", str2);
            JSONArray optJSONArray = a4.optJSONArray("sim_slots");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        str3 = optJSONObject.optString("imei");
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                }
            }
            str3 = "";
            jSONObject.put("imei", str3);
            jSONObject.put("resolution", a4.optString("resolution"));
            jSONObject.put("os", "a");
            jSONObject.put("sysver", a4.optString("os_version"));
            JSONObject optJSONObject2 = a4.optJSONObject("ids");
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, optJSONObject2 != null ? optJSONObject2.optString("joad") : "");
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("joperate_sdk_version", cn.jiguang.bm.g.a(context).a());
            jSONObject.put("jcore_sdk_version", cn.jiguang.bm.f.d(context));
            jSONObject.put("app_version", a.a(context));
            return cn.jiguang.bm.f.a(context, b(), jSONObject);
        } catch (Throwable th) {
            h.b("JOperateHttpHelper", "configDownload:", th);
            return "";
        }
    }

    public static String a(Context context, String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appKey", cn.jiguang.bm.f.j(context));
            jSONObject2.put("cuid", str);
            jSONObject2.put("rid", str2);
            jSONObject2.put("value", jSONObject);
            jSONObject2.put("time", System.currentTimeMillis());
            return cn.jiguang.bm.f.a(context, c(), jSONObject2);
        } catch (Throwable th) {
            h.b("JOperateHttpHelper", "setLoginTag e1:", th);
            return a(th).toString();
        }
    }

    public static String a(Context context, String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appKey", cn.jiguang.bm.f.j(context));
            jSONObject2.put("cuid", str);
            jSONObject2.put("time", System.currentTimeMillis());
            JSONArray jSONArray = new JSONArray();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", next);
                jSONObject3.put("contactValues", jSONObject.getJSONObject(next));
                jSONArray.put(jSONObject3);
            }
            jSONObject2.put("channelInfo", jSONArray);
            return cn.jiguang.bm.f.a(context, f(), jSONObject2);
        } catch (Throwable th) {
            h.b("JOperateHttpHelper", "setChannel:", th);
            return a(th).toString();
        }
    }

    public static String a(Context context, JSONObject jSONObject) {
        return cn.jiguang.bm.f.a(context, a(), jSONObject);
    }

    private static String a(String str) {
        StringBuilder sb;
        String str2;
        if (!cn.jiguang.bm.f.b() || TextUtils.isEmpty(cn.jiguang.bm.f.a())) {
            sb = new StringBuilder();
            str2 = f2817a;
        } else {
            sb = new StringBuilder();
            str2 = cn.jiguang.bm.f.a();
        }
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    private static JSONObject a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", -1);
            jSONObject.put("msg", th.getMessage());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static String b() {
        return a("/v1/visual-bury-sdk-api/smartop/1/getEvent");
    }

    public static String b(Context context, String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appKey", cn.jiguang.bm.f.j(context));
            jSONObject2.put("cuid", str);
            jSONObject2.put("time", System.currentTimeMillis());
            jSONObject2.put("type", str2);
            jSONObject2.put("value", jSONObject);
            return cn.jiguang.bm.f.a(context, d(), jSONObject2);
        } catch (Throwable th) {
            h.b("JOperateHttpHelper", "userProfile:", th);
            return a(th).toString();
        }
    }

    private static String c() {
        return a("/v1/visual-bury-sdk-api/smartop/1/setUserInfo");
    }

    private static String d() {
        return a("/v1/visual-bury-sdk-api/smartop/1/updateUserProperties");
    }

    private static String e() {
        return a("/v1/visual-bury-sdk-api/smartop/1/switcUserProperties");
    }

    private static String f() {
        return a("/v1/visual-bury-sdk-api/smartop/1/setChannel");
    }
}
