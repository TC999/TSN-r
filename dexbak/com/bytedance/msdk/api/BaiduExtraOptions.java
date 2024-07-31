package com.bytedance.msdk.api;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BaiduExtraOptions {
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;

    /* renamed from: a */
    private boolean f21581a;

    /* renamed from: b */
    private int f21582b;

    /* renamed from: c */
    private BaiduNativeSmartOptStyleParams f21583c;

    /* renamed from: d */
    private BaiduRequestParameters f21584d;

    /* renamed from: e */
    private BaiduSplashParams f21585e;

    /* renamed from: f */
    private boolean f21586f;

    /* renamed from: g */
    private boolean f21587g;

    /* renamed from: h */
    private String f21588h;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f21589a;

        /* renamed from: b */
        private int f21590b;

        /* renamed from: c */
        private BaiduNativeSmartOptStyleParams f21591c;

        /* renamed from: d */
        private BaiduRequestParameters f21592d;

        /* renamed from: e */
        private BaiduSplashParams f21593e;

        /* renamed from: f */
        private boolean f21594f;

        /* renamed from: g */
        private boolean f21595g;

        /* renamed from: h */
        private String f21596h;

        public final BaiduExtraOptions build() {
            return new BaiduExtraOptions(this);
        }

        public Builder setAppSid(String str) {
            this.f21596h = str;
            return this;
        }

        public Builder setBaiduNativeSmartOptStyleParams(BaiduNativeSmartOptStyleParams baiduNativeSmartOptStyleParams) {
            this.f21591c = baiduNativeSmartOptStyleParams;
            return this;
        }

        public Builder setBaiduRequestParameters(BaiduRequestParameters baiduRequestParameters) {
            this.f21592d = baiduRequestParameters;
            return this;
        }

        public Builder setBaiduSplashParams(BaiduSplashParams baiduSplashParams) {
            this.f21593e = baiduSplashParams;
            return this;
        }

        public Builder setCacheVideoOnlyWifi(boolean z) {
            this.f21589a = z;
            return this;
        }

        public Builder setGDTExtraOption(int i) {
            this.f21590b = i;
            return this;
        }

        public Builder setShowDialogOnSkip(boolean z) {
            this.f21594f = z;
            return this;
        }

        public Builder setUseRewardCountdown(boolean z) {
            this.f21595g = z;
            return this;
        }
    }

    public String getAppSid() {
        return this.f21588h;
    }

    public BaiduNativeSmartOptStyleParams getBaiduNativeSmartOptStyleParams() {
        return this.f21583c;
    }

    public BaiduRequestParameters getBaiduRequestParameters() {
        return this.f21584d;
    }

    public BaiduSplashParams getBaiduSplashParams() {
        return this.f21585e;
    }

    public int getDownloadAppConfirmPolicy() {
        return this.f21582b;
    }

    public boolean getShowDialogOnSkip() {
        return this.f21586f;
    }

    public boolean getUseRewardCountdown() {
        return this.f21587g;
    }

    public boolean isCacheVideoOnlyWifi() {
        return this.f21581a;
    }

    private BaiduExtraOptions(Builder builder) {
        this.f21581a = builder.f21589a;
        this.f21582b = builder.f21590b;
        this.f21583c = builder.f21591c;
        this.f21584d = builder.f21592d;
        this.f21585e = builder.f21593e;
        this.f21586f = builder.f21594f;
        this.f21587g = builder.f21595g;
        this.f21588h = builder.f21596h;
    }
}
