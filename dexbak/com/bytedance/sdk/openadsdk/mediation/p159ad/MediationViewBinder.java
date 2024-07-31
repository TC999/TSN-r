package com.bytedance.sdk.openadsdk.mediation.p159ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    /* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder$Builder */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {

        /* renamed from: a */
        protected int f22676a;

        /* renamed from: bl */
        protected int f22677bl;

        /* renamed from: h */
        protected int f22678h;

        /* renamed from: j */
        protected int f22679j;

        /* renamed from: k */
        protected int f22680k;

        /* renamed from: kf */
        protected int f22681kf;

        /* renamed from: n */
        protected int f22682n;

        /* renamed from: ok */
        protected int f22683ok;

        /* renamed from: p */
        protected int f22684p;

        /* renamed from: q */
        protected int f22685q;

        /* renamed from: r */
        protected int f22686r;

        /* renamed from: rh */
        protected Map<String, Integer> f22687rh;

        /* renamed from: s */
        protected int f22688s;

        /* renamed from: z */
        protected int f22689z;

        public Builder(int i) {
            this.f22687rh = Collections.emptyMap();
            this.f22683ok = i;
            this.f22687rh = new HashMap();
        }

        public Builder addExtra(String str, int i) {
            this.f22687rh.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.f22687rh = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i) {
            this.f22688s = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.f22677bl = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.f22680k = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.f22686r = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.f22679j = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.f22682n = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.f22685q = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.f22681kf = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.f22678h = i;
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.f22689z = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.f22684p = i;
            return this;
        }

        public Builder titleId(int i) {
            this.f22676a = i;
            return this;
        }
    }

    protected MediationViewBinder(Builder builder) {
        this.layoutId = builder.f22683ok;
        this.titleId = builder.f22676a;
        this.decriptionTextId = builder.f22677bl;
        this.callToActionId = builder.f22688s;
        this.iconImageId = builder.f22682n;
        this.mainImageId = builder.f22681kf;
        this.mediaViewId = builder.f22678h;
        this.sourceId = builder.f22684p;
        this.extras = builder.f22687rh;
        this.groupImage1Id = builder.f22680k;
        this.groupImage2Id = builder.f22686r;
        this.groupImage3Id = builder.f22679j;
        this.logoLayoutId = builder.f22685q;
        this.shakeViewContainerId = builder.f22689z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
