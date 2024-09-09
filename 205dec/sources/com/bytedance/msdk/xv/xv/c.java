package com.bytedance.msdk.xv.xv;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.event.ad.IAdEvent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements IAdEvent {
    public static final String xv = UUID.randomUUID().toString();

    /* renamed from: c  reason: collision with root package name */
    public final String f28591c;

    /* renamed from: w  reason: collision with root package name */
    public final JSONObject f28592w;

    public c(String str, JSONObject jSONObject) {
        this.f28591c = str;
        this.f28592w = jSONObject;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f28591c) || this.f28592w == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.f28591c);
            jSONObject.putOpt("event", this.f28592w);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.ad.IAdEvent
    public JSONObject getDelayEvent(String str) {
        return this.f28592w;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.ad.IAdEvent
    public long getGlobalEventIndex() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.f28592w;
        if (jSONObject2 != null) {
            if (jSONObject2.has(EventMonitor.V3_PARAMS)) {
                jSONObject = this.f28592w.optJSONObject(EventMonitor.V3_PARAMS);
            } else {
                jSONObject = this.f28592w;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(EventMonitor.EVENT_EXTRA);
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        return new JSONObject(optString).optLong("eventIndex");
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return 0L;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.ad.IAdEvent
    public long getNewCreateTime() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.f28592w;
        if (jSONObject2 != null) {
            if (jSONObject2.has(EventMonitor.V3_PARAMS)) {
                jSONObject = this.f28592w.optJSONObject(EventMonitor.V3_PARAMS);
            } else {
                jSONObject = this.f28592w;
            }
            if (jSONObject != null) {
                return jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
            }
        }
        return 0L;
    }

    public String toString() {
        return "AdEvent{localId='" + this.f28591c + "', event=" + this.f28592w + '}';
    }
}
