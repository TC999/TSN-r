package com.p518qq.p519e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.widget.NativeAdContainer;
import com.p518qq.p519e.comm.adevent.ADEvent;
import com.p518qq.p519e.comm.adevent.ADEventListener;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.p518qq.p519e.comm.compliance.DownloadConfirmCallBack;
import com.p518qq.p519e.comm.compliance.DownloadConfirmListener;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {

    /* renamed from: a */
    private NativeUnifiedADData f32837a;

    /* renamed from: b */
    private NativeADEventListener f32838b;

    /* renamed from: c */
    private NativeADMediaListener f32839c;

    /* renamed from: d */
    private DownloadConfirmListener f32840d;

    /* renamed from: e */
    private NegativeFeedbackListener f32841e;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter$UnifiedAdListener */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class UnifiedAdListener implements ADListener {
        private UnifiedAdListener() {
        }

        @Override // com.p518qq.p519e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeUnifiedADDataAdapter.m20377a(NativeUnifiedADDataAdapter.this, aDEvent) || NativeUnifiedADDataAdapter.m20376b(NativeUnifiedADDataAdapter.this, aDEvent)) {
                return;
            }
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = NativeUnifiedADDataAdapter.this;
            nativeUnifiedADDataAdapter.getClass();
            NativeUnifiedADDataAdapter.m20375c(nativeUnifiedADDataAdapter, aDEvent);
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f32837a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener());
        }
    }

    /* renamed from: a */
    static boolean m20377a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f32838b != null) {
            int type = aDEvent.getType();
            if (type == 103) {
                nativeUnifiedADDataAdapter.f32838b.onADExposed();
            } else if (type == 105) {
                NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.f32838b;
                if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                    ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.f32838b).onADClicked((View) aDEvent.getParam(View.class));
                } else {
                    nativeADEventListener.onADClicked();
                }
            } else if (type == 107) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeUnifiedADDataAdapter.f32838b.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 111) {
                nativeUnifiedADDataAdapter.f32838b.onADStatusChanged();
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    static boolean m20376b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f32839c != null) {
            switch (aDEvent.getType()) {
                case 201:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        nativeUnifiedADDataAdapter.f32839c.onVideoLoaded(num.intValue());
                    }
                    return true;
                case 202:
                    nativeUnifiedADDataAdapter.f32839c.onVideoStart();
                    return true;
                case 203:
                    nativeUnifiedADDataAdapter.f32839c.onVideoResume();
                    return true;
                case AdEventType.VIDEO_PAUSE /* 204 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoPause();
                    return true;
                case AdEventType.VIDEO_STOP /* 205 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoStop();
                    return true;
                case AdEventType.VIDEO_COMPLETE /* 206 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoCompleted();
                    return true;
                case AdEventType.VIDEO_ERROR /* 207 */:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 != null) {
                        nativeUnifiedADDataAdapter.f32839c.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    }
                    return true;
                case AdEventType.VIDEO_CLICKED /* 208 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoClicked();
                    return true;
                case AdEventType.VIDEO_INIT /* 209 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoInit();
                    return true;
                case AdEventType.VIDEO_READY /* 210 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoReady();
                    return true;
                case AdEventType.VIDEO_LOADING /* 211 */:
                    nativeUnifiedADDataAdapter.f32839c.onVideoLoading();
                    return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    static boolean m20375c(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f32841e != null && aDEvent.getType() == 304) {
            nativeUnifiedADDataAdapter.f32841e.onComplainSuccess();
            return true;
        }
        return false;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.f32837a.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f32837a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f32837a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f32837a.bindCTAViews(list);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        this.f32837a.bindImageViews(list, i);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.f32837a.bindImageViews(list, bArr);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f32839c = nativeADMediaListener;
        this.f32837a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f32837a.destroy();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f32837a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f32837a;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f32837a.getAdPatternType();
    }

    @Override // com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f32837a.getApkInfoUrl();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.f32837a.getAppMiitInfo();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f32837a.getAppPrice();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f32837a.getAppScore();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f32837a.getAppStatus();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.f32837a.getButtonText();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f32837a.getCTAText();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        return this.f32837a.getCustomizeVideo();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f32837a.getDesc();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f32837a.getDownloadCount();
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public int getECPM() {
        return this.f32837a.getECPM();
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public String getECPMLevel() {
        return this.f32837a.getECPMLevel();
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f32837a.getExtraInfo();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f32837a.getIconUrl();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f32837a.getImgList();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f32837a.getImgUrl();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f32837a.getPictureHeight();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f32837a.getPictureWidth();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f32837a.getProgress();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f32837a.getTitle();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f32837a.getVideoCurrentPosition();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f32837a.getVideoDuration();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f32837a.isAppAd();
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public boolean isValid() {
        return this.f32837a.isValid();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f32837a.isWeChatCanvasAd();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f32837a.negativeFeedback();
    }

    @Override // com.p518qq.p519e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f32840d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f32837a.pauseAppDownload();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f32837a.pauseVideo();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f32837a.resumeAppDownload();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f32837a.resumeVideo();
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f32837a.sendLossNotification(i, i2, str);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f32837a.sendLossNotification(map);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendWinNotification(int i) {
        this.f32837a.sendWinNotification(i);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f32837a.sendWinNotification(map);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void setBidECPM(int i) {
        this.f32837a.setBidECPM(i);
    }

    @Override // com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f32840d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f32837a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f32838b = nativeADEventListener;
    }

    @Override // com.p518qq.p519e.comm.p520pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f32841e = negativeFeedbackListener;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f32837a.setVideoMute(z);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f32837a.startVideo();
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f32837a.stopVideo();
    }
}
