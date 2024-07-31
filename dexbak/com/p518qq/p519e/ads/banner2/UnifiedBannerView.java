package com.p518qq.p519e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface;
import com.p518qq.p519e.comm.compliance.DownloadConfirmListener;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.listeners.ADRewardListener;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.p520pi.IBidding;
import com.p518qq.p519e.comm.p520pi.IReward;
import com.p518qq.p519e.comm.p520pi.NFBI;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.qq.e.ads.banner2.UnifiedBannerView */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {

    /* renamed from: a */
    final UnifiedBannerAD f32744a;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f32744a = new UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        m20406a();
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.m20307e(UnifiedBannerView.class.getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.f32744a = new UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        m20406a();
    }

    /* renamed from: a */
    private void m20406a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.f32744a.destroy();
    }

    public String getAdNetWorkName() {
        return this.f32744a.getAdNetWorkName();
    }

    @Override // com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f32744a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.f32744a.getECPM();
    }

    public String getECPMLevel() {
        return this.f32744a.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.f32744a.getExtraInfo();
    }

    public boolean isValid() {
        return this.f32744a.isValid();
    }

    public void loadAD() {
        this.f32744a.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f32744a.onWindowFocusChanged(z);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f32744a.sendLossNotification(i, i2, str);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f32744a.sendLossNotification(map);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendWinNotification(int i) {
        this.f32744a.sendWinNotification(i);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f32744a.sendWinNotification(map);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void setBidECPM(int i) {
        this.f32744a.setBidECPM(i);
    }

    @Override // com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f32744a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f32744a.setLoadAdParams(loadAdParams);
    }

    @Override // com.p518qq.p519e.comm.p520pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f32744a.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i) {
        this.f32744a.m20407c(i);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f32744a.setRewardListener(aDRewardListener);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f32744a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }
}
