package xyz.adscope.ad.control.cache.ad;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.inter.IAdvertising;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.control.cache.ad.inter.IAdCache;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.config.AdCacheConfigModel;
import xyz.adscope.ad.tool.persistent.db.ASNPDataBaseManager;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.ad.tool.task.TimerOutTask;
import xyz.adscope.ad.tool.task.inter.ITimerTaskCallback;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCacheManager implements IAdCache {
    private static final String AD_CACHE_TABLE_NAME = "ad_cache_table";
    private static final long AD_EXPIRE_TIME = 1800000;
    private static final String KEY_CACHE_DATA = "cacheData";
    private static final String KEY_CACHE_KEY = "cacheKey";
    private static final String KEY_CACHE_TIME = "cacheTime";
    private static final String KEY_EXPIRE_TIME = "expireTime";
    public static final int MESSAGE_SUCCESS_REQUEST_WHAT = 10030;
    private static final String TAG = "AdCacheManager";
    private static AdCacheManager mInstance;
    private ASNPDataBaseManager adCacheDBManager;

    public AdCacheManager() {
        ASNPDataBaseManager aSNPDataBaseManager = new ASNPDataBaseManager(AdScopeSDK.getContext());
        this.adCacheDBManager = aSNPDataBaseManager;
        aSNPDataBaseManager.setTableNameAndModel(AD_CACHE_TABLE_NAME, AdCacheModel.class);
    }

    private String getCacheKey(AdScopeCycleModel adScopeCycleModel) {
        if (adScopeCycleModel != null) {
            String appId = InitImplement.getInstance().getGlobalAdInitConfig(adScopeCycleModel.getApiKey()).getAppId();
            return adScopeCycleModel.getApiKey() + "_" + appId + "_" + adScopeCycleModel.getSpaceId();
        }
        return "";
    }

    private long getExpireTime(String str) {
        long expireTime = AdResponseManager.getExpireTime(AdResponseManager.parseAdResponse(str));
        return expireTime == 0 ? System.currentTimeMillis() + AD_EXPIRE_TIME : expireTime;
    }

    public static AdCacheManager getInstance() {
        if (mInstance == null) {
            synchronized (AdCacheManager.class) {
                if (mInstance == null) {
                    mInstance = new AdCacheManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildAdCacheTimerTask$0(AdScopeCycleModel adScopeCycleModel, Handler handler, String str) {
        LogUtil.i(TAG, "cacheLog_ adScopeCycleModel.isServerResponse() : " + adScopeCycleModel.isServerResponse());
        if (adScopeCycleModel.isServerResponse()) {
            return;
        }
        LogUtil.i(TAG, "cache_ad_user \u4f7f\u7528\u7f13\u5b58\u5e7f\u544a");
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = MESSAGE_SUCCESS_REQUEST_WHAT;
            obtain.obj = str;
            handler.sendMessage(obtain);
        }
        adScopeCycleModel.setServerResponse(true);
        getInstance().deleteCacheAd(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cacheAdData$1(AdScopeCycleModel adScopeCycleModel, String str) {
        if (adScopeCycleModel == null || !adScopeCycleModel.isOpenCache()) {
            return;
        }
        AdCacheModel adCacheModel = new AdCacheModel();
        long currentTimeMillis = System.currentTimeMillis();
        long expireTime = getExpireTime(str);
        adCacheModel.setCacheKey(getCacheKey(adScopeCycleModel));
        adCacheModel.setCacheData(str);
        adCacheModel.setCacheTime(currentTimeMillis);
        adCacheModel.setExpireTime(expireTime);
        getInstance().addCacheAd(adCacheModel);
    }

    @Override // xyz.adscope.ad.control.cache.ad.inter.IAdCache
    public void addCacheAd(AdCacheModel adCacheModel) {
        ASNPDataBaseManager aSNPDataBaseManager = this.adCacheDBManager;
        if (aSNPDataBaseManager != null) {
            aSNPDataBaseManager.insert(adCacheModel);
        }
    }

    public void buildAdCacheTimerTask(TimerOutTask timerOutTask, final Handler handler, final AdScopeCycleModel adScopeCycleModel, final String str) {
        if (adScopeCycleModel == null || !adScopeCycleModel.isOpenCache()) {
            return;
        }
        timerOutTask.buildAdCacheTimerTask(adScopeCycleModel.getLimitAdTime(), new ITimerTaskCallback() { // from class: xyz.adscope.ad.control.cache.ad.b
            @Override // xyz.adscope.ad.tool.task.inter.ITimerTaskCallback
            public final void scheduleTimeEndCall() {
                AdCacheManager.lambda$buildAdCacheTimerTask$0(AdScopeCycleModel.this, handler, str);
            }
        });
    }

    public void cacheAdData(final AdScopeCycleModel adScopeCycleModel, final String str) {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.ad.control.cache.ad.a
            @Override // java.lang.Runnable
            public final void run() {
                AdCacheManager.this.lambda$cacheAdData$1(adScopeCycleModel, str);
            }
        });
    }

    @Override // xyz.adscope.ad.control.cache.ad.inter.IAdCache
    public void deleteCacheAd(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_CACHE_DATA, str);
        ASNPDataBaseManager aSNPDataBaseManager = this.adCacheDBManager;
        if (aSNPDataBaseManager != null) {
            int delete = aSNPDataBaseManager.delete(hashMap);
            LogUtil.i(TAG, "cacheLog_ deleteCacheAd result : " + delete);
        }
    }

    @Override // xyz.adscope.ad.control.cache.ad.inter.IAdCache
    public void deleteOutTimeCacheAd() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_EXPIRE_TIME, Long.valueOf(currentTimeMillis));
        ASNPDataBaseManager aSNPDataBaseManager = this.adCacheDBManager;
        if (aSNPDataBaseManager != null) {
            int deleteOutTime = aSNPDataBaseManager.deleteOutTime(hashMap);
            LogUtil.i(TAG, "deleteOutTimeCacheAd result : " + deleteOutTime);
        }
    }

    @Override // xyz.adscope.ad.control.cache.ad.inter.IAdCache
    public String readCacheAd(String str) {
        deleteOutTimeCacheAd();
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_CACHE_KEY, str);
        String[] strArr = {KEY_CACHE_DATA};
        ASNPDataBaseManager aSNPDataBaseManager = this.adCacheDBManager;
        if (aSNPDataBaseManager != null) {
            return aSNPDataBaseManager.query(hashMap, strArr, "cacheTime DESC", "1");
        }
        return null;
    }

    public String readCacheAdStr(AdScopeCycleModel adScopeCycleModel) {
        return readCacheAd(getCacheKey(adScopeCycleModel));
    }

    public void requestForCache(final AdScopeCycleModel adScopeCycleModel, IAdvertising iAdvertising) {
        if (adScopeCycleModel == null || !adScopeCycleModel.isOpenCache()) {
            return;
        }
        iAdvertising.httpRequestAds(new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.control.cache.ad.AdCacheManager.1
            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str, int i4) {
            }

            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void successCallback(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("code") == 200) {
                        LogUtil.i(AdCacheManager.TAG, "cache_ad_user \u8bf7\u6c42\u4e86\u7f13\u5b58\u5e7f\u544a");
                        LogUtil.i(AdCacheManager.TAG, "cacheLog_ requestForCache : successCallback ");
                        AdCacheManager.getInstance().cacheAdData(adScopeCycleModel, jSONObject.optString("data"));
                    }
                } catch (Exception e4) {
                    LogUtil.i(AdCacheManager.TAG, "e : " + e4);
                }
            }
        });
    }

    public void updateAdCacheConfig(AdScopeCycleModel adScopeCycleModel) {
        AdScopeGlobalModel apiModelWithApiKey = InitImplement.getInstance().getApiModelWithApiKey(adScopeCycleModel != null ? adScopeCycleModel.getApiKey() : "");
        if (apiModelWithApiKey == null || apiModelWithApiKey.getConfigureModel() == null || apiModelWithApiKey.getConfigureModel().getAdCache() == null || apiModelWithApiKey.getConfigureModel().getAdCache().size() <= 0) {
            return;
        }
        for (AdCacheConfigModel adCacheConfigModel : apiModelWithApiKey.getConfigureModel().getAdCache()) {
            if (!TextUtils.isEmpty(adScopeCycleModel.getSpaceType()) && adScopeCycleModel.getSpaceType().equals(adCacheConfigModel.getAdType())) {
                adScopeCycleModel.setOpenCache(1 == adCacheConfigModel.getEnable());
                adScopeCycleModel.setLimitAdTime(adCacheConfigModel.getReqAdTimeLimit());
            }
        }
    }
}
