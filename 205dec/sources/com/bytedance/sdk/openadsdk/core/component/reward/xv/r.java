package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "\u53c2\u4e0e\u4e92\u52a8\u53ef\u4ee5\u9886\u53d6\u798f\u5229");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.85f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public boolean w() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        return xv(pVar);
    }
}
