package com.beizi.fusion.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.y;
import com.beizi.fusion.model.EventItem;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DaoManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f14418a;

    /* renamed from: b  reason: collision with root package name */
    private a f14419b;

    private b(Context context) {
        this.f14419b = a.a(context);
    }

    public static b a(Context context) {
        if (f14418a == null) {
            synchronized (b.class) {
                if (f14418a == null) {
                    f14418a = new b(context);
                }
            }
        }
        return f14418a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (r1 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean b(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            if (r12 != 0) goto L6
            monitor-exit(r11)
            return r0
        L6:
            r1 = 0
            com.beizi.fusion.a.a r2 = r11.f14419b     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            r2 = 1
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r4 = "count('*') as c"
            r5[r0] = r4     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r6 = "type=? and name =?"
            r4 = 2
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r4 = "table"
            r7[r0] = r4     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r12 = r12.trim()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            r7[r2] = r12     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r4 = "Sqlite_master"
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            if (r12 == 0) goto L59
            int r12 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r3 = "DaoManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            r4.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r5 = "DaoManager count:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            r4.append(r12)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            android.util.Log.e(r3, r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
            if (r12 <= 0) goto L59
            r0 = 1
            goto L59
        L50:
            r12 = move-exception
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.lang.Throwable -> L5d
        L56:
            throw r12     // Catch: java.lang.Throwable -> L5d
        L57:
            if (r1 == 0) goto L60
        L59:
            r1.close()     // Catch: java.lang.Throwable -> L5d
            goto L60
        L5d:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L60:
            monitor-exit(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.a.b.b(java.lang.String):boolean");
    }

    private synchronized void c(String str) {
        SQLiteDatabase writableDatabase = this.f14419b.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            String str2 = "create table " + str + "(id integer primary key autoincrement,event_code nvarchar,channel nvarchar,space_id nvarchar," + CampaignEx.JSON_KEY_TIMESTAMP + " nvarchar)";
            af.a("DaoManager", "sql createTable tableName = " + str2);
            writableDatabase.execSQL(str2);
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        writableDatabase.endTransaction();
    }

    private synchronized void d(String str) {
        boolean b4 = b(str);
        af.a("DaoManager", "sql table is exist == " + b4);
        if (!b4) {
            c(str);
        }
    }

    private synchronized int e(String str) {
        int i4;
        i4 = 0;
        Cursor query = this.f14419b.getWritableDatabase().query(str, null, null, null, null, null, null);
        if (query != null) {
            i4 = query.getCount();
            query.close();
        }
        return i4;
    }

    private EventItem a(Cursor cursor) {
        EventItem eventItem = new EventItem();
        eventItem.setCode(cursor.getString(cursor.getColumnIndex("event_code")));
        eventItem.setChannel(cursor.getString(cursor.getColumnIndex("channel")));
        eventItem.setSpaceId(cursor.getString(cursor.getColumnIndex("space_id")));
        eventItem.setTimeStamp(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_TIMESTAMP)));
        return eventItem;
    }

    private ContentValues a(EventItem eventItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_code", eventItem.getCode());
        contentValues.put("channel", eventItem.getChannel());
        contentValues.put("space_id", eventItem.getSpaceId());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, eventItem.getTimeStamp());
        return contentValues;
    }

    public synchronized void a(String str, EventItem eventItem) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "T_" + str;
        d(str2);
        int e4 = e(str2);
        long insert = this.f14419b.getWritableDatabase().insert(str2, null, a(eventItem));
        StringBuilder sb = new StringBuilder();
        sb.append("insert before size == ");
        sb.append(e4);
        sb.append(", insert data success = ");
        sb.append(insert != -1);
        af.a("DaoManager", sb.toString());
        a(str2, Math.max(86400000L, y.b(str) * 2));
    }

    public synchronized List<EventItem> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "T_" + str;
        d(str2);
        ArrayList arrayList = new ArrayList();
        Cursor query = this.f14419b.getWritableDatabase().query(str2, null, null, null, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.moveToFirst();
            do {
                arrayList.add(a(query));
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    public synchronized void a(String str, long j4) {
        long currentTimeMillis = System.currentTimeMillis() - j4;
        int e4 = e(str);
        if (e4 > 0 && j4 > 0 && currentTimeMillis > 0) {
            boolean z3 = true;
            int delete = this.f14419b.getWritableDatabase().delete(str, "timestamp<=?", new String[]{String.valueOf(currentTimeMillis)});
            StringBuilder sb = new StringBuilder();
            sb.append("start first delete data success = ");
            if (delete <= 0) {
                z3 = false;
            }
            sb.append(z3);
            sb.append(", intervalTime = ");
            sb.append(j4);
            af.a("DaoManager", sb.toString());
        }
        if (e4 >= 1000) {
            this.f14419b.getWritableDatabase().execSQL("delete from " + str + " where rowid in(select rowid from " + str + " order by id limit 200)");
            af.a("DaoManager", "start second delete data");
        }
    }
}
