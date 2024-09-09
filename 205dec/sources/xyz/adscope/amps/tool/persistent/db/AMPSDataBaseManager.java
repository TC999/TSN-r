package xyz.adscope.amps.tool.persistent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import xyz.adscope.common.db.CommonDataBase;
import xyz.adscope.common.db.inter.IDataBase;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSDataBaseManager<T> implements IDataBase {
    private static final String conditionEqual = " = ? ";
    private static final String conditionLessThan = " < ? ";
    private AMPSSqliteOpenHelper ampsSqliteOpenHelper;
    private CommonDataBase commonDataBase = new CommonDataBase();
    private SQLiteDatabase sqLiteDatabase;
    private Class<T> tClass;
    private String tableName;

    public AMPSDataBaseManager(Context context) {
        this.ampsSqliteOpenHelper = AMPSSqliteOpenHelper.getInstance(context);
        this.sqLiteDatabase = this.ampsSqliteOpenHelper.getWritableDatabase();
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
}
