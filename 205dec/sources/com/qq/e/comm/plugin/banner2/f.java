package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements UBVI, com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {

    /* renamed from: c  reason: collision with root package name */
    private final d f42101c;

    /* renamed from: d  reason: collision with root package name */
    private final a f42102d;

    public f(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener) {
        this(unifiedBannerView, activity, str, str2, str3, aDListener, l.f42027d);
    }

    private NativeExpressADView a() {
        return this.f42102d.b();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void destroy() {
        d1.a("gdt_tag_callback", "destroy()");
        NativeExpressADView b4 = this.f42102d.b();
        if (b4 != null) {
            b4.destroy();
        }
        this.f42101c.t();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void fetchAd() {
        d1.a("gdt_tag_callback", "fetchAd()");
        this.f42101c.fetchAd();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public String getAdNetWorkName() {
        return "";
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            return a4.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return this.f42101c.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return this.f42101c.getCompetitionWinUrls();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            return a4.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        NativeExpressADView a4 = a();
        return a4 != null ? a4.getECPMLevel() : "";
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            return a4.getBoundData().getExtraInfo();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.f42101c.getMediationPrice();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            return a4.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void onWindowFocusChanged(boolean z3) {
        d1.a("gdt_tag_callback", "onWindowFocusChanged hasWindowFocus: " + z3);
        try {
            this.f42101c.onWindowFocusChanged(z3);
        } catch (Throwable th) {
            x.b(th);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            a4.sendLossNotification(i4, i5, str);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            a4.sendWinNotification(i4);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            a4.setBidECPM(i4);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            a4.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        d1.a("gdt_tag_callback", "setLoadAdParams(loadAdParams)");
        this.f42101c.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.f42101c.setMediationId(str);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setRefresh(int i4) {
        d1.a("gdt_tag_callback", "setRefresh(refresh)");
        this.f42101c.setRefresh(i4);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
    }

    public f(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener, l lVar) {
        this.f42102d = new a(unifiedBannerView, aDListener);
        this.f42101c = new d(activity, new ADSize(-1, -2), str, str2, str3, this.f42102d, lVar);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            a4.sendLossNotification(map);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        NativeExpressADView a4 = a();
        if (a4 != null) {
            a4.sendWinNotification(map);
        }
    }
}
