package xyz.adscope.amps.model.config.response;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MediationModel {
    private List<SpaceModel> spaceList;
    private String version = "";
    private String appId = "";
    private String ext = "";
    private String customData = "";

    public String getAppId() {
        return this.appId;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getExt() {
        return this.ext;
    }

    public List<SpaceModel> getSpaceList() {
        return this.spaceList;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setSpaceList(List<SpaceModel> list) {
        this.spaceList = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"spaceList\":" + this.spaceList + ", \"version\":\"" + this.version + "\", \"appId\":\"" + this.appId + "\", \"ext\":\"" + this.ext + "\", \"customData\":\"" + this.customData + "\"}";
    }
}
