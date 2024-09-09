package xyz.adscope.amps.control.bid;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSPriceComparator implements IPriceComparatorInterface {
    private int mAdRequestType;
    private List<AdSourceModel> mC2SAdSourceList;
    private Map<String, AdSourceModel> mRequestAdSourceDatas;
    private List<AdSourceModel> mS2SAdSourceList;
    private int mWeightRandomNum;
    private AdSourceModel mCandidateAdSourceModel = null;
    private AdSourceModel mWinAdSourceModel = null;

    public AMPSPriceComparator(SpaceModel spaceModel, Map<String, AdSourceModel> map) {
        this.mWeightRandomNum = 0;
        this.mS2SAdSourceList = null;
        this.mC2SAdSourceList = null;
        this.mAdRequestType = 0;
        if (spaceModel == null) {
            return;
        }
        this.mWeightRandomNum = spaceModel.getWeightRandomNum();
        this.mS2SAdSourceList = spaceModel.getS2sAdSourceList();
        this.mC2SAdSourceList = spaceModel.getC2sAdSourceList();
        this.mRequestAdSourceDatas = map;
        this.mAdRequestType = spaceModel.getBidDistributionMethod();
    }

    private int getBiddingSuccessCompareResult(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return 4;
        }
        AdSourceModel adSourceModel2 = this.mCandidateAdSourceModel;
        return (adSourceModel2 == null || adSourceModel2.getEcpm() < adSourceModel.getEcpm()) ? 2 : 4;
    }

    private int getCycleQueueCompareResult(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return 4;
        }
        for (AdSourceModel adSourceModel2 : this.mRequestAdSourceDatas.values()) {
            if (adSourceModel2 != null && !isSameAdSource(adSourceModel2, adSourceModel)) {
                if (adSourceModel2.getAdStatus() == 5) {
                    if (adSourceModel2.getEcpm() == adSourceModel.getEcpm()) {
                        if (isSameAdSource(adSourceModel, this.mCandidateAdSourceModel)) {
                            continue;
                        } else if (!AMPSRandomUtil.isHitRandomNum(adSourceModel.getStartWeight(), adSourceModel.getEndWeight(), this.mWeightRandomNum) && AMPSRandomUtil.isHitRandomNum(adSourceModel2.getStartWeight(), adSourceModel2.getEndWeight(), this.mWeightRandomNum)) {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice hit fail channel:" + adSourceModel2.getSeatId() + ",spaceId:" + adSourceModel2.getSpaceId() + ",adStatus:" + adSourceModel2.getAdStatus() + ",ecpm:" + adSourceModel2.getEcpm());
                            return 4;
                        }
                    }
                    if (adSourceModel2.getEcpm() > adSourceModel.getEcpm()) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice fail channel:" + adSourceModel2.getSeatId() + ",spaceId:" + adSourceModel2.getSpaceId() + ",adStatus:" + adSourceModel2.getAdStatus() + ",ecpm:" + adSourceModel2.getEcpm());
                        return 4;
                    }
                }
                if (adSourceModel2.getAdStatus() > 0 && adSourceModel2.getAdStatus() <= 4 && (adSourceModel2.getEcpm() != adSourceModel.getEcpm() || (!AMPSRandomUtil.isHitRandomNum(adSourceModel.getStartWeight(), adSourceModel.getEndWeight(), this.mWeightRandomNum) && AMPSRandomUtil.isHitRandomNum(adSourceModel2.getStartWeight(), adSourceModel2.getEndWeight(), this.mWeightRandomNum)))) {
                    if (this.mAdRequestType != 1 || adSourceModel2.getEcpm() >= adSourceModel.getEcpm()) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice wait channel:" + adSourceModel2.getSeatId() + ",spaceId:" + adSourceModel2.getSpaceId() + ",adStatus:" + adSourceModel2.getAdStatus() + ",ecpm:" + adSourceModel2.getEcpm());
                        return 1;
                    }
                }
            }
        }
        if (this.mAdRequestType == 0 && !isBidFinish()) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice wait bidding not finish:");
            return 1;
        }
        this.mWinAdSourceModel = adSourceModel;
        return 3;
    }

    private boolean isBidFinish() {
        if (isExistC2SOrS2SAdSource()) {
            List<AdSourceModel> list = this.mC2SAdSourceList;
            if (list != null && list.size() > 0) {
                for (AdSourceModel adSourceModel : this.mC2SAdSourceList) {
                    if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() <= 2) {
                        return false;
                    }
                }
            }
            List<AdSourceModel> list2 = this.mS2SAdSourceList;
            if (list2 != null && list2.size() > 0) {
                for (AdSourceModel adSourceModel2 : this.mS2SAdSourceList) {
                    if (adSourceModel2 != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(adSourceModel2.getBiddingType()) && adSourceModel2.getAdStatus() <= 2) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    private boolean isExistC2SOrS2SAdSource() {
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list == null || list.size() == 0) {
            List<AdSourceModel> list2 = this.mS2SAdSourceList;
            return (list2 == null || list2.size() == 0) ? false : true;
        }
        return true;
    }

    private boolean isSameAdSource(AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
        if (adSourceModel != null && adSourceModel2 != null) {
            String spaceId = adSourceModel.getSpaceId();
            String spaceId2 = adSourceModel2.getSpaceId();
            if (!TextUtils.isEmpty(spaceId) && !TextUtils.isEmpty(spaceId2) && spaceId.equalsIgnoreCase(spaceId2)) {
                return true;
            }
        }
        return false;
    }

    @Override // xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface
    public void comparePriceTimeout() {
        AdSourceModel adSourceModel;
        if (this.mWinAdSourceModel == null && (adSourceModel = this.mCandidateAdSourceModel) != null) {
            this.mWinAdSourceModel = adSourceModel;
        }
    }

    @Override // xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface
    public int getComparePriceResult(AdSourceModel adSourceModel) {
        Map<String, AdSourceModel> map;
        if (adSourceModel == null || (map = this.mRequestAdSourceDatas) == null || map.size() == 0 || this.mWinAdSourceModel != null) {
            return 4;
        }
        if (adSourceModel.getAdStatus() == 3) {
            return getBiddingSuccessCompareResult(adSourceModel);
        }
        if (adSourceModel.getAdStatus() != 5) {
            return 4;
        }
        AdSourceModel adSourceModel2 = this.mCandidateAdSourceModel;
        if (adSourceModel2 != null && !isSameAdSource(adSourceModel2, adSourceModel)) {
            if (this.mCandidateAdSourceModel.getEcpm() > adSourceModel.getEcpm()) {
                return 4;
            }
            if (this.mCandidateAdSourceModel.getEcpm() == adSourceModel.getEcpm()) {
                if (AMPSRandomUtil.isHitRandomNum(this.mCandidateAdSourceModel.getStartWeight(), this.mCandidateAdSourceModel.getEndWeight(), this.mWeightRandomNum) || !AMPSRandomUtil.isHitRandomNum(adSourceModel.getStartWeight(), adSourceModel.getEndWeight(), this.mWeightRandomNum)) {
                    return 4;
                }
                this.mCandidateAdSourceModel = adSourceModel;
            }
        }
        AdSourceModel adSourceModel3 = this.mCandidateAdSourceModel;
        if (adSourceModel3 == null || adSourceModel3.getEcpm() < adSourceModel.getEcpm()) {
            this.mCandidateAdSourceModel = adSourceModel;
        }
        return getCycleQueueCompareResult(adSourceModel);
    }

    @Override // xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface
    public AdSourceModel getWinAdSourceModel() {
        AdSourceModel adSourceModel = this.mWinAdSourceModel;
        if (adSourceModel != null) {
            return adSourceModel;
        }
        AdSourceModel adSourceModel2 = this.mCandidateAdSourceModel;
        if (adSourceModel2 != null && getCycleQueueCompareResult(adSourceModel2) == 3) {
            return this.mWinAdSourceModel;
        }
        return null;
    }
}
