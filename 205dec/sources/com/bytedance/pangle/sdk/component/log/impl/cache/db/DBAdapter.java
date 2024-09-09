package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.DBHelper;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DBAdapter extends DBHelper {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile DBAdapter sInstance;

    private DBAdapter(Context context) {
        super(context);
    }

    public static DBAdapter getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DBAdapter.class) {
                if (sInstance == null) {
                    sInstance = new DBAdapter(context);
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.DBHelper
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.cache.db.DBHelper
    public /* bridge */ /* synthetic */ DBHelper.MySQLiteDatabase getDb() {
        return super.getDb();
    }
}
