package com.bytedance.c.w.w.w;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.c.w.b;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final String f26639a = "_id";

    /* renamed from: b  reason: collision with root package name */
    protected final String f26640b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str) {
        this.f26640b = str;
    }

    protected abstract ContentValues a(T t3);

    protected abstract HashMap<String, String> b();

    public void c(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.f26640b);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> b4 = b();
            if (b4 != null) {
                for (String str : b4.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(b4.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t3) {
        if (sQLiteDatabase == null || t3 == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f26640b, null, a(t3));
        } catch (Exception e4) {
            b.k.c(e4);
        }
    }
}
