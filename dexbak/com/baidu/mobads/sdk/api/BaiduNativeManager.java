package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.C2584ad;
import com.baidu.mobads.sdk.internal.C2592al;
import com.baidu.mobads.sdk.internal.C2692dj;
import com.baidu.mobads.sdk.internal.C2705f;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final String TAG = "BaiduNativeManager";
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final String mAdPlacementId;
    private String mAppSid;
    private int mBidFloor;
    private final Context mContext;
    private RequestParameters mRequestParameters;
    private int mTimeoutMillis;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i, String str);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, (int) FEED_TIMEOUT);
    }

    private String getAdPlacemenId(RequestParameters requestParameters) {
        if (requestParameters != null) {
            String adPlacementId = requestParameters.getAdPlacementId();
            if (!TextUtils.isEmpty(adPlacementId)) {
                return adPlacementId;
            }
        }
        return this.mAdPlacementId;
    }

    private int getBidFloor(RequestParameters requestParameters) {
        int bidFloor;
        return (requestParameters == null || (bidFloor = requestParameters.getBidFloor()) <= 0) ? this.mBidFloor : bidFloor;
    }

    private void loadBiddingAd(RequestParameters requestParameters, String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        C2692dj c2692dj = new C2692dj(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2692dj.m50809h(this.mAppSid);
        }
        c2692dj.f8671p = getBidFloor(requestParameters);
        c2692dj.m50513c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            c2692dj.m50519a(new C2584ad(feedAdListener));
        } else if (expressAdListener != null) {
            c2692dj.m50522a(expressAdListener);
            c2692dj.m50526a(1);
        }
        c2692dj.m50518a(new C2592al());
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        c2692dj.m50521a(requestParameters);
        c2692dj.m50806m();
        c2692dj.m50811c(str2);
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        C2692dj c2692dj = new C2692dj(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        c2692dj.m50526a(1);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2692dj.m50809h(this.mAppSid);
        }
        c2692dj.f8671p = getBidFloor(requestParameters);
        c2692dj.m50521a(build);
        this.mRequestParameters = build;
        return c2692dj.m50806m();
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        C2692dj c2692dj = new C2692dj(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2692dj.m50809h(this.mAppSid);
        }
        c2692dj.f8671p = getBidFloor(requestParameters);
        c2692dj.m50521a(build);
        this.mRequestParameters = build;
        return c2692dj.m50806m();
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        C2692dj c2692dj = new C2692dj(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2692dj.m50809h(this.mAppSid);
        }
        c2692dj.f8671p = getBidFloor(requestParameters);
        c2692dj.m50521a(build);
        this.mRequestParameters = build;
        return c2692dj.m50806m();
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        C2705f c2705f = new C2705f(this.mContext, new C2584ad(feedAdListener), new C2692dj(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50407b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        C2705f c2705f = new C2705f(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50407b(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        C2705f c2705f = new C2705f(this.mContext, getAdPlacemenId(requestParameters), new C2584ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50407b(requestParameters);
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        C2705f c2705f = new C2705f(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50407b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        C2705f c2705f = new C2705f(this.mContext, new C2584ad(feedAdListener), new C2692dj(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50407b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        C2705f c2705f = new C2705f(this.mContext, getAdPlacemenId(requestParameters), new C2584ad(feedAdListener), this.isCacheVideo, FEED_TIMEOUT, IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50407b(requestParameters);
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.isCacheVideoOnlyWifi = z;
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        C2705f c2705f = new C2705f(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50412a(requestParameters);
        c2705f.m50410a(str);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        C2705f c2705f = new C2705f(this.mContext, getAdPlacemenId(requestParameters), new C2584ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50412a(requestParameters);
        c2705f.m50410a(str);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        C2705f c2705f = new C2705f(this.mContext, new C2584ad(portraitVideoAdListener), new C2692dj(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50412a(requestParameters);
        c2705f.m50410a(str);
    }

    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        C2705f c2705f = new C2705f(this.mContext, new C2584ad(feedAdListener), new C2692dj(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            c2705f.m50406b(this.mAppSid);
        }
        c2705f.m50413a(getBidFloor(requestParameters));
        c2705f.m50409a(this.isCacheVideoOnlyWifi);
        c2705f.m50411a(new C2592al());
        c2705f.m50407b(requestParameters);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, FEED_TIMEOUT);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i;
    }
}
