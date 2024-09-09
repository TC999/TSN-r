package xyz.adscope.amps.manager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.FilterModel;
import xyz.adscope.amps.model.config.response.FrequencyModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSAdSourceDataProvider {
    private static AMPSAdSourceDataProvider mInstance;
    private AMPSGlobalModel globalModel;

    private List<AdSourceModel> buildAdSourceModelList(List<AdSourceModel> list) {
        ArrayList arrayList = new ArrayList();
        for (AdSourceModel adSourceModel : list) {
            AdSourceModel adSourceModel2 = new AdSourceModel();
            adSourceModel2.setAppId(adSourceModel.getAppId());
            adSourceModel2.setSpaceId(adSourceModel.getSpaceId());
            adSourceModel2.setAdType(adSourceModel.getAdType());
            adSourceModel2.setSeatId(adSourceModel.getSeatId());
            adSourceModel2.setAdapterManagerClass(adSourceModel.getAdapterManagerClass());
            adSourceModel2.setAdapterClass(adSourceModel.getAdapterClass());
            adSourceModel2.setBiddingType(adSourceModel.getBiddingType());
            adSourceModel2.setRenderType(adSourceModel.getRenderType());
            adSourceModel2.setEcpm(adSourceModel.getEcpm());
            adSourceModel2.setFloorEcpm(adSourceModel.getFloorEcpm());
            adSourceModel2.setIsFloor(adSourceModel.getIsFloor());
            adSourceModel2.setPriority(adSourceModel.getPriority());
            adSourceModel2.setAdsTimeout(adSourceModel.getAdsTimeout());
            adSourceModel2.setBiddingTimeout(adSourceModel.getBiddingTimeout());
            adSourceModel2.setCachedOffersTimeout(adSourceModel.getCachedOffersTimeout());
            adSourceModel2.setAutoRefreshSwitch(adSourceModel.getAutoRefreshSwitch());
            adSourceModel2.setOrientation(adSourceModel.getOrientation());
            adSourceModel2.setZoomout(adSourceModel.getZoomout());
            adSourceModel2.setVideoSound(adSourceModel.getVideoSound());
            adSourceModel2.setVideoMaxTime(adSourceModel.getVideoMaxTime());
            adSourceModel2.setVideoAutoPlay(adSourceModel.getVideoAutoPlay());
            adSourceModel2.setCustomData(adSourceModel.getCustomData());
            if (adSourceModel.getFilter() != null) {
                adSourceModel2.setFilter(buildFilterModel(adSourceModel.getFilter()));
            }
            adSourceModel2.setAdStatus(adSourceModel.getAdStatus());
            adSourceModel2.setStartWeight(adSourceModel.getStartWeight());
            adSourceModel2.setEndWeight(adSourceModel.getEndWeight());
            if (adSourceModel.getTemplateTypes() != null && adSourceModel.getTemplateTypes().size() > 0) {
                adSourceModel2.setTemplateTypes(adSourceModel.getTemplateTypes());
            }
            adSourceModel2.setIsSendBidData(adSourceModel.getIsSendBidData());
            arrayList.add(adSourceModel2);
        }
        return arrayList;
    }

    private FilterModel buildFilterModel(FilterModel filterModel) {
        if (filterModel == null) {
            return null;
        }
        FilterModel filterModel2 = new FilterModel();
        filterModel2.setMinLoadTime(filterModel.getMinLoadTime());
        List<FrequencyModel> frequency = filterModel.getFrequency();
        if (frequency != null && frequency.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (FrequencyModel frequencyModel : frequency) {
                FrequencyModel frequencyModel2 = new FrequencyModel();
                frequencyModel2.setCount(frequencyModel.getCount());
                frequencyModel2.setEvent(frequencyModel.getEvent());
                frequencyModel2.setTime(frequencyModel.getTime());
                arrayList.add(frequencyModel2);
            }
            filterModel2.setFrequency(arrayList);
        }
        return filterModel2;
    }

    private SpaceModel copySpaceModel(SpaceModel spaceModel) {
        if (spaceModel == null) {
            return null;
        }
        SpaceModel spaceModel2 = new SpaceModel();
        spaceModel2.setSpaceId(spaceModel.getSpaceId());
        spaceModel2.setBidDistributionMethod(spaceModel.getBidDistributionMethod());
        spaceModel2.setAdType(spaceModel.getAdType());
        spaceModel2.setWaterfallParallelNum(spaceModel.getWaterfallParallelNum());
        spaceModel2.setAdTimeout(spaceModel.getAdTimeout());
        spaceModel2.setAdsTimeout(spaceModel.getAdsTimeout());
        spaceModel2.setBidAdTimeout(spaceModel.getBidAdTimeout());
        spaceModel2.setBidParallelNum(spaceModel.getBidParallelNum());
        spaceModel2.setAdFloorEcpm(spaceModel.getAdFloorEcpm());
        spaceModel2.setBidFloorEcpm(spaceModel.getBidFloorEcpm());
        spaceModel2.setCachedOffersNum(spaceModel.getCachedOffersNum());
        spaceModel2.setCachedOffersTimeout(spaceModel.getCachedOffersTimeout());
        spaceModel2.setAutoRefreshSwitch(spaceModel.getAutoRefreshSwitch());
        spaceModel2.setAutoRefreshTime(spaceModel.getAutoRefreshTime());
        spaceModel2.setFloorDelayTime(spaceModel.getFloorDelayTime());
        if (spaceModel.getS2sAdSourceList() != null && spaceModel.getS2sAdSourceList().size() > 0) {
            spaceModel2.setS2sAdSourceList(buildAdSourceModelList(spaceModel.getS2sAdSourceList()));
        }
        if (spaceModel.getC2sAdSourceList() != null && spaceModel.getC2sAdSourceList().size() > 0) {
            spaceModel2.setC2sAdSourceList(buildAdSourceModelList(spaceModel.getC2sAdSourceList()));
        }
        if (spaceModel.getWfAdSourceList() != null && spaceModel.getWfAdSourceList().size() > 0) {
            spaceModel2.setWfAdSourceList(buildAdSourceModelList(spaceModel.getWfAdSourceList()));
        }
        if (spaceModel.getFloorAdSourceList() != null && spaceModel.getFloorAdSourceList().size() > 0) {
            spaceModel2.setFloorAdSourceList(buildAdSourceModelList(spaceModel.getFloorAdSourceList()));
        }
        if (spaceModel.getFilter() != null) {
            spaceModel2.setFilter(buildFilterModel(spaceModel.getFilter()));
        }
        spaceModel2.setExt(spaceModel.getExt());
        spaceModel2.setWeightRandomNum(AMPSRandomUtil.getRandomNum(1000));
        spaceModel2.setCustomData(spaceModel.getCustomData());
        return spaceModel2;
    }

    public static AMPSAdSourceDataProvider getInstance() {
        if (mInstance == null) {
            synchronized (AMPSAdSourceDataProvider.class) {
                if (mInstance == null) {
                    mInstance = new AMPSAdSourceDataProvider();
                }
            }
        }
        return mInstance;
    }

    private AdSourceModel getSingleAdSourceByAdapterName(List<AdSourceModel> list, String str) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (AdSourceModel adSourceModel : list) {
                        if (str.equals(adSourceModel.getAdapterManagerClass())) {
                            return adSourceModel;
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public SpaceModel buildDispatcherModel(AMPSRequestParameters aMPSRequestParameters) {
        List<SpaceModel> spaceList;
        try {
            AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
            this.globalModel = globalModel;
            if (globalModel != null && aMPSRequestParameters != null && !TextUtils.isEmpty(globalModel.getAppId()) && this.globalModel.getConfigureResponseModel() != null && this.globalModel.getConfigureResponseModel().getMediation() != null && !TextUtils.isEmpty(this.globalModel.getConfigureResponseModel().getMediation().getAppId()) && this.globalModel.getAppId().equals(this.globalModel.getConfigureResponseModel().getMediation().getAppId()) && (spaceList = this.globalModel.getConfigureResponseModel().getMediation().getSpaceList()) != null && spaceList.size() > 0) {
                for (int i4 = 0; i4 < spaceList.size(); i4++) {
                    SpaceModel spaceModel = spaceList.get(i4);
                    if (!TextUtils.isEmpty(spaceModel.getSpaceId()) && !TextUtils.isEmpty(aMPSRequestParameters.getSpaceId()) && spaceModel.getSpaceId().equals(aMPSRequestParameters.getSpaceId())) {
                        return copySpaceModel(spaceModel);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public AdSourceModel getAdSourceByAdapterName(String str) {
        AMPSGlobalModel aMPSGlobalModel;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && (aMPSGlobalModel = this.globalModel) != null && aMPSGlobalModel.getConfigureResponseModel() != null && this.globalModel.getConfigureResponseModel().getMediation() != null && this.globalModel.getConfigureResponseModel().getMediation().getSpaceList() != null && this.globalModel.getConfigureResponseModel().getMediation().getSpaceList().size() >= 1) {
            Iterator<SpaceModel> it = this.globalModel.getConfigureResponseModel().getMediation().getSpaceList().iterator();
            if (it.hasNext()) {
                SpaceModel next = it.next();
                List<AdSourceModel> s2sAdSourceList = next.getS2sAdSourceList();
                if (s2sAdSourceList != null && s2sAdSourceList.size() > 0) {
                    return getSingleAdSourceByAdapterName(s2sAdSourceList, str);
                }
                List<AdSourceModel> c2sAdSourceList = next.getC2sAdSourceList();
                if (c2sAdSourceList != null && c2sAdSourceList.size() > 0) {
                    return getSingleAdSourceByAdapterName(c2sAdSourceList, str);
                }
                List<AdSourceModel> wfAdSourceList = next.getWfAdSourceList();
                if (wfAdSourceList != null && wfAdSourceList.size() > 0) {
                    return getSingleAdSourceByAdapterName(wfAdSourceList, str);
                }
                return getSingleAdSourceByAdapterName(next.getFloorAdSourceList(), str);
            }
            return null;
        }
        return null;
    }
}
