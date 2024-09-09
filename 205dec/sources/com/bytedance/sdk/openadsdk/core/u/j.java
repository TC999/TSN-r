package com.bytedance.sdk.openadsdk.core.u;

import android.view.ViewGroup;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private String f34705c = "xeasy";

    /* renamed from: w  reason: collision with root package name */
    private String f34706w;
    private int xv;

    public j(me meVar, ViewGroup viewGroup) {
        JSONObject l4;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (meVar == null || viewGroup == null || (l4 = meVar.l()) == null || (optJSONObject = l4.optJSONObject("easy_playable")) == null || (optJSONObject2 = optJSONObject.optJSONObject("components")) == null) {
            return;
        }
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("vertical");
        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("horizontal");
        if (optJSONObject3 == null && optJSONObject4 == null) {
            return;
        }
        String str = this.f34705c;
        com.bytedance.sdk.component.utils.a.w(str, "w:" + viewGroup.getWidth() + " h:" + viewGroup.getHeight());
        if (optJSONObject3 != null && optJSONObject4 != null) {
            if (viewGroup.getWidth() > viewGroup.getHeight()) {
                c(optJSONObject4);
            } else {
                c(optJSONObject3);
            }
        } else if (optJSONObject3 != null) {
            com.bytedance.sdk.component.utils.a.w(this.f34705c, "v");
            c(optJSONObject3);
        } else {
            com.bytedance.sdk.component.utils.a.w(this.f34705c, "h");
            c(optJSONObject4);
        }
    }

    private void c(JSONObject jSONObject) {
        this.f34706w = jSONObject.optString("entry");
        this.xv = jSONObject.optInt("displayAreaAndroid");
    }

    public int w() {
        return this.xv;
    }

    public String c() {
        return this.f34706w;
    }
}
