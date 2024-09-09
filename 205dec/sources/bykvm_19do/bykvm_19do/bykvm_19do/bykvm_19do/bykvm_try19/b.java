package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import com.bytedance.msdk.api.AdSlot;

/* compiled from: AdSlotInner.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f483a;

    /* renamed from: b  reason: collision with root package name */
    private int f484b;

    /* renamed from: e  reason: collision with root package name */
    private int f487e;

    /* renamed from: f  reason: collision with root package name */
    private String f488f;

    /* renamed from: g  reason: collision with root package name */
    private String f489g;

    /* renamed from: h  reason: collision with root package name */
    private String f490h;

    /* renamed from: c  reason: collision with root package name */
    private int f485c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f486d = 0;
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
        return this.f484b;
    }

    public int getIfTest() {
        return this.ifTest;
    }

    public String getLinkedId() {
        return this.f483a;
    }

    public int getPrimeRitReqType() {
        return this.f485c;
    }

    public int getReqType() {
        return this.f486d;
    }

    public int getSegmentId() {
        return this.f487e;
    }

    public String getSegmentVersion() {
        return this.f488f;
    }

    public String getTransparentParams() {
        return this.f489g;
    }

    public String getmWaterfallExtra() {
        return this.f490h;
    }

    public void setAdloadSeq(int i4) {
        this.f484b = i4;
    }

    public void setIfTest(int i4) {
        this.ifTest = i4;
    }

    public void setLinkedId(String str) {
        this.f483a = str;
    }

    public void setPrimeRitReqType(int i4) {
        this.f485c = i4;
    }

    public void setReqType(int i4) {
        this.f486d = i4;
    }

    public void setSegmentId(int i4) {
        this.f487e = i4;
    }

    public void setSegmentVersion(String str) {
        this.f488f = str;
    }

    public void setTransparentParams(String str) {
        this.f489g = str;
    }

    public void setmWaterfallExtra(String str) {
        this.f490h = str;
    }
}
