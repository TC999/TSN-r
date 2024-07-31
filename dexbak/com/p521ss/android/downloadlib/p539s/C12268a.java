package com.p521ss.android.downloadlib.p539s;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.C13131bm;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* renamed from: com.ss.android.downloadlib.s.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12268a extends SQLiteOpenHelper {

    /* renamed from: ok */
    static final String[] f34610ok = {C13131bm.f37927d, MediationConstant.EXTRA_ADID, "req_id", RtspHeaders.Values.TIME};

    public C12268a(@Nullable Context context) {
        super(context, "click_event", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
        onCreate(sQLiteDatabase);
    }
}
