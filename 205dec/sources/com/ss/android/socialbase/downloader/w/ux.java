package com.ss.android.socialbase.downloader.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.f.gd;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.w.xv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux extends xv.c implements u {

    /* renamed from: w  reason: collision with root package name */
    private static volatile SQLiteDatabase f50203w;

    /* renamed from: c  reason: collision with root package name */
    w f50204c;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f50205f;
    private r sr;
    private r ux;
    private r xv;

    public ux() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        if (f50203w == null) {
            synchronized (ux.class) {
                if (f50203w == null) {
                    f50203w = c.c().getWritableDatabase();
                    this.xv = new r(f50203w, "downloader", com.ss.android.socialbase.downloader.constants.xv.f49357c, com.ss.android.socialbase.downloader.constants.xv.f49359w);
                    this.sr = new r(f50203w, "downloadChunk", com.ss.android.socialbase.downloader.constants.xv.xv, com.ss.android.socialbase.downloader.constants.xv.sr);
                    this.ux = new r(f50203w, "segments", com.ss.android.socialbase.downloader.constants.xv.ux, com.ss.android.socialbase.downloader.constants.xv.f49358f);
                }
            }
        }
    }

    private void gd() {
        f50203w.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        gd();
        f50203w.delete("downloader", null, null);
        f50203w.delete("downloadChunk", null, null);
        f50203w.setTransactionSuccessful();
        p();
    }

    private void p() {
        try {
            if (f50203w == null || !f50203w.inTransaction()) {
                return;
            }
            f50203w.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void update(final int i4, final ContentValues contentValues) {
        ev();
        if (f50203w == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.3
            @Override // java.lang.Runnable
            public void run() {
                ux.this.c(i4, contentValues);
            }
        });
    }

    public Map<Long, gd> a(int i4) {
        Cursor cursor;
        ev();
        if (f50203w != null) {
            try {
                cursor = f50203w.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i4)});
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
                        gd gdVar = new gd(jSONArray.getJSONObject(i5));
                        hashMap.put(Long.valueOf(gdVar.xv()), gdVar);
                    }
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    return hashMap;
                }
                com.ss.android.socialbase.downloader.gd.f.c(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    public void bk(int i4) {
        ev();
        if (f50203w == null) {
            return;
        }
        try {
            c(i4, this.ux.w());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public boolean f(final int i4) {
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.11
            @Override // java.lang.Runnable
            public void run() {
                ux.this.ux(i4);
                ux.this.sr(i4);
                ux.this.bk(i4);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo r(int i4) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public List<DownloadInfo> sr(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public boolean ux() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public boolean ux(int i4) {
        r rVar;
        ev();
        if (f50203w != null && (rVar = this.xv) != null) {
            try {
                c(i4, rVar.w());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public List<DownloadInfo> w() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public List<DownloadInfo> w(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void w(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public List<DownloadInfo> xv(String str) {
        return null;
    }

    public ux(boolean z3) {
        this.f50204c = null;
        if (z3) {
            this.f50205f = false;
            c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo gd(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void sr(final int i4) {
        ev();
        if (f50203w == null || this.sr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux.this.c(i4, ux.this.sr.w());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo w(int i4) {
        Cursor cursor;
        ev();
        if (f50203w != null) {
            try {
                cursor = f50203w.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i4)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    return downloadInfo;
                }
                com.ss.android.socialbase.downloader.gd.f.c(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public List<com.ss.android.socialbase.downloader.model.w> xv(int i4) {
        ArrayList arrayList = new ArrayList();
        ev();
        if (f50203w != null) {
            Cursor cursor = null;
            try {
                cursor = f50203w.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i4)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.w(cursor));
                }
                com.ss.android.socialbase.downloader.gd.f.c(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv, com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i4, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!c(downloadInfo.getId())) {
                xv(downloadInfo);
            } else {
                r rVar = this.xv;
                if (rVar == null) {
                    return;
                }
                w(downloadInfo, rVar.xv());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo ux(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j4));
        update(i4, contentValues);
        return null;
    }

    /* renamed from: k */
    public ArrayList<gd> t(int i4) {
        Map<Long, gd> a4 = a(i4);
        if (a4 == null || a4.isEmpty()) {
            return null;
        }
        return new ArrayList<>(a4.values());
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo ev(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void w(com.ss.android.socialbase.downloader.model.w wVar) {
        c(wVar);
    }

    private void w(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
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

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c() {
        c(new SparseArray<>(), new SparseArray<>(), (sr) null);
    }

    private void xv(final DownloadInfo downloadInfo) {
        ev();
        if (f50203w == null || this.xv == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux uxVar = ux.this;
                    uxVar.c(downloadInfo, uxVar.xv.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void c(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.w>> sparseArray2, final sr srVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.1
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
                    r0.c();
                    r18.sr.f50205f = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:171:0x0353, code lost:
                    r18.sr.c(r2, r3);
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
                    r0.c();
                    r18.sr.f50205f = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x01b8, code lost:
                    r18.sr.c(r2, r3);
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
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.w.ux.AnonymousClass1.run():void");
                }
            };
            ExecutorService s3 = com.ss.android.socialbase.downloader.downloader.xv.s();
            if (s3 != null) {
                s3.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo sr(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j4));
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void xv() {
        ev();
        if (f50203w == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.2
            @Override // java.lang.Runnable
            public void run() {
                ux.this.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.gd.f.w(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public boolean sr() {
        return this.f50205f;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo w(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j4));
        if (j4 > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i4, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo xv(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j4));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i4, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.w>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || f50203w == null) {
            return;
        }
        synchronized (f50203w) {
            try {
                gd();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.r.c.xv().c("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            strArr[i4] = String.valueOf(list.get(i4));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f50203w.delete("downloader", str, strArr);
                        f50203w.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        f50203w.delete("downloader", "_id IN (?)", new String[]{join});
                        f50203w.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f50203w.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f50203w.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.w> xv = xv(keyAt);
                        if (xv.size() > 0) {
                            f50203w.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.w wVar : xv) {
                                wVar.w(downloadInfo.getId());
                                f50203w.insert("downloadChunk", null, wVar.c());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        int id = sparseArray2.valueAt(i6).getId();
                        List<com.ss.android.socialbase.downloader.model.w> c4 = com.ss.android.socialbase.downloader.gd.f.c(xv(id));
                        if (c4 != null && c4.size() > 0) {
                            sparseArray3.put(id, c4);
                        }
                    }
                }
                f50203w.setTransactionSuccessful();
                p();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        try {
            sr(i4);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                    if (wVar != null) {
                        c(wVar);
                        if (wVar.f()) {
                            for (com.ss.android.socialbase.downloader.model.w wVar2 : wVar.r()) {
                                c(wVar2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public boolean c(int i4) {
        try {
            return w(i4) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public List<DownloadInfo> c(String str) {
        ev();
        ArrayList arrayList = new ArrayList();
        if (f50203w != null) {
            Cursor cursor = null;
            try {
                cursor = f50203w.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                com.ss.android.socialbase.downloader.gd.f.c(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.gd.f.c(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, SQLiteStatement sQLiteStatement) {
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

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c(final com.ss.android.socialbase.downloader.model.w wVar) {
        ev();
        if (f50203w == null || this.sr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux.this.c(wVar, ux.this.sr.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
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
    public void c(com.ss.android.socialbase.downloader.model.w wVar, SQLiteStatement sQLiteStatement) {
        if (wVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                wVar.c(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c(final int i4, final int i5, final long j4) {
        ev();
        if (i4 == 0 || i5 < 0 || j4 < 0 || f50203w == null || this.sr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux.this.c(i4, i5, j4, ux.this.sr.xv());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c(final int i4, final int i5, final int i6, final long j4) {
        ev();
        if (i4 == 0 || i5 < 0 || i6 < 0 || j4 < 0 || f50203w == null || this.sr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux.this.c(i4, i5, i6, j4, ux.this.sr.xv());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c(final int i4, final int i5, final int i6, final int i7) {
        ev();
        if (i4 == 0 || i6 < 0 || i7 == i5 || i7 < 0 || f50203w == null || this.sr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux.this.c(i4, i5, i6, i7, ux.this.sr.xv());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5, int i6, int i7, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i7));
                f50203w.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i4), Integer.toString(i5), Integer.toString(i6)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5, long j4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j4));
                f50203w.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i4), Integer.toString(i5)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5, int i6, long j4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j4));
                f50203w.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i4), Integer.toString(i5), Integer.toString(i6)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo c(int i4, int i5) {
        ev();
        if (f50203w == null) {
            return null;
        }
        int i6 = 10;
        while (f50203w.isDbLockedByCurrentThread() && i6 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i5));
        f50203w.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i4)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public boolean c(final DownloadInfo downloadInfo) {
        ev();
        if (downloadInfo == null || f50203w == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.xv.xv(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.ux.10
            @Override // java.lang.Runnable
            public void run() {
                ux.this.sr(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo c(int i4, long j4, String str, String str2) {
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

    @Override // com.ss.android.socialbase.downloader.w.xv
    public DownloadInfo c(int i4, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j4));
        update(i4, contentValues);
        return null;
    }

    public boolean c(int i4, Map<Long, gd> map) {
        long currentTimeMillis = System.currentTimeMillis();
        ev();
        if (f50203w == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l4 : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l4.longValue())).k());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement sr = this.ux.sr();
        synchronized (sr) {
            sr.clearBindings();
            sr.bindLong(1, i4);
            sr.bindString(2, jSONArray.toString());
            sr.execute();
        }
        com.ss.android.socialbase.downloader.xv.c.w("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.gd.f.xv(currentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, ContentValues contentValues) {
        int i5 = 10;
        while (f50203w.isDbLockedByCurrentThread() && i5 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        f50203w.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i4)});
    }

    @Override // com.ss.android.socialbase.downloader.w.xv
    public void c(w wVar) {
        this.f50204c = wVar;
    }

    public void c(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.w>> sparseArray2) {
        try {
            HashMap c4 = com.ss.android.socialbase.downloader.gd.f.c(sparseArray);
            HashMap c5 = com.ss.android.socialbase.downloader.gd.f.c(sparseArray2);
            w wVar = this.f50204c;
            if (wVar != null) {
                wVar.c(c4, c5);
            }
        } catch (Throwable unused) {
        }
    }
}
