package xyz.adscope.amps.control.filter;

import android.text.TextUtils;
import java.util.List;
import xyz.adscope.amps.control.filter.inter.IFilterInterface;
import xyz.adscope.amps.manager.AMPSFrequencyManager;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.FilterModel;
import xyz.adscope.amps.model.config.response.FrequencyModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.model.frequency.AMPSFrequencyEventModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSFilter implements IFilterInterface {
    private long mAdRequestTimeout;
    private long mAdSourceRequestTimeout;
    private FilterModel mFilterModel;
    private String mSpaceId;

    public AMPSFilter(SpaceModel spaceModel) {
        this.mFilterModel = null;
        this.mSpaceId = null;
        this.mAdRequestTimeout = 5000L;
        this.mAdSourceRequestTimeout = 5000L;
        if (spaceModel == null) {
            return;
        }
        try {
            this.mSpaceId = spaceModel.getSpaceId();
            this.mFilterModel = spaceModel.getFilter();
            this.mAdRequestTimeout = spaceModel.getAdTimeout();
            this.mAdSourceRequestTimeout = spaceModel.getAdsTimeout();
            AMPSFrequencyManager.getInstance().initFrequencyData(this.mSpaceId);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.control.filter.inter.IFilterInterface
    public void addFilterEvent(AMPSFrequencyEventModel aMPSFrequencyEventModel) {
        try {
            aMPSFrequencyEventModel.setMediationSpaceId(this.mSpaceId);
            aMPSFrequencyEventModel.setEventTime(String.valueOf(System.currentTimeMillis()));
            AMPSFrequencyManager.getInstance().putFrequencyData(aMPSFrequencyEventModel);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.control.filter.inter.IFilterInterface
    public boolean channelFilter(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return false;
        }
        try {
            String spaceId = adSourceModel.getSpaceId();
            FilterModel filter = adSourceModel.getFilter();
            if (TextUtils.isEmpty(spaceId)) {
                return false;
            }
            if (filter == null) {
                return true;
            }
            long minLoadTime = filter.getMinLoadTime();
            long adsTimeout = adSourceModel.getAdsTimeout();
            if (adsTimeout == 0) {
                adsTimeout = this.mAdSourceRequestTimeout;
            }
            if (adsTimeout < minLoadTime) {
                return false;
            }
            List<FrequencyModel> frequency = filter.getFrequency();
            if (frequency != null && frequency.size() != 0) {
                for (FrequencyModel frequencyModel : frequency) {
                    if (frequencyModel.getCount() != 0 && !AMPSFrequencyManager.getInstance().isPassAdSourceFrequencyLimit(spaceId, frequencyModel)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    @Override // xyz.adscope.amps.control.filter.inter.IFilterInterface
    public boolean platformFilter() {
        try {
            if (TextUtils.isEmpty(this.mSpaceId)) {
                return false;
            }
            FilterModel filterModel = this.mFilterModel;
            if (filterModel == null) {
                return true;
            }
            if (this.mAdRequestTimeout < filterModel.getMinLoadTime()) {
                return false;
            }
            List<FrequencyModel> frequency = this.mFilterModel.getFrequency();
            if (frequency != null && frequency.size() != 0) {
                for (FrequencyModel frequencyModel : frequency) {
                    if (frequencyModel.getCount() != 0 && !AMPSFrequencyManager.getInstance().isPassMediationFrequencyLimit(this.mSpaceId, frequencyModel)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }
}
