package com.qq.e.comm.plugin.edgeanalytics.h.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.d;
import com.qq.e.comm.plugin.n0.e;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.d2;
import com.qq.e.comm.plugin.util.j0;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f43007c;

    private a(Context context) {
        super(new com.qq.e.comm.plugin.l.a(context), "ea_data.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context) {
        if (f43007c == null) {
            synchronized (a.class) {
                if (f43007c == null) {
                    f43007c = new a(context);
                }
            }
        }
        return f43007c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(e eVar) {
        try {
            return (int) getWritableDatabase().insert("t_events", null, a(eVar));
        } catch (Throwable th) {
            d1.a("GDTEAM_DB", th.getMessage(), th);
            return -1;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists t_events(id integer primary key autoincrement,aid text,adt integer,pid text,tid text,eid integer not null,erc integer,enc integer,pt integer,rt integer,ct integer,teid text,ts integer not null,nt integer not null,prid text,adext text,vd integer not null default 0,extra text)");
        sQLiteDatabase.execSQL("create table if not exists t_agg(id integer primary key autoincrement,adt integer,pid text,eid integer not null,erc integer,enc integer,pt integer,rt integer,ct integer,teid text,ts integer not null,va1 integer not null default 0,va2 integer not null default 0,nt integer not null,prid text,adext text,vd integer not null default 0,extra text)");
        sQLiteDatabase.execSQL("create table if not exists t_results(id integer primary key autoincrement,k text,v text,ph text,ts integer not null,extra text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (i4 != 1) {
            return;
        }
        a(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONArray b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        try {
            return a(getReadableDatabase().rawQuery(str, null));
        } catch (Throwable th) {
            d1.a("GDTEAM_DB", th.getMessage(), th);
            return new JSONArray();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("alter table t_events add column prid text");
            sQLiteDatabase.execSQL("alter table t_events add column vd integer not null default 0");
            sQLiteDatabase.execSQL("alter table t_events add column adext text");
            sQLiteDatabase.execSQL("alter table t_agg add column prid text");
            sQLiteDatabase.execSQL("alter table t_agg add column vd integer not null default 0");
            sQLiteDatabase.execSQL("alter table t_agg add column adext text");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    public int a(String str) {
        try {
            getWritableDatabase().execSQL(str);
            d1.a("GDTEAM_DB", "exeSQL %s=", str);
            return 0;
        } catch (Throwable th) {
            d1.a("GDTEAM_DB", th.getMessage(), th);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, String str2, String str3, long j4) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            contentValues.put("ph", str3);
            contentValues.put("ts", Long.valueOf(j4));
            long insert = writableDatabase.insert("t_results", null, contentValues);
            d1.a("GDTEAM_DB", "insert result id =" + insert);
            return (int) insert;
        } catch (Throwable th) {
            d1.a("GDTEAM_DB", th.getMessage(), th);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length <= 0) {
            return -1;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                d1.a("GDTEAM_DB", "insert table " + str);
                long j4 = -1;
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        j4 = writableDatabase.insert(str, null, a(optJSONObject));
                    }
                }
                writableDatabase.setTransactionSuccessful();
                int i5 = (int) j4;
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
                return i5;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    d1.a("GDTEAM_DB", th.getMessage(), th);
                    return -1;
                } finally {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private ContentValues a(JSONObject jSONObject) {
        ContentValues contentValues = new ContentValues();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof Integer) {
                contentValues.put(next, Integer.valueOf(((Integer) opt).intValue()));
            } else if (opt instanceof Long) {
                contentValues.put(next, Long.valueOf(((Long) opt).longValue()));
            } else if (opt instanceof String) {
                contentValues.put(next, (String) opt);
            } else if (opt instanceof Float) {
                contentValues.put(next, (Float) opt);
            } else if (opt instanceof Double) {
                contentValues.put(next, (Double) opt);
            }
        }
        return contentValues;
    }

    private ContentValues a(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("eid", Integer.valueOf(eVar.c()));
        contentValues.put("erc", Integer.valueOf(eVar.g()));
        contentValues.put("enc", Integer.valueOf(eVar.f()));
        contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
        com.qq.e.comm.plugin.n0.c a4 = eVar.a();
        if (a4 != null) {
            contentValues.put("pt", Integer.valueOf(a4.f()));
            contentValues.put("rt", Integer.valueOf(a4.g()));
            contentValues.put("ct", Integer.valueOf(a4.d()));
            contentValues.put("aid", a4.c());
            contentValues.put("adt", Integer.valueOf(a4.b()));
            contentValues.put("pid", a4.e());
            contentValues.put("tid", a4.i());
            contentValues.put("teid", a4.h());
            com.qq.e.comm.plugin.g0.e a5 = a4.a();
            if (a5 != null) {
                contentValues.put("prid", a5.s0());
                contentValues.put("vd", Integer.valueOf(a5.M0()));
                contentValues.put("adext", a5.P());
            }
        }
        contentValues.put("nt", Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().c().n().a()));
        d b4 = eVar.b();
        if (b4 != null) {
            contentValues.put("extra", b4.toString());
        }
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, String str2) {
        int i4 = -1;
        try {
            i4 = getWritableDatabase().delete(str, str2, null);
            d1.a("GDTEAM_DB", "delete by table " + str + " " + i4);
            return i4;
        } catch (Throwable th) {
            d1.a("GDTEAM_DB", th.getMessage(), th);
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int[] iArr) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            String[] strArr = {"t_events", "t_agg", "t_results"};
            if (iArr == null || iArr.length <= 0) {
                for (int i4 = 0; i4 < 3; i4++) {
                    writableDatabase.delete(strArr[i4], null, null);
                }
            } else {
                int min = Math.min(iArr.length, 3);
                for (int i5 = 0; i5 < min; i5++) {
                    if (iArr[i5] > 0) {
                        writableDatabase.delete(strArr[i5], "ts<" + d2.a(1 - iArr[i5]), null);
                    }
                }
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                d1.a("GDTEAM_DB", th.getMessage(), th);
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    private JSONArray a(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        if (cursor == null) {
            return jSONArray;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return jSONArray;
        }
        do {
            j0 j0Var = new j0();
            int columnCount = cursor.getColumnCount();
            for (int i4 = 0; i4 < columnCount; i4++) {
                String columnName = cursor.getColumnName(i4);
                int type = cursor.getType(i4);
                if (type == 1) {
                    j0Var.a(columnName, cursor.getLong(i4));
                } else if (type == 2) {
                    j0Var.a(columnName, cursor.getDouble(i4));
                } else if (type == 3) {
                    j0Var.a(columnName, cursor.getString(i4));
                }
            }
            jSONArray.put(j0Var.a());
        } while (cursor.moveToNext());
        cursor.close();
        return jSONArray;
    }
}
