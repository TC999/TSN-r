package com.bytedance.c.w.w.w;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.c.w.b;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends a<x0.a> {
    public b() {
        super("duplicatelog");
    }

    @Override // com.bytedance.c.w.w.w.a
    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.c.w.w.w.a
    /* renamed from: d */
    public ContentValues a(x0.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.f64436a);
        contentValues.put("insert_time", Long.valueOf(aVar.f64437b));
        return contentValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L2e
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto La
            goto L2e
        La:
            r1 = 1
            java.lang.String r3 = r10.f26640b     // Catch: java.lang.Exception -> L26
            r4 = 0
            java.lang.String r5 = "path=?"
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L26
            r6[r0] = r12     // Catch: java.lang.Exception -> L26
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L26
            int r12 = r11.getCount()     // Catch: java.lang.Exception -> L26
            r11.close()     // Catch: java.lang.Exception -> L24
            goto L2b
        L24:
            r11 = move-exception
            goto L28
        L26:
            r11 = move-exception
            r12 = 0
        L28:
            com.bytedance.c.w.b.k.c(r11)
        L2b:
            if (r12 <= 0) goto L2e
            r0 = 1
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.c.w.w.w.b.e(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @Override // com.bytedance.c.w.w.w.a
    public void insert(SQLiteDatabase sQLiteDatabase, x0.a aVar) {
        if (aVar == null || e(sQLiteDatabase, aVar.f64436a)) {
            return;
        }
        super.insert(sQLiteDatabase, (SQLiteDatabase) aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f26640b + " where _id in (select _id from " + this.f26640b + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e4) {
            b.k.c(e4);
        }
    }
}
