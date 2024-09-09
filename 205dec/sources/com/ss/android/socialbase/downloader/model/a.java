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

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private int f49948a;
    private long bl;

    /* renamed from: h  reason: collision with root package name */
    private int f49949h;

    /* renamed from: j  reason: collision with root package name */
    private int f49950j;

    /* renamed from: k  reason: collision with root package name */
    private List<a> f49951k;
    private long kf;

    /* renamed from: n  reason: collision with root package name */
    private long f49952n;

    /* renamed from: p  reason: collision with root package name */
    private AtomicInteger f49953p;

    /* renamed from: q  reason: collision with root package name */
    private long f49954q;

    /* renamed from: r  reason: collision with root package name */
    private a f49955r;
    private AtomicBoolean rh;

    /* renamed from: s  reason: collision with root package name */
    private AtomicLong f49956s;

    /* renamed from: t  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.p.a f49957t;

    /* renamed from: z  reason: collision with root package name */
    private boolean f49958z;
    private static final String ok = a.class.getSimpleName();
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.ss.android.socialbase.downloader.model.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public a[] newArray(int i4) {
            return new a[i4];
        }
    };

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private long f49959a;
        private long bl;

        /* renamed from: h  reason: collision with root package name */
        private long f49960h;
        private int kf;

        /* renamed from: n  reason: collision with root package name */
        private long f49961n;
        private int ok;

        /* renamed from: p  reason: collision with root package name */
        private a f49962p;

        /* renamed from: s  reason: collision with root package name */
        private long f49963s;

        public ok(int i4) {
            this.ok = i4;
        }

        public ok a(long j4) {
            this.bl = j4;
            return this;
        }

        public ok bl(long j4) {
            this.f49963s = j4;
            return this;
        }

        public ok n(long j4) {
            this.f49960h = j4;
            return this;
        }

        public ok ok(long j4) {
            this.f49959a = j4;
            return this;
        }

        public ok s(long j4) {
            this.f49961n = j4;
            return this;
        }

        public ok ok(int i4) {
            this.kf = i4;
            return this;
        }

        public ok ok(a aVar) {
            this.f49962p = aVar;
            return this;
        }

        public a ok() {
            return new a(this);
        }
    }

    public int a() {
        AtomicInteger atomicInteger = this.f49953p;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public boolean bl() {
        AtomicBoolean atomicBoolean = this.rh;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<a> h() {
        return this.f49951k;
    }

    public long i() {
        return this.f49952n;
    }

    public long j() {
        return this.bl;
    }

    public long k() {
        a aVar = this.f49955r;
        if (aVar != null && aVar.h() != null) {
            int indexOf = this.f49955r.h().indexOf(this);
            boolean z3 = false;
            for (int i4 = 0; i4 < this.f49955r.h().size(); i4++) {
                a aVar2 = this.f49955r.h().get(i4);
                if (aVar2 != null) {
                    if (z3) {
                        return aVar2.rh();
                    }
                    if (indexOf == i4) {
                        z3 = true;
                    }
                }
            }
        }
        return -1L;
    }

    public boolean kf() {
        List<a> list = this.f49951k;
        return list != null && list.size() > 0;
    }

    public a n() {
        a aVar = !s() ? this.f49955r : this;
        if (aVar == null || !aVar.kf()) {
            return null;
        }
        return aVar.h().get(0);
    }

    public ContentValues ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f49948a));
        contentValues.put("chunkIndex", Integer.valueOf(this.f49949h));
        contentValues.put("startOffset", Long.valueOf(this.bl));
        contentValues.put("curOffset", Long.valueOf(rh()));
        contentValues.put("endOffset", Long.valueOf(this.f49952n));
        contentValues.put("chunkContentLen", Long.valueOf(this.kf));
        contentValues.put("hostChunkIndex", Integer.valueOf(a()));
        return contentValues;
    }

    public boolean p() {
        a aVar = this.f49955r;
        if (aVar == null) {
            return true;
        }
        if (aVar.kf()) {
            for (int i4 = 0; i4 < this.f49955r.h().size(); i4++) {
                a aVar2 = this.f49955r.h().get(i4);
                if (aVar2 != null) {
                    int indexOf = this.f49955r.h().indexOf(this);
                    if (indexOf > i4 && !aVar2.q()) {
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

    public boolean q() {
        long j4 = this.bl;
        if (s()) {
            long j5 = this.f49954q;
            if (j5 > this.bl) {
                j4 = j5;
            }
        }
        return rh() - j4 >= this.kf;
    }

    public int r() {
        return this.f49948a;
    }

    public long rh() {
        if (s() && kf()) {
            long j4 = 0;
            for (int i4 = 0; i4 < this.f49951k.size(); i4++) {
                a aVar = this.f49951k.get(i4);
                if (aVar != null) {
                    if (!aVar.q()) {
                        return aVar.z();
                    }
                    if (j4 < aVar.z()) {
                        j4 = aVar.z();
                    }
                }
            }
            return j4;
        }
        return z();
    }

    public boolean s() {
        return a() == -1;
    }

    public long t() {
        long rh = rh() - this.bl;
        if (kf()) {
            rh = 0;
            for (int i4 = 0; i4 < this.f49951k.size(); i4++) {
                a aVar = this.f49951k.get(i4);
                if (aVar != null) {
                    rh += aVar.rh() - aVar.j();
                }
            }
        }
        return rh;
    }

    public void td() {
        this.f49954q = rh();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f49948a);
        parcel.writeLong(this.bl);
        AtomicLong atomicLong = this.f49956s;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f49952n);
        parcel.writeLong(this.kf);
        parcel.writeInt(this.f49949h);
        AtomicInteger atomicInteger = this.f49953p;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public long x() {
        return this.kf;
    }

    public long z() {
        AtomicLong atomicLong = this.f49956s;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int zz() {
        return this.f49949h;
    }

    private a(ok okVar) {
        if (okVar == null) {
            return;
        }
        this.f49948a = okVar.ok;
        this.bl = okVar.f49959a;
        this.f49956s = new AtomicLong(okVar.bl);
        this.f49952n = okVar.f49963s;
        this.kf = okVar.f49961n;
        this.f49949h = okVar.kf;
        this.f49954q = okVar.f49960h;
        this.f49953p = new AtomicInteger(-1);
        ok(okVar.f49962p);
        this.rh = new AtomicBoolean(false);
    }

    public void a(boolean z3) {
        this.f49958z = z3;
    }

    public void bl(int i4) {
        this.f49949h = i4;
    }

    public void a(int i4) {
        this.f49948a = i4;
    }

    public long bl(boolean z3) {
        long rh = rh();
        long j4 = this.kf;
        long j5 = this.f49954q;
        long j6 = j4 - (rh - j5);
        if (!z3 && rh == j5) {
            j6 = j4 - (rh - this.bl);
        }
        com.ss.android.socialbase.downloader.bl.ok.a("DownloadChunk", "contentLength:" + this.kf + " curOffset:" + rh() + " oldOffset:" + this.f49954q + " retainLen:" + j6);
        if (j6 < 0) {
            return 0L;
        }
        return j6;
    }

    public void a(long j4) {
        AtomicLong atomicLong = this.f49956s;
        if (atomicLong != null) {
            atomicLong.set(j4);
        } else {
            this.f49956s = new AtomicLong(j4);
        }
    }

    public void ok(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.f49950j = 0;
        sQLiteStatement.clearBindings();
        int i4 = this.f49950j + 1;
        this.f49950j = i4;
        sQLiteStatement.bindLong(i4, this.f49948a);
        int i5 = this.f49950j + 1;
        this.f49950j = i5;
        sQLiteStatement.bindLong(i5, this.f49949h);
        int i6 = this.f49950j + 1;
        this.f49950j = i6;
        sQLiteStatement.bindLong(i6, this.bl);
        int i7 = this.f49950j + 1;
        this.f49950j = i7;
        sQLiteStatement.bindLong(i7, rh());
        int i8 = this.f49950j + 1;
        this.f49950j = i8;
        sQLiteStatement.bindLong(i8, this.f49952n);
        int i9 = this.f49950j + 1;
        this.f49950j = i9;
        sQLiteStatement.bindLong(i9, this.kf);
        int i10 = this.f49950j + 1;
        this.f49950j = i10;
        sQLiteStatement.bindLong(i10, a());
    }

    public a(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f49948a = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f49949h = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.bl = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f49956s = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f49956s = new AtomicLong(0L);
        }
        this.f49952n = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f49953p = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f49953p = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.kf = cursor.getLong(columnIndex3);
        }
        this.rh = new AtomicBoolean(false);
    }

    public void ok(int i4) {
        AtomicInteger atomicInteger = this.f49953p;
        if (atomicInteger == null) {
            this.f49953p = new AtomicInteger(i4);
        } else {
            atomicInteger.set(i4);
        }
    }

    public void ok(com.ss.android.socialbase.downloader.p.a aVar) {
        this.f49957t = aVar;
        td();
    }

    public void ok(boolean z3) {
        AtomicBoolean atomicBoolean = this.rh;
        if (atomicBoolean == null) {
            this.rh = new AtomicBoolean(z3);
        } else {
            atomicBoolean.set(z3);
        }
        this.f49957t = null;
    }

    protected a(Parcel parcel) {
        this.f49948a = parcel.readInt();
        this.bl = parcel.readLong();
        this.f49956s = new AtomicLong(parcel.readLong());
        this.f49952n = parcel.readLong();
        this.kf = parcel.readLong();
        this.f49949h = parcel.readInt();
        this.f49953p = new AtomicInteger(parcel.readInt());
    }

    public void ok(a aVar) {
        this.f49955r = aVar;
        if (aVar != null) {
            ok(aVar.zz());
        }
    }

    public void ok(List<a> list) {
        this.f49951k = list;
    }

    public void ok(long j4) {
        this.kf = j4;
    }

    public List<a> ok(int i4, long j4) {
        a aVar;
        long i5;
        long j5;
        long j6;
        long j7;
        long j8;
        a aVar2 = this;
        int i6 = i4;
        if (!s() || kf()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long z3 = z();
        long bl = aVar2.bl(true);
        long j9 = bl / i6;
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "retainLen:" + bl + " divideChunkForReuse chunkSize:" + j9 + " current host downloadChunk index:" + aVar2.f49949h);
        int i7 = 0;
        while (i7 < i6) {
            if (i7 == 0) {
                j6 = j();
                j5 = (z3 + j9) - 1;
            } else {
                int i8 = i6 - 1;
                if (i7 == i8) {
                    long i9 = i();
                    j7 = i9 > z3 ? (i9 - z3) + 1 : bl - (i8 * j9);
                    j8 = i9;
                    j6 = z3;
                    long j10 = bl;
                    long j11 = j8;
                    a ok2 = new ok(aVar2.f49948a).ok((-i7) - 1).ok(j6).a(z3).n(z3).bl(j11).s(j7).ok(aVar2).ok();
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, "divide sub chunk : " + i7 + " startOffset:" + j6 + " curOffset:" + z3 + " endOffset:" + j11 + " contentLen:" + j7);
                    arrayList.add(ok2);
                    z3 += j9;
                    i7++;
                    aVar2 = this;
                    i6 = i4;
                    bl = j10;
                } else {
                    j5 = (z3 + j9) - 1;
                    j6 = z3;
                }
            }
            j7 = j9;
            j8 = j5;
            long j102 = bl;
            long j112 = j8;
            a ok22 = new ok(aVar2.f49948a).ok((-i7) - 1).ok(j6).a(z3).n(z3).bl(j112).s(j7).ok(aVar2).ok();
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "divide sub chunk : " + i7 + " startOffset:" + j6 + " curOffset:" + z3 + " endOffset:" + j112 + " contentLen:" + j7);
            arrayList.add(ok22);
            z3 += j9;
            i7++;
            aVar2 = this;
            i6 = i4;
            bl = j102;
        }
        long j12 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            a aVar3 = arrayList.get(size);
            if (aVar3 != null) {
                j12 += aVar3.x();
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "reuseChunkContentLen:" + j12);
        a aVar4 = arrayList.get(0);
        if (aVar4 != null) {
            if (i() == 0) {
                i5 = j4 - j();
            } else {
                i5 = (i() - j()) + 1;
            }
            aVar4.ok(i5 - j12);
            aVar = this;
            aVar4.bl(aVar.f49949h);
            com.ss.android.socialbase.downloader.p.a aVar5 = aVar.f49957t;
            if (aVar5 != null) {
                aVar5.ok(aVar4.i(), x() - j12);
            }
        } else {
            aVar = this;
        }
        aVar.ok(arrayList);
        return arrayList;
    }
}
