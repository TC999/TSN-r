package com.bytedance.pangle.sdk.component.log.impl.cache.db.repo;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class StatsBatchLogEventRepoImpl extends StatsLogEventRepoImpl {
    public StatsBatchLogEventRepoImpl(Context context, PolicyConfig policyConfig) {
        super(context, policyConfig);
    }

    public static String addEncryptColumn() {
        return "ALTER TABLE " + LogInternalManager.getInstance().getDbCallback().getStatsBatchTableName() + " ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    public static String getBatchCreateSql() {
        return "CREATE TABLE IF NOT EXISTS " + LogInternalManager.getInstance().getDbCallback().getStatsBatchTableName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0 , " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsLogEventRepoImpl
    public byte getEventAdType() {
        return (byte) 1;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsLogEventRepoImpl
    public byte getEventPriority() {
        return (byte) 3;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsLogEventRepoImpl
    public String getTableName() {
        return LogInternalManager.getInstance().getDbCallback().getStatsBatchTableName();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsLogEventRepoImpl, com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public String printMessage() {
        return "\u7ec4\u4ef6\u4e2d db_batch.count:" + queryCount();
    }
}
