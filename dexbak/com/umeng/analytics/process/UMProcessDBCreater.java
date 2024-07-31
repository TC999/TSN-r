package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.UMDBUtils;
import java.io.File;

/* renamed from: com.umeng.analytics.process.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class UMProcessDBCreater extends SQLiteOpenHelper {
    UMProcessDBCreater(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static UMProcessDBCreater m14129a(Context context, String str) {
        String m14127b = m14127b(context, str);
        DBConstant.f38512h.equals(str);
        return new UMProcessDBCreater(context, m14127b, null, 1);
    }

    /* renamed from: b */
    public static String m14127b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = DBConstant.f38512h;
        }
        String str2 = UMDBUtils.m14349b(context) + DBConstant.f38505a;
        if (DBConstant.f38512h.equals(str)) {
            str2 = UMDBUtils.m14349b(context);
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(str2 + DBConstant.f38509e, str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m14128a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: a */
    private void m14128a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: a */
    public static String m14130a(Context context) {
        return UMDBUtils.m14349b(context) + DBConstant.f38505a;
    }
}
