package xyz.adscope.amps.control.preload;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.preload.AMPSPreloadManagerInfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSPreLoad {
    private static AMPSPreLoad instance;
    private static Map<String, AMPSPreloadManagerInfo> mPreloadAdData = new HashMap();

    public static synchronized AMPSPreLoad getInstance() {
        AMPSPreLoad aMPSPreLoad;
        synchronized (AMPSPreLoad.class) {
            if (instance == null) {
                synchronized (AMPSPreLoad.class) {
                    instance = new AMPSPreLoad();
                }
            }
            aMPSPreLoad = instance;
        }
        return aMPSPreLoad;
    }

    public void addPreLoadAdInfo(String str, AMPSBaseOpenApiManager aMPSBaseOpenApiManager) {
        if (TextUtils.isEmpty(str) || aMPSBaseOpenApiManager == null) {
            return;
        }
        if (mPreloadAdData.containsKey(str)) {
            mPreloadAdData.remove(str);
        }
        AMPSPreloadManagerInfo aMPSPreloadManagerInfo = new AMPSPreloadManagerInfo();
        aMPSPreloadManagerInfo.setSpaceId(str);
        aMPSPreloadManagerInfo.setBaseOpenApiManager(aMPSBaseOpenApiManager);
        aMPSPreloadManagerInfo.setCachedTime(System.currentTimeMillis());
        AdSourceModel winAdSourceModel = aMPSBaseOpenApiManager.getWinAdSourceModel();
        long cachedOffersTimeout = winAdSourceModel != null ? winAdSourceModel.getCachedOffersTimeout() : 0L;
        if (cachedOffersTimeout == 0) {
            cachedOffersTimeout = aMPSBaseOpenApiManager.getSpaceCachedOffersTimeout();
        }
        if (cachedOffersTimeout == 0) {
            return;
        }
        aMPSPreloadManagerInfo.setCachedOffersTimeout(cachedOffersTimeout);
        mPreloadAdData.put(str, aMPSPreloadManagerInfo);
    }

    public AMPSPreloadManagerInfo getAMPSPreloadManagerInfo(String str) {
        AMPSPreloadManagerInfo aMPSPreloadManagerInfo;
        if (TextUtils.isEmpty(str) || !mPreloadAdData.containsKey(str) || (aMPSPreloadManagerInfo = mPreloadAdData.get(str)) == null) {
            return null;
        }
        if (System.currentTimeMillis() - aMPSPreloadManagerInfo.getCachedTime() > aMPSPreloadManagerInfo.getCachedOffersTimeout()) {
            removePreLoadAdInfo(str);
            return null;
        }
        AMPSBaseOpenApiManager baseOpenApiManager = aMPSPreloadManagerInfo.getBaseOpenApiManager();
        if (baseOpenApiManager == null) {
            removePreLoadAdInfo(str);
            return null;
        }
        AMPSBaseAdapter winAdSourceAdapter = baseOpenApiManager.getWinAdSourceAdapter();
        if (winAdSourceAdapter == null) {
            removePreLoadAdInfo(str);
            return null;
        } else if (!winAdSourceAdapter.isValid()) {
            removePreLoadAdInfo(str);
            return null;
        } else {
            removePreLoadAdInfo(str);
            return aMPSPreloadManagerInfo;
        }
    }

    public void removePreLoadAdInfo(String str) {
        if (!TextUtils.isEmpty(str) && mPreloadAdData.containsKey(str)) {
            mPreloadAdData.remove(str);
        }
    }
}
