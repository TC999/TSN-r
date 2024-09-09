package com.bytedance.pangle.sdk.component.log.impl.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IDBCallback {
    String getAdEventTableName();

    String getAdEventV3TableName();

    SQLiteDatabase getDatabase(Context context);

    String getDbName();

    String getHighPriorityTableName();

    String getOtherEventTableName();

    String getStatsBatchTableName();

    String getStatsEventTableName();
}
