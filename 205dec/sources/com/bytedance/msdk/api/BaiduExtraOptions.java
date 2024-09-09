package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BaiduExtraOptions {
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;

    /* renamed from: a  reason: collision with root package name */
    private boolean f27312a;

    /* renamed from: b  reason: collision with root package name */
    private int f27313b;

    /* renamed from: c  reason: collision with root package name */
    private BaiduNativeSmartOptStyleParams f27314c;

    /* renamed from: d  reason: collision with root package name */
    private BaiduRequestParameters f27315d;

    /* renamed from: e  reason: collision with root package name */
    private BaiduSplashParams f27316e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27317f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27318g;

    /* renamed from: h  reason: collision with root package name */
    private String f27319h;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27320a;

        /* renamed from: b  reason: collision with root package name */
        private int f27321b;

        /* renamed from: c  reason: collision with root package name */
        private BaiduNativeSmartOptStyleParams f27322c;

        /* renamed from: d  reason: collision with root package name */
        private BaiduRequestParameters f27323d;

        /* renamed from: e  reason: collision with root package name */
        private BaiduSplashParams f27324e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27325f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f27326g;

        /* renamed from: h  reason: collision with root package name */
        private String f27327h;

        public final BaiduExtraOptions build() {
            return new BaiduExtraOptions(this);
        }

        public Builder setAppSid(String str) {
            this.f27327h = str;
            return this;
        }

        public Builder setBaiduNativeSmartOptStyleParams(BaiduNativeSmartOptStyleParams baiduNativeSmartOptStyleParams) {
            this.f27322c = baiduNativeSmartOptStyleParams;
            return this;
        }

        public Builder setBaiduRequestParameters(BaiduRequestParameters baiduRequestParameters) {
            this.f27323d = baiduRequestParameters;
            return this;
        }

        public Builder setBaiduSplashParams(BaiduSplashParams baiduSplashParams) {
            this.f27324e = baiduSplashParams;
            return this;
        }

        public Builder setCacheVideoOnlyWifi(boolean z3) {
            this.f27320a = z3;
            return this;
        }

        public Builder setGDTExtraOption(int i4) {
            this.f27321b = i4;
            return this;
        }

        public Builder setShowDialogOnSkip(boolean z3) {
            this.f27325f = z3;
            return this;
        }

        public Builder setUseRewardCountdown(boolean z3) {
            this.f27326g = z3;
            return this;
        }
    }

    public String getAppSid() {
        return this.f27319h;
    }

    public BaiduNativeSmartOptStyleParams getBaiduNativeSmartOptStyleParams() {
        return this.f27314c;
    }

    public BaiduRequestParameters getBaiduRequestParameters() {
        return this.f27315d;
    }

    public BaiduSplashParams getBaiduSplashParams() {
        return this.f27316e;
    }

    public int getDownloadAppConfirmPolicy() {
        return this.f27313b;
    }

    public boolean getShowDialogOnSkip() {
        return this.f27317f;
    }

    public boolean getUseRewardCountdown() {
        return this.f27318g;
    }

    public boolean isCacheVideoOnlyWifi() {
        return this.f27312a;
    }

    private BaiduExtraOptions(Builder builder) {
        this.f27312a = builder.f27320a;
        this.f27313b = builder.f27321b;
        this.f27314c = builder.f27322c;
        this.f27315d = builder.f27323d;
        this.f27316e = builder.f27324e;
        this.f27317f = builder.f27325f;
        this.f27318g = builder.f27326g;
        this.f27319h = builder.f27327h;
    }
}
