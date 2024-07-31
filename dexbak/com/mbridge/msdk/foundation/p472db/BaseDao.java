package com.mbridge.msdk.foundation.p472db;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.mbridge.msdk.foundation.db.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BaseDao<T> {
    protected CommonAbsDBHelper mHelper;

    public BaseDao(CommonAbsDBHelper commonAbsDBHelper) {
        this.mHelper = commonAbsDBHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized SQLiteDatabase getReadableDatabase() {
        return this.mHelper.m22723a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized SQLiteDatabase getWritableDatabase() {
        return this.mHelper.m22722b();
    }
}
