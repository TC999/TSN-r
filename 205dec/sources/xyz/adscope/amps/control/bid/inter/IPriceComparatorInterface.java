package xyz.adscope.amps.control.bid.inter;

import xyz.adscope.amps.model.config.response.AdSourceModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IPriceComparatorInterface {
    void comparePriceTimeout();

    int getComparePriceResult(AdSourceModel adSourceModel);

    AdSourceModel getWinAdSourceModel();
}
