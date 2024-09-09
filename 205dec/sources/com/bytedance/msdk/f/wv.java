package com.bytedance.msdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.f.sr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wv {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, wv> f28364c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.f.c f28365w;

    private wv(String str, Context context) {
        context = context == null ? com.bytedance.msdk.core.c.getContext() : context;
        if (context != null) {
            this.f28365w = new sr.c().c(str).c(context).c(1).w(com.bytedance.msdk.core.w.k().bk()).c();
        }
    }

    public static wv c(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        Map<String, wv> map = f28364c;
        wv wvVar = map.get(str);
        if (wvVar == null) {
            wv wvVar2 = new wv(str, context);
            map.put(str, wvVar2);
            return wvVar2;
        }
        return wvVar;
    }

    public static JSONObject r(String str) {
        try {
            String w3 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w(str);
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).f(str);
            return new JSONObject(w3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void f(@NonNull String str) {
        try {
            this.f28365w.c(str);
        } catch (Throwable unused) {
        }
    }

    public long sr(@NonNull String str) {
        return w(str, -1L);
    }

    public boolean ux(@NonNull String str) {
        return w(str, false);
    }

    public String w(@NonNull String str) {
        try {
            return w(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public int xv(@NonNull String str) {
        return w(str, -1);
    }

    public static JSONArray sr() {
        try {
            String w3 = c("gm_v3_temp", com.bytedance.msdk.core.c.getContext()).w("gm_key_v3_bug");
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(w3);
            c("gm_v3_temp", com.bytedance.msdk.core.c.getContext()).f("gm_key_v3_bug");
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject ux() {
        try {
            String w3 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("init_time");
            if (TextUtils.isEmpty(w3)) {
                return null;
            }
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).f("init_time");
            return new JSONObject(w3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String w(@NonNull String str, @NonNull String str2) {
        try {
            return this.f28365w.w(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void xv() {
        try {
            this.f28365w.w();
        } catch (Throwable unused) {
        }
    }

    public static void xv(String str, long j4) {
        JSONObject jSONObject;
        try {
            String w3 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("init_time");
            if (TextUtils.isEmpty(w3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(w3);
            }
            jSONObject.put(str, j4);
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("init_time", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public int w(@NonNull String str, int i4) {
        try {
            return this.f28365w.w(str, i4);
        } catch (Throwable unused) {
            return i4;
        }
    }

    public long w(@NonNull String str, long j4) {
        try {
            return this.f28365w.w(str, j4);
        } catch (Throwable unused) {
            return j4;
        }
    }

    public void c(String str) {
        c("any_door_id", str);
    }

    public float w(@NonNull String str, float f4) {
        try {
            return this.f28365w.w(str, f4);
        } catch (Throwable unused) {
            return f4;
        }
    }

    public String c() {
        return w("any_door_id", "");
    }

    public boolean w(@NonNull String str, boolean z3) {
        try {
            return this.f28365w.w(str, z3);
        } catch (Throwable unused) {
            return z3;
        }
    }

    public void c(@NonNull String str, @NonNull String str2) {
        try {
            this.f28365w.c(str, str2);
        } catch (Throwable unused) {
        }
    }

    public Map<String, ?> w() {
        try {
            return this.f28365w.c();
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public void c(@NonNull String str, int i4) {
        try {
            this.f28365w.c(str, i4);
        } catch (Throwable unused) {
        }
    }

    public static void w(Map<String, Object> map) {
        try {
            Context context = com.bytedance.msdk.core.c.getContext();
            SharedPreferences w3 = com.bytedance.sdk.openadsdk.api.plugin.w.w((Context) com.bytedance.msdk.adapter.sr.c.c(context), "cb_test", 0);
            String string = w3.getString("ks", "");
            String string2 = w3.getString("gdt", "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                w3 = com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "cb_test", 0);
                string = w3.getString("ks", "");
                string2 = w3.getString("gdt", "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("ks", string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("gdt", string2);
            }
            map.put("cb_stacktrace", jSONObject);
            w3.edit().clear().apply();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(@NonNull String str, long j4) {
        try {
            this.f28365w.c(str, j4);
        } catch (Throwable unused) {
        }
    }

    public void c(@NonNull String str, float f4) {
        try {
            this.f28365w.c(str, f4);
        } catch (Throwable unused) {
        }
    }

    public void c(@NonNull String str, boolean z3) {
        try {
            this.f28365w.c(str, z3);
        } catch (Throwable unused) {
        }
    }

    public static void c(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String w3 = c("gm_v3_temp", com.bytedance.msdk.core.c.getContext()).w("gm_key_v3_bug");
            if (!TextUtils.isEmpty(w3)) {
                jSONArray = new JSONArray(w3);
            } else {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            c("gm_v3_temp", com.bytedance.msdk.core.c.getContext()).c("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static void c(boolean z3, boolean z4, int i4, String str, long j4, int i5) {
        JSONObject jSONObject;
        String str2 = z3 ? EventMonitor.V3_STAGING_ADLOG : EventMonitor.V1_STAGING_ADLOG;
        try {
            String w3 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w(str2);
            if (TextUtils.isEmpty(w3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(w3);
            }
            int i6 = 1;
            if (z4) {
                JSONObject optJSONObject = jSONObject.optJSONObject("success");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put("success", optJSONObject);
                }
                int optInt = optJSONObject.optInt("times", -1);
                int i7 = optInt == -1 ? 1 : optInt + 1;
                optJSONObject.put("times", i7);
                int optInt2 = optJSONObject.optInt("upload_size", -1);
                optJSONObject.put("upload_size", optInt2 == -1 ? i4 : optInt2 + i4);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("reason");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    optJSONObject.put("reason", optJSONObject2);
                }
                int optInt3 = optJSONObject2.optInt(str, -1);
                if (optInt3 != -1) {
                    i6 = 1 + optInt3;
                }
                optJSONObject2.put(str, i6);
                if (j4 <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long optInt4 = optJSONObject.optInt("avg_req_duration", -1);
                    optJSONObject.put("avg_req_duration", optInt4 == -1 ? j4 : ((optInt4 * (i7 - 1)) + j4) / i7);
                }
            } else {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("fail");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                    jSONObject.put("fail", optJSONObject3);
                }
                int optInt5 = optJSONObject3.optInt("times", -1);
                optJSONObject3.put("times", optInt5 == -1 ? 1 : optInt5 + 1);
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("error_code");
                if (optJSONObject4 == null) {
                    optJSONObject4 = new JSONObject();
                    optJSONObject3.put("error_code", optJSONObject4);
                }
                String str3 = "" + i5;
                int optInt6 = optJSONObject4.optInt(str3, -1);
                if (optInt6 != -1) {
                    i6 = 1 + optInt6;
                }
                optJSONObject4.put(str3, i6);
            }
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c(str2, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void c(int i4, int i5) {
        try {
            int w3 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("low_m_cnt", 0);
            int w4 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("clean_invalid_cnt", 0) + i4;
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("low_m_cnt", w3 + 1);
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("clean_invalid_cnt", w4);
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("force_clean_cnt", c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("force_clean_cnt", 0) + i5);
        } catch (Throwable unused) {
        }
    }

    public static void c(Map<String, Object> map) {
        try {
            int w3 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("low_m_cnt", 0);
            int w4 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("clean_invalid_cnt", 0);
            int w5 = c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).w("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", w3);
            jSONObject.put("invalid_cnt", w4);
            jSONObject.put("force_cnt", w5);
            map.put("low_m_clean", jSONObject);
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("low_m_cnt", 0);
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("clean_invalid_cnt", 0);
            c("evt_upload_info", com.bytedance.msdk.core.c.getContext()).c("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }
}
