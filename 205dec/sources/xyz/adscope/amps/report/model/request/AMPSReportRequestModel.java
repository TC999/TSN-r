package xyz.adscope.amps.report.model.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSReportRequestModel {
    private AdModel ad;
    private AppModel app;
    private DeviceModel device;
    private EventModel eventModel;
    private SdkModel sdk;
    private UserModel user;

    public AMPSReportRequestModel() {
    }

    public AdModel getAd() {
        return this.ad;
    }

    public AppModel getApp() {
        return this.app;
    }

    public DeviceModel getDevice() {
        return this.device;
    }

    public EventModel getEventModel() {
        return this.eventModel;
    }

    public SdkModel getSdk() {
        return this.sdk;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setAd(AdModel adModel) {
        this.ad = adModel;
    }

    public void setApp(AppModel appModel) {
        this.app = appModel;
    }

    public void setDevice(DeviceModel deviceModel) {
        this.device = deviceModel;
    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
    }

    public void setSdk(SdkModel sdkModel) {
        this.sdk = sdkModel;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    public String toString() {
        return "{\"eventModel\":" + this.eventModel + ", \"app\":" + this.app + ", \"device\":" + this.device + ", \"user\":" + this.user + ", \"ad\":" + this.ad + ", \"sdk\":" + this.sdk + '}';
    }

    public AMPSReportRequestModel(AMPSReportRequestModel aMPSReportRequestModel) {
        this.eventModel = aMPSReportRequestModel.getEventModel();
        this.app = aMPSReportRequestModel.getApp();
        this.device = aMPSReportRequestModel.getDevice();
        this.user = aMPSReportRequestModel.getUser();
        this.sdk = aMPSReportRequestModel.getSdk();
        this.ad = aMPSReportRequestModel.getAd();
    }
}
