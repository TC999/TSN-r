package com.bytedance.pangle.sdk.component.log.impl.cache.db.repo;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class HighPriorityAdEventRepoImpl extends AdEventRepoImpl {
    private PolicyConfig mPolicyConfig;

    public HighPriorityAdEventRepoImpl(Context context, PolicyConfig policyConfig) {
        super(context, policyConfig);
    }

    public static String addEncryptColumn() {
        return "ALTER TABLE " + LogInternalManager.getInstance().getDbCallback().getHighPriorityTableName() + " ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    public static String getHighPriorityCreateSql() {
        return "CREATE TABLE IF NOT EXISTS " + LogInternalManager.getInstance().getDbCallback().getHighPriorityTableName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0 , " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl
    public byte getEventAdType() {
        return (byte) 0;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl
    public byte getEventPriority() {
        return (byte) 1;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl
    public String getTableName() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        if (dbCallback != null) {
            return dbCallback.getHighPriorityTableName();
        }
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl, com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo
    public String printMessage() {
        return "In component db_high_priority.count:" + queryCount();
    }
}
