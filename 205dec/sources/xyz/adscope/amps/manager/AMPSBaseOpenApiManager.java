package xyz.adscope.amps.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.banner.AMPSBannerLoadEventListener;
import xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener;
import xyz.adscope.amps.ad.nativead.AMPSNativeLoadEventListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener;
import xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.base.AMPSBaseBiddingResult;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.control.bid.AMPSPriceComparator;
import xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface;
import xyz.adscope.amps.control.cache.AMPSCacheController;
import xyz.adscope.amps.control.dispatch.AMPSDispatcher;
import xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface;
import xyz.adscope.amps.control.filter.AMPSFilter;
import xyz.adscope.amps.control.filter.inter.IFilterInterface;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.AMPSInitChannelAdapterConfig;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.model.AMPSCycleModel;
import xyz.adscope.amps.model.cache.AMPSAdSourceCacheInfo;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.model.frequency.AMPSFrequencyEventModel;
import xyz.adscope.amps.report.AMPSEventReportCode;
import xyz.adscope.amps.report.AMPSReportLoader;
import xyz.adscope.amps.tool.AMPSAdapterFactory;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.task.AMPSManagerTask;
import xyz.adscope.amps.tool.task.inter.IBiddingTimeoutTimerCallBack;
import xyz.adscope.amps.tool.task.inter.IDispatchFloorAdSourceTimerCallBack;
import xyz.adscope.amps.tool.task.inter.IRequestTimeoutTimerCallBack;
import xyz.adscope.amps.tool.util.AMPSStringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSBaseOpenApiManager<T extends AMPSLoadEventListener> implements AMPSAdBiddingListener, AMPSBaseAdAdapterListener {
    private long adSourceRequestStartTime;
    private AMPSInitChannelAdapterConfig ampsInitChannelAdapterConfig;
    private AMPSLoadEventListener ampsLoadEventListener;
    private IDispatcherInterface iDispatcherInterface;
    private IFilterInterface iFilterInterface;
    private IPriceComparatorInterface iPriceComparatorInterface;
    private boolean isAdClosed;
    private AMPSBaseAdapter mAMPSBaseAdapter;
    private AMPSRequestParameters mAMPSRequestParameters;
    private int mAdAutoRefreshSwitch;
    private long mAdRequestTimeout;
    private int mAdRequestType;
    private int mAdSourceRequestTimeout;
    private AMPSManagerTask mAmpsManagerTask;
    private long mBidAdTimeout;
    private List<AdSourceModel> mC2SAdSourceList;
    private Context mContext;
    private List<AdSourceModel> mFloorAdSourceList;
    private long mFloorDelayTime;
    private List<AdSourceModel> mS2SAdSourceList;
    private String mSessionId;
    private long mSpaceCachedOffersTimeout;
    private String mSpaceId;
    private SpaceModel mSpaceModel;
    private AdSourceModel mWinAdSourceModel;
    private long mediationStartTime;
    private final String TAG = getClass().getSimpleName();
    private Map<String, AdSourceModel> loadAdResourceDatas = new HashMap();
    private Map<String, AMPSBaseAdapter> loadAdResourceAdapters = new HashMap();
    private boolean isHasLoadingSuccess = false;
    private boolean isDispatchFloorAdSource = false;
    private boolean isRequestTimeout = false;
    private int mSpaceAdStatus = 0;
    private long adSourceBiddingStartTime = 0;

    public AMPSBaseOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, T t3) {
        this.mAdRequestTimeout = 5000L;
        this.mAdSourceRequestTimeout = 5000;
        this.mAdRequestType = 0;
        this.mBidAdTimeout = 5000L;
        this.mFloorDelayTime = 5000L;
        this.mS2SAdSourceList = null;
        this.mC2SAdSourceList = null;
        this.mFloorAdSourceList = null;
        this.mAdAutoRefreshSwitch = 0;
        this.mAmpsManagerTask = null;
        this.mContext = context;
        this.mAMPSRequestParameters = aMPSRequestParameters;
        this.ampsLoadEventListener = t3;
        SpaceModel buildDispatcherModel = AMPSAdSourceDataProvider.getInstance().buildDispatcherModel(aMPSRequestParameters);
        this.mSpaceModel = buildDispatcherModel;
        if (buildDispatcherModel == null) {
            return;
        }
        this.mediationStartTime = System.currentTimeMillis();
        this.mSessionId = AMPSStringUtil.createRequestId();
        SpaceModel spaceModel = this.mSpaceModel;
        if (spaceModel != null) {
            this.mSpaceId = spaceModel.getSpaceId();
            this.mSpaceCachedOffersTimeout = this.mSpaceModel.getCachedOffersTimeout();
            this.mAdRequestType = this.mSpaceModel.getBidDistributionMethod();
            this.mBidAdTimeout = this.mSpaceModel.getBidAdTimeout();
            this.mFloorDelayTime = this.mSpaceModel.getFloorDelayTime();
            this.mAdRequestTimeout = this.mSpaceModel.getAdTimeout();
            this.mAdSourceRequestTimeout = (int) this.mSpaceModel.getAdsTimeout();
            this.mS2SAdSourceList = this.mSpaceModel.getS2sAdSourceList();
            this.mC2SAdSourceList = this.mSpaceModel.getC2sAdSourceList();
            this.mFloorAdSourceList = this.mSpaceModel.getFloorAdSourceList();
            this.mAdAutoRefreshSwitch = this.mSpaceModel.getAutoRefreshSwitch();
        }
        uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_CODE, "", "", 0L);
        this.mAmpsManagerTask = new AMPSManagerTask();
        this.iFilterInterface = new AMPSFilter(this.mSpaceModel);
        this.iDispatcherInterface = new AMPSDispatcher(this.mSpaceModel);
        this.iPriceComparatorInterface = new AMPSPriceComparator(this.mSpaceModel, this.loadAdResourceDatas);
    }

    private void addFilterEvent(String str, String str2) {
        IFilterInterface iFilterInterface;
        try {
            if (TextUtils.isEmpty(str2) || (iFilterInterface = this.iFilterInterface) == null) {
                return;
            }
            iFilterInterface.addFilterEvent(new AMPSFrequencyEventModel(str, str2));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackAdLoadFail(String str, String str2) {
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "callbackAdLoadFail code:" + str + "; message:" + str2);
            if (!this.isDispatchFloorAdSource && !this.isRequestTimeout) {
                this.isDispatchFloorAdSource = true;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "callbackAdLoadFail \u5206\u53d1\u515c\u5e95\u5e7f\u544a\u6e90");
                dispatchAdSource(this.mFloorAdSourceList);
            } else if (this.mSpaceAdStatus == 3) {
            } else {
                this.mSpaceAdStatus = 3;
                uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_FAIL_CODE, str, str2, System.currentTimeMillis() - this.mediationStartTime);
                if (this.ampsLoadEventListener != null) {
                    AMPSError aMPSError = new AMPSError(str, str2);
                    AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                    if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                        ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    } else if (aMPSLoadEventListener instanceof AMPSNativeLoadEventListener) {
                        ((AMPSNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                        ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                        ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                        ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    }
                }
                sendLosNoticeByFail();
                destroy();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackAdLoadSuccess(AdSourceModel adSourceModel) {
        Map<String, AMPSBaseAdapter> map;
        if (adSourceModel != null) {
            try {
                if (this.mAMPSBaseAdapter == null && this.mSpaceAdStatus < 1) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (TextUtils.isEmpty(spaceId)) {
                        return;
                    }
                    this.mWinAdSourceModel = adSourceModel;
                    if (this.loadAdResourceAdapters.containsKey(spaceId)) {
                        this.mAMPSBaseAdapter = this.loadAdResourceAdapters.get(spaceId);
                    }
                    if (this.mAMPSBaseAdapter != null && this.ampsLoadEventListener != null) {
                        this.mSpaceAdStatus = 1;
                        adSourceModel.setAdComparePriceStatus(3);
                        if (!AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                            AdSourceModel secondAdSourceModel = getSecondAdSourceModel();
                            AMPSBidResult aMPSBidResult = new AMPSBidResult();
                            if (secondAdSourceModel != null) {
                                aMPSBidResult.setEcpm(secondAdSourceModel.getEcpm());
                                aMPSBidResult.setChannelName(secondAdSourceModel.getSeatId());
                                aMPSBidResult.setBidType(secondAdSourceModel.getBiddingType());
                            } else {
                                aMPSBidResult.setEcpm(adSourceModel.getEcpm());
                                aMPSBidResult.setChannelName(adSourceModel.getSeatId());
                                aMPSBidResult.setBidType(adSourceModel.getBiddingType());
                            }
                            this.mAMPSBaseAdapter.sendWinNotice(aMPSBidResult);
                        }
                        uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_SUCCESS_CODE, "", "", 0L);
                        for (AdSourceModel adSourceModel2 : this.loadAdResourceDatas.values()) {
                            if (adSourceModel2 != null && adSourceModel2.getAdStatus() == 5 && adSourceModel2.getAdComparePriceStatus() == 1) {
                                adSourceModel2.setAdComparePriceStatus(4);
                                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_FAIL_CODE;
                                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_COMPARISON_FAIL;
                                uploadLog(adSourceModel2, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                            }
                        }
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "callBackAdLoadSuccess winAdSource:" + spaceId);
                        uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_SUCCESS_CODE, "", "", System.currentTimeMillis() - this.mediationStartTime);
                        AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
                        } else if (aMPSLoadEventListener instanceof AMPSNativeLoadEventListener) {
                            AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                            if (aMPSBaseAdapter instanceof AMPSNativeAdapter) {
                                ((AMPSNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad(((AMPSNativeAdapter) aMPSBaseAdapter).getNativeListInfo());
                            }
                        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad();
                        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
                        } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
                        }
                        startCacheLoadSuccessAdSource();
                        removeCacheAdSource(spaceId);
                        sendLosNotice();
                        AMPSManagerTask aMPSManagerTask = this.mAmpsManagerTask;
                        if (aMPSManagerTask != null) {
                            aMPSManagerTask.cancelBiddingTimerTask();
                            this.mAmpsManagerTask.cancelDispatchFloorAdSourceTimerTask();
                            this.mAmpsManagerTask.cancelRequestedTimerTask();
                            this.mAmpsManagerTask = null;
                        }
                        if (!(this.ampsLoadEventListener instanceof AMPSBannerLoadEventListener) || (map = this.loadAdResourceAdapters) == null || map.size() <= 0) {
                            return;
                        }
                        for (Map.Entry<String, AMPSBaseAdapter> entry : this.loadAdResourceAdapters.entrySet()) {
                            AMPSBaseAdapter value = entry.getValue();
                            if (value != null && !isWinAdSource(value)) {
                                value.destroy();
                            }
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private void comparePrice(AMPSBaseAdapter aMPSBaseAdapter, AdSourceModel adSourceModel) {
        try {
            if (this.iPriceComparatorInterface == null || adSourceModel == null || TextUtils.isEmpty(adSourceModel.getSpaceId())) {
                return;
            }
            uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_CODE, "", "", 0L);
            int comparePriceResult = this.iPriceComparatorInterface.getComparePriceResult(adSourceModel);
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice channel:" + adSourceModel.getSeatId() + ",spaceId:" + adSourceModel.getSpaceId() + ",ecpm:" + adSourceModel.getEcpm() + ",comparePriceResult:" + comparePriceResult);
            adSourceModel.setAdComparePriceStatus(comparePriceResult);
            if (comparePriceResult == 1) {
                uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_WAIT_CODE, "", "", 0L);
            } else if (comparePriceResult == 4) {
                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_FAIL_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_COMPARISON_FAIL;
                uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
            }
            if (comparePriceResult == 3) {
                callBackAdLoadSuccess(adSourceModel);
                return;
            }
            if (this.mAdRequestType != 1 && adSourceModel.getIsFloor() != 1) {
                if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    dispatchAdSourceByChannelResult(adSourceModel);
                }
                handleCallbackAdSourceLoadResult();
                return;
            }
            handleCallbackAdSourceLoadResult();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void createAMPSInitCustomAdapterConfig() {
        try {
            if (this.ampsInitChannelAdapterConfig == null) {
                this.ampsInitChannelAdapterConfig = new AMPSInitChannelAdapterConfig();
            }
            AMPSInitConfig aMPSAdConfig = AMPSSDKManager.getInstance().getAMPSAdConfig();
            if (aMPSAdConfig != null) {
                this.ampsInitChannelAdapterConfig.setAppName(aMPSAdConfig.getAppName());
                this.ampsInitChannelAdapterConfig.setPrivacyConfig(aMPSAdConfig.getPrivacyConfig());
                this.ampsInitChannelAdapterConfig.setPersonalRecommend(aMPSAdConfig.isPersonalRecommend());
                this.ampsInitChannelAdapterConfig.setDebug(aMPSAdConfig.isDebug());
                this.ampsInitChannelAdapterConfig.setUserId(aMPSAdConfig.getUserId());
                this.ampsInitChannelAdapterConfig.setCustomOAID(aMPSAdConfig.getCustomOAID());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAdSource(List<AdSourceModel> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (AdSourceModel adSourceModel : list) {
                        if (adSourceModel != null && !TextUtils.isEmpty(adSourceModel.getSpaceId())) {
                            this.loadAdResourceDatas.put(adSourceModel.getSpaceId(), adSourceModel);
                        }
                    }
                    for (AdSourceModel adSourceModel2 : list) {
                        if (adSourceModel2 != null && !TextUtils.isEmpty(adSourceModel2.getSpaceId())) {
                            uploadLog(adSourceModel2, AMPSEventReportCode.EVENT_ADSOURCE_FILTER_CODE, "", "", 0L);
                            IFilterInterface iFilterInterface = this.iFilterInterface;
                            if (iFilterInterface != null ? iFilterInterface.channelFilter(adSourceModel2) : false) {
                                uploadLog(adSourceModel2, AMPSEventReportCode.EVENT_ADSOURCE_FILTER_SUCCESS_CODE, "", "", 0L);
                                starLoadAdResource(adSourceModel2);
                            } else {
                                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_FILTER_FAIL_CODE;
                                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_FILTER_FAIL;
                                uploadLog(adSourceModel2, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " filter not pass spaceId:" + adSourceModel2.getSpaceId());
                                adSourceModel2.setAdStatus(6);
                                dispatchAdSourceByChannelResult(adSourceModel2);
                            }
                        }
                    }
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " dispatchAdSource is null:");
        handleCallbackAdSourceLoadResult();
    }

    private void dispatchAdSourceByChannelResult(AdSourceModel adSourceModel) {
        try {
            IDispatcherInterface iDispatcherInterface = this.iDispatcherInterface;
            if (iDispatcherInterface == null) {
                return;
            }
            dispatchAdSource(iDispatcherInterface.dispatch(adSourceModel));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void dispatchAdSourceByFloor() {
        AMPSManagerTask aMPSManagerTask;
        try {
            List<AdSourceModel> list = this.mFloorAdSourceList;
            if (list != null && list.size() != 0 && (aMPSManagerTask = this.mAmpsManagerTask) != null) {
                aMPSManagerTask.startDispatchFloorAdSourceTimerTask(this.mFloorDelayTime, new IDispatchFloorAdSourceTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.3
                    @Override // xyz.adscope.amps.tool.task.inter.IDispatchFloorAdSourceTimerCallBack
                    public void callBackDispatchFloorAdSource() {
                        if (AMPSBaseOpenApiManager.this.isHasLoadingSuccess || AMPSBaseOpenApiManager.this.isDispatchFloorAdSource) {
                            return;
                        }
                        AMPSBaseOpenApiManager.this.isDispatchFloorAdSource = true;
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, AMPSBaseOpenApiManager.this.TAG + " dispatchAdSourceByFloor \u5206\u53d1\u515c\u5e95\u5e7f\u544a\u6e90:");
                        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = AMPSBaseOpenApiManager.this;
                        aMPSBaseOpenApiManager.dispatchAdSource(aMPSBaseOpenApiManager.mFloorAdSourceList);
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void dispatchAdSourceByS2S() {
        List<AdSourceModel> list = this.mS2SAdSourceList;
        if (list == null || list.size() == 0) {
            return;
        }
        this.iDispatcherInterface.updateAdSourceAdStatus(this.mS2SAdSourceList, 1);
        this.iDispatcherInterface.updateAdSourceAdStatus(this.mS2SAdSourceList, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAdSourceByTimeOut() {
        try {
            if (this.iDispatcherInterface == null) {
                return;
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " dispatchAdSourceByTimeOut \u8be2\u4ef7\u8d85\u65f6:");
            dispatchAdSource(this.iDispatcherInterface.biddingTimeOut());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private AdSourceModel getSecondAdSourceModel() {
        AdSourceModel adSourceModel = null;
        for (AdSourceModel adSourceModel2 : this.loadAdResourceDatas.values()) {
            if (adSourceModel2 != null && adSourceModel2.getAdStatus() == 5 && adSourceModel2.getAdComparePriceStatus() != 3 && (adSourceModel == null || adSourceModel2.getEcpm() > adSourceModel.getEcpm())) {
                adSourceModel = adSourceModel2;
            }
        }
        return adSourceModel;
    }

    private int getWinEcpm() {
        AdSourceModel adSourceModel = this.mWinAdSourceModel;
        if (adSourceModel != null) {
            return adSourceModel.getEcpm();
        }
        return 0;
    }

    private void handleC2SAdSourceBidResult(AdSourceModel adSourceModel, AMPSBaseBiddingResult aMPSBaseBiddingResult, int i4) {
        if (adSourceModel == null || aMPSBaseBiddingResult == null) {
            return;
        }
        try {
            if (adSourceModel.getAdStatus() == 3 && i4 == 2 && this.mAdRequestType == 0) {
                starLoadAdResource(adSourceModel);
            } else {
                dispatchAdSourceByChannelResult(adSourceModel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void handleC2SFloorAdSourceBidResult(AdSourceModel adSourceModel, AMPSBaseBiddingResult aMPSBaseBiddingResult, int i4) {
        try {
            if (adSourceModel.getAdStatus() == 3 && i4 == 2) {
                starLoadAdResource(adSourceModel);
            } else {
                handleCallbackAdSourceLoadResult();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void handleCallbackAdSourceLoadResult() {
        IPriceComparatorInterface iPriceComparatorInterface;
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " handleCallbackAdSourceLoadResult ");
            if (this.mAMPSBaseAdapter == null && (iPriceComparatorInterface = this.iPriceComparatorInterface) != null) {
                AdSourceModel winAdSourceModel = iPriceComparatorInterface.getWinAdSourceModel();
                if (winAdSourceModel != null && !TextUtils.isEmpty(winAdSourceModel.getSpaceId())) {
                    callBackAdLoadSuccess(winAdSourceModel);
                    return;
                }
                if (judgeIsHasNoResultAdSource() || this.ampsLoadEventListener == null) {
                    return;
                }
                AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_REQUEST_ERROR;
                callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void handlerBiddingTimeout() {
        List<AdSourceModel> list;
        try {
            if (this.mAmpsManagerTask == null || this.mAdRequestType == 0) {
                return;
            }
            List<AdSourceModel> list2 = this.mS2SAdSourceList;
            if ((list2 == null || list2.size() <= 0) && ((list = this.mC2SAdSourceList) == null || list.size() <= 0)) {
                return;
            }
            this.mAmpsManagerTask.startBiddingTimerTask(this.mBidAdTimeout, new IBiddingTimeoutTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.1
                @Override // xyz.adscope.amps.tool.task.inter.IBiddingTimeoutTimerCallBack
                public void callBackBiddingTimeout() {
                    AMPSBaseOpenApiManager.this.dispatchAdSourceByTimeOut();
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void handlerRequestedTimeout() {
        try {
            AMPSManagerTask aMPSManagerTask = this.mAmpsManagerTask;
            if (aMPSManagerTask == null) {
                return;
            }
            aMPSManagerTask.startRequestedTimerTask(this.mAdRequestTimeout, new IRequestTimeoutTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.2
                @Override // xyz.adscope.amps.tool.task.inter.IRequestTimeoutTimerCallBack
                public void callBackRequestedTimeout() {
                    try {
                        AMPSBaseOpenApiManager.this.isRequestTimeout = true;
                        if (AMPSBaseOpenApiManager.this.mAmpsManagerTask != null && AMPSBaseOpenApiManager.this.mAMPSBaseAdapter == null) {
                            for (AdSourceModel adSourceModel : AMPSBaseOpenApiManager.this.loadAdResourceDatas.values()) {
                                if (adSourceModel != null && adSourceModel.getAdStatus() < 5) {
                                    adSourceModel.setAdStatus(6);
                                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT;
                                    adSourceModel.setErrorCode(channelErrorEnum.getErrorCode());
                                    adSourceModel.setErrorMsg(channelErrorEnum.getErrorMsg() + " , handlerRequestedTimeout");
                                    AMPSBaseOpenApiManager aMPSBaseOpenApiManager = AMPSBaseOpenApiManager.this;
                                    AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE;
                                    String errorCode = channelErrorEnum.getErrorCode();
                                    aMPSBaseOpenApiManager.uploadLog(adSourceModel, aMPSEventReportCode, errorCode, channelErrorEnum.getErrorMsg() + " , handlerRequestedTimeout", 0L);
                                }
                            }
                            if (AMPSBaseOpenApiManager.this.iPriceComparatorInterface == null) {
                                return;
                            }
                            AMPSBaseOpenApiManager.this.iPriceComparatorInterface.comparePriceTimeout();
                            AdSourceModel winAdSourceModel = AMPSBaseOpenApiManager.this.iPriceComparatorInterface.getWinAdSourceModel();
                            if (winAdSourceModel == null) {
                                AMPSBaseOpenApiManager aMPSBaseOpenApiManager2 = AMPSBaseOpenApiManager.this;
                                AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_REQUEST_TIME_OUT;
                                aMPSBaseOpenApiManager2.callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
                                return;
                            }
                            AMPSBaseOpenApiManager.this.callBackAdLoadSuccess(winAdSourceModel);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean judgeIsHasNoResultAdSource() {
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null && adSourceModel.getAdStatus() >= 1 && adSourceModel.getAdStatus() <= 4) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private void removeCacheAdSource(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AdSourceModel adSourceModel = this.loadAdResourceDatas.containsKey(str) ? this.loadAdResourceDatas.get(str) : null;
            if (adSourceModel == null || TextUtils.isEmpty(adSourceModel.getAppId())) {
                return;
            }
            AMPSCacheController.getInstance().removeAdSourceCacheInfo(this.mSpaceId, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void requestAdResource(AdSourceModel adSourceModel) {
        AMPSBaseAdapter createAdapterClass;
        AMPSBaseAdapter baseAdapter;
        if (adSourceModel == null) {
            return;
        }
        try {
            String spaceId = adSourceModel.getSpaceId();
            if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equals(adSourceModel.getBiddingType())) {
                uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_GET_CACHE_CODE, "", "", 0L);
                AMPSAdSourceCacheInfo adSourceCacheInfo = AMPSCacheController.getInstance().getAdSourceCacheInfo(this.mSpaceId, spaceId);
                if (adSourceCacheInfo == null) {
                    AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_GET_CACHE_FAIL_CODE;
                    AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_GET_CACHE_FAIL;
                    uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                }
                if (adSourceCacheInfo != null && (baseAdapter = adSourceCacheInfo.getBaseAdapter()) != null) {
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_GET_CACHE_SUCCESS_CODE, "", "", 0L);
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "loadAdResource  cacheInfo spaceId:" + adSourceCacheInfo.getSpaceId());
                    adSourceModel.setCache(true);
                    this.loadAdResourceAdapters.put(adSourceModel.getSpaceId(), baseAdapter);
                    addFilterEvent(adSourceModel.getSpaceId(), "request");
                    onAdLoaded(baseAdapter);
                    return;
                }
            }
            if (this.loadAdResourceAdapters.containsKey(adSourceModel.getSpaceId())) {
                createAdapterClass = this.loadAdResourceAdapters.get(adSourceModel.getSpaceId());
            } else {
                createAdapterClass = AMPSAdapterFactory.createAdapterClass(adSourceModel.getAdapterClass());
            }
            if (createAdapterClass == null) {
                AMPSEventReportCode aMPSEventReportCode2 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_SELECTOR_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum2 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_FAIL_SELECTOR_ADAPTER_NULL;
                uploadLog(adSourceModel, aMPSEventReportCode2, reportLogErrorEnum2.getErrorCode(), reportLogErrorEnum2.getErrorMsg(), 0L);
                adSourceModel.setAdStatus(6);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "loadAdResource  adapter name error spaceId:" + adSourceModel.getSpaceId());
                dispatchAdSourceByChannelResult(adSourceModel);
                return;
            }
            addFilterEvent(adSourceModel.getSpaceId(), "request");
            AMPSAdapterModel aMPSAdapterModel = new AMPSAdapterModel();
            aMPSAdapterModel.setAppId(adSourceModel.getAppId());
            aMPSAdapterModel.setSpaceId(adSourceModel.getSpaceId());
            aMPSAdapterModel.setTimeOut(this.mAdSourceRequestTimeout);
            aMPSAdapterModel.setZoomOut(adSourceModel.getZoomout());
            aMPSAdapterModel.setVideoSound(adSourceModel.getVideoSound());
            aMPSAdapterModel.setVideoMaxTime(adSourceModel.getVideoMaxTime());
            aMPSAdapterModel.setVideoAutoPlay(adSourceModel.getVideoAutoPlay());
            aMPSAdapterModel.setOrientation(adSourceModel.getOrientation());
            aMPSAdapterModel.setExtra(adSourceModel.getOrientation());
            if (adSourceModel.getTemplateTypes() != null && adSourceModel.getTemplateTypes().size() > 0) {
                aMPSAdapterModel.setTemplateTypes(adSourceModel.getTemplateTypes());
            }
            AMPSRequestParameters aMPSRequestParameters = this.mAMPSRequestParameters;
            if (aMPSRequestParameters != null) {
                aMPSAdapterModel.setAdCount(aMPSRequestParameters.getAdCount());
                aMPSAdapterModel.setExpressViewWidth(this.mAMPSRequestParameters.getWidth());
                aMPSAdapterModel.setExpressViewHeight(this.mAMPSRequestParameters.getHeight());
                aMPSAdapterModel.setUserId(this.mAMPSRequestParameters.getUserId());
                aMPSAdapterModel.setExtra(this.mAMPSRequestParameters.getExtraData());
            }
            AMPSInitAdapterConfig aMPSInitAdapterConfig = new AMPSInitAdapterConfig();
            aMPSInitAdapterConfig.setAppId(adSourceModel.getAppId());
            aMPSInitAdapterConfig.setAmpsInitChannelAdapterConfig(this.ampsInitChannelAdapterConfig);
            aMPSAdapterModel.setAmpsInitAdapterConfig(aMPSInitAdapterConfig);
            aMPSAdapterModel.setIsSendBidData(adSourceModel.getIsSendBidData());
            this.loadAdResourceAdapters.put(adSourceModel.getSpaceId(), createAdapterClass);
            if (!adSourceModel.isCache()) {
                if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() <= 1) {
                    this.adSourceBiddingStartTime = System.currentTimeMillis();
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_CODE, "", "", 0L);
                } else {
                    this.adSourceRequestStartTime = System.currentTimeMillis();
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_CODE, "", "", 0L);
                }
            }
            if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() <= 1) {
                adSourceModel.setAdStatus(2);
                createAdapterClass.startBid(this.mContext, aMPSAdapterModel, this);
                return;
            }
            adSourceModel.setAdStatus(4);
            createAdapterClass.loadNetworkAd(this.mContext, aMPSAdapterModel, this);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void sendLosNotice() {
        AMPSBaseAdapter aMPSBaseAdapter;
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null && !AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (!TextUtils.isEmpty(spaceId)) {
                        AdSourceModel adSourceModel2 = this.mWinAdSourceModel;
                        if (!spaceId.equalsIgnoreCase(adSourceModel2 != null ? adSourceModel2.getSpaceId() : "") && this.loadAdResourceAdapters.containsKey(spaceId) && (aMPSBaseAdapter = this.loadAdResourceAdapters.get(spaceId)) != null) {
                            AMPSBidResult aMPSBidResult = new AMPSBidResult();
                            aMPSBidResult.setEcpm(this.mWinAdSourceModel.getEcpm());
                            aMPSBidResult.setChannelName(this.mWinAdSourceModel.getSeatId());
                            aMPSBidResult.setBidType(this.mWinAdSourceModel.getBiddingType());
                            if (adSourceModel.getAdComparePriceStatus() == 0) {
                                if (AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT.getErrorCode().equals(adSourceModel.getErrorCode())) {
                                    aMPSBidResult.setReason(3);
                                } else {
                                    aMPSBidResult.setReason(2);
                                }
                            } else {
                                aMPSBidResult.setReason(1);
                            }
                            aMPSBaseAdapter.sendLossNotice(aMPSBidResult);
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void sendLosNoticeByFail() {
        AMPSBaseAdapter aMPSBaseAdapter;
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null && !AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (!TextUtils.isEmpty(spaceId) && adSourceModel.getAdStatus() == 6 && this.loadAdResourceAdapters.containsKey(spaceId) && (aMPSBaseAdapter = this.loadAdResourceAdapters.get(spaceId)) != null) {
                        AMPSBidResult aMPSBidResult = new AMPSBidResult();
                        aMPSBidResult.setEcpm(0);
                        aMPSBidResult.setChannelName("-1");
                        aMPSBidResult.setBidType("other");
                        if (AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT.getErrorCode().equals(adSourceModel.getErrorCode())) {
                            aMPSBidResult.setReason(3);
                        } else {
                            aMPSBidResult.setReason(2);
                        }
                        aMPSBaseAdapter.sendLossNotice(aMPSBidResult);
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void starLoadAdResource(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return;
        }
        try {
            requestAdResource(adSourceModel);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void startCacheLoadSuccessAdSource() {
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (!TextUtils.isEmpty(spaceId) && adSourceModel.getAdStatus() == 5 && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && !adSourceModel.isCache()) {
                        AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                        if (aMPSBaseAdapter != null) {
                            String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                            if (!TextUtils.isEmpty(networkSpaceId) && networkSpaceId.equalsIgnoreCase(spaceId)) {
                            }
                        }
                        AMPSBaseAdapter aMPSBaseAdapter2 = this.loadAdResourceAdapters.containsKey(spaceId) ? this.loadAdResourceAdapters.get(spaceId) : null;
                        if (aMPSBaseAdapter2 != null) {
                            AMPSCacheController.getInstance().addAdSourceCacheInfo(this.mSpaceModel, adSourceModel, aMPSBaseAdapter2);
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void updateC2SAdSourceAdStatus(AdSourceModel adSourceModel, AMPSBaseBiddingResult aMPSBaseBiddingResult) {
        if (adSourceModel == null) {
            return;
        }
        try {
            if (aMPSBaseBiddingResult == null) {
                adSourceModel.setAdStatus(6);
                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_FAIL_RESULT_NULL;
                uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), System.currentTimeMillis() - this.adSourceBiddingStartTime);
            } else if (adSourceModel.getAdStatus() == 6) {
                adSourceModel.setAdStatus(6);
            } else if (!aMPSBaseBiddingResult.isSuccess()) {
                adSourceModel.setAdStatus(6);
                AMPSEventReportCode aMPSEventReportCode2 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum2 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_FAIL_RESULT;
                uploadLog(adSourceModel, aMPSEventReportCode2, reportLogErrorEnum2.getErrorCode(), reportLogErrorEnum2.getErrorMsg(), System.currentTimeMillis() - this.adSourceBiddingStartTime);
            } else {
                adSourceModel.setEcpm(aMPSBaseBiddingResult.getEcpm());
                uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_SUCCESS_CODE, "", "", System.currentTimeMillis() - this.adSourceBiddingStartTime);
                if (aMPSBaseBiddingResult.getEcpm() < adSourceModel.getFloorEcpm()) {
                    adSourceModel.setAdStatus(6);
                    AMPSEventReportCode aMPSEventReportCode3 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_COMPARE_FAIL_CODE;
                    AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum3 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_COMPARE_FAIL_LESS_FLOOR;
                    uploadLog(adSourceModel, aMPSEventReportCode3, reportLogErrorEnum3.getErrorCode(), reportLogErrorEnum3.getErrorMsg(), 0L);
                    return;
                }
                adSourceModel.setAdStatus(3);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void destroy() {
        try {
            Map<String, AdSourceModel> map = this.loadAdResourceDatas;
            if (map != null && !map.isEmpty()) {
                for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                    if (adSourceModel != null && adSourceModel.getAdStatus() < 5) {
                        AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE;
                        AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_LOAD_REQUEST_FAIL;
                        String errorCode = reportLogErrorEnum.getErrorCode();
                        uploadLog(adSourceModel, aMPSEventReportCode, errorCode, reportLogErrorEnum.getErrorMsg() + " onDestroy", 0L);
                    }
                }
            }
            Map<String, AMPSBaseAdapter> map2 = this.loadAdResourceAdapters;
            if (map2 != null && map2.size() > 0) {
                for (Map.Entry<String, AMPSBaseAdapter> entry : this.loadAdResourceAdapters.entrySet()) {
                    AMPSBaseAdapter value = entry.getValue();
                    if (value != null) {
                        value.destroy();
                    }
                }
            }
            this.mAMPSBaseAdapter = null;
            Map<String, AdSourceModel> map3 = this.loadAdResourceDatas;
            if (map3 != null) {
                map3.clear();
            }
            this.loadAdResourceDatas = null;
            Map<String, AMPSBaseAdapter> map4 = this.loadAdResourceAdapters;
            if (map4 != null) {
                map4.clear();
            }
            this.loadAdResourceAdapters = null;
            this.mSpaceModel = null;
            List<AdSourceModel> list = this.mS2SAdSourceList;
            if (list != null) {
                list.clear();
            }
            this.mS2SAdSourceList = null;
            List<AdSourceModel> list2 = this.mC2SAdSourceList;
            if (list2 != null) {
                list2.clear();
            }
            this.mC2SAdSourceList = null;
            List<AdSourceModel> list3 = this.mFloorAdSourceList;
            if (list3 != null) {
                list3.clear();
            }
            this.mFloorAdSourceList = null;
            this.iDispatcherInterface = null;
            this.iPriceComparatorInterface = null;
            this.mContext = null;
            AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
            if (aMPSInitChannelAdapterConfig != null) {
                aMPSInitChannelAdapterConfig.clear();
                this.ampsInitChannelAdapterConfig = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public int getAdAutoRefreshSwitch() {
        return this.mAdAutoRefreshSwitch;
    }

    public long getSpaceCachedOffersTimeout() {
        return this.mSpaceCachedOffersTimeout;
    }

    public AMPSBaseAdapter getWinAdSourceAdapter() {
        return this.mAMPSBaseAdapter;
    }

    public AdSourceModel getWinAdSourceModel() {
        return this.mWinAdSourceModel;
    }

    public boolean isWinAdSource(AMPSBaseAdapter aMPSBaseAdapter) {
        AMPSBaseAdapter aMPSBaseAdapter2;
        if (aMPSBaseAdapter != null) {
            String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
            return (TextUtils.isEmpty(networkSpaceId) || (aMPSBaseAdapter2 = this.mAMPSBaseAdapter) == null || !aMPSBaseAdapter2.getNetworkSpaceId().equals(networkSpaceId)) ? false : true;
        }
        return false;
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdClicked(AMPSBaseAdapter aMPSBaseAdapter) {
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdClicked ");
            if (this.ampsLoadEventListener != null && isWinAdSource(aMPSBaseAdapter)) {
                AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                    ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
                } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                    ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
                } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                    ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdVideoClick();
                } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
                }
                AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter2 != null) {
                    String networkSpaceId = aMPSBaseAdapter2.getNetworkSpaceId();
                    addFilterEvent(networkSpaceId, "click");
                    AdSourceModel adSourceModel = this.loadAdResourceDatas.get(networkSpaceId);
                    if (adSourceModel == null) {
                        return;
                    }
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_CLICK_CODE, "", "", 0L);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdDismiss(AMPSBaseAdapter aMPSBaseAdapter) {
        AdSourceModel adSourceModel;
        try {
            if (!this.isAdClosed && isWinAdSource(aMPSBaseAdapter)) {
                this.isAdClosed = true;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdDismiss ");
                AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                if (aMPSLoadEventListener == null) {
                    return;
                }
                if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                    ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
                } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                    ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
                } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                    ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
                } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
                }
                AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter2 != null) {
                    String networkSpaceId = aMPSBaseAdapter2.getNetworkSpaceId();
                    if (TextUtils.isEmpty(networkSpaceId) || (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) == null) {
                        return;
                    }
                    for (AdSourceModel adSourceModel2 : this.loadAdResourceDatas.values()) {
                        if (adSourceModel2 != null && adSourceModel2.getAdStatus() < 5) {
                            adSourceModel2.setAdStatus(6);
                            AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE;
                            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT;
                            String errorCode = channelErrorEnum.getErrorCode();
                            uploadLog(adSourceModel2, aMPSEventReportCode, errorCode, channelErrorEnum.getErrorMsg() + " , onAdDismiss", 0L);
                        }
                    }
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_CLOSE_CODE, "", "", 0L);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void onAdFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError) {
        AdSourceModel adSourceModel;
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdFailed code: " + aMPSError.getCode() + ";message:" + aMPSError.getMessage() + " spaceID:" + aMPSBaseAdapter.getNetworkSpaceId());
            if (this.ampsLoadEventListener != null) {
                String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                if (TextUtils.isEmpty(networkSpaceId) || !this.loadAdResourceDatas.containsKey(networkSpaceId) || (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) == null) {
                    return;
                }
                if (adSourceModel.getAdStatus() != 6) {
                    long currentTimeMillis = System.currentTimeMillis() - this.adSourceRequestStartTime;
                    adSourceModel.setAdStatus(6);
                    String code = aMPSError.getCode();
                    String message = aMPSError.getMessage();
                    adSourceModel.setErrorCode(code);
                    adSourceModel.setErrorMsg(message);
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE, code, message, currentTimeMillis);
                }
                dispatchAdSourceByChannelResult(adSourceModel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void onAdLoaded(AMPSBaseAdapter aMPSBaseAdapter) {
        AdSourceModel adSourceModel;
        try {
            if (this.ampsLoadEventListener != null && aMPSBaseAdapter != null) {
                String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                if (TextUtils.isEmpty(networkSpaceId) || !this.loadAdResourceDatas.containsKey(networkSpaceId) || (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) == null) {
                    return;
                }
                if (!adSourceModel.isCache()) {
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_SUCCESS_CODE, "", "", System.currentTimeMillis() - this.adSourceRequestStartTime);
                }
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " channel:" + adSourceModel.getSeatId() + " spaceId:" + networkSpaceId + ", onAdLoaded success");
                adSourceModel.setAdStatus(5);
                this.isHasLoadingSuccess = true;
                if (this.mAMPSBaseAdapter != null && !adSourceModel.isCache() && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    AMPSCacheController.getInstance().addAdSourceCacheInfo(this.mSpaceModel, adSourceModel, aMPSBaseAdapter);
                }
                comparePrice(aMPSBaseAdapter, adSourceModel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdShow(AMPSBaseAdapter aMPSBaseAdapter) {
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdShow ");
            if (this.ampsLoadEventListener != null && isWinAdSource(aMPSBaseAdapter)) {
                this.mSpaceAdStatus = 2;
                AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                    ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                    ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                    ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                }
                AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter2 != null) {
                    String networkSpaceId = aMPSBaseAdapter2.getNetworkSpaceId();
                    addFilterEvent(networkSpaceId, "show");
                    AdSourceModel adSourceModel = this.loadAdResourceDatas.get(networkSpaceId);
                    if (adSourceModel == null) {
                        return;
                    }
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_SHOW_CODE, "", "", 0L);
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_EXPOSURE_CODE, "", "", 0L);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdShowFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError) {
        String str;
        try {
            if (this.mWinAdSourceModel != null && isWinAdSource(aMPSBaseAdapter) && this.mWinAdSourceModel.getAdStatus() == 5) {
                String str2 = "";
                if (aMPSError != null) {
                    str2 = aMPSError.getCode();
                    str = aMPSError.getMessage();
                } else {
                    str = "";
                }
                uploadLog(this.mWinAdSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_SHOW_FAIL_CODE, str2, str, 0L);
                this.isDispatchFloorAdSource = true;
                AMPSCacheController.getInstance().removeAdSourceCacheInfo(this.mSpaceId, this.mWinAdSourceModel.getSpaceId());
                callBackAdLoadFail(str2, str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSAdBiddingListener
    public void onC2SBiddingFail(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult) {
        AdSourceModel adSourceModel;
        if (aMPSBaseAdapter == null || aMPSBaseBiddingResult == null) {
            return;
        }
        try {
            String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
            if (TextUtils.isEmpty(networkSpaceId) || !this.loadAdResourceDatas.containsKey(networkSpaceId) || (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) == null || adSourceModel.getAdStatus() == 5) {
                return;
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onC2SBiddingFail  channel:" + adSourceModel.getSeatId() + ",spaceId:" + networkSpaceId + ";adStatus:" + adSourceModel.getAdStatus() + ";" + aMPSBaseBiddingResult.toString());
            adSourceModel.setAdStatus(6);
            uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE, aMPSBaseBiddingResult.getErrorCode(), aMPSBaseBiddingResult.getErrorMsg(), System.currentTimeMillis() - this.adSourceBiddingStartTime);
            if (adSourceModel.getIsFloor() == 1) {
                handleC2SFloorAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, 4);
            } else {
                handleC2SAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, 4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSAdBiddingListener
    public void onC2SBiddingSuccess(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult) {
        AdSourceModel adSourceModel;
        if (aMPSBaseAdapter == null || aMPSBaseBiddingResult == null) {
            return;
        }
        try {
            if (this.iPriceComparatorInterface == null) {
                return;
            }
            String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
            if (TextUtils.isEmpty(networkSpaceId) || !this.loadAdResourceDatas.containsKey(networkSpaceId) || (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) == null || adSourceModel.getAdStatus() == 5) {
                return;
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onC2SBiddingSuccess  channel:" + adSourceModel.getSeatId() + ",spaceId:" + networkSpaceId + ";adStatus:" + adSourceModel.getAdStatus() + ";" + aMPSBaseBiddingResult.toString());
            updateC2SAdSourceAdStatus(adSourceModel, aMPSBaseBiddingResult);
            AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_COMPARE;
            uploadLog(adSourceModel, aMPSEventReportCode, "", "", 0L);
            int comparePriceResult = this.iPriceComparatorInterface.getComparePriceResult(adSourceModel);
            adSourceModel.setAdComparePriceStatus(comparePriceResult);
            if (adSourceModel.getAdStatus() == 3) {
                uploadLog(adSourceModel, aMPSEventReportCode, "", "", 0L);
                if (comparePriceResult != 2) {
                    adSourceModel.setAdStatus(6);
                    AMPSEventReportCode aMPSEventReportCode2 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_COMPARE_FAIL_CODE;
                    AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_COMPARE_FAIL;
                    uploadLog(adSourceModel, aMPSEventReportCode2, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                } else {
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_COMPARE_SUCCESS_CODE, "", "", 0L);
                }
            }
            if (adSourceModel.getIsFloor() == 1) {
                handleC2SFloorAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, comparePriceResult);
            } else {
                handleC2SAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, comparePriceResult);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void preLoad() {
    }

    public void refreshListener(T t3) {
        this.ampsLoadEventListener = t3;
    }

    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter != null) {
                    aMPSBaseAdapter.refreshAMPSAdAdapterListener(this);
                    this.mAMPSBaseAdapter.showAd(viewGroup);
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_SHOW_ERROR;
        callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
    }

    public void startLoad() {
        try {
            if (this.mSpaceModel != null && this.mAMPSRequestParameters != null && this.iFilterInterface != null && this.iDispatcherInterface != null) {
                uploadLog(null, AMPSEventReportCode.EVENT_SPACE_FILTER_CODE, "", "", 0L);
                if (!this.iFilterInterface.platformFilter()) {
                    this.isDispatchFloorAdSource = true;
                    uploadLog(null, AMPSEventReportCode.EVENT_SPACE_FILTER_FAIL_CODE, "", "", 0L);
                    AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_FILTER_NOT_PASS;
                    callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
                    return;
                }
                uploadLog(null, AMPSEventReportCode.EVENT_SPACE_FILTER_SUCCESS_CODE, "", "", 0L);
                createAMPSInitCustomAdapterConfig();
                addFilterEvent("", "request");
                handlerBiddingTimeout();
                handlerRequestedTimeout();
                uploadLog(null, AMPSEventReportCode.EVENT_FORWARD_BEGIN_CODE, "", "", 0L);
                List<AdSourceModel> dispatch = this.iDispatcherInterface.dispatch(null);
                uploadLog(null, AMPSEventReportCode.EVENT_FORWARD_RESULT_CODE, "", "", 0L);
                dispatchAdSource(dispatch);
                dispatchAdSourceByFloor();
                return;
            }
            this.isDispatchFloorAdSource = true;
            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum2 = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_PARAM_ERROR;
            callBackAdLoadFail(aSMPLogicErrorEnum2.getErrorCode(), aSMPLogicErrorEnum2.getErrorMsg());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public synchronized void uploadLog(AdSourceModel adSourceModel, AMPSEventReportCode aMPSEventReportCode, String str, String str2, long j4) {
        try {
            AMPSCycleModel aMPSCycleModel = new AMPSCycleModel();
            aMPSCycleModel.setMediationAppId(AMPSSDKManager.getInstance().getAppId());
            aMPSCycleModel.setMediationSpaceId(this.mSpaceId);
            aMPSCycleModel.setErrorCode(str);
            aMPSCycleModel.setErrorMsg(str2);
            aMPSCycleModel.setRoundTripTime(j4);
            if (adSourceModel != null) {
                aMPSCycleModel.setAdSourceAppId(adSourceModel.getAppId());
                aMPSCycleModel.setAdSourceId(adSourceModel.getSeatId());
                aMPSCycleModel.setAdSourceSpaceId(adSourceModel.getSpaceId());
                aMPSCycleModel.setEcpm(adSourceModel.getEcpm() + "");
                aMPSCycleModel.setAdSourceCustomData(adSourceModel.getCustomData());
                aMPSCycleModel.setBidType(adSourceModel.getBiddingType());
                aMPSCycleModel.setFloorPrice(adSourceModel.getFloorEcpm() + "");
            }
            AMPSRequestParameters aMPSRequestParameters = this.mAMPSRequestParameters;
            if (aMPSRequestParameters != null) {
                aMPSCycleModel.setLoadType(aMPSRequestParameters.getLoadType());
                aMPSCycleModel.setAdCount(this.mAMPSRequestParameters.getAdCount() + "");
            }
            SpaceModel spaceModel = this.mSpaceModel;
            if (spaceModel != null) {
                aMPSCycleModel.setAdType(spaceModel.getAdType());
                aMPSCycleModel.setSessionId(this.mSessionId);
                aMPSCycleModel.setSpaceCustomData(this.mSpaceModel.getCustomData());
                aMPSCycleModel.setMaxWaitTime(this.mSpaceModel.getAdsTimeout() + "");
            }
            AMPSReportLoader.getInstance().reportAdLog(aMPSCycleModel, aMPSEventReportCode.getCodeStr());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void show(Activity activity) {
        if (activity != null) {
            try {
                AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter != null) {
                    aMPSBaseAdapter.refreshAMPSAdAdapterListener(this);
                    this.mAMPSBaseAdapter.showAd(activity);
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_SHOW_ERROR;
        callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
    }
}
