package xyz.adscope.amps.control.cache;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.model.cache.AMPSAdSourceCacheInfo;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSCacheController {
    private static AMPSCacheController instance;
    private static Map<String, List<AMPSAdSourceCacheInfo>> mAdSourceCacheData = new HashMap();
    private final String TAG = getClass().getSimpleName();

    private void addCacheInfo(String str, String str2, String str3, int i4, AMPSBaseAdapter aMPSBaseAdapter, long j4, List<AMPSAdSourceCacheInfo> list) {
        AMPSAdSourceCacheInfo aMPSAdSourceCacheInfo = new AMPSAdSourceCacheInfo();
        aMPSAdSourceCacheInfo.setAppId(str2);
        aMPSAdSourceCacheInfo.setSpaceId(str3);
        aMPSAdSourceCacheInfo.setEcpm(i4);
        aMPSAdSourceCacheInfo.setBaseAdapter(aMPSBaseAdapter);
        aMPSAdSourceCacheInfo.setCachedTime(System.currentTimeMillis());
        aMPSAdSourceCacheInfo.setCachedOffersTimeout(j4);
        list.add(aMPSAdSourceCacheInfo);
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " addCacheInfo cacheInfo:" + aMPSAdSourceCacheInfo);
        Collections.sort(list, new Comparator<AMPSAdSourceCacheInfo>() { // from class: xyz.adscope.amps.control.cache.AMPSCacheController.1
            @Override // java.util.Comparator
            public int compare(AMPSAdSourceCacheInfo aMPSAdSourceCacheInfo2, AMPSAdSourceCacheInfo aMPSAdSourceCacheInfo3) {
                return aMPSAdSourceCacheInfo2.getEcpm() - aMPSAdSourceCacheInfo3.getEcpm();
            }
        });
        mAdSourceCacheData.put(str, list);
        Iterator<AMPSAdSourceCacheInfo> it = list.iterator();
        while (it.hasNext()) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " addCacheInfo after cacheInfo:" + it.next());
        }
    }

    public static synchronized AMPSCacheController getInstance() {
        AMPSCacheController aMPSCacheController;
        synchronized (AMPSCacheController.class) {
            if (instance == null) {
                synchronized (AMPSCacheController.class) {
                    instance = new AMPSCacheController();
                }
            }
            aMPSCacheController = instance;
        }
        return aMPSCacheController;
    }

    public void addAdSourceCacheInfo(SpaceModel spaceModel, AdSourceModel adSourceModel, AMPSBaseAdapter aMPSBaseAdapter) {
        List<AMPSAdSourceCacheInfo> list;
        if (spaceModel == null || adSourceModel == null || aMPSBaseAdapter == null) {
            return;
        }
        String spaceId = spaceModel.getSpaceId();
        int cachedOffersNum = spaceModel.getCachedOffersNum();
        int cachedOffersTimeout = spaceModel.getCachedOffersTimeout();
        if (TextUtils.isEmpty(spaceId) || cachedOffersNum == 0) {
            return;
        }
        String appId = adSourceModel.getAppId();
        String spaceId2 = adSourceModel.getSpaceId();
        int cachedOffersTimeout2 = adSourceModel.getCachedOffersTimeout();
        int ecpm = adSourceModel.getEcpm();
        if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(spaceId2)) {
            return;
        }
        if (cachedOffersTimeout2 != 0) {
            cachedOffersTimeout = cachedOffersTimeout2;
        }
        if (cachedOffersTimeout == 0) {
            return;
        }
        List<AMPSAdSourceCacheInfo> arrayList = new ArrayList<>();
        if (mAdSourceCacheData.containsKey(spaceId) && (list = mAdSourceCacheData.get(spaceId)) != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (arrayList.size() < cachedOffersNum) {
            addCacheInfo(spaceId, appId, spaceId2, ecpm, aMPSBaseAdapter, cachedOffersTimeout, arrayList);
            return;
        }
        Iterator<AMPSAdSourceCacheInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            AMPSAdSourceCacheInfo next = it.next();
            int ecpm2 = next.getEcpm();
            if (System.currentTimeMillis() - next.getCachedTime() <= next.getCachedOffersTimeout()) {
                if (ecpm2 < ecpm) {
                }
            }
            it.remove();
            addCacheInfo(spaceId, appId, spaceId2, ecpm, aMPSBaseAdapter, cachedOffersTimeout, arrayList);
            return;
        }
    }

    public AMPSAdSourceCacheInfo getAdSourceCacheInfo(String str, String str2) {
        List<AMPSAdSourceCacheInfo> list;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && mAdSourceCacheData.containsKey(str) && (list = mAdSourceCacheData.get(str)) != null && list.size() != 0) {
            Iterator<AMPSAdSourceCacheInfo> it = list.iterator();
            while (it.hasNext()) {
                AMPSAdSourceCacheInfo next = it.next();
                String spaceId = next.getSpaceId();
                if (!TextUtils.isEmpty(spaceId) && spaceId.equalsIgnoreCase(str2)) {
                    if (System.currentTimeMillis() - next.getCachedTime() > next.getCachedOffersTimeout()) {
                        it.remove();
                        return null;
                    }
                    return next;
                }
            }
        }
        return null;
    }

    public void removeAdSourceCacheInfo(String str, String str2) {
        List<AMPSAdSourceCacheInfo> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !mAdSourceCacheData.containsKey(str) || (list = mAdSourceCacheData.get(str)) == null || list.size() == 0) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " removeAdSourceCacheInfo  adSourceSpaceId:" + str2);
        Iterator<AMPSAdSourceCacheInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String spaceId = it.next().getSpaceId();
            if (!TextUtils.isEmpty(spaceId) && spaceId.equalsIgnoreCase(str2)) {
                it.remove();
                break;
            }
        }
        mAdSourceCacheData.put(str, list);
        Iterator<AMPSAdSourceCacheInfo> it2 = list.iterator();
        while (it2.hasNext()) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " removeAdSourceCacheInfo after cacheInfo:" + it2.next());
        }
    }
}
