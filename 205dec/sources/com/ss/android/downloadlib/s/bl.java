package com.ss.android.downloadlib.s;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bl f48937a;
    private SQLiteDatabase ok;

    private bl() {
        try {
            this.ok = new a(r.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.n.bl.ok().ok(th, "ClickEventHelper");
        }
    }

    public static bl ok() {
        if (f48937a == null) {
            synchronized (bl.class) {
                if (f48937a == null) {
                    f48937a = new bl();
                }
            }
        }
        return f48937a;
    }

    public boolean a() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("click_event_switch", 0) == 1;
    }

    public boolean bl() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("click_event_switch", 0) == 2;
    }

    private void bl(long j4, String str) {
        SQLiteDatabase sQLiteDatabase = this.ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j4 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.ok.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j4), optString});
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean a(long j4, String str) {
        SQLiteDatabase sQLiteDatabase = this.ok;
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
                cursor = this.ok.query("click_event", a.ok, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j4), optString}, null, null, null, null);
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

    public void ok(long j4, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.ok;
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
        this.ok.insert("click_event", null, contentValues);
        bl(j4, str);
    }
}
