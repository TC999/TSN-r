package xyz.adscope.amps.control.dispatch.inter;

import java.util.List;
import xyz.adscope.amps.model.config.response.AdSourceModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IDispatcherInterface {
    List<AdSourceModel> biddingTimeOut();

    List<AdSourceModel> dispatch(AdSourceModel adSourceModel);

    void updateAdSourceAdStatus(List<AdSourceModel> list, int i4);
}
