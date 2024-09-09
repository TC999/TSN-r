package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/* compiled from: AdIntervalFreqctlRepertoryImpl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d implements c<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g> {

    /* renamed from: a  reason: collision with root package name */
    private final h f561a;

    public d(Context context) {
        this.f561a = h.a(context);
    }

    private void c(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar) {
        a(gVar.b());
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit_id", gVar.b());
        contentValues.put("waterfall_show_rules_version", gVar.c());
        contentValues.put("waterfall_timing_mode", Integer.valueOf(gVar.d()));
        contentValues.put("waterfall_show_freqctl_rules", gVar.f());
        this.f561a.a().a("show_freqctl", (String) null, contentValues);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.g
    public synchronized bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g b(String str) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar;
        Cursor a4 = this.f561a.a().a("show_freqctl", new String[]{"rit_id", "waterfall_show_rules_version", "waterfall_timing_mode", "waterfall_show_freqctl_rules"}, "rit_id=?", new String[]{str}, null, null, null, null);
        gVar = null;
        if (a4 != null) {
            if (a4.getCount() > 0) {
                a4.moveToNext();
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar2 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g(a4.getString(a4.getColumnIndex("rit_id")), a4.getString(a4.getColumnIndex("waterfall_show_rules_version")), a4.getInt(a4.getColumnIndex("waterfall_timing_mode")), a4.getString(a4.getColumnIndex("waterfall_show_freqctl_rules")));
                a4.close();
                gVar = gVar2;
            } else {
                a4.close();
            }
        }
        return gVar;
    }

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS show_freqctl (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit_id TEXT UNIQUE,waterfall_show_rules_version TEXT , waterfall_timing_mode INTEGER default 0 ,waterfall_show_freqctl_rules TEXT)";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.g
    public synchronized void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar) {
        if (gVar != null) {
            try {
                a(gVar.b());
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit_id", gVar.b());
                contentValues.put("waterfall_show_rules_version", gVar.c());
                contentValues.put("waterfall_timing_mode", Integer.valueOf(gVar.d()));
                contentValues.put("waterfall_show_freqctl_rules", gVar.g());
                this.f561a.a().a("show_freqctl", (String) null, contentValues);
            } catch (Exception unused) {
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c
    public synchronized void b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar) {
        if (gVar != null) {
            c(gVar);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.g
    public synchronized void a(String str) {
        this.f561a.a().a("DELETE FROM show_freqctl WHERE rit_id=" + str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c
    public synchronized void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar, String str, int i4) {
        if (gVar != null) {
            c(gVar);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c
    public synchronized void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g gVar, String str, long j4) {
        if (gVar != null) {
            c(gVar);
        }
    }
}
