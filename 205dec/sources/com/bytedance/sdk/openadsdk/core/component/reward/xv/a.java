package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "\u8ddd\u79bb\u9886\u53d6\u5956\u52b1\u8fd8\u5269");
            jSONObject.put("number", this.f32765c);
            jSONObject.put("number_unit", "\u79d2");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        return xv(pVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 1;
    }
}
