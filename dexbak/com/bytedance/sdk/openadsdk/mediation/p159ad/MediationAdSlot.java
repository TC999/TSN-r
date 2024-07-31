package com.bytedance.sdk.openadsdk.mediation.p159ad;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* renamed from: a */
    private boolean f22631a;

    /* renamed from: bl */
    private String f22632bl;

    /* renamed from: h */
    private boolean f22633h;

    /* renamed from: i */
    private MediationSplashRequestInfo f22634i;

    /* renamed from: j */
    private MediationNativeToBannerListener f22635j;

    /* renamed from: k */
    private String f22636k;

    /* renamed from: kf */
    private boolean f22637kf;

    /* renamed from: n */
    private float f22638n;

    /* renamed from: ok */
    private boolean f22639ok;

    /* renamed from: p */
    private Map<String, Object> f22640p;

    /* renamed from: q */
    private boolean f22641q;

    /* renamed from: r */
    private boolean f22642r;

    /* renamed from: rh */
    private float f22643rh;

    /* renamed from: s */
    private int f22644s;

    /* renamed from: t */
    private String f22645t;

    /* renamed from: z */
    private float f22646z;

    /* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot$Builder */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {

        /* renamed from: a */
        private boolean f22647a;

        /* renamed from: bl */
        private boolean f22648bl;

        /* renamed from: h */
        private boolean f22649h;

        /* renamed from: i */
        private MediationSplashRequestInfo f22650i;

        /* renamed from: j */
        private MediationNativeToBannerListener f22651j;

        /* renamed from: k */
        private int f22652k;

        /* renamed from: n */
        private boolean f22654n;

        /* renamed from: ok */
        private boolean f22655ok;

        /* renamed from: p */
        private String f22656p;

        /* renamed from: r */
        private boolean f22658r;

        /* renamed from: s */
        private float f22660s;

        /* renamed from: t */
        private String f22661t;

        /* renamed from: kf */
        private Map<String, Object> f22653kf = new HashMap();

        /* renamed from: q */
        private String f22657q = "";

        /* renamed from: z */
        private float f22662z = 80.0f;

        /* renamed from: rh */
        private float f22659rh = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.f22639ok = this.f22655ok;
            mediationAdSlot.f22631a = this.f22647a;
            mediationAdSlot.f22633h = this.f22648bl;
            mediationAdSlot.f22638n = this.f22660s;
            mediationAdSlot.f22637kf = this.f22654n;
            mediationAdSlot.f22640p = this.f22653kf;
            mediationAdSlot.f22641q = this.f22649h;
            mediationAdSlot.f22636k = this.f22656p;
            mediationAdSlot.f22632bl = this.f22657q;
            mediationAdSlot.f22644s = this.f22652k;
            mediationAdSlot.f22642r = this.f22658r;
            mediationAdSlot.f22635j = this.f22651j;
            mediationAdSlot.f22646z = this.f22662z;
            mediationAdSlot.f22643rh = this.f22659rh;
            mediationAdSlot.f22645t = this.f22661t;
            mediationAdSlot.f22634i = this.f22650i;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.f22658r = z;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.f22649h = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f22653kf;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.f22651j = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.f22650i = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.f22648bl = z;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.f22652k = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f22657q = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f22656p = str;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.f22662z = f;
            this.f22659rh = f2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.f22647a = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.f22655ok = z;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.f22654n = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.f22660s = f;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.f22661t = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.f22640p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.f22644s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public String getRewardName() {
        return this.f22632bl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public String getScenarioId() {
        return this.f22636k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.f22643rh;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.f22646z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public float getVolume() {
        return this.f22638n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public String getWxAppId() {
        return this.f22645t;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.f22642r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.f22641q;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public boolean isMuted() {
        return this.f22633h;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.f22631a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.f22639ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.f22637kf;
    }

    private MediationAdSlot() {
        this.f22632bl = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.f22635j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.f22634i;
    }
}
