package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalFreqctlBean;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdIntervalFreqctlRepertoryImpl implements AdIntervalFreqctlRepertory<IntervalFreqctlBean> {

    /* renamed from: a */
    private final DBAdapter f568a;

    public AdIntervalFreqctlRepertoryImpl(Context context) {
        this.f568a = DBAdapter.m59403a(context);
    }

    /* renamed from: c */
    private void m59411c(IntervalFreqctlBean intervalFreqctlBean) {
        mo59405a(intervalFreqctlBean.m59623b());
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit_id", intervalFreqctlBean.m59623b());
        contentValues.put("waterfall_show_rules_version", intervalFreqctlBean.m59622c());
        contentValues.put("waterfall_timing_mode", Integer.valueOf(intervalFreqctlBean.m59621d()));
        contentValues.put("waterfall_show_freqctl_rules", intervalFreqctlBean.m59603f());
        this.f568a.m59402a().m59396a("show_freqctl", (String) null, contentValues);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.BaseAdIntervalRepertory
    /* renamed from: b */
    public synchronized IntervalFreqctlBean mo59404b(String str) {
        IntervalFreqctlBean intervalFreqctlBean;
        Cursor m59394a = this.f568a.m59402a().m59394a("show_freqctl", new String[]{"rit_id", "waterfall_show_rules_version", "waterfall_timing_mode", "waterfall_show_freqctl_rules"}, "rit_id=?", new String[]{str}, null, null, null, null);
        intervalFreqctlBean = null;
        if (m59394a != null) {
            if (m59394a.getCount() > 0) {
                m59394a.moveToNext();
                IntervalFreqctlBean intervalFreqctlBean2 = new IntervalFreqctlBean(m59394a.getString(m59394a.getColumnIndex("rit_id")), m59394a.getString(m59394a.getColumnIndex("waterfall_show_rules_version")), m59394a.getInt(m59394a.getColumnIndex("waterfall_timing_mode")), m59394a.getString(m59394a.getColumnIndex("waterfall_show_freqctl_rules")));
                m59394a.close();
                intervalFreqctlBean = intervalFreqctlBean2;
            } else {
                m59394a.close();
            }
        }
        return intervalFreqctlBean;
    }

    /* renamed from: a */
    public static String m59419a() {
        return "CREATE TABLE IF NOT EXISTS show_freqctl (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit_id TEXT UNIQUE,waterfall_show_rules_version TEXT , waterfall_timing_mode INTEGER default 0 ,waterfall_show_freqctl_rules TEXT)";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.BaseAdIntervalRepertory
    /* renamed from: a */
    public synchronized void mo59406a(IntervalFreqctlBean intervalFreqctlBean) {
        if (intervalFreqctlBean != null) {
            try {
                mo59405a(intervalFreqctlBean.m59623b());
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit_id", intervalFreqctlBean.m59623b());
                contentValues.put("waterfall_show_rules_version", intervalFreqctlBean.m59622c());
                contentValues.put("waterfall_timing_mode", Integer.valueOf(intervalFreqctlBean.m59621d()));
                contentValues.put("waterfall_show_freqctl_rules", intervalFreqctlBean.m59602g());
                this.f568a.m59402a().m59396a("show_freqctl", (String) null, contentValues);
            } catch (Exception unused) {
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalFreqctlRepertory
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public synchronized void mo59412b(IntervalFreqctlBean intervalFreqctlBean) {
        if (intervalFreqctlBean != null) {
            m59411c(intervalFreqctlBean);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.BaseAdIntervalRepertory
    /* renamed from: a */
    public synchronized void mo59405a(String str) {
        this.f568a.m59402a().m59397a("DELETE FROM show_freqctl WHERE rit_id=" + str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalFreqctlRepertory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo59415a(IntervalFreqctlBean intervalFreqctlBean, String str, int i) {
        if (intervalFreqctlBean != null) {
            m59411c(intervalFreqctlBean);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalFreqctlRepertory
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo59414a(IntervalFreqctlBean intervalFreqctlBean, String str, long j) {
        if (intervalFreqctlBean != null) {
            m59411c(intervalFreqctlBean);
        }
    }
}
