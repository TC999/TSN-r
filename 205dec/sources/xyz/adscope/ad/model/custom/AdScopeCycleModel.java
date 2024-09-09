package xyz.adscope.ad.model.custom;

import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.model.BaseModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.config.ConfigureResponseModel;
import xyz.adscope.ad.tool.event.ASNPUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeCycleModel extends BaseModel {
    private IBaseAdListener adListener;
    private AdResponseModel adResponseModel;
    private AdScopeADNAdvertisingType adScopeADNAdvertisingType;
    private AdScopeGlobalModel adScopeGlobalModel;
    private AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel;
    private BidModel bidModel;
    private String bidToken;
    private ConfigureResponseModel configureResponseModel;
    private int countryCN;
    private int expireTime;
    private long exposureStartTime;
    private boolean isClosedAd;
    private boolean isOpenCache;
    private boolean isScheduleEndTime;
    private boolean isServerResponse;
    private long limitAdTime;
    private long loadStartTime;
    private float nativeAdViewHeight;
    private float nativeAdViewWidth;
    private long renderStartTime;
    private long requestStartTime;
    private boolean supportZoomOutView;
    private int testAd;
    private long timeoutInterval;
    private int uniteRandom;
    private int DEFAULT_AD_COUNT = 1;
    private String sessionId = "";
    private String spaceId = "";
    private String spaceType = "";
    private String apiKey = "AdScopeADN";
    private String dspId = "";
    private String price = "";
    private String renderPlanId = "";
    private String interactPlanId = "";
    private String clickResults = "";
    private String errorCode = "";
    private String errorInfo = "";
    private boolean isTimeOutCallback = false;
    private int adCount = 1;
    private String roundTripTime = "";
    private String orderId = "";
    private String createId = "";
    private String materialId = "";
    private String materialMd5Value = "";
    private String currency = "";
    private String isWin = "";
    private String winPrice = "";
    private String complainContent = "";

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum AdScopeADNAdvertisingType {
        AdScopeAdsTypeSplash(1),
        AdScopeAdsTypeInterstitial(2),
        AdScopeAdsTypeNativeExpress(3),
        AdScopeAdsTypeBanner(4);
        
        public int code;

        AdScopeADNAdvertisingType(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    public int getAdCount() {
        return this.adCount;
    }

    public IBaseAdListener getAdListener() {
        return this.adListener;
    }

    public AdResponseModel getAdResponseModel() {
        return this.adResponseModel;
    }

    public AdScopeADNAdvertisingType getAdScopeADNAdvertisingType() {
        return this.adScopeADNAdvertisingType;
    }

    public AdScopeGlobalModel getAdScopeGlobalModel() {
        return this.adScopeGlobalModel;
    }

    public AdScopeRenderCustomTrackerModel getAdScopeRenderCustomTrackerModel() {
        return this.adScopeRenderCustomTrackerModel;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public BidModel getBidModel() {
        return this.bidModel;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public String getClickResults() {
        return this.clickResults;
    }

    public String getComplainContent() {
        return this.complainContent;
    }

    public ConfigureResponseModel getConfigureResponseModel() {
        return this.configureResponseModel;
    }

    public int getCountryCN() {
        return this.countryCN;
    }

    public String getCreateId() {
        return this.createId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDspId() {
        return this.dspId;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public String getEventId() {
        return ASNPUtil.createRequestId();
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public long getExposureStartTime() {
        return this.exposureStartTime;
    }

    public String getInteractPlanId() {
        return this.interactPlanId;
    }

    public String getIsWin() {
        return this.isWin;
    }

    public long getLimitAdTime() {
        return this.limitAdTime;
    }

    public long getLoadStartTime() {
        return this.loadStartTime;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public String getMaterialMd5Value() {
        return this.materialMd5Value;
    }

    public float getNativeAdViewHeight() {
        return this.nativeAdViewHeight;
    }

    public float getNativeAdViewWidth() {
        return this.nativeAdViewWidth;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRenderPlanId() {
        return this.renderPlanId;
    }

    public long getRenderStartTime() {
        return this.renderStartTime;
    }

    public long getRequestStartTime() {
        return this.requestStartTime;
    }

    public String getRoundTripTime() {
        return this.roundTripTime;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getSpaceType() {
        return this.spaceType;
    }

    public int getTestAd() {
        return this.testAd;
    }

    public long getTimeoutInterval() {
        return this.timeoutInterval;
    }

    public int getUniteRandom() {
        return this.uniteRandom;
    }

    public String getWinPrice() {
        return this.winPrice;
    }

    public boolean isClosedAd() {
        return this.isClosedAd;
    }

    public boolean isOpenCache() {
        return this.isOpenCache;
    }

    public boolean isScheduleEndTime() {
        return this.isScheduleEndTime;
    }

    public boolean isServerResponse() {
        return this.isServerResponse;
    }

    public boolean isSupportZoomOutView() {
        return this.supportZoomOutView;
    }

    public boolean isTimeOutCallback() {
        return this.isTimeOutCallback;
    }

    public void setAdCount(int i4) {
        if (i4 == 0) {
            this.adCount = this.DEFAULT_AD_COUNT;
        } else {
            this.adCount = i4;
        }
    }

    public void setAdListener(IBaseAdListener iBaseAdListener) {
        this.adListener = iBaseAdListener;
    }

    public void setAdResponseModel(AdResponseModel adResponseModel) {
        this.adResponseModel = adResponseModel;
    }

    public void setAdScopeADNAdvertisingType(AdScopeADNAdvertisingType adScopeADNAdvertisingType) {
        this.adScopeADNAdvertisingType = adScopeADNAdvertisingType;
    }

    public void setAdScopeGlobalModel(AdScopeGlobalModel adScopeGlobalModel) {
        this.adScopeGlobalModel = adScopeGlobalModel;
    }

    public void setAdScopeRenderCustomTrackerModel(AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel) {
        this.adScopeRenderCustomTrackerModel = adScopeRenderCustomTrackerModel;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setBidModel(BidModel bidModel) {
        this.bidModel = bidModel;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setClickResults(String str) {
        this.clickResults = str;
    }

    public void setClosedAd(boolean z3) {
        this.isClosedAd = z3;
    }

    public void setComplainContent(String str) {
        this.complainContent = str;
    }

    public void setConfigureResponseModel(ConfigureResponseModel configureResponseModel) {
        this.configureResponseModel = configureResponseModel;
    }

    public void setCountryCN(int i4) {
        this.countryCN = i4;
    }

    public void setCreateId(String str) {
        this.createId = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDspId(String str) {
        this.dspId = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public void setExpireTime(int i4) {
        this.expireTime = i4;
    }

    public void setExposureStartTime(long j4) {
        this.exposureStartTime = j4;
    }

    public void setInteractPlanId(String str) {
        this.interactPlanId = str;
    }

    public void setIsWin(String str) {
        this.isWin = str;
    }

    public void setLimitAdTime(long j4) {
        this.limitAdTime = j4;
    }

    public void setLoadStartTime(long j4) {
        this.loadStartTime = j4;
    }

    public void setMaterialId(String str) {
        this.materialId = str;
    }

    public void setMaterialMd5Value(String str) {
        this.materialMd5Value = str;
    }

    public void setNativeAdViewHeight(float f4) {
        this.nativeAdViewHeight = f4;
    }

    public void setNativeAdViewWidth(float f4) {
        this.nativeAdViewWidth = f4;
    }

    public void setOpenCache(boolean z3) {
        this.isOpenCache = z3;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRenderPlanId(String str) {
        this.renderPlanId = str;
    }

    public void setRenderStartTime(long j4) {
        this.renderStartTime = j4;
    }

    public void setRequestStartTime(long j4) {
        this.requestStartTime = j4;
    }

    public void setRoundTripTime(String str) {
        this.roundTripTime = str;
    }

    public void setScheduleEndTime(boolean z3) {
        this.isScheduleEndTime = z3;
    }

    public void setServerResponse(boolean z3) {
        this.isServerResponse = z3;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setSpaceType(String str) {
        this.spaceType = str;
    }

    public void setSupportZoomOutView(boolean z3) {
        this.supportZoomOutView = z3;
    }

    public void setTestAd(int i4) {
        this.testAd = i4;
    }

    public void setTimeOutCallback(boolean z3) {
        this.isTimeOutCallback = z3;
    }

    public void setTimeoutInterval(long j4) {
        this.timeoutInterval = j4;
    }

    public void setUniteRandom(int i4) {
        this.uniteRandom = i4;
    }

    public void setWinPrice(String str) {
        this.winPrice = str;
    }
}
