package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import com.bytedance.msdk.api.AdSlot;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdSlotInner {

    /* renamed from: a */
    private String f490a;

    /* renamed from: b */
    private int f491b;

    /* renamed from: e */
    private int f494e;

    /* renamed from: f */
    private String f495f;

    /* renamed from: g */
    private String f496g;

    /* renamed from: h */
    private String f497h;

    /* renamed from: c */
    private int f492c = 1;

    /* renamed from: d */
    private int f493d = 0;
    public int ifTest = 0;

    public static AdSlot getShallowCopy(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()).setSupportDeepLink(adSlot.isSupportDeepLink()).setAdCount(adSlot.getAdCount()).setRewardName(adSlot.getRewardName()).setRewardAmount(adSlot.getRewardAmount()).setMediaExtra(adSlot.getMediaExtra()).setCustomData(adSlot.getCustomData()).setUserID(adSlot.getUserID()).setOrientation(adSlot.getOrientation()).setAdType(adSlot.getAdType()).setTTVideoOption(adSlot.getTTVideoOption()).setTTRequestExtraParams(adSlot.getReuestParam()).setAdStyleType(adSlot.getAdStyleType()).setBannerSize(adSlot.getBannerSize()).setAdmobNativeAdOptions(adSlot.getAdmobNativeAdOptions()).setGdtNativeAdLogoParams(adSlot.getGdtNativeAdLogoParams()).setSplashButtonType(adSlot.getSplashButtonType()).setDownloadType(adSlot.getDownloadType()).setTestSlotId(adSlot.getTestSlotId());
        AdSlot build = builder.build();
        build.setAdUnitId(adSlot.getAdUnitId());
        build.setVersion(adSlot.getVersion());
        build.setWaterfallId(adSlot.getWaterfallId());
        build.setAdloadSeq(adSlot.getAdloadSeq());
        build.setLinkedId(adSlot.getLinkedId());
        build.setSegmentId(adSlot.getSegmentId());
        build.setSegmentVersion(adSlot.getSegmentVersion());
        build.setReqType(adSlot.getReqType());
        build.setmWaterfallExtra(adSlot.getmWaterfallExtra());
        build.setTransparentParams(adSlot.getTransparentParams());
        build.setIfTest(adSlot.getIfTest());
        return build;
    }

    public int getAdloadSeq() {
        return this.f491b;
    }

    public int getIfTest() {
        return this.ifTest;
    }

    public String getLinkedId() {
        return this.f490a;
    }

    public int getPrimeRitReqType() {
        return this.f492c;
    }

    public int getReqType() {
        return this.f493d;
    }

    public int getSegmentId() {
        return this.f494e;
    }

    public String getSegmentVersion() {
        return this.f495f;
    }

    public String getTransparentParams() {
        return this.f496g;
    }

    public String getmWaterfallExtra() {
        return this.f497h;
    }

    public void setAdloadSeq(int i) {
        this.f491b = i;
    }

    public void setIfTest(int i) {
        this.ifTest = i;
    }

    public void setLinkedId(String str) {
        this.f490a = str;
    }

    public void setPrimeRitReqType(int i) {
        this.f492c = i;
    }

    public void setReqType(int i) {
        this.f493d = i;
    }

    public void setSegmentId(int i) {
        this.f494e = i;
    }

    public void setSegmentVersion(String str) {
        this.f495f = str;
    }

    public void setTransparentParams(String str) {
        this.f496g = str;
    }

    public void setmWaterfallExtra(String str) {
        this.f497h = str;
    }
}
