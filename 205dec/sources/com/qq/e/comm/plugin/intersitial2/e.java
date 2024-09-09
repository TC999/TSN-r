package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements UIADI {

    /* renamed from: c  reason: collision with root package name */
    UIADI f44432c;

    /* renamed from: d  reason: collision with root package name */
    private String f44433d;

    public e(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        if (com.qq.e.comm.plugin.e0.d.d.a(activity).b(str2)) {
            this.f44432c = new g(activity, str, str2, aDListener);
        } else {
            this.f44432c = new f(activity, str, str2, str3, aDListener);
        }
        this.f44433d = str2;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        d1.a("gdt_tag_callback", "close()");
        this.f44432c.close();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destroy() {
        d1.a("gdt_tag_callback", "destory()");
        this.f44432c.destroy();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        d1.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f44432c.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        d1.a("gdt_tag_callback", "getAdPatternType()");
        return this.f44432c.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f44432c.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        d1.a("gdt_tag_callback", "getECPM()");
        return this.f44432c.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        d1.a("gdt_tag_callback", "getECPMLevel()");
        return this.f44432c.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f44432c.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getVideoDuration() {
        return this.f44432c.getVideoDuration();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        d1.a("gdt_tag_callback", "isValid()");
        return this.f44432c.isValid();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        d1.a("gdt_tag_callback", "loadAd()");
        this.f44432c.loadAd();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        d1.a("gdt_tag_callback", "loadFullScreenAD()");
        this.f44432c.loadFullScreenAD();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        this.f44432c.sendLossNotification(i4, i5, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        this.f44432c.sendWinNotification(i4);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        this.f44432c.setBidECPM(i4);
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f44432c.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        d1.a("gdt_tag_callback", "setLoadAdParams(policy)");
        this.f44432c.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i4) {
        d1.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f44432c.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i4) {
        d1.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f44432c.setMinVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f44432c.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        d1.a("gdt_tag_callback", "setVideoOption(videoOption)");
        this.f44432c.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        d1.a("gdt_tag_callback", "show()");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f44433d, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.d());
        this.f44432c.show();
    }

    public void showAsPopupWindow() {
        d1.a("gdt_tag_callback", "showAsPopupWindow()");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f44433d, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.d());
        this.f44432c.show();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        d1.a("gdt_tag_callback", "showFullScreenAD(activity)");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f44433d, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN.d());
        this.f44432c.showFullScreenAD(activity);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f44432c.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f44432c.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        d1.a("gdt_tag_callback", "show(activity)");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f44433d, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.d());
        this.f44432c.show(activity);
    }

    public void showAsPopupWindow(Activity activity) {
        d1.a("gdt_tag_callback", "showAsPopupWindow(activity)");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f44433d, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.d());
        this.f44432c.show(activity);
    }
}
