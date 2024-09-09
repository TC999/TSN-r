package cn.jiguang.bm;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2751a = cn.jiguang.bp.d.b(new byte[]{109, 80, 79, 112, 92, 113, 16, 94, 75, 69, 96, 119, 115, 80, 106, 37, 85, 97, 101, 91, 73, 71, 68, 113, 97, 45, 79, 88, 80, 116, 99, 91, 97, 71, 90, 114, 71, 72, 76, 82, 118, 82, 82, 88, 90, 64, 101, 106, 17, 74, 125, 98, 126, 114, 70, 83, 70, 81, 98, 102, 86, 86, 70, 71, 39, 31, 87, 122, 126, 122, 91, 69, 69, 96, 56, 47, 82, 116, 66, 79, 57, 94, 71, 89, 116, 76, 126, 122, 105, 117, 99, 84, 88, 80, 114, 104, 76, 125, 124, 81, 83, 96, 111, 107, 105, Byte.MAX_VALUE, 105, 102, 73, 111, 82, 69, 67, 105, 76, 110, 126, 124, 72, 101, 107, 106, 102, 67, 93, 118, 108, 88, 66, 89, 40, 91, 106, 90, 112, 64, 112, 2, 102, 113, 68, 70, 85, 84, 90, 87, 63, 117, 97, 94, 70, 44, Byte.MAX_VALUE, 126, 33, 123, 116, 46, 48, 96, 70, 31, 82, 94, 56, 90, 93, 87, 22, 95, 94, 103, 121, 104, 111, 122, 100, 66, 73, 117, 68, 45, 112, 102, 41, 82, 100, 104, 108, 123, 71, 74, 106, 117, 66, 89, 72, 5, 88, 105, 114, 47, 115, 117, 118, 87, 69, 35, 62, 97, 105, 93, 73, 71, 80, 114});

    /* renamed from: b  reason: collision with root package name */
    private static int f2752b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static int f2753c = 500;

    private static Bundle a(Context context, int i4) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 94, null, null, new Object[0]);
        return onEvent instanceof Bundle ? (Bundle) onEvent : new Bundle();
    }

    public static String a() {
        return JConstants.testJOperateBaseUrl;
    }

    public static String a(Context context, String str, JSONObject jSONObject) {
        HttpResponse httpResponse = null;
        try {
            a(context, (List<String>) cn.jiguang.bp.e.f2819c);
            int i4 = 0;
            String str2 = str;
            boolean z3 = false;
            while (i4 < cn.jiguang.bp.e.f2819c.size()) {
                if (!l(context) || z3) {
                    str2 = (z3 || i4 != cn.jiguang.bp.e.f2819c.size() - 1) ? str : str.replace(cn.jiguang.bp.e.f2817a, cn.jiguang.bp.e.f2818b);
                } else {
                    str2 = str2.replace(cn.jiguang.bp.e.f2817a, cn.jiguang.bp.e.f2818b);
                    z3 = true;
                }
                HttpRequest httpRequest = new HttpRequest(str2);
                httpRequest.setRequestProperty("Content-Type", "application/json");
                httpRequest.setRequestProperty("Accept", "application/json");
                String a4 = cn.jiguang.cn.g.a(cn.jiguang.cn.g.a());
                httpRequest.setRequestProperty("Authorization", a(a4));
                String jSONObject2 = jSONObject.toString();
                cn.jiguang.bp.h.a("JOperateJCoreHelper", "sendHttp ulr:" + httpRequest.getUrl());
                cn.jiguang.bp.h.a("JOperateJCoreHelper", "sendHttp body:" + jSONObject2);
                httpRequest.setBody(cn.jiguang.cn.g.a(jSONObject2.getBytes("UTF-8"), a4, "q5bfn8msyozljacg", true));
                httpResponse = HttpUtils.httpPost(context, httpRequest);
                cn.jiguang.bp.h.a("JOperateJCoreHelper", "sendHttp httpResponse:" + httpResponse.toString());
                if (200 == httpResponse.getResponseCode()) {
                    String responseBody = httpResponse.getResponseBody();
                    cn.jiguang.bp.h.a("JOperateJCoreHelper", "success responseBody:" + responseBody);
                    return responseBody;
                }
                i4++;
            }
            cn.jiguang.bp.h.g("JOperateJCoreHelper", "sendHttp: httpResponse:" + httpResponse);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("code", -1);
                jSONObject3.put("msg", httpResponse);
            } catch (Throwable unused) {
            }
            return jSONObject3.toString();
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateJCoreHelper", "sendHttp11:", th);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("code", -1);
                jSONObject4.put("msg", th.getMessage());
            } catch (Throwable unused2) {
            }
            return jSONObject4.toString();
        }
    }

    public static String a(File file) {
        return cn.jiguang.f.c.d(file);
    }

    public static String a(String str) {
        try {
            return cn.jiguang.cn.g.b(str, c(), "RSA/ECB/PKCS1Padding");
        } catch (Throwable unused) {
            cn.jiguang.bp.h.f("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static JSONObject a(Context context) {
        for (int i4 = 0; i4 < f2752b; i4++) {
            Bundle a4 = a(context, i4);
            if (a4.getBoolean("isServiceProcess", false)) {
                try {
                    return new JSONObject(a4.getString("de_inf"));
                } catch (Throwable unused) {
                    return new JSONObject();
                }
            }
            try {
                Thread.sleep(f2753c);
            } catch (Throwable unused2) {
            }
        }
        return new JSONObject();
    }

    public static void a(int i4, boolean z3, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JOperate", 18, str, null, Integer.valueOf(i4), Boolean.valueOf(z3), str2, th);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    private static void a(Context context, List<String> list) {
        if (!l(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    public static void a(final Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 76, null, null, new cn.jiguang.cm.b("JOperate") { // from class: cn.jiguang.bm.f.1
            @Override // cn.jiguang.cm.b
            public void a() {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public static boolean a(File file, String str) {
        return cn.jiguang.f.c.c(file, str);
    }

    private static synchronized Bundle b(Context context, int i4) {
        synchronized (f.class) {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 91, null, null, new Object[0]);
            if (onEvent instanceof Bundle) {
                return (Bundle) onEvent;
            }
            return new Bundle();
        }
    }

    public static String b(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 6, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static boolean b() {
        return false;
    }

    public static boolean b(File file, String str) {
        return cn.jiguang.f.c.b(file, str);
    }

    public static Boolean c(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 124, null, null, new Object[0]);
        return onEvent instanceof Boolean ? (Boolean) onEvent : Boolean.FALSE;
    }

    public static String c() {
        return f2751a;
    }

    public static String d(Context context) {
        Object onEvent = JCoreManager.onEvent(null, JConstants.SDK_TYPE, 92, null, null, new Object[0]);
        if (onEvent instanceof String) {
            return (String) onEvent;
        }
        return null;
    }

    public static Bundle e(Context context) {
        for (int i4 = 0; i4 < f2752b; i4++) {
            Bundle b4 = b(context, i4);
            if (b4.getBoolean("isServiceProcess", false)) {
                return b4;
            }
            try {
                Thread.sleep(f2753c);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String f(Context context) {
        return cn.jiguang.d.a.b(context);
    }

    public static long g(Context context) {
        return cn.jiguang.d.a.f(context);
    }

    public static String h(Context context) {
        return cn.jiguang.f.a.a(context);
    }

    public static String i(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 8, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String j(Context context) {
        return cn.jiguang.d.a.e(context);
    }

    public static Boolean k(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 82, null, null, new Object[0]);
        return onEvent instanceof Boolean ? (Boolean) onEvent : Boolean.FALSE;
    }

    public static boolean l(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 121, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }
}
