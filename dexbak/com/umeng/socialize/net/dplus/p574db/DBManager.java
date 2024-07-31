package com.umeng.socialize.net.dplus.p574db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.socialize.utils.ContextUtil;
import org.json.JSONObject;

/* renamed from: com.umeng.socialize.net.dplus.db.DBManager */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DBManager {

    /* renamed from: a */
    private static DBManager f39579a;

    /* renamed from: b */
    private static StandardDBHelper f39580b;

    private DBManager() {
        f39580b = new StandardDBHelper(ContextUtil.getContext());
    }

    public static synchronized DBManager get(Context context) {
        DBManager dBManager;
        synchronized (DBManager.class) {
            if (f39579a == null) {
                f39579a = new DBManager();
            }
            dBManager = f39579a;
        }
        return dBManager;
    }

    public synchronized void closeDatabase() {
        f39580b.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r0 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void delete(java.util.ArrayList<java.lang.Integer> r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p574db.DBManager.f39580b     // Catch: java.lang.Throwable -> L41
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L41
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L41
            r1 = 0
        Lc:
            int r2 = r5.size()     // Catch: java.lang.Throwable -> L41
            if (r1 >= r2) goto L3a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            r2.<init>()     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "delete from "
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            r2.append(r6)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = " where Id='"
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.Object r3 = r5.get(r1)     // Catch: java.lang.Throwable -> L41
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "' "
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L41
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L41
            int r1 = r1 + 1
            goto Lc
        L3a:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L41
        L3d:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L44
            goto L44
        L41:
            if (r0 == 0) goto L44
            goto L3d
        L44:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p574db.DBManager.delete(java.util.ArrayList, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (r0 != null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void deleteTable(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.p574db.DBManager.f39580b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r1.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "DELETE FROM "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2b
            r1.append(r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = ";"
            r1.append(r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L2b
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L2b
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2b
        L27:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L2e
            goto L2e
        L2b:
            if (r0 == 0) goto L2e
            goto L27
        L2e:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p574db.DBManager.deleteTable(java.lang.String):void");
    }

    public synchronized void insertAuth(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f39580b.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConfig.VALUE, jSONObject.toString());
            writableDatabase.insert("auth", null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable unused3) {
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public synchronized void insertDau(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f39580b.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConfig.VALUE, jSONObject.toString());
            writableDatabase.insert("dau", null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable unused3) {
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public synchronized void insertS_E(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f39580b.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConfig.VALUE, jSONObject.toString());
            writableDatabase.insert("s_e", null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable unused3) {
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public synchronized void insertStats(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f39580b.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConfig.VALUE, jSONObject.toString());
            writableDatabase.insert("stats", null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable unused3) {
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public synchronized void insertUserInfo(JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        if (jSONObject == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = f39580b.getWritableDatabase();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConfig.VALUE, jSONObject.toString());
            writableDatabase.insert("userinfo", null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable unused3) {
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (r3 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONArray select(java.lang.String r13, java.util.ArrayList<java.lang.Integer> r14, double r15, boolean r17) throws org.json.JSONException {
        /*
            r12 = this;
            r0 = r14
            monitor-enter(r12)
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L85
            r1.<init>()     // Catch: java.lang.Throwable -> L85
            r2 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r3 = com.umeng.socialize.net.dplus.p574db.DBManager.f39580b     // Catch: java.lang.Throwable -> L6a org.json.JSONException -> L75
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L6a org.json.JSONException -> L75
            r3.beginTransaction()     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            r5 = r13
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
        L1d:
            boolean r4 = r2.moveToNext()     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            if (r4 == 0) goto L5e
            r4 = 0
            int r4 = r2.getInt(r4)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            r5 = 1
            java.lang.String r5 = r2.getString(r5)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            if (r17 == 0) goto L44
            java.lang.String r6 = r1.toString()     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            byte[] r6 = r6.getBytes()     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            int r6 = r6.length     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            byte[] r7 = r5.getBytes()     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            int r7 = r7.length     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            int r6 = r6 + r7
            double r6 = (double) r6     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            int r8 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r8 <= 0) goto L44
            goto L5e
        L44:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            r6.<init>(r5)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            r1.put(r6)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            boolean r5 = r14.contains(r5)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            if (r5 != 0) goto L1d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            r14.add(r4)     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            goto L1d
        L5e:
            r3.setTransactionSuccessful()     // Catch: org.json.JSONException -> L68 java.lang.Throwable -> L6b
            r2.close()     // Catch: java.lang.Throwable -> L73
        L64:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L73
            goto L73
        L68:
            r0 = move-exception
            goto L77
        L6a:
            r3 = r2
        L6b:
            if (r2 == 0) goto L70
            r2.close()     // Catch: java.lang.Throwable -> L73
        L70:
            if (r3 == 0) goto L73
            goto L64
        L73:
            monitor-exit(r12)
            return r1
        L75:
            r0 = move-exception
            r3 = r2
        L77:
            throw r0     // Catch: java.lang.Throwable -> L78
        L78:
            r0 = move-exception
            r1 = r0
            if (r2 == 0) goto L7f
            r2.close()     // Catch: java.lang.Throwable -> L84
        L7f:
            if (r3 == 0) goto L84
            r3.endTransaction()     // Catch: java.lang.Throwable -> L84
        L84:
            throw r1     // Catch: java.lang.Throwable -> L85
        L85:
            r0 = move-exception
            monitor-exit(r12)
            goto L89
        L88:
            throw r0
        L89:
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.p574db.DBManager.select(java.lang.String, java.util.ArrayList, double, boolean):org.json.JSONArray");
    }
}
