package com.kwad.components.ad.splashscreen.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SplashWebMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = 9047786030751346172L;
    public int status;
    public int timeType;
    public String event = "";
    public String url = "";
    public String sceneId = "";
    public long durationMs = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }

    public SplashWebMonitorInfo setDurationMs(long j4) {
        this.durationMs = j4;
        return this;
    }

    public SplashWebMonitorInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public SplashWebMonitorInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public SplashWebMonitorInfo setStatus(int i4) {
        this.status = i4;
        return this;
    }

    public SplashWebMonitorInfo setTimeType(int i4) {
        this.timeType = i4;
        return this;
    }

    public SplashWebMonitorInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
