package xyz.adscope.common.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import xyz.adscope.common.db.inter.IDataBase;
import xyz.adscope.common.db.storage.DatabaseHelper;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DataBaseManager<T> implements IDataBase {

    /* renamed from: a  reason: collision with root package name */
    public DatabaseHelper f64584a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f64585b;

    /* renamed from: c  reason: collision with root package name */
    public CommonDataBase f64586c = new CommonDataBase();

    /* renamed from: d  reason: collision with root package name */
    public String f64587d;

    /* renamed from: e  reason: collision with root package name */
    public Class<T> f64588e;

    public DataBaseManager(Context context) {
        this.f64584a = DatabaseHelper.getInstance(context);
        this.f64585b = this.f64584a.getWritableDatabase();
    }

    public final synchronized void a() {
        if (!a(this.f64587d)) {
            b();
        }
    }

    public final synchronized boolean a(String str) {
        return this.f64586c.isTableExists(this.f64585b, str);
    }

    public final synchronized void b() {
        this.f64586c.createTable(this.f64585b, this.f64587d, this.f64588e, null);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized int delete(Object obj) {
        a();
        return this.f64586c.deleteTable(this.f64585b, this.f64587d, " = ? ", obj);
    }

    public synchronized int deleteOutTime(Object obj) {
        a();
        return this.f64586c.deleteTable(this.f64585b, this.f64587d, " < ? ", obj);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized Long insert(Object obj) {
        a();
        return Long.valueOf(this.f64586c.insertTable(this.f64585b, this.f64587d, obj));
    }

    public synchronized String query(Object obj, String[] strArr, String str, String str2) {
        a();
        return this.f64586c.querySingleData(this.f64585b, this.f64587d, obj, strArr, " = ? ", str, str2);
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public List query(Object obj) {
        a();
        return this.f64586c.queryTable(this.f64585b, this.f64587d, this.f64588e, obj, " = ? ");
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public List query(Object obj, String str, String str2) {
        a();
        return this.f64586c.querySingleTable(this.f64585b, this.f64587d, this.f64588e, obj, " = ? ", str, str2);
    }

    public synchronized List query(String str, String str2) {
        a();
        return this.f64586c.queryTable(this.f64585b, this.f64587d, this.f64588e, null, null, str, str2);
    }

    public void setTableNameAndModel(String str, Class cls) {
        this.f64587d = str;
        this.f64588e = cls;
    }

    public synchronized int update(Object obj, ContentValues contentValues) {
        this.f64586c.updateTable(this.f64585b, this.f64587d, contentValues, " = ? ", obj);
        return 0;
    }

    @Override // xyz.adscope.common.db.inter.IDataBase
    public synchronized int update(Object obj, Object obj2) {
        return 0;
    }
}
