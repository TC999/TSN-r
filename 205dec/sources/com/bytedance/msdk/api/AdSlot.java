package com.bytedance.msdk.api;

import android.widget.FrameLayout;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdSlot extends b {
    public static final int AUTO_HEIGHT = -2;
    public static final String CUSTOM_DATA_KEY_ADMOB = "admob";
    public static final String CUSTOM_DATA_KEY_BAIDU = "baidu";
    public static final String CUSTOM_DATA_KEY_GDT = "gdt";
    public static final String CUSTOM_DATA_KEY_KLEVIN = "klevin";
    public static final String CUSTOM_DATA_KEY_KS = "ks";
    public static final String CUSTOM_DATA_KEY_MINTEGRAL = "mintegral";
    public static final String CUSTOM_DATA_KEY_PANGLE = "pangle";
    public static final String CUSTOM_DATA_KEY_SIGMOB = "sigmob";
    public static final String CUSTOM_DATA_KEY_UNITY = "unity";
    public static final int FULL_WIDTH = -1;
    public static final int POSITION_BOTTOM = 2;
    public static final int POSITION_FEED = 3;
    public static final int POSITION_FULL_SCREEN = 5;
    public static final int POSITION_MIDDLE = 4;
    public static final int POSITION_TOP = 1;
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_EXPRESS_AD = 1;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_NATIVE_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    private AdmobNativeAdOptions A;
    private FrameLayout.LayoutParams B;
    private String C;
    private int D;
    private int E;

    /* renamed from: i  reason: collision with root package name */
    private String f27271i;

    /* renamed from: j  reason: collision with root package name */
    private long f27272j;

    /* renamed from: k  reason: collision with root package name */
    private String f27273k;

    /* renamed from: l  reason: collision with root package name */
    private int f27274l;

    /* renamed from: m  reason: collision with root package name */
    private int f27275m;

    /* renamed from: n  reason: collision with root package name */
    private int f27276n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f27277o;

    /* renamed from: p  reason: collision with root package name */
    private int f27278p;

    /* renamed from: q  reason: collision with root package name */
    private int f27279q;

    /* renamed from: r  reason: collision with root package name */
    private int f27280r;

    /* renamed from: s  reason: collision with root package name */
    private String f27281s;

    /* renamed from: t  reason: collision with root package name */
    private int f27282t;

    /* renamed from: u  reason: collision with root package name */
    private String f27283u;

    /* renamed from: v  reason: collision with root package name */
    private String f27284v;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, String> f27285w;

    /* renamed from: x  reason: collision with root package name */
    private int f27286x;

    /* renamed from: y  reason: collision with root package name */
    private TTVideoOption f27287y;

    /* renamed from: z  reason: collision with root package name */
    private TTRequestExtraParams f27288z;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class Builder {

        /* renamed from: e  reason: collision with root package name */
        private String f27293e;

        /* renamed from: f  reason: collision with root package name */
        private int f27294f;

        /* renamed from: g  reason: collision with root package name */
        private String f27295g;

        /* renamed from: h  reason: collision with root package name */
        private Map<String, String> f27296h;

        /* renamed from: i  reason: collision with root package name */
        private String f27297i;

        /* renamed from: j  reason: collision with root package name */
        private int f27298j;

        /* renamed from: k  reason: collision with root package name */
        private int f27299k;

        /* renamed from: l  reason: collision with root package name */
        private TTVideoOption f27300l;

        /* renamed from: m  reason: collision with root package name */
        private TTRequestExtraParams f27301m;

        /* renamed from: p  reason: collision with root package name */
        private AdmobNativeAdOptions f27304p;

        /* renamed from: q  reason: collision with root package name */
        private FrameLayout.LayoutParams f27305q;

        /* renamed from: r  reason: collision with root package name */
        private String f27306r;

        /* renamed from: a  reason: collision with root package name */
        private int f27289a = 640;

        /* renamed from: b  reason: collision with root package name */
        private int f27290b = 320;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27291c = true;

        /* renamed from: d  reason: collision with root package name */
        private int f27292d = 1;

        /* renamed from: n  reason: collision with root package name */
        private int f27302n = 2;

        /* renamed from: o  reason: collision with root package name */
        private int f27303o = 3;

        /* renamed from: s  reason: collision with root package name */
        private int f27307s = 1;

        /* renamed from: t  reason: collision with root package name */
        private int f27308t = 0;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f27276n = this.f27292d;
            adSlot.f27277o = this.f27291c;
            adSlot.f27274l = this.f27289a;
            adSlot.f27275m = this.f27290b;
            adSlot.f27281s = this.f27293e;
            adSlot.f27282t = this.f27294f;
            adSlot.f27283u = this.f27295g;
            adSlot.f27285w = this.f27296h;
            adSlot.f27284v = this.f27297i;
            adSlot.f27286x = this.f27298j;
            adSlot.f27278p = this.f27299k;
            adSlot.f27279q = this.f27302n;
            adSlot.f27287y = this.f27300l;
            adSlot.f27288z = this.f27301m;
            adSlot.A = this.f27304p;
            adSlot.f27280r = this.f27303o;
            adSlot.B = this.f27305q;
            adSlot.C = this.f27306r;
            adSlot.D = this.f27307s;
            adSlot.E = this.f27308t;
            return adSlot;
        }

        public Builder setAdCount(int i4) {
            this.f27292d = i4;
            return this;
        }

        public Builder setAdStyleType(int i4) {
            this.f27302n = i4;
            return this;
        }

        public Builder setAdType(int i4) {
            this.f27299k = i4;
            return this;
        }

        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.f27304p = admobNativeAdOptions;
            return this;
        }

        public Builder setBannerSize(int i4) {
            this.f27303o = i4;
            return this;
        }

        public Builder setCustomData(Map<String, String> map) {
            this.f27296h = map;
            return this;
        }

        public Builder setDownloadType(int i4) {
            this.f27308t = i4;
            return this;
        }

        public Builder setGdtNativeAdLogoParams(FrameLayout.LayoutParams layoutParams) {
            this.f27305q = layoutParams;
            return this;
        }

        public Builder setImageAdSize(int i4, int i5) {
            this.f27289a = i4;
            this.f27290b = i5;
            return this;
        }

        @Deprecated
        public Builder setMediaExtra(String str) {
            this.f27295g = str;
            return this;
        }

        public Builder setOpenBaiduSplashDismissControl(boolean z3) {
            return this;
        }

        public Builder setOpenGDTSplashDismissControl(boolean z3) {
            return this;
        }

        public Builder setOrientation(int i4) {
            this.f27298j = i4;
            return this;
        }

        public Builder setRewardAmount(int i4) {
            this.f27294f = i4;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f27293e = str;
            return this;
        }

        public Builder setSplashButtonType(int i4) {
            this.f27307s = i4;
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z3) {
            this.f27291c = z3;
            return this;
        }

        public Builder setTTRequestExtraParams(TTRequestExtraParams tTRequestExtraParams) {
            this.f27301m = tTRequestExtraParams;
            return this;
        }

        public Builder setTTVideoOption(TTVideoOption tTVideoOption) {
            this.f27300l = tTVideoOption;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f27306r = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f27297i = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.f27276n;
    }

    public int getAdStyleType() {
        return this.f27279q;
    }

    public int getAdType() {
        return this.f27278p;
    }

    public String getAdUnitId() {
        return this.f27271i;
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.A;
    }

    public int getBannerSize() {
        return this.f27280r;
    }

    public Map<String, String> getCustomData() {
        return this.f27285w;
    }

    public int getDownloadType() {
        return this.E;
    }

    public FrameLayout.LayoutParams getGdtNativeAdLogoParams() {
        return this.B;
    }

    public int getImgAcceptedHeight() {
        return this.f27275m;
    }

    public int getImgAcceptedWidth() {
        return this.f27274l;
    }

    @Deprecated
    public String getMediaExtra() {
        return this.f27283u;
    }

    public int getOrientation() {
        return this.f27286x;
    }

    public TTRequestExtraParams getReuestParam() {
        if (this.f27288z == null) {
            this.f27288z = new TTRequestExtraParams();
        }
        return this.f27288z;
    }

    public int getRewardAmount() {
        return this.f27282t;
    }

    public String getRewardName() {
        return this.f27281s;
    }

    public int getSplashButtonType() {
        return this.D;
    }

    public TTVideoOption getTTVideoOption() {
        return this.f27287y;
    }

    @Deprecated
    public String getTestSlotId() {
        return this.C;
    }

    public String getUserID() {
        return this.f27284v;
    }

    @Deprecated
    public String getVersion() {
        return this.f27273k;
    }

    @Deprecated
    public long getWaterfallId() {
        return this.f27272j;
    }

    public boolean isSupportDeepLink() {
        return this.f27277o;
    }

    public void setAdCount(int i4) {
        this.f27276n = i4;
    }

    public void setAdType(int i4) {
        this.f27278p = i4;
    }

    public void setAdUnitId(String str) {
        this.f27271i = str;
    }

    public void setTTVideoOption(TTVideoOption tTVideoOption) {
        this.f27287y = tTVideoOption;
    }

    @Deprecated
    public void setTestSlotId(String str) {
        this.C = str;
    }

    @Deprecated
    public void setVersion(String str) {
        this.f27273k = str;
    }

    @Deprecated
    public void setWaterfallId(long j4) {
        this.f27272j = j4;
    }

    private AdSlot() {
        this.f27279q = 2;
        this.f27280r = 3;
    }
}
