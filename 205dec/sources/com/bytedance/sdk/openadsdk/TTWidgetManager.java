package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.bl.ok.ok.x;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class TTWidgetManager {
    public static TTWidgetManager create(View view) {
        if (view == null) {
            return null;
        }
        Bridge bridge = view.getTag() instanceof Bridge ? (Bridge) view.getTag() : null;
        if (bridge == null) {
            return null;
        }
        return new x(bridge);
    }

    public abstract boolean updateWidgetWithType(int i4, JSONObject jSONObject);
}
