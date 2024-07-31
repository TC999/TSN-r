package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalPacingBean;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdIntervalPacingRepertoryImpl implements AdIntervalPacingRepertory<IntervalPacingBean> {

    /* renamed from: a */
    private final DBAdapter f569a;

    public AdIntervalPacingRepertoryImpl(Context context) {
        this.f569a = DBAdapter.m59403a(context);
    }

    /* renamed from: a */
    public static String m59410a() {
        return "CREATE TABLE IF NOT EXISTS show_pacing (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit_id TEXT UNIQUE,waterfall_show_rules_version TEXT , waterfall_timing_mode INTEGER default 0 ,waterfall_show_pacing TEXT , waterfall_show_pacing_rule_id TEXT , waterfall_show_time TEXT)";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.BaseAdIntervalRepertory
    /* renamed from: b */
    public synchronized IntervalPacingBean mo59404b(String str) {
        IntervalPacingBean intervalPacingBean;
        Cursor m59394a = this.f569a.m59402a().m59394a("show_pacing", new String[]{"rit_id", "waterfall_show_rules_version", "waterfall_timing_mode", "waterfall_show_pacing", "waterfall_show_pacing_rule_id", "waterfall_show_time"}, "rit_id=?", new String[]{str}, null, null, null, null);
        intervalPacingBean = null;
        if (m59394a != null) {
            if (m59394a.getCount() > 0) {
                m59394a.moveToNext();
                try {
                    intervalPacingBean = m59409a(m59394a);
                } catch (Throwable unused) {
                }
                m59394a.close();
            } else {
                m59394a.close();
            }
        }
        return intervalPacingBean;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.BaseAdIntervalRepertory
    /* renamed from: a */
    public synchronized void mo59406a(IntervalPacingBean intervalPacingBean) {
        if (intervalPacingBean != null) {
            try {
                mo59405a(intervalPacingBean.m59623b());
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit_id", intervalPacingBean.m59623b());
                contentValues.put("waterfall_show_rules_version", intervalPacingBean.m59622c());
                contentValues.put("waterfall_timing_mode", Integer.valueOf(intervalPacingBean.m59621d()));
                contentValues.put("waterfall_show_pacing", intervalPacingBean.m59598e() + "");
                contentValues.put("waterfall_show_pacing_rule_id", intervalPacingBean.m59597f());
                contentValues.put("waterfall_show_time", intervalPacingBean.m59596g() + "");
                this.f569a.m59402a().m59396a("show_pacing", (String) null, contentValues);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private IntervalPacingBean m59409a(Cursor cursor) {
        return new IntervalPacingBean(cursor.getString(cursor.getColumnIndex("rit_id")), cursor.getString(cursor.getColumnIndex("waterfall_show_rules_version")), cursor.getInt(cursor.getColumnIndex("waterfall_timing_mode")), cursor.getString(cursor.getColumnIndex("waterfall_show_pacing")), cursor.getString(cursor.getColumnIndex("waterfall_show_pacing_rule_id")), cursor.getString(cursor.getColumnIndex("waterfall_show_time")));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.BaseAdIntervalRepertory
    /* renamed from: a */
    public synchronized void mo59405a(String str) {
        this.f569a.m59402a().m59397a("DELETE FROM show_pacing WHERE rit_id=" + str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalPacingRepertory
    /* renamed from: a */
    public synchronized void mo59407a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("show_pacing");
        sb.append(" SET ");
        sb.append("waterfall_show_time");
        sb.append(" = ");
        sb.append(j);
        sb.append(" WHERE ");
        sb.append("rit_id=" + str);
        this.f569a.m59402a().m59397a(sb.toString());
    }
}
