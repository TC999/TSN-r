package xyz.adscope.amps.control.dispatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.AMPSListUtil;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSDispatcher implements IDispatcherInterface {
    private int mAdRequestType;
    private List<AdSourceModel> mC2SAdSourceList;
    private int mC2SMaxRequestNum;
    private List<AdSourceModel> mS2SAdSourceList;
    private List<AdSourceModel> mWFAdSourceList;
    private int mWFMaxRequestNum;
    private int mWeightRandomNum;
    private List<AdSourceModel> mWFSortAdSourceList = new ArrayList();
    private boolean isFirstDispatch = true;
    private boolean isDispatchWFSort = false;

    public AMPSDispatcher(SpaceModel spaceModel) {
        this.mC2SMaxRequestNum = 0;
        this.mWFMaxRequestNum = 0;
        this.mAdRequestType = 0;
        this.mWeightRandomNum = 0;
        this.mS2SAdSourceList = null;
        this.mC2SAdSourceList = null;
        this.mWFAdSourceList = null;
        if (spaceModel == null) {
            return;
        }
        this.mC2SMaxRequestNum = spaceModel.getBidParallelNum();
        this.mWFMaxRequestNum = spaceModel.getWaterfallParallelNum();
        this.mAdRequestType = spaceModel.getBidDistributionMethod();
        this.mWeightRandomNum = spaceModel.getWeightRandomNum();
        List<AdSourceModel> s2sAdSourceList = spaceModel.getS2sAdSourceList();
        List<AdSourceModel> c2sAdSourceList = spaceModel.getC2sAdSourceList();
        List<AdSourceModel> wfAdSourceList = spaceModel.getWfAdSourceList();
        if (s2sAdSourceList != null && s2sAdSourceList.size() > 0) {
            this.mS2SAdSourceList = s2sAdSourceList;
        }
        if (c2sAdSourceList != null && c2sAdSourceList.size() > 0) {
            this.mC2SAdSourceList = c2sAdSourceList;
        }
        if (wfAdSourceList == null || wfAdSourceList.size() <= 0) {
            return;
        }
        this.mWFAdSourceList = wfAdSourceList;
        sortAdSourceListByEcpm(wfAdSourceList);
        if (this.mAdRequestType == 1) {
            this.mWFSortAdSourceList.addAll(this.mWFAdSourceList);
        }
    }

    private AdSourceModel getOneWaitDispatchC2SAdSource() {
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (AdSourceModel adSourceModel : this.mC2SAdSourceList) {
            if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                adSourceModel.setAdStatus(1);
                return adSourceModel;
            }
        }
        return null;
    }

    private AdSourceModel getOneWaitDispatchWFAdSource() {
        List<AdSourceModel> list = this.mWFAdSourceList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (AdSourceModel adSourceModel : this.mWFAdSourceList) {
            if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                adSourceModel.setAdStatus(1);
                return adSourceModel;
            }
        }
        return null;
    }

    private AdSourceModel getOneWaitDispatchWFSortAdSource() {
        List<AdSourceModel> list = this.mWFSortAdSourceList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (AdSourceModel adSourceModel : this.mWFSortAdSourceList) {
            if (adSourceModel != null && (adSourceModel.getAdStatus() == 0 || adSourceModel.getAdStatus() == 3)) {
                adSourceModel.setAdStatus(4);
                return adSourceModel;
            }
        }
        return null;
    }

    private List<AdSourceModel> getWaitDispatchC2SAdSourceList() {
        ArrayList arrayList = new ArrayList();
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mC2SAdSourceList) {
                if (adSourceModel != null) {
                    if (arrayList.size() >= this.mC2SMaxRequestNum) {
                        break;
                    } else if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                        adSourceModel.setAdStatus(1);
                        arrayList.add(adSourceModel);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<AdSourceModel> getWaitDispatchWFAdSourceList() {
        ArrayList arrayList = new ArrayList();
        List<AdSourceModel> list = this.mWFAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mWFAdSourceList) {
                if (adSourceModel != null) {
                    if (arrayList.size() >= this.mWFMaxRequestNum) {
                        break;
                    } else if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                        adSourceModel.setAdStatus(1);
                        arrayList.add(adSourceModel);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<AdSourceModel> getWaitDispatchWFSortAdSourceList() {
        ArrayList arrayList = new ArrayList();
        List<AdSourceModel> list = this.mWFSortAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mWFSortAdSourceList) {
                if (adSourceModel != null) {
                    if (arrayList.size() >= this.mWFMaxRequestNum) {
                        break;
                    } else if (adSourceModel.getAdStatus() == 0 || adSourceModel.getAdStatus() == 3) {
                        adSourceModel.setAdStatus(4);
                        arrayList.add(adSourceModel);
                    }
                }
            }
        }
        return arrayList;
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

    private boolean isExistHasSuccessResultWF() {
        List<AdSourceModel> list = this.mWFAdSourceList;
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (AdSourceModel adSourceModel : this.mWFAdSourceList) {
            if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean isHigherThanHasSuccessResultC2SOrS2S(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return false;
        }
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel2 : this.mC2SAdSourceList) {
                if (adSourceModel2 != null && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel2.getBiddingType()) && adSourceModel2.getAdStatus() == 5 && adSourceModel2.getEcpm() >= adSourceModel.getEcpm()) {
                    return false;
                }
            }
        }
        List<AdSourceModel> list2 = this.mS2SAdSourceList;
        if (list2 == null || list2.size() <= 0) {
            return true;
        }
        for (AdSourceModel adSourceModel3 : this.mS2SAdSourceList) {
            if (adSourceModel3 != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(adSourceModel3.getBiddingType()) && adSourceModel3.getAdStatus() == 5 && adSourceModel3.getEcpm() > adSourceModel.getEcpm()) {
                return false;
            }
        }
        return true;
    }

    private boolean judgeIsHasLoadingSuccessAdResource() {
        List<AdSourceModel> list = this.mWFSortAdSourceList;
        if (list != null && list.size() != 0) {
            for (AdSourceModel adSourceModel : this.mWFSortAdSourceList) {
                if (adSourceModel != null && adSourceModel.getAdStatus() == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private void sortAdSourceListByEcpm(List<AdSourceModel> list) {
        Collections.sort(list, new Comparator<AdSourceModel>() { // from class: xyz.adscope.amps.control.dispatch.AMPSDispatcher.1
            @Override // java.util.Comparator
            public int compare(AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
                try {
                    int ecpm = adSourceModel.getEcpm() - adSourceModel2.getEcpm();
                    if (ecpm > 0) {
                        return -1;
                    }
                    if (ecpm < 0) {
                        return 1;
                    }
                    if (AMPSRandomUtil.isHitRandomNum(adSourceModel.getStartWeight(), adSourceModel.getEndWeight(), AMPSDispatcher.this.mWeightRandomNum) && AMPSRandomUtil.isHitRandomNum(adSourceModel2.getStartWeight(), adSourceModel2.getEndWeight(), AMPSDispatcher.this.mWeightRandomNum)) {
                        return 0;
                    }
                    return AMPSRandomUtil.isHitRandomNum(adSourceModel.getStartWeight(), adSourceModel.getEndWeight(), AMPSDispatcher.this.mWeightRandomNum) ? -1 : 1;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return -1;
                }
            }
        });
        for (AdSourceModel adSourceModel : list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, " sortAdSourceListByEcpm mWeightRandomNum:" + this.mWeightRandomNum + ";getStartWeight:" + adSourceModel.getStartWeight() + ";getEndWeight:" + adSourceModel.getEndWeight() + ";getSeatId:" + adSourceModel.getSeatId());
        }
    }

    @Override // xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface
    public List<AdSourceModel> biddingTimeOut() {
        if (!this.isDispatchWFSort && this.mAdRequestType == 1) {
            updateAdSourceAdStatus(this.mS2SAdSourceList, 6);
            updateAdSourceAdStatus(this.mC2SAdSourceList, 6);
            this.isDispatchWFSort = true;
            List<AdSourceModel> waitDispatchWFSortAdSourceList = getWaitDispatchWFSortAdSourceList();
            if (waitDispatchWFSortAdSourceList != null && waitDispatchWFSortAdSourceList.size() > 0) {
                return waitDispatchWFSortAdSourceList;
            }
        }
        return null;
    }

    @Override // xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface
    public List<AdSourceModel> dispatch(AdSourceModel adSourceModel) {
        if (this.isFirstDispatch || adSourceModel != null) {
            this.isFirstDispatch = false;
            if (adSourceModel == null) {
                ArrayList arrayList = new ArrayList();
                AMPSListUtil.addDataToList((List) arrayList, (List) getWaitDispatchC2SAdSourceList());
                int i4 = this.mAdRequestType;
                if (i4 == 0 || (i4 == 1 && !isExistC2SOrS2SAdSource())) {
                    AMPSListUtil.addDataToList((List) arrayList, (List) getWaitDispatchWFAdSourceList());
                }
                return arrayList;
            }
            int i5 = this.mAdRequestType;
            if (i5 == 0) {
                if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    ArrayList arrayList2 = new ArrayList();
                    AMPSListUtil.addDataToList(arrayList2, getOneWaitDispatchC2SAdSource());
                    return arrayList2;
                }
                if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 6 && !isExistHasSuccessResultWF()) {
                    AdSourceModel oneWaitDispatchWFAdSource = getOneWaitDispatchWFAdSource();
                    if (isHigherThanHasSuccessResultC2SOrS2S(oneWaitDispatchWFAdSource)) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(oneWaitDispatchWFAdSource);
                        return arrayList3;
                    }
                }
                return null;
            } else if (i5 == 1) {
                if (adSourceModel.getAdStatus() == 3) {
                    this.mWFSortAdSourceList.add(adSourceModel);
                    sortAdSourceListByEcpm(this.mWFSortAdSourceList);
                }
                if (adSourceModel.getAdStatus() == 5) {
                    return null;
                }
                if (!isBidFinish()) {
                    if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                        ArrayList arrayList4 = new ArrayList();
                        AMPSListUtil.addDataToList(arrayList4, getOneWaitDispatchC2SAdSource());
                        return arrayList4;
                    }
                    return null;
                } else if (this.isDispatchWFSort) {
                    if (judgeIsHasLoadingSuccessAdResource()) {
                        return null;
                    }
                    ArrayList arrayList5 = new ArrayList();
                    AMPSListUtil.addDataToList(arrayList5, getOneWaitDispatchWFSortAdSource());
                    return arrayList5;
                } else {
                    this.isDispatchWFSort = true;
                    return getWaitDispatchWFSortAdSourceList();
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface
    public void updateAdSourceAdStatus(List<AdSourceModel> list, int i4) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (AdSourceModel adSourceModel : list) {
            if (adSourceModel != null) {
                if (i4 != 6) {
                    adSourceModel.setAdStatus(i4);
                } else if (adSourceModel.getAdStatus() != 3 && adSourceModel.getAdStatus() != 5) {
                    adSourceModel.setAdStatus(i4);
                }
            }
        }
    }
}
