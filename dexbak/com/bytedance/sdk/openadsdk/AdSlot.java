package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdSlot implements SlotType {

    /* renamed from: a */
    private int f22247a;

    /* renamed from: bl */
    private int f22248bl;

    /* renamed from: ep */
    private int f22249ep;

    /* renamed from: h */
    private boolean f22250h;

    /* renamed from: i */
    private int[] f22251i;

    /* renamed from: io */
    private String f22252io;

    /* renamed from: j */
    private int f22253j;

    /* renamed from: k */
    private String f22254k;

    /* renamed from: kf */
    private int f22255kf;

    /* renamed from: m */
    private IMediationAdSlot f22256m;

    /* renamed from: n */
    private float f22257n;

    /* renamed from: o */
    private String f22258o;

    /* renamed from: ok */
    private String f22259ok;

    /* renamed from: p */
    private boolean f22260p;

    /* renamed from: q */
    private boolean f22261q;

    /* renamed from: r */
    private String f22262r;

    /* renamed from: rh */
    private int f22263rh;

    /* renamed from: s */
    private float f22264s;

    /* renamed from: t */
    private boolean f22265t;

    /* renamed from: td */
    private String f22266td;

    /* renamed from: u */
    private String f22267u;

    /* renamed from: ul */
    private String f22268ul;

    /* renamed from: vz */
    private String f22269vz;

    /* renamed from: x */
    private int f22270x;

    /* renamed from: y */
    private TTAdLoadType f22271y;

    /* renamed from: z */
    private int f22272z;

    /* renamed from: zz */
    private String f22273zz;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Builder {

        /* renamed from: ep */
        private int f22276ep;

        /* renamed from: i */
        private int[] f22278i;

        /* renamed from: j */
        private int f22280j;

        /* renamed from: m */
        private IMediationAdSlot f22283m;

        /* renamed from: o */
        private String f22285o;

        /* renamed from: ok */
        private String f22286ok;

        /* renamed from: p */
        private String f22287p;

        /* renamed from: r */
        private int f22289r;

        /* renamed from: rh */
        private float f22290rh;

        /* renamed from: td */
        private String f22293td;

        /* renamed from: u */
        private String f22294u;

        /* renamed from: ul */
        private String f22295ul;

        /* renamed from: vz */
        private String f22296vz;

        /* renamed from: x */
        private int f22297x;

        /* renamed from: y */
        private String f22298y;

        /* renamed from: z */
        private float f22299z;

        /* renamed from: zz */
        private String f22300zz;

        /* renamed from: a */
        private int f22274a = 640;

        /* renamed from: bl */
        private int f22275bl = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;

        /* renamed from: s */
        private boolean f22291s = true;

        /* renamed from: n */
        private boolean f22284n = false;

        /* renamed from: kf */
        private boolean f22282kf = false;

        /* renamed from: h */
        private int f22277h = 1;

        /* renamed from: q */
        private String f22288q = "defaultUser";

        /* renamed from: k */
        private int f22281k = 2;

        /* renamed from: t */
        private boolean f22292t = true;

        /* renamed from: io */
        private TTAdLoadType f22279io = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f22259ok = this.f22286ok;
            adSlot.f22255kf = this.f22277h;
            adSlot.f22250h = this.f22291s;
            adSlot.f22260p = this.f22284n;
            adSlot.f22261q = this.f22282kf;
            adSlot.f22247a = this.f22274a;
            adSlot.f22248bl = this.f22275bl;
            adSlot.f22264s = this.f22299z;
            adSlot.f22257n = this.f22290rh;
            adSlot.f22254k = this.f22287p;
            adSlot.f22262r = this.f22288q;
            adSlot.f22253j = this.f22281k;
            adSlot.f22263rh = this.f22289r;
            adSlot.f22265t = this.f22292t;
            adSlot.f22251i = this.f22278i;
            adSlot.f22270x = this.f22297x;
            adSlot.f22266td = this.f22293td;
            adSlot.f22267u = this.f22295ul;
            adSlot.f22252io = this.f22285o;
            adSlot.f22268ul = this.f22298y;
            adSlot.f22272z = this.f22280j;
            adSlot.f22273zz = this.f22300zz;
            adSlot.f22258o = this.f22294u;
            adSlot.f22271y = this.f22279io;
            adSlot.f22269vz = this.f22296vz;
            adSlot.f22249ep = this.f22276ep;
            adSlot.f22256m = this.f22283m;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.f22277h = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.f22295ul = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.f22279io = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.f22280j = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.f22297x = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f22286ok = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.f22285o = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.f22299z = f;
            this.f22290rh = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.f22298y = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f22278i = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.f22274a = i;
            this.f22275bl = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.f22292t = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f22287p = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.f22283m = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.f22289r = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.f22281k = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f22293td = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.f22276ep = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f22296vz = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f22291s = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.f22294u = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f22288q = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.f22282kf = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.f22284n = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.f22300zz = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.f22255kf;
    }

    public String getAdId() {
        return this.f22267u;
    }

    public TTAdLoadType getAdLoadType() {
        return this.f22271y;
    }

    public int getAdType() {
        return this.f22272z;
    }

    public int getAdloadSeq() {
        return this.f22270x;
    }

    public String getBidAdm() {
        return this.f22273zz;
    }

    public String getCodeId() {
        return this.f22259ok;
    }

    public String getCreativeId() {
        return this.f22252io;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f22257n;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f22264s;
    }

    public String getExt() {
        return this.f22268ul;
    }

    public int[] getExternalABVid() {
        return this.f22251i;
    }

    public int getImgAcceptedHeight() {
        return this.f22248bl;
    }

    public int getImgAcceptedWidth() {
        return this.f22247a;
    }

    public String getMediaExtra() {
        return this.f22254k;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.f22256m;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.f22263rh;
    }

    public int getOrientation() {
        return this.f22253j;
    }

    public String getPrimeRit() {
        String str = this.f22266td;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.f22249ep;
    }

    public String getRewardName() {
        return this.f22269vz;
    }

    public String getUserData() {
        return this.f22258o;
    }

    public String getUserID() {
        return this.f22262r;
    }

    public boolean isAutoPlay() {
        return this.f22265t;
    }

    public boolean isSupportDeepLink() {
        return this.f22250h;
    }

    public boolean isSupportIconStyle() {
        return this.f22261q;
    }

    public boolean isSupportRenderConrol() {
        return this.f22260p;
    }

    public void setAdCount(int i) {
        this.f22255kf = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.f22271y = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.f22251i = iArr;
    }

    public void setGroupLoadMore(int i) {
        this.f22254k = m36838ok(this.f22254k, i);
    }

    public void setNativeAdType(int i) {
        this.f22263rh = i;
    }

    public void setUserData(String str) {
        this.f22258o = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f22259ok);
            jSONObject.put("mIsAutoPlay", this.f22265t);
            jSONObject.put("mImgAcceptedWidth", this.f22247a);
            jSONObject.put("mImgAcceptedHeight", this.f22248bl);
            jSONObject.put("mExpressViewAcceptedWidth", this.f22264s);
            jSONObject.put("mExpressViewAcceptedHeight", this.f22257n);
            jSONObject.put("mAdCount", this.f22255kf);
            jSONObject.put("mSupportDeepLink", this.f22250h);
            jSONObject.put("mSupportRenderControl", this.f22260p);
            jSONObject.put("mSupportIconStyle", this.f22261q);
            jSONObject.put("mMediaExtra", this.f22254k);
            jSONObject.put("mUserID", this.f22262r);
            jSONObject.put("mOrientation", this.f22253j);
            jSONObject.put("mNativeAdType", this.f22263rh);
            jSONObject.put("mAdloadSeq", this.f22270x);
            jSONObject.put("mPrimeRit", this.f22266td);
            jSONObject.put("mAdId", this.f22267u);
            jSONObject.put("mCreativeId", this.f22252io);
            jSONObject.put("mExt", this.f22268ul);
            jSONObject.put("mBidAdm", this.f22273zz);
            jSONObject.put("mUserData", this.f22258o);
            jSONObject.put("mAdLoadType", this.f22271y);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f22259ok + "', mImgAcceptedWidth=" + this.f22247a + ", mImgAcceptedHeight=" + this.f22248bl + ", mExpressViewAcceptedWidth=" + this.f22264s + ", mExpressViewAcceptedHeight=" + this.f22257n + ", mAdCount=" + this.f22255kf + ", mSupportDeepLink=" + this.f22250h + ", mSupportRenderControl=" + this.f22260p + ", mSupportIconStyle=" + this.f22261q + ", mMediaExtra='" + this.f22254k + "', mUserID='" + this.f22262r + "', mOrientation=" + this.f22253j + ", mNativeAdType=" + this.f22263rh + ", mIsAutoPlay=" + this.f22265t + ", mPrimeRit" + this.f22266td + ", mAdloadSeq" + this.f22270x + ", mAdId" + this.f22267u + ", mCreativeId" + this.f22252io + ", mExt" + this.f22268ul + ", mUserData" + this.f22258o + ", mAdLoadType" + this.f22271y + '}';
    }

    private AdSlot() {
        this.f22253j = 2;
        this.f22265t = true;
    }

    /* renamed from: ok */
    private String m36838ok(String str, int i) {
        JSONObject jSONObject;
        if (i < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }
}
