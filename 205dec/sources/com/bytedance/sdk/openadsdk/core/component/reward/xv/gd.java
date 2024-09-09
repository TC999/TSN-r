package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import com.bytedance.sdk.openadsdk.core.u.q;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends c {
    private String fp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
        q jm = this.f32775f.jm();
        if (jm != null) {
            this.fp = jm.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.fp);
            boolean z3 = false;
            try {
                if (Double.parseDouble(this.fp) != 0.0d) {
                    z3 = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z3);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.6f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public boolean w() {
        String str = this.fp;
        if (str == null || str.equals("0")) {
            return false;
        }
        return !TextUtils.isEmpty(this.fp);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        return xv(pVar);
    }
}
