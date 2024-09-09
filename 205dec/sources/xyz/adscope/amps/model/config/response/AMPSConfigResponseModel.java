package xyz.adscope.amps.model.config.response;

import xyz.adscope.amps.model.AMPSBaseModel;
import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSConfigResponseModel extends AMPSBaseModel {
    private ConfigModel config;
    private String customData = "";
    private EventModel event;
    private long lastUpdateTime;
    private MediationModel mediation;

    public ConfigModel getConfig() {
        return this.config;
    }

    public String getCustomData() {
        return this.customData;
    }

    public EventModel getEvent() {
        return this.event;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public MediationModel getMediation() {
        return this.mediation;
    }

    public void setConfig(ConfigModel configModel) {
        this.config = configModel;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setEvent(EventModel eventModel) {
        this.event = eventModel;
    }

    public void setLastUpdateTime(long j4) {
        this.lastUpdateTime = j4;
    }

    public void setMediation(MediationModel mediationModel) {
        this.mediation = mediationModel;
    }

    public String toString() {
        return "{\"mediation\":" + this.mediation + ", \"event\":" + this.event + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"config\":" + this.config + ", \"lastUpdateTime\":" + this.lastUpdateTime + "} ";
    }
}
