package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RewardWebViewInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
    public int status;
    public int timeType;
    public String event = "";
    public String url = "";
    public String source = "";
    public String sceneId = "";
    public String pageType = "";
    public long durationMs = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }

    public RewardWebViewInfo setDurationMs(long j4) {
        this.durationMs = j4;
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

    public RewardWebViewInfo setStatus(int i4) {
        this.status = i4;
        return this;
    }

    public RewardWebViewInfo setTimeType(int i4) {
        this.timeType = i4;
        return this;
    }

    public RewardWebViewInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
