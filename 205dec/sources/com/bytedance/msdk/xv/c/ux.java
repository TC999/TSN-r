package com.bytedance.msdk.xv.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.wv;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements sr<com.bytedance.msdk.core.gd.gd> {

    /* renamed from: c  reason: collision with root package name */
    private Context f28482c;

    public ux(Context context) {
        if (context != null) {
            this.f28482c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    /* renamed from: c */
    public synchronized void w(com.bytedance.msdk.core.gd.gd gdVar) {
        if (this.f28482c != null && gdVar != null) {
            wv c4 = wv.c("pacing_" + gdVar.w(), this.f28482c);
            String sr = gdVar.sr();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("unity_id", gdVar.sr());
                if (!gdVar.c()) {
                    jSONObject.put("waterfall_show_rules_version", gdVar.ux());
                    jSONObject.put("adn_rit_show_rules_version", gdVar.f());
                }
                jSONObject.put("timing_mode", gdVar.r());
                jSONObject.put("show_pacing", gdVar.gd() + "");
                jSONObject.put("show_pacing_rule_id", gdVar.p());
                jSONObject.put("show_time", gdVar.k() + "");
                c4.c(sr, jSONObject.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized void delete(String str) {
        if (!str.contains("_")) {
            if (this.f28482c != null && !TextUtils.isEmpty(str)) {
                wv.c("pacing_" + str, this.f28482c).f(str);
            }
        } else {
            throw new RuntimeException(" has slotId");
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized com.bytedance.msdk.core.gd.gd query(String str) {
        if (!str.contains("_")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c(wv.c("pacing_" + str, this.f28482c).w(str, ""), false);
        }
        throw new RuntimeException(" has slotId");
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized void delete(String str, String str2) {
        if (!str.contains("_")) {
            if (this.f28482c != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                wv c4 = wv.c("pacing_" + str, this.f28482c);
                c4.f(str + "_" + str2);
            }
        } else {
            throw new RuntimeException(" has slotId");
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized com.bytedance.msdk.core.gd.gd query(String str, String str2) {
        if (!str.contains("_")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            wv c4 = wv.c("pacing_" + str, this.f28482c);
            return c(c4.w(str + "_" + str2, ""), true);
        }
        throw new RuntimeException(" has slotId");
    }

    private com.bytedance.msdk.core.gd.gd c(String str, boolean z3) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] split = jSONObject.getString("unity_id").split("_");
            String str4 = split.length > 0 ? split[0] : "";
            String str5 = split.length > 1 ? split[1] : "";
            if (z3) {
                str2 = "";
                str3 = str2;
            } else {
                String string = jSONObject.getString("waterfall_show_rules_version");
                str3 = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string;
            }
            return new com.bytedance.msdk.core.gd.gd(str4, str5, str2, str3, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.msdk.xv.c.sr
    public synchronized void c(String str, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.msdk.core.gd.gd query = query(str);
        if (query != null) {
            query.c(j4);
            w(query);
        }
    }

    @Override // com.bytedance.msdk.xv.c.sr
    public synchronized void c(String str, String str2, long j4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.bytedance.msdk.core.gd.gd query = query(str, str2);
            if (query != null) {
                query.c(j4);
                w(query);
            }
        }
    }
}
