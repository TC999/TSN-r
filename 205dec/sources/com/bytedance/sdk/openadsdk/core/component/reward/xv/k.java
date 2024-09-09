package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "\u7ee7\u7eed\u89c2\u770b " + this.f32765c + "s \u53ef\u83b7\u5f97\u5956\u52b1");
            jSONObject.put("number", this.f32776k);
            jSONObject.put("number_unit", this.f32777p);
            jSONObject.put("remain_time", this.f32765c);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public boolean w() {
        if (m.xv(this.f32775f)) {
            try {
                return (Integer.parseInt(this.f32776k) == 0 || TextUtils.isEmpty(this.f32776k) || TextUtils.isEmpty(this.f32777p)) ? false : true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        return xv(pVar);
    }
}
