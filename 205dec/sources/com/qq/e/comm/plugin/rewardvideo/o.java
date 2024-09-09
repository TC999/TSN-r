package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o implements RVADI {

    /* renamed from: c  reason: collision with root package name */
    private RVADI f45986c;

    /* renamed from: d  reason: collision with root package name */
    private String f45987d;

    public o(Context context, String str, String str2, ADListener aDListener, String str3) {
        if (com.qq.e.comm.plugin.e0.d.d.a(context).b(str2)) {
            this.f45986c = new p(context, str, str2, aDListener);
        } else {
            this.f45986c = new c(context, str, str2, str3, aDListener);
        }
        this.f45987d = str2;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        d1.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f45986c.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f45986c.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        d1.a("gdt_tag_callback", "getECPM()");
        return this.f45986c.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        d1.a("gdt_tag_callback", "getECPMLevel()");
        return this.f45986c.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.RVADI
    @Deprecated
    public long getExpireTimestamp() {
        d1.a("gdt_tag_callback", "getExpireTimestamp()");
        return this.f45986c.getExpireTimestamp();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f45986c.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        d1.a("gdt_tag_callback", "getRewardAdType()");
        return this.f45986c.getRewardAdType();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        d1.a("gdt_tag_callback", "getVideoDuration()");
        return this.f45986c.getVideoDuration();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        d1.a("gdt_tag_callback", "hasShown()");
        return this.f45986c.hasShown();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        d1.a("gdt_tag_callback", "isValid()");
        return this.f45986c.isValid();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        d1.a("gdt_tag_callback", "loadAD()");
        this.f45986c.loadAD();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        this.f45986c.sendLossNotification(i4, i5, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        this.f45986c.sendWinNotification(i4);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        this.f45986c.setBidECPM(i4);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f45986c.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        d1.a("gdt_tag_callback", "setLoadAdParams(loadAdParams)");
        this.f45986c.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f45986c.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z3) {
        d1.a("gdt_tag_callback", "setVolumeOn(volumeOn)");
        this.f45986c.setVolumeOn(z3);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        d1.a("gdt_tag_callback", "showAD()");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f45987d, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.d());
        this.f45986c.showAD();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f45986c.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f45986c.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        d1.a("gdt_tag_callback", "showAD(activity)");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f45987d, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.d());
        this.f45986c.showAD(activity);
    }
}
