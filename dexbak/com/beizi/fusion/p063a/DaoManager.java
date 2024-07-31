package com.beizi.fusion.p063a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.FreqUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DaoManager {

    /* renamed from: a */
    private static volatile DaoManager f10854a;

    /* renamed from: b */
    private AdSQLiteOpenHelper f10855b;

    private DaoManager(Context context) {
        this.f10855b = AdSQLiteOpenHelper.m49000a(context);
    }

    /* renamed from: a */
    public static DaoManager m48999a(Context context) {
        if (f10854a == null) {
            synchronized (DaoManager.class) {
                if (f10854a == null) {
                    f10854a = new DaoManager(context);
                }
            }
        }
        return f10854a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (r1 != null) goto L15;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean m48993b(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            if (r12 != 0) goto L6
            monitor-exit(r11)
            return r0
        L6:
            r1 = 0
            com.beizi.fusion.a.a r2 = r11.f10855b     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L57
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
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p063a.DaoManager.m48993b(java.lang.String):boolean");
    }

    /* renamed from: c */
    private synchronized void m48992c(String str) {
        SQLiteDatabase writableDatabase = this.f10855b.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            String str2 = "create table " + str + "(id integer primary key autoincrement,event_code nvarchar,channel nvarchar,space_id nvarchar," + CampaignEx.JSON_KEY_TIMESTAMP + " nvarchar)";
            C3116af.m48496a("DaoManager", "sql createTable tableName = " + str2);
            writableDatabase.execSQL(str2);
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writableDatabase.endTransaction();
    }

    /* renamed from: d */
    private synchronized void m48991d(String str) {
        boolean m48993b = m48993b(str);
        C3116af.m48496a("DaoManager", "sql table is exist == " + m48993b);
        if (!m48993b) {
            m48992c(str);
        }
    }

    /* renamed from: e */
    private synchronized int m48990e(String str) {
        int i;
        i = 0;
        Cursor query = this.f10855b.getWritableDatabase().query(str, null, null, null, null, null, null);
        if (query != null) {
            i = query.getCount();
            query.close();
        }
        return i;
    }

    /* renamed from: a */
    private EventItem m48998a(Cursor cursor) {
        EventItem eventItem = new EventItem();
        eventItem.setCode(cursor.getString(cursor.getColumnIndex("event_code")));
        eventItem.setChannel(cursor.getString(cursor.getColumnIndex("channel")));
        eventItem.setSpaceId(cursor.getString(cursor.getColumnIndex("space_id")));
        eventItem.setTimeStamp(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_TIMESTAMP)));
        return eventItem;
    }

    /* renamed from: a */
    private ContentValues m48997a(EventItem eventItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_code", eventItem.getCode());
        contentValues.put("channel", eventItem.getChannel());
        contentValues.put("space_id", eventItem.getSpaceId());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, eventItem.getTimeStamp());
        return contentValues;
    }

    /* renamed from: a */
    public synchronized void m48994a(String str, EventItem eventItem) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "T_" + str;
        m48991d(str2);
        int m48990e = m48990e(str2);
        long insert = this.f10855b.getWritableDatabase().insert(str2, null, m48997a(eventItem));
        StringBuilder sb = new StringBuilder();
        sb.append("insert before size == ");
        sb.append(m48990e);
        sb.append(", insert data success = ");
        sb.append(insert != -1);
        C3116af.m48496a("DaoManager", sb.toString());
        m48995a(str2, Math.max(86400000L, FreqUtil.m48158b(str) * 2));
    }

    /* renamed from: a */
    public synchronized List<EventItem> m48996a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "T_" + str;
        m48991d(str2);
        ArrayList arrayList = new ArrayList();
        Cursor query = this.f10855b.getWritableDatabase().query(str2, null, null, null, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.moveToFirst();
            do {
                arrayList.add(m48998a(query));
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void m48995a(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        int m48990e = m48990e(str);
        if (m48990e > 0 && j > 0 && currentTimeMillis > 0) {
            boolean z = true;
            int delete = this.f10855b.getWritableDatabase().delete(str, "timestamp<=?", new String[]{String.valueOf(currentTimeMillis)});
            StringBuilder sb = new StringBuilder();
            sb.append("start first delete data success = ");
            if (delete <= 0) {
                z = false;
            }
            sb.append(z);
            sb.append(", intervalTime = ");
            sb.append(j);
            C3116af.m48496a("DaoManager", sb.toString());
        }
        if (m48990e >= 1000) {
            this.f10855b.getWritableDatabase().execSQL("delete from " + str + " where rowid in(select rowid from " + str + " order by id limit 200)");
            C3116af.m48496a("DaoManager", "start second delete data");
        }
    }
}
