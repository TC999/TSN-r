package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.al;
import com.baidu.mobads.sdk.internal.dm;
import com.baidu.mobads.sdk.internal.f;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i4, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i4, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i4, String str);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i4, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i4, String str);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i4, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, (int) AVMDLDataLoader.KeyIsLiveSetLoaderType);
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
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.f12489p = getBidFloor(requestParameters);
        dmVar.c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            dmVar.a(new ad(feedAdListener));
        } else if (expressAdListener != null) {
            dmVar.a(expressAdListener);
            dmVar.a(1);
        }
        dmVar.a(new al());
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dmVar.a(requestParameters);
        dmVar.m();
        dmVar.c(str2);
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        dmVar.a(1);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.f12489p = getBidFloor(requestParameters);
        dmVar.a(build);
        this.mRequestParameters = build;
        return dmVar.m();
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.f12489p = getBidFloor(requestParameters);
        dmVar.a(build);
        this.mRequestParameters = build;
        return dmVar.m();
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        dm dmVar = new dm(this.mContext, getAdPlacemenId(requestParameters), "pvideo", this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters build = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dmVar.h(this.mAppSid);
        }
        dmVar.f12489p = getBidFloor(requestParameters);
        dmVar.a(build);
        this.mRequestParameters = build;
        return dmVar.m();
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, "pvideo", str, portraitVideoAdListener, null);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, new ad(feedAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, new ad(feedAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), "insite", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, AVMDLDataLoader.KeyIsLiveSetLoaderType, "preroll");
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.b(requestParameters);
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i4) {
        this.mBidFloor = i4;
    }

    public void setCacheVideoOnlyWifi(boolean z3) {
        this.isCacheVideoOnlyWifi = z3;
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.a(requestParameters);
        fVar.a(str);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.a(requestParameters);
        fVar.a(str);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        f fVar = new f(this.mContext, new ad(portraitVideoAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), "pvideo", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.a(requestParameters);
        fVar.a(str);
    }

    public BaiduNativeManager(Context context, String str, int i4) {
        this(context, str, true, i4);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "pvideo", str, feedAdListener, null);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        f fVar = new f(this.mContext, new ad(feedAdListener), new dm(this.mContext, getAdPlacemenId(requestParameters), "pvideo", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            fVar.b(this.mAppSid);
        }
        fVar.a(getBidFloor(requestParameters));
        fVar.a(this.isCacheVideoOnlyWifi);
        fVar.a(new al());
        fVar.b(requestParameters);
    }

    public BaiduNativeManager(Context context, String str, boolean z3) {
        this(context, str, z3, AVMDLDataLoader.KeyIsLiveSetLoaderType);
    }

    public BaiduNativeManager(Context context, String str, boolean z3, int i4) {
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z3;
        this.mTimeoutMillis = i4;
    }
}
