package com.bytedance.sdk.openadsdk.core.xv;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.ev;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.k;
import com.bytedance.sdk.openadsdk.core.ls;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f35603c;

    public static r c() {
        if (f35603c == null) {
            synchronized (r.class) {
                if (f35603c == null) {
                    f35603c = new r();
                }
            }
        }
        return f35603c;
    }

    private Pair<Integer, JSONObject> f(String str) {
        return sr(str);
    }

    public Pair<Integer, JSONObject> sr(String str) {
        return new Pair<>(3, com.bytedance.sdk.component.utils.c.c(str));
    }

    public JSONObject ux(String str) {
        if (TextUtils.isEmpty(str) || !ev.w()) {
            return null;
        }
        try {
            byte[] c4 = ev.c().c(str.getBytes(StandardCharsets.UTF_8));
            if (c4 != null) {
                String encodeToString = Base64.encodeToString(c4, 0);
                if (TextUtils.isEmpty(encodeToString)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("message", encodeToString);
                jSONObject.put("cypher", 4);
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public com.bytedance.sdk.openadsdk.core.ck.w w(String str) {
        int i4;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.ck.w wVar = new com.bytedance.sdk.openadsdk.core.ck.w();
        HashMap hashMap = new HashMap();
        try {
            wVar.c(str.length());
            Pair<Integer, JSONObject> c4 = c().c(str, false);
            if (c4 != null) {
                JSONObject jSONObject2 = (JSONObject) c4.second;
                try {
                    Object obj = c4.first;
                    i4 = obj != null ? ((Integer) obj).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                i4 = 3;
            }
            jSONObject.put("ad_sdk_version", eq.xv);
            jSONObject.put("plugin_version", "6.1.0.6");
            if (i4 != 3) {
                hashMap.put("x-ad-sdk-version", eq.xv);
                hashMap.put("x-plugin-version", "6.1.0.6");
                hashMap.put("x-pglcypher", String.valueOf(4));
            }
        } catch (Throwable unused2) {
        }
        wVar.c(hashMap);
        wVar.w(jSONObject);
        return wVar;
    }

    public Pair<Integer, ?> xv(String str) {
        try {
            if (!TextUtils.isEmpty(str) && ls.w().eu()) {
                return c(str, "get_ad");
            }
        } catch (Throwable th) {
            a.xv(th.getMessage());
        }
        return sr(str);
    }

    public com.bytedance.sdk.openadsdk.core.ck.w c(String str) {
        Object obj;
        com.bytedance.sdk.openadsdk.core.ck.w wVar = new com.bytedance.sdk.openadsdk.core.ck.w();
        HashMap hashMap = new HashMap();
        try {
            wVar.c(str.length());
            Pair<Integer, ?> xv = c().xv(str);
            int i4 = 3;
            if (xv != null) {
                obj = xv.second;
                Object obj2 = xv.first;
                if (obj2 != null) {
                    i4 = ((Integer) obj2).intValue();
                }
            } else {
                obj = null;
            }
            if (i4 == 4) {
                hashMap.put("x-ad-sdk-version", eq.xv);
                hashMap.put("x-plugin-version", "6.1.0.6");
                hashMap.put("x-pglcypher", String.valueOf(i4));
                hashMap.put("Content-Type", "application/octet-stream");
                wVar.c((byte[]) obj);
                wVar.c(hashMap);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", eq.xv);
                jSONObject.put("plugin_version", "6.1.0.6");
                wVar.w(jSONObject);
                wVar.c(hashMap);
            }
        } catch (Throwable unused) {
        }
        return wVar;
    }

    private Pair<Integer, JSONObject> w(String str, boolean z3) {
        JSONObject ux = (TextUtils.isEmpty(str) || !ev.w()) ? null : ux(str);
        if (ux != null && !TextUtils.isEmpty(ux.optString("message"))) {
            return new Pair<>(4, ux);
        }
        if (ev.w() && z3) {
            com.bytedance.sdk.openadsdk.core.fz.a.c().c(3, -1L, (String) null);
        }
        return f(str);
    }

    private static String w(byte[] bArr, String str) {
        int i4;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] w3 = ev.c().w(bArr);
                    String w4 = k.w(w3);
                    if (TextUtils.isEmpty(w4)) {
                        com.bytedance.sdk.openadsdk.core.fz.a c4 = com.bytedance.sdk.openadsdk.core.fz.a.c();
                        if (w3 != null && w3.length != 0) {
                            i4 = 2;
                            c4.c(i4, -1L, str);
                            return null;
                        }
                        i4 = 1;
                        c4.c(i4, -1L, str);
                        return null;
                    }
                    return w4;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public Pair<Integer, JSONObject> c(String str, boolean z3) {
        try {
            if (ls.w().eu()) {
                return w(str, z3);
            }
        } catch (Throwable th) {
            a.xv(th.getMessage());
        }
        return sr(str);
    }

    public Pair<Integer, ?> c(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str)) {
            return f(str);
        }
        if (ev.w()) {
            bArr = ev.c().c(k.c(str.getBytes(StandardCharsets.UTF_8)));
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            return new Pair<>(4, bArr);
        }
        if (ev.w()) {
            com.bytedance.sdk.openadsdk.core.fz.a.c().c(3, -1L, str2);
        }
        return f(str);
    }

    public static Pair<Boolean, JSONObject> c(com.bytedance.sdk.component.ev.w wVar, String str, boolean z3) {
        if (com.bytedance.sdk.component.ev.sr.c.c(wVar.xv())) {
            return new Pair<>(Boolean.FALSE, c(wVar.p(), str));
        }
        if (wVar.sr() != null && !wVar.sr().startsWith("{") && !wVar.sr().endsWith("}") && !wVar.sr().contains("message") && !wVar.sr().contains("cypher")) {
            return new Pair<>(Boolean.FALSE, c(wVar.p(), str));
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(wVar.sr());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return new Pair<>(Boolean.TRUE, c(jSONObject, true, z3));
    }

    public static JSONObject c(JSONObject jSONObject, boolean z3, boolean z4) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String c4 = c(jSONObject, z3);
            String optString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(c4)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(c4);
            if (z4) {
                try {
                    jSONObject2.put("auction_price", optString);
                } catch (Throwable unused) {
                }
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String c(JSONObject jSONObject, boolean z3) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            if (optInt == 3) {
                return com.bytedance.sdk.component.utils.c.xv(optString);
            }
            if (optInt == 4) {
                String c4 = ev.c().c(optString);
                if (TextUtils.isEmpty(c4) && z3) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(1, -1L, (String) null);
                    return c4;
                }
                return c4;
            }
            return optString;
        } catch (Exception unused) {
            return null;
        }
    }

    private static JSONObject c(byte[] bArr, String str) {
        try {
            String w3 = w(bArr, str);
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            return new JSONObject(w3);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
