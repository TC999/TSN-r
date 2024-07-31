package com.bytedance.msdk.api;

import android.widget.FrameLayout;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdSlot extends AdSlotInner {
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

    /* renamed from: A */
    private AdmobNativeAdOptions f21535A;

    /* renamed from: B */
    private FrameLayout.LayoutParams f21536B;

    /* renamed from: C */
    private String f21537C;

    /* renamed from: D */
    private int f21538D;

    /* renamed from: E */
    private int f21539E;

    /* renamed from: i */
    private String f21540i;

    /* renamed from: j */
    private long f21541j;

    /* renamed from: k */
    private String f21542k;

    /* renamed from: l */
    private int f21543l;

    /* renamed from: m */
    private int f21544m;

    /* renamed from: n */
    private int f21545n;

    /* renamed from: o */
    private boolean f21546o;

    /* renamed from: p */
    private int f21547p;

    /* renamed from: q */
    private int f21548q;

    /* renamed from: r */
    private int f21549r;

    /* renamed from: s */
    private String f21550s;

    /* renamed from: t */
    private int f21551t;

    /* renamed from: u */
    private String f21552u;

    /* renamed from: v */
    private String f21553v;

    /* renamed from: w */
    private Map<String, String> f21554w;

    /* renamed from: x */
    private int f21555x;

    /* renamed from: y */
    private TTVideoOption f21556y;

    /* renamed from: z */
    private TTRequestExtraParams f21557z;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {

        /* renamed from: e */
        private String f21562e;

        /* renamed from: f */
        private int f21563f;

        /* renamed from: g */
        private String f21564g;

        /* renamed from: h */
        private Map<String, String> f21565h;

        /* renamed from: i */
        private String f21566i;

        /* renamed from: j */
        private int f21567j;

        /* renamed from: k */
        private int f21568k;

        /* renamed from: l */
        private TTVideoOption f21569l;

        /* renamed from: m */
        private TTRequestExtraParams f21570m;

        /* renamed from: p */
        private AdmobNativeAdOptions f21573p;

        /* renamed from: q */
        private FrameLayout.LayoutParams f21574q;

        /* renamed from: r */
        private String f21575r;

        /* renamed from: a */
        private int f21558a = 640;

        /* renamed from: b */
        private int f21559b = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;

        /* renamed from: c */
        private boolean f21560c = true;

        /* renamed from: d */
        private int f21561d = 1;

        /* renamed from: n */
        private int f21571n = 2;

        /* renamed from: o */
        private int f21572o = 3;

        /* renamed from: s */
        private int f21576s = 1;

        /* renamed from: t */
        private int f21577t = 0;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f21545n = this.f21561d;
            adSlot.f21546o = this.f21560c;
            adSlot.f21543l = this.f21558a;
            adSlot.f21544m = this.f21559b;
            adSlot.f21550s = this.f21562e;
            adSlot.f21551t = this.f21563f;
            adSlot.f21552u = this.f21564g;
            adSlot.f21554w = this.f21565h;
            adSlot.f21553v = this.f21566i;
            adSlot.f21555x = this.f21567j;
            adSlot.f21547p = this.f21568k;
            adSlot.f21548q = this.f21571n;
            adSlot.f21556y = this.f21569l;
            adSlot.f21557z = this.f21570m;
            adSlot.f21535A = this.f21573p;
            adSlot.f21549r = this.f21572o;
            adSlot.f21536B = this.f21574q;
            adSlot.f21537C = this.f21575r;
            adSlot.f21538D = this.f21576s;
            adSlot.f21539E = this.f21577t;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            this.f21561d = i;
            return this;
        }

        public Builder setAdStyleType(int i) {
            this.f21571n = i;
            return this;
        }

        public Builder setAdType(int i) {
            this.f21568k = i;
            return this;
        }

        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.f21573p = admobNativeAdOptions;
            return this;
        }

        public Builder setBannerSize(int i) {
            this.f21572o = i;
            return this;
        }

        public Builder setCustomData(Map<String, String> map) {
            this.f21565h = map;
            return this;
        }

        public Builder setDownloadType(int i) {
            this.f21577t = i;
            return this;
        }

        public Builder setGdtNativeAdLogoParams(FrameLayout.LayoutParams layoutParams) {
            this.f21574q = layoutParams;
            return this;
        }

        public Builder setImageAdSize(int i, int i2) {
            this.f21558a = i;
            this.f21559b = i2;
            return this;
        }

        @Deprecated
        public Builder setMediaExtra(String str) {
            this.f21564g = str;
            return this;
        }

        public Builder setOpenBaiduSplashDismissControl(boolean z) {
            return this;
        }

        public Builder setOpenGDTSplashDismissControl(boolean z) {
            return this;
        }

        public Builder setOrientation(int i) {
            this.f21567j = i;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.f21563f = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f21562e = str;
            return this;
        }

        public Builder setSplashButtonType(int i) {
            this.f21576s = i;
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z) {
            this.f21560c = z;
            return this;
        }

        public Builder setTTRequestExtraParams(TTRequestExtraParams tTRequestExtraParams) {
            this.f21570m = tTRequestExtraParams;
            return this;
        }

        public Builder setTTVideoOption(TTVideoOption tTVideoOption) {
            this.f21569l = tTVideoOption;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.f21575r = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f21566i = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.f21545n;
    }

    public int getAdStyleType() {
        return this.f21548q;
    }

    public int getAdType() {
        return this.f21547p;
    }

    public String getAdUnitId() {
        return this.f21540i;
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.f21535A;
    }

    public int getBannerSize() {
        return this.f21549r;
    }

    public Map<String, String> getCustomData() {
        return this.f21554w;
    }

    public int getDownloadType() {
        return this.f21539E;
    }

    public FrameLayout.LayoutParams getGdtNativeAdLogoParams() {
        return this.f21536B;
    }

    public int getImgAcceptedHeight() {
        return this.f21544m;
    }

    public int getImgAcceptedWidth() {
        return this.f21543l;
    }

    @Deprecated
    public String getMediaExtra() {
        return this.f21552u;
    }

    public int getOrientation() {
        return this.f21555x;
    }

    public TTRequestExtraParams getReuestParam() {
        if (this.f21557z == null) {
            this.f21557z = new TTRequestExtraParams();
        }
        return this.f21557z;
    }

    public int getRewardAmount() {
        return this.f21551t;
    }

    public String getRewardName() {
        return this.f21550s;
    }

    public int getSplashButtonType() {
        return this.f21538D;
    }

    public TTVideoOption getTTVideoOption() {
        return this.f21556y;
    }

    @Deprecated
    public String getTestSlotId() {
        return this.f21537C;
    }

    public String getUserID() {
        return this.f21553v;
    }

    @Deprecated
    public String getVersion() {
        return this.f21542k;
    }

    @Deprecated
    public long getWaterfallId() {
        return this.f21541j;
    }

    public boolean isSupportDeepLink() {
        return this.f21546o;
    }

    public void setAdCount(int i) {
        this.f21545n = i;
    }

    public void setAdType(int i) {
        this.f21547p = i;
    }

    public void setAdUnitId(String str) {
        this.f21540i = str;
    }

    public void setTTVideoOption(TTVideoOption tTVideoOption) {
        this.f21556y = tTVideoOption;
    }

    @Deprecated
    public void setTestSlotId(String str) {
        this.f21537C = str;
    }

    @Deprecated
    public void setVersion(String str) {
        this.f21542k = str;
    }

    @Deprecated
    public void setWaterfallId(long j) {
        this.f21541j = j;
    }

    private AdSlot() {
        this.f21548q = 2;
        this.f21549r = 3;
    }
}
