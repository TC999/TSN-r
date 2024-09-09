package com.bytedance.sdk.openadsdk.core.component.reward;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.n;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private String f32693c;

    /* renamed from: w  reason: collision with root package name */
    private static com.bytedance.sdk.component.f.c f32692w = ba.c("full_reward_cache_file");
    private static com.bytedance.sdk.component.f.c xv = ba.c("full_reward_adslot");
    private static com.bytedance.sdk.component.f.c sr = ba.c("full_reward_adslot_preload");

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str) {
        this.f32693c = TextUtils.isEmpty(str) ? "" : str;
    }

    private String r(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.f32693c + "_cache_" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(String str) {
        try {
            return new JSONObject(f32692w.w(r(str), "")).optString("material_data", "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.ys.w.xv.w f(String str) {
        try {
            return n.c(xv.w(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int sr(String str) {
        try {
            return new JSONObject(f32692w.w(r(str), "")).optInt("data_sdk_version", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ux(String str) {
        try {
            f32692w.c(r(str));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long w(String str) {
        try {
            return new JSONObject(f32692w.w(r(str), "")).optLong("create_time", 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xv(String str) {
        try {
            return new JSONObject(f32692w.w(r(str), "")).optBoolean("has_played", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("has_played", false);
            jSONObject.put("create_time", System.currentTimeMillis());
            jSONObject.put("material_data", str2);
            jSONObject.put("data_sdk_version", 6106);
            f32692w.c(r(str), jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (wVar != null) {
            try {
                if (TextUtils.isEmpty(wVar.f())) {
                    return;
                }
                sr.c("preload_data", n.c(wVar).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (wVar != null) {
            try {
                if (TextUtils.isEmpty(wVar.f())) {
                    return;
                }
                xv.c(wVar.f(), n.c(wVar).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        if (wVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                xv.c(str, n.c(wVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.ys.w.xv.w c(boolean z3) {
        try {
            String w3 = sr.w("preload_data", (String) null);
            if (z3) {
                sr.w();
            }
            return n.c(w3);
        } catch (Throwable unused) {
            return null;
        }
    }
}
