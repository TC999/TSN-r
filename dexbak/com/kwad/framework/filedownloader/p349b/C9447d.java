package com.kwad.framework.filedownloader.p349b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9461a;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.kwad.sdk.crash.utils.C10738b;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.umeng.analytics.pro.C13131bm;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9447d implements InterfaceC9440a {
    private static boolean afx;
    private final C9450e afy = new C9450e(C9492c.m28544wL());
    private SQLiteDatabase afz;

    /* renamed from: com.kwad.framework.filedownloader.b.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C9448a implements InterfaceC9440a.InterfaceC9441a {
        private final SparseArray<C9464c> afA = new SparseArray<>();
        private C9449b afB;
        private final SparseArray<C9464c> afn;
        private final SparseArray<List<C9461a>> afo;

        C9448a(SparseArray<C9464c> sparseArray, SparseArray<List<C9461a>> sparseArray2) {
            this.afn = sparseArray;
            this.afo = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a
        /* renamed from: a */
        public final void mo28765a(int i, C9464c c9464c) {
            this.afA.put(i, c9464c);
        }

        @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a
        /* renamed from: c */
        public final void mo28764c(C9464c c9464c) {
            SparseArray<C9464c> sparseArray = this.afn;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.afn.put(c9464c.getId(), c9464c);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<C9464c> iterator() {
            C9449b c9449b = new C9449b();
            this.afB = c9449b;
            return c9449b;
        }

        @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a
        /* renamed from: vg */
        public final void mo28763vg() {
            C9449b c9449b = this.afB;
            if (c9449b != null) {
                c9449b.m28762vg();
            }
            try {
                SQLiteDatabase m28766vh = C9447d.this.m28766vh();
                if (m28766vh == null) {
                    return;
                }
                int size = this.afA.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        m28766vh.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int keyAt = this.afA.keyAt(i);
                            C9464c c9464c = this.afA.get(keyAt);
                            m28766vh.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            m28766vh.insert("ksad_file_download", null, c9464c.m28684wj());
                            if (c9464c.m28680wo() > 1) {
                                List<C9461a> mo28779bl = C9447d.this.mo28779bl(keyAt);
                                if (mo28779bl.size() > 0) {
                                    m28766vh.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (C9461a c9461a : mo28779bl) {
                                        c9461a.setId(c9464c.getId());
                                        m28766vh.insert("ksad_file_download_connection", null, c9461a.m28703wj());
                                    }
                                }
                            }
                        }
                        SparseArray<C9464c> sparseArray = this.afn;
                        if (sparseArray != null && this.afo != null) {
                            synchronized (sparseArray) {
                                int size2 = this.afn.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int id = this.afn.valueAt(i2).getId();
                                    List<C9461a> mo28779bl2 = C9447d.this.mo28779bl(id);
                                    if (mo28779bl2 != null && mo28779bl2.size() > 0) {
                                        synchronized (this.afo) {
                                            this.afo.put(id, mo28779bl2);
                                        }
                                    }
                                }
                            }
                        }
                        m28766vh.setTransactionSuccessful();
                        try {
                            m28766vh.endTransaction();
                        } catch (Exception e) {
                            C9447d.printStackTrace(e);
                        }
                    } catch (SQLiteException e2) {
                        C9447d.this.m28788a(e2);
                        try {
                            m28766vh.endTransaction();
                        } catch (Exception e3) {
                            C9447d.printStackTrace(e3);
                        }
                    } catch (Exception e4) {
                        C9447d.printStackTrace(e4);
                        try {
                            m28766vh.endTransaction();
                        } catch (Exception e5) {
                            C9447d.printStackTrace(e5);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        m28766vh.endTransaction();
                    } catch (Exception e6) {
                        C9447d.printStackTrace(e6);
                    }
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C9449b implements Iterator<C9464c> {
        private Cursor afD;
        private final List<Integer> afE = new ArrayList();
        private int afF;

        C9449b() {
            try {
                this.afD = C9447d.this.m28766vh().rawQuery("SELECT * FROM ksad_file_download", null);
            } catch (SQLiteException e) {
                C9447d.this.m28788a(e);
            } catch (Exception e2) {
                C9447d.printStackTrace(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: vi */
        public C9464c next() {
            C9464c m28773d = C9447d.m28773d(this.afD);
            this.afF = m28773d.getId();
            return m28773d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.afD;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                C9447d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.afE.add(Integer.valueOf(this.afF));
        }

        /* renamed from: vg */
        final void m28762vg() {
            Cursor cursor = this.afD;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.afE.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.afE);
            if (C9498d.ail) {
                C9498d.m28535c(this, "delete %s", join);
            }
            try {
                SQLiteDatabase m28766vh = C9447d.this.m28766vh();
                m28766vh.execSQL(C9501f.m28515b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", C13131bm.f37927d, join));
                m28766vh.execSQL(C9501f.m28515b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e) {
                C9447d.this.m28788a(e);
            } catch (Exception e2) {
                C9447d.printStackTrace(e2);
            }
        }
    }

    /* renamed from: d */
    private void m28772d(C9464c c9464c) {
        try {
            m28766vh().insert("ksad_file_download", null, c9464c.m28684wj());
        } catch (SQLiteException e) {
            c9464c.m28692bo(e.toString());
            c9464c.m28690d((byte) -1);
            m28792a(c9464c.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    /* renamed from: h */
    private static void m28770h(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        m28770h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: vh */
    public SQLiteDatabase m28766vh() {
        if (this.afz == null) {
            this.afz = this.afy.getWritableDatabase();
        }
        return this.afz;
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: b */
    public final void mo28782b(C9464c c9464c) {
        if (c9464c == null) {
            C9498d.m28534d(this, "update but model == null!", new Object[0]);
        } else if (mo28780bk(c9464c.getId()) != null) {
            try {
                m28766vh().update("ksad_file_download", c9464c.m28684wj(), "_id = ? ", new String[]{String.valueOf(c9464c.getId())});
            } catch (SQLiteException e) {
                c9464c.m28692bo(e.toString());
                c9464c.m28690d((byte) -1);
                m28792a(c9464c.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        } else {
            m28772d(c9464c);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bj */
    public final void mo28781bj(int i) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0048 */
    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bk */
    public final C9464c mo28780bk(int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = m28766vh().rawQuery(C9501f.m28515b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", C13131bm.f37927d), new String[]{Integer.toString(i)});
            } catch (SQLiteException e) {
                e = e;
                cursor = null;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                C10738b.closeQuietly(closeable2);
                throw th;
            }
            try {
                if (cursor.moveToNext()) {
                    C9464c m28773d = m28773d(cursor);
                    C10738b.closeQuietly(cursor);
                    return m28773d;
                }
            } catch (SQLiteException e3) {
                e = e3;
                m28792a(i, e);
                C10738b.closeQuietly(cursor);
                return null;
            } catch (Exception e4) {
                e = e4;
                printStackTrace(e);
                C10738b.closeQuietly(cursor);
                return null;
            }
            C10738b.closeQuietly(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            C10738b.closeQuietly(closeable2);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    @SuppressLint({"Range"})
    /* renamed from: bl */
    public final List<C9461a> mo28779bl(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = m28766vh().rawQuery(C9501f.m28515b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    C9461a c9461a = new C9461a();
                    c9461a.setId(i);
                    c9461a.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    c9461a.setStartOffset(cursor.getLong(cursor.getColumnIndex("startOffset")));
                    c9461a.m28712Q(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    c9461a.m28711R(cursor.getLong(cursor.getColumnIndex("endOffset")));
                    arrayList.add(c9461a);
                }
            } catch (SQLiteException e) {
                m28792a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            return arrayList;
        } finally {
            C10738b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bm */
    public final void mo28778bm(int i) {
        try {
            SQLiteDatabase m28766vh = m28766vh();
            m28766vh.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bn */
    public final boolean mo28777bn(int i) {
        try {
            return m28766vh().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bo */
    public final void mo28776bo(int i) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: c */
    public final void mo28775c(int i, long j) {
        mo28777bn(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    public final void clear() {
        try {
            m28766vh().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            m28788a(e);
        }
        try {
            m28766vh().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            m28788a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: s */
    public final void mo28768s(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            m28766vh().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            m28792a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: vf */
    public final InterfaceC9440a.InterfaceC9441a mo28767vf() {
        return new C9448a(null, null);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28784a(C9461a c9461a) {
        if (c9461a != null) {
            try {
                m28766vh().insert("ksad_file_download_connection", null, c9461a.m28703wj());
            } catch (SQLiteException e) {
                m28792a(c9461a.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28795a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            m28766vh().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            m28792a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: d */
    public final void mo28774d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        m28793a(i, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Range"})
    /* renamed from: d */
    public static C9464c m28773d(Cursor cursor) {
        C9464c c9464c = new C9464c();
        if (cursor == null) {
            return c9464c;
        }
        c9464c.setId(cursor.getInt(cursor.getColumnIndex(C13131bm.f37927d)));
        c9464c.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        c9464c.m28689d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        c9464c.m28690d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        c9464c.m28697S(cursor.getLong(cursor.getColumnIndex("sofar")));
        c9464c.m28695U(cursor.getLong(cursor.getColumnIndex("total")));
        c9464c.m28692bo(cursor.getString(cursor.getColumnIndex("errMsg")));
        c9464c.m28693bn(cursor.getString(cursor.getColumnIndex(DownloadModel.ETAG)));
        c9464c.m28691bp(cursor.getString(cursor.getColumnIndex("filename")));
        c9464c.m28694bD(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return c9464c;
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: b */
    public final void mo28783b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        m28793a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28791a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put(DownloadModel.ETAG, str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        m28793a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28794a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put(DownloadModel.ETAG, str);
        contentValues.put("filename", str2);
        m28793a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28789a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        m28793a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28790a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        m28793a(i, contentValues);
    }

    /* renamed from: a */
    public final InterfaceC9440a.InterfaceC9441a m28787a(SparseArray<C9464c> sparseArray, SparseArray<List<C9461a>> sparseArray2) {
        return new C9448a(sparseArray, sparseArray2);
    }

    /* renamed from: a */
    private void m28793a(int i, ContentValues contentValues) {
        try {
            m28766vh().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            m28792a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m28788a(SQLiteException sQLiteException) {
        m28792a(-1, sQLiteException);
    }

    /* renamed from: a */
    private void m28792a(int i, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                mo28777bn(i);
                mo28778bm(i);
            }
            m28770h(sQLiteException);
            afx = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}
