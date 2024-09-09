package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* renamed from: a  reason: collision with root package name */
    private MediationNativeToBannerListener f35992a;
    private float bk;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35993c;
    private Map<String, Object> ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35994f;
    private MediationSplashRequestInfo fp;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f35995k;

    /* renamed from: p  reason: collision with root package name */
    private String f35996p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f35997r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private float f35998t;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f35999w;
    private String xv;
    private String ys;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private MediationNativeToBannerListener f36000a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f36001c;
        private String ev;
        private MediationSplashRequestInfo fp;

        /* renamed from: k  reason: collision with root package name */
        private boolean f36003k;

        /* renamed from: p  reason: collision with root package name */
        private int f36004p;

        /* renamed from: r  reason: collision with root package name */
        private boolean f36005r;
        private float sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private boolean f36007w;
        private boolean xv;
        private String ys;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, Object> f36002f = new HashMap();
        private String gd = "";
        private float bk = 80.0f;

        /* renamed from: t  reason: collision with root package name */
        private float f36006t = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.f35993c = this.f36001c;
            mediationAdSlot.f35999w = this.f36007w;
            mediationAdSlot.f35997r = this.xv;
            mediationAdSlot.ux = this.sr;
            mediationAdSlot.f35994f = this.ux;
            mediationAdSlot.ev = this.f36002f;
            mediationAdSlot.gd = this.f36005r;
            mediationAdSlot.f35996p = this.ev;
            mediationAdSlot.xv = this.gd;
            mediationAdSlot.sr = this.f36004p;
            mediationAdSlot.f35995k = this.f36003k;
            mediationAdSlot.f35992a = this.f36000a;
            mediationAdSlot.bk = this.bk;
            mediationAdSlot.f35998t = this.f36006t;
            mediationAdSlot.ys = this.ys;
            mediationAdSlot.fp = this.fp;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z3) {
            this.f36003k = z3;
            return this;
        }

        public Builder setBidNotify(boolean z3) {
            this.f36005r = z3;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f36002f;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.f36000a = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.fp = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z3) {
            this.xv = z3;
            return this;
        }

        public Builder setRewardAmount(int i4) {
            this.f36004p = i4;
            return this;
        }

        public Builder setRewardName(String str) {
            this.gd = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.ev = str;
            return this;
        }

        public Builder setShakeViewSize(float f4, float f5) {
            this.bk = f4;
            this.f36006t = f5;
            return this;
        }

        public Builder setSplashPreLoad(boolean z3) {
            this.f36007w = z3;
            return this;
        }

        public Builder setSplashShakeButton(boolean z3) {
            this.f36001c = z3;
            return this;
        }

        public Builder setUseSurfaceView(boolean z3) {
            this.ux = z3;
            return this;
        }

        public Builder setVolume(float f4) {
            this.sr = f4;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.ys = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.ev;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.f35996p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.f35998t;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.bk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.ys;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.f35995k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.f35997r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.f35999w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.f35993c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.f35994f;
    }

    private MediationAdSlot() {
        this.xv = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.f35992a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.fp;
    }
}
