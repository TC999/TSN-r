package com.kwad.components.p208ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.components.ad.feed.monitor.FeedWebViewInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FeedWebViewInfo extends AbstractC9822a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
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

    public FeedWebViewInfo setDurationMs(long j) {
        this.durationMs = j;
        return this;
    }

    public FeedWebViewInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public FeedWebViewInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public FeedWebViewInfo setTimeType(int i) {
        this.timeType = i;
        return this;
    }

    public FeedWebViewInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
