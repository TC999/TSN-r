package com.ss.android.downloadlib.sr;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: w  reason: collision with root package name */
    private static volatile xv f48944w;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f48945c;

    private xv() {
        try {
            this.f48945c = new w(k.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.ux.xv.c().c(th, "ClickEventHelper");
        }
    }

    public static xv c() {
        if (f48944w == null) {
            synchronized (xv.class) {
                if (f48944w == null) {
                    f48944w = new xv();
                }
            }
        }
        return f48944w;
    }

    public boolean w() {
        return com.ss.android.socialbase.downloader.r.c.xv().c("click_event_switch", 0) == 1;
    }

    public boolean xv() {
        return com.ss.android.socialbase.downloader.r.c.xv().c("click_event_switch", 0) == 2;
    }

    private void xv(long j4, String str) {
        SQLiteDatabase sQLiteDatabase = this.f48945c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j4 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f48945c.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j4), optString});
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean w(long j4, String str) {
        SQLiteDatabase sQLiteDatabase = this.f48945c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j4 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f48945c.query("click_event", w.f48943c, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j4), optString}, null, null, null, null);
                boolean z3 = cursor.getCount() > 0;
                cursor.close();
                return z3;
            } catch (Exception e4) {
                e4.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void c(long j4, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f48945c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j4 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString("req_id");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_id", Long.valueOf(j4));
        contentValues.put("req_id", optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.f48945c.insert("click_event", null, contentValues);
        xv(j4, str);
    }
}
