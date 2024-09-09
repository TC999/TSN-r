package com.bytedance.msdk.xv.xv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.msdk.xv.c.r;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements IDBCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final ux f28593c = new ux();

    /* renamed from: w  reason: collision with root package name */
    private volatile SQLiteDatabase f28594w;

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getAdEventTableName() {
        return "adevent";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getAdEventV3TableName() {
        return "adevent_applog";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public SQLiteDatabase getDatabase(Context context) {
        if (this.f28594w == null) {
            synchronized (this) {
                if (this.f28594w == null) {
                    this.f28594w = r.c(context).c().c();
                    com.bytedance.msdk.adapter.sr.xv.c("---------------DB CREATE  SUCCESS old------------");
                }
            }
        }
        return this.f28594w;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getDbName() {
        return "tt_mediation_open_sdk.db";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getHighPriorityTableName() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getOtherEventTableName() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getStatsBatchTableName() {
        return null;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback
    public String getStatsEventTableName() {
        return null;
    }
}
