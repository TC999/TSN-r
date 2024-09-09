package com.bytedance.pangle.sdk.component.log.impl.cache;

import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.mem.AdEventMemoryCacheManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.mem.AdV3EventMemoryCacheManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.mem.BatchMemoryCacheManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.mem.HighAdEventMemoryCacheManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.mem.OtherMemoryCacheManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.mem.StatsEventCacheManager;
import com.bytedance.pangle.sdk.component.log.impl.core.DBEventUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventMonitorUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.List;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RealTimeMemoryCacheStrategy implements ICache {
    private static final String TAG = "RealTimeCacheStrategy";
    IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
    private AdEventMemoryCacheManager mAdManager;
    private PolicyConfig mBatchConfig;
    private BatchMemoryCacheManager mBatchManager;
    private HighAdEventMemoryCacheManager mHighAdManager;
    private PolicyConfig mHighConfig;
    private PolicyConfig mOtherConfig;
    private OtherMemoryCacheManager mOtherManager;
    private PolicyConfig mRealAdConfig;
    private PolicyConfig mRealStatsConfig;
    private StatsEventCacheManager mStatsManager;
    private PolicyConfig mV3Config;
    private AdV3EventMemoryCacheManager mV3Manager;
    private Queue<String> sendingQueue;

    public RealTimeMemoryCacheStrategy(Queue<String> queue) {
        this.sendingQueue = queue;
        if (DBEventUtils.isHighAvailable()) {
            PolicyConfig highPolicyConfig = LogInternalManager.getInstance().getHighPolicyConfig();
            this.mHighConfig = highPolicyConfig;
            this.mHighAdManager = new HighAdEventMemoryCacheManager(highPolicyConfig, queue);
        }
        if (DBEventUtils.isAdEventV3Available()) {
            PolicyConfig normalPolicyConfig = LogInternalManager.getInstance().getNormalPolicyConfig();
            this.mV3Config = normalPolicyConfig;
            this.mV3Manager = new AdV3EventMemoryCacheManager(normalPolicyConfig, queue);
        }
        if (DBEventUtils.isAdEventAvailable()) {
            PolicyConfig normalPolicyConfig2 = LogInternalManager.getInstance().getNormalPolicyConfig();
            this.mRealAdConfig = normalPolicyConfig2;
            this.mAdManager = new AdEventMemoryCacheManager(normalPolicyConfig2, queue);
        }
        if (DBEventUtils.isStatsAvailable()) {
            PolicyConfig normalPolicyConfig3 = LogInternalManager.getInstance().getNormalPolicyConfig();
            this.mRealStatsConfig = normalPolicyConfig3;
            this.mStatsManager = new StatsEventCacheManager(normalPolicyConfig3, queue);
        }
        if (DBEventUtils.isBatchAvailable()) {
            PolicyConfig batchPolicyConfig = LogInternalManager.getInstance().getBatchPolicyConfig();
            this.mBatchConfig = batchPolicyConfig;
            this.mBatchManager = new BatchMemoryCacheManager(batchPolicyConfig, queue);
        }
        if (DBEventUtils.isOtherEventAvailable()) {
            PolicyConfig otherConfig = LogInternalManager.getInstance().getOtherConfig();
            this.mOtherConfig = otherConfig;
            this.mOtherManager = new OtherMemoryCacheManager(otherConfig, queue);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public void add(AdLogEventFace adLogEventFace, int i4) {
        try {
            byte adType = adLogEventFace.getAdType();
            byte priority = adLogEventFace.getPriority();
            if (adType == 0 && priority == 1 && DBEventUtils.isHighAvailable()) {
                this.mHighAdManager.add(adLogEventFace);
            } else if (adType == 3 && priority == 2 && DBEventUtils.isAdEventV3Available()) {
                this.mV3Manager.add(adLogEventFace);
            } else if (adType == 0 && priority == 2 && DBEventUtils.isAdEventAvailable()) {
                this.mAdManager.add(adLogEventFace);
            } else if (adType == 1 && priority == 2 && DBEventUtils.isStatsAvailable()) {
                this.mStatsManager.add(adLogEventFace);
            } else if (adType == 1 && priority == 3 && DBEventUtils.isBatchAvailable()) {
                this.mBatchManager.add(adLogEventFace);
            } else if (adType == 2 && priority == 3 && DBEventUtils.isOtherEventAvailable()) {
                this.mOtherManager.add(adLogEventFace);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public boolean checkNeedUpload(int i4, boolean z3) {
        OtherMemoryCacheManager otherMemoryCacheManager;
        PolicyConfig policyConfig;
        BatchMemoryCacheManager batchMemoryCacheManager;
        PolicyConfig policyConfig2;
        StatsEventCacheManager statsEventCacheManager;
        PolicyConfig policyConfig3;
        AdEventMemoryCacheManager adEventMemoryCacheManager;
        PolicyConfig policyConfig4;
        AdV3EventMemoryCacheManager adV3EventMemoryCacheManager;
        PolicyConfig policyConfig5;
        HighAdEventMemoryCacheManager highAdEventMemoryCacheManager;
        PolicyConfig policyConfig6;
        return (DBEventUtils.isHighAvailable() && (highAdEventMemoryCacheManager = this.mHighAdManager) != null && (policyConfig6 = this.mHighConfig) != null && highAdEventMemoryCacheManager.checkNeedUpload(i4, policyConfig6.getmMaxCacheCount())) || (DBEventUtils.isAdEventV3Available() && (adV3EventMemoryCacheManager = this.mV3Manager) != null && (policyConfig5 = this.mV3Config) != null && adV3EventMemoryCacheManager.checkNeedUpload(i4, policyConfig5.getmMaxCacheCount())) || ((DBEventUtils.isAdEventAvailable() && (adEventMemoryCacheManager = this.mAdManager) != null && (policyConfig4 = this.mRealAdConfig) != null && adEventMemoryCacheManager.checkNeedUpload(i4, policyConfig4.getmMaxCacheCount())) || ((DBEventUtils.isStatsAvailable() && (statsEventCacheManager = this.mStatsManager) != null && (policyConfig3 = this.mRealStatsConfig) != null && statsEventCacheManager.checkNeedUpload(i4, policyConfig3.getmMaxCacheCount())) || ((DBEventUtils.isBatchAvailable() && (batchMemoryCacheManager = this.mBatchManager) != null && (policyConfig2 = this.mBatchConfig) != null && batchMemoryCacheManager.checkNeedUpload(i4, policyConfig2.getmMaxCacheCount())) || (DBEventUtils.isOtherEventAvailable() && (otherMemoryCacheManager = this.mOtherManager) != null && (policyConfig = this.mOtherConfig) != null && otherMemoryCacheManager.checkNeedUpload(i4, policyConfig.getmMaxCacheCount())))));
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public List<AdLogEventFace> get(int i4, int i5) {
        List<AdLogEventFace> list;
        List<AdLogEventFace> list2;
        List<AdLogEventFace> list3;
        List<AdLogEventFace> list4;
        List<AdLogEventFace> list5;
        List<AdLogEventFace> list6;
        if (DBEventUtils.isHighAvailable() && this.mHighAdManager.checkNeedUpload(i4, i5) && (list6 = this.mHighAdManager.get(i4, i5)) != null && list6.size() != 0) {
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getHigh_m_counts(), 1);
            return list6;
        } else if (!DBEventUtils.isAdEventV3Available() || !this.mV3Manager.checkNeedUpload(i4, i5) || (list5 = this.mV3Manager.get(i4, i5)) == null || list5.size() == 0) {
            if (DBEventUtils.isAdEventAvailable() && this.mAdManager.checkNeedUpload(i4, i5) && (list4 = this.mAdManager.get(i4, i5)) != null && list4.size() != 0) {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getAdevent_m_counts(), 1);
                return list4;
            } else if (DBEventUtils.isStatsAvailable() && this.mStatsManager.checkNeedUpload(i4, i5) && (list3 = this.mStatsManager.get(i4, i5)) != null && list3.size() != 0) {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getStats_m_counts(), 1);
                return list3;
            } else if (DBEventUtils.isBatchAvailable() && this.mBatchManager.checkNeedUpload(i4, i5) && (list2 = this.mBatchManager.get(i4, i5)) != null && list2.size() != 0) {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getBatch_m_counts(), 1);
                return list2;
            } else if (!DBEventUtils.isOtherEventAvailable() || !this.mOtherManager.checkNeedUpload(i4, i5) || (list = this.mOtherManager.get(i4, i5)) == null || list.size() == 0) {
                return null;
            } else {
                return list;
            }
        } else {
            return list5;
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public void handleResult(int i4, List<AdLogEventFace> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        AdLogEventFace adLogEventFace = list.get(0);
        byte priority = adLogEventFace.getPriority();
        byte adType = adLogEventFace.getAdType();
        if (adType == 0 && priority == 1 && DBEventUtils.isHighAvailable()) {
            this.mHighAdManager.handleUploadResult(i4, list);
        } else if (adType == 3 && priority == 2 && DBEventUtils.isAdEventV3Available()) {
            this.mV3Manager.handleUploadResult(i4, list);
        } else if (adType == 0 && priority == 2 && DBEventUtils.isAdEventAvailable()) {
            this.mAdManager.handleUploadResult(i4, list);
        } else if (adType == 1 && priority == 2 && DBEventUtils.isStatsAvailable()) {
            this.mStatsManager.handleUploadResult(i4, list);
        } else if (adType == 1 && priority == 3 && DBEventUtils.isBatchAvailable()) {
            this.mBatchManager.handleUploadResult(i4, list);
        } else if (adType == 2 && priority == 3 && DBEventUtils.isOtherEventAvailable()) {
            this.mOtherManager.handleUploadResult(i4, list);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printBatchEvent() {
        return DBEventUtils.isBatchAvailable() ? this.mBatchManager.printMessage() : "";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printHighEvent() {
        return DBEventUtils.isHighAvailable() ? this.mHighAdManager.printMessage() : "";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printRealAdEvent() {
        return DBEventUtils.isAdEventAvailable() ? this.mAdManager.printMessage() : "";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printRealStatsEvent() {
        return DBEventUtils.isStatsAvailable() ? this.mStatsManager.printMessage() : "";
    }
}
