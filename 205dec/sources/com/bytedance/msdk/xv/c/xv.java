package com.bytedance.msdk.xv.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.wv;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements w<com.bytedance.msdk.core.gd.r> {

    /* renamed from: c  reason: collision with root package name */
    private Context f28483c;

    public xv(Context context) {
        if (context != null) {
            this.f28483c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private void xv(com.bytedance.msdk.core.gd.r rVar) {
        if (this.f28483c == null || rVar == null) {
            return;
        }
        wv c4 = wv.c("freqctl_" + rVar.w(), this.f28483c);
        JSONObject c5 = c(rVar, false);
        if (c5 != null) {
            c4.c(rVar.sr(), c5.toString());
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized void delete(String str) {
        if (this.f28483c != null && !TextUtils.isEmpty(str)) {
            wv.c("freqctl_" + str, this.f28483c).f(str);
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public synchronized void w(com.bytedance.msdk.core.gd.r rVar) {
        if (this.f28483c != null && rVar != null) {
            wv c4 = wv.c("freqctl_" + rVar.w(), this.f28483c);
            String sr = rVar.sr();
            JSONObject c5 = c(rVar, true);
            if (c5 != null) {
                c4.c(sr, c5.toString());
            }
        }
    }

    @Override // com.bytedance.msdk.xv.c.w
    /* renamed from: w */
    public synchronized void c(com.bytedance.msdk.core.gd.r rVar) {
        if (rVar != null) {
            xv(rVar);
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized com.bytedance.msdk.core.gd.r query(String str) {
        if (this.f28483c == null) {
            return null;
        }
        return c(wv.c("freqctl_" + str, this.f28483c).w(str, ""), false);
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized void delete(String str, String str2) {
        if (this.f28483c != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            wv c4 = wv.c("freqctl_" + str, this.f28483c);
            c4.f(str + "_" + str2);
        }
    }

    @Override // com.bytedance.msdk.xv.c.f
    public synchronized com.bytedance.msdk.core.gd.r query(String str, String str2) {
        if (this.f28483c == null) {
            return null;
        }
        wv c4 = wv.c("freqctl_" + str, this.f28483c);
        return c(c4.w(str + "_" + str2, ""), true);
    }

    private JSONObject c(com.bytedance.msdk.core.gd.r rVar, boolean z3) {
        if (rVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("unity_id", rVar.sr());
                if (rVar.c()) {
                    jSONObject.put("adn_rit_show_rules_version", rVar.f());
                } else {
                    jSONObject.put("waterfall_show_rules_version", rVar.ux());
                }
                jSONObject.put("timing_mode", rVar.r());
                jSONObject.put("show_freqctl_rules", z3 ? rVar.gd() : rVar.p());
                return jSONObject;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private com.bytedance.msdk.core.gd.r c(String str, boolean z3) {
        String string;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] split = jSONObject.getString("unity_id").split("_");
            String str3 = split.length > 0 ? split[0] : "";
            String str4 = split.length > 1 ? split[1] : "";
            if (z3) {
                str2 = jSONObject.getString("adn_rit_show_rules_version");
                string = "";
            } else {
                string = jSONObject.getString("waterfall_show_rules_version");
                str2 = "";
            }
            return new com.bytedance.msdk.core.gd.r(str3, str4, string, str2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
