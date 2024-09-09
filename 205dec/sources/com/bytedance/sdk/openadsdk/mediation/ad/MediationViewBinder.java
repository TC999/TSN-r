package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        protected int f36014a;
        protected int bk;

        /* renamed from: c  reason: collision with root package name */
        protected int f36015c;
        protected int ev;

        /* renamed from: f  reason: collision with root package name */
        protected int f36016f;
        protected int gd;

        /* renamed from: k  reason: collision with root package name */
        protected int f36017k;

        /* renamed from: p  reason: collision with root package name */
        protected int f36018p;

        /* renamed from: r  reason: collision with root package name */
        protected int f36019r;
        protected int sr;

        /* renamed from: t  reason: collision with root package name */
        protected Map<String, Integer> f36020t;
        protected int ux;

        /* renamed from: w  reason: collision with root package name */
        protected int f36021w;
        protected int xv;

        public Builder(int i4) {
            this.f36020t = Collections.emptyMap();
            this.f36015c = i4;
            this.f36020t = new HashMap();
        }

        public Builder addExtra(String str, int i4) {
            this.f36020t.put(str, Integer.valueOf(i4));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.f36020t = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i4) {
            this.sr = i4;
            return this;
        }

        public Builder descriptionTextId(int i4) {
            this.xv = i4;
            return this;
        }

        public Builder groupImage1Id(int i4) {
            this.f36018p = i4;
            return this;
        }

        public Builder groupImage2Id(int i4) {
            this.f36017k = i4;
            return this;
        }

        public Builder groupImage3Id(int i4) {
            this.f36014a = i4;
            return this;
        }

        public Builder iconImageId(int i4) {
            this.ux = i4;
            return this;
        }

        public Builder logoLayoutId(int i4) {
            this.gd = i4;
            return this;
        }

        public Builder mainImageId(int i4) {
            this.f36016f = i4;
            return this;
        }

        public Builder mediaViewIdId(int i4) {
            this.f36019r = i4;
            return this;
        }

        public Builder shakeViewContainerId(int i4) {
            this.bk = i4;
            return this;
        }

        public Builder sourceId(int i4) {
            this.ev = i4;
            return this;
        }

        public Builder titleId(int i4) {
            this.f36021w = i4;
            return this;
        }
    }

    protected MediationViewBinder(Builder builder) {
        this.layoutId = builder.f36015c;
        this.titleId = builder.f36021w;
        this.decriptionTextId = builder.xv;
        this.callToActionId = builder.sr;
        this.iconImageId = builder.ux;
        this.mainImageId = builder.f36016f;
        this.mediaViewId = builder.f36019r;
        this.sourceId = builder.ev;
        this.extras = builder.f36020t;
        this.groupImage1Id = builder.f36018p;
        this.groupImage2Id = builder.f36017k;
        this.groupImage3Id = builder.f36014a;
        this.logoLayoutId = builder.gd;
        this.shakeViewContainerId = builder.bk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
