package cn.jpush.android.v;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f4460b;

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4459a = {"_id", "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4461c = new Object();

    private b(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public static b a(Context context) {
        if (f4460b == null) {
            synchronized (f4461c) {
                if (f4460b == null) {
                    f4460b = new b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f4460b;
    }

    public static c a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            Logger.d("LocalNotificationDb", "cursor is null");
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(cursor.getLong(1));
            cVar.a(cursor.getInt(2));
            cVar.b(cursor.getInt(3));
            cVar.c(cursor.getInt(4));
            cVar.a(cn.jpush.android.ad.c.c(cursor.getString(5)));
            cVar.c(cursor.getLong(6));
            cVar.b(cursor.getLong(7));
            Logger.i("LocalNotificationDb", cVar.toString());
            return cVar;
        } catch (Exception e4) {
            e4.getStackTrace();
            Logger.w("LocalNotificationDb", "initLocalNotificationDBData exception:" + e4.getMessage());
            return null;
        }
    }

    public int a(long j4) {
        if (a(true)) {
            try {
                return getWritableDatabase().delete("t_localnotification", "ln_id=" + j4, null);
            } catch (Exception unused) {
                return 0;
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public long a(long j4, int i4, int i5, int i6, String str, long j5, long j6) {
        if (a(true)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j4));
                contentValues.put("ln_count", Integer.valueOf(i4));
                contentValues.put("ln_remove", Integer.valueOf(i5));
                contentValues.put("ln_type", Integer.valueOf(i6));
                contentValues.put("ln_extra", cn.jpush.android.ad.c.c(str));
                contentValues.put("ln_trigger_time", Long.valueOf(j5));
                contentValues.put("ln_add_time", Long.valueOf(j6));
                return getWritableDatabase().insert("t_localnotification", null, contentValues);
            } catch (Exception unused) {
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    public Cursor a(int i4, long j4) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f4459a, "ln_count=" + i4 + " and ln_trigger_time<" + j4, null, null, null, null, null);
        } catch (Exception e4) {
            Logger.w("LocalNotificationDb", "getOutDatas exception:" + e4.getMessage());
            return null;
        }
    }

    public Cursor a(long j4, long j5) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f4459a, "ln_count>0 and ln_trigger_time<" + (j5 + j4) + " and ln_trigger_time>" + j4, null, null, null, null, null);
        } catch (Exception e4) {
            Logger.w("LocalNotificationDb", "getRtcDatas exception:" + e4.getMessage());
            return null;
        }
    }

    public c a(long j4, int i4) {
        if (a(false)) {
            Cursor cursor = null;
            try {
                cursor = getReadableDatabase().query(true, "t_localnotification", f4459a, "ln_id=" + j4 + " and ln_type=" + i4, null, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                }
                return a(cursor);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                b(false);
            }
        }
        throw new Exception("open database failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] a() {
        /*
            r13 = this;
            java.lang.String r4 = "1"
            r10 = 0
            boolean r0 = r13.a(r10)
            r11 = 0
            if (r0 == 0) goto L91
            r12 = 1
            java.lang.String[] r3 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L81
            java.lang.String r0 = "ln_id"
            r3[r10] = r0     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L81
            android.database.sqlite.SQLiteDatabase r0 = r13.getReadableDatabase()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L81
            r1 = 1
            java.lang.String r2 = "t_localnotification"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L81
            if (r0 == 0) goto L43
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            if (r1 <= 0) goto L43
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            int[] r1 = new int[r1]     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6f
            r2 = 0
        L34:
            int r3 = r0.getInt(r10)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6f
            r1[r2] = r3     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6f
            int r2 = r2 + 1
            boolean r3 = r0.moveToNext()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6f
            if (r3 != 0) goto L34
            r11 = r1
        L43:
            boolean r1 = r13.a(r12)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            if (r1 == 0) goto L5c
            java.lang.String r1 = "delete from t_localnotification"
            android.database.sqlite.SQLiteDatabase r2 = r13.getWritableDatabase()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L58
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L58
            r1 = 1
            goto L5d
        L54:
            r1 = move-exception
            r11 = r0
            r0 = 1
            goto L73
        L58:
            r1 = r11
            r11 = r0
            r0 = 1
            goto L83
        L5c:
            r1 = 0
        L5d:
            if (r0 == 0) goto L62
            r0.close()
        L62:
            r13.b(r10)
            if (r1 == 0) goto L91
            r13.b(r12)
            goto L91
        L6b:
            r1 = move-exception
            r11 = r0
            goto L72
        L6e:
            r1 = r11
        L6f:
            r11 = r0
            goto L82
        L71:
            r1 = move-exception
        L72:
            r0 = 0
        L73:
            if (r11 == 0) goto L78
            r11.close()
        L78:
            r13.b(r10)
            if (r0 == 0) goto L80
            r13.b(r12)
        L80:
            throw r1
        L81:
            r1 = r11
        L82:
            r0 = 0
        L83:
            if (r11 == 0) goto L88
            r11.close()
        L88:
            r13.b(r10)
            if (r0 == 0) goto L90
            r13.b(r12)
        L90:
            r11 = r1
        L91:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.b.a():int[]");
    }

    public long b(long j4, int i4, int i5, int i6, String str, long j5, long j6) {
        if (a(true)) {
            try {
                String str2 = "ln_id=" + j4;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j4));
                contentValues.put("ln_count", Integer.valueOf(i4));
                contentValues.put("ln_remove", Integer.valueOf(i5));
                contentValues.put("ln_type", Integer.valueOf(i6));
                contentValues.put("ln_extra", cn.jpush.android.ad.c.c(str));
                contentValues.put("ln_trigger_time", Long.valueOf(j5));
                contentValues.put("ln_add_time", Long.valueOf(j6));
                return getWritableDatabase().update("t_localnotification", contentValues, str2, null);
            } catch (Exception unused) {
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
            Logger.v("LocalNotificationDb", "\u8868\u5df2\u7ecf\u5b58\u5728");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }
}
