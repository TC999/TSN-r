package com.bytedance.sdk.openadsdk.core.component.reward.c.w.c;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends c {
    public xv(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c c(p pVar) {
        return xv(pVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public boolean w() {
        return (TextUtils.isEmpty(this.f32777p) || TextUtils.isEmpty(this.f32776k)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reward_name", this.f32777p);
            jSONObject.put("reward_amount", this.f32776k);
            jSONObject.put("extra_info", this.f32243c);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }
}
