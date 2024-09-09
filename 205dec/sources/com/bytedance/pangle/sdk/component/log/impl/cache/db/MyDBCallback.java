package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class MyDBCallback implements IDBCallback {
    public static final MyDBCallback INSTANCE = new MyDBCallback();
    private volatile SQLiteDatabase writableDatabase;

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getAdEventTableName() {
        return "adevent";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getAdEventV3TableName() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public SQLiteDatabase getDatabase(Context context) {
        if (this.writableDatabase == null) {
            synchronized (this) {
                if (this.writableDatabase == null) {
                    this.writableDatabase = new DatabaseHelper(context).getWritableDatabase();
                    LDebug.d("---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.writableDatabase;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getDbName() {
        return "ttadlog.db";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getHighPriorityTableName() {
        return "loghighpriority";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getOtherEventTableName() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getStatsBatchTableName() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getStatsEventTableName() {
        return "logstats";
    }
}
