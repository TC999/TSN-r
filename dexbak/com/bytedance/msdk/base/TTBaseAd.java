package com.bytedance.msdk.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTAdDislike;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.nativeAd.TTNativeAdListener;
import com.bytedance.msdk.api.nativeAd.TTVideoListener;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.p111ad.sdk.ad_mediation_sdk.C5937R;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTBaseAd implements Comparable<TTBaseAd> {
    private String appName;
    private String authorName;
    private String linkIdFromRealReq;
    private String mActionText;
    private String mAdNetWorkName;
    private String mAdNetworkSlotId;
    private int mAdNetworkSlotType;
    private int mAdType;
    private int mAppSize;
    private boolean mCacheSuccess;
    private double mCpm;
    private String mDescription;
    private volatile boolean mHasShown;
    private String mIconUrl;
    private int mImageHeight;
    private int mImageMode;
    private String mImageUrl;
    private int mImageWidth;
    private int mInteractionType;
    private boolean mIsAppDownload;
    private boolean mIsExpressAd;
    private int mLoadSort;
    private String mPackageName;
    private double mRating;
    private String mRit;
    private int mSdkNum;
    private String mSdkVersion;
    private double mServerBiddingCpm;
    private int mShowSort;
    private String mSource;
    private String mStore;
    protected ITTAdatperCallback mTTAdatperCallback;
    protected TTNativeAdListener mTTNativeAdListener;
    protected TTVideoListener mTTVideoListener;
    private String mTitle;
    private int originType;
    private long packageSizeBytes;
    private String permissionsUrl;
    private String privacyAgreement;
    private String versionName;
    private List<String> mImages = new ArrayList();
    private int mediationRitReqType = 1;
    private int mediationRitReqTypeSrc = 1;
    private int mediationRitReqTypeFromRealReq = 1;
    private int mediationRitReqTypeSrcFromRealReq = 1;
    private String mExchangeRate = "1";
    private Map<String, Object> eventMap = new HashMap();

    private void removeSelfAddView(@NonNull ViewGroup viewGroup) {
        try {
            TTNativeAdView tTNativeAdView = (TTNativeAdView) viewGroup;
            if (tTNativeAdView.getChildCount() == 0) {
                return;
            }
            int i = 0;
            if (getAdNetworkPlatformId() != 3 && (tTNativeAdView.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) tTNativeAdView.getChildAt(0);
                if ("tt_gdt_developer_view_root".equals(viewGroup2.getTag(C5937R.C5939id.tt_mediation_gdt_developer_view_root_tag_key))) {
                    tTNativeAdView.removeView(viewGroup2);
                    int i2 = 0;
                    while (i2 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i2);
                        if (childAt != null) {
                            Object tag = childAt.getTag(C5937R.C5939id.tt_mediation_gdt_developer_view_tag_key);
                            if ((tag instanceof String) && tag.equals("tt_gdt_developer_view")) {
                                viewGroup2.removeView(childAt);
                                tTNativeAdView.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i2++;
                    }
                }
            }
            if (getAdNetworkPlatformId() == 2 || !(tTNativeAdView.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) tTNativeAdView.getChildAt(0);
            if ("tt_admob_native_view_root_tag".equals(viewGroup3.getTag(C5937R.C5939id.tt_mediation_admob_developer_view_root_tag_key))) {
                tTNativeAdView.removeView(viewGroup3);
                while (i < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(C5937R.C5939id.tt_mediation_admob_developer_view_tag_key);
                        if ((tag2 instanceof String) && tag2.equals("tt_admob_native_view_tag")) {
                            viewGroup3.removeView(childAt2);
                            tTNativeAdView.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean adnHasAdExpiredApi() {
        return false;
    }

    public boolean adnHasAdVideoCachedApi() {
        return false;
    }

    public void clearLogoView(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(C5937R.C5938color.tt_mediation_transparent);
            }
        }
    }

    public String getActionText() {
        return this.mActionText;
    }

    public String getAdDescription() {
        return this.mDescription;
    }

    public long getAdId() {
        return 0L;
    }

    public View getAdLogoView() {
        return null;
    }

    public String getAdNetWorkName() {
        return this.mAdNetWorkName;
    }

    public int getAdNetworkPlatformId() {
        return this.mSdkNum;
    }

    public String getAdNetworkSlotId() {
        return this.mAdNetworkSlotId;
    }

    public int getAdNetworkSlotType() {
        return this.mAdNetworkSlotType;
    }

    public String getAdTitle() {
        return this.mTitle;
    }

    public abstract int getAdType();

    public View getAdView() {
        return null;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppSize() {
        return this.mAppSize;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public double getCpm() {
        try {
            if (isBidingAd()) {
                return this.mCpm * Double.valueOf(this.mExchangeRate).doubleValue();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.mCpm;
    }

    public long getCreativeId() {
        return 0L;
    }

    public TTAdDislike getDislikeDialog(Activity activity) {
        return null;
    }

    public int getEventLoadSort() {
        if (this.mAdNetworkSlotType == 100) {
            return this.mLoadSort + 300;
        }
        return this.mLoadSort;
    }

    public Map<String, Object> getEventMap() {
        return this.eventMap;
    }

    public String getExchangeRate() {
        return this.mExchangeRate;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageMode() {
        return this.mImageMode;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public List<String> getImages() {
        return this.mImages;
    }

    public int getInteractionType() {
        return this.mInteractionType;
    }

    public boolean getIsAppDownload() {
        return this.mIsAppDownload;
    }

    public int getLoadSort() {
        return this.mLoadSort;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    public int getMediationRitReqType(String str) {
        if (TextUtils.equals(str, this.linkIdFromRealReq)) {
            return this.mediationRitReqTypeFromRealReq;
        }
        return this.mediationRitReqType;
    }

    public int getMediationRitReqTypeSrc(String str) {
        if (TextUtils.equals(str, this.linkIdFromRealReq)) {
            return this.mediationRitReqTypeSrcFromRealReq;
        }
        return this.mediationRitReqTypeSrc;
    }

    public int[] getMinWindowSize() {
        return null;
    }

    public String getNetWorkPlatFormCpm() {
        if (isClientBiddingAd() || isPAd()) {
            return "-1";
        }
        if (isServerBiddingAd()) {
            return getServerBiddingCpm() < Utils.DOUBLE_EPSILON ? "-1" : String.valueOf(getServerBiddingCpm());
        }
        return String.valueOf(getCpm());
    }

    public int getOriginType() {
        return this.originType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long getPackageSizeBytes() {
        return this.packageSizeBytes;
    }

    public String getPermissionsUrl() {
        return this.permissionsUrl;
    }

    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    public String getReqId() {
        return null;
    }

    public String getRit() {
        return this.mRit;
    }

    @Deprecated
    public int getSdkNum() {
        return this.mSdkNum;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public double getServerBiddingCpm() {
        return this.mServerBiddingCpm;
    }

    public int getShowSort() {
        return this.mShowSort;
    }

    public String getSource() {
        return this.mSource;
    }

    public Bitmap getSplashBitMap() {
        return null;
    }

    public double getStarRating() {
        return this.mRating;
    }

    public String getStore() {
        return this.mStore;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean hasAppInfo() {
        return (TextUtils.isEmpty(this.appName) && TextUtils.isEmpty(this.authorName) && this.packageSizeBytes <= 0 && TextUtils.isEmpty(this.permissionsUrl) && TextUtils.isEmpty(this.privacyAgreement) && TextUtils.isEmpty(this.versionName)) ? false : true;
    }

    public abstract boolean hasDestroyed();

    public boolean hasDislike() {
        return false;
    }

    public boolean isAdCacheReady() {
        return true;
    }

    public boolean isAdExpired() {
        return true;
    }

    public boolean isBidingAd() {
        return isServerBiddingAd() || isClientBiddingAd();
    }

    public boolean isCacheSuccess() {
        return this.mCacheSuccess;
    }

    public boolean isClientBiddingAd() {
        return this.mAdNetworkSlotType == 1;
    }

    public boolean isExpressAd() {
        return this.mIsExpressAd;
    }

    public boolean isHasShown() {
        return this.mHasShown;
    }

    public boolean isPAd() {
        return this.mAdNetworkSlotType == 100;
    }

    public boolean isReady() {
        return false;
    }

    public boolean isServerBiddingAd() {
        return this.mAdNetworkSlotType == 2;
    }

    public void onDestroy() {
        this.mTTNativeAdListener = null;
        this.mTTVideoListener = null;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void putEventParam(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.eventMap.put(str, obj);
    }

    public void putEventParams(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.eventMap.putAll(map);
    }

    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, TTViewBinder tTViewBinder) {
        registerViewForInteraction(viewGroup, list, null, tTViewBinder);
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void render() {
    }

    public void setActionText(String str) {
        this.mActionText = str;
    }

    public void setAdDescription(String str) {
        this.mDescription = str;
    }

    public void setAdNetWorkName(String str) {
        this.mAdNetWorkName = str;
    }

    public void setAdNetworkSlotId(String str) {
        this.mAdNetworkSlotId = str;
    }

    public void setAdNetworkSlotType(int i) {
        this.mAdNetworkSlotType = i;
    }

    public void setAdType(int i) {
        this.mAdType = i;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppSize(int i) {
        this.mAppSize = i;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setCacheSuccess(boolean z) {
        this.mCacheSuccess = z;
    }

    public void setCpm(double d) {
        this.mCpm = d;
    }

    public void setDislikeCallback(Activity activity, TTDislikeCallback tTDislikeCallback) {
    }

    public void setExchangeRate(String str) {
        this.mExchangeRate = str;
    }

    public void setExpressAd(boolean z) {
        this.mIsExpressAd = z;
    }

    public void setHasShown(boolean z) {
        this.mHasShown = z;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setImageHeight(int i) {
        this.mImageHeight = i;
    }

    public void setImageMode(int i) {
        this.mImageMode = i;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setImageWidth(int i) {
        this.mImageWidth = i;
    }

    public void setImages(List<String> list) {
        if (list != null) {
            this.mImages.addAll(list);
        }
    }

    public void setInteractionType(int i) {
        this.mInteractionType = i;
    }

    public void setIsAppDownload(boolean z) {
        this.mIsAppDownload = z;
    }

    public void setLinkIdFromRealReq(String str) {
        this.linkIdFromRealReq = str;
    }

    public void setLoadSort(int i) {
        this.mLoadSort = i;
    }

    public void setMediationRitReqType(int i) {
        this.mediationRitReqType = i;
    }

    public void setMediationRitReqTypeFromRealReq(int i) {
        this.mediationRitReqTypeFromRealReq = i;
    }

    public void setMediationRitReqTypeSrc(int i) {
        this.mediationRitReqTypeSrc = i;
    }

    public void setMediationRitReqTypeSrcFromRealReq(int i) {
        this.mediationRitReqTypeSrcFromRealReq = i;
    }

    public void setOriginType(int i) {
        this.originType = i;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setPackageSizeBytes(long j) {
        this.packageSizeBytes = j;
    }

    public void setPermissionsUrl(String str) {
        this.permissionsUrl = str;
    }

    public void setPrivacyAgreement(String str) {
        this.privacyAgreement = str;
    }

    public void setRating(double d) {
        this.mRating = d;
    }

    public void setRit(String str) {
        this.mRit = str;
    }

    public void setSdkNum(int i) {
        this.mSdkNum = i;
    }

    public void setSdkVersion(String str) {
        this.mSdkVersion = str;
    }

    public void setServerBiddingCpm(double d) {
        this.mServerBiddingCpm = d;
    }

    public void setShowSort(int i) {
        this.mShowSort = i;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setStore(String str) {
        this.mStore = str;
    }

    public void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback) {
        this.mTTAdatperCallback = iTTAdatperCallback;
    }

    public void setTTNativeAdListener(TTNativeAdListener tTNativeAdListener) {
        this.mTTNativeAdListener = tTNativeAdListener;
    }

    public void setTTVideoListener(TTVideoListener tTVideoListener) {
        this.mTTVideoListener = tTVideoListener;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
    }

    public void showMinWindow(Rect rect, ITTAdatperCallback iTTAdatperCallback) {
    }

    public void showSplashAd(ViewGroup viewGroup) {
    }

    public void splashMinWindowAnimationFinish() {
    }

    public void unregisterView() {
    }

    @Override // java.lang.Comparable
    public int compareTo(TTBaseAd tTBaseAd) {
        if (tTBaseAd != null && this.mLoadSort <= tTBaseAd.getLoadSort()) {
            if (this.mLoadSort < tTBaseAd.getLoadSort()) {
                return -1;
            }
            if (this.mShowSort > tTBaseAd.getShowSort()) {
                return 1;
            }
            return this.mShowSort < tTBaseAd.getShowSort() ? -1 : 0;
        }
        return 1;
    }

    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
        if (viewGroup instanceof TTNativeAdView) {
            removeSelfAddView(viewGroup);
            View findViewById = viewGroup.findViewById(C5937R.C5939id.tt_mediation_mtg_ad_choice);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (tTViewBinder != null) {
                clearLogoView(viewGroup.findViewById(tTViewBinder.logoLayoutId));
            }
        }
    }

    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, TTViewBinder tTViewBinder) {
        registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
    }
}
