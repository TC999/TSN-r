package com.p521ss.android.socialbase.downloader.p548a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.InterfaceC12412bl;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12519u;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p551kf.C12584q;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.umeng.analytics.pro.C13131bm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* renamed from: com.ss.android.socialbase.downloader.a.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BinderC12395n extends InterfaceC12384bl.AbstractBinderC12385ok implements InterfaceC12519u {

    /* renamed from: a */
    private static volatile SQLiteDatabase f34922a;

    /* renamed from: bl */
    private C12387h f34923bl;

    /* renamed from: kf */
    private volatile boolean f34924kf;

    /* renamed from: n */
    private C12387h f34925n;

    /* renamed from: ok */
    InterfaceC12381a f34926ok;

    /* renamed from: s */
    private C12387h f34927s;

    public BinderC12395n() {
        this(false);
    }

    /* renamed from: k */
    private void m17959k() {
        try {
            if (f34922a == null || !f34922a.inTransaction()) {
                return;
            }
            f34922a.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m17918p() {
        if (f34922a == null) {
            synchronized (BinderC12395n.class) {
                if (f34922a == null) {
                    f34922a = C12407ok.m17906ok().getWritableDatabase();
                    this.f34923bl = new C12387h(f34922a, "downloader", InterfaceC12412bl.f34974ok, InterfaceC12412bl.f34970a);
                    this.f34927s = new C12387h(f34922a, "downloadChunk", InterfaceC12412bl.f34971bl, InterfaceC12412bl.f34975s);
                    this.f34925n = new C12387h(f34922a, "segments", InterfaceC12412bl.f34973n, InterfaceC12412bl.f34972kf);
                }
            }
        }
    }

    /* renamed from: q */
    private void m17916q() {
        f34922a.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public synchronized void m17914r() {
        m17916q();
        f34922a.delete("downloader", null, null);
        f34922a.delete("downloadChunk", null, null);
        f34922a.setTransactionSuccessful();
        m17959k();
    }

    private void update(final int i, final ContentValues contentValues) {
        m17918p();
        if (f34922a == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.3
            @Override // java.lang.Runnable
            public void run() {
                BinderC12395n.this.m17942ok(i, contentValues);
            }
        });
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public List<DownloadInfo> mo17976a() {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public List<DownloadInfo> mo17968a(String str) {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public void mo17971a(DownloadInfo downloadInfo) {
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: bl */
    public List<DownloadInfo> mo17962bl(String str) {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: h */
    public DownloadInfo mo17960h(int i) {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: j */
    public Map<Long, C12584q> mo17506j(int i) {
        Cursor cursor;
        m17918p();
        if (f34922a != null) {
            try {
                cursor = f34922a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", C13131bm.f37927d), new String[]{Integer.toString(i)});
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
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        C12584q c12584q = new C12584q(jSONArray.getJSONObject(i2));
                        hashMap.put(Long.valueOf(c12584q.m17293bl()), c12584q);
                    }
                    C12713kf.m16532ok(cursor);
                    return hashMap;
                }
                C12713kf.m16532ok(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    C12713kf.m16532ok(cursor);
                    return null;
                } catch (Throwable th3) {
                    C12713kf.m16532ok(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: kf */
    public boolean mo17957kf(final int i) {
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.11
            @Override // java.lang.Runnable
            public void run() {
                BinderC12395n.this.mo17955n(i);
                BinderC12395n.this.mo17911s(i);
                BinderC12395n.this.mo17475z(i);
            }
        });
        return true;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: n */
    public boolean mo17956n() {
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: n */
    public boolean mo17955n(int i) {
        C12387h c12387h;
        m17918p();
        if (f34922a != null && (c12387h = this.f34923bl) != null) {
            try {
                m17941ok(i, c12387h.m17996a());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17940ok(int i, List<C12598a> list) {
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: s */
    public List<DownloadInfo> mo17907s(String str) {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: z */
    public void mo17475z(int i) {
        m17918p();
        if (f34922a == null) {
            return;
        }
        try {
            m17941ok(i, this.f34925n.m17996a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public BinderC12395n(boolean z) {
        this.f34926ok = null;
        if (z) {
            this.f34924kf = false;
            mo17953ok();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public DownloadInfo mo17975a(int i) {
        Cursor cursor;
        m17918p();
        if (f34922a != null) {
            try {
                cursor = f34922a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", C13131bm.f37927d), new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    C12713kf.m16532ok(cursor);
                    return downloadInfo;
                }
                C12713kf.m16532ok(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    C12713kf.m16532ok(cursor);
                    return null;
                } catch (Throwable th3) {
                    C12713kf.m16532ok(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: bl */
    public List<C12598a> mo17966bl(int i) {
        ArrayList arrayList = new ArrayList();
        m17918p();
        if (f34922a != null) {
            Cursor cursor = null;
            try {
                cursor = f34922a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", C13131bm.f37927d), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    arrayList.add(new C12598a(cursor));
                }
                C12713kf.m16532ok(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    C12713kf.m16532ok(cursor);
                } catch (Throwable th2) {
                    C12713kf.m16532ok(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: q */
    public DownloadInfo mo17915q(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: s */
    public void mo17911s(final int i) {
        m17918p();
        if (f34922a == null || this.f34927s == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BinderC12395n.this.m17941ok(i, BinderC12395n.this.f34927s.m17996a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: k */
    public DownloadInfo mo17958k(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public synchronized void m17908s(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!mo17952ok(downloadInfo.getId())) {
                m17963bl(downloadInfo);
            } else {
                C12387h c12387h = this.f34923bl;
                if (c12387h == null) {
                    return;
                }
                m17970a(downloadInfo, c12387h.m17995bl());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: n */
    public DownloadInfo mo17954n(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: r */
    public ArrayList<C12584q> mo17480rh(int i) {
        Map<Long, C12584q> mo17506j = mo17506j(i);
        if (mo17506j == null || mo17506j.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mo17506j.values());
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: p */
    public DownloadInfo mo17917p(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public void mo17969a(C12598a c12598a) {
        mo17923ok(c12598a);
    }

    /* renamed from: a */
    private void m17970a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
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

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17953ok() {
        mo17626ok(new SparseArray<>(), new SparseArray<>(), (InterfaceC12408s) null);
    }

    /* renamed from: bl */
    private void m17963bl(final DownloadInfo downloadInfo) {
        m17918p();
        if (f34922a == null || this.f34923bl == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BinderC12395n binderC12395n = BinderC12395n.this;
                    binderC12395n.m17924ok(downloadInfo, binderC12395n.f34923bl.m17994ok());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12519u
    /* renamed from: ok */
    public void mo17626ok(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<C12598a>> sparseArray2, final InterfaceC12408s interfaceC12408s) {
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
                    r0.mo17473ok();
                    r18.f34931s.f34924kf = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:171:0x0353, code lost:
                    r18.f34931s.m17939ok(r2, r3);
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
                    r0.mo17473ok();
                    r18.f34931s.f34924kf = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x01b8, code lost:
                    r18.f34931s.m17939ok(r2, r3);
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
                    throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p548a.BinderC12395n.RunnableC123961.run():void");
                }
            };
            ExecutorService m17757td = C12490bl.m17757td();
            if (m17757td != null) {
                m17757td.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: s */
    public DownloadInfo mo17910s(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: bl */
    public void mo17967bl() {
        m17918p();
        if (f34922a == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.2
            @Override // java.lang.Runnable
            public void run() {
                BinderC12395n.this.m17914r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17920ok(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    C12713kf.m16617a(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: s */
    public boolean mo17912s() {
        return this.f34924kf;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public DownloadInfo mo17974a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: bl */
    public DownloadInfo mo17965bl(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17919ok(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<C12598a>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || f34922a == null) {
            return;
        }
        synchronized (f34922a) {
            try {
                m17916q();
                if (!list.isEmpty()) {
                    if (C12534ok.m17605bl().m17595ok("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = String.valueOf(list.get(i));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f34922a.delete("downloader", str, strArr);
                        f34922a.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        f34922a.delete("downloader", "_id IN (?)", new String[]{join});
                        f34922a.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f34922a.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f34922a.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<C12598a> mo17966bl = mo17966bl(keyAt);
                        if (mo17966bl.size() > 0) {
                            f34922a.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (C12598a c12598a : mo17966bl) {
                                c12598a.m17049a(downloadInfo.getId());
                                f34922a.insert("downloadChunk", null, c12598a.m17037ok());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int id = sparseArray2.valueAt(i3).getId();
                        List<C12598a> m16539ok = C12713kf.m16539ok(mo17966bl(id));
                        if (m16539ok != null && m16539ok.size() > 0) {
                            sparseArray3.put(id, m16539ok);
                        }
                    }
                }
                f34922a.setTransactionSuccessful();
                m17959k();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: a */
    public void mo17973a(int i, List<C12598a> list) {
        try {
            mo17911s(i);
            if (list != null) {
                for (C12598a c12598a : list) {
                    if (c12598a != null) {
                        mo17923ok(c12598a);
                        if (c12598a.m17039kf()) {
                            for (C12598a c12598a2 : c12598a.m17043h()) {
                                mo17923ok(c12598a2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public boolean mo17952ok(int i) {
        try {
            return mo17975a(i) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public List<DownloadInfo> mo17921ok(String str) {
        m17918p();
        ArrayList arrayList = new ArrayList();
        if (f34922a != null) {
            Cursor cursor = null;
            try {
                cursor = f34922a.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                C12713kf.m16532ok(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    C12713kf.m16532ok(cursor);
                } catch (Throwable th2) {
                    C12713kf.m16532ok(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17941ok(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17923ok(final C12598a c12598a) {
        m17918p();
        if (f34922a == null || this.f34927s == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BinderC12395n.this.m17922ok(c12598a, BinderC12395n.this.f34927s.m17994ok());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17924ok(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
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
    /* renamed from: ok */
    public void m17922ok(C12598a c12598a, SQLiteStatement sQLiteStatement) {
        if (c12598a == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                c12598a.m17033ok(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17946ok(final int i, final int i2, final long j) {
        m17918p();
        if (i == 0 || i2 < 0 || j < 0 || f34922a == null || this.f34927s == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BinderC12395n.this.m17945ok(i, i2, j, BinderC12395n.this.f34927s.m17995bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17948ok(final int i, final int i2, final int i3, final long j) {
        m17918p();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || f34922a == null || this.f34927s == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BinderC12395n.this.m17947ok(i, i2, i3, j, BinderC12395n.this.f34927s.m17995bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17950ok(final int i, final int i2, final int i3, final int i4) {
        m17918p();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || f34922a == null || this.f34927s == null) {
            return;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BinderC12395n.this.m17949ok(i, i2, i3, i4, BinderC12395n.this.f34927s.m17995bl());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17949ok(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                f34922a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17945ok(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                f34922a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17947ok(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                f34922a.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public DownloadInfo mo17951ok(int i, int i2) {
        m17918p();
        if (f34922a == null) {
            return null;
        }
        int i3 = 10;
        while (f34922a.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        f34922a.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public boolean mo17925ok(final DownloadInfo downloadInfo) {
        m17918p();
        if (downloadInfo == null || f34922a == null) {
            return false;
        }
        C12490bl.m17828bl(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.n.10
            @Override // java.lang.Runnable
            public void run() {
                BinderC12395n.this.m17908s(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public DownloadInfo mo17943ok(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public DownloadInfo mo17944ok(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public boolean mo17491ok(int i, Map<Long, C12584q> map) {
        long currentTimeMillis = System.currentTimeMillis();
        m17918p();
        if (f34922a == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l.longValue())).m17281r());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement m17993s = this.f34925n.m17993s();
        synchronized (m17993s) {
            m17993s.clearBindings();
            m17993s.bindLong(1, i);
            m17993s.bindString(2, jSONArray.toString());
            m17993s.execute();
        }
        C12409ok.m17904a("SqlDownloadCache", "updateSegments cost=" + C12713kf.m16603bl(currentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17942ok(int i, ContentValues contentValues) {
        int i2 = 10;
        while (f34922a.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        f34922a.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
    /* renamed from: ok */
    public void mo17938ok(InterfaceC12381a interfaceC12381a) {
        this.f34926ok = interfaceC12381a;
    }

    /* renamed from: ok */
    public void m17939ok(SparseArray<DownloadInfo> sparseArray, SparseArray<List<C12598a>> sparseArray2) {
        try {
            HashMap m16567ok = C12713kf.m16567ok(sparseArray);
            HashMap m16567ok2 = C12713kf.m16567ok(sparseArray2);
            InterfaceC12381a interfaceC12381a = this.f34926ok;
            if (interfaceC12381a != null) {
                interfaceC12381a.mo17977ok(m16567ok, m16567ok2);
            }
        } catch (Throwable unused) {
        }
    }
}
