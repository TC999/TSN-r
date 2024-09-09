package xyz.adscope.ad.tool.persistent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import xyz.adscope.common.db.CommonDataBase;
import xyz.adscope.common.db.inter.IDataBase;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPDataBaseManager<T> implements IDataBase {
    private static final String conditionEqual = " = ? ";
    private static final String conditionLessThan = " < ? ";
    private ASNPSqliteOpenHelper ampsSqliteOpenHelper;
    private CommonDataBase commonDataBase = new CommonDataBase();
    private SQLiteDatabase sqLiteDatabase;
    private Class<T> tClass;
    private String tableName;

    public ASNPDataBaseManager(Context context) {
        this.ampsSqliteOpenHelper = ASNPSqliteOpenHelper.getInstance(context);
        ASNPSqliteOpenHelper aSNPSqliteOpenHelper = this.ampsSqliteOpenHelper;
        if (aSNPSqliteOpenHelper != null) {
            this.sqLiteDatabase = aSNPSqliteOpenHelper.getWritableDatabase();
        }
    }

    private synchronized void checkTable() {
        if (!sqlTableIsExist(this.tableName)) {
            createTable();
        }
    }

    private synchronized void createTable() {
        this.commonDataBase.createTable(this.sqLiteDatabase, this.tableName, this.tClass, null);
    }

    private synchronized boolean sqlTableIsExist(String str) {
        return this.commonDataBase.isTableExists(this.sqLiteDatabase, str);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized int delete(Object obj) {
        checkTable();
        return this.commonDataBase.deleteTable(this.sqLiteDatabase, this.tableName, conditionEqual, obj);
    }

    public synchronized int deleteFixedCountData(int i4) {
        checkTable();
        try {
            this.sqLiteDatabase.execSQL("DELETE FROM " + this.tableName + " WHERE _id IN (SELECT _id FROM " + this.tableName + " ORDER BY _id ASC LIMIT " + i4 + ");");
            this.sqLiteDatabase.close();
        } catch (Exception unused) {
        }
        return 0;
    }

    public synchronized int deleteOutTime(Object obj) {
        checkTable();
        return this.commonDataBase.deleteTable(this.sqLiteDatabase, this.tableName, conditionLessThan, obj);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized Long insert(Object obj) {
        checkTable();
        return Long.valueOf(this.commonDataBase.insertTable(this.sqLiteDatabase, this.tableName, obj));
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public List query(Object obj) {
        checkTable();
        return this.commonDataBase.queryTable(this.sqLiteDatabase, this.tableName, this.tClass, obj, conditionEqual);
    }

    public void setTableNameAndModel(String str, Class cls) {
        this.tableName = str;
        this.tClass = cls;
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized int update(Object obj, Object obj2) {
        return 0;
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public List query(Object obj, String str, String str2) {
        checkTable();
        return this.commonDataBase.querySingleTable(this.sqLiteDatabase, this.tableName, this.tClass, obj, conditionEqual, str, str2);
    }

    public synchronized List query(String str, String str2) {
        checkTable();
        return this.commonDataBase.queryTable(this.sqLiteDatabase, this.tableName, this.tClass, null, null, str, str2);
    }

    public synchronized String query(Object obj, String[] strArr, String str, String str2) {
        checkTable();
        return this.commonDataBase.querySingleData(this.sqLiteDatabase, this.tableName, obj, strArr, conditionEqual, str, str2);
    }
}
