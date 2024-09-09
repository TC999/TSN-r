package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    private int fp;
    private int ia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
        JSONObject w3;
        ox oxVar2 = this.ev;
        if (oxVar2 == null || (w3 = oxVar2.w()) == null) {
            return;
        }
        this.fp = w3.optInt("reduce_time");
        this.ia = w3.optInt("reduce_duration");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "\u606d\u559c\u83b7\u5f97\u52a0\u901f\u7279\u6743");
            jSONObject.put("reduce_time", this.fp + "s");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected void c(com.bytedance.sdk.openadsdk.core.widget.r rVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected void sr(p pVar) {
        if (pVar != null) {
            pVar.c(this.fp);
        }
        this.ev.c(true);
        if (pVar != null) {
            pVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public boolean w() {
        int i4;
        ox oxVar = this.ev;
        return (oxVar == null || !oxVar.f()) && this.fp > 0 && (i4 = this.ia) > 0 && this.f32766w < i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        return xv(pVar);
    }
}
