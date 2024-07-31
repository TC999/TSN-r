package com.mbridge.msdk.out;

import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NativeListener {

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface FilpListener {
        void filpEvent(int i);
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface NativeAdListener {
        void onAdClick(Campaign campaign);

        void onAdFramesLoaded(List<Frame> list);

        void onAdLoadError(String str);

        void onAdLoaded(List<Campaign> list, int i);

        void onLoggingImpression(int i);
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface NativeTrackingListener {
        void onDismissLoading(Campaign campaign);

        void onDownloadFinish(Campaign campaign);

        void onDownloadProgress(int i);

        void onDownloadStart(Campaign campaign);

        void onFinishRedirection(Campaign campaign, String str);

        boolean onInterceptDefaultLoadingDialog();

        void onRedirectionFailed(Campaign campaign, String str);

        void onShowLoading(Campaign campaign);

        void onStartRedirection(Campaign campaign, String str);
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class Template {
        private int adNum;

        /* renamed from: id */
        private int f31657id;

        public Template(int i, int i2) {
            this.f31657id = i;
            this.adNum = i2;
        }

        public int getAdNum() {
            return this.adNum;
        }

        public int getId() {
            return this.f31657id;
        }

        public void setAdNum(int i) {
            this.adNum = i;
        }

        public void setId(int i) {
            this.f31657id = i;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface TrackingExListener extends NativeTrackingListener {
        void onLeaveApp();
    }
}
