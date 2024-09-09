package xyz.adscope.ad.control.strategy;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.control.strategy.model.AdScopeHistoryEventModel;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.tool.persistent.db.ASNPDataBaseManager;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StrategyEventCacheManager {
    public static StrategyEventCacheManager mInstance;
    private List<AdScopeHistoryEventModel> adScopeHistoryEventModels;
    private String KEY_TABLE_NAME = "asnp_strategy_event_table";
    private String KEY_EVENT_TIME = AMPSReportConstants.EVENT_TIME_KEY;
    private int numEventToQuery = 1000;
    private int needDeleteOutCount = 1000;
    private Map<String, Map<String, List<AdScopeHistoryEventModel>>> eventsDict = new HashMap();
    private ASNPDataBaseManager asnpDataBaseManager = new ASNPDataBaseManager(AdScopeSDK.getContext());

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deleteOutCountTable */
    public void lambda$asyncDeleteData$2(AdScopeCycleModel adScopeCycleModel) {
        if (adScopeCycleModel == null) {
            return;
        }
        setTableName(adScopeCycleModel);
        List query = this.asnpDataBaseManager.query(null);
        if (query == null || query.size() <= this.needDeleteOutCount) {
            return;
        }
        this.asnpDataBaseManager.deleteFixedCountData(query.size() / 2);
    }

    public static StrategyEventCacheManager getInstance() {
        if (mInstance == null) {
            synchronized (StrategyEventCacheManager.class) {
                if (mInstance == null) {
                    mInstance = new StrategyEventCacheManager();
                }
            }
        }
        return mInstance;
    }

    private void setTableName(AdScopeCycleModel adScopeCycleModel) {
        String apiKey = adScopeCycleModel.getApiKey();
        String spaceId = adScopeCycleModel.getSpaceId();
        ASNPDataBaseManager aSNPDataBaseManager = this.asnpDataBaseManager;
        aSNPDataBaseManager.setTableNameAndModel(this.KEY_TABLE_NAME + "_" + apiKey + "_" + spaceId, AdScopeHistoryEventModel.class);
    }

    public void asyncDeleteData(final AdScopeCycleModel adScopeCycleModel) {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: o3.a
            @Override // java.lang.Runnable
            public final void run() {
                StrategyEventCacheManager.this.lambda$asyncDeleteData$2(adScopeCycleModel);
            }
        });
    }

    public void asyncInsertStrategyEventModel(final AdScopeCycleModel adScopeCycleModel, final String str) {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: o3.c
            @Override // java.lang.Runnable
            public final void run() {
                StrategyEventCacheManager.this.lambda$asyncInsertStrategyEventModel$0(adScopeCycleModel, str);
            }
        });
    }

    public void asyncQueryStrategyEventList(final AdScopeCycleModel adScopeCycleModel) {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: o3.b
            @Override // java.lang.Runnable
            public final void run() {
                StrategyEventCacheManager.this.lambda$asyncQueryStrategyEventList$1(adScopeCycleModel);
            }
        });
    }

    public void buildingDictWithModel(AdScopeHistoryEventModel adScopeHistoryEventModel) {
        Map<String, List<AdScopeHistoryEventModel>> hashMap;
        String str = "strategy_" + adScopeHistoryEventModel.getApiKey() + "_" + adScopeHistoryEventModel.getSpaceId();
        if (this.eventsDict.containsKey(str)) {
            hashMap = this.eventsDict.get(str);
        } else {
            hashMap = new HashMap<>();
            this.eventsDict.put(str, hashMap);
        }
        String str2 = str + "_" + adScopeHistoryEventModel.getEventCode();
        if (hashMap.containsKey(str2)) {
            hashMap.get(str2).add(0, adScopeHistoryEventModel);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, adScopeHistoryEventModel);
        hashMap.put(str2, arrayList);
    }

    public List<AdScopeHistoryEventModel> getArrayWithApiKey(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        String str4 = "strategy_" + str + "_" + str2;
        if (this.eventsDict.containsKey(str4)) {
            Map<String, List<AdScopeHistoryEventModel>> map = this.eventsDict.get(str4);
            String str5 = str4 + "_" + str3;
            return map.containsKey(str5) ? map.get(str5) : arrayList;
        }
        return arrayList;
    }

    /* renamed from: insertStrategyEventModel */
    public void lambda$asyncInsertStrategyEventModel$0(AdScopeCycleModel adScopeCycleModel, String str) {
        if (adScopeCycleModel == null || TextUtils.isEmpty(str) || !AdResponseManager.needSaveEventCodeWithCycleModel(adScopeCycleModel)) {
            return;
        }
        setTableName(adScopeCycleModel);
        AdScopeHistoryEventModel adScopeHistoryEventModel = new AdScopeHistoryEventModel();
        adScopeHistoryEventModel.setApiKey(adScopeCycleModel.getApiKey());
        adScopeHistoryEventModel.setEventCode(str);
        adScopeHistoryEventModel.setSpaceId(adScopeCycleModel.getSpaceId());
        adScopeHistoryEventModel.setEventTime(DeviceInfoUtil.getTimeStamp());
        this.asnpDataBaseManager.insert(adScopeHistoryEventModel);
        lambda$asyncDeleteData$2(adScopeCycleModel);
    }

    /* renamed from: queryStrategyEventList */
    public List<AdScopeHistoryEventModel> lambda$asyncQueryStrategyEventList$1(AdScopeCycleModel adScopeCycleModel) {
        if (adScopeCycleModel == null) {
            return null;
        }
        setTableName(adScopeCycleModel);
        ASNPDataBaseManager aSNPDataBaseManager = this.asnpDataBaseManager;
        String str = this.KEY_EVENT_TIME;
        List<AdScopeHistoryEventModel> query = aSNPDataBaseManager.query(str, this.numEventToQuery + "");
        if (query != null && query.size() > 0) {
            for (AdScopeHistoryEventModel adScopeHistoryEventModel : query) {
                buildingDictWithModel(adScopeHistoryEventModel);
            }
        }
        return query;
    }
}
