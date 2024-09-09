package com.bytedance.pangle.sdk.component.log.impl.cache;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventV3RepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.HighPriorityAdEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.OtherEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsBatchLogEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsLogEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.core.DBEventUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventMonitorUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DBCacheStrategy implements ICache {
    private PolicyConfig mAdConfig;
    private AdEventRepoImpl mAdEventRepo;
    private PolicyConfig mAdV3Config;
    private AdEventV3RepoImpl mAdV3Repo;
    private StatsBatchLogEventRepoImpl mBatchEventRepo;
    private PolicyConfig mBatchStatsConfig;
    private PolicyConfig mHighConfig;
    private HighPriorityAdEventRepoImpl mHighEventRepo;
    private PolicyConfig mOtherEventConfig;
    private OtherEventRepoImpl mOtherRepo;
    private PolicyConfig mStatsConfig;
    private StatsLogEventRepoImpl mStatsEventRepo;

    public DBCacheStrategy() {
        Context context = LogInternalManager.getInstance().getContext();
        if (DBEventUtils.isHighAvailable()) {
            PolicyConfig highPolicyConfig = LogInternalManager.getInstance().getHighPolicyConfig();
            this.mHighConfig = highPolicyConfig;
            this.mHighEventRepo = new HighPriorityAdEventRepoImpl(context, highPolicyConfig);
        }
        if (DBEventUtils.isAdEventV3Available()) {
            PolicyConfig normalPolicyConfig = LogInternalManager.getInstance().getNormalPolicyConfig();
            this.mAdV3Config = normalPolicyConfig;
            this.mAdV3Repo = new AdEventV3RepoImpl(context, normalPolicyConfig);
        }
        if (DBEventUtils.isAdEventAvailable()) {
            PolicyConfig normalPolicyConfig2 = LogInternalManager.getInstance().getNormalPolicyConfig();
            this.mAdConfig = normalPolicyConfig2;
            this.mAdEventRepo = new AdEventRepoImpl(context, normalPolicyConfig2);
        }
        if (DBEventUtils.isStatsAvailable()) {
            PolicyConfig normalPolicyConfig3 = LogInternalManager.getInstance().getNormalPolicyConfig();
            this.mStatsConfig = normalPolicyConfig3;
            this.mStatsEventRepo = new StatsLogEventRepoImpl(context, normalPolicyConfig3);
        }
        if (DBEventUtils.isBatchAvailable()) {
            PolicyConfig batchPolicyConfig = LogInternalManager.getInstance().getBatchPolicyConfig();
            this.mBatchStatsConfig = batchPolicyConfig;
            this.mBatchEventRepo = new StatsBatchLogEventRepoImpl(context, batchPolicyConfig);
        }
        if (DBEventUtils.isOtherEventAvailable()) {
            PolicyConfig otherConfig = LogInternalManager.getInstance().getOtherConfig();
            this.mOtherEventConfig = otherConfig;
            this.mOtherRepo = new OtherEventRepoImpl(context, otherConfig);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public void add(AdLogEventFace adLogEventFace, int i4) {
        if (adLogEventFace == null) {
            return;
        }
        try {
            adLogEventFace.setSaveTime(System.currentTimeMillis());
            if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 1) {
                if (DBEventUtils.isHighAvailable()) {
                    this.mHighEventRepo.save(adLogEventFace);
                }
            } else if (adLogEventFace.getAdType() == 3 && adLogEventFace.getPriority() == 2) {
                if (DBEventUtils.isAdEventV3Available()) {
                    this.mAdV3Repo.save(adLogEventFace);
                }
            } else if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 2) {
                if (DBEventUtils.isAdEventAvailable()) {
                    this.mAdEventRepo.save(adLogEventFace);
                }
            } else if (adLogEventFace.getAdType() == 1 && adLogEventFace.getPriority() == 2) {
                if (DBEventUtils.isStatsAvailable()) {
                    this.mStatsEventRepo.save(adLogEventFace);
                }
            } else if (adLogEventFace.getAdType() == 1 && adLogEventFace.getPriority() == 3) {
                if (DBEventUtils.isBatchAvailable()) {
                    this.mBatchEventRepo.save(adLogEventFace);
                }
            } else if (adLogEventFace.getAdType() == 2 && adLogEventFace.getPriority() == 3 && DBEventUtils.isOtherEventAvailable()) {
                this.mOtherRepo.save(adLogEventFace);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getQuit_threadmessage(), 1);
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public boolean checkNeedUpload(int i4, boolean z3) {
        OtherEventRepoImpl otherEventRepoImpl;
        StatsBatchLogEventRepoImpl statsBatchLogEventRepoImpl;
        StatsLogEventRepoImpl statsLogEventRepoImpl;
        AdEventRepoImpl adEventRepoImpl;
        AdEventV3RepoImpl adEventV3RepoImpl;
        HighPriorityAdEventRepoImpl highPriorityAdEventRepoImpl;
        if (DBEventUtils.isHighAvailable() && (highPriorityAdEventRepoImpl = this.mHighEventRepo) != null && highPriorityAdEventRepoImpl.checkNeedUpload(i4)) {
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getHigh_db_avi(), 1);
            return true;
        } else if (DBEventUtils.isAdEventV3Available() && (adEventV3RepoImpl = this.mAdV3Repo) != null && adEventV3RepoImpl.checkNeedUpload(i4)) {
            return true;
        } else {
            if (DBEventUtils.isAdEventAvailable() && (adEventRepoImpl = this.mAdEventRepo) != null && adEventRepoImpl.checkNeedUpload(i4)) {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getAdevent_db_avi(), 1);
                return true;
            } else if (DBEventUtils.isStatsAvailable() && (statsLogEventRepoImpl = this.mStatsEventRepo) != null && statsLogEventRepoImpl.checkNeedUpload(i4)) {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getStats_db_avi(), 1);
                return true;
            } else if (!DBEventUtils.isBatchAvailable() || (statsBatchLogEventRepoImpl = this.mBatchEventRepo) == null || !statsBatchLogEventRepoImpl.checkNeedUpload(i4)) {
                return DBEventUtils.isOtherEventAvailable() && (otherEventRepoImpl = this.mOtherRepo) != null && otherEventRepoImpl.checkNeedUpload(i4);
            } else {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getBatch_db_avi(), 1);
                return true;
            }
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public List<AdLogEventFace> get(int i4, int i5) {
        List<AdLogEventFace> queryAll;
        List<AdLogEventFace> queryAll2;
        List<AdLogEventFace> queryAll3;
        List<AdLogEventFace> queryAll4;
        List<AdLogEventFace> queryAll5;
        List<AdLogEventFace> queryAll6;
        if (DBEventUtils.isHighAvailable() && (queryAll6 = this.mHighEventRepo.queryAll("_id")) != null && queryAll6.size() != 0) {
            LDebug.d("high db get size:" + queryAll6.size());
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getHigh_counts(), 1);
            return queryAll6;
        } else if (DBEventUtils.isAdEventV3Available() && (queryAll5 = this.mAdV3Repo.queryAll("_id")) != null && queryAll5.size() != 0) {
            LDebug.d("v3ad db get :" + queryAll5.size());
            return queryAll5;
        } else if (DBEventUtils.isAdEventAvailable() && (queryAll4 = this.mAdEventRepo.queryAll("_id")) != null && queryAll4.size() != 0) {
            LDebug.d("adevent db get :" + queryAll4.size());
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getAdevent_counts(), 1);
            return queryAll4;
        } else if (DBEventUtils.isStatsAvailable() && (queryAll3 = this.mStatsEventRepo.queryAll("_id")) != null && queryAll3.size() != 0) {
            LDebug.d("real stats db get :" + queryAll3.size());
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getStats_counts(), 1);
            return queryAll3;
        } else if (DBEventUtils.isBatchAvailable() && (queryAll2 = this.mBatchEventRepo.queryAll("_id")) != null && queryAll2.size() != 0) {
            LDebug.d("batch db get :" + queryAll2.size());
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getBatch_counts(), 1);
            return queryAll2;
        } else if (!DBEventUtils.isOtherEventAvailable() || (queryAll = this.mOtherRepo.queryAll("_id")) == null || queryAll.size() == 0) {
            return null;
        } else {
            LDebug.d("other db get :" + queryAll.size());
            return queryAll;
        }
    }

    public List<AdLogEventFace> getReminderEvents(AdLogEventFace adLogEventFace, int i4) {
        if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 1 && DBEventUtils.isHighAvailable()) {
            if (this.mHighConfig.getmAtMostBatchSendCount() > i4) {
                List<AdLogEventFace> queryAll = this.mHighEventRepo.queryAll(this.mHighConfig.getmAtMostBatchSendCount() - i4, "_id");
                if (queryAll != null && queryAll.size() != 0) {
                    EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getHigh_times(), 1);
                }
                return queryAll;
            }
            return null;
        }
        if (adLogEventFace.getAdType() == 3 && adLogEventFace.getPriority() == 2 && DBEventUtils.isAdEventV3Available()) {
            if (this.mAdV3Config.getmAtMostBatchSendCount() > i4) {
                return this.mAdV3Repo.queryAll(this.mAdV3Config.getmAtMostBatchSendCount() - i4, "_id");
            }
        } else if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 2 && DBEventUtils.isAdEventAvailable()) {
            if (this.mAdConfig.getmAtMostBatchSendCount() > i4) {
                List<AdLogEventFace> queryAll2 = this.mAdEventRepo.queryAll(this.mAdConfig.getmAtMostBatchSendCount() - i4, "_id");
                if (queryAll2 != null && queryAll2.size() != 0) {
                    EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getAdevent_times(), 1);
                }
                return queryAll2;
            }
        } else if (adLogEventFace.getAdType() == 1 && adLogEventFace.getPriority() == 2 && DBEventUtils.isStatsAvailable()) {
            if (this.mStatsConfig.getmAtMostBatchSendCount() > i4) {
                List<AdLogEventFace> queryAll3 = this.mStatsEventRepo.queryAll(this.mStatsConfig.getmAtMostBatchSendCount() - i4, "_id");
                if (queryAll3 != null && queryAll3.size() != 0) {
                    EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getStats_times(), 1);
                }
                return queryAll3;
            }
        } else if (adLogEventFace.getAdType() == 1 && adLogEventFace.getPriority() == 3 && DBEventUtils.isBatchAvailable()) {
            if (this.mBatchStatsConfig.getmAtMostBatchSendCount() > i4) {
                List<AdLogEventFace> queryAll4 = this.mBatchEventRepo.queryAll(this.mBatchStatsConfig.getmAtMostBatchSendCount() - i4, "_id");
                if (queryAll4 != null && queryAll4.size() != 0) {
                    EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getBatch_times(), 1);
                }
                return queryAll4;
            }
        } else if (adLogEventFace.getAdType() == 2 && adLogEventFace.getPriority() == 3 && DBEventUtils.isOtherEventAvailable() && this.mOtherEventConfig.getmAtMostBatchSendCount() > i4) {
            return this.mOtherRepo.queryAll(this.mOtherEventConfig.getmAtMostBatchSendCount() - i4, "_id");
        }
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public void handleResult(int i4, List<AdLogEventFace> list) {
        LDebug.d("dbCache handleResult start");
        if (list != null && list.size() != 0 && list.get(0) != null) {
            AdLogEventFace adLogEventFace = list.get(0);
            if (i4 == 200 || i4 == -1) {
                EventMonitor eventMonitor = LogThreadCenter.sEventMonitor;
                EventMonitorUtils.add(eventMonitor.getAll_delete_count(), list.size());
                if (i4 != 200) {
                    EventMonitorUtils.add(eventMonitor.getInvalid_delete_count(), list.size());
                }
                if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 1) {
                    if (DBEventUtils.isHighAvailable()) {
                        this.mHighEventRepo.delete(list);
                    }
                } else if (adLogEventFace.getAdType() == 3 && adLogEventFace.getPriority() == 2) {
                    if (DBEventUtils.isAdEventV3Available()) {
                        this.mAdV3Repo.delete(list);
                    }
                } else if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 2) {
                    if (DBEventUtils.isAdEventAvailable()) {
                        this.mAdEventRepo.delete(list);
                    }
                } else if (adLogEventFace.getAdType() == 1 && adLogEventFace.getPriority() == 2) {
                    if (DBEventUtils.isStatsAvailable()) {
                        this.mStatsEventRepo.delete(list);
                    }
                } else if (adLogEventFace.getAdType() == 1 && adLogEventFace.getPriority() == 3) {
                    if (DBEventUtils.isBatchAvailable()) {
                        this.mBatchEventRepo.delete(list);
                    }
                } else if (adLogEventFace.getAdType() == 2 && adLogEventFace.getPriority() == 3 && DBEventUtils.isOtherEventAvailable()) {
                    this.mOtherRepo.delete(list);
                }
            }
        }
        LDebug.d("dbCache handleResult end");
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printBatchEvent() {
        return DBEventUtils.isBatchAvailable() ? this.mBatchEventRepo.printMessage() : "";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printHighEvent() {
        return DBEventUtils.isHighAvailable() ? this.mHighEventRepo.printMessage() : "";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printRealAdEvent() {
        return DBEventUtils.isAdEventAvailable() ? this.mAdEventRepo.printMessage() : "";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.ICache
    public String printRealStatsEvent() {
        return DBEventUtils.isStatsAvailable() ? this.mStatsEventRepo.printMessage() : "";
    }
}
