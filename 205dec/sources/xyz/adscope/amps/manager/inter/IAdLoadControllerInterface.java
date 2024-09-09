package xyz.adscope.amps.manager.inter;

import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdLoadControllerInterface {
    void bidPrice();

    void cacheAdSource();

    void configManager();

    void dispatcher(AdSourceModel adSourceModel);

    void filter();

    SpaceModel getSpaceModel();

    void loadAd();

    void preLoad();

    void setHasLoadingSuccessAdResource();
}
