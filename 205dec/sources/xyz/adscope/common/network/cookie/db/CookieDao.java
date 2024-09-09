package xyz.adscope.common.network.cookie.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.common.network.cookie.Cookie;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CookieDao implements Field {

    /* renamed from: a  reason: collision with root package name */
    public SQLHelper f64911a;

    public CookieDao(Context context) {
        this.f64911a = new SQLHelper(context);
    }

    public final SQLiteDatabase a() {
        return this.f64911a.getReadableDatabase();
    }

    public final void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public int count() {
        return count("SELECT COUNT(_ID) FROM COOKIES_TABLE");
    }

    public int count(String str) {
        SQLiteDatabase a4 = a();
        Cursor rawQuery = a4.rawQuery(str, null);
        try {
            return rawQuery.moveToNext() ? rawQuery.getInt(0) : 0;
        } finally {
            a(rawQuery);
            a(a4);
        }
    }

    public boolean delete(String str) {
        SQLiteDatabase a4 = a();
        String str2 = "DELETE FROM COOKIES_TABLE WHERE " + str;
        a4.beginTransaction();
        try {
            a4.execSQL(str2);
            a4.setTransactionSuccessful();
            a4.endTransaction();
            a(a4);
            return true;
        } catch (SQLException unused) {
            a4.endTransaction();
            a(a4);
            return false;
        } catch (Throwable th) {
            a4.endTransaction();
            a(a4);
            throw th;
        }
    }

    public boolean delete(List<Cookie> list) {
        ArrayList arrayList = new ArrayList();
        for (Cookie cookie : list) {
            arrayList.add(Long.valueOf(cookie.getId()));
        }
        return delete(Where.newBuilder().in(Field.ID, arrayList).build().toString());
    }

    public boolean deleteAll() {
        return delete("1=1");
    }

    public List<Cookie> getAll() {
        return getList(null, null, null, null);
    }

    public List<Cookie> getList(String str) {
        SQLiteDatabase a4 = a();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = a4.rawQuery(str, null);
        while (rawQuery.moveToNext()) {
            Cookie cookie = new Cookie();
            cookie.setId(rawQuery.getInt(rawQuery.getColumnIndex(Field.ID)));
            cookie.setUrl(rawQuery.getString(rawQuery.getColumnIndex(Field.URL)));
            cookie.setName(rawQuery.getString(rawQuery.getColumnIndex(Field.NAME)));
            cookie.setValue(rawQuery.getString(rawQuery.getColumnIndex(Field.VALUE)));
            cookie.setComment(rawQuery.getString(rawQuery.getColumnIndex(Field.COMMENT)));
            cookie.setCommentURL(rawQuery.getString(rawQuery.getColumnIndex(Field.COMMENT_URL)));
            cookie.setDiscard("true".equals(rawQuery.getString(rawQuery.getColumnIndex(Field.DISCARD))));
            cookie.setDomain(rawQuery.getString(rawQuery.getColumnIndex(Field.DOMAIN)));
            cookie.setExpiry(rawQuery.getLong(rawQuery.getColumnIndex(Field.EXPIRY)));
            cookie.setPath(rawQuery.getString(rawQuery.getColumnIndex(Field.PATH)));
            cookie.setPortList(rawQuery.getString(rawQuery.getColumnIndex(Field.PORT_LIST)));
            cookie.setSecure("true".equals(rawQuery.getString(rawQuery.getColumnIndex(Field.SECURE))));
            cookie.setVersion(rawQuery.getInt(rawQuery.getColumnIndex(Field.VERSION)));
            arrayList.add(cookie);
        }
        a(rawQuery);
        a(a4);
        return arrayList;
    }

    public List<Cookie> getList(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("*");
        sb.append(" FROM ");
        sb.append(Field.TABLE_NAME);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" ORDER BY ");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" LIMIT ");
            sb.append(str3);
            if (!TextUtils.isEmpty(str4)) {
                sb.append(" OFFSET ");
                sb.append(str4);
            }
        }
        return getList(sb.toString());
    }

    public long replace(Cookie cookie) {
        SQLiteDatabase a4 = a();
        a4.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Field.URL, cookie.getUrl());
        contentValues.put(Field.NAME, cookie.getName());
        contentValues.put(Field.VALUE, cookie.getValue());
        contentValues.put(Field.COMMENT, cookie.getComment());
        contentValues.put(Field.COMMENT_URL, cookie.getCommentURL());
        contentValues.put(Field.DISCARD, String.valueOf(cookie.isDiscard()));
        contentValues.put(Field.DOMAIN, cookie.getDomain());
        contentValues.put(Field.EXPIRY, Long.valueOf(cookie.getExpiry()));
        contentValues.put(Field.PATH, cookie.getPath());
        contentValues.put(Field.PORT_LIST, cookie.getPortList());
        contentValues.put(Field.SECURE, String.valueOf(cookie.isSecure()));
        contentValues.put(Field.VERSION, Integer.valueOf(cookie.getVersion()));
        try {
            long replace = a4.replace(Field.TABLE_NAME, null, contentValues);
            a4.setTransactionSuccessful();
            a4.endTransaction();
            a(a4);
            return replace;
        } catch (Exception unused) {
            a4.endTransaction();
            a(a4);
            return -1L;
        } catch (Throwable th) {
            a4.endTransaction();
            a(a4);
            throw th;
        }
    }
}
