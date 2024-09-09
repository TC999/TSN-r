package xyz.adscope.amps.manager;

import android.content.Context;
import android.os.Handler;
import java.util.List;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.config.AMPSConfigManager;
import xyz.adscope.amps.config.inter.IConfigInterface;
import xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface;
import xyz.adscope.amps.control.cache.inter.ICacheControllerInterface;
import xyz.adscope.amps.control.dispatch.AMPSDispatcher;
import xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface;
import xyz.adscope.amps.control.filter.inter.IFilterInterface;
import xyz.adscope.amps.control.preload.inter.IPreLoadInterface;
import xyz.adscope.amps.manager.inter.IAdControllerDispatcherCallBack;
import xyz.adscope.amps.manager.inter.IAdLoadControllerInterface;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSAdLoadController implements IAdLoadControllerInterface {
    private IAdControllerDispatcherCallBack iAdControllerDispatcherCallBack;
    private IPriceComparatorInterface iBidInterface;
    private ICacheControllerInterface iCacheControllerInterface;
    private IDispatcherInterface iDispatcherInterface;
    private IFilterInterface iFilterInterface;
    private IPreLoadInterface iPreLoadInterface;
    private Context mContext;
    private SpaceModel mSpaceModel;
    private final String TAG = getClass().getSimpleName();
    private boolean isHasLoadingSuccess = false;
    private TimerTask mFloorDispatcherTimerTask = null;
    private TimerTask mBiddingTimerTask = null;
    private IConfigInterface iConfigInterface = new AMPSConfigManager();

    public AMPSAdLoadController(Context context, SpaceModel spaceModel, IAdControllerDispatcherCallBack iAdControllerDispatcherCallBack) {
        this.mContext = context;
        this.iAdControllerDispatcherCallBack = iAdControllerDispatcherCallBack;
        this.mSpaceModel = spaceModel;
        this.iDispatcherInterface = new AMPSDispatcher(spaceModel);
    }

    private void handleBiddingTimeOut() {
        try {
            SpaceModel spaceModel = this.mSpaceModel;
            if (spaceModel == null || spaceModel.getBidDistributionMethod() != 1) {
                return;
            }
            if ((this.mSpaceModel.getS2sAdSourceList() == null || this.mSpaceModel.getS2sAdSourceList().size() <= 0) && (this.mSpaceModel.getC2sAdSourceList() == null || this.mSpaceModel.getC2sAdSourceList().size() <= 0)) {
                return;
            }
            new Handler().postDelayed(new Runnable() { // from class: xyz.adscope.amps.manager.AMPSAdLoadController.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, AMPSAdLoadController.this.TAG + " \u8be2\u4ef7\u8d85\u65f6:");
                        List<AdSourceModel> biddingTimeOut = AMPSAdLoadController.this.iDispatcherInterface != null ? AMPSAdLoadController.this.iDispatcherInterface.biddingTimeOut() : null;
                        if (AMPSAdLoadController.this.iAdControllerDispatcherCallBack == null || biddingTimeOut == null || biddingTimeOut.size() <= 0) {
                            return;
                        }
                        AMPSAdLoadController.this.iAdControllerDispatcherCallBack.dispatchResult(biddingTimeOut);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }, this.mSpaceModel.getBidAdTimeout());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void bidPrice() {
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void cacheAdSource() {
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void configManager() {
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void dispatcher(AdSourceModel adSourceModel) {
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void filter() {
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public SpaceModel getSpaceModel() {
        return this.mSpaceModel;
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void loadAd() {
        SpaceModel spaceModel;
        preLoad();
        configManager();
        handleBiddingTimeOut();
        dispatcher(null);
        if (this.iAdControllerDispatcherCallBack != null && (spaceModel = this.mSpaceModel) != null && spaceModel.getS2sAdSourceList() != null && this.mSpaceModel.getS2sAdSourceList().size() > 0) {
            this.iDispatcherInterface.updateAdSourceAdStatus(this.mSpaceModel.getS2sAdSourceList(), 1);
            this.iAdControllerDispatcherCallBack.dispatchResult(this.mSpaceModel.getS2sAdSourceList());
        }
        SpaceModel spaceModel2 = this.mSpaceModel;
        if (spaceModel2 == null || spaceModel2.getFloorAdSourceList() == null || this.mSpaceModel.getFloorAdSourceList().size() <= 0) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: xyz.adscope.amps.manager.AMPSAdLoadController.1
            @Override // java.lang.Runnable
            public void run() {
                if (AMPSAdLoadController.this.isHasLoadingSuccess || AMPSAdLoadController.this.iAdControllerDispatcherCallBack == null) {
                    return;
                }
                AMPSAdLoadController.this.iAdControllerDispatcherCallBack.dispatchResult(AMPSAdLoadController.this.mSpaceModel.getFloorAdSourceList());
            }
        }, this.mSpaceModel.getFloorDelayTime());
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void preLoad() {
    }

    @Override // xyz.adscope.amps.manager.inter.IAdLoadControllerInterface
    public void setHasLoadingSuccessAdResource() {
        this.isHasLoadingSuccess = true;
    }
}
