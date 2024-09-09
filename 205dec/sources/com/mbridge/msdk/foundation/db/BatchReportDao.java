package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.foundation.same.report.BatchReportMessage;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BatchReportDao extends a<BatchReportMessage> implements NoProGuard, Serializable {
    private static volatile BatchReportDao instance;

    protected BatchReportDao(h hVar) {
        super(hVar);
    }

    public static BatchReportDao getInstance(h hVar) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(hVar);
                }
            }
        }
        return instance;
    }

    public void addReportMessage(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("report_message", str);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("uuid", UUID.randomUUID().toString().replace("-", ""));
            contentValues.put("report_state", (Integer) 0);
            writableDatabase.insert("batch_report", null, contentValues);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void deleteBatchReportMessagesByTimestamp(long j4) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return;
        }
        try {
            readableDatabase.rawQuery("delete from batch_report where time <= " + j4, null);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ArrayList<BatchReportMessage> getBatchReportMessages(long j4) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        if (readableDatabase == null) {
            return null;
        }
        ArrayList<BatchReportMessage> arrayList = new ArrayList<>();
        try {
            try {
                Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM batch_report WHERE time <= " + j4 + " AND report_state = 0", null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        try {
                            arrayList.add(new BatchReportMessage(rawQuery.getString(rawQuery.getColumnIndex("uuid")), rawQuery.getString(rawQuery.getColumnIndex("report_message")), rawQuery.getLong(rawQuery.getColumnIndex("time"))));
                        } catch (Throwable th) {
                            th = th;
                            cursor = rawQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("report_state", (Integer) 1);
                readableDatabase.update("batch_report", contentValues, "time <= " + j4, null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void updateMessagesReportState(ArrayList<BatchReportMessage> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (arrayList == null || arrayList.size() == 0 || writableDatabase == null) {
            return;
        }
        Iterator<BatchReportMessage> it = arrayList.iterator();
        while (it.hasNext()) {
            BatchReportMessage next = it.next();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("report_state", (Integer) 0);
                writableDatabase.update("batch_report", contentValues, "uuid = '" + next.getUuid() + "'", null);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static BatchReportDao getInstance(Context context) {
        if (instance == null) {
            synchronized (BatchReportDao.class) {
                if (instance == null) {
                    instance = new BatchReportDao(i.a(context));
                }
            }
        }
        return instance;
    }
}
