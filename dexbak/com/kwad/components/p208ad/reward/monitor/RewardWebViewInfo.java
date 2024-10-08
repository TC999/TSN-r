package com.kwad.components.p208ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.components.ad.reward.monitor.RewardWebViewInfo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RewardWebViewInfo extends AbstractC9822a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
    public int status;
    public int timeType;
    public String event = "";
    public String url = "";
    public String source = "";
    public String sceneId = "";
    public String pageType = "";
    public long durationMs = -1;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }

    public RewardWebViewInfo setDurationMs(long j) {
        this.durationMs = j;
        return this;
    }

    public RewardWebViewInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public RewardWebViewInfo setPageType(String str) {
        this.pageType = str;
        return this;
    }

    public RewardWebViewInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public RewardWebViewInfo setSource(String str) {
        this.source = str;
        return this;
    }

    public RewardWebViewInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public RewardWebViewInfo setTimeType(int i) {
        this.timeType = i;
        return this;
    }

    public RewardWebViewInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
