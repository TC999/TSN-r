package com.bytedance.sdk.openadsdk;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface TTDownloadEventLogger {
    void onDownloadConfigReady();

    void onEvent(JSONObject jSONObject);

    void onV3Event(JSONObject jSONObject);

    boolean shouldFilterOpenSdkLog();
}
