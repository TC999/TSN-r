package com.mbridge.msdk.out;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class NativeListener {

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface FilpListener {
        void filpEvent(int i4);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface NativeAdListener {
        void onAdClick(Campaign campaign);

        void onAdFramesLoaded(List<Frame> list);

        void onAdLoadError(String str);

        void onAdLoaded(List<Campaign> list, int i4);

        void onLoggingImpression(int i4);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface NativeTrackingListener {
        void onDismissLoading(Campaign campaign);

        void onDownloadFinish(Campaign campaign);

        void onDownloadProgress(int i4);

        void onDownloadStart(Campaign campaign);

        void onFinishRedirection(Campaign campaign, String str);

        boolean onInterceptDefaultLoadingDialog();

        void onRedirectionFailed(Campaign campaign, String str);

        void onShowLoading(Campaign campaign);

        void onStartRedirection(Campaign campaign, String str);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Template {
        private int adNum;
        private int id;

        public Template(int i4, int i5) {
            this.id = i4;
            this.adNum = i5;
        }

        public int getAdNum() {
            return this.adNum;
        }

        public int getId() {
            return this.id;
        }

        public void setAdNum(int i4) {
            this.adNum = i4;
        }

        public void setId(int i4) {
            this.id = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface TrackingExListener extends NativeTrackingListener {
        void onLeaveApp();
    }
}
