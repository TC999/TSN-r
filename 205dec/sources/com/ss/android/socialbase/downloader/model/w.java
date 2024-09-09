package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private int f49977a;
    private boolean bk;
    private AtomicInteger ev;

    /* renamed from: f  reason: collision with root package name */
    private long f49978f;
    private long gd;

    /* renamed from: k  reason: collision with root package name */
    private w f49979k;

    /* renamed from: p  reason: collision with root package name */
    private List<w> f49980p;

    /* renamed from: r  reason: collision with root package name */
    private int f49981r;
    private AtomicLong sr;

    /* renamed from: t  reason: collision with root package name */
    private AtomicBoolean f49982t;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private int f49983w;
    private long xv;
    private com.ss.android.socialbase.downloader.ev.w ys;

    /* renamed from: c  reason: collision with root package name */
    private static final String f49976c = w.class.getSimpleName();
    public static final Parcelable.Creator<w> CREATOR = new Parcelable.Creator<w>() { // from class: com.ss.android.socialbase.downloader.model.w.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public w createFromParcel(Parcel parcel) {
            return new w(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public w[] newArray(int i4) {
            return new w[i4];
        }
    };

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private int f49984c;
        private w ev;

        /* renamed from: f  reason: collision with root package name */
        private int f49985f;

        /* renamed from: r  reason: collision with root package name */
        private long f49986r;
        private long sr;
        private long ux;

        /* renamed from: w  reason: collision with root package name */
        private long f49987w;
        private long xv;

        public c(int i4) {
            this.f49984c = i4;
        }

        public c c(long j4) {
            this.f49987w = j4;
            return this;
        }

        public c sr(long j4) {
            this.ux = j4;
            return this;
        }

        public c ux(long j4) {
            this.f49986r = j4;
            return this;
        }

        public c w(long j4) {
            this.xv = j4;
            return this;
        }

        public c xv(long j4) {
            this.sr = j4;
            return this;
        }

        public c c(int i4) {
            this.f49985f = i4;
            return this;
        }

        public c c(w wVar) {
            this.ev = wVar;
            return this;
        }

        public w c() {
            return new w(this);
        }
    }

    public long a() {
        return this.xv;
    }

    public long bk() {
        AtomicLong atomicLong = this.sr;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public ContentValues c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f49983w));
        contentValues.put("chunkIndex", Integer.valueOf(this.f49981r));
        contentValues.put("startOffset", Long.valueOf(this.xv));
        contentValues.put("curOffset", Long.valueOf(t()));
        contentValues.put("endOffset", Long.valueOf(this.ux));
        contentValues.put("chunkContentLen", Long.valueOf(this.f49978f));
        contentValues.put("hostChunkIndex", Integer.valueOf(w()));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean ev() {
        w wVar = this.f49979k;
        if (wVar == null) {
            return true;
        }
        if (wVar.f()) {
            for (int i4 = 0; i4 < this.f49979k.r().size(); i4++) {
                w wVar2 = this.f49979k.r().get(i4);
                if (wVar2 != null) {
                    int indexOf = this.f49979k.r().indexOf(this);
                    if (indexOf > i4 && !wVar2.gd()) {
                        return false;
                    }
                    if (indexOf == i4) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        List<w> list = this.f49980p;
        return list != null && list.size() > 0;
    }

    public long fp() {
        return this.ux;
    }

    public int fz() {
        return this.f49981r;
    }

    public boolean gd() {
        long j4 = this.xv;
        if (sr()) {
            long j5 = this.gd;
            if (j5 > this.xv) {
                j4 = j5;
            }
        }
        return t() - j4 >= this.f49978f;
    }

    public long ia() {
        return this.f49978f;
    }

    public int k() {
        return this.f49983w;
    }

    public long p() {
        w wVar = this.f49979k;
        if (wVar != null && wVar.r() != null) {
            int indexOf = this.f49979k.r().indexOf(this);
            boolean z3 = false;
            for (int i4 = 0; i4 < this.f49979k.r().size(); i4++) {
                w wVar2 = this.f49979k.r().get(i4);
                if (wVar2 != null) {
                    if (z3) {
                        return wVar2.t();
                    }
                    if (indexOf == i4) {
                        z3 = true;
                    }
                }
            }
        }
        return -1L;
    }

    public List<w> r() {
        return this.f49980p;
    }

    public void s() {
        this.gd = t();
    }

    public boolean sr() {
        return w() == -1;
    }

    public long t() {
        if (sr() && f()) {
            long j4 = 0;
            for (int i4 = 0; i4 < this.f49980p.size(); i4++) {
                w wVar = this.f49980p.get(i4);
                if (wVar != null) {
                    if (!wVar.gd()) {
                        return wVar.bk();
                    }
                    if (j4 < wVar.bk()) {
                        j4 = wVar.bk();
                    }
                }
            }
            return j4;
        }
        return bk();
    }

    public w ux() {
        w wVar = !sr() ? this.f49979k : this;
        if (wVar == null || !wVar.f()) {
            return null;
        }
        return wVar.r().get(0);
    }

    public int w() {
        AtomicInteger atomicInteger = this.ev;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f49983w);
        parcel.writeLong(this.xv);
        AtomicLong atomicLong = this.sr;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.ux);
        parcel.writeLong(this.f49978f);
        parcel.writeInt(this.f49981r);
        AtomicInteger atomicInteger = this.ev;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public boolean xv() {
        AtomicBoolean atomicBoolean = this.f49982t;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public long ys() {
        long t3 = t() - this.xv;
        if (f()) {
            t3 = 0;
            for (int i4 = 0; i4 < this.f49980p.size(); i4++) {
                w wVar = this.f49980p.get(i4);
                if (wVar != null) {
                    t3 += wVar.t() - wVar.a();
                }
            }
        }
        return t3;
    }

    private w(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f49983w = cVar.f49984c;
        this.xv = cVar.f49987w;
        this.sr = new AtomicLong(cVar.xv);
        this.ux = cVar.sr;
        this.f49978f = cVar.ux;
        this.f49981r = cVar.f49985f;
        this.gd = cVar.f49986r;
        this.ev = new AtomicInteger(-1);
        c(cVar.ev);
        this.f49982t = new AtomicBoolean(false);
    }

    public void w(boolean z3) {
        this.bk = z3;
    }

    public void xv(int i4) {
        this.f49981r = i4;
    }

    public void w(int i4) {
        this.f49983w = i4;
    }

    public long xv(boolean z3) {
        long t3 = t();
        long j4 = this.f49978f;
        long j5 = this.gd;
        long j6 = j4 - (t3 - j5);
        if (!z3 && t3 == j5) {
            j6 = j4 - (t3 - this.xv);
        }
        com.ss.android.socialbase.downloader.xv.c.w("DownloadChunk", "contentLength:" + this.f49978f + " curOffset:" + t() + " oldOffset:" + this.gd + " retainLen:" + j6);
        if (j6 < 0) {
            return 0L;
        }
        return j6;
    }

    public void w(long j4) {
        AtomicLong atomicLong = this.sr;
        if (atomicLong != null) {
            atomicLong.set(j4);
        } else {
            this.sr = new AtomicLong(j4);
        }
    }

    public void c(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.f49977a = 0;
        sQLiteStatement.clearBindings();
        int i4 = this.f49977a + 1;
        this.f49977a = i4;
        sQLiteStatement.bindLong(i4, this.f49983w);
        int i5 = this.f49977a + 1;
        this.f49977a = i5;
        sQLiteStatement.bindLong(i5, this.f49981r);
        int i6 = this.f49977a + 1;
        this.f49977a = i6;
        sQLiteStatement.bindLong(i6, this.xv);
        int i7 = this.f49977a + 1;
        this.f49977a = i7;
        sQLiteStatement.bindLong(i7, t());
        int i8 = this.f49977a + 1;
        this.f49977a = i8;
        sQLiteStatement.bindLong(i8, this.ux);
        int i9 = this.f49977a + 1;
        this.f49977a = i9;
        sQLiteStatement.bindLong(i9, this.f49978f);
        int i10 = this.f49977a + 1;
        this.f49977a = i10;
        sQLiteStatement.bindLong(i10, w());
    }

    public w(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f49983w = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f49981r = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.xv = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.sr = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.sr = new AtomicLong(0L);
        }
        this.ux = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.ev = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.ev = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f49978f = cursor.getLong(columnIndex3);
        }
        this.f49982t = new AtomicBoolean(false);
    }

    public void c(int i4) {
        AtomicInteger atomicInteger = this.ev;
        if (atomicInteger == null) {
            this.ev = new AtomicInteger(i4);
        } else {
            atomicInteger.set(i4);
        }
    }

    public void c(com.ss.android.socialbase.downloader.ev.w wVar) {
        this.ys = wVar;
        s();
    }

    public void c(boolean z3) {
        AtomicBoolean atomicBoolean = this.f49982t;
        if (atomicBoolean == null) {
            this.f49982t = new AtomicBoolean(z3);
        } else {
            atomicBoolean.set(z3);
        }
        this.ys = null;
    }

    protected w(Parcel parcel) {
        this.f49983w = parcel.readInt();
        this.xv = parcel.readLong();
        this.sr = new AtomicLong(parcel.readLong());
        this.ux = parcel.readLong();
        this.f49978f = parcel.readLong();
        this.f49981r = parcel.readInt();
        this.ev = new AtomicInteger(parcel.readInt());
    }

    public void c(w wVar) {
        this.f49979k = wVar;
        if (wVar != null) {
            c(wVar.fz());
        }
    }

    public void c(List<w> list) {
        this.f49980p = list;
    }

    public void c(long j4) {
        this.f49978f = j4;
    }

    public List<w> c(int i4, long j4) {
        w wVar;
        long fp;
        long j5;
        long j6;
        long j7;
        long j8;
        w wVar2 = this;
        int i5 = i4;
        if (!sr() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long bk = bk();
        long xv = wVar2.xv(true);
        long j9 = xv / i5;
        com.ss.android.socialbase.downloader.xv.c.w(f49976c, "retainLen:" + xv + " divideChunkForReuse chunkSize:" + j9 + " current host downloadChunk index:" + wVar2.f49981r);
        int i6 = 0;
        while (i6 < i5) {
            if (i6 == 0) {
                j6 = a();
                j5 = (bk + j9) - 1;
            } else {
                int i7 = i5 - 1;
                if (i6 == i7) {
                    long fp2 = fp();
                    j7 = fp2 > bk ? (fp2 - bk) + 1 : xv - (i7 * j9);
                    j8 = fp2;
                    j6 = bk;
                    long j10 = xv;
                    long j11 = j8;
                    w c4 = new c(wVar2.f49983w).c((-i6) - 1).c(j6).w(bk).ux(bk).xv(j11).sr(j7).c(wVar2).c();
                    com.ss.android.socialbase.downloader.xv.c.w(f49976c, "divide sub chunk : " + i6 + " startOffset:" + j6 + " curOffset:" + bk + " endOffset:" + j11 + " contentLen:" + j7);
                    arrayList.add(c4);
                    bk += j9;
                    i6++;
                    wVar2 = this;
                    i5 = i4;
                    xv = j10;
                } else {
                    j5 = (bk + j9) - 1;
                    j6 = bk;
                }
            }
            j7 = j9;
            j8 = j5;
            long j102 = xv;
            long j112 = j8;
            w c42 = new c(wVar2.f49983w).c((-i6) - 1).c(j6).w(bk).ux(bk).xv(j112).sr(j7).c(wVar2).c();
            com.ss.android.socialbase.downloader.xv.c.w(f49976c, "divide sub chunk : " + i6 + " startOffset:" + j6 + " curOffset:" + bk + " endOffset:" + j112 + " contentLen:" + j7);
            arrayList.add(c42);
            bk += j9;
            i6++;
            wVar2 = this;
            i5 = i4;
            xv = j102;
        }
        long j12 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            w wVar3 = arrayList.get(size);
            if (wVar3 != null) {
                j12 += wVar3.ia();
            }
        }
        com.ss.android.socialbase.downloader.xv.c.w(f49976c, "reuseChunkContentLen:" + j12);
        w wVar4 = arrayList.get(0);
        if (wVar4 != null) {
            if (fp() == 0) {
                fp = j4 - a();
            } else {
                fp = (fp() - a()) + 1;
            }
            wVar4.c(fp - j12);
            wVar = this;
            wVar4.xv(wVar.f49981r);
            com.ss.android.socialbase.downloader.ev.w wVar5 = wVar.ys;
            if (wVar5 != null) {
                wVar5.c(wVar4.fp(), ia() - j12);
            }
        } else {
            wVar = this;
        }
        wVar.c(arrayList);
        return arrayList;
    }
}
