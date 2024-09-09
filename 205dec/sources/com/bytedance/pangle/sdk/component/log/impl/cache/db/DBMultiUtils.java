package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DBMultiUtils {
    public static synchronized int delete(Context context, String str, String str2, String[] strArr) {
        synchronized (DBMultiUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            LDebug.d("DBMultiUtils  delete start");
            return DBAdapter.getInstance(context).getDb().delete(str, str2, strArr);
        }
    }

    public static synchronized void execSQL(Context context, String str) {
        synchronized (DBMultiUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DBAdapter.getInstance(context).getDb().execSQL(Uri.decode(str));
        }
    }

    public static synchronized void insert(Context context, String str, ContentValues contentValues) {
        synchronized (DBMultiUtils.class) {
            if (contentValues != null) {
                if (!TextUtils.isEmpty(str)) {
                    DBAdapter.getInstance(context).getDb().insert(str, null, contentValues);
                }
            }
        }
    }

    public static synchronized Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        synchronized (DBMultiUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return DBAdapter.getInstance(context).getDb().query(str, strArr, str2, strArr2, null, null, str5);
        }
    }

    public static synchronized int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        synchronized (DBMultiUtils.class) {
            if (contentValues != null) {
                if (!TextUtils.isEmpty(str)) {
                    return DBAdapter.getInstance(context).getDb().update(str, contentValues, str2, strArr);
                }
            }
            return 0;
        }
    }
}
