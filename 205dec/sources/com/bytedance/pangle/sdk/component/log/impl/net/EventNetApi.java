package com.bytedance.pangle.sdk.component.log.impl.net;

import com.bytedance.pangle.sdk.component.log.impl.core.thread.AdEventUploadResult;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface EventNetApi<T> {
    AdEventUploadResult uploadEvent(List<T> list);

    AdEventUploadResult uploadStatsLog(JSONObject jSONObject);
}
