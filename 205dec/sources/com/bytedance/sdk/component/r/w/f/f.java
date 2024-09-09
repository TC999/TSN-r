package com.bytedance.sdk.component.r.w.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.r.c.ux f30082c;

    /* renamed from: w  reason: collision with root package name */
    private Context f30083w;

    public f(com.bytedance.sdk.component.r.c.ux uxVar) {
        this.f30083w = uxVar.getContext();
        this.f30082c = uxVar;
    }

    public static String w() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.r.w.f.ux
    public List<sr> c() {
        LinkedList linkedList = new LinkedList();
        Cursor query = com.bytedance.sdk.component.r.w.c.c.w.query(this.f30083w, "trackurl", null, null, null, null, null, null, this.f30082c);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    try {
                        linkedList.add(new sr(query.getString(query.getColumnIndex("id")), query.getString(query.getColumnIndex("url")), query.getInt(query.getColumnIndex("replaceholder")) > 0, query.getInt(query.getColumnIndex(AdLogEventRepo.COL_RETRY_COUNT))));
                    } finally {
                        query.close();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.r.w.f.ux
    public void delete(sr srVar) {
        com.bytedance.sdk.component.r.w.c.c.w.delete(this.f30083w, "trackurl", "id=?", new String[]{srVar.c()}, this.f30082c);
    }

    @Override // com.bytedance.sdk.component.r.w.f.ux
    public void insert(sr srVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", srVar.c());
        contentValues.put("url", srVar.w());
        contentValues.put("replaceholder", Integer.valueOf(srVar.xv() ? 1 : 0));
        contentValues.put(AdLogEventRepo.COL_RETRY_COUNT, Integer.valueOf(srVar.sr()));
        com.bytedance.sdk.component.r.w.c.c.w.insert(this.f30083w, "trackurl", contentValues, this.f30082c);
    }

    @Override // com.bytedance.sdk.component.r.w.f.ux
    public void update(sr srVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", srVar.c());
        contentValues.put("url", srVar.w());
        contentValues.put("replaceholder", Integer.valueOf(srVar.xv() ? 1 : 0));
        contentValues.put(AdLogEventRepo.COL_RETRY_COUNT, Integer.valueOf(srVar.sr()));
        com.bytedance.sdk.component.r.w.c.c.w.update(this.f30083w, "trackurl", contentValues, "id=?", new String[]{srVar.c()}, this.f30082c);
    }
}
