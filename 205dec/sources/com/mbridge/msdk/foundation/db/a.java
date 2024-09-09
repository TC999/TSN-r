package com.mbridge.msdk.foundation.db;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: BaseDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a<T> {
    protected h mHelper;

    public a(h hVar) {
        this.mHelper = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized SQLiteDatabase getReadableDatabase() {
        return this.mHelper.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized SQLiteDatabase getWritableDatabase() {
        return this.mHelper.b();
    }
}
