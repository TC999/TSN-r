package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ReportEvent implements InterfaceC9914b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class CustomStatEvent implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
            this.value = jSONObject.optString(DomainCampaignEx.LOOPBACK_VALUE);
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_KEY, this.key);
            C11126t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_VALUE, this.value);
            return jSONObject;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ExceptionEvent implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "type", this.type);
            C11126t.putValue(jSONObject, "message", this.message);
            C11126t.m23678a(jSONObject, "urlPackage", this.urlPackage);
            C11126t.putValue(jSONObject, "flag", this.flag);
            return jSONObject;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class StatPackage implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.m23678a(jSONObject, "exceptionEvent", this.exceptionEvent);
            C11126t.m23678a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class UrlPackage implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString("identity");
            this.pageType = jSONObject.optInt("pageType");
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "page", this.page);
            C11126t.putValue(jSONObject, "params", this.params);
            C11126t.putValue(jSONObject, "identity", this.identity);
            C11126t.putValue(jSONObject, "pageType", this.pageType);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString("sessionId");
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        C11126t.putValue(jSONObject, "clientIncrementId", this.clientIncrementId);
        C11126t.putValue(jSONObject, "sessionId", this.sessionId);
        C11126t.m23678a(jSONObject, "statPackage", this.statPackage);
        C11126t.putValue(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
