package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;

/* compiled from: AdIntervalPacingRepertoryImpl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f implements e<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h> {

    /* renamed from: a  reason: collision with root package name */
    private final h f562a;

    public f(Context context) {
        this.f562a = h.a(context);
    }

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS show_pacing (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit_id TEXT UNIQUE,waterfall_show_rules_version TEXT , waterfall_timing_mode INTEGER default 0 ,waterfall_show_pacing TEXT , waterfall_show_pacing_rule_id TEXT , waterfall_show_time TEXT)";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.g
    public synchronized bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h b(String str) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h hVar;
        Cursor a4 = this.f562a.a().a("show_pacing", new String[]{"rit_id", "waterfall_show_rules_version", "waterfall_timing_mode", "waterfall_show_pacing", "waterfall_show_pacing_rule_id", "waterfall_show_time"}, "rit_id=?", new String[]{str}, null, null, null, null);
        hVar = null;
        if (a4 != null) {
            if (a4.getCount() > 0) {
                a4.moveToNext();
                try {
                    hVar = a(a4);
                } catch (Throwable unused) {
                }
                a4.close();
            } else {
                a4.close();
            }
        }
        return hVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.g
    public synchronized void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h hVar) {
        if (hVar != null) {
            try {
                a(hVar.b());
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit_id", hVar.b());
                contentValues.put("waterfall_show_rules_version", hVar.c());
                contentValues.put("waterfall_timing_mode", Integer.valueOf(hVar.d()));
                contentValues.put("waterfall_show_pacing", hVar.e() + "");
                contentValues.put("waterfall_show_pacing_rule_id", hVar.f());
                contentValues.put("waterfall_show_time", hVar.g() + "");
                this.f562a.a().a("show_pacing", (String) null, contentValues);
            } catch (Exception unused) {
            }
        }
    }

    private bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h a(Cursor cursor) {
        return new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h(cursor.getString(cursor.getColumnIndex("rit_id")), cursor.getString(cursor.getColumnIndex("waterfall_show_rules_version")), cursor.getInt(cursor.getColumnIndex("waterfall_timing_mode")), cursor.getString(cursor.getColumnIndex("waterfall_show_pacing")), cursor.getString(cursor.getColumnIndex("waterfall_show_pacing_rule_id")), cursor.getString(cursor.getColumnIndex("waterfall_show_time")));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.g
    public synchronized void a(String str) {
        this.f562a.a().a("DELETE FROM show_pacing WHERE rit_id=" + str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.e
    public synchronized void a(String str, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("show_pacing");
        sb.append(" SET ");
        sb.append("waterfall_show_time");
        sb.append(" = ");
        sb.append(j4);
        sb.append(" WHERE ");
        sb.append("rit_id=" + str);
        this.f562a.a().a(sb.toString());
    }
}
