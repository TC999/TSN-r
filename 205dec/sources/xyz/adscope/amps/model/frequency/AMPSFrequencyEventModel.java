package xyz.adscope.amps.model.frequency;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSFrequencyEventModel {
    private String adSourceSpaceId;
    private String eventCode;
    private String eventTime;
    private String mediationSpaceId;

    public AMPSFrequencyEventModel() {
    }

    public String getAdSourceSpaceId() {
        return this.adSourceSpaceId;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public String getMediationSpaceId() {
        return this.mediationSpaceId;
    }

    public void setAdSourceSpaceId(String str) {
        this.adSourceSpaceId = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventTime(String str) {
        this.eventTime = str;
    }

    public void setMediationSpaceId(String str) {
        this.mediationSpaceId = str;
    }

    public AMPSFrequencyEventModel(String str, String str2) {
        this.adSourceSpaceId = str;
        this.eventCode = str2;
    }
}
