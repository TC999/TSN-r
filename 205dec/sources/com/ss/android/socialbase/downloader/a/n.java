package com.ss.android.socialbase.downloader.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.bl;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.kf.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n extends bl.ok implements u {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SQLiteDatabase f49281a;
    private h bl;
    private volatile boolean kf;

    /* renamed from: n  reason: collision with root package name */
    private h f49282n;
    a ok;

    /* renamed from: s  reason: collision with root package name */
    private h f49283s;

    public n() {
        this(false);
    }

    private void k() {
        try {
            if (f49281a == null || !f49281a.inTransaction()) {
                return;
            }
            f49281a.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (f49281a == null) {
            synchronized (n.class) {
                if (f49281a == null) {
                    f49281a = ok.ok().getWritableDatabase();
                    this.bl = new h(f49281a, "downloader", com.ss.android.socialbase.downloader.constants.bl.ok, com.ss.android.socialbase.downloader.constants.bl.f49311a);
                    this.f49283s = new h(f49281a, "downloadChunk", com.ss.android.socialbase.downloader.constants.bl.bl, com.ss.android.socialbase.downloader.constants.bl.f49313s);
                    this.f49282n = new h(f49281a, "segments", com.ss.android.socialbase.downloader.constants.bl.f49312n, com.ss.android.socialbase.downloader.constants.bl.kf);
                }
            }
        }
    }

    private void q() {
        f49281a.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() {
        q();
        f49281a.delete("downloader", null, null);
        f49281a.delete("downloadChunk", null, null);
        f49281a.setTransactionSuccessful();
        k();
    }

    private void update(final int i4, final ContentValues contentValues) {
        p();
        if (f49281a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.ok(i4, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> a() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> a(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void a(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> bl(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo h(int i4) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public Map<Long, q> j(int i4) {
        Cursor cursor;
        p();
        if (f49281a != null) {
            try {
                cursor = f49281a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i4)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex("info");
                    String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                    HashMap hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        q qVar = new q(jSONArray.getJSONObject(i5));
                        hashMap.put(Long.valueOf(qVar.bl()), qVar);
                    }
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    return hashMap;
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean kf(final int i4) {
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.11
            @Override // java.lang.Runnable
            public void run() {
                n.this.n(i4);
                n.this.s(i4);
                n.this.z(i4);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean n() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean n(int i4) {
        h hVar;
        p();
        if (f49281a != null && (hVar = this.bl) != null) {
            try {
                ok(i4, hVar.a());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> s(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void z(int i4) {
        p();
        if (f49281a == null) {
            return;
        }
        try {
            ok(i4, this.f49282n.a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public n(boolean z3) {
        this.ok = null;
        if (z3) {
            this.kf = false;
            ok();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo a(int i4) {
        Cursor cursor;
        p();
        if (f49281a != null) {
            try {
                cursor = f49281a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i4)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    return downloadInfo;
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<com.ss.android.socialbase.downloader.model.a> bl(int i4) {
        ArrayList arrayList = new ArrayList();
        p();
        if (f49281a != null) {
            Cursor cursor = null;
            try {
                cursor = f49281a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i4)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.a(cursor));
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo q(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void s(final int i4) {
        p();
        if (f49281a == null || this.f49283s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i4, n.this.f49283s.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo k(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i4, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!ok(downloadInfo.getId())) {
                bl(downloadInfo);
            } else {
                h hVar = this.bl;
                if (hVar == null) {
                    return;
                }
                a(downloadInfo, hVar.bl());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo n(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j4));
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    /* renamed from: r */
    public ArrayList<q> rh(int i4) {
        Map<Long, q> j4 = j(i4);
        if (j4 == null || j4.isEmpty()) {
            return null;
        }
        return new ArrayList<>(j4.values());
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo p(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
        ok(aVar);
    }

    private void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok() {
        ok(new SparseArray<>(), new SparseArray<>(), (s) null);
    }

    private void bl(final DownloadInfo downloadInfo) {
        p();
        if (f49281a == null || this.bl == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n nVar = n.this;
                    nVar.ok(downloadInfo, nVar.bl.ok());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void ok(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2, final s sVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.1
                /* JADX WARN: Code restructure failed: missing block: B:123:0x027b, code lost:
                    if (r0 == null) goto L91;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:128:0x0285, code lost:
                    if (r0 == null) goto L91;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:130:0x0289, code lost:
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:164:0x0340, code lost:
                    if (r0 == null) goto L184;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:169:0x0349, code lost:
                    if (r0 == null) goto L184;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:170:0x034b, code lost:
                    r0.ok();
                    r18.f49285s.kf = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:171:0x0353, code lost:
                    r18.f49285s.ok(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:172:0x035c, code lost:
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:0x01a5, code lost:
                    if (r0 != null) goto L93;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:86:0x01ae, code lost:
                    if (r0 == null) goto L91;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:87:0x01b0, code lost:
                    r0.ok();
                    r18.f49285s.kf = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x01b8, code lost:
                    r18.f49285s.ok(r2, r3);
                 */
                /* JADX WARN: Removed duplicated region for block: B:196:0x00da A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:198:0x00ca A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 889
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.a.n.AnonymousClass1.run():void");
                }
            };
            ExecutorService td = com.ss.android.socialbase.downloader.downloader.bl.td();
            if (td != null) {
                td.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo s(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j4));
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void bl() {
        p();
        if (f49281a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.q.kf.a(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean s() {
        return this.kf;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo a(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j4));
        if (j4 > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo bl(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j4));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i4, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || f49281a == null) {
            return;
        }
        synchronized (f49281a) {
            try {
                q();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.h.ok.bl().ok("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            strArr[i4] = String.valueOf(list.get(i4));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f49281a.delete("downloader", str, strArr);
                        f49281a.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        f49281a.delete("downloader", "_id IN (?)", new String[]{join});
                        f49281a.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f49281a.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f49281a.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.a> bl = bl(keyAt);
                        if (bl.size() > 0) {
                            f49281a.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.a aVar : bl) {
                                aVar.a(downloadInfo.getId());
                                f49281a.insert("downloadChunk", null, aVar.ok());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        int id = sparseArray2.valueAt(i6).getId();
                        List<com.ss.android.socialbase.downloader.model.a> ok = com.ss.android.socialbase.downloader.q.kf.ok(bl(id));
                        if (ok != null && ok.size() > 0) {
                            sparseArray3.put(id, ok);
                        }
                    }
                }
                f49281a.setTransactionSuccessful();
                k();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            s(i4);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.a aVar : list) {
                    if (aVar != null) {
                        ok(aVar);
                        if (aVar.kf()) {
                            for (com.ss.android.socialbase.downloader.model.a aVar2 : aVar.h()) {
                                ok(aVar2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean ok(int i4) {
        try {
            return a(i4) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public List<DownloadInfo> ok(String str) {
        p();
        ArrayList arrayList = new ArrayList();
        if (f49281a != null) {
            Cursor cursor = null;
            try {
                cursor = f49281a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                com.ss.android.socialbase.downloader.q.kf.ok(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.q.kf.ok(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i4);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final com.ss.android.socialbase.downloader.model.a aVar) {
        p();
        if (f49281a == null || this.f49283s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(aVar, n.this.f49283s.ok());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(com.ss.android.socialbase.downloader.model.a aVar, SQLiteStatement sQLiteStatement) {
        if (aVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                aVar.ok(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final int i4, final int i5, final long j4) {
        p();
        if (i4 == 0 || i5 < 0 || j4 < 0 || f49281a == null || this.f49283s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i4, i5, j4, n.this.f49283s.bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final int i4, final int i5, final int i6, final long j4) {
        p();
        if (i4 == 0 || i5 < 0 || i6 < 0 || j4 < 0 || f49281a == null || this.f49283s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i4, i5, i6, j4, n.this.f49283s.bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(final int i4, final int i5, final int i6, final int i7) {
        p();
        if (i4 == 0 || i6 < 0 || i7 == i5 || i7 < 0 || f49281a == null || this.f49283s == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.ok(i4, i5, i6, i7, n.this.f49283s.bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, int i6, int i7, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i7));
                f49281a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i4), Integer.toString(i5), Integer.toString(i6)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, long j4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j4));
                f49281a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i4), Integer.toString(i5)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, int i6, long j4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j4));
                f49281a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i4), Integer.toString(i5), Integer.toString(i6)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo ok(int i4, int i5) {
        p();
        if (f49281a == null) {
            return null;
        }
        int i6 = 10;
        while (f49281a.isDbLockedByCurrentThread() && i6 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i5));
        f49281a.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i4)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public boolean ok(final DownloadInfo downloadInfo) {
        p();
        if (downloadInfo == null || f49281a == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.bl.bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.10
            @Override // java.lang.Runnable
            public void run() {
                n.this.s(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo ok(int i4, long j4, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j4));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public DownloadInfo ok(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j4));
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(int i4, Map<Long, q> map) {
        long currentTimeMillis = System.currentTimeMillis();
        p();
        if (f49281a == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l4 : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l4.longValue())).r());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement s3 = this.f49282n.s();
        synchronized (s3) {
            s3.clearBindings();
            s3.bindLong(1, i4);
            s3.bindString(2, jSONArray.toString());
            s3.execute();
        }
        com.ss.android.socialbase.downloader.bl.ok.a("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.q.kf.bl(currentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, ContentValues contentValues) {
        int i5 = 10;
        while (f49281a.isDbLockedByCurrentThread() && i5 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        f49281a.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i4)});
    }

    @Override // com.ss.android.socialbase.downloader.a.bl
    public void ok(a aVar) {
        this.ok = aVar;
    }

    public void ok(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2) {
        try {
            HashMap ok = com.ss.android.socialbase.downloader.q.kf.ok(sparseArray);
            HashMap ok2 = com.ss.android.socialbase.downloader.q.kf.ok(sparseArray2);
            a aVar = this.ok;
            if (aVar != null) {
                aVar.ok(ok, ok2);
            }
        } catch (Throwable unused) {
        }
    }
}
