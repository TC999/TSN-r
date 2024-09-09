package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class AdSlot implements SlotType {

    /* renamed from: a  reason: collision with root package name */
    private int f31284a;
    private int bl;
    private int ep;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31285h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f31286i;

    /* renamed from: io  reason: collision with root package name */
    private String f31287io;

    /* renamed from: j  reason: collision with root package name */
    private int f31288j;

    /* renamed from: k  reason: collision with root package name */
    private String f31289k;
    private int kf;

    /* renamed from: m  reason: collision with root package name */
    private IMediationAdSlot f31290m;

    /* renamed from: n  reason: collision with root package name */
    private float f31291n;

    /* renamed from: o  reason: collision with root package name */
    private String f31292o;
    private String ok;

    /* renamed from: p  reason: collision with root package name */
    private boolean f31293p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f31294q;

    /* renamed from: r  reason: collision with root package name */
    private String f31295r;
    private int rh;

    /* renamed from: s  reason: collision with root package name */
    private float f31296s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f31297t;
    private String td;

    /* renamed from: u  reason: collision with root package name */
    private String f31298u;
    private String ul;
    private String vz;

    /* renamed from: x  reason: collision with root package name */
    private int f31299x;

    /* renamed from: y  reason: collision with root package name */
    private TTAdLoadType f31300y;

    /* renamed from: z  reason: collision with root package name */
    private int f31301z;
    private String zz;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class Builder {
        private int ep;

        /* renamed from: i  reason: collision with root package name */
        private int[] f31304i;

        /* renamed from: j  reason: collision with root package name */
        private int f31306j;

        /* renamed from: m  reason: collision with root package name */
        private IMediationAdSlot f31308m;

        /* renamed from: o  reason: collision with root package name */
        private String f31310o;
        private String ok;

        /* renamed from: p  reason: collision with root package name */
        private String f31311p;

        /* renamed from: r  reason: collision with root package name */
        private int f31313r;
        private float rh;
        private String td;

        /* renamed from: u  reason: collision with root package name */
        private String f31316u;
        private String ul;
        private String vz;

        /* renamed from: x  reason: collision with root package name */
        private int f31317x;

        /* renamed from: y  reason: collision with root package name */
        private String f31318y;

        /* renamed from: z  reason: collision with root package name */
        private float f31319z;
        private String zz;

        /* renamed from: a  reason: collision with root package name */
        private int f31302a = 640;
        private int bl = 320;

        /* renamed from: s  reason: collision with root package name */
        private boolean f31314s = true;

        /* renamed from: n  reason: collision with root package name */
        private boolean f31309n = false;
        private boolean kf = false;

        /* renamed from: h  reason: collision with root package name */
        private int f31303h = 1;

        /* renamed from: q  reason: collision with root package name */
        private String f31312q = "defaultUser";

        /* renamed from: k  reason: collision with root package name */
        private int f31307k = 2;

        /* renamed from: t  reason: collision with root package name */
        private boolean f31315t = true;

        /* renamed from: io  reason: collision with root package name */
        private TTAdLoadType f31305io = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.ok = this.ok;
            adSlot.kf = this.f31303h;
            adSlot.f31285h = this.f31314s;
            adSlot.f31293p = this.f31309n;
            adSlot.f31294q = this.kf;
            adSlot.f31284a = this.f31302a;
            adSlot.bl = this.bl;
            adSlot.f31296s = this.f31319z;
            adSlot.f31291n = this.rh;
            adSlot.f31289k = this.f31311p;
            adSlot.f31295r = this.f31312q;
            adSlot.f31288j = this.f31307k;
            adSlot.rh = this.f31313r;
            adSlot.f31297t = this.f31315t;
            adSlot.f31286i = this.f31304i;
            adSlot.f31299x = this.f31317x;
            adSlot.td = this.td;
            adSlot.f31298u = this.ul;
            adSlot.f31287io = this.f31310o;
            adSlot.ul = this.f31318y;
            adSlot.f31301z = this.f31306j;
            adSlot.zz = this.zz;
            adSlot.f31292o = this.f31316u;
            adSlot.f31300y = this.f31305io;
            adSlot.vz = this.vz;
            adSlot.ep = this.ep;
            adSlot.f31290m = this.f31308m;
            return adSlot;
        }

        public Builder setAdCount(int i4) {
            if (i4 <= 0) {
                i4 = 1;
            }
            if (i4 > 20) {
                i4 = 20;
            }
            this.f31303h = i4;
            return this;
        }

        public Builder setAdId(String str) {
            this.ul = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.f31305io = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i4) {
            this.f31306j = i4;
            return this;
        }

        public Builder setAdloadSeq(int i4) {
            this.f31317x = i4;
            return this;
        }

        public Builder setCodeId(String str) {
            this.ok = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.f31310o = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f4, float f5) {
            this.f31319z = f4;
            this.rh = f5;
            return this;
        }

        public Builder setExt(String str) {
            this.f31318y = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f31304i = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i4, int i5) {
            this.f31302a = i4;
            this.bl = i5;
            return this;
        }

        public Builder setIsAutoPlay(boolean z3) {
            this.f31315t = z3;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f31311p = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.f31308m = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i4) {
            this.f31313r = i4;
            return this;
        }

        public Builder setOrientation(int i4) {
            this.f31307k = i4;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.td = str;
            return this;
        }

        public Builder setRewardAmount(int i4) {
            this.ep = i4;
            return this;
        }

        public Builder setRewardName(String str) {
            this.vz = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z3) {
            this.f31314s = z3;
            return this;
        }

        public Builder setUserData(String str) {
            this.f31316u = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f31312q = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.kf = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.f31309n = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.zz = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.kf;
    }

    public String getAdId() {
        return this.f31298u;
    }

    public TTAdLoadType getAdLoadType() {
        return this.f31300y;
    }

    public int getAdType() {
        return this.f31301z;
    }

    public int getAdloadSeq() {
        return this.f31299x;
    }

    public String getBidAdm() {
        return this.zz;
    }

    public String getCodeId() {
        return this.ok;
    }

    public String getCreativeId() {
        return this.f31287io;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f31291n;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f31296s;
    }

    public String getExt() {
        return this.ul;
    }

    public int[] getExternalABVid() {
        return this.f31286i;
    }

    public int getImgAcceptedHeight() {
        return this.bl;
    }

    public int getImgAcceptedWidth() {
        return this.f31284a;
    }

    public String getMediaExtra() {
        return this.f31289k;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.f31290m;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.rh;
    }

    public int getOrientation() {
        return this.f31288j;
    }

    public String getPrimeRit() {
        String str = this.td;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.ep;
    }

    public String getRewardName() {
        return this.vz;
    }

    public String getUserData() {
        return this.f31292o;
    }

    public String getUserID() {
        return this.f31295r;
    }

    public boolean isAutoPlay() {
        return this.f31297t;
    }

    public boolean isSupportDeepLink() {
        return this.f31285h;
    }

    public boolean isSupportIconStyle() {
        return this.f31294q;
    }

    public boolean isSupportRenderConrol() {
        return this.f31293p;
    }

    public void setAdCount(int i4) {
        this.kf = i4;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.f31300y = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.f31286i = iArr;
    }

    public void setGroupLoadMore(int i4) {
        this.f31289k = ok(this.f31289k, i4);
    }

    public void setNativeAdType(int i4) {
        this.rh = i4;
    }

    public void setUserData(String str) {
        this.f31292o = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.ok);
            jSONObject.put("mIsAutoPlay", this.f31297t);
            jSONObject.put("mImgAcceptedWidth", this.f31284a);
            jSONObject.put("mImgAcceptedHeight", this.bl);
            jSONObject.put("mExpressViewAcceptedWidth", this.f31296s);
            jSONObject.put("mExpressViewAcceptedHeight", this.f31291n);
            jSONObject.put("mAdCount", this.kf);
            jSONObject.put("mSupportDeepLink", this.f31285h);
            jSONObject.put("mSupportRenderControl", this.f31293p);
            jSONObject.put("mSupportIconStyle", this.f31294q);
            jSONObject.put("mMediaExtra", this.f31289k);
            jSONObject.put("mUserID", this.f31295r);
            jSONObject.put("mOrientation", this.f31288j);
            jSONObject.put("mNativeAdType", this.rh);
            jSONObject.put("mAdloadSeq", this.f31299x);
            jSONObject.put("mPrimeRit", this.td);
            jSONObject.put("mAdId", this.f31298u);
            jSONObject.put("mCreativeId", this.f31287io);
            jSONObject.put("mExt", this.ul);
            jSONObject.put("mBidAdm", this.zz);
            jSONObject.put("mUserData", this.f31292o);
            jSONObject.put("mAdLoadType", this.f31300y);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.ok + "', mImgAcceptedWidth=" + this.f31284a + ", mImgAcceptedHeight=" + this.bl + ", mExpressViewAcceptedWidth=" + this.f31296s + ", mExpressViewAcceptedHeight=" + this.f31291n + ", mAdCount=" + this.kf + ", mSupportDeepLink=" + this.f31285h + ", mSupportRenderControl=" + this.f31293p + ", mSupportIconStyle=" + this.f31294q + ", mMediaExtra='" + this.f31289k + "', mUserID='" + this.f31295r + "', mOrientation=" + this.f31288j + ", mNativeAdType=" + this.rh + ", mIsAutoPlay=" + this.f31297t + ", mPrimeRit" + this.td + ", mAdloadSeq" + this.f31299x + ", mAdId" + this.f31298u + ", mCreativeId" + this.f31287io + ", mExt" + this.ul + ", mUserData" + this.f31292o + ", mAdLoadType" + this.f31300y + '}';
    }

    private AdSlot() {
        this.f31288j = 2;
        this.f31297t = true;
    }

    private String ok(String str, int i4) {
        JSONObject jSONObject;
        if (i4 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i4);
            return jSONObject.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return str;
        }
    }
}
