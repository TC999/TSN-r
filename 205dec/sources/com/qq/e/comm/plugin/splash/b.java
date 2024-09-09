package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.util.d1;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements NSPVI {

    /* renamed from: c  reason: collision with root package name */
    private NSPVI f46029c;

    /* renamed from: d  reason: collision with root package name */
    private String f46030d;

    public b(Context context, String str, String str2, String str3) {
        if (com.qq.e.comm.plugin.e0.d.d.a(context).b(str2)) {
            this.f46029c = new c(context, str, str2);
        } else {
            this.f46029c = new e(context, str, str2, str3);
        }
        this.f46030d = str2;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        d1.a("gdt_tag_callback", "fetchAdOnly()");
        this.f46029c.fetchAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        d1.a("gdt_tag_callback", "fetchAndShowIn(container)");
        this.f46029c.fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAdOnly() {
        d1.a("gdt_tag_callback", "fetchFullScreenAdOnly()");
        this.f46029c.fetchFullScreenAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        d1.a("gdt_tag_callback", "fetchFullScreenAndShowIn(container)");
        this.f46029c.fetchFullScreenAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        d1.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f46029c.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f46029c.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f46029c.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f46029c.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f46029c.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public Bitmap getZoomOutBitmap() {
        return this.f46029c.getZoomOutBitmap();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        d1.a("gdt_tag_callback", "isValid()");
        return this.f46029c.isValid();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        d1.a("gdt_tag_callback", "preload()");
        this.f46029c.preload();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        this.f46029c.sendLossNotification(i4, i5, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        this.f46029c.sendWinNotification(i4);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        d1.a("gdt_tag_callback", "setAdListener(listener)");
        this.f46029c.setAdListener(aDListener);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        this.f46029c.setBidECPM(i4);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(int i4) {
        this.f46029c.setDeveloperLogo(i4);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f46029c.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i4) {
        d1.a("gdt_tag_callback", "setFetchDelay(fetchDelay)");
        this.f46029c.setFetchDelay(i4);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        d1.a("gdt_tag_callback", "setLoadAdParams(params)");
        this.f46029c.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f46029c.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    @Deprecated
    public void setSkipView(View view) {
        d1.a("gdt_tag_callback", "setSkipView(view)");
        this.f46029c.setSkipView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSupportZoomOut(boolean z3) {
        this.f46029c.setSupportZoomOut(z3);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        d1.a("gdt_tag_callback", "showAd(container)");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f46030d, com.qq.e.comm.plugin.b.g.SPLASH.d());
        this.f46029c.showAd(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showFullScreenAd(ViewGroup viewGroup) {
        d1.a("gdt_tag_callback", "showFullScreenAd(container)");
        com.qq.e.comm.plugin.util.u2.e.b().a(this.f46030d, com.qq.e.comm.plugin.b.g.SPLASH.d());
        this.f46029c.showFullScreenAd(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void zoomOutAnimationFinish() {
        this.f46029c.zoomOutAnimationFinish();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f46029c.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f46029c.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(byte[] bArr) {
        this.f46029c.setDeveloperLogo(bArr);
    }
}
