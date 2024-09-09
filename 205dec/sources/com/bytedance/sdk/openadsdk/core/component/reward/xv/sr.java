package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {
    private int fp;
    private String fz;
    private int ia;

    /* renamed from: s  reason: collision with root package name */
    private String f32769s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
        JSONObject optJSONObject;
        JSONObject w3 = oxVar.w();
        if (w3 == null || (optJSONObject = w3.optJSONObject(PangleAdapterUtils.MEDIA_EXTRA_COUPON)) == null) {
            return;
        }
        this.fp = optJSONObject.optInt(RewardPlus.AMOUNT);
        this.ia = optJSONObject.optInt("threshold");
        this.f32769s = optJSONObject.optString("start_time");
        this.fz = optJSONObject.optString("expire_time");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RewardPlus.AMOUNT, this.fp);
            jSONObject.put("threshold", "\u6ee1" + this.ia + "\u5143\u53ef\u7528");
            if (TextUtils.isEmpty(this.f32769s)) {
                if (TextUtils.isEmpty(this.fz)) {
                    str = "\u9886\u53d6\u5f53\u65e5\u8d7730\u5206\u949f\u5185\u6709\u6548";
                } else {
                    str = "\u6709\u6548\u671f\u81f3" + this.fz;
                }
            } else if (TextUtils.isEmpty(this.fz)) {
                str = "\u6709\u6548\u671f\u81f3" + this.f32769s;
            } else {
                str = "\u6709\u6548\u671f" + this.f32769s + "\u81f3" + this.fz;
            }
            jSONObject.put("start_time", this.f32769s);
            jSONObject.put("expire_text", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    protected float sr() {
        return 0.55f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public boolean w() {
        return (this.fp == 0 || this.ia == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public int xv() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        return xv(pVar);
    }
}
