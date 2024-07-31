package com.kwad.components.p208ad.splashscreen.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SplashWebMonitorInfo extends AbstractC9822a implements Serializable {
    private static final long serialVersionUID = 9047786030751346172L;
    public int status;
    public int timeType;
    public String event = "";
    public String url = "";
    public String sceneId = "";
    public long durationMs = -1;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }

    public SplashWebMonitorInfo setDurationMs(long j) {
        this.durationMs = j;
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

    public SplashWebMonitorInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public SplashWebMonitorInfo setTimeType(int i) {
        this.timeType = i;
        return this;
    }

    public SplashWebMonitorInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
