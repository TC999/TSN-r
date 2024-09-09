package xyz.adscope.amps.base;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSBidResult {
    private String bidType;
    private String channelName;
    private int ecpm;
    private int reason;

    public String getBidType() {
        return this.bidType;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public int getReason() {
        return this.reason;
    }

    public void setBidType(String str) {
        this.bidType = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setEcpm(int i4) {
        this.ecpm = i4;
    }

    public void setReason(int i4) {
        this.reason = i4;
    }
}
