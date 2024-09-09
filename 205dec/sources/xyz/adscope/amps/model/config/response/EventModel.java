package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EventModel {
    private List<EventLevelModel> eventLevel;
    private String version = "";
    private String customData = "";
    private String ext = "";

    public String getCustomData() {
        return this.customData;
    }

    public List<EventLevelModel> getEventLevel() {
        return this.eventLevel;
    }

    public String getExt() {
        return this.ext;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setEventLevel(List<EventLevelModel> list) {
        this.eventLevel = list;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"eventLevel\":" + this.eventLevel + ", \"version\":\"" + this.version + "\", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
