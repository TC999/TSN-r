package com.bytedance.sdk.openadsdk.core.ugeno.component.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.adsdk.ugeno.component.frame.UGFrameLayout;
import com.bytedance.adsdk.ugeno.w.h;
import k0.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends a {
    public c(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(long j4, long j5) {
        h hVar;
        JSONObject i4;
        if (!c(12) || (hVar = ((b) this).up.get(12)) == null || (i4 = hVar.i()) == null) {
            return;
        }
        i4.optString("type");
        JSONArray optJSONArray = i4.optJSONArray("actions");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("type");
                int optInt = optJSONObject.optInt("progress") * 1000;
                if (optInt > j5) {
                    optInt = (int) j5;
                }
                if (j4 == optInt && TextUtils.equals(optString, "onShow")) {
                    b w3 = w(this);
                    String optString2 = optJSONObject.optString("nodeId");
                    if (w3 != null) {
                        w3.w(optString2).w(0);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: fz */
    public UGFrameLayout xv() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(((b) this).f26040w);
        uGFrameLayout.a(this);
        return uGFrameLayout;
    }

    public void i() {
    }

    public void j() {
    }

    public void q() {
    }

    public void u() {
    }

    public void w() {
        super.w();
    }
}
