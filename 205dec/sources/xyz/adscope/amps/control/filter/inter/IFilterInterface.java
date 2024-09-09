package xyz.adscope.amps.control.filter.inter;

import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.frequency.AMPSFrequencyEventModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IFilterInterface {
    void addFilterEvent(AMPSFrequencyEventModel aMPSFrequencyEventModel);

    boolean channelFilter(AdSourceModel adSourceModel);

    boolean platformFilter();
}
