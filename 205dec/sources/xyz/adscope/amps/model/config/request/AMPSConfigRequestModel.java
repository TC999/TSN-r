package xyz.adscope.amps.model.config.request;

import xyz.adscope.amps.model.AMPSBaseModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSConfigRequestModel extends AMPSBaseModel {
    private AppModel app;
    private DeviceModel device;
    private String ext = "";
    private SdkModel sdk;
    private long time;
    private UserModel user;

    public AppModel getApp() {
        return this.app;
    }

    public DeviceModel getDevice() {
        return this.device;
    }

    public String getExt() {
        return this.ext;
    }

    public SdkModel getSdk() {
        return this.sdk;
    }

    public Long getTime() {
        return Long.valueOf(this.time);
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setApp(AppModel appModel) {
        this.app = appModel;
    }

    public void setDevice(DeviceModel deviceModel) {
        this.device = deviceModel;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setSdk(SdkModel sdkModel) {
        this.sdk = sdkModel;
    }

    public void setTime(Long l4) {
        this.time = l4.longValue();
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    public String toString() {
        return "{\"device\":" + this.device + ", \"app\":" + this.app + ", \"user\":" + this.user + ", \"ext\":\"" + this.ext + "\", \"time\":" + this.time + ", \"sdk\":" + this.sdk + "} ";
    }
}
