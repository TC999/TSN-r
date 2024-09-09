package xyz.adscope.ad.model.http.request.ad;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ContextModel {
    private AppModel app;
    private DeviceModel device;
    private JSONObject ext;
    private RegsModel regs;
    private UserModel user;

    public AppModel getApp() {
        return this.app;
    }

    public DeviceModel getDevice() {
        return this.device;
    }

    public JSONObject getExt() {
        return this.ext;
    }

    public RegsModel getRegs() {
        return this.regs;
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

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setRegs(RegsModel regsModel) {
        this.regs = regsModel;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    public String toString() {
        return "{\"app\":" + this.app + ", \"user\":" + this.user + ", \"device\":" + this.device + ", \"regs\":" + this.regs + ", \"ext\":" + this.ext + '}';
    }
}
