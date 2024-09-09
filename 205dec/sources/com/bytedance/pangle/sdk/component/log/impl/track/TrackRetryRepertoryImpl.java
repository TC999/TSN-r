package com.bytedance.pangle.sdk.component.log.impl.track;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.DBMultiUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TrackRetryRepertoryImpl implements TrackRetryRepertory {
    private static final String COL_ID = "id";
    private static final String COL_REPLACE_HOLDER = "replaceholder";
    private static final String COL_RETRY_COUNT = "retry";
    private static final String COL_URL = "url";
    private static final String TABLE_NAME = "trackurl";
    private Context mContext;

    public TrackRetryRepertoryImpl(Context context) {
        this.mContext = context;
    }

    public static String getCreateSql() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ," + COL_REPLACE_HOLDER + " INTEGER default 0, retry INTEGER default 0)";
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackRetryRepertory
    public synchronized void delete(TrackInfo trackInfo) {
        DBMultiUtils.delete(this.mContext, TABLE_NAME, "id=?", new String[]{trackInfo.getId()});
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackRetryRepertory
    public synchronized void insert(TrackInfo trackInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", trackInfo.getId());
        contentValues.put("url", trackInfo.getUrl());
        contentValues.put(COL_REPLACE_HOLDER, Integer.valueOf(trackInfo.isReplaceHolder() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(trackInfo.getRetryCount()));
        DBMultiUtils.insert(this.mContext, TABLE_NAME, contentValues);
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackRetryRepertory
    public synchronized List<TrackInfo> queryAll() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor query = DBMultiUtils.query(this.mContext, TABLE_NAME, null, null, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    linkedList.add(new TrackInfo(query.getString(query.getColumnIndex("id")), query.getString(query.getColumnIndex("url")), query.getInt(query.getColumnIndex(COL_REPLACE_HOLDER)) > 0, query.getInt(query.getColumnIndex("retry"))));
                } catch (Throwable unused) {
                    query.close();
                }
            }
            query.close();
        }
        return linkedList;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackRetryRepertory
    public synchronized void update(TrackInfo trackInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", trackInfo.getId());
        contentValues.put("url", trackInfo.getUrl());
        contentValues.put(COL_REPLACE_HOLDER, Integer.valueOf(trackInfo.isReplaceHolder() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(trackInfo.getRetryCount()));
        DBMultiUtils.update(this.mContext, TABLE_NAME, contentValues, "id=?", new String[]{trackInfo.getId()});
    }
}
