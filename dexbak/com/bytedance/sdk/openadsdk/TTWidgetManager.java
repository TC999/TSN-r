package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6387x;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class TTWidgetManager {
    public static TTWidgetManager create(View view) {
        if (view == null) {
            return null;
        }
        Bridge bridge = view.getTag() instanceof Bridge ? (Bridge) view.getTag() : null;
        if (bridge == null) {
            return null;
        }
        return new C6387x(bridge);
    }

    public abstract boolean updateWidgetWithType(int i, JSONObject jSONObject);
}
