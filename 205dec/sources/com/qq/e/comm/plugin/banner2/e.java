package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements UBVI {

    /* renamed from: c  reason: collision with root package name */
    private final UBVI f42099c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42100d;

    public e(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        if (com.qq.e.comm.plugin.e0.d.d.a(activity).b(str2)) {
            this.f42099c = new g(unifiedBannerView, activity, str, str2, aDListener);
        } else {
            this.f42099c = new f(unifiedBannerView, activity, str, str2, str3, aDListener);
        }
        this.f42100d = str2;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void destroy() {
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f42100d, com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.d());
        this.f42099c.destroy();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void fetchAd() {
        this.f42099c.fetchAd();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public String getAdNetWorkName() {
        return this.f42099c.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f42099c.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f42099c.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f42099c.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f42099c.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f42099c.isValid();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void onWindowFocusChanged(boolean z3) {
        this.f42099c.onWindowFocusChanged(z3);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        this.f42099c.sendLossNotification(i4, i5, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        this.f42099c.sendWinNotification(i4);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        this.f42099c.setBidECPM(i4);
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f42099c.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f42099c.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setRefresh(int i4) {
        this.f42099c.setRefresh(i4);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f42099c.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f42099c.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f42099c.sendWinNotification(map);
    }
}
