package com.p521ss.android.downloadlib.p539s;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.s.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12269bl {

    /* renamed from: a */
    private static volatile C12269bl f34611a;

    /* renamed from: ok */
    private SQLiteDatabase f34612ok;

    private C12269bl() {
        try {
            this.f34612ok = new C12268a(C12128r.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            C12235bl.m18640ok().mo18637ok(th, "ClickEventHelper");
        }
    }

    /* renamed from: ok */
    public static C12269bl m18545ok() {
        if (f34611a == null) {
            synchronized (C12269bl.class) {
                if (f34611a == null) {
                    f34611a = new C12269bl();
                }
            }
        }
        return f34611a;
    }

    /* renamed from: a */
    public boolean m18549a() {
        return C12534ok.m17605bl().m17593ok("click_event_switch", 0) == 1;
    }

    /* renamed from: bl */
    public boolean m18547bl() {
        return C12534ok.m17605bl().m17593ok("click_event_switch", 0) == 2;
    }

    /* renamed from: bl */
    private void m18546bl(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f34612ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f34612ok.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean m18548a(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f34612ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f34612ok.query("click_event", C12268a.f34610ok, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
                boolean z = cursor.getCount() > 0;
                cursor.close();
                return z;
            } catch (Exception e) {
                e.printStackTrace();
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

    /* renamed from: ok */
    public void m18544ok(long j, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f34612ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString("req_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
        contentValues.put("req_id", optString);
        contentValues.put(RtspHeaders.Values.TIME, Long.valueOf(System.currentTimeMillis()));
        this.f34612ok.insert("click_event", null, contentValues);
        m18546bl(j, str);
    }
}
